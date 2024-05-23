# LibraryController.java

## Explanation
`LibraryController.java` is a JavaFX controller class for a library management system. It provides functionalities such as loading books from a JSON file, searching for a book, editing a book's details, deleting a book, and adding a new book to the library.

## Dependencies
- `com.fasterxml.jackson.databind.JsonNode`
- `com.fasterxml.jackson.databind.ObjectMapper`
- `com.fasterxml.jackson.databind.node.ObjectNode`
- `javafx.collections.ObservableList`
- `javafx.fxml.FXML`
- `javafx.fxml.FXMLLoader`
- `javafx.fxml.Initializable`
- `javafx.scene.Scene`
- `javafx.scene.control.*`
- `javafx.stage.Modality`
- `javafx.stage.Stage`
- `library.main.librarymanagementsystem.HelloApplication`
- `java.io.*`
- `java.net.URL`
- `java.nio.file.Files`
- `java.nio.file.Path`
- `java.nio.file.Paths`
- `java.util.ArrayList`
- `java.util.List`
- `java.util.Objects`
- `java.util.ResourceBundle`

## Classes
### LibraryController
#### initialize
This method is called to initialize a controller after its root element has been completely processed. It loads the books from the JSON file and sets the cell size for the books list.

| Parameters | Returns |
| --- | --- |
| `URL url` (URL), `ResourceBundle resourceBundle` (ResourceBundle) | void |

#### help
This method is used to load the help page in a new stage.

| Parameters | Returns |
| --- | --- |
| None | void |

#### searchBook
This method is used to search for a book in the library. It requires the search text to be at least 3 characters long.

| Parameters | Returns |
| --- | --- |
| None | void |

#### editBook
This method is used to edit the details of a selected book.

| Parameters | Returns |
| --- | --- |
| None | void |

#### deleteBook
This method is used to delete a selected book from the library.

| Parameters | Returns |
| --- | --- |
| None | void |

#### addItem
This method is used to add a new book to the library.

| Parameters | Returns |
| --- | --- |
| None | void |

#### loadBooks
This method is used to load the books from the JSON file and display them in the list view.

| Parameters | Returns |
| --- | --- |
| None | void |

#### changeScene
This method is used to change the scene of the application.

| Parameters | Returns |
| --- | --- |
| None | void |

#### getBooksDataFromFile
This method is used to get the book data from the JSON file.

| Parameters | Returns |
| --- | --- |
| `final File dataFile` (File) | `List<JsonNode>` (List of JsonNode) |

#### updateDataFile
This method is used to update the JSON file with the current book data.

| Parameters | Returns |
| --- | --- |
| None | void |

## Example usage
```java
// Initialize the controller
LibraryController controller = new LibraryController();

// Load the books
controller.loadBooks();

// Search for a book
controller.searchBook();

// Edit a book
controller.editBook();

// Delete a book
controller.deleteBook();

// Add a new book
controller.addItem();

// Change the scene
controller.changeScene();
```