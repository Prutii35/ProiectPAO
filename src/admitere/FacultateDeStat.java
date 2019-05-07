package admitere;

import service.ServiceOutput;

public class FacultateDeStat extends Facultate {
    public FacultateDeStat(String nume, String speci, int locuri) {
        super(nume, speci, locuri);
    }

    @Override
    public double calculeazaMediaIntrare(double MedieBac, double MedieAdmitere){
        return (MedieAdmitere*60 + MedieBac*40)/100;
    }

    @Override
    public void printInformatii(String path){
        ServiceOutput s = new ServiceOutput();
        s.printStringFacultate(path,"\n---------Informatii pentru facultatea de stat--------");
        super.printInformatii(path);
    }

}
