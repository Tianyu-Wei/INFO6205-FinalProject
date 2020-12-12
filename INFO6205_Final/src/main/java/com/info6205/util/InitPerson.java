package com.info6205.util;

import com.info6205.entity.Person;
import com.info6205.entity.PersonDictionary;

import java.util.Random;

public class InitPerson {

    public static PersonDictionary getPersonDirectory(int population, int infectedNum, double rateMasked, double rateGoOut, double rateTesting) {
        Random random = new Random();
        int m = (int)(population * rateGoOut / 100);  // number of people go out
        int n = (int)(m * rateMasked / 100); // number of people wear mask
        int t = (int)(population * rateTesting / 100);

        boolean[] isMasked = new boolean[m]; // only the people who go out will wear the mask

        for (int i = 0; i < n; i++) {
            int index = random.nextInt(m);
            while (isMasked[index]) {
                index = random.nextInt(m);
            }
            isMasked[index] = true;
        }

        PersonDictionary personDirectory = new PersonDictionary();

        int width = 800, height = 800;

        int j = 0; // number of people go out
        for (int i = 0; i < population; i++) {
            int x =random.nextInt(width);
            int y = random.nextInt(height);
            int target_x, target_y;
            if (j < m) {
                // people who go out
                target_x = random.nextInt(width);
                target_y = random.nextInt(height);
            } else {
                // people who are at home
                target_x = x;
                target_y = y;
            }

            Person person;
            if (i < infectedNum) {
                //people who are infected
                person = new Person(x, y, target_x, target_y, true, true, isMasked[i], false, false);
                person.setState(4);
            } else if (i >= infectedNum && i < m) {
                //people who wear mask
                person = new Person(x, y, target_x, target_y, false, false, isMasked[i], false, false);
            } else {
                //people who not wear mask
                person = new Person(x, y, target_x, target_y, false, false, false, false, false);
            }
            //PersonDictionary.getInstance().getPersonList().add(person);
            personDirectory.getPersonList().add(person);
        }
        while(t > 0) {
            int index = random.nextInt(population);
            //System.out.println(index);
            while(personDirectory.getPersonList().get(index).isTested()) {
                index = random.nextInt(population);
            }
            personDirectory.getPersonList().get(index).setTested(true);
            t--;
        }
        return personDirectory;
    }
}
