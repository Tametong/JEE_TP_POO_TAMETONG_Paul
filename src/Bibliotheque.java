import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Bibliotheque {

    private String nom;
    private Livre []livre = new Livre[100];
    private Etudiant []etudiant = new Etudiant[50];
    private Emprunt []emprunt = new Emprunt[200];

    int nbLivre, nbMembre, nbEmprunts;

    public Etudiant[] getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant[] etudiant) {
        this.etudiant = etudiant;
    }

    public Emprunt[] getEmprunt() {
        return emprunt;
    }

    public void setEmprunt(Emprunt[] emprunt) {
        this.emprunt = emprunt;
    }

    public Livre[] getLivre() {
        return livre;
    }

    public void setLivre(Livre[] livre) {
        this.livre = livre;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void ajouterLivre(Livre liv){
        nbLivre = 0;
        livre[nbLivre] = liv;
        nbLivre = nbLivre + 1;
    }

    public void inscrireMembre(Etudiant etud){
        nbMembre = 0;
        etudiant[nbMembre] = etud;
        nbMembre = nbMembre + 1;

    }

    public void rechercherLivreParTitre(String titre){
        for (int i = 0; i < livre.length; i++) {
            if (livre[i] != null && livre[i].getTitre().equals(titre)) {
                System.out.println("Le livre existe: ");
                System.out.println("isbn"+ livre[i].getIsbn());
                System.out.println("Titre: " + livre[i].getTitre());
                System.out.println("Auteur: " + livre[i].getAuteur());
                System.out.println("Année de publication: " + livre[i].getAnneePublication());
            }else{
                System.out.println("Le livre n'existe pas");
            }
        }
    }

    public void rechercherMembreParId(String id){
        for (int i = 0; i < etudiant.length; i++) {
            if (etudiant[i] != null && etudiant[i].getId().equals(id)) {
                System.out.println("Membre existant: ");
                System.out.println("id: "+ etudiant[i].getId());
                System.out.println("Nom: "+ etudiant[i].getNom());
                System.out.println("Email: "+ etudiant[i].getEmail());
            }
        }
    }

    public void effectuerEmprunt(String isbn, String idMember, String date){
        nbEmprunts = 0;
        for (int i = 0; i < 100; i++) {
            if (livre[i].getIsbn().equals(isbn) ) {
                for (int j = 0; j < 50; j++) {
                    if (etudiant[j] != null && etudiant[j].getId().equals(idMember)) {
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                        String dateEnregistrement = LocalDate.now().format(formatter);
                        emprunt[nbEmprunts]= new Emprunt(livre[i], etudiant[j], dateEnregistrement, date, false);
                        nbEmprunts +=1;
                    }

                }
                System.out.println("Emprunt effectué avec succès");
            }else {
                System.out.println("Erreur lors de l'emprunt veuillez réessayer");
            }
        }

    }

    public  void afficherLivreDisponible(){
        for (int i = 0; i < livre.length; i++) {
            if (livre[i] != null && livre[i].isDisponible()) {
                System.out.println("Livres disponibles: ");
                System.out.println("Titre: "+ livre[i].getTitre() + "de :"+ livre[i].getAuteur());
            }
        }
    }

    public void afficherStatistique(){
        System.out.println("=================================STATISTIQUES=================================");
        System.out.println("Nombre total de livre: "+ nbLivre);
        int livreDisponible = 0;
        for (int i = 0; i < livre.length; i++) {
            if (livre[i] != null && livre[i].isDisponible()) {
                livreDisponible +=1;
            }
        }
        System.out.println("Nombre de livre disponible: "+ livreDisponible);
        System.out.println("Nombre de membre: "+ etudiant.length);


        System.out.println("Nombre d'emprunts en cours: "+ nbEmprunts);

        float tauxOccupation = ((float) nbEmprunts / nbLivre)*100;
        System.out.println("Taux d'occupation: "+ tauxOccupation + "%");
    }
}
