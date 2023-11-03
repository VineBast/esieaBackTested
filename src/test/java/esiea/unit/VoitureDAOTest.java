package esiea.unit;

import esiea.dao.VoitureDAO;
import esiea.metier.Voiture;
import esiea.metier.Voiture.Carburant;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class VoitureDAOTest {

    private VoitureDAO voitureDAO;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    @Before
    public void setUp() {
        voitureDAO = new VoitureDAO();
        connection = mock(Connection.class);
        preparedStatement = mock(PreparedStatement.class);
        resultSet = mock(ResultSet.class);
    }

    @Test
    public void testAjouterVoiture() throws SQLException {
        Voiture voiture = new Voiture();
        voiture.setMarque("Peugeot");
        voiture.setModele("405");
        voiture.setFinition("Bleu");
        voiture.setCarburant(Carburant.DIESEL);
        voiture.setKm(500000);
        voiture.setAnnee(1993);
        voiture.setPrix(500);

        when(connection.prepareStatement(Mockito.anyString())).thenReturn(preparedStatement);

        voitureDAO.connection = connection;
        voitureDAO.ajouterVoiture(voiture);

        Mockito.verify(preparedStatement).setString(1, "Peugeot");
        Mockito.verify(preparedStatement).setString(2, "405");
        Mockito.verify(preparedStatement).setString(3, "Bleu");
        Mockito.verify(preparedStatement).setString(4, Carburant.DIESEL.toString());
        Mockito.verify(preparedStatement).setInt(5, 500000);
        Mockito.verify(preparedStatement).setInt(6, 1993);
        Mockito.verify(preparedStatement).setInt(7, 500);
        Mockito.verify(preparedStatement).executeUpdate();

        Mockito.verify(connection).close();
    }

    @Test
    public void testSupprimerVoiture() throws SQLException {
        String id = "1";

        when(connection.prepareStatement(Mockito.anyString())).thenReturn(preparedStatement);

        voitureDAO.connection = connection;
        voitureDAO.supprimerVoiture(id);

        Mockito.verify(preparedStatement).setString(1, id);
        Mockito.verify(preparedStatement).executeUpdate();

        Mockito.verify(connection).close();
    }
}

