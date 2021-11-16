package com.company;

import java.io.File;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            File file = new File("/home/navin/Projects/ipl-dataset-proj/src/com/company/dataset/deliveries.csv");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("File not found -> " + e.getMessage());
        }
    }
}