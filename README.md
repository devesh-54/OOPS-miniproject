Expt. No. : 16    PATIENT BILLING AND PHARMACY MANAGEMENT SYSTEM


PO-PSO Mapping Table :

PO1	PO2	PO3	PO4	PO5	PO6	PO7	PO8	PO9	PO10	PO11	PO12	PSO1	PSO2	PSO3
3	2	3	2	3	2	-	3	1	2	-	-	3	2	1

PSO Justification :

PSO	Relevance	Justification
PSO1 – Apply fundamental computing knowledge	3	Applies Java programming, OOP principles, and database integration to automate hospital billing and pharmacy management.
PSO2 – Design and implement solutions	2	Designs modular components such as patient registration, billing generation, and pharmacy inventory management using Java and JDBC.
PSO3 – Use modern tools and technologies	1	Utilizes JavaFX/Swing for GUI and MySQL for backend database management, ensuring efficient and user-friendly operation.
 
PO Justification:



PO	Relevance	Justification
PO1 – Engineering Knowledge	3	Applies Java fundamentals, OOP concepts, and database technologies to develop a fully functional hospital billing and pharmacy system.
PO2 – Problem Analysis	2	Identifies and resolves issues like duplicate entries, incorrect billing, and stock mismatches through structured validation and exception handling.
PO3 – Design/Development of Solutions	3	Designs and integrates billing, patient, and pharmacy modules to ensure accurate data flow and automated processing.
PO4 – Conduct Investigations of Complex Problems	2	Analyzes system workflow, data synchronization, and error scenarios to ensure reliable and consistent hospital operations.
PO5 – Modern Tool Usage	3	Employs Java IDEs (Eclipse/NetBeans), MySQL, and GUI tools such as JavaFX for implementation and visualization.
PO6 – The Engineer and Society	2	Addresses real-world healthcare challenges by providing digital management for billing and pharmacy services.
PO8 – Ethics	3	Ensures ethical data handling by maintaining patient confidentiality and preventing unauthorized access to sensitive medical information.
PO9 – Individual and Team Work	1	Encourages collaborative design and development while supporting individual module contributions.
PO10 – Communication	2	Demonstrates effective documentation and communication through structured project modules and clear code organization.
 
Introduction :

 In modern healthcare, efficient management of patient billing and pharmacy operations is essential for providing accurate, timely, and reliable service. Traditional manual billing processes often result in errors, time delays, and data inconsistencies, making it difficult to track patient information and medicine inventory effectively.
The Patient Billing and Pharmacy Management System is designed to automate these operations using Object-Oriented Programming principles and database management techniques in Java. The system enables hospitals and clinics to maintain patient records, generate accurate bills based on treatments and prescribed medicines, and manage pharmacy stock levels in real time.
This project integrates all core Java concepts — including encapsulation, inheritance, exception handling, multithreading, JDBC connectivity, and GUI design — to create a unified, efficient, and user-friendly application. The use of a centralized database ensures data consistency and prevents duplication, while the graphical interface simplifies the work of billing clerks and pharmacists.
Overall, this system demonstrates the practical implementation of Java programming for healthcare automation, improving workflow, accuracy, and overall patient service quality
	

Project Distribution :

Module Name	Concept (Unit)	Description
1. Patient Registration	Core Java Fundamentals	Handles patient record creation, validation of input details, and unique patient ID generation. Demonstrates class design and encapsulation.
2. Pharmacy Management	OOP & Exception Handling	Manages medicines, tracks stock levels, and handles exceptions such as out-of-stock or expired items. Uses abstraction and inheritance for modular design.
3. Billing System	Multithreading & Generics	Generates patient bills based on treatments and medicines purchased. Employs threads to simulate multiple billing counters running concurrently.
4. Database Connectivity	JDBC & Networking	Connects to MySQL database for storing patient, billing, and medicine data. Demonstrates JDBC driver usage, SQL execution, and error handling.
5. User Interface Module	Swing / JavaFX (GUI)	Provides a graphical user interface for hospital staff to register patients, view stock, and generate bills interactively. Demonstrates MVC and event-driven design.
 

System Architecture :

 
Coding :
Module 1:
package oops;

abstract class Person {
 protected String name;
 protected int age;

 public Person(String name, int age) {
     this.name = name;
     this.age = age;
 }

