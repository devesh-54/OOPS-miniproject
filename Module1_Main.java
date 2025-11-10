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
