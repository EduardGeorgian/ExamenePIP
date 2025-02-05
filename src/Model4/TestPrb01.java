package Model4;

public class TestPrb01 {
    static public class Drum{
        public final String id;
        public final Short nr_benzi;

        public Drum(String id, Short nr_benzi) {
            this.id = id;
            this.nr_benzi = nr_benzi;
        }
    }

    public TestPrb01(){}

    public static void main(String[] args) {
        Drum drum=new Drum("1",(short)2);
        Tip3Drumuri tip3Drumuri=new Tip3Drumuri("Tudor",true);
        Tip4Drumuri tip4Drumuri=new Tip4Drumuri("Bucsinescu",false);

        tip4Drumuri.addDrum(drum);

        try{
            tip4Drumuri.getDrum(1);
        }
        catch(Exception e){
            e.printStackTrace();
        }

        tip4Drumuri.printInfoIntersectie();
        tip4Drumuri.addDrum(drum);




    }
}
