package admitere;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ServiceFacultate {

    private Facultate facultateDeStat;
    private Facultate facultatePrivata;

    public void creeazaFaculttateStat(){

        Path p = Paths.get("data\\inputFacultateStat.csv");
        try (BufferedReader br = Files.newBufferedReader(p)) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                facultateDeStat = new FacultateDeStat(values[0],values[1],Integer.parseInt(values[2]));
            }
        } catch (IOException e) {
            System.out.println(":(");
        }
    }

    public void creeazFacultatePrivata(){
        Path p = Paths.get("data\\inputFacultatePrivata.csv");
        try (BufferedReader br = Files.newBufferedReader(p)) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                facultatePrivata = new FacultatePrivata(values[0],values[1],Integer.parseInt(values[2]));
            }
        } catch (IOException e) {
            System.out.println(":(");
        }
    }

    public void citesteCandidati(){
        Path p = Paths.get("data\\inputCandidati.csv");
        try (BufferedReader br = Files.newBufferedReader(p)) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

                Candidat candidatGeneral = new Candidat(values[0],values[1],
                        Double.parseDouble(values[2]),Double.parseDouble(values[3]),Double.parseDouble(values[4]),
                        Double.parseDouble(values[5]),Double.parseDouble(values[6]),Integer.parseInt(values[7]));

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
                    System.out.println("Candidatul " + candidatGeneral.getNume() + candidatGeneral.getPrenume() + "a aplicat la o facultate care nu exista");
                }
            }
        } catch (IOException e) {
            System.out.println(":(");
        }
    }
    public void prineazaInformatiiFacultateStat(){
        facultateDeStat.printInformatii("data\\outputFacultateStat.csv");
    }

    public void printeazaInformatiiFacultatePrivata(){
        facultatePrivata.printInformatii("data\\outputFacultatePrivata.csv");
    }



    public void sorteazaListaCandidati(){
        facultateDeStat.sortByMedie();
        facultatePrivata.sortByMedie();
    }

    public void afiseazaCandidatiStat(){
        facultateDeStat.afiseazaCandidati("data\\outputFacultateStat.csv");
    }

    public void afiseazaCandidatiPrivat(){
        facultatePrivata.afiseazaCandidati("data\\outputFacultatePrivata.csv");
    }

    public void setListaAdmisiRespinsiStat(){
        facultateDeStat.setListaAdmisiRespinsi();
    }

    public void setListaAdmisiRespinsiPrivata(){
        facultatePrivata.setListaAdmisiRespinsi();
    }

    public void afiseazaAdmisiStat(){
        facultateDeStat.afiseazaAdmisi("data\\outputFacultateStat.csv");
    }

    public void afiseazaRespinsiStat(){
        facultateDeStat.afiseazaRespinsi("data\\outputFacultateStat.csv");
    }

    public void afiseazaAdmisiPrivata(){
        facultatePrivata.afiseazaAdmisi("data\\outputFacultatePrivata.csv");
    }

    public void afiseazaRespinsiPrivata(){
        facultatePrivata.afiseazaRespinsi("data\\outputFacultatePrivata.csv");
    }
}
