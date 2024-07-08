public class Timetest {

    public static void main(String[] args) {
        long start, finish, elapsed;

        WarteschlangeMitArray<Integer> wsMa = new WarteschlangeMitArray<>(100000);
        WarteschlangeMitEVL<Integer> wsMl = new WarteschlangeMitEVL<>();
        SchlangeMitRing<Integer> smr = new SchlangeMitRing<>(100000);
        SchlangeMitEVL<Integer> smwvl = new SchlangeMitEVL<>();

        //-------------------------------WarteschlangeMitArray-------------------------------
        start =  System.currentTimeMillis();
        for (int i = 0; i < 100000; i++){
            wsMa.push(i);
        }
        finish = System.currentTimeMillis();
        elapsed = finish - start;
        System.out.println("WarteschlangeMitArray push: " + (double)elapsed/1000 + "s");

        start =  System.currentTimeMillis();
        for (int i = 0; i < 100000; i++){
            wsMa.pop();
        }
        finish = System.currentTimeMillis();
        elapsed = finish - start;
        System.out.println("WarteschlangeMitArray pop: " + (double)elapsed/1000 + "s");
        //-------------------------------WarteschlangeMitArray-------------------------------

        //-------------------------------WarteschlangeMitEVL-------------------------------
        start =  System.currentTimeMillis();
        for (int i = 0; i < 100000; i++){
            wsMl.push(i);
        }
        finish = System.currentTimeMillis();
        elapsed = finish - start;
        System.out.println("WarteschlangeMitEVL push: " + (double)elapsed/1000 + "s");

        start =  System.currentTimeMillis();
        for (int i = 0; i < 100000; i++){
            wsMl.pop();
        }
        finish = System.currentTimeMillis();
        elapsed = finish - start;
        System.out.println("WarteschlangeMitEVL pop: " + (double)elapsed/1000 + "s");
        //-------------------------------WarteschlangeMitEVL-------------------------------


        //-------------------------------SchlangeMitRing-------------------------------
        start =  System.currentTimeMillis();
        for (int i = 0; i < 100000; i++){
            smr.insert(i);
        }
        finish = System.currentTimeMillis();
        elapsed = finish - start;
        System.out.println("SchlangeMitRing insert: " + (double)elapsed/1000 + "s");

        start =  System.currentTimeMillis();
        for (int i = 0; i < 100000; i++){
            smr.remove();
        }
        finish = System.currentTimeMillis();
        elapsed = finish - start;
        System.out.println("SchlangeMitRing remove: " + (double)elapsed/1000 + "s");
        //-------------------------------SchlangeMitRing-------------------------------

        //-------------------------------SchlangeMitEVL-------------------------------

        start =  System.currentTimeMillis();
        for (int i = 0; i < 100000; i++){
            smwvl.insert(i);
        }
        finish = System.currentTimeMillis();
        elapsed = finish - start;
        System.out.println("SchlangeMitEVL insert: " + (double)elapsed/1000 + "s");

        start =  System.currentTimeMillis();
        for (int i = 0; i < 100000; i++){
            smwvl.remove();
        }
        finish = System.currentTimeMillis();
        elapsed = finish - start;
        System.out.println("SchlangeMitEVL remove: " + (double)elapsed/1000 + "s");
        //-------------------------------SchlangeMitEVL-------------------------------



    }
}
