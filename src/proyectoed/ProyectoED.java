/**
 *
 * @author Marlon Mejia
 * Proyecto Estructura de Datos
 * 
 * Esta clase es la que inicia la ejecucion del sistema.
 */

package proyectoed;

import java.util.Scanner;

public class ProyectoED {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Metodos met = new Metodos();
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Cargando...");
        met.Iniciar();
        System.out.println("\n------------------------------------------------");
        System.out.println(" Bienvenido al Sistema de Tren Electrico Urbano");
        System.out.println("------------------------------------------------");
        int opcion = 0;
        while(opcion != 4){
            try{
                System.out.println("\n------------------------------------------------");
                System.out.println("¿Que desea hacer?");
                System.out.println("1.- Mostrar Linea");
                System.out.println("2.- Planear Ruta");
                System.out.println("3.- Modo Administrador");
                System.out.println("4.- Salir");
                System.out.println("------------------------------------------------");
                System.out.print("Seleccion: ");
                String entrada = scan.next();
                opcion = Integer.parseInt(entrada);
                switch(opcion){
                case 1:
                    met.MostrarLinea();
                    break;
                case 2:
                    met.PlanearRuta();
                    break;
                case 3:
                    met.Administrador();
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("¡Opcion Invalida!");
                    break;
                }      
            }
            catch(NumberFormatException e){
                System.out.println("¡Debe de ser un valor numerico!");
            }
        }
    }
}
