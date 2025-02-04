package Model2;

public class TestPrb01 {
    public static class Drum{
        public final String id;
        public final Short nr_benzi;

        public Drum(String id, Short nr_benzi) {
            this.id = id;
            this.nr_benzi = nr_benzi;
        }
    }
    public static void main(String[] args) {
        Drum drum=new Drum("1",(short)2);
        Tip3Cai tip3cai=new Tip3Cai("Tudor",true);
        Tip4Cai tip4cai=new Tip4Cai("Bucsinescu",false);

        tip4cai.addDrum(drum); //popularea unei intersectii de tip4cai

        try{
        tip4cai.getDrum(1);
        }
        catch(Exception e){
            System.out.println("Una sau mai multe pozitii libere in masiv");
        }

        tip4cai.printInfoIntersectie();
        tip4cai.getDrum(1);




    }
}
