package Model;

import javafx.scene.paint.Color;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import org.apache.commons.math3.analysis.polynomials.PolynomialFunctionLagrangeForm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cip on 13-Apr-16.
 */
public class Function {
    private String expression;
    private Color color;
    private Expression functionExpression;

    public Function(String expression, Color color) {
        this.expression = expression;
        this.color = color;
        functionExpression = new ExpressionBuilder(expression).variables("x").build();
    }

    public String getExpression() {
        return expression;
    }

    public Color getColor() {
        return color;
    }

    public static Function interpolate(List<Point> points) {
        double[] x = new double[points.size()];
        double[] y = new double[points.size()];
        int index = 0;
        for(Point point : points) {
            x[index] = point.getX();
            y[index] = point.getY();
            ++index;
        }
        PolynomialFunctionLagrangeForm polynomial = new PolynomialFunctionLagrangeForm(x, y);
        double[] coefficients = polynomial.getCoefficients();
        StringBuilder sbExpression = new StringBuilder();
        for(int i = 0; i < coefficients.length; ++i) {
            sbExpression.append('(').append(coefficients[i]).append(" x^").append(i).append(')');
            if(i < coefficients.length - 1) {
                sbExpression.append('+');
            }
        }
        return new Function(sbExpression.toString(), Color.BLACK);
    }

    public double apply(double value) {
        functionExpression.setVariable("x", value);
        return functionExpression.evaluate();
    }
}
