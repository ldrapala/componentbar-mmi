package byt.money.componentbarmmi.internal.demo;

import byt.money.componentbarmmi.internal.ComponentBarMmi;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Lukasz
 */
public class Main extends Application {
    
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        ComponentBarMmi componentBarMmi = new ComponentBarMmi();
//        componentBarMmi.start();
//        primaryStage.setTitle(addingMmi.getName());
        Scene scene = new Scene(componentBarMmi.getScene(), 200, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
