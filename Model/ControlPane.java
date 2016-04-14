package Model;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;

import java.io.File;

/**
 * Created by Cip on 12-Apr-16.
 */
public class ControlPane extends FlowPane {
    TopPane topPane;

    private Button graphButton;
    private Button resetButton;
    private ColorPicker colorPicker;
    private Button saveButton;
    private Button loadButton;
    private FileChooserFactory fileChooserFactory;
    //private FileChooserFactory;

    public ControlPane(TopPane topPane) {
        this.topPane = topPane;
        graphButton = new Button("Make graph");
        resetButton = new Button("Reset");
        colorPicker = new ColorPicker(Color.CORAL);
        saveButton = new Button("Save");
        loadButton = new Button("Load");
        fileChooserFactory = new FileChooserFactory();


        this.setPadding(new Insets(15, 12, 15, 12));
        this.setHgap(5);
        this.setVgap(5);
        this.getChildren().add(graphButton);
        this.getChildren().add(resetButton);
        this.getChildren().add(colorPicker);
        this.getChildren().add(saveButton);
        this.getChildren().add(loadButton);

        graphButton.setOnAction(event -> topPane.paintGraph(colorPicker.getValue()));

        resetButton.setOnAction(event -> topPane.resetGraph());

        saveButton.setOnAction(event -> {
            FileChooser fileChooser = fileChooserFactory.getFileSaver();
            File file = fileChooser.showSaveDialog(topPane.mainPage.stage);
            if(file != null) {
                topPane.exportSVGToFile(file);
            }
        });

        loadButton.setOnAction(event -> {
            FileChooser fileChooser = fileChooserFactory.getFileLoader();
            File file = fileChooser.showOpenDialog(topPane.mainPage.stage);
            if(file != null) {
                topPane.importSVGFromFile(file);
            }
        });


    }
}
