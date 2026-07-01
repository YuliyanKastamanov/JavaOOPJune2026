public class Parent {

    private String name;
    private String birthDay;


    public Parent(String name, String birthDay) {
        this.name = name;
        this.birthDay = birthDay;
    }

    public Parent() {
        this.name = "";
        this.birthDay = "";
    }

    @Override
    public String toString() {
        return this.name + " " + this.birthDay;
    }
}
