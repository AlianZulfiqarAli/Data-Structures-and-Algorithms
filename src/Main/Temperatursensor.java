public class Temperatursensor {
    Ringpuffer<Float> sensor = new Ringpuffer<>(24);

    public void neueMessung(Float wert){
        try {
            sensor.addLast(wert);

        }catch (IndexOutOfBoundsException e){
            System.out.println("overwriting values!!");
            sensor.set(wert,0);
        }
    }

    public Float aktuelleTemperatur(){
        if (sensor.size() == 0)
            return Float.NaN;
        int i = 0;
        Float tmp = null;
        while (sensor.get(i) != null) {
            tmp = sensor.get(i++);
            if(i == 24){
                return sensor.get(0);
            }
        }
        return tmp;
    }

    public Float durchschnittsTemperatur(){
        if (sensor.size() == 0)
            return Float.NaN;
        int i = 0;
        Float tmp = 0f;
        while (sensor.get(i%23)!= null && i < 24)
            tmp += sensor.get(i++ % 23);
        return tmp/24;
    }

    public void reset(){
        sensor = new Ringpuffer<>(24);
    }

    public static void main(String[] args) {
        Temperatursensor tmp = new Temperatursensor();
        tmp.neueMessung(55f);
        tmp.neueMessung(52f);
        tmp.neueMessung(56f);
        tmp.neueMessung(58f);
        tmp.neueMessung(50f);
        tmp.neueMessung(54f);
        tmp.neueMessung(57f);
        tmp.neueMessung(53f);
        System.out.println(tmp.aktuelleTemperatur());
        System.out.println(tmp.durchschnittsTemperatur());
        tmp.reset();
        System.out.println(tmp.aktuelleTemperatur());
        for (float i = 0f; i <= 24f ; i++) {
            tmp.neueMessung(i);
        }
        System.out.println(tmp.aktuelleTemperatur());
        System.out.println(tmp.durchschnittsTemperatur());

    }

}
