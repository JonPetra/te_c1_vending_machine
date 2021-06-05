package com.vendingmachine;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

public class VendingMachine {

    public Map<String, Product> getProducts() {
        File inputFile = new File("vendingmachine.csv");
        Map<String, Product> products = new LinkedHashMap<>();

        try (Scanner fileScanner = new Scanner(inputFile)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] lineArray = line.split("\\|", 4);
                Product product = new Product(lineArray[0], lineArray[1], lineArray[2], lineArray[3]);
                products.put(lineArray[0], product);

            }

        } catch (IOException e) {
            System.out.println("Error: Invalid File");
        }
        return products;
    }

    public void addToLog(String logInfo) {

        File log = new File("log.txt");

        try (PrintWriter print = new PrintWriter(new FileWriter(log, true))) {
            print.println(LocalDate.now() + " " + LocalTime.now().withNano(0)+ " " + logInfo);
        } catch (IOException e) {
            System.out.println("Could Not Add To File");
        }
    }
}