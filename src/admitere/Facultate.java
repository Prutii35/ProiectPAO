package admitere;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public abstract class Facultate {

    protected String NumeFacultate;
    protected String Specializare;
    protected final int NumarLocuri;

    protected Queue <Candidat> listaRespinsi;
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

    public void printInformatii(String path){
        ServiceOutput s = new ServiceOutput();
        s.printeazaInformatiiFacultate(path,this.NumeFacultate,this.Specializare,this.NumarLocuri);
    }

    public void setListaAdmisiRespinsi(){
        if(listaCandidati.locuriOcupate != 0) {
            for(int i = 0 ; i< listaCandidati.locuriOcupate ; i++){
                if( i < this.NumarLocuri){
                    this.listaAdmisi.adaugaCandidat(this.listaCandidati.lista.get(i));
                }
                else{
                    this.listaRespinsi.add(this.listaCandidati.lista.get(i));
                }
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

    public void afiseazaCandidati(String path){
        if(NumarLocuri != 0) {
            if (listaCandidati.locuriOcupate != 0) {
                ServiceOutput s = new ServiceOutput();
                s.printString(path,"\n -----Lista candidati pentru facultate------\n");
                listaCandidati.afiseazaCandidati(path);
            } else {
                ServiceOutput s = new ServiceOutput();
                String string = "\nNu sunt candidati la facultatea " + this.NumeFacultate;
                s.printString(path,string);
            }
        }
        else{
            ServiceOutput s = new ServiceOutput();
            String string = "\nFacultatea " +this.NumeFacultate + " nu are locuri";
            s.printString(path,string);
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

    public void afiseazaAdmisi(String path){
        if(listaAdmisi.locuriOcupate != 0) {
            ServiceOutput s = new ServiceOutput();
            s.printString(path,"\n\n ------Lista candidati admisi pentru facultatea--------\n\n ");
            listaAdmisi.afiseazaCandidati(path);
        }
        else{
            ServiceOutput s = new ServiceOutput();
            String string = "Nu sunt candidati admisi la facultatea " + this.getNumeFacultate();
            s.printString(path,string);
        }
    }

//Functii pentru lista de Respinsi

    public void adaugaCandidatRespins(Candidat candidat){
        listaRespinsi.add(candidat);
    }

    public Candidat eliminaCandidatRespins(){
        return listaRespinsi.poll();
    }

    public void afiseazaRespinsi(String path){
        if(listaRespinsi.size() != 0 ) {
            ServiceOutput s = new ServiceOutput();
            s.printString(path,"\n ------Lista candidati respinsi pentru facultatea--------\n ");
            for (Candidat c : listaRespinsi) {
                c.printeazaInformatii(path);
            }
        }
        else{
            ServiceOutput s = new ServiceOutput();
            String string = "Nu sunt candidati respinsi la facultatea " + this.NumeFacultate;
            s.printString(path,string);
        }
    }
}
