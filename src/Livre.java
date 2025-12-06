import java.time.LocalDate;

public class Livre {
    private String isbn;
    private String titre;
    private String auteur;
    private int anneePublication;
    private boolean disponible = true;

    //Constructeur

    public Livre() {
        this("", "", "", 0, true);
    }

    public Livre(String isbn, String auteur, String titre, int anneePublication, boolean disponible) {
        this.isbn = isbn;
        this.auteur = auteur;
        this.titre = titre;
        this.anneePublication = anneePublication;
        this.disponible = disponible;
    }


    //Getters et setters
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public int getAnneePublication() {
        return anneePublication;
    }

    public void setAnneePublication(int anneePublication) {
        this.anneePublication = anneePublication;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void afficherDetail(){
        System.out.println("Information du livre: ");
        System.out.println("Identifiant unique du livre: "+ isbn);
        System.out.println("Titre du livre: "+ titre);
        System.out.println("Nom de l'auteur: "+ auteur);
        System.out.println("Année de publication: "+ anneePublication);
    }

    public int getAge(){
        return LocalDate.now().getYear() - anneePublication;
    }
}
