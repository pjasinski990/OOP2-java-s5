import java.util.ArrayList;
import java.util.Scanner;

enum MenuOption {ADD_PRODUCT, SELL_PRODUCT, END_DAY, BALANCE, EXIT}

public class Store {
    private int balance = 0;
    private int date = 0;
    private ArrayList<Product> products = new ArrayList<>();

    void showMenu() {
        Scanner s = new Scanner(System.in);
        System.out.printf(
                "1) Dodaj towar\n"
                + "2) Sprzedaj towar\n"
                + "3) Kolejny dzien\n"
                + "4) Bilans\n"
                + "X) Koniec programu\n"
        );
        String input = s.next();
        MenuOption option = parseOption(input);
        executeTask(option);
    }

    private void executeTask(MenuOption option) {
        switch (option) {
            case ADD_PRODUCT:
                showAddProductMenu();
                break;
            case SELL_PRODUCT:
                showSellProductMenu();
                break;
            case END_DAY:
                endDay();
                break;
            case BALANCE:
                showBalance();
                break;
            case EXIT:
                System.exit(0);
                break;
            default:
                System.out.println("Incorrect option");
                showMenu();
                break;
        }
    }

    private MenuOption parseOption(String s) {
        if (s.equals("X") || s.equals("x")) {
            return MenuOption.EXIT;
        }
        int option = Integer.parseInt(s);
        return MenuOption.values()[option-1];
    }

    private void showAddProductMenu() {
        System.out.printf(
                "1) dodaj owoc\n"
                + "2) dodaj warzywo\n"
                + "3) dodaj drobne agd\n"
        );
        Scanner s = new Scanner(System.in);
        int option = s.nextInt();

        System.out.println("podaj nazwe: ");
        String name = s.next();
        System.out.println("podaj cene zakupu: ");
        int priceBuy = s.nextInt();
        System.out.println("podaj cene sprzedazy: ");
        int priceSell = s.nextInt();

        switch (option) {
            case 1:
                products.add(new Fruit(name, priceBuy, priceSell));
                break;
            case 2:
                products.add(new Vegetable(name, priceBuy, priceSell));
                break;
            case 3:
                products.add(new Appliance(name, priceBuy, priceSell));
        }
    }

    private void showSellProductMenu() {
        System.out.println("Wybierz produkt do sprzedania: ");
        int i = 1;
        for (Product item: products) {
            System.out.println(i++ + ") " + item.name + ", cena: " + item.priceSell);
        }
        Scanner s = new Scanner(System.in);
        int select = s.nextInt() - 1;
        balance += products.get(select).sell();
        products.remove(select);
    }

    private void endDay() {
        System.out.printf("Koniec dnia %d\n\n", date);
        for (int i = 0; i < products.size(); i++) {
            Product item = products.get(i);
            if (item.doesSpoil && item.freshness >= 0) {
                --item.freshness;
                if (item.freshness < 0) {
                    balance -= item.priceBuy;
                    products.remove(i);
                    --i;
                }
            }
        }
        ++date;
    }

    private void showBalance() {
        System.out.println(balance);
    }
}
