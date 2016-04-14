package Model;

import javafx.scene.canvas.Canvas;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.File;

/**
 * Created by Cip on 12-Apr-16.
 */
public class MainPage extends BorderPane {
    Stage stage;
    TopPane topPane;
    GraphicPane graphic;

    public MainPage(Stage stage) {
        this.stage = stage;
        topPane = new TopPane(this);
        graphic = new GraphicPane();
        this.setMinSize(0, 0);
        //graphic.prefHeightProperty().bind(this.heightProperty());
        //graphic.prefWidthProperty().bind(this.widthProperty());
        this.setTop(topPane);
        this.setCenter(graphic);

    }

    void paintGraph(Function function) {
        graphic.paintGraph(function);
    }

    void resetGraph() {
        graphic.resetGraph() ;
    }

    void exportSVGToFile(File file) {
        graphic.exportSVGToFile(file);
    }

    void importSVGFromFile(File file) {
        graphic.importSVGFromFile(file);
    }

}
