import java.util.ArrayList;
import java.util.List;

public class Person {



    private String name;
    private Company company;
    private List<Pokemon> pokemons;
    private List<Parent> parents;
    private List<Children> children;
    private Car car;

    public Person(String name) {
        this.name = name;
        setCompany(new Company());
        this.pokemons = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
        this.car = new Car();
    }

    public void addChild(Children child){
        this.children.add(child);
    }

    public void addPokemon(Pokemon pokemon){
        this.pokemons.add(pokemon);
    }

    public void addParent(Parent parent){
        this.parents.add(parent);
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public void setParents(List<Parent> parents) {
        this.parents = parents;
    }

    public List<Children> getChildren() {
        return children;
    }

    public void setChildren(List<Children> children) {
        this.children = children;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder(this.name);
        builder.append(System.lineSeparator())
                .append(this.company.toString()).append(System.lineSeparator())
                .append(this.car.toString()).append(System.lineSeparator());
        builder.append("Pokemon:").append(System.lineSeparator());
        this.pokemons.forEach(pokemon -> builder.append(pokemon.toString()).append(System.lineSeparator()));
        builder.append("Parents:").append(System.lineSeparator());
        this.parents.forEach(parent -> builder.append(parent.toString()).append(System.lineSeparator()));
        builder.append("Children:").append(System.lineSeparator());
        this.children.forEach(child -> builder.append(child.toString()).append(System.lineSeparator()));

        return builder.toString();
    }
}
