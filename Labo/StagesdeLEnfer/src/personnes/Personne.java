package personnes;

public class Personne {

    // Variables d'instances

    private String name = "";
    private String clubName = "";


    // Méthodes

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }


    @Override
    public String toString() {
        return "name='" + name + '\'' +
                '}';
    }
}
