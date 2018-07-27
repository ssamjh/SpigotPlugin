package nz.ssamjh.spigotplugin;

public class Person {

    SpigotPlugin plugin = SpigotPlugin.getInstance();

    private Person() {}
    private static Person instance = new Person();
    public static Person getInstance(){
        return instance;
    }


    String name;
    int age;
    double doubleNumber;

    public void count() {
        for (int i = 0; i < 10; i++) {

        }
    }
}