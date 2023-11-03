package esiea.unit;

import esiea.dao.ReponseVoiture;
import esiea.metier.Voiture;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ReponseVoitureTest {

    @Test
    public void testGetData() {
        ReponseVoiture reponse = new ReponseVoiture();
        Voiture[] data = new Voiture[3];
        reponse.setData(data);

        Voiture[] result = reponse.getData();

        assertArrayEquals(data, result);
    }

    @Test
    public void testGetVolume() {
        ReponseVoiture reponse = new ReponseVoiture();
        reponse.setVolume(5);

        int result = reponse.getVolume();

        assertEquals(5, result);
    }

    @Test
    public void testSetData() {
        ReponseVoiture reponse = new ReponseVoiture();
        Voiture voiture = new Voiture();
        reponse.setData(voiture, 0);

        Voiture[] result = reponse.getData();

        assertEquals(voiture, result[0]);
    }
}

