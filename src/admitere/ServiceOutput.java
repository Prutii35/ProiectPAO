package admitere;

import java.io.*;

public class ServiceOutput {

    public void printeazaInformatiiFacultate(String path,String nume,String  specializare, int locuri){
        File file = new File(path);
        try{
            PrintWriter pw = new PrintWriter(new FileOutputStream(file, true));
            pw.println("Nume : " + nume + ",");
            pw.println("Specializare : " + specializare + ",");
            pw.println("Numar Locuri : " + locuri + ",");
            pw.flush();
            pw.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

    public void printStringFacultate(String path,String s){
        File file = new File(path);
        try{
            PrintWriter pw = new PrintWriter(file);
            pw.println(s);
            pw.flush();
            pw.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

    public void printString(String path,String s){
        File file = new File(path);
        try{
            PrintWriter pw = new PrintWriter(new FileOutputStream(file, true));
            pw.println(s);
            pw.flush();
            pw.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

    public void printeazaInformatiiCandidati(String path, String nume, String prenume, Double medieBac , Double medieAdmitere , int tip){
        File file = new File(path);
        try{
            PrintWriter pw = new PrintWriter(new FileOutputStream(file, true));
            pw.println("Nume : " + nume + ",");
            pw.println("Prenume: " + prenume + ",");
            pw.println("Medie Bac: " + medieBac + ",");
            pw.println("Medie Admitere: " + medieAdmitere + ",");
            pw.println("Tipul de facultate : " +(tip==1 ? "De Stat" : "Privata") + "," + "\n");
            pw.flush();
            pw.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
