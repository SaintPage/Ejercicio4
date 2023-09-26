//clase donde se tiene los datos principales del extremo
public class Extremo extends Jugador{
    private int pases;
    private int asistenciasEfectivas;


    //Setters y getters
    public void setPases(int pases){
        this.pases = pases; 
    }
    public int getPases(){
        return this.pases;
    }

    public void setAsistenciasEfecitvas(int asistenciasEfectivas){
        this.asistenciasEfectivas = asistenciasEfectivas;
    }
    public int getAsistenciasEfecitvas(){
        return this.asistenciasEfectivas;
    }

    //método de calcular efectividad, se introduce la fórmula requerida
    public void calcularEfectividad(){
        this.efectividad = ((this.pases + this.asistenciasEfectivas - this.faltas) * 100 / (this.pases +this.asistenciasEfectivas + this.faltas)) + (this.golesDirectos *100 / this.totalTiros);
    }

    //Sobreescribir un método
    @Override
    public String toString(){
        return "nombre: " + this.nombre + ", pais: " + this.pais + ", goles: " + this.golesDirectos + ", asistencias: " + this.asistenciasEfectivas;
    }
}
