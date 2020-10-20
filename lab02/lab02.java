package lab02;

import java.util.Random;
import java.util.ArrayList;

class RandomArrayGenerator {
    public static ArrayList<Integer> generate(int size) {
        Random r = new Random();
         var res = new ArrayList<Integer>(size);
         for (Integer i: res) {
             i = r.nextInt(50);
         }
         return res;
    }
}

public class lab02 {

    static ArrayList<Integer> list = new ArrayList<Integer>(10);
    public static void main(String[] args) {
        var list = RandomArrayGenerator.generate(10);
        for (var i: list) {
            System.out.println(i);
        }
    }
}
