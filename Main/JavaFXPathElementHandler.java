package Main;

/**
 * Created by Cip on 13-Apr-16.
 */

import javafx.scene.shape.*;
import org.apache.batik.parser.ParseException;
import org.apache.batik.parser.PathHandler;

/**
 * @author j.hameister
 * @see PathHandler Interface
 * <p>
 * http://www.w3.org/TR/SVG/paths.html
 */
public class JavaFXPathElementHandler implements PathHandler {

    private Path path = new Path();

    private float lastX = 0;
    private float lastY = 0;

    public JavaFXPathElementHandler(String pathStyling) {
        path.getStyleClass().add(pathStyling);
    }

    @Override
    public void arcAbs(float rx, float ry, float xAxisRotation, boolean largeArcFlag, boolean sweepFlag, float x, float y) throws ParseException {
        lastX = x;
        lastY = y;
        path.getElements().add(new ArcTo(rx, ry, xAxisRotation, x, y, largeArcFlag, sweepFlag));
    }

    @Override
    public void arcRel(float rx, float ry, float xAxisRotation, boolean largeArcFlag, boolean sweepFlag, float x, float y) throws ParseException {
        lastX = x;
        lastY = y;

        path.getElements().add(new ArcTo(rx, ry, xAxisRotation, x, y, largeArcFlag, sweepFlag));
    }

    @Override
    public void closePath() throws ParseException {
        path.getElements().add(new ClosePath());
    }

    @Override
    public void curvetoCubicAbs(float x1, float y1, float x2, float y2, float x, float y) throws ParseException {
        lastX = x;
        lastY = y;

        CubicCurveTo c = new CubicCurveTo(x1, y1, x2, y2, x, y);
        c.setAbsolute(true);
        path.getElements().add(c);
    }

    @Override
    public void curvetoCubicRel(float x1, float y1, float x2, float y2, float x, float y) throws ParseException {
        lastX = x;
        lastY = y;
        CubicCurveTo c = new CubicCurveTo(x1, y1, x2, y2, x, y);
        c.setAbsolute(false);
        path.getElements().add(c);
    }

    @Override
    public void curvetoCubicSmoothAbs(float x2, float y2, float x, float y) throws ParseException {
        throw new ParseException("curvetoCubicSmoothAbs is currently not supported.", null);
    }

    @Override
    public void curvetoCubicSmoothRel(float x2, float y2, float x, float y) throws ParseException {
        throw new ParseException("curvetoCubicSmoothRel is currently not supported.", null);
    }

    @Override
    public void curvetoQuadraticAbs(float x1, float y1, float x, float y) throws ParseException {
        throw new ParseException("curvetoQuadraticAbs is currently not supported.", null);
    }

    @Override
    public void curvetoQuadraticRel(float x1, float y1, float x, float y) throws ParseException {
        throw new ParseException("curvetoQuadraticRel is currently not supported.", null);
    }

    @Override
    public void curvetoQuadraticSmoothAbs(float x, float y) throws ParseException {
        throw new ParseException("curvetoQuadraticSmoothAbs is currently not supported.", null);
    }

    @Override
    public void curvetoQuadraticSmoothRel(float x, float y) throws ParseException {
        throw new ParseException("curvetoQuadraticSmoothRel is currently not supported.", null);
    }

    @Override
    public void endPath() throws ParseException {
    }

    @Override
    public void linetoAbs(float x, float y) throws ParseException {
        lastX = x;
        lastY = y;

        LineTo lineTo = new LineTo(x, y);
        lineTo.setAbsolute(true);
        path.getElements().add(lineTo);
    }

    @Override
    public void linetoHorizontalAbs(float x) throws ParseException {
        lastX = x;
        LineTo lineTo = new LineTo(x, lastX);
        lineTo.setAbsolute(true);
        path.getElements().add(lineTo);
    }

    @Override
    public void linetoHorizontalRel(float x) throws ParseException {
        lastX = x;
        LineTo lineTo = new LineTo(x, lastY);
        lineTo.setAbsolute(false);
        path.getElements().add(lineTo);
    }

    @Override
    public void linetoRel(float x, float y) throws ParseException {
        lastX = x;
        lastY = y;
        LineTo lineTo = new LineTo(x, y);
        lineTo.setAbsolute(false);
        path.getElements().add(lineTo);
    }

    @Override
    public void linetoVerticalAbs(float y) throws ParseException {
        lastY = y;
        LineTo lineTo = new LineTo(lastX, y);
        lineTo.setAbsolute(true);
        path.getElements().add(lineTo);
    }

    @Override
    public void linetoVerticalRel(float y) throws ParseException {
        lastY = y;
        LineTo lineTo = new LineTo(lastX, y);
        lineTo.setAbsolute(false);
        path.getElements().add(lineTo);
    }

    @Override
    public void movetoAbs(float x, float y) throws ParseException {
        lastX = x;
        lastY = y;
        MoveTo moveTo = new MoveTo(x, y);
        moveTo.setAbsolute(true);
        path.getElements().add(moveTo);
    }

    @Override
    public void movetoRel(float x, float y) throws ParseException {
        lastX = x;
        lastY = y;
        MoveTo moveTo = new MoveTo(x, y);
        moveTo.setAbsolute(false);
        path.getElements().add(moveTo);
    }

    @Override
    public void startPath() throws ParseException {
    }

    public Path getPath() {
        return path;
    }

}

