package library.main.librarymanagementsystem.application;

import javafx.geometry.Insets;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.util.Optional;

public class Help {
    private String result;

    public String getResult() {
        return this.result;
    }
    private Label helpLabel;
    public Help() {

        Dialog<String> dialog = new Dialog<>();
        dialog.setTitle("Help");
        dialog.setHeaderText("Help");

        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20,150,10,10));



        dialog.getDialogPane().setContent(grid);


        Optional<String> rslt = dialog.showAndWait();
        this.result = rslt.orElse(null);
    }
}
