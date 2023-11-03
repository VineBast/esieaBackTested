package esiea.integration;

import esiea.api.VoitureAPI;
import esiea.metier.Voiture;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DatabaseAndAPITest {
    private VoitureAPI voitureAPI;

    @Before
    public void setUp() {
        voitureAPI = new VoitureAPI();
    }

    @Test
    public void testToutesVoitures() {
        Voiture[] voitures = voitureAPI.getToutesVoitures(0, 1000).getData();
        assertNotEquals(0, voitures.length);
    }

    @Test
    public void testAjouterVoiture() {
        JSONObject json = new JSONObject();
        json.put("marque", "Peugeot");
        json.put("modele", "405");
        json.put("finition", "Bleu");
        json.put("carburant", "E");
        json.put("km", 500000);
        json.put("annee", 1993);
        json.put("prix", 500);

        String result = voitureAPI.ajouterVoiture(json.toString());
        JSONObject response = new JSONObject(result);

        assertTrue(response.getBoolean("succes"));
    }

    @Test
    public void testSupprimerVoiture() {
        String id = "10";
        String result = voitureAPI.supprimerVoiture(id);
        JSONObject response = new JSONObject(result);

        assertTrue(response.getBoolean("succes"));
    }

    @Test
    public void testGetVoituresJsonAll() {
        String result = voitureAPI.getVoituresJson("all", "0", "1000");
        JSONObject response = new JSONObject(result);

        assertTrue(response.has("voitures"));
        JSONArray voitures = response.getJSONArray("voitures");
        assertTrue(voitures.length() > 0);
    }

    @Test
    public void testVoitureFromJson() {
        JSONObject json = new JSONObject();
        json.put("id", 1);
        json.put("marque", "Tesla");
        json.put("modele", "S");
        json.put("finition", "Blanc");
        json.put("carburant", "W");
        json.put("km", 2000);
        json.put("annee", 2022);
        json.put("prix", 45000);

        Voiture result = voitureAPI.voitureFromJson(json);

        assertNotNull(result);
        assertEquals(1, result.getId());
        assertEquals("Tesla", result.getMarque());
        assertEquals("S", result.getModele());
        assertEquals("Blanc", result.getFinition());
        assertEquals(Voiture.Carburant.ELECTRIQUE, result.getCarburant());
        assertEquals(2000, result.getKm());
        assertEquals(2022, result.getAnnee());
        assertEquals(45000, result.getPrix());
    }

}
