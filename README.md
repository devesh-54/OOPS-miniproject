# 🏥 Patient Billing and Pharmacy Management System

## 📘 Overview
The **Patient Billing and Pharmacy Management System** is a Java-based desktop application designed to automate hospital billing and pharmacy operations.  
It integrates patient registration, billing generation, and pharmacy inventory management into a unified system using **JavaFX**, **JDBC**, and **MySQL**.

This project demonstrates the use of **Object-Oriented Programming (OOP)** principles, **database connectivity**, and **GUI design** to create a secure, efficient, and user-friendly healthcare management solution.

---

## 🚀 Features
- 🧾 **Patient Registration:** Allows staff to register patients with essential details such as name, age, gender, and diagnosis.  
- 💊 **Pharmacy Management:** Maintains a list of medicines, their stock levels, and expiry dates.  
- 💰 **Billing System:** Automatically calculates and generates bills based on patient treatments and prescribed medicines.  
- 🧩 **Database Integration:** Stores and retrieves all records from a MySQL database using JDBC.  
- 🖥️ **Graphical Interface:** Provides an intuitive JavaFX-based GUI for smooth interaction.  
- 🔒 **Data Validation:** Ensures accurate entry and prevents duplication or invalid inputs.  
- ⚙️ **Scalable Architecture:** Modular design for future expansion (adding doctors, appointments, or online payments).

---

## 🧱 System Architecture

The system follows a **three-layered architecture**:

1. **Presentation Layer (JavaFX GUI):**  
   Handles user interaction such as adding patients, managing medicines, and generating bills.

2. **Business Logic Layer (Java Classes):**  
   Contains the main application logic — performs billing calculations, stock updates, and validations.

3. **Data Layer (MySQL Database via JDBC):**  
   Manages data persistence for patients, medicines, and billing information.

**Data Flow:**  
`GUI → Business Logic → Database → Business Logic → GUI`

---

## 🧩 Module Distribution

| Module | Concept (Java Unit) | Description |
|:--:|:--|:--|
| **1** | Core Java Fundamentals | Patient Registration – Input validation and record creation. |
| **2** | OOP & Exception Handling | Pharmacy Management – Medicine tracking and error handling. |
| **3** | Multithreading & Generics | Billing Module – Handles multiple billing operations concurrently. |
| **4** | JDBC & Networking | Database Connectivity – Connects Java with MySQL for data storage. |
| **5** | Swing / JavaFX | GUI Module – Provides user-friendly graphical interface for operations. |

---

## 🗃️ Database Design

**Database Name:** `hospitaldb`

### Tables:
1. **patients**
   ```sql
   CREATE TABLE patients (
     patient_id INT AUTO_INCREMENT PRIMARY KEY,
     name VARCHAR(100),
     age INT,
     gender VARCHAR(10),
     diagnosis VARCHAR(200),
     contact VARCHAR(15)
   );
