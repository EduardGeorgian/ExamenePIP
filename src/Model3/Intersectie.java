package Model3;

public class Intersectie {
    public final String id;
    public final Boolean cu_dirijatie;
    protected Drum[] drumuri;

    static class Drum{
        public final String id;
        public final Short nr_benzi;

        public Drum(String id, Short nr_benzi) {
            this.id = id;
            this.nr_benzi = nr_benzi;
        }
    }

    public Intersectie(String id, Boolean cu_dirijatie) {
        this.id = id;
        this.cu_dirijatie = cu_dirijatie;
        drumuri=new Drum[4];
    }

    public Boolean addDrum(Drum drum){
        for(int i=0;i<drumuri.length;i++){
            if(drumuri[i]==null){
                drumuri[i]=drum;
                return true;
            }
        }
        return false;
    }

    public Object getDrum(int poz)throws RuntimeException{
        for(int i=0;i<drumuri.length;i++){
            if(drumuri[i]==null){
                throw new RuntimeException();
            }
        }
        return drumuri[poz];
    }
}
