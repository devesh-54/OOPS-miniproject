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
            ps.setString(5, "9876543201");
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
            System.out.println("❌ Database Error: " + e.getMessage());
        }
    }
}
