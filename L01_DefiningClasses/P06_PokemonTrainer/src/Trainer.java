import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private int numberOfBadges;
    private List<Pokemon> pokemon;


    public Trainer() {
        this.numberOfBadges = 0;
        this.pokemon = new ArrayList<>();

    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemon.add(pokemon);
    }


    public List<Pokemon> getPokemon() {
        return pokemon;

    }

    public void setNumberOfBadges(int numberOfBadges) {
        this.numberOfBadges = numberOfBadges;
    }

    public int getNumberOfBadges() {
        return numberOfBadges;
    }

}
