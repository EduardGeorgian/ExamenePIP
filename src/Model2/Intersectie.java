package Model2;

public class Intersectie {
    public final String id;
    public final Boolean cu_dirijatie;
    protected Object[] drumuri;

    public Intersectie(String id, Boolean cu_dirijatie) {
        this.id = id;
        this.cu_dirijatie = cu_dirijatie;
        drumuri=new Object[4];
    }

    public Boolean addDrum(TestPrb01.Drum drum){
      for(int i=0;i<drumuri.length;i++){
          if(drumuri[i]==null) {
              drumuri[i] = drum;
              return true;
          }
          }
      return false;
    }

    public TestPrb01.Drum getDrum(int id) throws Exception{
      for(int i=0;i<drumuri.length;i++){
          if(drumuri[i]==null) {
              throw new Exception();
          }
      }
      return (TestPrb01.Drum)drumuri[id];
    }

    public void printInfoIntersectie(){}
}
