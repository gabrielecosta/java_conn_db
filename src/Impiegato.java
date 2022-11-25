package src;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Impiegato {
    private int matricola;
    private String nome;
    private String cognome;
    private String email;
    private String passw;
    private int stipendio;

    public Impiegato(int matricola, String nome, String cognome, String email, String passw, int stipendio) {
        this.setMatricola(matricola);
        this.setNome(nome);
        this.setCognome(cognome);
        this.setEmail(email);
        this.setPassw(passw);
        this.setStipendio(stipendio);
    }

    public int getMatricola() {
        return this.matricola;
    }

    public void setMatricola(int matricola) {
        this.matricola = matricola;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return this.cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassw() {
        return this.passw;
    }

    public void setPassw(String passw) {
        this.passw = passw;
    }

    public int getStipendio() {
        return this.stipendio;
    }

    public void setStipendio(int stipendio) {
        this.stipendio = stipendio;
    }

    public static Impiegato createFromDB(ResultSet row) throws SQLException {
        int matricola = row.getInt(1);
        String nome = row.getString(2);
        String cognome = row.getString(3);
        String email = row.getString(4);
        String passw = row.getString(5);
        int stipendio = row.getInt(6);
        return new Impiegato(matricola, nome, cognome, email, passw, stipendio);
    }

    public String toString() {
        String ret = this.getNome() + " " + this.getCognome() + " " + ", " + this.getMatricola();
        return ret;
    }
}
