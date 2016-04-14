package Model;

import javafx.stage.FileChooser;
import javafx.stage.Window;

import java.io.File;

/**
 * Created by Cip on 14-Apr-16.
 */
public class FileChooserFactory {

    public FileChooser getFileSaver() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Function Plots");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("SVG", "*.svg"));
        return fileChooser;
    }

    public FileChooser getFileLoader() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Load Function Plots");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("SVG", "*.svg"));
        return fileChooser;
    }
}
