public class User {

    private String name;
    private Suit role;

    public User(String name, Suit role) {
        setName(name);
        this.role = role;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.length() > 3){
            this.name = name;
        }
    }

    public Suit getRole() {
        return role;
    }

    public void setRole(Suit role) {
        this.role = role;
    }


    @Override
    public String toString() {
        return String.format("Hello my name is: %s, my role is: %s.", name, role);
    }
}
