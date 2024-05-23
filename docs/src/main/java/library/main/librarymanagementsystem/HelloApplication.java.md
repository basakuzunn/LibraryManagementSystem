# HelloApplication.java

## Explanation
`HelloApplication.java` is the main entry point for a JavaFX application. It sets up the primary stage (window) of the application, loads the initial scene from an FXML file (`hello-view.fxml`), and displays the stage.

## Dependencies
- `javafx.application.Application`: The base class for all JavaFX applications.
- `javafx.fxml.FXMLLoader`: Loads an object hierarchy from an XML document.
- `javafx.scene.Scene`: Holds all the 2D content that has to be shown in the stage (window).
- `javafx.stage.Stage`: The top level JavaFX container.
- `java.io.IOException`: This exception is thrown when an I/O error occurs.

## Classes
### HelloApplication
This class extends `javafx.application.Application` and overrides the `start` method. It also contains a `main` method to launch the application.

#### getPrimaryStage
This static method returns the primary stage of the application.
- Parameters: None
- Returns: `Stage` - The primary stage of the application.

#### start
This method is called after the `init` method has returned, and after the system is ready for the application to begin running.
- Parameters: `Stage stage` - The primary stage for this application, onto which the application scene can be set.
- Returns: None

#### main
The main entry point for all JavaFX applications. The start method is called after the `init` method has returned, and after the system is ready for the application to begin running.
- Parameters: `String[] args` - The command line arguments passed to the program.
- Returns: None

## Example usage
```java
public class Main {
    public static void main(String[] args) {
        // Launch the JavaFX application
        HelloApplication.launch(args);
    }
}
```
In this example, the `Main` class contains the `main` method which launches the `HelloApplication` JavaFX application.