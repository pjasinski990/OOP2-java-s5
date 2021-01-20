public class lab13 {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.exit(-1);
        }

        Serializer s = new Serializer();
        String fname1 = args[0];
        String fname2 = args[1];
        String extension1 = fname1.substring(fname1.indexOf('.') + 1);
        String extension2 = fname2.substring(fname2.indexOf('.') + 1);

        if (extension1.equals("txt") && extension2.equals("ser")) {
            s.serialize(fname1, fname2);
        }
        else if (extension1.equals("ser") && extension2.equals("txt")) {
            s.deserialize(fname1, fname2);
        }
    }
}
