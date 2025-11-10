package oops;
//File: Module2_Main.java

import java.io.*;

interface DataHandler {
 void saveToFile(String data) throws IOException;
 void readFromFile() throws IOException;
}

class FileManager implements DataHandler {
 private String filename;

 public FileManager(String filename) {
     this.filename = filename;
 }

 @Override
 public void saveToFile(String data) throws IOException {
     try (FileWriter writer = new FileWriter(filename, true)) {
         writer.write(data + "\n");
         System.out.println("Data saved successfully!");
     }
 }

 @Override
 public void readFromFile() throws IOException {
     try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
         String line;
         System.out.println("Reading file contents:");
         while ((line = reader.readLine()) != null) {
             System.out.println(line);
         }
     }
 }
}

public class Module2_Main {
 public static void main(String[] args) {
     FileManager fm = new FileManager("patients.txt");
     try {
         fm.saveToFile("101,Arun,25,Fever");
         fm.readFromFile();
     } catch (IOException e) {
         System.out.println("Error: " + e.getMessage());
     }
 }
}
