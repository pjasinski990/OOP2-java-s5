package Armia;

public class Rozkaz {
    public Rozkaz(String order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return order + "\n";
    }

    private String order;
}