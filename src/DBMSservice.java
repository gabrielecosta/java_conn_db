package src;
import java.sql.*;
import java.util.ArrayList;

public class DBMSservice {
    private static final String baseUrl = "127.0.0.1";
    private static final int port = 3344;
    private static final String user = "root";
    private static final String pass = "";
    private static final String DBAzienda = "azienda";
    private static Connection connAzienda = null;

    public DBMSservice() {
        DBMSservice.connect();
    }

    private static void erroreComunicazioneDBMS(Exception e) {
        final String errore = "Errore durante comunicazione con DBMS" + e;
        System.out.println(errore);
    }

    /**
     * @hidden
     */
    private static String buildConnectionUrl(String dbName) {
        if (dbName.equals(DBAzienda))
            return "jdbc:mysql://" + baseUrl + ":" + port + "/" + dbName + "?user=" + user + "&password=" + pass;
        return "";
    }

    public static void connect() {
        connectAzienda();
    }

    public static void connectAzienda() {
        try {
            if (connAzienda == null || connAzienda.isClosed()) {
                System.out.println("Connettendo con Azienda...");
                DBMSservice.connAzienda = DriverManager.getConnection(buildConnectionUrl(DBAzienda));
                System.out.println("Connesso con Azienda");
            }
        } catch (java.sql.SQLException e) {
            erroreComunicazioneDBMS(e);
        }
    }

    public void getStatus() {
        if (connAzienda != null) {
            System.out.println("connesso....");
        }
    }

    public void getImpiegati() {
        connectAzienda();
        String query = "SELECT * FROM impiegato";
        try (PreparedStatement stmt = connAzienda.prepareStatement(query)) {
            var rs = stmt.executeQuery();
            ArrayList<Impiegato> impiegati = new ArrayList<>();
            while (rs.next()) {
                impiegati.add(Impiegato.createFromDB(rs));
            }
            for(int i=0; i<impiegati.size(); i++) {
                System.out.println(impiegati.get(i));
            }
        } catch (SQLException e) {
            erroreComunicazioneDBMS(e);
        }
    } 

    public static boolean addImpiegato (String nome, String cognome, String email, String passw, int stipendio) {
        connectAzienda();
        String query = "INSERT INTO impiegato(nome, cognome, email, passw, stipendio) VALUES (?,?,?,?,?)";
        try (PreparedStatement stmt = connAzienda.prepareStatement(query)) {
            stmt.setString(1, nome);
            stmt.setString(2, cognome);
            stmt.setString(3, email);
            stmt.setString(4, passw);
            stmt.setInt(5, stipendio);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            erroreComunicazioneDBMS(e);
        }
        return false;
    }

}
