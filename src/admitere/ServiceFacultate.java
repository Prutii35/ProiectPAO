package admitere;

public class ServiceFacultate {

    private Facultate facultateDeStat;
    private Facultate facultatePrivata;

    public void creeazaFaculttateStat(){
        facultateDeStat = new FacultateDeStat();
    }

    public void creeazFacultatePrivata(){
        facultatePrivata = new FacultatePrivata();
    }

    public void prineazaInformatiiFacultateStat(){
        facultateDeStat.printInformatii();
    }

    public void printeazaInformatiiFacultatePrivata(){
        facultatePrivata.printInformatii();
    }

    public void creeazaCandidat(){
        Candidat candidatGeneral = new Candidat();

        if(candidatGeneral.getTipFacultate() == 1){
            double medieIntrare = facultateDeStat.calculeazaMediaIntrare(candidatGeneral.getMedieBac(),candidatGeneral.getMedieAdmitere());
            candidatGeneral.setMedieIntrare(medieIntrare);
            facultateDeStat.adaugaCandidat(candidatGeneral);
        }
        else if(candidatGeneral.getTipFacultate() == 0 ) {
            double medieIntrare = facultatePrivata.calculeazaMediaIntrare(candidatGeneral.getMedieBac(),candidatGeneral.getMedieAdmitere());
            candidatGeneral.setMedieIntrare(medieIntrare);
            facultatePrivata.adaugaCandidat(candidatGeneral);
        }
        else{
            System.out.println("Nu exista facultatea respectiva");
        }
    }

    public void sorteazaListaCandidati(){
        facultateDeStat.sortByMedie();
        facultatePrivata.sortByMedie();
    }

    public void afiseazaCandidatiStat(){
        facultateDeStat.afiseazaCandidati();
    }

    public void afiseazaCandidatiPrivat(){
        facultatePrivata.afiseazaCandidati();
    }

    public void setListaAdmisiRespinsiStat(){
        facultateDeStat.setListaAdmisiRespinsi();
    }

    public void setListaAdmisiRespinsiPrivata(){
        facultatePrivata.setListaAdmisiRespinsi();
    }

    public void afiseazaAdmisiStat(){
        facultateDeStat.afiseazaAdmisi();
    }

    public void afiseazaRespinsiStat(){
        facultateDeStat.afiseazaRespinsi();
    }

    public void afiseazaAdmisiPrivata(){
        facultatePrivata.afiseazaAdmisi();
    }

    public void afiseazaRespinsiPrivata(){
        facultatePrivata.afiseazaRespinsi();
    }
}