 abstract void displayDetails();
}

class Patient extends Person {
 private int patientId;
 private String diagnosis;

 public Patient(int patientId, String name, int age, String diagnosis) {
     super(name, age);
     this.patientId = patientId;
     this.diagnosis = diagnosis;
 }

 @Override
 void displayDetails() {
     System.out.println("Patient ID: " + patientId + ", Name: " + name + ", Diagnosis: " + diagnosis);
 }
}

class Doctor extends Person {
 private String specialization;

 public Doctor(String name, int age, String specialization) {
     super(name, age);
     this.specialization = specialization;
 }

 @Override
 void displayDetails() {
     System.out.println("Doctor Name: " + name + ", Specialization: " + specialization);
 }
}

class Bill {
 private static int billCount = 0;
 private int billNo;
 private double amount;

 public Bill(double amount) {
     this.amount = amount;
     billNo = ++billCount;
 }

 public void showBill() {
     System.out.println("Bill No: " + billNo + " | Amount: ₹" + amount);
 }

 @Override
 protected void finalize() {
     System.out.println("Bill object is destroyed.");
 }
}

public class Module1_Main {
 public static void main(String[] args) {
     Patient p1 = new Patient(101, "Arun", 25, "Fever");
     Doctor d1 = new Doctor("Dr. Kumar", 45, "Physician");
     Bill b1 = new Bill(1500.50);

     p1.displayDetails();
     d1.displayDetails();
     b1.showBill();
 }
}

MODULE 2:
package oops;
//File: Module2_Main.java
package oops;
//File: Module2_Main.java
package oops;

// File: Module2_Main.java

import java.io.*;

/**
 * Interface defining the contract for handling data persistence.
 * Demonstrates Abstraction.
 */
interface DataHandler {
    void saveToFile(String data) throws IOException;
    void readFromFile() throws IOException;
}

/**
 * Concrete implementation of DataHandler, managing file operations.
 * Demonstrates Encapsulation and Polymorphism.
 */
class FileManager implements DataHandler {
    private String filename;

    public FileManager(String filename) {
        this.filename = filename;
    }

    /**
     * Saves data to the file, appending it to existing content.
     */
    @Override
    public void saveToFile(String data) throws IOException {
        
// Use try-with-resources to ensure the FileWriter is closed automatically
       
 try (FileWriter writer = new FileWriter(filename, true)) {
            writer.write(data + "\n");
            System.out.println("Data saved successfully!");
        }
    }

    /**
     * Reads and prints all contents from the file.
     */
    @Override
    public void readFromFile() throws IOException {
        // Use try-with-resources for automatic closure of file resources
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            System.out.println("Rading file contents:");
            while ((line = reader.readLine()) != null) {
                
System.out.println(line);
            }  }
    }
}

/**
 * Main class to execute the file handling demonstration.
 */
public class Module2_Main {
    public static void main(String[] args) {
        FileManager fm = new FileManager("patients.txt");
        
        // Handling potential IO exceptions during file operations
        try {
            fm.saveToFile("101,Arun,25,Fever");
            fm.readFromFile();
        } catch (IOException e) {
            System.out.println("Error: Could not perform file operation.");
            System.out.println("Details: " + e.getMessage());
        }
    } }

MODULE 3:
package oops;

//File: Module3_Main.java


import java.util.*;

class Inventory<T> {
 private List<T> items = Collections.synchronizedList(new ArrayList<>());

 public void addItem(T item) {
     items.add(item);
     System.out.println(item + " added to inventory.");
 }

 public void showItems() {
     System.out.println("Inventory Items:");
     for (T i : items)
         System.out.println("- " + i);
 }
}

class BillingThread extends Thread {
 private double amount;

 public BillingThread(double amount) {
     this.amount = amount;
 }

 public void run() {
     System.out.println("Generating bill... Amount: ₹" + amount);
     try {
         Thread.sleep(1000);
     } catch (InterruptedException e) {
         System.out.println("Billing interrupted!");
     }
     System.out.println("Bill generated successfully!");
 }
}

public class Module3_Main {
 public static void main(String[] args) {
     Inventory<String> medicineInventory = new Inventory<>();
     medicineInventory.addItem("Paracetamol");
     medicineInventory.addItem("Cough Syrup");
     medicineInventory.showItems();

     BillingThread t1 = new BillingThread(250.75);
     
t1.start();
 }
}



