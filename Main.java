/* Angel de Jesús Mérida Jiménez Carné: 23661
En este programa se llevará acabo un menú donde el usuario podrá ver los porteros y extremos ya registrados
al igual puede modificarlos directamente en su respectivo csv, con el fin de ver la lista de jugadores completa
ver los 3 porteros con mayor efectividad y por útlimo la cantidad de extremos con mayor de 85 de efectividad 
 */


import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import com.opencsv.CSVReader;

/* clase principal donde se lleva la lógica:
 */
public class Main {
    public static void main(String[] args) {
        boolean salir = false;
        // Se crean arraylist de porteros y jugadores
        ArrayList<Portero> porteros = new ArrayList<Portero>();
        ArrayList<Extremo> extremos = new ArrayList<Extremo>();
        
        try{
            //agregamos los datos del csv a la lista de array de porteros
            porteros.clear();
            CSVReader csvReader = new CSVReader(new FileReader("./files/porteros.csv"));
            int count = 0;
            String[] fila = null;
            while( (fila = csvReader.readNext()) != null ){
                if (count == 0){
                    count++;
                    continue;
                }
                Portero aux = new Portero();
                //usar setters correspondientes para agregar los datos
                aux.setNombre(fila[0]);
                aux.setPais(fila[1]);
                aux.setFaltas(Integer.parseInt(fila[2]));
                aux.setGolesDirectos(Integer.parseInt(fila[3]));
                aux.setTotalTiros(Integer.parseInt(fila[4]));
                aux.setAtajadasEfectivas(Integer.parseInt(fila[5]));
                aux.setGolesRecibidos(Integer.parseInt(fila[6]));
                aux.calcularEfectividad();
                porteros.add(aux);
            }
            System.out.println("Archivo de porteros cargado existosamente!!");
        
        }
        catch(Exception e){
            System.out.println("error");
            e.printStackTrace();
        }
        
        // Leemos otro csv para los extremos
        try{
            extremos.clear();
            CSVReader csvReader = new CSVReader(new FileReader("./files/extremos.csv"));
            int count = 0;
            String[] fila = null;
            while( (fila = csvReader.readNext()) != null ){
                if (count == 0){
                    count++;
                    continue;
                }
                Extremo aux = new Extremo();
                //usar setters correspondientes para agregar los datos requeridos
                aux.setNombre(fila[0]);
                aux.setPais(fila[1]);
                aux.setFaltas(Integer.parseInt(fila[2]));
                aux.setGolesDirectos(Integer.parseInt(fila[3]));
                aux.setTotalTiros(Integer.parseInt(fila[4]));
                aux.setPases(Integer.parseInt(fila[5]));
                aux.setAsistenciasEfecitvas(Integer.parseInt(fila[6]));
                aux.calcularEfectividad();
                extremos.add(aux);
            }
            System.out.println("Archivo de extremos cargado existosamente!!");
        
        }
        //Por si sale error al cargar el archivo
        catch(Exception e){
            System.out.println("error");
            e.printStackTrace();
        }

        //menú
        while (!salir){
            mostrarMenu();
            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();
            String[] fila = null;
            switch (option){
                case 1:
                    //opción mostar la lista de porteros y extremos con for
                    System.out.println("Lista de porteros:");
                    for(int i=0; i<porteros.size(); i++){
                        System.out.println(porteros.get(i));
                    }
                    System.out.println("Lista extremos:");
                    for(int i=0; i<extremos.size(); i++){
                        System.out.println(extremos.get(i));
                    }
                    break;

                //Opción 2 para comparar porteros utilizando nueva lista y la función Comparator
                case 2:
                    Comparator<Portero> comparadorPorEfectividad = new Comparator<Portero>() {
                        //Sobreescribimos
                        @Override
                        public int compare(Portero portero1, Portero portero2){
                            // Compara los jugadores en función de su efectividad de manera descendente
                            return Double.compare(portero2.getEfectividad(), portero1.getEfectividad());
                        }
                    };

                    // Ordenar la lista de porteros utilizando el comparador
                    Collections.sort(porteros, comparadorPorEfectividad);

                    // Mostrar los 3 mejores porteros
                    for (int i = 0; i < 3 && i < porteros.size(); i++){
                        Portero jugador = porteros.get(i);
                        System.out.println("Nombre: " + jugador.getNombre() + ", Efectividad: " + jugador.getEfectividad());
                    }
                
                    break;
                case 3:
                    //Opción 3 de mostrar los extremos con efectividad mayor a 85
                    System.out.println("Lista de extremos con efectividad mayor a 85:");
                    for(int i=0; i<extremos.size(); i++){
                        if(extremos.get(i).getEfectividad() > 85){
                            Extremo aux = extremos.get(i); 
                            System.out.println("Nombre: " + aux.getNombre() +  ", con efectividad de: " + aux.getEfectividad());
                        }
                    }
                    break;
                case 4:
                    salir = true;
                    break;
                default:
                System.out.println("Esta opcion no existe");
            }
        }



    }

    //Opciones del menú
    public static void mostrarMenu(){
        System.out.println("Menu");
        System.out.println("Elija una opcion");
        System.out.println("1. Mostrar todos los jugadores del campeonato");
        System.out.println("2. Los 3 mejores porteros en función de su efectividad");
        System.out.println("3. La cantidad de extremos con más de un 85% de efectividad");
        System.out.println("4. Salir");
    }
}