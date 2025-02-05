package Model3;

public class Tip3Cai extends Intersectie{
    public Tip3Cai(String id, Boolean cu_dirijatie){
        super(id, cu_dirijatie);
    }

    public Tip3Cai(String id){
        super(id,null);
    }

    public void printInfoIntersectie(){
        for(Drum drum:drumuri){
            if(drum!=null){
                System.out.println("Drum cu id: "+drum.id+" si nr.benzi: "+drum.nr_benzi);
            }
        }
    }

    @Override
    public Object getDrum(int poz){
        if(drumuri[poz]==null){
            return null;
        }
        else return drumuri[poz];
    }
}
