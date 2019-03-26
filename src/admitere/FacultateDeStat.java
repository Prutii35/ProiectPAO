package admitere;

public class FacultateDeStat extends Facultate {
    public FacultateDeStat(String nume, String speci, int locuri) {
        super(nume, speci, locuri);
    }
    public FacultateDeStat() { super();}

    @Override
    public double calculeazaMediaIntrare(double MedieBac, double MedieAdmitere){
        return (MedieAdmitere*60 + MedieBac*40)/100;
    }

    @Override
    public void printInformatii(){
        System.out.println("\nInformatii pentru facultatea de stat : \n");
        super.printInformatii();
    }
}
