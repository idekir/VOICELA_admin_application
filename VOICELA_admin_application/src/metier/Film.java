package metier;

public class Film {
    private int numVisa;
    private String titreFilm;
    private int anneeFilm;
    private int numGenre;

    public Film(int numVisa, String titreFilm, int anneeFilm, int numGenre) {
        this.numVisa = numVisa;
        this.titreFilm = titreFilm;
        this.anneeFilm = anneeFilm;
        this.numGenre = numGenre;
    }

    public Film() {
        
    }

    public int getNumVisa() {
        return numVisa;
    }

    public String getTitreFilm() {
        return titreFilm;
    }

    public int getAnneeFilm() {
        return anneeFilm;
    }

    public int getNumGenre() {
        return numGenre;
    }

    public void setNumVisa(int numVisa) {
        this.numVisa = numVisa;
    }

    public void setTitreFilm(String titreFilm) {
        this.titreFilm = titreFilm;
    }

    public void setAnneeFilm(int anneeFilm) {
        this.anneeFilm = anneeFilm;
    }

    public void setNumGenre(int numGenre) {
        this.numGenre = numGenre;
    }
    
    
}
