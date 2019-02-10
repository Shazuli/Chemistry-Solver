package main.java;

import javafx.application.Application;
import javafx.event.Event;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import main.java.Objects.Element;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.security.PublicKey;

public class PeriodicTable extends Main {
    private int[] shells = new int[] { 2, 6, 10, 14, 18, 22, 26, 30 };
    private final int width=600,height=350;
    //private StackPane layout;


    public PeriodicTable() {

        Stage window = new Stage();
        layout = new StackPane();
        Scene scene = new Scene(layout,width,height);
        layout = new StackPane();



        window.setTitle("window.Periodic_Table");
        window.setResizable(false);
        window.setScene(scene);

        window.setOnHiding(event -> {
            openPerTab.setDisable(false);
        });


        window.show();
    }


    public int[] getShells() { return this.shells; }
    public int getShell(int index) { return this.shells[index]; }
}
