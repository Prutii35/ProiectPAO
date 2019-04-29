package admitere;

import java.util.Scanner;

public class Candidat implements Comparable<Candidat> {

    private String Nume;
    private String Prenume;
    protected ExamenBac Bac;
    protected ExamenAdmitere Admitere;
    private int tipFacultate;//1 pt stat , 0 pt privata

    private boolean rezultat; //true pt admis , false pt respins
    private double medieIntrare;

    public Candidat(String nume, String prenume,double notaBac1,double notaBac2,double notaBac3,double notaAd1,double notaAd2,int tip) {
        this.Nume = nume;
        this.Prenume = prenume;
        this.Bac = new ExamenBac(notaBac1,notaBac2,notaBac3);
        this.Admitere = new ExamenAdmitere(notaAd1,notaAd2);
        this.tipFacultate = tip;
    }

    public String getNume() { return Nume; }

    public String getPrenume() { return Prenume; }

    public int getTipFacultate() { return tipFacultate; }

    public void setRezultat(boolean rez){ this.rezultat = rez; }

    public void setMedieIntrare(double medie) {this.medieIntrare = medie; }

    public double getMedieIntrare() { return medieIntrare; }

    public double getMedieBac() { return Bac.getMedie(); }

    public double getMedieAdmitere() { return Admitere.getMedieAdmitere(); }

    public void printeazaInformatii(String path){
        ServiceOutput s = new ServiceOutput();
        s.printeazaInformatiiCandidati(path,this.Nume,this.Prenume,this.Bac.getMedie(),this.Admitere.getMedieAdmitere(),this.tipFacultate);
    }

    @Override
    public int compareTo(Candidat c) {
        double medieIntrare1=((Candidat)c).getMedieIntrare();
        return -(Double.compare(this.medieIntrare,medieIntrare1));
    }

}
