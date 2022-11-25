package src;

public class TestService {
    public static void main(String args[]) {
        System.out.println("Test class for services");
        DBMSservice db = new DBMSservice();
        db.getStatus();
        db.getImpiegati();

        String nome = "Gabriele";
        String cognome = "Costa";
        String email = "gabriele@costa01";
        String passw = "123456";
        int stipendio = 500;

        if (db.addImpiegato(nome, cognome, email, passw, stipendio)) {
            System.out.println("Utente inserito");
        } else {
            System.out.println("Utente non inserito");
        }

        db.getImpiegati();

    }
}
