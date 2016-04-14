package SVGUtil;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.JPEGTranscoder;
import org.apache.batik.transcoder.image.PNGTranscoder;

import java.awt.image.BufferedImage;
import java.io.*;
import java.net.MalformedURLException;

/**
 * Created by Cip on 14-Apr-16.
 */
public class SVGLoader {
    int width;
    int height;

    public SVGLoader(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Image loadSVG(File file) throws MalformedURLException, FileNotFoundException, TranscoderException {

        BufferedImageTranscoder trans = new BufferedImageTranscoder();
        FileInputStream fileInputStream = new FileInputStream(file);
        TranscoderInput transIn = new TranscoderInput(fileInputStream);

        trans.transcode(transIn, null);
        Image image = SwingFXUtils.toFXImage(trans.getBufferedImage(), null);
        return image;
    }
}
