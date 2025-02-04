package Model2;

public class Tip4Cai extends Intersectie{
    public Tip4Cai(String identificator_unic){
        super(identificator_unic,false);
    }
    public Tip4Cai(String identificator_unic,Boolean cu_dirijatie){
        super(identificator_unic,cu_dirijatie);
    }

    @Override
    public void printInfoIntersectie(){
        for(Object drum:this.drumuri){
            if(drum!=null){
                TestPrb01.Drum drum_=(TestPrb01.Drum)drum;
                System.out.println("Drumul cu id: "+drum_.id+" si numar de benzi: "+drum_.nr_benzi);
            }
        }
    }

    @Override
    public TestPrb01.Drum getDrum(int id){
        for(Object drum:this.drumuri){
            if(drum!=null){
                return (TestPrb01.Drum)drum;
            }
        }
        return null;
    }
}
