package oops;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.*;

public class Module5_Main extends Application {

    // Database credentials
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/hospitaldb_mod4";
    private static final String USER = "root";
    private static final String PASS = "devesh70054";

    @Override
    public void start(Stage primaryStage) {
        // UI components
        Label nameLabel = new Label("Patient Name:");
        TextField nameField = new TextField();

        Label ageLabel = new Label("Age:");
        TextField ageField = new TextField();

        Label genderLabel = new Label("Gender:");
        TextField genderField = new TextField();

        Label diagnosisLabel = new Label("Diagnosis:");
        TextField diagnosisField = new TextField();

        Label contactLabel = new Label("Contact:");
        TextField contactField = new TextField();

        Button saveButton = new Button("Save to Database");
        Label statusLabel = new Label();

        // Layout using GridPane
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setVgap(10);
        grid.setHgap(10);

        grid.add(nameLabel, 0, 0);
        grid.add(nameField, 1, 0);
        grid.add(ageLabel, 0, 1);
        grid.add(ageField, 1, 1);
        grid.add(genderLabel, 0, 2);
        grid.add(genderField, 1, 2);
        grid.add(diagnosisLabel, 0, 3);
        grid.add(diagnosisField, 1, 3);
        grid.add(contactLabel, 0, 4);
        grid.add(contactField, 1, 4);
        grid.add(saveButton, 1, 5);
        grid.add(statusLabel, 1, 6);

        // Save button action
        saveButton.setOnAction(e -> {
            String name = nameField.getText();
            String ageText = ageField.getText();
            String gender = genderField.getText();
            String diagnosis = diagnosisField.getText();
            String contact = contactField.getText();

            if (name.isEmpty() || ageText.isEmpty() || gender.isEmpty() || diagnosis.isEmpty() || contact.isEmpty()) {
                statusLabel.setText("⚠️ Please fill all fields!");
                return;
            }

            try {
                int age = Integer.parseInt(ageText);
                savePatientToDatabase(name, age, gender, diagnosis, contact);
                statusLabel.setText("✅ Saved successfully!");
                clearFields(nameField, ageField, genderField, diagnosisField, contactField);
            } catch (NumberFormatException ex) {
                statusLabel.setText("⚠️ Age must be a number!");
            } catch (SQLException ex) {
                statusLabel.setText("❌ Database Error: " + ex.getMessage());
                ex.printStackTrace();
            }
        });

        // Scene setup
        Scene scene = new Scene(grid, 400, 350);
        primaryStage.setTitle("Patient Billing and Pharmacy Management (JavaFX)");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Function to save data into MySQL
    private void savePatientToDatabase(String name, int age, String gender, String diagnosis, String contact) throws SQLException {
        Connection con = DriverManager.getConnection(URL, USER, PASS);
        String query = "INSERT INTO patients (name, age, gender, diagnosis, contact) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, name);
        ps.setInt(2, age);
        ps.setString(3, gender);
        ps.setString(4, diagnosis);
        ps.setString(5, contact);
        ps.executeUpdate();
        con.close();
    }

    // Helper function to clear text fields after saving
    private void clearFields(TextField... fields) {
        for (TextField field : fields) {
            field.clear();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
