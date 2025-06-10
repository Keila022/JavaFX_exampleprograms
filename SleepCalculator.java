package SleepCalculator;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Author: Keila Gonzalez
 * Date: 08/29/2024
 * Instructor: Krishna Nandanoor
 * Class: Java CIT249
 * Purpose of this program: Sleeping Calculator to estimate the amount of time a person has slept in their life.
 */

public class SleepCalculator extends Application {

    @Override
    public void start(Stage stage) {
        // Create labels and text fields
        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();
        Label ageLabel = new Label("Age:");
        TextField ageField = new TextField();
        Label sleepLabel = new Label("Hours of Sleep per Night:");
        TextField sleepField = new TextField();

        // Create labels for output
        Label hoursSleptLabel = new Label("Total Hours Slept:");
        Label daysSleptLabel = new Label("Total Days Slept:");
        Label yearsSleptLabel = new Label("Total Years Slept:");

        // Create buttons
        Button calculateButton = new Button("Calculate");
        Button exitButton = new Button("Exit");

        // Set button actions
        calculateButton.setOnAction(e -> {
            try {
                String name = nameField.getText();
                int age = Integer.parseInt(ageField.getText());
                double hoursPerNight = Double.parseDouble(sleepField.getText());

                double totalHours = age * 365 * hoursPerNight;
                double totalDays = totalHours / 24;
                double totalYears = totalDays / 365;
                
                // Round results to two decimal places
                totalHours = Math.round(totalHours * 100.0) / 100.0;
                totalDays = Math.round(totalDays * 100.0) / 100.0;
                totalYears = Math.round(totalYears * 100.0) / 100.0;

                hoursSleptLabel.setText("Total Hours Slept: " + totalHours);
                daysSleptLabel.setText("Total Days Slept: " + totalDays);
                yearsSleptLabel.setText("Total Years Slept: " + totalYears);
            } catch (NumberFormatException ex) {
                // Handle invalid input
                hoursSleptLabel.setText("Invalid input. Please enter numeric values for age and hours of sleep.");
                daysSleptLabel.setText("");
                yearsSleptLabel.setText("");
            }
        });

        exitButton.setOnAction(e -> {
            Platform.exit();
            System.exit(0);
        });

        // Create layout and add components
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setMinSize(400, 300);
        pane.setVgap(10);
        pane.setHgap(10);

        pane.add(nameLabel, 0, 0);
        pane.add(nameField, 1, 0);
        pane.add(ageLabel, 0, 1);
        pane.add(ageField, 1, 1);
        pane.add(sleepLabel, 0, 2);
        pane.add(sleepField, 1, 2);
        pane.add(calculateButton, 0, 3);
        pane.add(exitButton, 1, 3);
        pane.add(hoursSleptLabel, 0, 4, 2, 1);
        pane.add(daysSleptLabel, 0, 5, 2, 1);
        pane.add(yearsSleptLabel, 0, 6, 2, 1);

        // JavaFX must have a Scene (window content) inside a Stage (window)
        Scene scene = new Scene(pane, 400, 300);
        stage.setTitle("Sleep Calculator");
        stage.setScene(scene);

        // Show the Stage (window)
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

