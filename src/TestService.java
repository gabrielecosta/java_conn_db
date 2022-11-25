package src;

import java.util.Scanner;

public class TestService {
    public static void main(String args[]) {
        System.out.println("Test class for services");
        DBMSservice db = new DBMSservice();
        db.getStatus();
    
		Scanner scanner = new Scanner(System.in);
		boolean loop = true;

		while(loop) {
			System.out.println("Menu: ");
			System.out.println("-1) Esci");
			System.out.println("1) Inserisci impiegato");
			System.out.println("2) Cercare impiegato");
			System.out.println("3) Stampare impiegati");
			System.out.println("4) Cancella impiegato");
			System.out.print("Scelta: ");
			int sc = scanner.nextInt();
			System.out.println("===========================");
			switch(sc) {
				case 1:
				System.out.print("Inserisci nome: ");
				String nome = scanner.next();
				System.out.print("Inserisci cognome: ");
				String cognome = scanner.next();
                System.out.print("Inserisci email: ");
				String email = scanner.next();
                System.out.print("Inserisci password: ");
				String passw = scanner.next();
				System.out.print("Inserisci stipendio: ");
				int stipendio = scanner.nextInt();
				if (db.addImpiegato(nome, cognome, email, passw, stipendio)) {
                    System.out.println("Utente inserito");
                } else {
                    System.out.println("Utente non inserito");
                }
                //String nome = "Gabriele";
                //String cognome = "Costa";
                //String email = "gabriele@costa01";
                //String passw = "123456";
                //int stipendio = 500;
                break;

				case 2:
				System.out.println("Da implementare...");
				break;

				case 3:
				db.getImpiegati();
				break;

				case 4:
				System.out.println("Da implementare...");
				break;

				case -1:
				loop = false;
				break;

				default:
				System.out.println("Scelta non valida!");
				break;
			}
			System.out.println("===========================");
		}

    }
}
