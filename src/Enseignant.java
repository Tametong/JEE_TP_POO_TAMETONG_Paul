public class Enseignant extends Membre {
    private String departement;

    public Enseignant(String id, String nom, String email, String departement) {
        super(id, nom, email);
        this.departement = departement;
    }

    @Override
    public int getNombreMaxEmprunt(){
        return 5;
    }

    @Override
    public int getDureeEmprunt(){
        return 30;
    }

    public void afficherInfo(){
        System.out.println("Information de l'enseigant:");
        System.out.println("Identifiant: "+ id);
        System.out.println("Nom de l'enseignant: "+ nom);
        System.out.println("Email: "+ email);
        System.out.println("Département: "+ departement);
    }
}
