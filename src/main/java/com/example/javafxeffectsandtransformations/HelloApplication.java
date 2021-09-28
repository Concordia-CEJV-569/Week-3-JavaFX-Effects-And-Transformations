package com.example.javafxeffectsandtransformations;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.FlowPane;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application implements EventHandler {
    private Button rotateButton;
    private Button blurButton;
    private Button scaleButton;

    private Rotate rotate;
    private double angle;

    private BoxBlur boxBlur;
    private double blurVal;

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Life Cycle");

        angle = 0.0;
        blurVal = 1.0;

        rotateButton = new Button("Rotate");
        blurButton = new Button("Blur");
        scaleButton = new Button("Scale");

        rotate = new Rotate();
        boxBlur = new BoxBlur(1.0, 1.0, 1);

        // Register our buttons
        rotateButton.setOnAction(this);
        blurButton.setOnAction(this);
        scaleButton.setOnAction(this);

        Label reflectLabel = new Label("Reflection Adds Visual Sparkle");

        FlowPane rootFlowPane = new FlowPane(15, 15);
        rootFlowPane.setAlignment(Pos.CENTER);

        rootFlowPane.getChildren().addAll(rotateButton, blurButton, scaleButton, reflectLabel);

        Scene scene = new Scene(rootFlowPane, 300, 120);
        stage.setScene(scene);
        stage.show();

        // Setup transformations
        rotateButton.getTransforms().add(rotate);
    }

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void handle(Event event) {
        if (event.getSource().equals(rotateButton)) {
            angle += 15.0;
            rotate.setAngle(angle);
            rotate.setPivotX(rotateButton.getWidth() / 2);
            rotate.setPivotY(rotateButton.getHeight() / 2);
            rotate.setPivotZ(rotateButton.getHeight() / 2);
        } else if (event.getSource().equals(blurButton)) {
            // each time button is pressed, its blur is changed
            if (blurVal == 10.0) {
                blurVal = 1;
                blurButton.setEffect(null);
                blurButton.setText("Blur Off");
            } else {
                blurVal++;
                blurButton.setEffect(boxBlur);
                blurButton.setText("Blur On");
            }
            boxBlur.setWidth(blurVal);
            boxBlur.setHeight(blurVal);
        } else if (event.getSource().equals(scaleButton)) {
            System.out.println("Scale button clicked");
        }
    }
}