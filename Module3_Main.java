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

