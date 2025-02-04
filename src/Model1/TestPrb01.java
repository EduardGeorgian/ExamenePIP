package Model1;

public class TestPrb01 {
    public TestPrb01() {}
    public static void main(String[] args) {
        //am declarat aici, in scope ul main ului studentii pentru ca in blocul try erau out of scope
        //pentru a putea fi introdusi in grupa
        Disciplina.Student student1 = null;
        Disciplina.Student student2 = null;
        Disciplina.Student student3 = null;
        try {
            student1 = new Disciplina.Student("Ionescu", 7, 8);
            student2 = new Disciplina.Student("Popescu", 5, 5);
            student3 = new Disciplina.Student("Georgescu", 4, 4);
        } catch (Exception e) {
            System.out.println("Date invalide la Student");
        }

        Disciplina disciplina1 = new Disciplina("Istorie", "Grea");
        disciplina1.grupa[0] = student1;
        disciplina1.grupa[1] = student2;
        disciplina1.grupa[2] = student3;

        for(int i=0;i<disciplina1.grupa.length;i++){
            if(disciplina1.grupa[i]!=null)
                System.out.println(disciplina1.grupa[i].toString());
        }


    }
}
