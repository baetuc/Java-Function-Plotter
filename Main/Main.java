package Main;/**
 * Created by Cip on 03-Apr-16.
 */

import Model.MainPage;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Path;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.apache.batik.parser.PathParser;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Scene scene = new Scene(new MainPage(primaryStage), 700, 500);
        primaryStage.setTitle("Hello World Application");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
    /*
private final static double WIDTH = 650;
    private final static double HEIGHT = 500;

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();

        // Parse the SVG Path with Apache Batik and create a Path
        PathParser parser = new PathParser();
        JavaFXPathElementHandler handler = new JavaFXPathElementHandler("track");
        parser.setPathHandler(handler);

        // The short track example
         //parser.parse("M 150 50 L 550,50 A 50 50 0 0 1 600,100 L 600,350 A 50 50 0 0 1 550,400 L 400,400 A 50 50 0 0 1 350,350 L 350,300 A 50 50 0 0 0 300,250 L 250,250 A 50 50 0 0 0 200,300 L 200,450 A 50,50 0 0 1 150,500 A 50 50 0 0 1 100,450 L 100,100 A 50 50 0 0 1 150,50 z");
        // The long track example (Created online with SVG-edit)
        parser.parse("M102,135c0,-1 0.693436,-2.458801 2,-3c0.923882,-0.38269 2,-1 3,-2c1,-1 2,-2 3,-3c1,-1 1.292892,-1.292892 2,-2c0.707108,-0.707108 1.693436,-0.458801 3,-1c0.923882,-0.382683 2.693436,-1.458801 4,-2c2.771637,-1.148048 5.026749,-0.770248 6,-1c2.176254,-0.513741 2.85273,-3.173096 4,-4c1.813995,-1.307449 3.298691,-0.94854 5,-2c1.902115,-1.175568 3.07843,-1.789848 6,-3c2.065857,-0.855705 5,-2 9,-4c2,-1 4.186005,-1.692551 6,-3c1.147263,-0.826904 1.693436,-2.458801 3,-3c1.847763,-0.765366 2.852737,-1.173096 4,-2c1.813995,-1.307449 2.693436,-1.458801 4,-2c1.847763,-0.765366 3.152237,-0.234634 5,-1c1.306564,-0.541199 2.693436,-1.458801 4,-2c0.923874,-0.382683 3.053497,-0.540497 5,-1c2.176254,-0.513741 4.412079,-0.968552 8,-3c2.461304,-1.393562 3,-3 5,-3c0,0 1.076126,0.382683 2,0c1.306564,-0.541199 3,-3 5,-3c1,0 1.173096,-0.85273 2,-2c1.307449,-1.813995 5,-5 10,-8c5,-3 8.769928,-4.54863 13,-6c4.823029,-1.654816 8,-1 11,-1c4,0 7,0 10,0c5,0 9.029205,0.591225 15,0c5.074219,-0.502449 9.920349,-2.167961 14,-4c4.912567,-2.206066 9.076904,-2.731445 13,-4c5.123962,-1.656849 8.927673,-3.231731 15,-5c3.958679,-1.152771 9.016907,-1.903393 15,-3c5.015472,-0.919258 9.878571,-1.493458 13,-2c3.948364,-0.640728 9.038727,0.480545 12,0c3.121429,-0.506542 6.01947,-0.60585 10,-1c5.074219,-0.502445 8,-1 12,-1c5,0 10.012573,-0.645554 15,-1c7.053284,-0.501263 14.009064,-1.929871 22,-3c7.008514,-0.938564 17,-1 25,-2c8,-1 16.946716,-1.498737 24,-2c4.987427,-0.354446 12.023865,-0.422638 19,-1c6.062042,-0.501709 11.029205,-0.408775 17,-1c5.074219,-0.502445 7.925781,-1.497555 13,-2c4.975677,-0.492687 9.925781,-0.497555 15,-1c4.975647,-0.492687 9,0 14,0c4,0 8,0 11,0c4,0 6.076111,-0.382683 7,0c1.30658,0.541195 1,2 1,3c0,1 0,2 0,4c0,1 0,4 0,5c0,2 0,4 0,5c0,1 0,3 0,3c0,1 0.707092,3.292892 0,4c-0.707092,0.707108 -2,1 -3,2c-1,1 -2.292908,1.292892 -3,2c-0.707092,0.707108 -1.705444,1.346191 -4,3c-1.813965,1.307449 -4.042908,1.710213 -5,2c-3.450867,1.04483 -5,3 -7,3c-1,0 -2.152222,0.234634 -4,1c-1.30658,0.541199 -4.015015,0.75563 -6,1c-4.092224,0.503777 -7.022491,1.633453 -10,2c-4.092224,0.503777 -6.647491,1.972511 -11,3c-2.919739,0.689262 -5.878571,1.493462 -9,2c-1.974182,0.320366 -5.038727,0.519455 -8,1c-3.121429,0.506538 -5.038727,0.519455 -8,1c-3.121429,0.506538 -5.925781,1.497551 -11,2c-2.985413,0.295616 -7,1 -11,1c-5,0 -9,0 -13,0c-5,0 -9,0 -14,0c-4,0 -9,0 -14,0c-4,0 -8,0 -12,0c-4,0 -9,0 -12,0c-3,0 -7,0 -10,0c-2,0 -5,0 -7,0c-3,0 -6,0 -9,0c-2,0 -4,0 -7,0c-2,0 -4,0 -6,0c-2,0 -5,1 -8,1c-2,0 -4.934143,1.144295 -7,2c-2.92157,1.210152 -4.852722,1.173096 -6,2c-1.813995,1.307449 -4,3 -6,4c-2,1 -3.486267,1.823746 -4,4c-0.229767,0.973251 -0.540497,2.053505 -1,4c-0.513733,2.176254 -3,4 -3,6c0,2 0,3 0,5c0,2 -1.414215,4.585785 0,6c0.707092,0.707108 2,1 3,1c1,0 2,1 4,1c2,0 4,0 7,0c3,0 6,0 9,0c4,0 8.064575,0.800911 13,0c3.121429,-0.506538 7,-1 11,-1c3,0 8,0 11,0c3,0 6.053497,0.459503 8,0c2.176239,-0.513741 3.823761,-1.486259 6,-2c1.946503,-0.459503 4.963837,-0.115868 8,-1c3.958679,-1.152771 8.041321,-0.847229 12,-2c3.036163,-0.884132 7.022491,-1.633453 10,-2c4.092224,-0.503777 7.037476,-1.389084 12,-2c4.092224,-0.503777 8.064575,-1.199089 13,-2c3.121429,-0.506538 6.925781,-1.497551 12,-2c3.98053,-0.39415 8.037476,-0.389084 13,-1c4.092224,-0.503777 8,-1 13,-1c4,0 7,0 10,0c2,0 5,0 8,0c4,0 7,0 11,0c4,0 7,0 12,0c4,0 9,0 12,0c4,0 8,0 11,0c3,0 6,0 8,0c2,0 4.053528,-0.459503 6,0c2.17627,0.513741 3.186035,0.692551 5,2c1.147278,0.826904 2.418884,0.418861 4,2c1.581116,1.581139 2.692566,3.186005 4,5c1.653809,2.29454 3,3 4,5c1,2 1.292908,2.292892 2,3c0.707092,0.707108 0.458801,0.693436 1,2c0.38269,0.923882 0,2 0,4c0,2 0,3 0,5c0,3 0,5 0,7c0,2 0,2 0,3c0,3 0,5 0,7c0,2 0.765381,5.152237 0,7c-1.082397,2.613129 -4,4 -6,6c-2,2 -4,3 -6,4c-2,1 -4.053528,1.540497 -6,2c-2.17627,0.513748 -3.87854,3.493454 -7,4c-2.961243,0.480545 -7.037476,0.389084 -12,1c-4.092224,0.503769 -8,1 -11,1c-4,0 -9,0 -13,0c-4,0 -9,0 -14,0c-3,0 -7,0 -12,0c-5,0 -9,0 -14,0c-5,0 -9,0 -14,0c-5,0 -11,0 -15,0c-4,0 -9,0 -13,0c-3,0 -6.693451,-0.458801 -8,-1c-1.847748,-0.765366 -4.014984,0.24437 -6,0c-4.092224,-0.503769 -10.980865,-4.122574 -17,-5c-7.977936,-1.162949 -15.044952,-2.266907 -21,-3c-4.092224,-0.503769 -11.176971,-0.345184 -16,-2c-4.230072,-1.45137 -8.925781,-3.497559 -14,-4c-5.970795,-0.591232 -11.037476,-0.389084 -16,-1c-4.092224,-0.503769 -8,-2 -11,-2c-4,0 -8,-1 -13,-1c-3,0 -6.907776,-0.496231 -11,-1c-3.970032,-0.488739 -7.925781,-0.497559 -13,-1c-2.985413,-0.295609 -4.907776,-0.496231 -9,-1c-2.977509,-0.366547 -7,0 -10,0c-3,0 -5,-1 -7,-1c-2,0 -7,0 -10,0c-3,0 -6.702667,1.541367 -10,3c-3.770645,1.668015 -6,2 -9,4c-3,2 -4.186005,3.692551 -6,5c-2.29454,1.653809 -4.877655,4.06601 -6,6c-1.809723,3.118484 -3.486252,4.823746 -4,7c-0.459503,1.946503 -1.346191,3.70546 -3,6c-1.307449,1.813995 -1,4 -1,6c0,0 0,1 0,2c0,1 0,2 0,3c0,2 -0.307449,5.186005 1,7c1.653809,2.29454 3,4 4,6c1,2 2,4 3,5c1,1 1,1 2,1c1,0 1.549149,0.95517 5,2c2.871277,0.869354 6.228363,-0.148056 9,1c1.306564,0.541199 3,1 3,1c1,0 2,0 4,0c1,0 3.06456,0.800919 8,0c3.121445,-0.506546 7,-2 11,-2c4,0 8,-2 13,-2c3,0 6,0 9,0c3,0 7,0 10,0c4,0 7,0 11,0c5,0 11,0 17,0c5,0 10,0 17,0c7,0 13,0 19,0c5,0 12,0 16,0c5,0 8,0 12,0c4,0 8,0 12,0c5,0 11,0 16,0c4,0 8.171631,-1.159134 12,0c3.450836,1.04483 9,3 12,3c3,0 6.071808,0.691238 11,2c3.056335,0.811661 6,2 9,2c3,0 5,0 7,0c2,0 4,0 6,0c3,0 5,0 7,0c2,0 5,0 6,0c2,0 3,0 5,0c2,0 3,0 6,0c2,0 4,0 7,0c2,0 4,0 6,0c1,0 2,0 3,0c2,0 3,0 4,0c1,0 2,0 3,0c2,0 3,0 4,0c1,0 2,0 3,0c3,0 8,0 13,0c4,0 7,0 10,0c2,0 3,1 5,1c1,0 2,0 3,0c1,0 2.076111,0.38269 3,0c1.30658,-0.541199 2,-2 3,-3c1,-1 2.458801,-1.693436 3,-3c0.38269,-0.923874 0.69342,-2.458801 2,-3c0.923889,-0.38269 2.076111,-0.61731 3,-1c1.30658,-0.541199 2.076111,-0.61731 3,-1c1.30658,-0.541199 2,-1 2,-1c1,0 2.486267,0.176254 3,-2c0.229736,-0.973251 1,-1 2,-2c1,-1 2.173096,-1.852737 3,-3c1.307434,-1.813995 0.69342,-3.458801 2,-4c0.923889,-0.38269 1.585815,0.414215 3,-1c0.707092,-0.707108 2.076111,-0.61731 3,-1c1.30658,-0.541199 4,-1 5,-1c1,0 3,0 5,0c1,0 3,0 4,0c2,0 3,0 4,0c1,0 1,1 2,1c1,0 1,1 1,2c0,1 1,3 2,4c1,1 1.458801,2.693436 2,4c0.38269,0.923874 1,1 1,3c0,1 0.292908,1.292892 1,2c0.707092,0.707108 0,1 0,2c0,1 2,1 2,3c0,0 0,1 0,2c0,0 0,1 0,3c0,1 0.707092,2.292892 0,3c-1.414185,1.414215 -1.292908,2.292892 -2,3c-0.707092,0.707108 -1,1 -1,2c0,0 -0.458801,1.693436 -1,3c-0.765381,1.847763 -1,3 -1,5c0,0 0,1 0,4c0,2 0,5 0,8c0,3 0,7 0,11c0,3 0,7 0,9c0,3 0,6 0,8c0,1 0,2 0,3c0,1 0,3 0,5c0,1 0.229736,2.026764 0,3c-0.513733,2.176239 -1.493469,3.878571 -2,7c-0.320374,1.974182 0,5 0,8c0,2 0.148071,4.228363 -1,7c-0.541199,1.306549 -0.61731,3.076111 -1,4c-1.082397,2.613129 -3,3 -3,5c0,1 0.488708,3.029968 0,7c-0.503784,4.092224 -2.1604,6.963287 -3,11c-1.238647,5.955322 -1,8 -1,10c0,2 0,4 0,7c0,2 0.459534,5.053497 0,7c-0.513733,2.176239 -2.144287,5.934143 -3,8c-1.210144,2.92157 -2.486267,6.823761 -3,9c-0.919006,3.893005 0,6 0,8c0,2 0,5 0,7c0,2 0.459534,3.053497 0,5c-0.513733,2.176239 -0.839844,4.012909 -1,5c-0.506531,3.121429 -1,4 -1,6c0,3 -1,4 -1,5c0,2 0.765381,3.152252 0,5c-0.541199,1.306549 -1,3 -1,5c0,1 -0.839844,2.012909 -1,3c-0.506531,3.121429 -0.540466,4.053497 -1,6c-0.513733,2.176239 -2,4 -3,6c-1,2 -2.292908,3.292908 -3,4c-0.707092,0.707092 -1.292908,1.292908 -2,2c-0.707092,0.707092 -2.026733,-0.229767 -3,0c-2.17627,0.513733 -5.228333,1.851959 -8,3c-2.613098,1.082397 -5.07843,2.789856 -8,4c-2.065857,0.855713 -2.69342,1.458801 -4,2c-1.847778,0.765381 -3,0 -4,0c0,0 -1,0 -2,0c-1,0 -1.852722,-1.173096 -3,-2c-1.813965,-1.307465 -2.61731,-2.076111 -3,-3c-0.541199,-1.306549 -2.149353,-1.474274 -3,-2c-1.9021,-1.175568 -2.61731,-4.076111 -3,-5c-0.541199,-1.306549 -2.458801,-1.693451 -3,-3c-0.38269,-0.923889 0,-2 0,-3c0,0 -1,0 -1,-2c0,-1 0,-3 0,-5c0,-2 0,-5 0,-8c0,-3 -0.68927,-7.080261 0,-10c0.513733,-2.176239 1,-5 1,-6c0,-2 0.458801,-3.693451 1,-5c0.765381,-1.847748 0,-3 0,-4c0,-2 -0.48053,-4.038727 0,-7c0.506531,-3.121429 0.679626,-6.025818 1,-8c0.506531,-3.121429 0.540466,-5.053497 1,-7c0.513733,-2.176239 0.234619,-3.152252 1,-5c0.541199,-1.306549 1.917603,-3.386871 3,-6c0.765381,-1.847748 1,-4 1,-7c0,-2 1,-5 1,-7c0,-3 0,-6 0,-8c0,-3 0,-4 0,-5c0,-2 0,-5 0,-9c0,-3 0,-7 0,-10c0,-2 0,-8 0,-11c0,-2 0,-4 0,-7c0,-2 -1,-4 -1,-6c0,-2 -0.61731,-6.076111 -1,-7c-1.082397,-2.613129 -2,-3 -2,-4c0,-1 0,-3 0,-4c0,0 0,-1 0,-2c0,-1 -1,-2 -1,-4c0,-1 -0.458801,-1.693451 -1,-3c-0.38269,-0.923889 -0.839844,-3.012909 -1,-4c-0.506531,-3.121429 -1,-4 -2,-5c-1,-1 -1.61731,-2.076111 -2,-3c-0.541199,-1.306564 -2,-2 -3,-3c-1,-1 -2.386902,-2.917603 -5,-4c-0.923889,-0.38269 -2,0 -4,0c-1,0 -3,0 -5,0c-2,0 -4.053528,-0.459503 -6,0c-2.176239,0.513748 -6.026764,1.770248 -7,2c-2.176239,0.513748 -5,3 -7,5c-2,2 -4.173096,3.852722 -5,5c-1.307465,1.813995 -2.486267,3.823761 -3,6c-0.459503,1.946503 -1,4 -2,6c-1,2 -2.493469,3.878571 -3,7c-0.320374,1.974182 -1.458801,4.693451 -2,6c-0.38269,0.923889 0.765381,3.152252 0,5c-0.541199,1.306549 -1,3 -1,7c0,4 -1.95517,7.549164 -3,11c-1.159149,3.828369 -0.497559,6.925781 -1,12c-0.197083,1.990265 0,4 0,6c0,2 0,4 0,7c0,2 0,5 0,8c0,2 0,5 0,8c0,3 1,5 1,7c0,2 2.458801,3.693451 3,5c0.765381,1.847748 -0.765381,3.152252 0,5c0.541199,1.306549 1,3 1,4c0,2 0,4 0,7c0,1 0,3 0,5c0,2 0,5 0,7c0,2 0,4 0,5c0,2 -0.234619,4.152252 -1,6c-0.541199,1.306549 -0.770233,3.026764 -1,4c-0.513733,2.176239 -1.144287,3.934143 -2,6c-1.210144,2.92157 -1.493469,4.878571 -2,8c-0.320374,1.974182 -1,3 -1,5c0,2 -1.372009,2.385101 -5,5c-2.294525,1.653809 -2.934143,3.144287 -5,4c-2.92157,1.210144 -5.025818,1.679626 -7,2c-3.121429,0.506531 -5.930969,2.237732 -9,3c-5.903381,1.466248 -9.041321,1.847229 -13,3c-3.036163,0.884125 -6.080261,0.31073 -9,1c-2.176239,0.513733 -4,1 -7,1c-2,0 -4,0 -6,0c-3,0 -7,0 -11,0c-4,0 -8,0 -11,0c-3,0 -6,0 -10,0c-4,0 -7,0 -11,0c-3,0 -6,0 -8,0c-2,0 -5,0 -6,0c-2,0 -7,0 -14,0c-9,0 -18,0 -25,0c-10,0 -18,0 -23,0c-7,0 -12,0 -17,0c-5,0 -9,0 -13,0c-5,0 -11,0 -18,0c-6,0 -13,0 -19,0c-5,0 -10,0 -15,0c-6,0 -10,0 -13,0c-3,0 -6,0 -10,0c-3,0 -6,0 -9,0c-3,0 -5,0 -8,0c-4,0 -7,0 -11,0c-5,0 -10,0 -16,0c-5,0 -10.024338,-0.492676 -15,0c-5.074203,0.502441 -10,1 -13,1c-5,0 -8,0 -12,0c-3,0 -6,0 -9,0c-2,0 -4,0 -6,0c-2,0 -6,0 -10,0c-3,0 -8,0 -14,0c-6,0 -10,0 -14,0c-2,0 -4.82375,-1.486267 -7,-2c-1.946499,-0.459503 -3.878555,-1.493469 -7,-2c-1.974174,-0.320374 -4,-1 -5,-1c-1,0 -1,-1 -1,-2c0,-1 -1.103405,-1.906342 -2,-3c-2.285879,-2.78833 -4.418861,-3.418854 -6,-5c-1.581139,-1.581146 -1.418861,-3.418854 -3,-5c-1.581139,-1.581146 -2.458803,-1.693451 -3,-3c-0.382683,-0.923889 0,-2 0,-3c0,-1 0,-3 0,-5c0,-1 0,-2 0,-3c0,0 0,-2 0,-3c0,-1 2,-2 3,-3c1,-1 2.292892,-2.292908 3,-3c0.707108,-0.707092 1.292892,-0.292908 2,-1c1.414213,-1.414215 5.310005,-0.337494 8,-2c1.203003,-0.7435 3,-1 3,-1c1,0 1,-1 3,-1c1,0 3,-1 4,-1c1,0 2,0 3,0c1,0 2,0 4,0c1,0 3,0 7,0c2,0 6,0 9,0c3,0 6,0 9,0c2,0 4,0 8,0c3,0 6.01947,-0.394165 10,0c5.074203,0.502441 10.907784,1.496216 15,2c4.96254,0.610931 11,1 18,1c4,0 9.03746,0.610931 14,0c4.092209,-0.503784 8,-1 10,-1c3,0 5,0 7,0c2,0 4,0 5,0c4,0 6.041321,-0.152771 10,1c3.036163,0.884125 7,1 12,1c3,0 8,0 11,0c1,0 3,0 5,0c1,0 2,0 3,0c1,0 2,0 4,0c2,0 5,0 10,0c5,0 13,0 18,0c7,0 11.051651,-0.640717 15,0c3.121445,0.506531 3.823746,2.486267 6,3c1.946503,0.459503 4,1 7,1c2,0 5.106995,0.919006 9,0c2.176239,-0.513733 3.878571,-1.493469 7,-2c2.961273,-0.48056 5.053497,-0.540497 7,-1c2.176239,-0.513733 6.041321,-1.847229 10,-3c3.036163,-0.884125 5.878571,-2.493469 9,-3c2.961273,-0.48056 6,-1 8,-1c3,0 4,0 5,0c2,0 3,0 4,0c3,0 5,0 8,0c2,0 4,0 7,0c3,0 6,0 8,0c4,0 8.022491,0.366547 11,0c4.092224,-0.503784 8.071808,-0.691254 13,-2c3.056335,-0.811646 5.907776,-1.496216 10,-2c1.985016,-0.244354 5,0 9,0c2,0 5,0 8,0c3,0 5,0 8,0c2,0 5,0 7,0c2,0 4.025818,-0.679626 6,-1c3.121429,-0.506531 5,-2 7,-3c2,-1 3.076111,-1.61731 4,-2c1.306549,-0.541199 2,-2 3,-4c1,-2 3.144287,-3.934143 4,-6c1.210144,-2.92157 3.144287,-5.934143 4,-8c1.210144,-2.92157 2,-6 3,-7c1,-1 1,-2 2,-3c1,-1 1,-2 1,-4c0,-1 -0.320374,-4.025818 0,-6c0.506531,-3.121429 1,-8 1,-12c0,-3 -0.366547,-8.022491 0,-11c0.503784,-4.092224 1.493469,-7.878571 2,-11c0.320374,-1.974182 0,-5 0,-7c0,-3 0,-5 0,-8c0,-3 0,-8 0,-11c0,-3 0.48056,-7.038727 0,-10c-0.506531,-3.121429 -1,-5 -1,-7c0,-3 -0.458801,-3.693451 -1,-5c-0.38269,-0.923889 0.306549,-2.458801 -1,-3c-0.923889,-0.38269 -0.292908,-0.292908 -1,-1c-0.707092,-0.707092 -2,0 -4,0c-1,0 -2,-1 -4,-1c-1,0 -2.149353,-0.474274 -3,-1c-1.9021,-1.175568 -2,-2 -2,-2c-1,0 -1.823761,-0.486252 -4,-1c-0.973236,-0.229752 -3,0 -5,0c-2,0 -3,0 -7,0c-3,0 -7,1 -10,3c-3,2 -7.4505,4.4505 -10,7c-2.5495,2.5495 -3.346191,4.705475 -5,7c-1.307465,1.813995 -0.692535,4.186005 -2,6c-0.826904,1.147278 -0.789856,3.07843 -2,6c-0.855713,2.065857 -1.337494,4.309998 -3,7c-0.7435,1.203003 -1,3 -2,4c-1,1 -1.540497,2.053497 -2,4c-0.513733,2.176239 -1.234619,3.152252 -2,5c-0.541199,1.306549 -0.234619,2.152252 -1,4c-0.541199,1.306549 -2.458801,2.693451 -3,4c-0.38269,0.923889 -0.852722,2.173096 -2,3c-1.813995,1.307465 -3,2 -5,4c-1,1 -2.309998,2.337494 -5,4c-1.203003,0.7435 -1.0979,1.824432 -3,3c-0.850647,0.525726 -2.852722,1.173096 -4,2c-1.813995,1.307465 -4,2 -5,3c-1,1 -2.173096,2.852722 -3,4c-1.307465,1.813995 -2.458801,3.693451 -3,5c-0.38269,0.923889 -0.693451,2.458801 -2,3c-0.923889,0.38269 -2.173096,0.852722 -3,2c-1.307465,1.813995 -2.186005,2.692535 -4,4c-2.294525,1.653809 -3.881531,3.190277 -7,5c-1.93399,1.122345 -3.878571,2.493469 -7,3c-1.974182,0.320374 -5,0 -8,0c-2,0 -5,0 -8,0c-4,0 -7,1 -10,1c-3,0 -5,1 -8,1c-3,0 -5,0 -8,0c-2,0 -4,0 -6,0c-2,0 -5,0 -7,0c-5,0 -8.076904,-0.731445 -12,-2c-5.123947,-1.65686 -9,-3 -12,-4c-3,-1 -4.823746,-2.486267 -7,-3c-1.946503,-0.459503 -5.038742,-0.51944 -8,-1c-3.121445,-0.506531 -6.878555,-1.493469 -10,-2c-3.948349,-0.640717 -8,0 -13,0c-4,0 -7,0 -10,0c-3,0 -5,0 -8,0c-2,0 -5.053497,0.459503 -7,0c-2.176254,-0.513733 -4,-1 -7,-1c-2,0 -4,0 -7,0c-2,0 -5,0 -9,0c-3,0 -6,0 -10,0c-3,0 -8,0 -12,0c-3,0 -5.907791,1.496216 -10,2c-2.977524,0.366547 -5,1 -7,1c-3,0 -5.053505,0.540497 -7,1c-2.176254,0.513733 -3.026749,0.770233 -4,1c-2.176254,0.513733 -4.025826,0.679626 -6,1c-3.121445,0.506531 -5,2 -7,2c-2,0 -4.693436,0.458801 -6,1c-0.923882,0.38269 -3,0 -4,0c-3,0 -5,0 -7,0c-2,0 -3,1 -4,1c-2,0 -3,0 -4,0c-2,0 -3,1 -5,1c-3,0 -4,0 -6,0c-1,0 -3,0 -5,0c-1,0 -2,0 -4,0c-2,0 -5,0 -6,0c-2,0 -3,0 -4,0c-1,0 -2.585785,0.414215 -4,-1c-0.707108,-0.707092 -0.693436,-1.458801 -2,-2c-0.923878,-0.38269 -1,0 -1,-2c0,-2 -1.496225,-4.907776 -2,-9c-0.244366,-1.985016 -0.679636,-5.025818 -1,-7c-0.50654,-3.121429 -0.540495,-5.053497 -1,-7c-0.513742,-2.176239 -1,-4 -1,-6c0,-3 0,-5 0,-8c0,-3 0,-8 0,-11c0,-3 -1.917608,-5.386871 -3,-8c-0.765368,-1.847748 0,-4 0,-5c0,-2 0,-3 0,-5c0,-2 0,-3 0,-4c0,-1 0,-3 0,-5c0,-2 0,-5 0,-7c0,-2 0,-4 0,-5c0,-1 0,-3 0,-4c0,-4 0.733099,-8.044952 0,-14c-0.503775,-4.092209 -1.486258,-8.823746 -2,-11c-0.689259,-2.919754 0.320364,-5.025818 0,-7c-0.50654,-3.121445 -1,-4 -1,-5c0,-2 0,-3 0,-6c0,-1 0,-3 0,-5c0,-2 0,-4 0,-7c0,-1 0,-3 0,-3c0,-1 0,-2 0,-3c0,-2 0.160183,-4.012909 0,-5c-0.50654,-3.121445 -1,-5 -1,-7c0,-5 -0.49346,-7.878555 -1,-11c-0.480547,-2.961258 -0.519453,-6.038742 -1,-9c-0.50654,-3.121445 -0.310741,-6.080246 -1,-9c-0.513742,-2.176254 -1.486257,-5.823746 -2,-8c-0.689259,-2.919754 -0.486257,-4.823746 -1,-7c-0.459506,-1.946503 0,-4 0,-5c0,-2 0,-4 0,-6c0,-1 0,-2 0,-4c0,-1 0,-1 0,-2c0,-1 0.458804,-2.693436 1,-4c0.382684,-0.923882 0.486257,-2.823746 1,-5c0.459505,-1.946495 0,-5 0,-8c0,-2 0,-4 0,-5c0,-1 0,-3 0,-6c0,-3 0.49346,-6.878555 1,-10c0.320364,-1.974174 0,-5 0,-6c0,-2 0,-3 0,-5c0,-2 0,-4 0,-6c0,-2 -1,-4 -1,-5c0,-1 0,-3 0,-4c0,0 0,-1 0,-2c0,-1 0,-2 0,-3c0,-2 1.486258,-3.82375 2,-6c0.689259,-2.919746 1.486258,-5.82375 2,-8c0.459505,-1.946499 0,-5 0,-7c0,-1 0,-3 0,-3c0,-1 0.292892,-1.292892 1,-2c0.707108,-0.707108 0.692549,-1.186007 2,-3c1.653811,-2.294538 3.07612,-2.617317 4,-3c1.306562,-0.541197 2,-1 3,-2c1,-1 1.292892,-1.292892 2,-2c0.707108,-0.707108 1.693436,-0.458803 3,-1c1.847759,-0.765368 3.292892,-0.292892 4,-1c0.707108,-0.707108 1.693436,-1.458803 3,-2c1.847759,-0.765368 2.82375,-0.486258 5,-1c0.973248,-0.229753 4,-1 6,-1c2,0 3.386875,-1.917608 6,-3c1.847759,-0.765367 4.025826,0.320365 6,0c3.121445,-0.50654 5,-1 7,-1c3,0 5,-1 7,-1c2,0 2.693436,-0.458804 4,-1c1.847755,-0.765367 3,0 4,0c1,0 2,0 3,0c2,0 2.85273,0.173095 4,1c1.813995,1.307452 3,1 4,1c1,0 1.152245,0.234633 3,1c1.306564,0.541196 2.026749,0.770247 3,1c2.176254,0.513743 3,3 3,3c1,0 2,1 2,2c0,1 0,1 0,2c0,1 0,2 0,4c0,1 0.458801,2.693438 1,4c0.765366,1.847759 0,3 0,5c0,1 0,3 0,4c0,2 0,4 0,5c0,2 -0.95517,3.549156 -2,7c-0.289787,0.957092 -0.234634,2.152241 -1,4c-0.541199,1.306564 -1.693436,2.458805 -3,3c-0.923882,0.382683 -1.85273,2.173096 -3,3c-1.813995,1.307453 -4.186005,0.692547 -6,2c-1.14727,0.826904 -3.076118,1.617317 -4,2c-1.306564,0.541199 -1.292892,1.292892 -2,2c-1.414215,1.414215 -1.693436,1.458801 -3,2c-0.923882,0.382683 -2.076118,0.617317 -3,1c-1.306564,0.541199 -1.693436,1.458801 -3,2c-0.923882,0.382683 -3,1 -4,2c-1,1 -2,2 -3,3c-1,1 -2,2 -3,3c-2,2 -4.85273,3.173096 -6,4c-1.813992,1.307449 -3,2 -4,2c-1,0 -2.458805,0.693436 -3,2c-0.382683,0.923882 -1.617317,2.076118 -2,3c-0.541195,1.306564 -2.458805,1.693436 -3,3c-0.382683,0.923882 -0.585785,0.585785 -2,2c-0.707108,0.707108 0,2 0,3c0,1 -1,1 -1,2c0,1 0,1 0,2c0,1 0,2 0,3c0,0 0,1 0,2c0,4 -1,6 -1,8c0,2 0,4 0,5c0,2 0,5 0,8c0,1 0,2 0,3c0,2 0,2 0,3c0,2 -0.480545,4.038742 0,7c0.506542,3.121445 2.540493,5.053497 3,7c0.513744,2.176254 1,3 1,4c0,1 0,3 0,4c0,2 0,4 0,6c0,1 0,3 0,4c0,1 1,3 1,5c0,1 0,3 0,5c0,3 0.486256,5.823746 1,8c0.459507,1.946503 1,4 1,6c0,2 1,3 1,5c0,2 -0.765366,3.152237 0,5c0.541195,1.306564 1,2 1,3c0,1 0,4 0,5c0,3 0,5 0,8c0,2 0,5 0,8c0,2 0,4 0,6c0,4 0,6 0,7c0,1 -1.414215,2.585785 0,4c0.707108,0.707108 0.617317,1.076126 1,2c0.541195,1.306564 1.486256,1.823746 2,4c0.459507,1.946503 -0.459507,3.053497 0,5c0.513744,2.176254 1,4 1,6c0,2 0,4 0,5c0,1 0,2 0,4c0,1 0,3 0,4c0,0 0,1 0,2c0,2 0,4 0,7c0,3 0.493458,6.878571 1,10c0.320366,1.974182 0,4 0,5c0,0 1,2 1,3c0,1 1,1 1,2c0,1 1.292892,1.292908 2,2c0.707108,0.707092 0.617317,1.076111 1,2c0.541199,1.306549 3,2 4,2c1,0 2,1 4,1c1,0 2.152245,-0.765381 4,0c1.306564,0.541199 2.025826,0.679626 4,1c3.121445,0.506531 4.934143,1.144287 7,2c2.921562,1.210144 6.078438,0.789856 9,2c2.065857,0.855713 4,2 6,2c2,0 4,0 6,0c2,0 4.053505,0.540497 6,1c2.176254,0.513733 5.934143,1.144287 8,2c2.921562,1.210144 4.878555,1.493469 8,2c1.974182,0.320374 5,0 8,0c2,0 3,0 6,0c1,0 2,0 3,0c1,0 3,0 5,0c2,0 4.038742,0.48056 7,0c3.121445,-0.506531 5.823746,-1.486267 8,-2c1.946503,-0.459503 4,0 6,0c1,0 3,0 4,0c2,0 3,0 5,0c2,0 3,0 6,0c2,0 4,0 7,0c2,0 5,0 8,0c2,0 4,0 7,0c2,0 4,0 8,0c2,0 4,0 6,0c1,0 3,0 4,0c1,0 2,0 3,0c1,0 2,0 4,0c3,0 7,0 11,0c6,0 8,0 11,0c1,0 3,0 4,0c2,0 4,0 7,0c2,0 3,-1 5,-1c1,0 1.823761,-0.486267 4,-1c1.946503,-0.459503 3.053497,-0.540497 5,-1c2.176239,-0.513733 5,-2 7,-2c2,0 3.878571,-1.493469 7,-2c0.987091,-0.160187 2.823761,-0.486267 5,-1c0.973236,-0.229767 2.152252,-0.234619 4,-1c2.613129,-1.082397 3.346191,-2.705475 5,-5c1.307465,-1.813995 3,-3 5,-5c2,-2 3.812653,-4.206818 6,-6c2.78833,-2.285889 6.132019,-3.75531 10,-6c3.118469,-1.809723 4.186005,-3.692535 6,-5c1.147278,-0.826904 1.292908,-1.292908 2,-2c0.707092,-0.707092 2,-1 2,-2c0,-1 0,-2 0,-3c0,-2 0,-4 0,-6c0,-1 0,-2 0,-3c0,-1 0.229767,-2.026764 0,-3c-0.513733,-2.176239 -2.458801,-3.693451 -3,-5c-0.38269,-0.923889 -0.61731,-2.076126 -1,-3c-0.541199,-1.306564 -1.458801,-1.693436 -2,-3c-0.38269,-0.923874 -0.61731,-2.076126 -1,-3c-0.541199,-1.306564 -2,-2 -2,-3c0,-1 -0.585785,-3.585785 -2,-5c-0.707092,-0.707108 -2,-1 -3,-1c-1,0 -2,0 -4,0c-2,0 -5.205261,-1.264908 -9,0c-4.743408,1.581146 -7.21167,3.714127 -10,6c-2.187347,1.793198 -3.878571,3.493454 -7,4c-0.987091,0.160187 -2.292908,0.292892 -3,1c-0.707092,0.707108 -2.186005,0.692551 -4,2c-2.294525,1.653809 -3.852722,4.173096 -5,5c-1.813995,1.307465 -3.418854,2.418854 -5,4c-1.581146,1.581146 -1.852722,3.173096 -3,4c-1.813995,1.307465 -2.796997,2.2565 -4,3c-2.690002,1.662506 -5.309998,1.337494 -8,3c-2.406006,1.487 -4.705475,3.346191 -7,5c-1.813995,1.307465 -3.0979,1.824432 -5,3c-1.701309,1.051453 -2.878555,1.493469 -6,2c-0.987091,0.160187 -1.878555,0.493469 -5,1c-0.987091,0.160187 -2,0 -3,0c-1,0 -1.823746,0.486267 -4,1c-1.946503,0.459503 -4.152237,0.234619 -6,1c-2.613129,1.082397 -5.076126,1.61731 -6,2c-1.306564,0.541199 -3,1 -4,1c-1,0 -2,0 -4,0c-1,0 -2,0 -4,0c-1,0 -3,0 -5,0c-2,0 -3,0 -5,-1c-2,-1 -2.292892,-1.292908 -3,-2c-0.707108,-0.707092 -2.076126,-0.61731 -3,-1c-1.306564,-0.541199 -1.852737,-1.173096 -3,-2c-3.627991,-2.614899 -6.190277,-3.881531 -8,-7c-1.122345,-1.93399 -1.692551,-4.186005 -3,-6c-1.653809,-2.294525 -3,-3 -4,-4c-1,-1 -2,-3 -3,-4c-1,-1 -2,-2 -3,-4c-1,-2 -2.173096,-3.852737 -3,-5c-1.307449,-1.813995 -2.458801,-3.693436 -3,-5c-0.765366,-1.847763 -1.486252,-4.823746 -2,-7c-0.229752,-0.973251 -1,-2 -1,-3c0,-2 -0.61731,-3.076126 -1,-4c-0.541199,-1.306564 -0.292892,-2.292892 -1,-3c-0.707108,-0.707108 -1,-1 -1,-2c0,-2 0,-3 0,-4c0,-1 0,-2 0,-3c0,-1 0,-3 0,-5c0,-3 0.486252,-5.823746 1,-8c0.459503,-1.946503 0.486252,-2.823746 1,-5c0.229752,-0.973251 0,-3 0,-4c0,-1 -0.389359,-3.159271 1,-6c1.584106,-3.238922 3.346191,-5.70546 5,-8c1.307449,-1.813995 1.097885,-4.824432 3,-6c0.850647,-0.525726 1.458801,-0.693436 2,-2c0.38269,-0.923874 1,-1 1,-2c0,-1 0.149353,-0.474274 1,-1c1.902115,-1.175568 1.173096,-2.852737 2,-4c1.307449,-1.813995 2.486252,-2.823746 3,-5c0.229752,-0.973251 0.292892,-1.292892 1,-2c0.707108,-0.707108 -0.229752,-1.026749 0,-2c0.513748,-2.176254 1.458801,-2.693436 2,-4c0.38269,-0.923874 0.234634,-1.152237 1,-3c0.541199,-1.306564 2,-3 3,-3c1,0 1.292892,-0.292892 2,-1c0.707108,-0.707108 0,-2 1,-3c1,-1 3,-2 4,-3c1,-1 1,-2 2,-2c1,0 1,-1 2,-1c1,0 2.458801,0.306564 3,-1c0.38269,-0.923874 2.076126,-1.61731 3,-2c1.306564,-0.541199 2.076126,-1.61731 3,-2c1.306564,-0.541199 1.418854,-2.418854 3,-4c1.581146,-1.581146 3.852737,-1.173096 5,-2c1.813995,-1.307449 3,-1 4,-2c1,-1 1.693436,-1.458801 3,-2c0.923874,-0.382683 2.076126,-0.617317 3,-1c1.306564,-0.541199 1.076126,-0.617317 2,-1c1.306564,-0.541199 2.292892,-1.292892 3,-2c0.707108,-0.707108 1.292892,-1.292892 2,-2c1.414215,-1.414215 2,-2 2,-4c0,-1 0,-1 0,-2c0,-1 0.38269,-1.076118 0,-2c-0.541199,-1.306564 -1.474274,-1.149345 -2,-2c-1.175568,-1.902115 -3,-2 -4,-2c0,0 -1,-1 -2,-1c-1,0 -2,0 -2,0c0,-2 -1,-2 -2,-2c-2,0 -3,0 -4,0c-1,0 -2,0 -3,0c-1,0 -2,0 -2,0c-1,0 -2,0 -3,0c-1,0 -2,0 -3,0c-1,0 -2,0 -3,0c-1,0 -2,2 -3,2c-1,0 -1.693436,1.458801 -3,2c-0.923874,0.382683 -2,1 -3,1c-1,0 -2.026749,-0.229752 -3,0c-2.176254,0.513741 -2,2 -3,2c-2,0 -4.053497,0.540497 -6,1c-2.176254,0.513741 -3.585785,0.585785 -5,2c-0.707108,0.707108 -0.693436,1.458801 -2,2c-0.923874,0.382683 -2.693436,1.458801 -4,2c-1.847763,0.765366 -2.292892,1.292892 -3,2c-0.707108,0.707108 -1.076126,0.617317 -2,1c-1.306564,0.541199 -2,2 -3,3c0,0 0.414215,0.585785 -1,2c-0.707108,0.707108 -1.076126,0.617317 -2,1c-1.306564,0.541199 -1.292892,1.292892 -2,2c-0.707108,0.707108 -1.474274,0.149353 -2,1c-1.175568,1.902115 -2.852737,2.173096 -4,3c-1.813995,1.307449 -2.61731,1.076126 -3,2c-0.541199,1.306564 -1.852737,2.173096 -3,3c-1.813995,1.307449 -2.692551,2.186005 -4,4c-0.826904,1.147263 -2.474274,2.149353 -3,3c-1.175568,1.902115 -3.173096,2.852737 -4,4c-1.307449,1.813995 -1.234634,3.152237 -2,5c-0.541199,1.306564 -1.61731,2.076126 -2,3c-0.541199,1.306564 -1.692551,2.186005 -3,4c-0.826904,1.147263 -2.458801,1.693436 -3,3c-0.382683,0.923874 -1,2 -1,3c0,0 -1,1 -1,2c0,2 0.459503,4.053497 0,6c-0.513741,2.176254 -1,4 -1,6c0,3 0,5 0,7c0,2 0,4 0,6c0,2 0.707108,3.292892 0,4c-0.707108,0.707108 -1,2 -1,3c0,2 0,3 0,4c0,1 0,3 0,4c0,1 0,3 0,4c0,3 0,5 0,8c0,2 0,5 0,7c0,3 0,6 1,8c1,2 2.458801,3.693436 3,5c0.765366,1.847763 0.458801,2.693436 1,4c0.38269,0.923874 0.770248,1.026749 1,2c0.513748,2.176254 1.234634,3.152237 2,5c0.541199,1.306564 2,2 2,3c0,1 0,2 0,3c0,2 0,3 0,4c0,1 0,2 0,3c0,1 0,2 0,3c0,1 -0.234634,1.152252 -1,3c-0.541199,1.306549 -1.292892,1.292908 -2,2c-0.707108,0.707092 -0.097885,1.824432 -2,3c-0.850647,0.525726 -2.292892,-0.707092 -3,0c-0.707108,0.707092 -2.458801,0.693451 -3,2c-0.382683,0.923889 -1,2 -2,2c-1,0 -2,0 -4,0c-2,0 -3,0 -4,0c-2,0 -3.292892,0.707092 -4,0c-0.707108,-0.707092 -1.693436,-2.458801 -3,-3c-0.923882,-0.38269 -2.824432,-0.0979 -4,-2c-0.525734,-0.850647 -0.292892,-1.292908 -1,-2c-1.414215,-1.414215 -2.292892,-0.292908 -3,-1c-0.707108,-0.707092 -1,-1 -1,-2c0,-1 -0.617317,-3.076111 -1,-4c-0.541199,-1.306549 -1.486259,-2.823761 -2,-5c-0.689262,-2.919739 -2.173096,-5.852737 -3,-7c-1.307449,-1.813995 -1.458801,-3.693436 -2,-5c-0.382683,-0.923874 -0.458801,-2.693436 -1,-4c-0.382683,-0.923874 0.707108,-3.292892 0,-4c-0.707108,-0.707108 -1,-1 -1,-2c0,-1 -1.486259,-2.823746 -2,-5c-0.459503,-1.946503 -1.458801,-2.693436 -2,-4c-0.765366,-1.847763 -0.292892,-2.292892 -1,-3c-0.707108,-0.707108 0,-2 0,-2c0,-1 0,-3 0,-4c0,-1 0,-2 0,-2c0,-1 0,-2 0,-4c0,-1 0.707108,-2.292892 0,-3c-0.707108,-0.707108 -0.617317,-1.076126 -1,-2c-0.541199,-1.306564 -0.292892,-3.292892 -1,-4c-0.707108,-0.707108 -0.617317,-1.076126 -1,-2c-0.541199,-1.306564 -0.770248,-2.026749 -1,-3c-0.513741,-2.176254 -2.458801,-2.693436 -3,-4c-0.382683,-0.923874 -0.617317,-2.076126 -1,-3c-0.541199,-1.306564 -1.292892,-1.292892 -2,-2c-0.707108,-0.707108 0,-2 0,-3c0,-1 0,-2 0,-3c0,-1 0,-2 0,-3c0,-2 0,-3 0,-5c0,-2 0,-4 0,-5c0,-3 0,-4 0,-5c0,-1 0,-2 0,-3c0,-1 0,-2 0,-3c0,0 0,-1 0,-2c0,0 0,-1 0,-2c0,-2 0,-3 0,-3c0,-1 0.824432,-1.097885 2,-3c0.525734,-0.850647 0,-3 0,-4c0,-1 1,-1 1,-2c0,-1 1,-2 1,-2c1,-1 1.292892,-1.292892 2,-2c0.707108,-0.707108 1.292892,-1.292892 2,-2c1.414215,-1.414215 2.292892,-1.292892 3,-2c0.707108,-0.707108 0.693436,-1.458801 2,-2c1.847755,-0.765366 2.292892,-0.292892 3,-1c0.707108,-0.707108 1.292892,-1.292892 2,-2c0.707108,-0.707108 2,0 2,0c1,0 2,0 2,0c1,0 2,0 2,0c1,0 2,0 3,1c0,0 1,1 2,1c1,0 1.292892,-0.292892 2,-1c0.707108,-0.707108 1,-1 2,-2l0,0 Z");

        Path path = handler.getPath();
        root.getChildren().add(path);

        // Moving image
        //ImageView alien = new ImageView(new Image("alien.png"));
        //root.getChildren().add(alien);

        // Path Transition
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.seconds(30));
        pathTransition.setPath(path);
        //pathTransition.setNode(alien);
        pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransition.setCycleCount(Timeline.INDEFINITE);
        pathTransition.play();

        primaryStage.setTitle("JavaFX Alien Rallye");
        primaryStage.setScene(new Scene(root, WIDTH, HEIGHT));
        //primaryStage.getScene().getStylesheets().add("alien");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

/*import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.geometry.Insets;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.function.Function;

// Java 8 code
public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage stage) {
        Axes axes = new Axes(
                400, 300,
                -8, 8, 1,
                -6, 6, 1
        );

        Plot plot = new Plot(
                x -> .25 * (x + 4) * (x + 1) * (x - 2),
                -8, 8, 0.1,
                axes
        );

        StackPane layout = new StackPane(
                plot
        );
        layout.setPadding(new Insets(20));
        layout.setStyle("-fx-background-color: rgb(35, 39, 50);");

        stage.setTitle("y = \u00BC(x+4)(x+1)(x-2)");
        stage.setScene(new Scene(layout, Color.rgb(35, 39, 50)));
        stage.show();
    }

    class Axes extends Pane {
        private NumberAxis xAxis;
        private NumberAxis yAxis;

        public Axes(
                int width, int height,
                double xLow, double xHi, double xTickUnit,
                double yLow, double yHi, double yTickUnit
        ) {
            setMinSize(Pane.USE_PREF_SIZE, Pane.USE_PREF_SIZE);
            setPrefSize(width, height);
            setMaxSize(Pane.USE_PREF_SIZE, Pane.USE_PREF_SIZE);

            xAxis = new NumberAxis(xLow, xHi, xTickUnit);
            xAxis.setSide(Side.BOTTOM);
            xAxis.setMinorTickVisible(false);
            xAxis.setPrefWidth();
            xAxis.setLayoutY(height / 2);

            yAxis = new NumberAxis(yLow, yHi, yTickUnit);
            yAxis.setSide(Side.LEFT);
            yAxis.setMinorTickVisible(false);
            yAxis.setPrefHeight(height);
            yAxis.layoutXProperty().bind(
                    Bindings.subtract(
                            (width / 2) + 1,
                            yAxis.widthProperty()
                    )
            );

            getChildren().setAll(xAxis, yAxis);
        }

        public NumberAxis getXAxis() {
            return xAxis;
        }

        public NumberAxis getYAxis() {
            return yAxis;
        }
    }

    class Plot extends Pane {
        public Plot(
                Function<Double, Double> f,
                double xMin, double xMax, double xInc,
                Axes axes
        ) {
            Path path = new Path();
            path.setStroke(Color.ORANGE.deriveColor(0, 1, 1, 0.6));
            path.setStrokeWidth(2);

            path.setClip(
                    new Rectangle(
                            0, 0,
                            axes.getPrefWidth(),
                            axes.getPrefHeight()
                    )
            );

            double x = xMin;
            double y = f.apply(x);

            path.getElements().add(
                    new MoveTo(
                            mapX(x, axes), mapY(y, axes)
                    )
            );

            x += xInc;
            while (x < xMax) {
                y = f.apply(x);

                path.getElements().add(
                        new LineTo(
                                mapX(x, axes), mapY(y, axes)
                        )
                );

                x += xInc;
            }

            setMinSize(Pane.USE_PREF_SIZE, Pane.USE_PREF_SIZE);
            setPrefSize(axes.getPrefWidth(), axes.getPrefHeight());
            setMaxSize(Pane.USE_PREF_SIZE, Pane.USE_PREF_SIZE);

            getChildren().setAll(axes, path);
        }

        private double mapX(double x, Axes axes) {
            double tx = axes.getPrefWidth() / 2;
            double sx = axes.getPrefWidth() /
                    (axes.getXAxis().getUpperBound() -
                            axes.getXAxis().getLowerBound());

            return x * sx + tx;
        }

        private double mapY(double y, Axes axes) {
            double ty = axes.getPrefHeight() / 2;
            double sy = axes.getPrefHeight() /
                    (axes.getYAxis().getUpperBound() -
                            axes.getYAxis().getLowerBound());

            return -y * sy + ty;
        }
    }

}

*/