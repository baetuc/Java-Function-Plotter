package Model;

import javafx.geometry.Insets;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;

/**
 * Created by Cip on 12-Apr-16.
 */
public class DataPane extends FlowPane {
    private Label functionLabel;
    private TextField function;


    public DataPane() {
        functionLabel = new Label();
        functionLabel.setText("f(x): ");
        functionLabel.setStyle("-fx-font-size: 20;");

        function = new TextField();
        function.setMinWidth(300);
        function.setStyle("-fx-font-size: 17;");

        this.setPadding(new Insets(30, 12, 15, 12));
        this.setHgap(5);

        this.getChildren().add(functionLabel);
        this.getChildren().add(function);
    }

    Function getFunction(Color color) {
        return new Function(function.getText(), color);
    }
}
