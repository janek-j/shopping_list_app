package src;

public class User {
    String name;
    String surname;
    public User(String _name, String _surname) {
        name = _name;
        surname = _surname;
    }
    public void print_info() {
        System.out.println(name + " " + surname);
    }
}
