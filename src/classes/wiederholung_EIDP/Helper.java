public class Helper {

    public static void move (IntegerBuffer quelle, IntegerBuffer ziel) throws Exception {
        while (quelle.size() != 0 ) {
            ziel.push(quelle.pop());
        }
    }
}
