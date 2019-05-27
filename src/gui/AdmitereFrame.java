package gui;

import admitere.Candidat;
import admitere.FacultateDeStat;
import admitere.FacultatePrivata;
import repositories.FacultateRepo;
import service.ServiceFacultate;
import service.ServiceOutput;

import java.awt.*;

import javax.swing.*;

public class AdmitereFrame extends JFrame{

    private ServiceFacultate serviceFacultate = new ServiceFacultate();
    private FacultateRepo repo = new FacultateRepo();

    private JPanel p1 = new JPanel();
    private GridBagConstraints c = new GridBagConstraints();

    private JButton b2 = new JButton("Creeaza Facultate privata");
    private JButton b1 = new JButton("Creeaza Facultate de stat");
    private JButton b3 = new JButton("Adauga Candidati");
    private JButton b4 = new JButton("Rezultate Admitere");
    private JButton b5 = new JButton("Gestionare candidati");

    public AdmitereFrame(){

        super("Admitere Facultate"); // TITLU

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600,600);
        setLocationRelativeTo(null);

        p1.setLayout(new GridBagLayout());
        add(p1);


        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 15;
        c.gridx = 0;
        c.gridy = 0;
        p1.add(b2,c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 15;
        c.weightx = 0.5;
        c.gridx = 2;
        c.gridy = 0;
        p1.add(b1,c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 15;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 0;
        p1.add(b5,c);
        b5.setEnabled(false);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 40;      //make this component tall
        c.weightx = 0.0;
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 1;
        p1.add(b3,c);
        b3.setEnabled(false);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 15;
        c.weighty = 1.0;   //request any extra vertical space
        c.anchor = GridBagConstraints.PAGE_END; //bottom of space
        c.insets = new Insets(10,0,0,0);  //top padding
        c.gridx = 0;       //aligned with button 2
        c.gridy = 2;       //third row
        p1.add(b4,c);
        b4.setEnabled(false);

        b1.addActionListener(ev -> creeazaFacultateStat());
        b2.addActionListener(ev -> creeazaFacultatePrivata());
        b3.addActionListener(ev -> adaugaCandidati());
        b4.addActionListener(ev -> makeLists());
        b5.addActionListener(ev -> gestionareCandidati());

        setVisible(true);
    }

    public void creeazaFacultateStat(){
        JFrame j = new JFrame();

        j.setSize(600,200);
        j.setLayout(new FlowLayout());
        j.setLocationRelativeTo(null);
        j.setVisible(true);

        JLabel e1 = new JLabel("Nume:");
        JLabel e2 = new JLabel("Specializare:");
        JLabel e3 = new JLabel("Locuri:");
        JTextField t1 = new JTextField(10);
        JTextField t2 = new JTextField(10);
        JTextField t3 = new JTextField(10);
        JButton b = new JButton("ADAUGA");

        j.add(e1);
        j.add(t1);
        j.add(e2);
        j.add(t2);
        j.add(e3);
        j.add(t3);
        j.add(b);

        b.addActionListener(ev -> {

            String nume = t1.getText();
            String specializare = t2.getText();
            Integer locuri = Integer.parseInt(t3.getText());

            t1.setText(null);
            t2.setText(null);
            t3.setText(null);

            serviceFacultate.JDBCcreeazaFacultateStat(nume,specializare,locuri);

            repo.adaugaFacultate(
                    serviceFacultate.getFacultateDeStat().getNumeFacultate(),
                    serviceFacultate.getFacultateDeStat().getSpecializare(),
                    serviceFacultate.getFacultateDeStat().getNumarLocuri());

            j.dispose();
            b1.setEnabled(false);

            if(!b2.isEnabled()){
                b3.setEnabled(true);
            }
        });
    }

    public void creeazaFacultatePrivata(){

        JFrame j = new JFrame();

        j.setSize(600,200);
        j.setLayout(new FlowLayout());
        j.setLocationRelativeTo(null);
        j.setVisible(true);

        JLabel e1 = new JLabel("Nume:");
        JLabel e2 = new JLabel("Specializare:");
        JLabel e3 = new JLabel("Locuri:");
        JTextField t1 = new JTextField(10);
        JTextField t2 = new JTextField(10);
        JTextField t3 = new JTextField(10);
        JButton b = new JButton("ADAUGA");

        j.add(e1);
        j.add(t1);
        j.add(e2);
        j.add(t2);
        j.add(e3);
        j.add(t3);
        j.add(b);

        b.addActionListener(ev -> {

            String nume = t1.getText();
            String specializare = t2.getText();
            Integer locuri = Integer.parseInt(t3.getText());

            t1.setText(null);
            t2.setText(null);
            t3.setText(null);

            serviceFacultate.JDBCCreaazaFacultatePrivata(nume,specializare,locuri);

            repo.adaugaFacultate(
                    serviceFacultate.getFacultatePrivata().getNumeFacultate(),
                    serviceFacultate.getFacultatePrivata().getSpecializare(),
                    serviceFacultate.getFacultatePrivata().getNumarLocuri());

            j.dispose();
            b2.setEnabled(false);

            if(!b1.isEnabled()){
                b3.setEnabled(true);
            }
        });

    }

    public void adaugaCandidati(){
        serviceFacultate.citesteCandidati();

        for(int i = 0 ;i<serviceFacultate.getFacultateDeStat().getListaCandidati().getLista().size() ;i ++){
            repo.adaugaCandidat(serviceFacultate.getFacultateDeStat().getListaCandidati().getCandidatI(i));
        }

        for(int i = 0 ;i<serviceFacultate.getFacultatePrivata().getListaCandidati().getLista().size() ;i ++){
            repo.adaugaCandidat(serviceFacultate.getFacultatePrivata().getListaCandidati().getCandidatI(i));
        }
        b3.setEnabled(false);
        b4.setEnabled(true);
    }

    public void makeLists(){

        serviceFacultate.prineazaInformatiiFacultateStat();
        serviceFacultate.printeazaInformatiiFacultatePrivata();

        serviceFacultate.sorteazaListaCandidati();

        //System.out.println("Lista sortata : ");
        serviceFacultate.afiseazaCandidatiStat();
        serviceFacultate.afiseazaCandidatiPrivat();

        serviceFacultate.setListaAdmisiRespinsiStat();
        serviceFacultate.afiseazaAdmisiStat();
        serviceFacultate.afiseazaRespinsiStat();

        serviceFacultate.setListaAdmisiRespinsiPrivata();
        serviceFacultate.afiseazaAdmisiPrivata();
        serviceFacultate.afiseazaRespinsiPrivata();

        //adaugam candidati acceptati
        for(Candidat c : serviceFacultate.getFacultateDeStat().getListaAdmisi().getLista()){
            repo.adaugaCandidatAdmis(c);
        }

        for(Candidat c : serviceFacultate.getFacultatePrivata().getListaAdmisi().getLista()){
            repo.adaugaCandidatAdmis(c);
        }

        //adauga candidati respinsi
        for(Candidat c : serviceFacultate.getFacultateDeStat().getListaRespinsi()){
            repo.adaugaCandidatRespins(c);
        }

        for(Candidat c : serviceFacultate.getFacultatePrivata().getListaRespinsi()){
            repo.adaugaCandidatRespins(c);
        }
        b4.setEnabled(false);
        b5.setEnabled(true);
    }

    public void gestionareCandidati(){

        JPanel p = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        p1.setVisible(false);
        p1.setSize(600,600);


        add(p);

        JButton b1 = new JButton("Adauga Candidat Stat");
        JButton b2 = new JButton("Adauga Candidat Privata");
        JButton b3 = new JButton("Sterge Candidat Stat");
        JButton b4 = new JButton("Sterge Candidat Privata");
        JButton b5 = new JButton("Back");

        c.ipady = 30;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.CENTER;
        c.weighty = 1.0;
        c.gridy = 0;
        p.add(b1,c);
        p.add(b3,c);

        c.ipady = 30;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.CENTER;
        c.weighty = 1.0;
        c.gridy = 1;
        p.add(b2,c);
        p.add(b4,c);


        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridy = 2;       //third row
        p.add(b5,c);

        b1.addActionListener(ev -> {

            if(serviceFacultate.getFacultateDeStat().getListaAdmisi().getLista().size() < serviceFacultate.getFacultateDeStat().getNumarLocuri()){

                if(serviceFacultate.getFacultateDeStat().getListaRespinsi().size() >=0){

                    Candidat candidat = serviceFacultate.getFacultateDeStat().getListaRespinsi().remove();
                    serviceFacultate.getFacultateDeStat().getListaAdmisi().adaugaCandidat(candidat);

                    repo.adaugaCandidatAdmis(candidat);
                    repo.stergeCandidatRespins(candidat);
                }
                else{
                    System.out.println("Nu exista studenti care sa fie adaugati");
                }
            }
            else{
                JFrame j = new JFrame();
                JLabel t = new JLabel();
                t.setText("Nu sunt locuri libere momentan");
                JButton b = new JButton("Close");

                j.setSize(200,300);
                j.setLayout(new FlowLayout());
                j.setLocationRelativeTo(null);
                j.setVisible(true);

                j.add(t);
                j.add(b);

                b.addActionListener(e ->{
                    j.dispose();
                });
            }

        });
        b2.addActionListener(ev -> {

            if(serviceFacultate.getFacultatePrivata().getListaAdmisi().getLista().size() < serviceFacultate.getFacultatePrivata().getNumarLocuri()){

                if(serviceFacultate.getFacultatePrivata().getListaRespinsi().size() >=0){

                    Candidat candidat = serviceFacultate.getFacultatePrivata().getListaRespinsi().remove();
                    serviceFacultate.getFacultatePrivata().getListaAdmisi().adaugaCandidat(candidat);

                    repo.adaugaCandidatAdmis(candidat);
                    repo.stergeCandidatRespins(candidat);
                }
                else{
                    System.out.println("Nu exista studenti care sa fie adaugati");
                }

            }
            else{
                JFrame j = new JFrame();
                JLabel t = new JLabel();
                t.setText("Nu sunt locuri libere momentan");
                JButton b = new JButton("Close");

                j.setSize(300,300);
                j.setLayout(new FlowLayout());
                j.setLocationRelativeTo(null);
                j.setVisible(true);

                j.add(t);
                j.add(b);

                b.addActionListener(e ->{
                    j.dispose();
                });
            }

        });
        b3.addActionListener(ev -> {
            if(serviceFacultate.getFacultateDeStat().getListaAdmisi().getLista().size() > 0){
                JFrame j = new JFrame();

                j.setSize(300,300);
                j.setLayout(new FlowLayout());
                j.setLocationRelativeTo(null);
                j.setVisible(true);

                JLabel e1 = new JLabel("Nume:");
                JLabel e2 = new JLabel("Prenume:");

                JTextField t1 = new JTextField(10);
                JTextField t2 = new JTextField(10);

                JButton b = new JButton("Sterge");

                j.add(e1);
                j.add(t1);
                j.add(e2);
                j.add(t2);
                j.add(b);

                b.addActionListener(e ->{

                    String nume = t1.getText();
                    String prenume = t2.getText();

                    for(Candidat c1 : serviceFacultate.getFacultateDeStat().getListaAdmisi().getLista()){
                        String Nume = c1.getNume();
                        String Prenume = c1.getPrenume().replaceAll("\\s+","");
                        if(Nume.equals(nume) && Prenume.equals(prenume)){
                            serviceFacultate.getFacultateDeStat().getListaAdmisi().eliminaCandidat(
                                    serviceFacultate.getFacultateDeStat().getListaAdmisi().getLista().indexOf(c1)
                            );
                            repo.stergeCandidatAdmis(c1);
                            break;
                        }
                    }

                    t1.setText(null);
                    t2.setText(null);
                    j.dispose();

                });

            }
            else{
                JFrame j = new JFrame();
                JLabel t = new JLabel();
                t.setText("Nu sunt candidati de sters");
                JButton b = new JButton("Close");

                j.setSize(300,300);
                j.setLayout(new FlowLayout());
                j.setLocationRelativeTo(null);
                j.setVisible(true);

                j.add(t);
                j.add(b);

                b.addActionListener(e ->{
                    j.dispose();
                });
            }

        });
        b4.addActionListener(ev -> {

            if(serviceFacultate.getFacultatePrivata().getListaAdmisi().getLista().size() > 0){
                JFrame j = new JFrame();

                j.setSize(200,300);
                j.setLayout(new FlowLayout());
                j.setLocationRelativeTo(null);
                j.setVisible(true);

                JLabel e1 = new JLabel("Nume:");
                JLabel e2 = new JLabel("Prenume:");

                JTextField t1 = new JTextField(10);
                JTextField t2 = new JTextField(10);

                JButton b = new JButton("Sterge");

                j.add(e1);
                j.add(t1);
                j.add(e2);
                j.add(t2);
                j.add(b);

                b.addActionListener(e ->{

                    String nume = t1.getText();
                    String prenume = t2.getText();

                    for(Candidat c1 : serviceFacultate.getFacultatePrivata().getListaAdmisi().getLista()){
                        String Nume = c1.getNume();
                        String Prenume = c1.getPrenume().replaceAll("\\s+","");
                        if(Nume.equals(nume) && Prenume.equals(prenume)){
                            serviceFacultate.getFacultatePrivata().getListaAdmisi().eliminaCandidat(
                                    serviceFacultate.getFacultatePrivata().getListaAdmisi().getLista().indexOf(c1)
                            );
                            repo.stergeCandidatAdmis(c1);
                            break;
                        }
                    }

                    t1.setText(null);
                    t2.setText(null);
                    j.dispose();

                });

            }
            else{
                JFrame j = new JFrame();
                JLabel t = new JLabel();
                t.setText("Nu sunt candidati de sters");
                JButton b = new JButton("Close");

                j.setSize(300,300);
                j.setLayout(new FlowLayout());
                j.setLocationRelativeTo(null);
                j.setVisible(true);

                j.add(t);
                j.add(b);

                b.addActionListener(e ->{
                    j.dispose();
                });
            }

        });
        b5.addActionListener(ev -> {
            p1.setVisible(true);
            p.setVisible(false);
        });




    }

}

