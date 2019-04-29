package admitere;

public class FacultatePrivata extends Facultate {
    public FacultatePrivata(String nume, String speci, int locuri) {
        super(nume, speci, locuri);
    }

    @Override
    public double calculeazaMediaIntrare(double MedieBac, double MedieAdmitere){
        return (MedieAdmitere*30 + MedieBac*70)/100;
    }

    @Override
    public void printInformatii(String path){
        ServiceOutput s = new ServiceOutput();
        s.printStringFacultate(path,"\n-------Informatii pentru facultatea privata--------- \n");
        super.printInformatii(path);
    }
}
