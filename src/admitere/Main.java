//Am pus doar 2 facultati pentru a nu complica proiectul foarte mult dar se pot utiliza si mai multe facultati
//Exista doar 2 tipuri de facultati de stat si privata


//fisier inout candidati : se vor da numele, prenumele , si cele 3 note de la bac si 2 de la admitere si facultatea la care aplica
//0 pentru stat 1 pentru privata

// fisierele input pentru facultati se vor da numele, specializarea si numarul delocuri disponibile

// in output pentru fiecare facultate se vor da lista de candidati(in oridine crescatoare dupa medie), lista de admisi si lista de respinsi
package admitere;

public class Main {
    public static void main(String[] args) {
        ServiceFacultate servici = new ServiceFacultate();

        servici.creeazaFaculttateStat();
        servici.prineazaInformatiiFacultateStat();

        servici.creeazFacultatePrivata();
        servici.printeazaInformatiiFacultatePrivata();

        servici.citesteCandidati();


        servici.sorteazaListaCandidati();

        //System.out.println("Lista sortata : ");
        servici.afiseazaCandidatiStat();
        servici.afiseazaCandidatiPrivat();

        servici.setListaAdmisiRespinsiStat();
        servici.afiseazaAdmisiStat();
        servici.afiseazaRespinsiStat();

        servici.setListaAdmisiRespinsiPrivata();
        servici.afiseazaAdmisiPrivata();
        servici.afiseazaRespinsiPrivata();
    }
}
