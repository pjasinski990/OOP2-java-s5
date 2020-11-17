package Armia;

import java.util.List;
import java.util.ArrayList;
import java.lang.Integer;
import java.lang.StringBuilder;

public class CentrumDowodzenia {
    private List<Czolg> registeredTanks = new ArrayList<Czolg>();

    public void zarejestrujCzolg(Czolg t) {
        registeredTanks.add(t);
    }

    public void wydajRozkaz(String tankID, Rozkaz order) {
        int id = Integer.parseInt(tankID);
        if (id <= registeredTanks.size()) {
            registeredTanks.get(id - 1).addOrder(order);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < registeredTanks.size(); i++) {
            sb.append("Czolg nr. " + (i+1) + " otrzymal rozkazy:\n");
            sb.append(registeredTanks.get(i).toString());
        }
        return sb.toString();
    }
}
