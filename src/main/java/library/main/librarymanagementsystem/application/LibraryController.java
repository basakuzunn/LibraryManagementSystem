package library.main.librarymanagementsystem.application;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import library.main.librarymanagementsystem.HelloApplication;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class LibraryController implements Initializable {

    @FXML
    private ListView<String> booksList;

    @FXML
    private TextField author;

    @FXML
    private TextField book;

    @FXML
    private TextField isbn;

    @FXML
    private TextField category;

    @FXML
    private TextField search;

    private String DATA_FILE_ABS_PATH = "C:\\Users\\basak\\OneDrive\\Masaüstü\\bookMnSYS\\LibraryManagementSystem\\src\\main\\data\\books.json";

    private List<JsonNode> bookDataList = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            loadBooks();
        } catch (IOException e) {
            e.printStackTrace();
        }

        booksList.setFixedCellSize(50.0);
    }
    @FXML
    protected void help() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("help.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        // Create a new stage for the help page
        Stage helpStage = new Stage();
        helpStage.initModality(Modality.APPLICATION_MODAL);
        helpStage.setTitle("Help");
        helpStage.setScene(scene);
        helpStage.showAndWait();



    }

    @FXML
    protected void searchBook() throws IOException {

        String search_text = search.getText().strip().toLowerCase();
        loadBooks();
        if (search_text.length() >= 3) {
            ArrayList<String> results = new ArrayList<>();

            for(String book: booksList.getItems()) {
                if (book.toLowerCase().contains(search_text)) results.add(book);
            }

            booksList.getItems().clear();
            if (results.size() > 0) {
                for(String found_book: results) booksList.getItems().add(found_book);
                booksList.refresh();
            }
        }
    }

    @FXML
    protected void editBook() throws IOException {
        ObservableList<Integer> selectedIndices = booksList.getSelectionModel().getSelectedIndices();

        if (selectedIndices.size() == 1) {
            String bookToEdit = booksList.getItems().get(selectedIndices.get(0));
            String oldIsbn = bookToEdit.split(" ")[2];


            EditBook eb = new EditBook();
            String str = eb.getResult();

            if (str != null) {

                JsonNode bookToEditNode = null;
                for (JsonNode book : bookDataList) {
                    if (book.get("isbn").textValue().equals(oldIsbn)) {
                        bookToEditNode = book;
                        break;
                    }
                }

                assert bookToEditNode != null;
                ((ObjectNode)bookToEditNode).put("author", str.split(" ")[0]);
                ((ObjectNode)bookToEditNode).put("title", str.split(" ")[1]);
                ((ObjectNode)bookToEditNode).put("isbn", str.split(" ")[2]);
                ((ObjectNode)bookToEditNode).put("category", str.split(" ")[3]);

                updateDataFile();
                loadBooks();
                search.setText("");
            }
        }
    }

    @FXML
    protected void deleteBook() throws IOException {
        ObservableList<Integer> selectedIndices = booksList.getSelectionModel().getSelectedIndices();

        if (selectedIndices.size() == 1) {
            String bookToEdit = booksList.getItems().get(selectedIndices.get(0));
            String oldIsbn = bookToEdit.split(" ")[2];

            bookDataList.removeIf(book -> book.get("isbn").textValue().equals(oldIsbn));

            updateDataFile();
            loadBooks();
            search.setText("");
        }
    }

    @FXML
    protected void addItem() throws IOException {

        String author_text = author.getText();
        String book_text = book.getText();
        String isbn_text = isbn.getText();
        String category_text = category.getText();

        ObjectMapper mapper = new ObjectMapper();

        ObjectNode newBook = mapper.createObjectNode();
        newBook.put("author", author_text);
        newBook.put("title", book_text);
        newBook.put("isbn", isbn_text);
        newBook.put("category", category_text);

        //String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(newBook);

        bookDataList.add(newBook);

        updateDataFile();

        author.setText("");
        book.setText("");
        isbn.setText("");
        category.setText("");

        this.loadBooks();
    }

    public void loadBooks() throws IOException {
//        Path p = Paths.get("../../data");
//        Objects.requireNonNull(p);
        final File file = new File(DATA_FILE_ABS_PATH);
        List<JsonNode> books = getBooksDataFromFile(file);
        booksList.getItems().clear();
        ObjectMapper mapper = new ObjectMapper();

        for(JsonNode book: books) {
            String bookString = book.get("author") +
                    " " +
                    book.get("title") +
                    " " +
                    book.get("isbn") +
                    " " +
                    book.get("category");

            booksList.getItems().add(bookString.replace("\"", ""));
        }
        booksList.refresh();
    }

    public static void changeScene() throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("library.fxml"));
        Scene scene = new Scene(fxmlLoader.load()); // scene

        Stage stage = HelloApplication.getPrimaryStage();
        stage.hide();
        stage.setTitle("Library Management System");
        stage.setScene(scene);
        stage.show();
    }

    private List<JsonNode> getBooksDataFromFile(final File dataFile) throws IOException {
        if (!bookDataList.isEmpty()) {
            return bookDataList;
        }
        try {
            List<String> read = Files.readAllLines(Paths.get(dataFile.getPath()));
            String jsonString = String.join("", read);
            ObjectMapper mapper = new ObjectMapper();

            JsonNode actualObj = mapper.readTree(jsonString);
            for (JsonNode book : actualObj.get("books")) {
                bookDataList.add(book);
            }
            return bookDataList;
        } catch (IOException e) {
            e.printStackTrace();
            return bookDataList;
        }
    }

    private void updateDataFile() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        mapper.writeValue(out, bookDataList);

        byte[] data = out.toByteArray();
        String newFileContent = "{" +
                "\"books\":" +
                new String(data) +
                "}";


        Path p = Paths.get(DATA_FILE_ABS_PATH);
        File myObj = new File(String.valueOf(p));
        FileWriter myWriter = new FileWriter(myObj);
        myWriter.write(newFileContent);
        myWriter.close();
    }

}
