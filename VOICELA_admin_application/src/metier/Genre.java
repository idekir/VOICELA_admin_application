package metier;

public class Genre {
    private int numGenre;
    private String nomGenre;

    public Genre(int numGenre, String nomGenre) {
        this.numGenre = numGenre;
        this.nomGenre = nomGenre;
    }

    public Genre() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getNumGenre() {
        return numGenre;
    }

    public String getNomGenre() {
        return nomGenre;
    }

    public void setNumGenre(int numGenre) {
        this.numGenre = numGenre;
    }

    public void setNomGenre(String nomGenre) {
        this.nomGenre = nomGenre;
    }
}
