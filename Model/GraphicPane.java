package Model;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

import java.io.File;

/**
 * Created by Cip on 13-Apr-16.
 */
public class GraphicPane extends StackPane {
    Graphic graphic;

    public GraphicPane() {
        graphic = new Graphic(this);
        this.getChildren().add(graphic);

        this.setMinSize(0, 0);
        graphic.widthProperty().bind(this.widthProperty());
        graphic.heightProperty().bind(this.heightProperty());

    }

    void paintGraph(Function function) {
        graphic.addFunctionAndDraw(function);
    }

    void resetGraph() {
        graphic.reset();
    }

    void exportSVGToFile(File file) {
        graphic.saveSVG(file);
    }

    void importSVGFromFile(File file) {
        graphic.loadSVG(file);
    }
}
