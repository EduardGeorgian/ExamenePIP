package Model3;

public class TestPrb01 {
    public static void main(String[] args) {
        Intersectie.Drum drum=new Intersectie.Drum("1",(short)4);
        Tip3Cai tip3Cai=new Tip3Cai("Bucsinescu",true);
        Tip4Cai tip4Cai=new Tip4Cai("Tudor Vladimirescu",true);

        tip3Cai.addDrum(drum);

        try {
            tip3Cai.getDrum(1);
        }
        catch (RuntimeException e) {
            System.out.println("pozitii libere, exceptia activata");
        }

        tip3Cai.printInfoIntersectie();

        tip3Cai.getDrum(1);

    }
}
