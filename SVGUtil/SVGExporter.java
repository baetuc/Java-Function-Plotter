package SVGUtil;

import Model.Function;
import org.apache.batik.dom.GenericDOMImplementation;
import org.apache.batik.svggen.SVGGraphics2D;
import org.apache.batik.svggen.SVGGraphics2DIOException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;

import java.awt.*;
import java.io.*;
import java.util.List;

/**
 * Created by Cip on 14-Apr-16.
 */
public class SVGExporter {
    List<Function> functions;
    private final double width;
    private final double height;
    private final double MIN_HORIZONTAL;
    private final double MAX_HORIZONTAL;
    private final double MIN_VERTICAL;
    private final double MAX_VERTICAL;

    public SVGExporter(List<Function> functions, double width, double height, double minH, double maxH,
                       double minV, double maxV) {
        this.functions = functions;
        this.width = width;
        this.height = height;
        this.MIN_HORIZONTAL = minH;
        this.MAX_HORIZONTAL = maxH;
        this.MIN_VERTICAL = minV;
        this.MAX_VERTICAL = maxV;
    }

    public void exportToSVG(File file) {
        // create SVG generator
        DOMImplementation domImplementation = GenericDOMImplementation.getDOMImplementation();
        String svgNS = "http://www.w3.org/2000/svg";
        Document document = domImplementation.createDocument(svgNS, "svg", null);
        SVGGraphics2D svgGenerator = new SVGGraphics2D(document);

        // start to paint the functions
        svgGenerator.setSVGCanvasSize(new Dimension((int) width, (int) height));
        for (Function function : functions) {
            drawFunction(function, svgGenerator);
        }

        Writer out = null;
        try {
            out = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
            svgGenerator.stream(out, false);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }


    }

    private void drawFunction(Function function, SVGGraphics2D graphics) {
        javafx.scene.paint.Color fxColor = function.getColor();
        graphics.setColor(new Color((float) fxColor.getRed(), (float) fxColor.getGreen(), (float) fxColor.getBlue()));
        double currentX = MIN_HORIZONTAL;
        double currentY = function.apply(currentX);
        double smallStep = (MAX_HORIZONTAL - MIN_HORIZONTAL) / width;
        for (double targetX = MIN_HORIZONTAL; targetX <= MAX_HORIZONTAL; targetX += smallStep) {
            try {
                double targetY = function.apply(targetX);
                graphics.drawLine(getRelativeHorizontalForValue(currentX), getRelativeVerticalForValue(currentY),
                        getRelativeHorizontalForValue(targetX), getRelativeVerticalForValue(targetY));
                currentX = targetX;
                currentY = targetY;
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
                exception.printStackTrace();
            }
        }
    }

    private int getRelativeHorizontalForValue(double value) {
        return (int) ((value + MAX_HORIZONTAL) / (MAX_HORIZONTAL - MIN_HORIZONTAL) * width);
    }

    private int getRelativeVerticalForValue(double value) {
        return (int) ((-value + MAX_VERTICAL) / (MAX_VERTICAL - MIN_VERTICAL) * height);
    }

}
