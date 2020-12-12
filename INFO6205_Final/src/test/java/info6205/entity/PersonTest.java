package info6205.entity;

import com.info6205.City.*;
import com.info6205.Virus.*;
import com.info6205.entity.Person;
import org.junit.Assert;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class PersonTest {

    Person person = new Person(100, 100, 400, 500, false, false, false, false, false);
    @Test
    public void moveTest() {

        person.move();
        assertEquals(person.getX(), 100.6);
        assertEquals(person.getY(), 100.8);

        person.setX(400);
        person.setY(500);
        person.move();
        assertEquals(person.isArrive(), true);

    }

    @Test
    public void distanceTest0() {
        Person p1 = new Person(80, 90, 90, 90, true, false, false, false, false);
        Person p2 = new Person(86, 90, 240, 240, true, false, false, false, false);

        double d = p1.distance(p2.getX(), p2.getY());
        Assert.assertEquals(6, d, 0);

    }

    @Test
    public void covidBostonStateTest() {
        Person p1 = new Person(80, 90, 90, 90, true, false, true, false, false);

        Virus virus = new Covid19();
        City city = new Boston();
        p1.updateState(virus, city);
        Assert.assertEquals(1, p1.getState());
    }

    @Test
    public void covidNewYorkStateTest() {
        Person p1 = new Person(80, 90, 90, 90, true, false, true, false, false);

        Virus virus = new Covid19();
        City city = new NewYork();
        p1.updateState(virus, city);
        Assert.assertEquals(1, p1.getState());
    }

    @Test
    public void covidSeattleStateTest() {
        Person p1 = new Person(80, 90, 90, 90, true, false, true, false, false);

        Virus virus = new Covid19();
        City city = new Seattle();
        p1.updateState(virus, city);
        Assert.assertEquals(1, p1.getState());
    }

    @Test
    public void covidWuhanStateTest() {
        Person p1 = new Person(80, 90, 90, 90, true, false, true, false, false);

        Virus virus = new Covid19();
        City city = new WuHan();
        p1.updateState(virus, city);
        Assert.assertEquals(1, p1.getState());
    }

    @Test
    public void measlesBostonStateTest() {
        Person p1 = new Person(80, 90, 90, 90, true, false, true, false, false);

        Virus virus = new Measles();
        City city = new Boston();
        p1.updateState(virus, city);
        Assert.assertEquals(3, p1.getState());
    }

    @Test
    public void pertussisBostonStateTest() {
        Person p1 = new Person(80, 90, 90, 90, true, false, true, false, false);

        Virus virus = new Pertussis();
        City city = new Boston();
        p1.updateState(virus, city);
        Assert.assertEquals(3, p1.getState());
    }

    @Test
    public void sarsBostonStateTest() {
        Person p1 = new Person(80, 90, 90, 90, true, false, true, false, false);

        Virus virus = new SARS();
        City city = new Boston();
        p1.updateState(virus, city);
        Assert.assertEquals(1, p1.getState());
    }

    @Test
    public void stateTest2() {
        Person p1 = new Person(80, 90, 90, 90, true, false, true, false, false);

        p1.move();
        Assert.assertEquals(false, p1.isArrive());
    }

    @Test
    public void stateTest3() {
        Person p1 = new Person(90, 90, 90, 90, true, false, true, false, false);

        p1.move();
        Assert.assertEquals(true, p1.isArrive());
    }
}
