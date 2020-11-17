package Armia;
import java.util.List;
import java.util.ArrayList;

public class Czolg {
    private List<Rozkaz> orders = new ArrayList<Rozkaz>();

    public void addOrder(Rozkaz order) {
        orders.add(order);
    }

    public String ostatniRozkaz() {
        if (orders.size() > 0) {
            return "Ostatni rozkaz do mnie: " + orders.get(orders.size() - 1).toString();
        }
        else {
            return null;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Rozkaz o: orders) {
            sb.append(o.toString());
        }
        sb.append("\n");
        return sb.toString();
    }
}
