package Model;

import SVGUtil.SVGExporter;
import SVGUtil.SVGLoader;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import org.apache.batik.transcoder.TranscoderException;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Cip on 12-Apr-16.
 */
public class Graphic extends javafx.scene.canvas.Canvas {
    private final double MIN_HORIZONTAL = -30;
    private final double MAX_HORIZONTAL = 30;
    private final double MIN_VERTICAL = -30;
    private final double MAX_VERTICAL = 30;

    private final int HORIZONTAL_RULES = 60;
    private final int VERTICAL_RULES = 60;
    private final int HORIZONTAL_STEP = 5;
    private final int VERTICAL_STEP = 5;

    private GraphicPane graphicPane;
    private List<Function> functions;
    private List<Point> interpolationPoints;
    private Function interpolationFunction;
    private Image loadedPlot;


    public Graphic(GraphicPane graphicPane) {
        super(graphicPane.getWidth(), graphicPane.getHeight());
        this.graphicPane = graphicPane;
        functions = new LinkedList<>();
        interpolationPoints = new LinkedList<>();
        widthProperty().addListener(evt -> redraw());
        heightProperty().addListener((evt -> redraw()));

        this.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            interpolationPoints.add(new Point(getValueFromRelativeHorizontal(event.getX()),
                    getValueFromRelativeVertical(event.getY())));
            // ADD RED POINTS TO INTERPOLATION POINTS, HERE + AT REDRAWAL
            if (interpolationPoints.size() > 1) {
                try {
                    interpolationFunction = Function.interpolate(interpolationPoints);
                    redraw();
                    getGraphicsContext2D().setLineWidth(1.5);
                    drawFunction(interpolationFunction);
                    getGraphicsContext2D().setLineWidth(1);
                } catch (Exception exception) {
                    interpolationPoints.remove(interpolationPoints.size() - 1);

                }
            }
        });
    }


    public void reset() {
        functions.clear();
        interpolationPoints.clear();
        interpolationFunction = null;
        loadedPlot = null;
        GraphicsContext graphics = this.getGraphicsContext2D();
        graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
        drawPlot();
    }

    public void addFunctionAndDraw(Function function) {
        functions.add(function);
        drawFunction(function);
    }

    public void saveSVG(File file) {
        SVGExporter exporter = new SVGExporter(functions, getWidth(), getHeight(), MIN_HORIZONTAL, MAX_HORIZONTAL,
                MIN_VERTICAL, MAX_VERTICAL);
        exporter.exportToSVG(file);
    }

    public void loadSVG(File file) {

        SVGLoader loader = new SVGLoader((int)this.getWidth(), (int)this.getHeight());
        try {
            Image image = loader.loadSVG(file);
            loadedPlot = image;
            redraw();
        } catch (MalformedURLException | FileNotFoundException | TranscoderException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    private void redraw() {
        GraphicsContext graphics = this.getGraphicsContext2D();
        graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
        drawPlot();
        if(loadedPlot != null) {
            graphics.drawImage(loadedPlot, 0, 0, getWidth(), getHeight());
        }
        for (Function function : functions) {
            drawFunction(function);
        }
        if (interpolationFunction != null) {
            drawFunction(interpolationFunction);
        }

    }

    private void drawFunction(Function function) {
        GraphicsContext graphics = this.getGraphicsContext2D();
        graphics.setStroke(function.getColor());
        double currentX = MIN_HORIZONTAL;
        double currentY = function.apply(currentX);
        double smallStep = (MAX_HORIZONTAL - MIN_HORIZONTAL) / getWidth();
        for (double targetX = MIN_HORIZONTAL; targetX <= MAX_HORIZONTAL; targetX += smallStep) {
            try {
                double targetY = function.apply(targetX);
                graphics.strokeLine(getRelativeHorizontalForValue(currentX), getRelativeVerticalForValue(currentY),
                        getRelativeHorizontalForValue(targetX), getRelativeVerticalForValue(targetY));
                currentX = targetX;
                currentY = targetY;
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
                exception.printStackTrace();
            }
        }
    }

    private void drawPlot() {
        GraphicsContext graphics = this.getGraphicsContext2D();
        drawBackground(graphics);
        drawAxes(graphics);
        drawAxesArrows(graphics);
        drawTicks(graphics);
    }

    private void drawBackground(GraphicsContext graphics) {
        graphics.setStroke(Color.rgb(179, 230, 179));
        // draw the horizontal lines
        double step = getHorizontalGridStep(); // we have 60 horizontal lines
        for (int i = 0; i < HORIZONTAL_RULES; ++i) {
            graphics.strokeLine(0, step * i, this.getWidth(), step * i);
        }
        step = this.getVerticalGridStep(); // we have 60 horizontal lines
        for (int i = 0; i < VERTICAL_RULES; ++i) {
            graphics.strokeLine(step * i, 0, step * i, this.getHeight());
        }
    }

    private void drawAxesArrows(GraphicsContext graphics) {
        // draw the Ox arrow
        double endPointX = this.getWidth() * (HORIZONTAL_RULES - 1) / HORIZONTAL_RULES;
        double endPointY = getHorizontalMiddle() - (1.0 / VERTICAL_RULES) * this.getHeight();
        graphics.strokeLine(this.getWidth(), getHorizontalMiddle(), endPointX, endPointY);
        // the other part is symmetric
        endPointY = getHorizontalMiddle() + (1.0 / VERTICAL_RULES) * this.getHeight();
        graphics.strokeLine(this.getWidth(), getHorizontalMiddle(), endPointX, endPointY);
        graphics.strokeText("X", endPointX, endPointY + 20);


        // draw the Oy arrow
        endPointX = getVerticalMiddle() * (HORIZONTAL_RULES - 1) / HORIZONTAL_RULES;
        endPointY = this.getHeight() / VERTICAL_RULES;
        graphics.strokeLine(getVerticalMiddle(), 0, endPointX, endPointY);
        endPointX = getVerticalMiddle() * (HORIZONTAL_RULES + 1) / HORIZONTAL_RULES;
        graphics.strokeLine(getVerticalMiddle(), 0, endPointX, endPointY);
        graphics.strokeText("Y", endPointX + 20, endPointY + 5);
    }

    private void drawTicks(GraphicsContext graphics) {
        graphics.setStroke(Color.BLACK);
        double tickHalfLength = getVerticalGridStep() / 4;
        // draw the horizontal lines
        double step = getHorizontalGridStep() * VERTICAL_STEP; // we have HORIZONTAL_RULES / VERTICAL_STEP ticks on Oy
        for (int i = 1; i < HORIZONTAL_RULES / VERTICAL_STEP; ++i) {
            graphics.strokeLine(getVerticalMiddle() - tickHalfLength, step * i,
                    getVerticalMiddle() + tickHalfLength, step * i);

        }
        step = getVerticalGridStep() * HORIZONTAL_STEP; // we have VERTICAL_RULES / HORIZONTAL_STEP ticks on Ox
        for (int i = 0; i < VERTICAL_RULES / HORIZONTAL_STEP; ++i) {
            graphics.strokeLine(step * i, getHorizontalMiddle() - tickHalfLength,
                    step * i, getHorizontalMiddle() + tickHalfLength);
        }

        for (int x = (int) MIN_HORIZONTAL + 5; x < MAX_HORIZONTAL; x += HORIZONTAL_STEP) {
            if (x != 0) {
                graphics.strokeText(String.valueOf(x), getRelativeHorizontalForValue(x),
                        getRelativeVerticalForValue(-2.5));
            }
        }
        for (int y = (int) MIN_VERTICAL + 5; y < MAX_VERTICAL; y += VERTICAL_STEP) {
            if (y != 0) {
                graphics.strokeText(String.valueOf(y), getRelativeHorizontalForValue(.5),
                        getRelativeVerticalForValue(y - 0.5));
            }
        }

    }

    private void drawAxes(GraphicsContext graphics) {
        graphics.setStroke(Color.BLACK);
        graphics.strokeLine(0, getHorizontalMiddle(), this.getWidth(), getHorizontalMiddle());
        graphics.strokeLine(getVerticalMiddle(), 0, getVerticalMiddle(), this.getHeight());
        graphics.strokeText("O", getVerticalMiddle() + getHorizontalGridStep(), getHorizontalMiddle() +
                1.3 * getVerticalGridStep());
    }

    private double getVerticalGridStep() {
        return this.getWidth() / VERTICAL_RULES;
    }

    private double getHorizontalGridStep() {
        return this.getHeight() / HORIZONTAL_RULES;
    }

    private double getHorizontalMiddle() {
        return this.getHeight() / 2;
    }

    private double getVerticalMiddle() {
        return this.getWidth() / 2;
    }

    private double getRelativeHorizontalForValue(double value) {
        return (value + MAX_HORIZONTAL) / (MAX_HORIZONTAL - MIN_HORIZONTAL) * getWidth();
    }

    private double getRelativeVerticalForValue(double value) {
        return (-value + MAX_VERTICAL) / (MAX_VERTICAL - MIN_VERTICAL) * getHeight();
    }

    private double getValueFromRelativeHorizontal(double value) {
        return (MAX_HORIZONTAL - MIN_HORIZONTAL) / getWidth() * value + MIN_HORIZONTAL;
    }


    private double getValueFromRelativeVertical(double value) {
        return -((MAX_VERTICAL - MIN_VERTICAL) / getHeight() * value + MIN_VERTICAL);
    }

    @Override
    public boolean isResizable() {
        return true;
    }

    @Override
    public double prefWidth(double width) {
        return this.getWidth();
    }

    @Override
    public double prefHeight(double height) {
        return this.getHeight();
    }
}
