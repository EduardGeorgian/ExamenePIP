package Model1;

public class Disciplina {
    private String numeDisciplina;
    private String tipDisciplina;
    Student[] grupa=new Student[10];

    public Disciplina(String numeDisciplina, String tipDisciplina) {
        this.numeDisciplina = numeDisciplina;
        this.tipDisciplina = tipDisciplina;
    }

    //clasa statica deoarece ca sa construim un obiect student am avea nevoie de un obiect disciplina mai intai
    static class Student implements NoteCatalog{
        public String numeStudent;
        private int notaLaborator;
        private int notaExamen;

        Student(String numeStudent,int notaLaborator, int notaExamen) throws Exception {
            this.notaLaborator = notaLaborator;
            this.notaExamen = notaExamen;
            this.numeStudent = numeStudent;
            if((notaLaborator>10 || notaLaborator<1)||(notaExamen>10 || notaExamen<1)){
                throw new Exception();
            }
        }

        @Override
        public int getNotaLaborator() {
            return this.notaLaborator;
        }

        @Override
        public int getNotaExamen() {
            return this.notaExamen;
        }

        @Override
        public String toString() {
            return "Student "+this.numeStudent+ " are notele "+this.notaLaborator+" " +this.notaExamen;
        }
    }

}
