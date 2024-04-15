package library.main.virtualbookmanager.application;

import javafx.geometry.Insets;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.util.Optional;

public class EditBook {

    private String result;

    public String getResult() {
        return this.result;
    }

    public EditBook() {
        Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("Edit Book");
        dialog.setHeaderText("Edit book");

        ButtonType confirm = new ButtonType("Edit");
        dialog.getDialogPane().getButtonTypes().add(confirm);

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20,150,10,10));

        TextField author = new TextField();
        author.setPromptText("Author");

        TextField title = new TextField();
        title.setPromptText("Title");

        TextField isbn = new TextField();
        isbn.setPromptText("ISBN");

        TextField category = new TextField();
        category.setPromptText("Category");

        TextField edition = new TextField();
        edition.setPromptText("Edition");

        TextField language = new TextField();
        language.setPromptText("Language");

        TextField publisher = new TextField();
        publisher.setPromptText("Publisher");

        TextField date = new TextField();
        date.setPromptText("Date");

        TextField translator = new TextField();
        translator.setPromptText("Translator");

        TextField tags = new TextField();
        tags.setPromptText("Tags");

        TextField rate = new TextField();
        rate.setPromptText("Rate");

        TextField imageurl = new TextField();
        imageurl.setPromptText("Image URL");

        TextField subtitle = new TextField();
        subtitle.setPromptText("Subtitle");

        grid.add(new Label("Author:"), 0, 0);
        grid.add(author, 1, 0);

        grid.add(new Label("Title:"), 0, 1);
        grid.add(title, 1, 1);

        grid.add(new Label("ISBN:"), 0, 2);
        grid.add(isbn, 1, 2);

        grid.add(new Label("Category:"), 0, 3);
        grid.add(category, 1, 3);

        grid.add(new Label("Edition:"), 0, 4);
        grid.add(category, 1, 4);

        grid.add(new Label("Language:"), 0, 5);
        grid.add(language, 1, 5);

        grid.add(new Label("Publisher:"), 0, 6);
        grid.add(publisher, 1, 6);

        grid.add(new Label("Date:"), 0, 7);
        grid.add(date, 1, 7);

        grid.add(new Label("Translator:"), 0, 8);
        grid.add(translator, 1, 8);

        grid.add(new Label("Tags:"), 0, 9);
        grid.add(tags, 1, 9);

        grid.add(new Label("Rate:"), 0, 10);
        grid.add(rate, 1, 10);

        grid.add(new Label("Image URL:"), 0, 11);
        grid.add(imageurl, 1, 11);

        grid.add(new Label("Subtitle:"), 0, 12);
        grid.add(subtitle, 1, 12);

        dialog.getDialogPane().setContent(grid);

        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == confirm) {
                return
                author.getText() + " " +
                title.getText() + " " +
                isbn.getText() + " " +
                category.getText() + " " +
                edition.getText() + " " +
                language.getText() + " " +
                publisher.getText() + " " +
                date.getText() + " " +
                translator.getText() + " " +
                tags.getText() + " " +
                rate.getText() + " " +
                imageurl.getText() + " " +
                subtitle.getText();
            }
            return null;
        });

        Optional<String> rslt = dialog.showAndWait();
        if (rslt.isPresent() ) {
            this.result = rslt.get();
        }
        else this.result = null;
    }
}
