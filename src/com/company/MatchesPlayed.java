package com.company;

import java.io.File;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MatchesPlayed {
    public Map<Integer, Integer> matchesPlayed() {
        Map<Integer, Integer> matches = new TreeMap<>();
        try {
            File file = new File("src/com/company/dataset/matches.csv");
            Scanner scanner = new Scanner(file);
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] lineSplit = line.split(",");
                if(matches.containsKey(Integer.parseInt(lineSplit[1]))) {
                    matches.put(Integer.parseInt(lineSplit[1]), matches.get(Integer.parseInt(lineSplit[1])) + 1);
                }else {
                    matches.put(Integer.parseInt(lineSplit[1]), 1);
                }
            }

        } catch (Exception e) {
            System.out.println("File Not Found");
            return  null;
        }
        return matches;
    }
}
