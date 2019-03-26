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

    public Candidat(){
        Scanner reader = new Scanner(System.in);

        String tipFacultate;
        double nota1Bac, nota2Bac, nota3Bac, nota1Admitere, nota2Admitere;

        System.out.println("Nume Candidat :");
        this.Nume = reader.nextLine();

        System.out.println("Prenume Candidat : ");
        this.Prenume = reader.nextLine();

        System.out.println("Nota la prima proba la Bac : ");
        nota1Bac = reader.nextInt();

        System.out.println("Nota la a doua proba la Bac : ");
        nota2Bac = reader.nextInt();

        System.out.println("Nota la a treia proba la Bac : ");
        nota3Bac = reader.nextInt();

        this.Bac = new ExamenBac(nota1Bac,nota2Bac,nota3Bac);

        System.out.println("Nota la prima proba la Admitere : ");
        nota1Admitere = reader.nextInt();

        System.out.println("Nota la a doua proba la Admitere : ");
        nota2Admitere = reader.nextInt(); reader.nextLine();

        this.Admitere = new ExamenAdmitere(nota1Admitere,nota2Admitere);

        System.out.println("La ce facultate aplica : stat(true) sau privata(false)");
        tipFacultate = reader.nextLine();

        if(tipFacultate.equals("stat")){
            this.tipFacultate = 1;
        }
        else if(tipFacultate.equals("privata")) {
            this.tipFacultate = 0;
        }
        else{
            System.out.println("Nu exista facultatea respectiva");
            this.tipFacultate = 3;
        }
    }

    public String getNume() { return Nume; }

    public String getPrenume() { return Prenume; }

    public int getTipFacultate() { return tipFacultate; }

    public void setRezultat(boolean rez){ this.rezultat = rez; }

    public void setMedieIntrare(double medie) {this.medieIntrare = medie; }

    public double getMedieIntrare() { return medieIntrare; }

    public double getMedieBac() { return Bac.getMedie(); }

    public double getMedieAdmitere() { return Admitere.getMedieAdmitere(); }

    public void printeazaInformatii(){
        System.out.println("Nume : " + this.Nume);
        System.out.println("Prenume : " + this.Prenume);
        System.out.println("Medie Bac : " + this.Bac.getMedie());
        System.out.println("Medie Admitere : "+ this.Admitere.getMedieAdmitere());
        System.out.println("Tipul de facultate : " + (this.tipFacultate==1 ? "De Stat" : "Privata"));
    }

    @Override
    public int compareTo(Candidat c) {
        double medieIntrare1=((Candidat)c).getMedieIntrare();
        return -(Double.compare(this.medieIntrare,medieIntrare1));
    }

}
