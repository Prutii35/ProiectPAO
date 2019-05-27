package repositories;

import admitere.Candidat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class FacultateRepo {

    private String url = "jdbc:mysql://localhost:3306/admitere";
    private String username = "root";
    private String password = "";

    public FacultateRepo(){
        String  sql1 = "DELETE FROM facultate";
        String  sql2 = "DELETE FROM candidat";
        String  sql3 = "DELETE FROM listaAdmisi";
        String  sql4 = "DELETE FROM listaRespinsi";
        try (
                Connection con = DriverManager.getConnection(url, username, password);
                PreparedStatement s1 = con.prepareStatement(sql1);
                PreparedStatement s2 = con.prepareStatement(sql2);
                PreparedStatement s3 = con.prepareStatement(sql3);
                PreparedStatement s4 = con.prepareStatement(sql4);
        ) {
            s1.executeUpdate(); // INSERT, UPDATE, DELETE
            s2.executeUpdate(); // INSERT, UPDATE, DELETE
            s3.executeUpdate(); // INSERT, UPDATE, DELETE
            s4.executeUpdate(); // INSERT, UPDATE, DELETE
        } catch (Exception e) { // SQLException
            e.printStackTrace();
        }
    }

    public void adaugaFacultate(String numeFacultate,String specializare,Integer locuri){
        String  sql = "INSERT INTO facultate VALUES (?, ?, ?)";

        try (
                Connection con = DriverManager.getConnection(url, username, password);
                PreparedStatement s = con.prepareStatement(sql);
        ) {
            s.setString(1, numeFacultate);
            s.setString(2, specializare);
            s.setDouble(3, locuri);
            s.executeUpdate(); // INSERT, UPDATE, DELETE
        } catch (Exception e) { // SQLException
            e.printStackTrace();
        }
    }

    public void adaugaCandidat(Candidat c){
        String  sql = "INSERT INTO candidat VALUES (?, ?, ?, ?, ?)";
        try (
                Connection con = DriverManager.getConnection(url, username, password);
                PreparedStatement s = con.prepareStatement(sql);
        ) {
            s.setString(1, c.getNume());
            s.setString(2, c.getPrenume());
            s.setDouble(3, c.getMedieBac());
            s.setDouble(4, c.getMedieAdmitere());
            if(c.getTipFacultate()==0){
                s.setString(5,"privata");
            }
            else{
                s.setString(5,"stat");
            }

            s.executeUpdate(); // INSERT, UPDATE, DELETE
        } catch (Exception e) { // SQLException
            e.printStackTrace();
        }
    }

    public void adaugaCandidatAdmis(Candidat c){
        String  sql = "INSERT INTO listaadmisi VALUES (?, ?, ?, ?, ?, ?)";
        try (
                Connection con = DriverManager.getConnection(url, username, password);
                PreparedStatement s = con.prepareStatement(sql);
        ) {
            s.setString(1, c.getNume());
            s.setString(2, c.getPrenume());
            s.setDouble(3, c.getMedieBac());
            s.setDouble(4, c.getMedieAdmitere());
            if(c.getTipFacultate()==0){
                s.setString(5,"privata");
            }
            else{
                s.setString(5,"stat");
            }
            s.setString(6,"acceptat");

            s.executeUpdate(); // INSERT, UPDATE, DELETE
        } catch (Exception e) { // SQLException
            e.printStackTrace();
        }

    }

    public void adaugaCandidatRespins(Candidat c){

        String  sql = "INSERT INTO listarespinsi VALUES (?, ?, ?, ?, ?, ?)";
        try (
                Connection con = DriverManager.getConnection(url, username, password);
                PreparedStatement s = con.prepareStatement(sql);
        ) {
            s.setString(1, c.getNume());
            s.setString(2, c.getPrenume());
            s.setDouble(3, c.getMedieBac());
            s.setDouble(4, c.getMedieAdmitere());
            if(c.getTipFacultate()==0){
                s.setString(5,"privata");
            }
            else{
                s.setString(5,"stat");
            }
            s.setString(6,"refuzat");
            s.executeUpdate(); // INSERT, UPDATE, DELETE
        } catch (Exception e) { // SQLException
            e.printStackTrace();
        }

    }

    public void stergeCandidatAdmis(Candidat c){
        String  sql = "DELETE FROM listaadmisi WHERE Nume = ? and Prenume = ?";
        try (
                Connection con = DriverManager.getConnection(url, username, password);
                PreparedStatement s = con.prepareStatement(sql);
        ) {
            s.setString(1, c.getNume());
            s.setString(2, c.getPrenume());
            s.executeUpdate(); // INSERT, UPDATE, DELETE
        } catch (Exception e) { // SQLException
            e.printStackTrace();
        }
    }

    public void stergeCandidatRespins(Candidat c){
        String  sql = "DELETE FROM listarespinsi WHERE Nume = ? and Prenume = ?";
        try (
                Connection con = DriverManager.getConnection(url, username, password);
                PreparedStatement s = con.prepareStatement(sql);
        ) {
            s.setString(1, c.getNume());
            s.setString(2, c.getPrenume());
            s.executeUpdate(); // INSERT, UPDATE, DELETE
        } catch (Exception e) { // SQLException
            e.printStackTrace();
        }
    }


}
