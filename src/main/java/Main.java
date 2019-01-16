package main.java;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;


public class Main extends Application implements EventHandler {

    private final int width=800,height=500;
    public static final String ResourceLocation = "file:src/main/resources/";

    public static StackPane layout;


    private TextField input;
    private Button format;


    public static void print(String str) { System.out.println(str); }

    public static void main(String[] args) {
        print("Loading all the elements ..");

        print("Done.");



        print("Launching program ..");
        launch(args);
        print("Program closed.");
    }

    @Override
    public void start(Stage window) throws Exception {
        layout = new StackPane();
        Scene scene = new Scene(layout,width,height);

        window.setTitle("Chemistry Solver");
        window.getIcons().add(new Image(ResourceLocation+"logo.jpg"));



        input = new TextField("C6H14 + O2 => CO2 + H2O");
        format = new Button("Format Text");

        input.setAlignment(Pos.CENTER);
        input.setTranslateY((-height*0.5)+input.getHeight()+10);
        format.setTranslateX((-width*0.5)+format.getWidth()+49);
        format.setTranslateY((-height*0.5)+input.getHeight()+37);
        layout.getChildren().add(input);
        layout.getChildren().add(format);







        window.setScene(scene);
        window.setResizable(false);
        window.show();
    }

    @Override
    public void handle(Event event) {


    }
}
