public class lab12 {
    public static void main(String[] args) {
        final String filename = "dic.txt";
        Dictionary d = new Dictionary(filename);

        if (args[0].equals("add")) {
            d.add(args[1], args[2]);
        }
        else if (args[0].equals("del")) {
            d.remove(args[1]);
        }
        else {
            String res = d.getTranslation(args[0]);
            if (res.isEmpty()) {
                System.err.printf("Brak slowa %s w słowniku...\n", args[0]);
            }
            else {
                System.out.println(res);
            }
        }
    }
}