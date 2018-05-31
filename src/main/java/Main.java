package main.java;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        /*try {
            DatabaseController dao = new DatabaseController();
            dao.executeAndPrintQuery("select * from item where price < 8");
            dao.close();
        } catch (Exception e) {
            System.err.println(e);
        }*/

        Parent root = FXMLLoader.load(getClass().getResource("tabs.fxml"));
        primaryStage.setTitle("Item Management App");
        primaryStage.setScene(new Scene(root, 640, 480));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
