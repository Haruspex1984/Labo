package personnes;

public class Personne {

    // Variables d'instances

    private String name = "";
    private String clubName = "";

    // Constructeur

    public Personne(String name,String clubName){
        this.name = name;
        this.clubName = clubName;
    }


    // Méthodes

    public String getName() {
        return name;
    }

    public String getClubName() {
        return clubName;
    }

    @Override
    public String toString() {
        return name;
    }
}
