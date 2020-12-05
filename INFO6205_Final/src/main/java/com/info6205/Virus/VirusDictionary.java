package com.info6205.Virus;

import java.util.ArrayList;
import java.util.List;

public class VirusDictionary {

    private static List<Virus> virusList = new ArrayList<>();

    public VirusDictionary() {
        Virus covid19 = new Covid19();
        virusList.add(covid19);
    }

    public List<Virus> getVirusList() {
        return virusList;
    }

    public void setVirusList(List<Virus> virusList) {
        this.virusList = virusList;
    }

    public static Virus searchVirusByName(String name) {
        for (Virus virus : virusList) {
            if (virus.getName().equals(name)) {
                return virus;
            }
        }
        return null;
    }
}
