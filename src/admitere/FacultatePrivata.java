package admitere;

public class FacultatePrivata extends Facultate {
    public FacultatePrivata(String nume, String speci, int locuri) {
        super(nume, speci, locuri);
    }
    public FacultatePrivata() { super(); }

    @Override
    public double calculeazaMediaIntrare(double MedieBac, double MedieAdmitere){
        return (MedieAdmitere*30 + MedieBac*70)/100;
    }

    @Override
    public void printInformatii(){
        System.out.println("\nInformatii pentru facultatea privata : \n");
        super.printInformatii();
    }
}
