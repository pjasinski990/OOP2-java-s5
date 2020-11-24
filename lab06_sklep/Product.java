interface Sellable {
    int sell();
}

public class Product implements Sellable {
    Product(String name, int priceBuy, int priceSell) {
        this.name = name;
        this.priceBuy = priceBuy;
        this.priceSell = priceSell;
    }
    String name;
    int priceBuy;
    int priceSell;

    boolean doesSpoil;
    int freshness;

    @Override
    public int sell() {
        return priceSell - priceBuy;
    }
}

class Fruit extends Product {
    Fruit(String name, int priceBuy, int priceSell) {
        super(name, priceBuy, priceSell);
        doesSpoil = true;
        freshness = 1;
    }
}

class Vegetable extends Product {
    Vegetable(String name, int priceBuy, int priceSell) {
        super(name, priceBuy, priceSell);
        doesSpoil = true;
        freshness = 2;
    }
}

class Appliance extends Product {
    Appliance(String name, int priceBuy, int priceSell) {
        super(name, priceBuy, priceSell);
    }
}
