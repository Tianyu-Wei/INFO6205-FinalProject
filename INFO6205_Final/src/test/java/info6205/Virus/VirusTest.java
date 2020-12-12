package info6205.Virus;

import com.info6205.Virus.Virus;
import com.info6205.Virus.VirusDictionary;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VirusTest {

    private VirusDictionary virusDictionary = new VirusDictionary();

    @Test
    public void searchByName() {
        Virus virus = virusDictionary.searchVirusByName("Covid19");
        assertEquals("Covid19", virus.getName());
    }
}
