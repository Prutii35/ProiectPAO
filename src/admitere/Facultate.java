package admitere;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public abstract class Facultate {

    private String NumeFacultate;
    private String Specializare;
    private final int NumarLocuri;

    private Queue <Candidat> listaRespinsi;
    protected ListaCandidatiAdmisi listaAdmisi;
    protected ListaCandidati listaCandidati;

    public String getNumeFacultate() {
        return NumeFacultate;
    }

    public String getSpecializare() {
        return Specializare;
    }

    public int getNumarLocuri() {
        return NumarLocuri;
    }

    public abstract double calculeazaMediaIntrare(double MedieBac, double MedieAdmitere);

    public Facultate(String nume, String speci, int locuri){
        this.NumeFacultate = nume;
        this.Specializare = speci;

        this.NumarLocuri = locuri;

        this.listaCandidati = new ListaCandidati();
        this.listaAdmisi = new ListaCandidatiAdmisi(locuri);
        this.listaRespinsi = new LinkedList<Candidat>();
    }

    public Facultate(){

        Scanner reader = new Scanner(System.in);

        System.out.println("Numele Facultatii : ");
        this.NumeFacultate = reader.nextLine();

        System.out.println("Specializarea : ");
        this.Specializare = reader.nextLine();

        System.out.println("Numar locuri : ");
        this.NumarLocuri = reader.nextInt();

        this.listaCandidati = new ListaCandidati();
        this.listaAdmisi = new ListaCandidatiAdmisi(this.NumarLocuri);
        this.listaRespinsi =  new LinkedList<Candidat>();
    }

    public void printInformatii(){
        System.out.println("Nume Facultate : " + this.NumeFacultate);
        System.out.println("Specializare : " + this.Specializare);
        System.out.println("Numar de locuri disponibile : " + this.NumarLocuri);
        System.out.println(" \n\n ");
    }

    public void setListaAdmisiRespinsi(){
        if(listaCandidati.locuriOcupate != 0) {
            for (int i = 0; i < this.NumarLocuri; i++) {
                this.listaAdmisi.adaugaCandidat(this.listaCandidati.lista.get(i));
            }
            for (int i = this.NumarLocuri; i < this.listaCandidati.lista.size(); i++) {
                this.listaRespinsi.add(this.listaCandidati.lista.get(i));
            }
        }
        else{
            System.out.println("\nNu se poate sorta lista de candidati deoarece nu au aplicat candidati la facultatea " + this.NumeFacultate + "! \n");
        }
    }

    public void sortByMedie(){
        listaCandidati.sortByMedieIntrare();
    }

//Functii pentru lista de candidati
    public void adaugaCandidat(Candidat candidat){
        listaCandidati.adaugaCandidat(candidat);
    }

    public void eliminaCandidat(int poz) {
        listaCandidati.eliminaCandidat(poz);
    }

    public Candidat getCandidat(int poz){
        return listaCandidati.getCandidatI(poz);
    }

    public void afiseazaCandidati(){
        if(NumarLocuri != 0) {
            if (listaCandidati.locuriOcupate != 0) {
                System.out.println("\n -----Lista candidati pentru facultatea " + this.NumeFacultate + "-----\n");
                listaCandidati.afiseazaCandidati();
            } else {
                System.out.println("\nNu sunt candidati la facultatea " + this.NumeFacultate);
            }
        }
        else{
            System.out.println("\nFacultatea " +this.NumeFacultate + " nu are locuri");
        }
    }

//Functii pentru lista de admisi

    public void adaugaCandidatAdmis(Candidat candidat){
        listaAdmisi.adaugaCandidat(candidat);
    }

    public void eliminaCandidatAdmis(int poz){
        listaAdmisi.eliminaCandidat(poz);
    }

    public Candidat getCandidatAdmis(int poz){
        return listaAdmisi.getCandidatI(poz);
    }

    public void afiseazaAdmisi(){
        if(listaAdmisi.locuriOcupate != 0) {
            System.out.println("\n -----Lista candidati admisi pentru facultatea " + this.getNumeFacultate() + "-----\n");
            listaAdmisi.afiseazaCandidati();
        }
        else{
            System.out.println("Nu sunt candidati admisi la facultatea " + this.getNumeFacultate());
        }
    }

//Functii pentru lista de Respinsi

    public void adaugaCandidatRespins(Candidat candidat){
        listaRespinsi.add(candidat);
    }

    public Candidat eliminaCandidatRespins(){
        return listaRespinsi.poll();
    }

    public void afiseazaRespinsi(){
        if(listaRespinsi.size() != 0 ) {
            System.out.println("\n ------Lista candidati respinsi pentru facultatea " + this.NumeFacultate + "------\n");
            for (Candidat c : listaRespinsi) {
                c.printeazaInformatii();
            }
        }
        else{
            System.out.println("Nu sunt candidati respinsi la facultatea " + this.NumeFacultate);
        }
    }
}
