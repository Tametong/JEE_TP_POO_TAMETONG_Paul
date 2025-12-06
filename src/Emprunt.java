public class Emprunt {

    private Livre livre;
    private Etudiant etudiant;
    private String dateEmprunt;
    private String dateRetour;
    private boolean rendu;

    public Emprunt(Livre livre, Etudiant etudiant, String dateEmprunt, String dateRetour, boolean rendu) {
        this.livre = livre;
        this.etudiant = etudiant;
        this.dateEmprunt = dateEmprunt;
        this.dateRetour = dateRetour;
        this.rendu = false;

        livre.setDisponible(false);
    }

    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public String getDateEmprunt() {
        return dateEmprunt;
    }

    public void setDateEmprunt(String dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }

    public String getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(String dateRetour) {
        this.dateRetour = dateRetour;
    }

    public boolean isRendu() {
        return rendu;
    }

    public void setRendu(boolean rendu) {
        this.rendu = rendu;
    }

    public void retournerLivre(String isbn){
        if (isbn.equals(livre.getIsbn())) {
            livre.setDisponible(true);
            rendu = true;
            System.out.println("Livre retourné avec succès");
        }else {
            System.out.println("Ce livre n'as pas été emprunté");
        }

    }

    public void afficheEmprunt(){
        System.out.println("Détails de l'emprunt: ");
        System.out.println("Livre emprunté: " + livre.getTitre());
        System.out.println("Personne ayant contracter l'emprunt: "+ etudiant.getNom());
        System.out.println("Date de l'emprunt: "+ dateEmprunt);
        System.out.println("Date de retour: "+ dateRetour);
        if (rendu == true) {
            System.out.println("Statut du retour: Livre retourner");
        } else {
            System.out.println("Statut du retour: Livre non retourner");
        }

    }
}
