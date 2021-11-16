package com.company;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Matches {
    public Map<Integer, Integer> matchesPlayed() {
        Map<Integer, Integer> matches = new TreeMap<>();
        try {
            File file = new File("src/com/company/dataset/matches.csv");
            Scanner scanner = new Scanner(file);
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] lineSplit = line.split(",");
                if (matches.containsKey(Integer.parseInt(lineSplit[1]))) {
                    matches.put(Integer.parseInt(lineSplit[1]), matches.get(Integer.parseInt(lineSplit[1])) + 1);
                } else {
                    matches.put(Integer.parseInt(lineSplit[1]), 1);
                }
            }
        } catch (Exception e) {
            System.out.println("Matches File, Error Class -> " + e.getClass().getName() + "Message -> " + e.getMessage());
            return null;
        }
        return matches;
    }

    public HashMap<String, HashMap<Integer, Integer>> matchesWon() {
        HashMap<String, HashMap<Integer, Integer>> matchesWon = new HashMap<>();
        try {
            File file = new File("src/com/company/dataset/matches.csv");
            Scanner scanner = new Scanner(file);
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] lineSplit = line.split(",");
                if(lineSplit[10].length() == 0) {
                    lineSplit[10] = "No Name";
                }
                if (matchesWon.containsKey(lineSplit[10])) {
                    HashMap<Integer, Integer> data = matchesWon.get(lineSplit[10]);
                    if (data.containsKey(Integer.parseInt(lineSplit[1]))) {
                        data.put(Integer.parseInt(lineSplit[1]), data.get(Integer.parseInt(lineSplit[1])) + 1);
                    } else {
                        data.put(Integer.parseInt(lineSplit[1]), 1);
                    }
                    matchesWon.put(lineSplit[10], data);
                } else {
                    matchesWon.put(lineSplit[10], new HashMap<>(Map.of(Integer.parseInt(lineSplit[1]), 1)));
                }
            }

        } catch (Exception e) {
            System.out.println("Matches File, Error Class -> " + e.getClass().getName() + "Message -> " + e.getMessage());
            return null;
        }
        return matchesWon;
    }
}
