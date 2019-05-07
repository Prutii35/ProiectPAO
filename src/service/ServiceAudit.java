package service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServiceAudit {

    private Date date = new Date();
    DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
    String data = dateFormat.format(date); //formateaza date ul dat la un string


    public void facultateCreata(String tip){
        File file = new File("data\\audit.csv");
        try( PrintWriter pw = new PrintWriter(new FileOutputStream(file, true))){
            if(tip == "stat"){
                pw.println("------ New Program -----");
            }
            pw.println("Facultate_" + tip +  "_creata" + "," + data);
            pw.flush();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

    public void candidatCreat(){
        File file = new File("data\\audit.csv");
        try( PrintWriter pw = new PrintWriter(new FileOutputStream(file, true))){
            pw.println("Candidat_" + "creat" + "," + data);
            pw.flush();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

    public void candidatiSortati(String tip){
        File file = new File("data\\audit.csv");
        try( PrintWriter pw = new PrintWriter(new FileOutputStream(file, true))){
            pw.println("Candidati_" + tip +  "_sortati" + "," + data);
            pw.flush();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

    public void listaAdmisiRespinsicreata(String tip){
        File file = new File("data\\audit.csv");
        try( PrintWriter pw = new PrintWriter(new FileOutputStream(file, true))){
            pw.println("Lista_" + tip +  "_creata" + "," + data);
            pw.flush();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

}
