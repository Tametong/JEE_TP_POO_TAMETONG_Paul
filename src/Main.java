import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choix;

        Bibliotheque biliotheque = new Bibliotheque();

        //membres initiaux présents dans la bibliothèque
        Etudiant etudiant1 = new Etudiant("0012025", "Tametong", "mesbus8@gmail.com", "Génie logiciel");
        Etudiant etudiant2 = new Etudiant("0022025", "Essoh", "paul@gmail.com", "Génie civile");
        biliotheque.inscrireMembre(etudiant1);
        biliotheque.inscrireMembre(etudiant2);

        //Livres initiaux dans la bibliotheque
        Livre livre1 = new Livre("LI001", "Paul", "Les portes du temps suspendu", 2000,  true);
        Livre livre2 = new Livre("LI002", "Jean", "Le couscous du sesert", 2010,  true);
        Livre livre3 = new Livre("LI003", "Jean de la Fontaine", "Mon papayer", 1957,  false);
        biliotheque.ajouterLivre(livre1);
        biliotheque.ajouterLivre(livre2);
        biliotheque.ajouterLivre(livre3);

        do {
            System.out.println("||============================================||");
            System.out.println("||     BIBLIOTHEQUE UNIVERSITAIRE ENSPD       ||");
            System.out.println("||  1. Ajouter un livre                       ||");
            System.out.println("||  2. Inscrire un membre                     ||");
            System.out.println("||  3. Effectuer un emprunt                   ||");
            System.out.println("||  4. Retourner un livre                     ||");
            System.out.println("||  5. Rechercher un livre                    ||");
            System.out.println("||  6. Afficher livres disponibles            ||");
            System.out.println("||  7. Afficher les statistiques              ||");
            System.out.println("||  0. Quitter                                ||");
            System.out.println("||                                            ||");
            System.out.println("||============================================||");

            choix = sc.nextInt();
            sc.nextLine();

            switch (choix){
                case 1:
                    System.out.println("Ajouter un livre: ");
                    System.out.println("Entrer le isbn: ");
                    String isbn = sc.nextLine();
                    System.out.println("Nom de l'auteur");
                    String nomAuteur = sc.nextLine();
                    System.out.println("Entrer le titre: ");
                    String titre = sc.nextLine();
                    System.out.println("Année de publication: ");
                    int annePublication = sc.nextInt();
                    sc.nextLine();

                    for (int i = 0; i < biliotheque.getLivre().length; i++) {
                        if (biliotheque.getLivre()[i] != null && isbn.equals(biliotheque.getLivre()[i].getIsbn())) {
                            System.out.println("Ce livre existe déja, veuillez en créer un autre avec un autre isbn");
                        }else{
                            //Livre créer par l'utilisateur
                            Livre livre4 = new Livre(isbn, nomAuteur, titre, annePublication, true);
                            biliotheque.ajouterLivre(livre4);
                        }
                    }



                case 2:
                    //Ajouter un membre
                    System.out.println("Ajouter un membre: ");
                    System.out.println("Entrer l'identifiant: ");
                    String id = sc.nextLine();
                    System.out.println("Nom du membre");
                    String nom = sc.nextLine();
                    System.out.println("Entrer l'email: ");
                    String email = sc.nextLine();
                    System.out.println("Entrer la filière: ");
                    String filiere = sc.nextLine();

                    for (int i = 0; i < biliotheque.getEtudiant().length; i++) {
                        if (biliotheque.getEtudiant()[i] != null && id.equals(biliotheque.getEtudiant()[i].getId())) {
                            System.out.println("l'étudiant existe déja veuillez en créer un autre avec un autre identifiant");
                        }else{
                            Etudiant etudiant3 = new Etudiant(id, nom, email, filiere);
                            biliotheque.inscrireMembre(etudiant3);
                        }
                    }
                    break;


                case 3:
                    //Effectuer un emprunt
                    System.out.println("Effectuer un emprunt: ");
                    System.out.println("id de l'étudiant: ");
                    String ide = sc.nextLine();
                    System.out.println("isbn du livre: ");
                    String isbnl = sc.nextLine();
                    System.out.println("Entrer la date de retour: ");
                    String dateRetour = sc.nextLine();
                    biliotheque.effectuerEmprunt(isbnl, ide, dateRetour);
                    break;

                case 4:
                    //Retourner un livre
                    System.out.println("Entrer l'isbn du livre à retourner: ");
                    String isbn_retour = sc.nextLine();
                    System.out.println("Entrer l'id du membre qui l'a emprunté: ");
                    String id_member = sc.nextLine();
                    for (int i = 0; i < biliotheque.getEmprunt().length; i++) {
                        if (isbn_retour.equals(biliotheque.getEmprunt()[i].getLivre().getIsbn()) && id_member.equals(biliotheque.getEmprunt()[i].getEtudiant().getId())) {
                            biliotheque.getEmprunt()[i].retournerLivre(isbn_retour);
                        }
                    }

                    break;

                case 5:
                    //Rechercher un livre
                    System.out.println("Entrer le titre du livre à rechercher");
                    String titreRechercher = sc.nextLine();
                    biliotheque.rechercherLivreParTitre(titreRechercher);

                    break;

                case 6:
                    //Afficher les livres disponibles
                    biliotheque.afficherLivreDisponible();

                    break;

                case 7:
                    //Afficher statistiques
                    biliotheque.afficherStatistique();

                    break;

                case 0:
                    System.out.println("Good bye");
                    System.exit(0);

                    break;
                default:
                    System.out.println("Vous avez choisi une option indisponible");
            }
        }while (choix == 0);

        sc.close();
    }

}