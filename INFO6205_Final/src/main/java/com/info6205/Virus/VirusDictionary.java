package com.info6205.Virus;

import java.util.ArrayList;
import java.util.List;

public class VirusDictionary {

    private List<Virus> virusList = new ArrayList<>();

    public VirusDictionary() {
        Virus covid19 = new Covid19();
        Virus SARS = new SARS();
        Virus Measles = new Measles();
        Virus Pertussis = new Pertussis();
        virusList.add(covid19);
        virusList.add(SARS);
        virusList.add(Measles);
        virusList.add(Pertussis);
    }

    public List<Virus> getVirusList() {
        return virusList;
    }

    private static VirusDictionary virusDictionary = new VirusDictionary();

    public static VirusDictionary getInstance() {
        return virusDictionary;
    }

    public static Virus searchVirusByName(String name) {
        for (Virus virus : VirusDictionary.getInstance().getVirusList()) {
            if (virus.getName().equals(name)) {
                return virus;
            }
        }
        return null;
    }
}
