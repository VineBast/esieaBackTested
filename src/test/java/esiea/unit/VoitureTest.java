package esiea.unit;

import esiea.metier.Voiture;
import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.*;

public class VoitureTest {
    private Voiture voiture;

    @Before
    public void setUp() {
        voiture = new Voiture();
    }

    @Test
    public void testCheck() {
        voiture.setMarque("Peugeot");
        voiture.setModele("405");
        voiture.setFinition("Bleu");
        voiture.setCarburant(Voiture.Carburant.ESSENCE);
        voiture.setKm(500000);
        voiture.setAnnee(1993);
        voiture.setPrix(500);

        assertTrue(voiture.check());

        voiture.setId(-1);
        voiture.setMarque("");
        voiture.setModele("");
        voiture.setFinition("");
        voiture.setCarburant(null);
        voiture.setKm(-5000);
        voiture.setAnnee(1);
        voiture.setPrix(-5000);

        assertFalse(voiture.check());
    }

    @Test
    public void testGetType() {
        assertEquals("string", Voiture.getTypeDonnee("marque"));
        assertEquals("string", Voiture.getTypeDonnee("modele"));
        assertEquals("string", Voiture.getTypeDonnee("finition"));
        assertEquals("entier", Voiture.getTypeDonnee("id"));
        assertEquals("entier", Voiture.getTypeDonnee("annee"));
        assertEquals("entier", Voiture.getTypeDonnee("km"));
        assertEquals("entier", Voiture.getTypeDonnee("prix"));

        assertEquals("", Voiture.getTypeDonnee("invalidAttribute"));
    }
}

