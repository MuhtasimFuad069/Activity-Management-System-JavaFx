package com.example.javafxpractice;

//import javafx.application.Application;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Scene;
//import javafx.stage.Stage;
//
//import java.io.IOException;
//
//public class HelloApplication extends Application {
//    @Override
//    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
//        stage.setTitle("Hello!");
//        stage.setScene(scene);
//        stage.show();
//    }
//
//    public static void main(String[] args) {
//        launch();
//    }
//}

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    // Declare a counter variable to track button clicks
    private int clickCount = 0;

    @Override
    public void start(Stage primaryStage) {
        // First Page (Scene 1)

        // Create UI elements for the first page
        Label label = new Label("Hello there!");
        label.setStyle("-fx-font-size: 18px;");  // Make label text larger
        Button clickMeButton = new Button("Click Me");
        clickMeButton.setStyle("-fx-font-size: 16px;");  // Make button text larger
        Button navigateButton = new Button("Go to Next Page");
        navigateButton.setStyle("-fx-font-size: 16px;");  // Make button text larger

        // Create a label to show the click count
        Label clickCountLabel = new Label("Button clicked: 0 times");
        clickCountLabel.setStyle("-fx-font-size: 16px;");  // Make click count label text larger

        // Set click event for the "Click Me" button (updates the counter)
        clickMeButton.setOnAction(event -> {
            clickCount++;  // Increment counter
            clickCountLabel.setText("Button clicked: " + clickCount + " times!"); // Update label with new count
        });

        // Create a VBox layout and add the UI elements for the first page
        VBox vbox1 = new VBox(10, label, clickCountLabel, clickMeButton, navigateButton);
        vbox1.setStyle("-fx-alignment: center;");  // Center the VBox's content horizontally
        vbox1.setSpacing(20); // Set some spacing between elements

        // Create the first scene
        Scene scene1 = new Scene(new StackPane(vbox1), 300, 200);

        // Second Page (Scene 2)

        // Create UI elements for the second page
        Label secondPageLabel = new Label("What's on your mind?");
        secondPageLabel.setStyle("-fx-font-size: 18px;");  // Make label text larger
        Button goBackButton = new Button("Go Back to Previous Page");
        goBackButton.setStyle("-fx-font-size: 16px;");  // Make button text larger

        // Create a ComboBox (like a dropdown) for single selection
        ObservableList<String> options = FXCollections.observableArrayList(
                "Play Video Games :D", "Read Romantic Novels ;-;", "Sleep All Day :/", "Daydream About World Tour -_-");
        ComboBox<String> comboBox = new ComboBox<>(options);
        comboBox.setStyle("-fx-font-size: 16px;");
        comboBox.setPromptText("Select an activity");

        // Create a label to display the selected item below the dropdown
        Label selectedOptionLabel = new Label("No item selected.");
        selectedOptionLabel.setStyle("-fx-font-size: 12px;");  // Set the font size to 12px

        // Handle ComboBox selection change
        comboBox.setOnAction(event -> {
            String selectedItem = comboBox.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                selectedOptionLabel.setText("You selected: " + selectedItem);
            } else {
                selectedOptionLabel.setText("No item selected.");
            }
        });

        // Create a VBox layout for the second page
        VBox vbox2 = new VBox(10, secondPageLabel, comboBox, selectedOptionLabel, goBackButton);
        vbox2.setStyle("-fx-alignment: center;");  // Center the VBox's content
        vbox2.setSpacing(20);

        // Create the second scene
        Scene scene2 = new Scene(new StackPane(vbox2), 300, 200);

        // Set click event for the "Go to Second Page" button (switch to scene 2)
        navigateButton.setOnAction(event -> primaryStage.setScene(scene2));

        // Set click event for the "Go Back" button (switch back to scene 1)
        goBackButton.setOnAction(event -> primaryStage.setScene(scene1));

        // Set the initial scene on the stage
        primaryStage.setTitle("JavaFX Sample Project");
        primaryStage.setScene(scene1);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}






