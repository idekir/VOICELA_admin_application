package metier;

public class Genre {
    private int numGenre;
    private String nomGenre;

    public Genre(int numGenre, String nomGenre) {
        this.numGenre = numGenre;
        this.nomGenre = nomGenre;
    }

    public Genre() {
        
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
