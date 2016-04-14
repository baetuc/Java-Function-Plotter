package Model;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

import java.io.File;

/**
 * Created by Cip on 12-Apr-16.
 */
public class TopPane extends BorderPane {
    MainPage mainPage;
    DataPane dataPane;
    ControlPane controlPane;

    public TopPane(MainPage mainPage) {
        this.mainPage = mainPage;
        dataPane = new DataPane();
        controlPane = new ControlPane(this);

        this.setLeft(dataPane);
        this.setRight(controlPane);
        this.setMinSize(0, 0);
        //this.getChildren().add(dataPane);
        //this.getChildren().add(controlPane);
    }

    void paintGraph(Color color) {
        mainPage.paintGraph(dataPane.getFunction(color));
    }

    void resetGraph() {
        mainPage.resetGraph();
    }

    void exportSVGToFile(File file) {
        mainPage.exportSVGToFile(file);
    }

    void importSVGFromFile(File file) {
        mainPage.importSVGFromFile(file);
    }
}
