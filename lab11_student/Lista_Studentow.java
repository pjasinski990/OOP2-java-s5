import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Lista_Studentow {
    public void add(Student s) {
        list.add(s);
    }

    public void add(String imie, String nazwisko, int wiek) {
        add(new Student(imie, nazwisko, wiek));
    }

    public void wypisz_wszystkich() {
        for (Student s: list) {
            System.out.printf("%s %s %d\n", s.getImie(), s.getNazwisko(), s.getWiek());
        }
    }

    public void sort_imie_rosnaca() {
        Collections.sort(list, Comparator.comparing(Student::getImie));
    }

    public void sort_imie_malejaca() {
        Collections.sort(list, Comparator.comparing(Student::getImie).reversed());
    }

    public void sort_nazwisko_rosnaca() {
        Collections.sort(list, Comparator.comparing(Student::getNazwisko));
    }

    public void sort_nazwisko_malejaca() {
        Collections.sort(list, Comparator.comparing(Student::getNazwisko).reversed());
    }

    public void sort_wiek_malejaca() {
        Collections.sort(list, Comparator.comparing(Student::getWiek));
    }

    public void sort_wiek_rosnaca() {
        Collections.sort(list, Comparator.comparing(Student::getWiek).reversed());
    }

    private ArrayList<Student> list = new ArrayList<>();
}