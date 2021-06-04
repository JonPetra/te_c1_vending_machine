package com.vendingmachine;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Location {
    public Map<String, Product> getProducts() {

        File inputFile = new File("vendingmachine.csv");
        Map<String, Product> products = new HashMap<>();

        try (Scanner fileScanner = new Scanner(inputFile)) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] lineArray = line.split("\\|", 4);
                Product product = new Product(lineArray[1], lineArray[2], lineArray[3]);
                products.put(lineArray[0], product);
            }
        } catch (IOException e) {
            System.out.println("Error: Invalid File");
        }
        return products;
    }
}