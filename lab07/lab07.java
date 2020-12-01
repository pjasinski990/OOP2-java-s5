public class lab07
{

    //Tej metody nie wolno zmieniać!!!! (Resztę pliku wolno).
    public static void main(String[] args) {
        System.out.printf("2.2 + 2.2 = %f%n", calculate((double v1, double v2) -> v1 + v2, 2.2, 2.2));
        System.out.printf("44 / 2.0 = %f%n", calculate((v1, v2) -> v1 / v2, 44, 2.0));
        System.out.printf("-66 = %f%n", calculate(v -> -v, 66));
        System.out.printf("8 * 8 = %f%n", calculate((double v) -> v * v, 8));

        //Uwaga! Klasa Add MUSI zawierać tylko jedną funkcję!!!!
        Add oblicz = new Add();
        oblicz.add(1, 2);
        oblicz.add(1, 2, 3);
        oblicz.add(1, 2, 3, 4, 5);
        oblicz.add(1, 2, 3, 4, 5, 6);
    }

    static double calculate(TwoArgsOperable e, double val1, double val2) {
        return e.operate(val1, val2);
    }
    static double calculate(OneArgOperable e, double val) {
        return e.operate(val);
    }
}

interface OneArgOperable {
    double operate(double val1);
}

interface TwoArgsOperable {
    double operate(double val1, double val2);
}

class Add {
    double add(int val1, int... args) {
        int res = val1;
        StringBuilder sb = new StringBuilder(Integer.toString(val1));
        for (var d: args) {
            res += d;
            sb.append("+").append(d);
        }
        sb.append("=").append(res);
        System.out.println(sb.toString());
        return res;
    }
}

/*
Wyjście z programu wygląda tak:

2.2 + 2.2 = 4,400000
44 / 2.0 = 22,000000
-66 = -66,000000
8 * 8 = 64,000000
1+2=3
1+2+3=6
1+2+3+4+5=15
1+2+3+4+5+6=21
*/