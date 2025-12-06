public class Etudiant extends Membre{

    private String filiere;

    public Etudiant(String id, String nom, String email, String filiere) {
        super(id, nom, email);
        this.filiere = filiere;
    }

    @Override
    public int getNombreMaxEmprunt(){
        return 3;
    }

    @Override
    public int getDureeEmprunt(){
        return 14;
    }

    public void afficherInfo(){
        System.out.println("Information de l'étudiant:");
        System.out.println("Identifiant: "+ id);
        System.out.println("Nom de l'étudiant: "+ nom);
        System.out.println("Email: "+ email);
        System.out.println("Filière: "+ filiere);
    }
}
