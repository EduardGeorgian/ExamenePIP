package Model4;

import org.w3c.dom.Text;

public class Tip4Drumuri extends Intersectie{
    public Tip4Drumuri(String id){
        super(id,null);
    }
    public Tip4Drumuri(String id, Boolean cu_dirijatie){
        super(id,cu_dirijatie);
    }
    public void printInfoIntersectie(){
        for(Object obj:drumuri){
            if(obj!=null)
            System.out.println(" Drum: "+((TestPrb01.Drum)obj).id+" cu benzi: " + ((TestPrb01.Drum) obj).nr_benzi);
        }
    }

    public TestPrb01.Drum getDrum(int poz){
        return null;
    }

    @Override
    public Boolean addDrum(TestPrb01.Drum drum) {
        System.out.println("Mesaj");
        for(int i=0;i<drumuri.length;i++){
            if(drumuri[i]==null){
                drumuri[i]=drum;
                return true;
            }
        }
        return false;
    }
}
