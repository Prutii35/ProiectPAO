//Am pus doar 2 facultati pentru a nu complica proiectul foarte mult dar se pot utiliza si mai multe facultati
//Exista doar 2 tipuri de facultati de stat si privata
//Convetie : prima facultate este de stat, iar a doua privata
//Conventie : atunci cand se decide la ce facultate aplica candidatul -> stat sau privata
//Pentru etapa viitoare voi updata proiectul si voi face ca acesta sa isi aleaga din mai multe facultati
package admitere;

public class Main {
    public static void main(String[] args) {
        ServiceFacultate servici = new ServiceFacultate();

        servici.creeazaFaculttateStat();
        servici.prineazaInformatiiFacultateStat();

        servici.creeazFacultatePrivata();
        servici.printeazaInformatiiFacultatePrivata();

        servici.creeazaCandidat();
        servici.creeazaCandidat();
        servici.creeazaCandidat();
        servici.creeazaCandidat();

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
