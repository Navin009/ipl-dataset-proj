package com.company;

import java.io.File;
import java.util.*;

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

    public HashMap<String, Integer> extraRuns() {
        HashMap<String, Integer> extraRuns = new HashMap<>();
        ArrayList<Integer> matchIds = new ArrayList<>();
        try {
            File file = new File("src/com/company/dataset/matches.csv");
            Scanner scanner = new Scanner(file);
            scanner.nextLine();

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] lineSplit = line.split(",");
                if(lineSplit[1].equals("2016")) {
                    matchIds.add(Integer.parseInt(lineSplit[0]));
                }
            }
            file = new  File("src/com/company/dataset/deliveries.csv");
            scanner = new Scanner(file);
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] lineSplit = line.split(",");
                if(matchIds.contains(Integer.parseInt(lineSplit[0]))) {
                    if (extraRuns.containsKey(lineSplit[2])) {
                        extraRuns.put(lineSplit[2], extraRuns.get(lineSplit[2]) + Integer.parseInt(lineSplit[16]));
                    }else {
                        extraRuns.put(lineSplit[2], Integer.parseInt(lineSplit[16]));
                    }
                }
            }

        } catch (Exception e) {
            System.out.println("Matches File, Error Class -> " + e.getClass().getName() + "Message -> " + e.getMessage());
        }
        return extraRuns;
    }
}
