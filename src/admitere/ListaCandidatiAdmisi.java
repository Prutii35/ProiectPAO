package admitere;

import java.util.ArrayList;
import java.util.List;

public class ListaCandidatiAdmisi extends ListaCandidati {

    private final int locuriDisponibile;

    public ListaCandidatiAdmisi(int locuriDisponibile){
        super();
        this.locuriDisponibile = locuriDisponibile;
    }

    @Override
    public void adaugaCandidat(Candidat candidat){
        if(locuriOcupate < locuriDisponibile){
            lista.add(locuriOcupate, candidat);
            locuriOcupate++;
        }
        else{
            System.out.println("Nu mai sunt locuri disponibile momentan");
        }
    }
    @Override
    public void afiseazaCandidati(){
        System.out.println("---------Lista candidati admisi ---------");
        super.afiseazaCandidati();
    }
}
