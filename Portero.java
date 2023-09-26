public class Portero extends Jugador{
    private int atajadasEfectivas;
    private int golesRecibidos;

    public int getAtajadasEfectivas() {
        return atajadasEfectivas;
    }

    public void setAtajadasEfectivas(int atajadasEfectivas) {
        this.atajadasEfectivas = atajadasEfectivas;
    }

    public int getGolesRecidos() {
        return golesRecibidos;
    }

    public void setGolesRecibidos(int golesRecibidos) {
        this.golesRecibidos = golesRecibidos;
    }

    public void calcularEfectividad(){
        //((paradas efectivas - goles recibidos) * 100 / (paradas efectivas + goles recibidos)) + goles
        //directos * 100 / total de lanzamientos.
        this.efectividad = ((this.atajadasEfectivas - this.golesRecibidos) * 100 / (this.atajadasEfectivas + this.golesRecibidos)) + (this.golesDirectos * 100 / this.totalTiros); 
    }

    //Sobreescribir un metodo 
    @Override
    public String toString(){
        return "Nombre: " + this.nombre + ", Pais: " + this.pais + ", Paradas efectivas:" + this.atajadasEfectivas;
    }
}