MODULE 4:(Backend and Database connection) 
package oops;

import java.sql.*;

public class Module4_Main {
    public static void main(String[] args) {
        // ✅ Step 1: Connection details (edit if needed)
        String url = "jdbc:mysql://127.0.0.1:3306/hospitaldb_mod4";
        String user = "root";         // Your MySQL username
        String pass = "devesh70054";     // Leave empty ("") if MySQL has no password

        try {
            // ✅ Step 2: Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // ✅ Step 3: Establish connection
            Connection con = DriverManager.getConnection(url, user, pass);
            System.out.println("✅ Connected to MySQL Workbench successfully!");

            // ✅ Step 4: Insert new patient record
            String insertQuery = "INSERT INTO patients (name, age, gender, diagnosis, contact) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(insertQuery);
            ps.setString(1, "Anitha Raj");
            ps.setInt(2, 34);
            ps.setString(3, "Female");
               
            ps.setString(4, "Migraine");
            ps.setString(5, "9876543201);
            ps.executeUpdate();
            System.out.println("✅ New patient record inserted successfully!");

            // ✅ Step 5: Retrieve and display all patient records
            String selectQuery = "SELECT * FROM patients";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(selectQuery);

            System.out.println("\n👩‍⚕️ PATIENT DETAILS");
            System.out.println("-----------------------------------");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("patient_id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Age: " + rs.getInt("age"));
                System.out.println("Gender: " + rs.getString("gender"));
                System.out.println("Diagnosis: " + rs.getString("diagnosis"));
                System.out.println("Contact: " + rs.getString("contact"));
                System.out.println("-----------------------------------");
            }

            // ✅ Step 6: Close resources
            rs.close();
            st.close();
            ps.close();
            con.close();
            System.out.println("✅ Connection closed successfully!");

        } catch (ClassNotFoundException e) {
            System.out.println("❌ JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("❌ Database Error:"e.getMessage());
        }
    }
}

MODULE 5(Frontend and User Interface):
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

Database(MySql):

-- Create database
CREATE DATABASE hotel_staff_dc;
USE hotel_staff_dc;

-- Create table
CREATE TABLE staff_schedule (
    staff_id INT PRIMARY KEY,
    staff_name VARCHAR(50),
    role VARCHAR(30),
    shift_date DATE,
    shift_start TIME,
    shift_end TIME
);

-- Insert sample data
INSERT INTO staff_schedule VALUES
(1, 'John', 'Receptionist', '2025-11-08', '08:00:00', '16:00:00'),
(2, 'Maya', 'Chef', '2025-11-08', '10:00:00', '18:00:00'),
(3, 'Ravi', 'Cleaner', '2025-11-08', '06:00:00', '14:00:00');

-- Display schedule
SELECT staff_name, role, shift_date, shift_start, shift_end
FROM staff_schedule
ORDER BY shift_date, shift_start;
GITHUB Link for Full Code :
CODE: https://github.com/devesh-54/OOPS-miniproject
README: https://github.com/Amudieshwar-AG/Java-mini-project/blob/main/README.md

Screenshots :
Frontend Structure :
 
 


Description:

The frontend of the Patient Billing and Pharmacy Management System provides a clean, interactive, and user-friendly graphical interface built using JavaFX. It allows hospital staff to register patients, manage pharmacy inventory, and generate bills with an intuitive and efficient design. The interface is directly connected to the backend through JDBC, ensuring real-time data transfer between the application and the MySQL database.
The system validates user inputs such as patient details, medicine quantities, and billing amounts to ensure data accuracy. It automatically updates the patient records and medicine stock levels in the database after every transaction, maintaining consistency across all modules. The backend logic efficiently handles billing calculations, stock management, and database communication while maintaining data integrity and security.
This architecture ensures smooth interaction between the frontend (JavaFX GUI), backend (Java business logic), and database (MySQL) — providing a seamless, reliable, and secure management experience for hospitals to streamline patient billing and pharmacy operations.
 
Database Structure :

 



Description:
The image above shows the SQL script file (SQLquery.txt) for the Patient Billing and Pharmacy Management System stored in the GitHub repository. This file defines the complete database structure that supports the backend operations of the project.
The script begins by creating a dedicated database named hospitaldb, which serves as the central data repository for all patient, billing, and pharmacy-related information. It then defines key database tables such as patients and medicines. The patients table stores essential patient details including ID, name, age, gender, diagnosis, and contact information, ensuring proper record management. Similarly, the medicines table maintains details about medicine names, IDs, and related attributes for effective pharmacy stock management.
This SQL file provides a strong foundation for the system’s backend by structuring the data into organized tables, enabling efficient storage, retrieval, and manipulation of information. The script ensures data consistency and integrity, making it easier for the Java application to perform operations such as registering patients, updating inventory, and generating bills seamlessly.











Database Storage Image :


     


Description:

The MySQL database acts as the core data storage component of the Patient Billing and Pharmacy Management System. It securely maintains all critical hospital-related information, including patient details, medical diagnoses, billing amounts, and billing dates. When a bill is generated through the JavaFX interface, the backend immediately executes SQL queries to insert or update the corresponding records in the bills table.
This process ensures that every transaction — such as creating a new bill or updating an existing one — is instantly reflected in the database, maintaining consistency and accuracy across the system. The use of JDBC enables seamless communication between the Java application and the MySQL database, allowing real-time storage and retrieval of patient and billing data.
By centralizing all billing information within the MySQL tables, the system guarantees data integrity, persistence, and reliability, ensuring that all patient records and billing details remain up-to-date, traceable, and securely managed throughout hospital operations. 


	 
 
 
Github Pages :




Description:
The screenshot above displays the GitHub repository interface of the Online Voting System (Java Project). The project is neatly organized into five separate module folders — each representing a specific Java unit — along with a detailed README.md file that provides documentation and an architectural overview of the system.

The README is formatted in Markdown and rendered directly on GitHub for clear readability. It includes sections such as Overview, Project Modules, System Architecture, and Database Setup, ensuring that users can easily understand the project’s structure and functionality.
Additionally, the repository contains an architecture-diagram.jpg file, which visually represents the system workflow between the JavaFX frontend, JDBC backend, and the MySQL database. This GitHub setup provides a centralized, accessible, and version-controlled platform for hosting and sharing the complete mini-project publicly.
 
Website Output Pages:
The application showcases a clean and interactive JavaFX graphical interface designed for the Patient Billing and Pharmacy Management System. The interface provides input fields for essential patient details such as Name, Age, Gender, Diagnosis, and Contact Number, allowing hospital staff to quickly enter and store patient information in the database.
When the user fills out all fields and clicks the “Save to Database” button, the system immediately validates the input data and then connects to the MySQL database through JDBC to insert the patient record into the corresponding table. Once the data is successfully stored, the interface displays a confirmation message — “Saved successfully!” — ensuring that the operation was completed correctly.
If the user attempts to save without providing the required details, the system prompts for proper input, maintaining data integrity and preventing errors. This interactive design demonstrates efficient synchronization between the frontend (JavaFX GUI), backend logic (Java code), and the database (MySQL), ensuring a smooth, responsive, and user-friendly experience for managing patient registration and billing operations in a hospital environment.

 
 
 






  

 

Conclusion:
      The Patient Billing and Pharmacy Management System effectively demonstrates how Java’s object-oriented        concepts and database technologies can automate hospital billing and pharmacy operations. The system simplifies complex manual workflows, minimizes calculation errors, and enhances data accuracy through centralized storage and retrieval.
By integrating patient registration, billing, and inventory management into a single interface, it improves coordination between departments and ensures faster service for patients. The application also promotes secure data handling by limiting access to authorized personnel, maintaining the privacy of sensitive medical information.
This project highlights the practical application of Java programming for real-world healthcare solutions, offering an efficient, reliable, and easily extensible system.


Future Work:

•	  Online Payment Integration: Add modules for card or UPI-based payment options.
•	  Automated Inventory Alerts: Notify staff when medicine stock is low or expired.
•	  Report Generation: Enable monthly and yearly reports on patient bills and pharmacy sales.
•	  Cloud Storage Integration: Store patient and billing data securely in a cloud database.
•	  Barcode and QR-Code Integration: Simplify medicine scanning and billing updates.
•	  Mobile App Version: Develop an Android application for doctors and pharmacists.
•	  Role-Based Access: Separate login modules for admin, billing staff, and pharmacy staff.
•	  Advanced Analytics: Include dashboards for financial statistics and stock insights

