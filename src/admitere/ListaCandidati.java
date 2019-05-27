//M-am gandit ca la fiecare facultate lista de admitere este nelimitata asa ca nu ar avea rost sa tin o variabila pentru locurile disponibile
//ceea ce poate fi un pic de confuz deoarece daca facultatea are 0 locuri disponibile de la inceput, nu ar mai avea rost ca cineva sa aplice la ea
//dar asta se rezolva in clasa derivata numita ListaCandidatiAdmisi unde un candidat nu este admis daca nu sunt locuri disponibile

package admitere;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListaCandidati {

    protected List <Candidat> lista;

    protected int locuriOcupate;

    public List<Candidat> getLista() {
        return lista;
    }

    public int getLocuriOcupate() {
        return locuriOcupate;
    }

    public ListaCandidati(){
        lista = new ArrayList<Candidat>();
        locuriOcupate = 0;
    }

    public void adaugaCandidat(Candidat candidat){
        lista.add(locuriOcupate, candidat);
        locuriOcupate++;
    }

    public void eliminaCandidat(int poz){
        if(locuriOcupate > 0){
            lista.remove(poz);
            locuriOcupate--;
        }
    }

    public Candidat getCandidatI(int poz){
        return lista.get(poz);
    }

    public void sortByMedieIntrare(){
        Collections.sort(lista);
    }

    public void afiseazaCandidati(String path){
        for(int i = 0 ; i < locuriOcupate; i++){
            lista.get(i).printeazaInformatii(path);
        }
    }

}
