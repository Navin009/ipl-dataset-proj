package com.company;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            File file = new File("/home/navin/Projects/ipl-dataset-proj/src/com/company/dataset/deliveries.csv");
            Scanner scanner = new Scanner(file);
            while (true) {
                System.out.println("1. Show Number of Matches Played per year for all years  in IPL.");
                System.out.println("2. Show Number of matches won of all teams over all the years of IPL.");
                System.out.println("3. For the year 2016 get the extra runs conceded per team.");
                System.out.println("4. For the year 2015 get the top economical bowlers.");
                System.out.println("5. Create your own scenario.");
                System.out.println("6. Exit...");
                System.out.println("Enter your option >> ");

                int option = new Scanner(System.in).nextInt();
                switch (option) {
                    case 1: {
                        Matches matches = new Matches();
                        Map<Integer, Integer> data = matches.matchesPlayed();
                        System.out.println(data);
                        break;
                    }
                    case 2: {
                        Matches matches = new Matches();
                        Map<String, HashMap<Integer, Integer>> won = matches.matchesWon();
                        Iterator<Map.Entry<String, HashMap<Integer, Integer>>> itr = won.entrySet().iterator();
                        while (itr.hasNext()) {
                            System.out.println(itr.next());
                        }
                        break;
                    }
                    case 3:
                        Matches matches = new Matches();
                        Map<String, Integer> extraRuns = matches.extraRuns();
                        System.out.println(extraRuns);
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6: {
                        System.exit(0);
                        break;
                    }
                    default: {
                        System.out.println("Invalid option Enter to Continue...");
                        break;
                    }
                }
                System.in.read();
            }
        } catch (Exception e) {
            System.out.println("Main File, Error Class -> " + e.getClass().getName() + " Message -> " + e.getMessage());
        }
    }
}