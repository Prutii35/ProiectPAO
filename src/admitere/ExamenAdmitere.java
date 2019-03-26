package admitere;

public class ExamenAdmitere {

    private double nota1Admitere;
    private double nota2Admitere;
    private final double medieAdmitere;

    public double getNota2Admitere() { return nota2Admitere; }

    public double getNota1Admitere() {
        return nota1Admitere;
    }

    public double getMedieAdmitere() { return medieAdmitere; }

    public ExamenAdmitere(double nota1, double nota2){
        this.nota1Admitere = nota1;
        this.nota2Admitere = nota2;
        this.medieAdmitere = (nota1+nota2)/2;
    }
}
