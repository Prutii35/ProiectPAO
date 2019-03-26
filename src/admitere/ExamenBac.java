package admitere;

public class ExamenBac {

    private double notaProba1;
    private double notaProba2;
    private double notaProba3;
    private final double medieBac;

    public ExamenBac(double nota1,double nota2,double nota3){
        this.notaProba1 = nota1;
        this.notaProba2 = nota2;
        this.notaProba3 = nota3;
        this.medieBac = (nota1+nota2+nota3)/3;
    }

    public double getNotaProba1(){  return notaProba1; }

    public double getNotaProba2(){  return notaProba2; }

    public double getNotaProba3(){  return notaProba3; }

    public double getMedie(){   return medieBac; }
}
