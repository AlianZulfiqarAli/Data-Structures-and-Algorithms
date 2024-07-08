
public class SpeicherPaar {
    public static void main(String[] args) {

        Speicher<Paar<Student,String>> servicePoint = new WarteschlangeMitArray<>(5);
        Speicher<Paar<Boxer,Boxer>> boxEvent = new KellerspeicherMitArray<>(5);

        //_____________________
        //push to servicePoint
        //    push( Paar( Student, String ) )
        //_____________________
        servicePoint.push(
                new Paar<>(
                        new Student("foo","bar",1),
                        "Wo finde ich meine matNummer?"
                )
        );

        servicePoint.push(
                new Paar<>(
                        new Student("man","boy", 2),
                        "Wo ist die Mensa?"
                )
        );

        servicePoint.push(
                new Paar<>(new Student("baz","koo", 3),
                        "wie heisse ich?"
                )
        );
        //_____________________
        //push to Boxevent
        //      push( Paar( Boxer, Boxer ) )
        //_____________________
        boxEvent.push(
                new Paar<>(new Boxer("Ali","Mohammed",90),
                        new Boxer("hund","katze",80))
        );


        boxEvent.push(
                new Paar<>(new Boxer("foo","baz",80),
                        new Boxer("flop","fies",180))
        );

        boxEvent.push(
                new Paar<>(new Boxer("mas","mus",8000),
                        new Boxer("kloos","laaak",50))
        );


        System.out.println("Service Point Fragen:");
        while(!servicePoint.isEmpty()){
            System.out.println(servicePoint.pop());
        }

        System.out.println("\nUpcoming Boxing Events:");
        while(!boxEvent.isEmpty()){
            System.out.println(boxEvent.pop());
        }
    }
}