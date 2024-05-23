# HelloController.java

## Explanation
`HelloController.java` is a JavaFX controller class that handles the interaction between the user interface and the application logic. It is part of a library management system. The main functionality of this class is to change the scene when a start button is clicked.

## Dependencies
- `javafx.fxml.FXML`
- `javafx.scene.control.Label`
- `library.main.librarymanagementsystem.application.LibraryController`
- `java.io.IOException`

## Classes
### HelloController
This class is a JavaFX controller class that handles the interaction between the user interface and the application logic. It has no variables and one method.

#### onStartButtonClick
This method is triggered when the start button is clicked. It changes the scene by calling the `changeScene` method from the `LibraryController` class. It throws an `IOException` if an input or output exception occurred.

| Parameters | Returns |
| --- | --- |
| None | None |

## Example usage
```java
// Create an instance of HelloController
HelloController helloController = new HelloController();

// Call the onStartButtonClick method when the start button is clicked
startButton.setOnAction(e -> {
    try {
        helloController.onStartButtonClick();
    } catch (IOException ex) {
        ex.printStackTrace();
    }
});
```
In this example, an instance of `HelloController` is created. When the start button is clicked, the `onStartButtonClick` method is called. If an `IOException` is thrown, it is caught and the stack trace is printed.