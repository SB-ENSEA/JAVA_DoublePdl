import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import physics.Sim;



public class main extends Application {

    private double[] Simparam=new double[6];

    public static void main(String args[]){}

    public void start(Stage stage){ try {
        BorderPane root = new BorderPane();
        //root.setTop(createToolbar());
        Scene scene = new Scene(root,1500,800);
        stage.setScene(scene);
        stage.setTitle("Double pendulum Visualizer");
        stage.show();
    }
    catch(Exception e) {e.printStackTrace();}
    }
}
