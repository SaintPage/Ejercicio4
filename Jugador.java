public class Jugador {
    protected String nombre;
    protected String pais;
    protected int faltas;
    protected int golesDirectos;
    protected int totalTiros;
    protected double efectividad;


    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getNombre(){
        return this.nombre;
    }

    public void setPais(String pais){
        this.pais = pais;
    }
    public String getPais(){
        return this.pais;
    }

    public void setFaltas(int faltas){
        this.faltas = faltas;
    }
    public int getFaltas(){
        return this.faltas;
    }

    public void setGolesDirectos(int golesDirectos){
        this.golesDirectos = golesDirectos;
    }
    public int getGolesDirectos(){
        return this.golesDirectos;
    }

    public void setTotalTiros(int totalTiros){
        this.totalTiros = totalTiros;
    }
    public int getTotalTiros(){
        return this.totalTiros;
    }

    public double getEfectividad(){
        return this.efectividad;
    }

}
