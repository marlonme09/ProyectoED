/**
 *
 * @author Marlon Mejia
 * 
 * Esta clase contiene todos los métodos que se utilizan en el proyecto.
 * 
 */

package proyectoed;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Metodos {
    int[][] MatrizMOriginal = {
        {0,   1, 99,  2, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99},
        {1,   0,  2,  2, 99, 99,  7, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99},
        {99,  2,  0,  3,  2, 99, 99,  5, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99},
        {2,   2,  3,  0,  2, 99, 99, 99, 99,  3, 99, 99, 99, 99, 99, 99, 99, 99},
        {99, 99,  2,  2,  0,  3, 99, 99,  2, 99, 99, 99, 99, 99, 99, 99, 99, 99},
        {99, 99, 99, 99,  3,  0, 99, 99, 99,  3, 99, 99, 99, 99, 99, 99, 99, 99},
        {99,  7, 99, 99, 99, 99,  0,  4, 99, 99,  3, 99, 99, 99, 99, 99, 99, 99},
        {99, 99,  5, 99, 99, 99,  4,  0,  3, 99, 99,  2, 99, 99, 99, 99, 99, 99},
        {99, 99, 99, 99,  2, 99, 99,  3,  0,  2, 99, 99,  2, 99, 99, 99, 99, 99},
        {99, 99, 99,  3, 99,  3, 99, 99,  2,  0, 99, 99, 99,  4,  3, 99, 99, 99},
        {99, 99, 99, 99, 99, 99,  3, 99, 99, 99,  0,  3, 99, 99, 99,  2, 99, 99},
        {99, 99, 99, 99, 99, 99, 99,  2, 99, 99,  3,  0,  2, 99, 99,  3, 99, 99},
        {99, 99, 99, 99, 99, 99, 99, 99,  2, 99, 99,  2,  0,  1, 99, 99,  2, 99},
        {99, 99, 99, 99, 99, 99, 99, 99, 99,  4, 99, 99,  1,  0,  2, 99, 99,  4},
        {99, 99, 99, 99, 99, 99, 99, 99, 99,  3, 99, 99, 99,  2,  0, 99, 99, 99},
        {99, 99, 99, 99, 99, 99, 99, 99, 99, 99,  2,  3, 99, 99, 99,  0,  3, 99},
        {99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99,  2, 99, 99,  3,  0,  3},
        {99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99,  4, 99, 99,  3,  0}
    };
    
    int[][] MatrizM = {};
    int[][] MatrizMTemp = {};
        
    int[][] MatrizT = {
        {99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99},
        {99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99},
        {99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99},
        {99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99},
        {99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99},
        {99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99},
        {99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99},
        {99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99},
        {99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99},
        {99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99},
        {99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99},
        {99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99},
        {99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99},
        {99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99},
        {99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99},
        {99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99},
        {99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99},
        {99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99, 99}
    };
    
    LinkedList<Estacion> linea1 = new LinkedList<>();
    LinkedList<Estacion> linea2 = new LinkedList<>();
    LinkedList<Estacion> linea3 = new LinkedList<>();
    LinkedList<Estacion> linea4 = new LinkedList<>();
    LinkedList<Estacion> linea5 = new LinkedList<>();
    LinkedList<Estacion> linea6 = new LinkedList<>();
    LinkedList<Estacion> linea7 = new LinkedList<>();
    LinkedList<Estacion> linea8 = new LinkedList<>();
    LinkedList<NodoCruce> nodosCruce = new LinkedList<>();
    LinkedList<Estacion> trayeOri = new LinkedList<>();
    LinkedList<NodoCruce> trayeCru = new LinkedList<>();
    LinkedList<Estacion> trayeDes = new LinkedList<>();
    int tiempo;
    int transbordos;
    
    /**
     * Esta función se encarga de llamar el método para que se carguen los datos
     * de la base de datos y copia las matrices a una matrices temporales.
     */
    public void Iniciar(){
        MatrizMTemp = CopiarMatriz(MatrizMOriginal);
        MatrizM = CopiarMatriz(MatrizMOriginal);
        MatrizT = Floyd(MatrizT, MatrizM);
        CargarTodo();
    }
    
    /**
     * Esta función copia una matriz a otra.
     * 
     * @param Matriz
     * La matriz de la cual se quieren tomar los datos.
     * 
     * @return
     * Regresa una nueva matriz identica a la matriz que se le paso en el
     * parametro.
     * 
     */
    private int[][] CopiarMatriz(int[][] Matriz){
        int[][] res = new int[18][18];
        for(int j = 0; j < 18; j++){
            for(int i = 0; i < 18; i++){
                res[j][i] = Matriz[j][i];
            }
        }
        return res;
    }
    
    /**
     * Función que sirve para tomar los datos de la base de datos y agregarlos a
     * una linked list.
     * 
     * @param lista
     * La lista en la cual se van a insetar los datos.
     * 
     * @param lin
     * Numero de la linea que se va a buscar.
     * 
     * @return 
     * Regresa la lista ya con los datos de la linea que se especifico.
     */
    private void AgregarEstaciones(LinkedList<Estacion> lista, int lin){
        Conexion cc = new Conexion();
        Connection cn = cc.ConnectionSQLServer();
        Statement stm;
        ResultSet rs;
        ResultSetMetaData rsm;
        try{
            stm = cn.createStatement();
            rs = stm.executeQuery("SELECT * FROM Estacion WHERE Linea = " + lin);
            rsm = rs.getMetaData();
            int numCol = rsm.getColumnCount();
            String fila[] = new String[numCol];
            while(rs.next()){
                for(int m = 1, n = 0; m <= numCol; m++, n++){
                    fila[n] = rs.getString(m);
                }
                Estacion nd = new Estacion();
                nd.setIdEstacion(Integer.parseInt(fila[0]));
                nd.setNumEstLin(Integer.parseInt(fila[1]));
                nd.setNombreEst(fila[2]);
                nd.setNumLinea(Integer.parseInt(fila[3]));
                nd.setPuntosInteres(fila[4]);
                nd.setTipo(Integer.parseInt(fila[5]));
                nd.setStatus(Integer.parseInt(fila[6]));
                lista.add(nd);
            }
        }
        catch(SQLException ex){
            Logger.getLogger(Estacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Esta función carga los datos de la base de datos de los nodos de cruce y
     * los mete a la lista.
     * 
     * @param listaNdCru 
     * Lista en la que se van a insertar los nodos de cruce.
     */
    private void AgregarNodoCruce(LinkedList<NodoCruce> listaNdCru){
        Conexion cc = new Conexion();
        Connection cn = cc.ConnectionSQLServer();
        Statement stm;
        ResultSet rs;
        ResultSetMetaData rsm;
        try{
            stm = cn.createStatement();
            rs = stm.executeQuery("SELECT * FROM NodoCruce");
            rsm = rs.getMetaData();
            int numCol = rsm.getColumnCount();
            String fila[] = new String[numCol];
            while(rs.next()){
                for(int m = 1, n = 0; m <= numCol; m++, n++){
                    fila[n] = rs.getString(m);
                }
                NodoCruce nc = new NodoCruce();
                nc.setPosFloyd(Integer.parseInt(fila[0]));
                nc.setLineaA(Integer.parseInt(fila[1]));
                nc.setEstacionA(Integer.parseInt(fila[2]));
                nc.setLineaB(Integer.parseInt(fila[3]));
                nc.setEstacionB(Integer.parseInt(fila[4]));
                nc.setLineaC(Integer.parseInt(fila[5]));
                nc.setEstacionC(Integer.parseInt(fila[6]));
                nc.setActivo(Integer.parseInt(fila[7]));
                listaNdCru.add(nc);
            }
        }
        catch(SQLException ex){
            Logger.getLogger(Estacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Esta función sirve para "avanzar" de manera ascendente a travez de la lista,
     * desde la estación de origen hasta encontrar la estacion de destino.
     * 
     * @param lin
     * Numero de la lista de la cual van a ser tomados los datos.
     * 
     * @param estDes
     * Numero de la estación destino.
     * 
     * @param estOri 
     * Numero de la estación origen.
     */
    private void Asciende(int lin, int estDes, int estOri){
       int tiempoRuta1 = 99, tiempoRuta2 = 99;
        LinkedList<Estacion> listOrigenDestino = new LinkedList();
        listOrigenDestino = OrigenDestino(lin, estDes, estOri);
        if(listOrigenDestino.getLast().getTipo() == 1){
            if(listOrigenDestino.getLast().getNumEstLin() == estDes && 
                    listOrigenDestino.getFirst().getNumEstLin() == estOri){
                trayeOri = (LinkedList) listOrigenDestino.clone();
                tiempo = (listOrigenDestino.size() - 1);
            }
            else{
                LinkedList<Integer> listCruce = new LinkedList();
                LinkedList<Estacion> listDestinoOrigen = new LinkedList();
                listDestinoOrigen = DestinoOrigen(lin, estOri, estDes);
                LinkedList<Estacion> listOrigenAtras = new LinkedList();
                LinkedList<Estacion> listDestinoAtras = new LinkedList();
                listOrigenAtras = OrigenAtras(lin, estOri, estDes);
                listDestinoAtras = DestinoAtras(lin, estDes, estOri);  
                int numCruA = 0, numCruB = 0, numCruY = 0, numCruZ = 0;
                if(!listOrigenDestino.isEmpty() && !listDestinoOrigen.isEmpty()){
                    int linOD = listOrigenDestino.getLast().getNumLinea();
                    int estOD = listOrigenDestino.getLast().getNumEstLin();
                    int linDO = listDestinoOrigen.getLast().getNumLinea();
                    int estDO = listDestinoOrigen.getLast().getNumEstLin();
                    numCruA = BuscarNodoCruce(linOD, estOD);
                    numCruB = BuscarNodoCruce(linDO, estDO);
                    tiempoRuta1 = MatrizM[numCruA][numCruB];
                    tiempoRuta1 += (listOrigenDestino.size() - 1);
                    tiempoRuta1 += (listDestinoOrigen.size() - 1);
                }
                if(!listOrigenAtras.isEmpty() && !listDestinoAtras.isEmpty()){
                    int linOA = listOrigenAtras.getLast().getNumLinea();
                    int estOA = listOrigenAtras.getLast().getNumEstLin();
                    int linDA = listDestinoAtras.getLast().getNumLinea();
                    int estDA = listDestinoAtras.getLast().getNumEstLin();
                    numCruY = BuscarNodoCruce(linDA, estDA);
                    numCruZ = BuscarNodoCruce(linOA, estOA);
                    tiempoRuta2 = MatrizM[numCruY][numCruZ];
                    tiempoRuta2 += (listDestinoAtras.size() - 1);
                    tiempoRuta2 += (listOrigenAtras.size() - 1);
                }
                if(tiempoRuta1 < tiempoRuta2){
                    trayeOri = (LinkedList) listOrigenDestino.clone();
                    trayeDes = (LinkedList) listDestinoOrigen.clone();
                    RutaCruce(numCruA, numCruB, listCruce);
                    for(Iterator<Integer> it = listCruce.iterator(); it.hasNext();){
                        Integer temp = it.next();
                        trayeCru.add(nodosCruce.get(temp));
                    }
                    tiempo = tiempoRuta1;
                }
                else{
                    trayeOri = (LinkedList) listOrigenAtras.clone();
                    trayeDes = (LinkedList) listDestinoAtras.clone();
                    RutaCruce(numCruY, numCruZ, listCruce);
                    for(Iterator<Integer> it = listCruce.iterator(); it.hasNext();){
                        Integer temp = it.next();
                        trayeCru.add(nodosCruce.get(temp));
                    }
                    tiempo = tiempoRuta2;
                }
            }
        }
        else{
            trayeOri = (LinkedList) listOrigenDestino.clone();
            tiempo = (listOrigenDestino.size() - 1);
        }
    }
    
    private LinkedList<Estacion> OrigenDestino(int lin, int estDes, int estOri){
        LinkedList<Estacion> trayectD = new LinkedList();
        LinkedList<Estacion> linea = TomarLinea(lin);
        for(int i = estOri; i <= linea.getLast().getNumEstLin(); i++){
            if(linea.get(i).getNumEstLin()!= estDes){
                if(linea.get(i).getTipo() == 1){
                    if(linea.get(i).getStatus() == 1){
                        trayectD = TomarEstacionesPasoAum(lin, estOri, i);
                        break;
                    }
                    else{
                        //No regresa nada porque encontro un puto de cruce pero 
                        //este esta deshabilitado.
                        break;
                    }
                }
                else{
                    //Nada
                }
            }
            else{
                trayectD = TomarEstacionesPasoAum(lin, estOri, i);
                break;
            }
        }
        return trayectD;
    }
    
    private LinkedList<Estacion> OrigenAtras(int lin, int estDes, int estOri){
        LinkedList<Estacion> trayectD = new LinkedList();
        LinkedList<Estacion> linea = TomarLinea(lin);
        for(int i = estDes; i >= linea.getFirst().getNumEstLin(); i--){
            if(i == linea.getFirst().getNumEstLin()){
                //No Regresa nada si se acaba la linea y no encuentra una estacion
                //de cruce.
                break;
            }
            else{
                if(linea.get(i).getNumEstLin()!= estOri){
                    if(linea.get(i).getTipo() == 1){
                        if(linea.get(i).getStatus() == 1){
                            trayectD = TomarEstacionesPasoDes(lin, estDes, i);
                            break;
                        }
                        else{
                            //No regresa nada porque encontro un puto de cruce pero 
                            //este esta deshabilitado.
                            break;
                        }
                    }
                    else{
                        //Nada
                    }
                }
                else{
                    trayectD = TomarEstacionesPasoDes(lin, estDes, i);
                    break;
                }
            }
            
        }
        return trayectD;
    }
    
    /**
     * Esta función se encarga de buscar el numero del nodo de cruce (ya que es
     * diferente al número de estacion) y regresa el valor que la estacion tiene
     * pero en la lista NodoCruce.
     * 
     * @param linCru
     * Linea donde se encuentra el nodo de cruce.
     * 
     * @param estCru
     * Estacion donde se encuentra el nodo de cruce.
     * 
     * @return
     * Regresa el numero del nodo de cruce.
     */
    private int BuscarNodoCruce(int linCru, int estCru){
        int posFloyd = 99;
        LinkedList<NodoCruce> listaLin = new LinkedList();
        for(Iterator<NodoCruce> itLinea = nodosCruce.iterator(); itLinea.hasNext();){
            NodoCruce tempLinea = itLinea.next();
            int lineaA = tempLinea.getLineaA();
            int lineaB = tempLinea.getLineaB();
            int lineaC = tempLinea.getLineaC();
            if(tempLinea.getLineaA() == linCru || tempLinea.getLineaB() == linCru || tempLinea.getLineaC() == linCru){
                listaLin.add(tempLinea);
            }
        }
        for(Iterator<NodoCruce> itEst = listaLin.iterator(); itEst.hasNext();){
            NodoCruce tempEst = itEst.next();
            if((tempEst.getLineaA() == linCru && tempEst.getEstacionA() == estCru) || 
                    (tempEst.getLineaB() == linCru && tempEst.getEstacionB() == estCru) ||
                        (tempEst.getLineaC() == linCru && tempEst.getEstacionC() == estCru)){
                posFloyd = tempEst.getPosFloyd();
            }
        }
        return posFloyd;
    }
    
    /**
     * Función que busca la estación o el punto de interes que se le especifico
     * en todas las listas y mandar en el linea se encuentra y su numero de 
     * estación.
     * 
     * @param entrada
     * Estación o Punto de interes a buscar.
     * 
     * @return 
     * Regresa un arreglo con el numero de linea donde se encontro y el numero
     * de estación.
     */
    private int[] Busqueda(String entrada){
        int salida[] = new int[2];
        for(Iterator<Estacion> it = linea1.iterator(); it.hasNext();){
            Estacion temp = it.next();
            if(temp.getNombreEst().equals(entrada) || PuntoInteres(temp.getPuntosInteres(), entrada)){
                salida[0] = 1;
                salida[1] = temp.getNumEstLin();
            }
        }
        for(Iterator<Estacion> it = linea2.iterator(); it.hasNext();){
            Estacion temp = it.next();
            if(temp.getNombreEst().equals(entrada) || PuntoInteres(temp.getPuntosInteres(), entrada)){
                salida[0] = 2;
                salida[1] = temp.getNumEstLin();
            }
        }
        for(Iterator<Estacion> it = linea3.iterator(); it.hasNext();){
            Estacion temp = it.next();
            if(temp.getNombreEst().equals(entrada) || PuntoInteres(temp.getPuntosInteres(), entrada)){
                salida[0] = 3;
                salida[1] = temp.getNumEstLin();
            }
        }
        for(Iterator<Estacion> it = linea4.iterator(); it.hasNext();){
            Estacion temp = it.next();
            if(temp.getNombreEst().equals(entrada) || PuntoInteres(temp.getPuntosInteres(), entrada)){
                salida[0] = 4;
                salida[1] = temp.getNumEstLin();
            }
        }
        for(Iterator<Estacion> it = linea5.iterator(); it.hasNext();){
            Estacion temp = it.next();
            if(temp.getNombreEst().equals(entrada) || PuntoInteres(temp.getPuntosInteres(), entrada)){
                salida[0] = 5;
                salida[1] = temp.getNumEstLin();
            }
        }
        for(Iterator<Estacion> it = linea6.iterator(); it.hasNext();){
            Estacion temp = it.next();
            if(temp.getNombreEst().equals(entrada) || PuntoInteres(temp.getPuntosInteres(), entrada)){
                salida[0] = 6;
                salida[1] = temp.getNumEstLin();
            }
        }
        for(Iterator<Estacion> it = linea7.iterator(); it.hasNext();){
            Estacion temp = it.next();
            if(temp.getNombreEst().equals(entrada) || PuntoInteres(temp.getPuntosInteres(), entrada)){
                salida[0] = 7;
                salida[1] = temp.getNumEstLin();
            }
        }
        for(Iterator<Estacion> it = linea8.iterator(); it.hasNext();){
            Estacion temp = it.next();
            if(temp.getNombreEst().equals(entrada) || PuntoInteres(temp.getPuntosInteres(), entrada)){
                salida[0] = 8;
                salida[1] = temp.getNumEstLin();
            }
        }
        return salida;
    }
    
    /**
     * Función que sirve para cargar los datos y llamar a la función que 
     * inserta los datos a las listas.
     */
    public void CargarTodo(){
        linea1.clear();
        linea2.clear();
        linea3.clear();
        linea4.clear();
        linea5.clear();
        linea6.clear();
        nodosCruce.clear();
        System.out.println("Cargando.");
        AgregarEstaciones(linea1, 1);
        AgregarEstaciones(linea2, 2);
        AgregarEstaciones(linea3, 3);
        AgregarEstaciones(linea4, 4);
        AgregarEstaciones(linea5, 5);
        AgregarEstaciones(linea6, 6);
        AgregarEstaciones(linea7, 7);
        AgregarEstaciones(linea8, 8);
        AgregarNodoCruce(nodosCruce);
    }
    
    /**
     * Esta función sirve para "avanzar" de manera descendinte a travez de la lista,
     * desde la estación de origen hasta encontrar la estacion de destino.
     * 
     * @param lin
     * Numero de la lista de la cual van a ser tomados los datos.
     * 
     * @param estDes
     * Numero de la estación destino.
     * 
     * @param estOri 
     * Numero de la estación origen.
     */
    private void Desciende(int lin, int estDes, int estOri){
        int tiempoRuta1 = 99, tiempoRuta2 = 99;
        LinkedList<Estacion> listOrigenDestino = new LinkedList();
        listOrigenDestino = DestinoOrigen(lin, estDes, estOri);
        if(listOrigenDestino.getLast().getTipo() == 1){
            if(listOrigenDestino.getFirst().getNumEstLin() == estOri && 
                    listOrigenDestino.getLast().getNumEstLin() == estDes){
                trayeOri = (LinkedList) listOrigenDestino.clone();
                tiempo = (listOrigenDestino.size() - 1);
            }
            else{
                LinkedList<Integer> listCruce = new LinkedList();
                LinkedList<Estacion> listDestinoOrigen = new LinkedList();
                listDestinoOrigen = OrigenDestino(lin, estOri, estDes);
                LinkedList<Estacion> listOrigenAtras = new LinkedList();
                LinkedList<Estacion> listDestinoAtras = new LinkedList();
                listOrigenAtras = OrigenAtras(lin, estDes, estOri);
                listDestinoAtras = DestinoAtras(lin, estOri, estDes);
                int numCruA = 0, numCruB = 0, numCruY = 0, numCruZ = 0;
                if(!listOrigenDestino.isEmpty() && !listDestinoOrigen.isEmpty()){
                    int linOD = listOrigenDestino.getLast().getNumLinea();
                    int estOD = listOrigenDestino.getLast().getNumEstLin();
                    int linDO = listDestinoOrigen.getLast().getNumLinea();
                    int estDO = listDestinoOrigen.getLast().getNumEstLin();
                    numCruA = BuscarNodoCruce(linOD, estOD);
                    numCruB = BuscarNodoCruce(linDO, estDO);
                    tiempoRuta1 = MatrizM[numCruA][numCruB];
                    tiempoRuta1 += (listOrigenDestino.size() - 1);
                    tiempoRuta1 += (listDestinoOrigen.size() - 1);
                }
                if(!listOrigenAtras.isEmpty() && !listDestinoAtras.isEmpty()){
                    int linOA = listOrigenAtras.getLast().getNumLinea();
                    int estOA = listOrigenAtras.getLast().getNumEstLin();
                    int linDA = listDestinoAtras.getLast().getNumLinea();
                    int estDA = listDestinoAtras.getLast().getNumEstLin();
                    numCruY = BuscarNodoCruce(linOA, estOA);
                    numCruZ = BuscarNodoCruce(linDA, estDA);
                    tiempoRuta2 = MatrizM[numCruY][numCruZ];
                    tiempoRuta2 += (listDestinoAtras.size() - 1);
                    tiempoRuta2 += (listOrigenAtras.size() - 1);
                }
                if(tiempoRuta1 < tiempoRuta2){
                    trayeOri = (LinkedList) listOrigenDestino.clone();
                    trayeDes = (LinkedList) listDestinoOrigen.clone();
                    RutaCruce(numCruA, numCruB, listCruce);
                    for(Iterator<Integer> it = listCruce.iterator(); it.hasNext();){
                        Integer temp = it.next();
                        trayeCru.add(nodosCruce.get(temp));
                    }
                    tiempo = tiempoRuta1;
                }
                else{
                    trayeDes = (LinkedList) listOrigenAtras.clone();
                    trayeOri = (LinkedList) listDestinoAtras.clone();
                    RutaCruce(numCruY, numCruZ, listCruce);
                    for(Iterator<Integer> it = listCruce.iterator(); it.hasNext();){
                        Integer temp = it.next();
                        trayeCru.add(nodosCruce.get(temp));
                    }
                    tiempo = tiempoRuta2;
                }
            }
        }
        else{
            trayeOri = (LinkedList) listOrigenDestino.clone();
                tiempo = (listOrigenDestino.size() - 1);
        }
    }
    
    private LinkedList<Estacion> DestinoAtras(int lin, int estDes, int estOri){
        LinkedList<Estacion> trayectD = new LinkedList();
        LinkedList<Estacion> linea = TomarLinea(lin);
        for(int i = estDes; i < linea.getLast().getNumEstLin(); i++){
            if(i == linea.size()){
                //No Regresa nada si se acaba la linea y no encuentra una estacion
                //de cruce.
                break;
            }
            else{
                if(linea.get(i).getNumEstLin()!= estOri){
                    if(linea.get(i).getTipo() == 1){
                        if(linea.get(i).getStatus() == 1){
                            trayectD = TomarEstacionesPasoAum(lin, estDes, i);
                            break;
                        }
                        else{
                            //No regresa nada porque encontro un puto de cruce pero 
                            //este esta deshabilitado.
                            break;
                        }
                    }
                    else{
                        //Nada
                    }
                }
                else{
                    trayectD = TomarEstacionesPasoAum(lin, estDes, i);
                    break;
                }
            }
        }    
        return trayectD;
    }
    
    private LinkedList<Estacion> DestinoOrigen(int lin, int estDes, int estOri){
        LinkedList<Estacion> trayectD = new LinkedList();
        LinkedList<Estacion> linea = TomarLinea(lin);
        for(int i = estOri; i <= linea.getLast().getNumEstLin(); i--){
            if(linea.get(i).getNumEstLin()!= estDes){
                if(linea.get(i).getTipo() == 1){
                    if(linea.get(i).getStatus() == 1){
                        trayectD = TomarEstacionesPasoDes(lin, estOri, i);
                        break;
                    }
                    else{
                        //No regresa nada porque encontro un puto de cruce pero 
                        //este esta deshabilitado.
                        break;
                    }
                }
                else{
                    //Nada
                }
            }
            else{
                trayectD = TomarEstacionesPasoDes(lin, estOri, i);
                break;
            }
        }
        return trayectD;
    }
    
    /**
     * Función que se encarga de mostrar las estaciones o los puntos de interes
     * de la linea que se le especifico.
     * 
     * @param num
     * Numero de la lista que debe mostrar.
     */
    public void Estacion_O_PuntoInteres(int num){
        Scanner sc = new Scanner(System.in);
        LinkedList<Estacion> listEPI = TomarLinea(num);
        System.out.println("Estaciones(E)/Puntos de Interes(PI)");
        String op;
        System.out.print("Opcion: ");
        op = sc.next();
        switch (op) {
            case "E":
                MostrarEstaciones(listEPI, num);
                break;
            case "PI":
                MostrarPuntoInt(listEPI, num);
                break;
            default:
                System.out.println("¡Opcion invalida!");
                break;
        }
    }
    
    /**
     * Función que sirve para aplicar el algoritmo de floyd a las matrices.
     * 
     * @param T
     * Matriz que tiene la matriz de cruce en su estado inicial.
     * 
     * @param M
     * Matriz que contiene las estaciones de cruce y a que distancia estan. 
     * 
     * @return 
     * Regresa la matriz ya modificada con los nuevos valores.
     */
    public int[][] Floyd(int[][] T, int[][] M){
        int k, i, j;
        for(k = 0; k <= M[0].length-1; k++){
            for(i = 0; i <= M[0].length-1; i++){
                for(j = 0; j <= M[0].length-1; j++){
                    if(M[i][k] + M[k][j] < M[i][j]){
                        M[i][j] = M[i][k] + M[k][j];
                        T[i][j] = k;
                    }
                }
            }
        }
        return T;
    }
    
    /**
     * Esta función se encarga de imprimir el trayecto simple (o sea el que no
     * cambia de linea) de acuerdo a los valores que se insertaron en la lista.
     * 
     */
    private void ImprimirTrayectoSimple(){
        LinkedList<Estacion> linTra = TomarLinea(trayeOri.getFirst().getNumLinea());
        System.out.println("\n------------------------------------------------");
        System.out.println("Tomar la linea: " + trayeOri.getFirst().getNumLinea() + 
                ", Estacion: " + trayeOri.getFirst().getNombreEst() + 
                " con direcion: " + (trayeOri.getLast().getNumEstLin() > 
                        trayeOri.getFirst().getNumEstLin() ? 
                        linTra.getLast().getNombreEst() : 
                        linTra.getFirst().getNombreEst()));
        trayeOri.removeFirst();
        System.out.println("\nPasara por las estaciones: ");
        for(Iterator<Estacion> it = trayeOri.iterator(); it.hasNext();){
            Estacion temp = it.next();
            System.out.println("- " + temp.getNombreEst());
            if(!temp.getPuntosInteres().equals("")){
                String[] puntos;
                puntos = (temp.getPuntosInteres()).split(",");
                System.out.println("\t Puntos de interes:");
                for(int i = 0; i < puntos.length; i++){
                    System.out.println("\t\t = " + puntos[i]);
                }
            }
        }
        System.out.println("Bajar en la estación: " + trayeOri.getLast().getNombreEst());
        System.out.println("Has llegado a tu destino.\n");
        System.out.println("Tiempo estimado: " + (tiempo));
        System.out.println("Numero de Transbordos: " + transbordos);
        System.out.println("------------------------------------------------");
        trayeOri.clear();
    }
    
    /**
     * Esta función imprime la ruta que se debe tomar del origen a la primera
     * estacion de cruce.
     */
    private void ImprimirTrayectoAB(){
        LinkedList<Estacion> linTra = new LinkedList();
        System.out.println("\n------------------------------------------------");
        if(trayeOri.size() == 1){
            int nodoCruce = BuscarNodoCruce(trayeOri.getFirst().getNumLinea(), trayeOri.getFirst().getNumEstLin());
            if(nodosCruce.get(nodoCruce).getLineaA() == trayeCru.get(1).getLineaA() || 
                    nodosCruce.get(nodoCruce).getLineaA() == trayeCru.get(1).getLineaB()){
                linTra = TomarLinea(nodosCruce.get(nodoCruce).getLineaA());
                if(nodosCruce.get(nodoCruce).getLineaA() == trayeCru.get(1).getLineaA()){
                    System.out.println("Tomar la linea: " + nodosCruce.get(nodoCruce).getLineaA() + 
                        ", Estacion: " + trayeOri.getFirst().getNombreEst() +
                        " con direcion: " + (trayeOri.getFirst().getNumEstLin() > 
                        trayeCru.get(1).getEstacionA() ? linTra.getLast().getNombreEst() : linTra.getFirst().getNombreEst()));
                }                   
                else{
                    System.out.println("Tomar la linea: " + nodosCruce.get(nodoCruce).getLineaA() + 
                        ", Estacion: " + trayeOri.getFirst().getNombreEst() +
                        " con direcion: " + (trayeOri.getFirst().getNumEstLin() < 
                        trayeCru.get(1).getEstacionB() ? linTra.getLast().getNombreEst() : linTra.getFirst().getNombreEst()));
                }
            }
            else if(nodosCruce.get(nodoCruce).getLineaB() == trayeCru.get(1).getLineaA() || 
                    nodosCruce.get(nodoCruce).getLineaB() == trayeCru.get(1).getLineaB()){
                linTra = TomarLinea(nodosCruce.get(nodoCruce).getLineaB());
                if(nodosCruce.get(nodoCruce).getLineaB() == trayeCru.get(1).getLineaA()){
                    System.out.println("Tomar la linea: " + nodosCruce.get(nodoCruce).getLineaB() + 
                        ", Estacion: " + trayeOri.getFirst().getNombreEst() +
                        " con direcion: " + (trayeOri.getFirst().getNumEstLin() < 
                        trayeCru.get(1).getEstacionA() ? linTra.getLast().getNombreEst() : linTra.getFirst().getNombreEst()));
                }                   
                else{
                    System.out.println("Tomar la linea: " + nodosCruce.get(nodoCruce).getLineaB() + 
                        ", Estacion: " + trayeOri.getFirst().getNombreEst() +
                        " con direcion: " + (trayeOri.getFirst().getNumEstLin() > 
                        trayeCru.get(1).getEstacionB() ? linTra.getLast().getNombreEst() : linTra.getFirst().getNombreEst()));
                }
            }
        }
        else{
            linTra = TomarLinea(trayeOri.getFirst().getNumLinea());
            System.out.println("Tomar la linea: " + trayeOri.getFirst().getNumLinea() + 
                ", Estacion: " + trayeOri.removeFirst().getNombreEst() + 
                " con direcion: " + (trayeOri.getLast().getNumEstLin() > 
                        trayeOri.getFirst().getNumEstLin() ? 
                        linTra.getLast().getNombreEst() : 
                        linTra.getFirst().getNombreEst()));
            System.out.println("\nPasara por las estaciones: ");
            for(Iterator<Estacion> it = trayeOri.iterator(); it.hasNext();){
                Estacion temp = it.next();
                System.out.println("- " + temp.getNombreEst());
                if(!temp.getPuntosInteres().equals("")){
                    String[] puntos;
                    puntos = (temp.getPuntosInteres()).split(",");
                    System.out.println("\t Puntos de interes:");
                 for(int i = 0; i < puntos.length; i++){
                        System.out.println("\t\t = " + puntos[i]);
                    }
                }
            }
        }
    }
    
    /**
     * Esta función muestra el trayecto que se debe seguir cuando el recorrido
     * necesita pasar por estaciones de cruce, de acuerdo con los valores que se
     * agregaron a la lista.
     */
    public void ImprimirTrayectoCruce(){
        int j = 1;
        int lineaOri = 0;
        int nodoCruce = BuscarNodoCruce(trayeOri.getFirst().getNumLinea(), trayeOri.getFirst().getNumEstLin());
        if(nodoCruce != 99){
            if(nodosCruce.get(nodoCruce).getLineaA() == trayeCru.get(1).getLineaA() || 
                    nodosCruce.get(nodoCruce).getLineaA() == trayeCru.get(1).getLineaB() ||
                        nodosCruce.get(nodoCruce).getLineaA() == trayeCru.get(1).getLineaC()){
                lineaOri = nodosCruce.get(nodoCruce).getLineaA();
            }
            else if(nodosCruce.get(nodoCruce).getLineaB() == trayeCru.get(1).getLineaA() || 
                        nodosCruce.get(nodoCruce).getLineaB() == trayeCru.get(1).getLineaB() ||
                            nodosCruce.get(nodoCruce).getLineaB() == trayeCru.get(1).getLineaC()){
                lineaOri = nodosCruce.get(nodoCruce).getLineaB();
            }
            else if(nodosCruce.get(nodoCruce).getLineaC() == trayeCru.get(1).getLineaA() || 
                        nodosCruce.get(nodoCruce).getLineaC() == trayeCru.get(1).getLineaB() ||
                            nodosCruce.get(nodoCruce).getLineaC() == trayeCru.get(1).getLineaC()){
                lineaOri = nodosCruce.get(nodoCruce).getLineaC();
            }
        }
        else{
            lineaOri = trayeOri.getFirst().getNumLinea();
        }
        int lineaActual = lineaOri;
        int lineaDes = trayeDes.getFirst().getNumLinea();
        for(Iterator<NodoCruce> it = trayeCru.iterator(); it.hasNext(); j++){
            NodoCruce tmpCru = it.next();
            if(tmpCru.getLineaA() == lineaActual || tmpCru.getLineaB() == lineaActual || tmpCru.getLineaC() == lineaActual){
                if(j <= (trayeCru.size()-1)){
                    if(trayeCru.get(j).getLineaA() == lineaActual || trayeCru.get(j).getLineaB() == lineaActual || trayeCru.get(j).getLineaC() == lineaActual){
                        //Seguir en la misma linea
                        System.out.println("- Seguir en la linea " + lineaActual);
                    }
                    else{
                        //Comprobacion linea A 
                        if(tmpCru.getLineaA() == trayeCru.get(j).getLineaA() || tmpCru.getLineaA() == trayeCru.get(j).getLineaB() || tmpCru.getLineaA() == trayeCru.get(j).getLineaC()){
                            lineaActual = tmpCru.getLineaA();
                            LinkedList<Estacion> linTra = TomarLinea(lineaActual);
                            System.out.println("+ Bajar de la estacion " + linTra.get(tmpCru.getEstacionA()).getNombreEst());
                            if(tmpCru.getLineaA() == trayeCru.get(j).getLineaA()){
                                System.out.println("\t- Transbordar a linea: " + lineaActual + " con direccion " + 
                                        (tmpCru.getEstacionA() > trayeCru.get(j).getEstacionA() ? 
                                                linTra.getFirst().getNombreEst() : linTra.getLast().getNombreEst()));
                            }
                            else{
                                System.out.println("\t- Transbordar a linea: " + lineaActual + " con direccion " + 
                                        (tmpCru.getEstacionA() > trayeCru.get(j).getEstacionB() ? 
                                                linTra.getFirst().getNombreEst() : linTra.getLast().getNombreEst()));
                            }
                            transbordos += 1;
                            tiempo += 3;
                        }
                        //Comprobacion linea B
                        else if(tmpCru.getLineaB() == trayeCru.get(j).getLineaA() || tmpCru.getLineaB() == trayeCru.get(j).getLineaB() || tmpCru.getLineaB() == trayeCru.get(j).getLineaC()){
                            lineaActual = tmpCru.getLineaB();
                            LinkedList<Estacion> linTra = TomarLinea(lineaActual);
                            System.out.println("+ Bajar de la estacion " + linTra.get(tmpCru.getEstacionB()).getNombreEst());
                            if(tmpCru.getLineaB() == trayeCru.get(j).getLineaA()){
                                System.out.println("\t- Transbordar a linea: " + lineaActual + " con direccion " + 
                                        (tmpCru.getEstacionB() > trayeCru.get(j).getEstacionA() ? 
                                                linTra.getFirst().getNombreEst() : linTra.getLast().getNombreEst()));
                            }
                            else{
                                System.out.println("\t- Transbordar a linea: " + lineaActual + " con direccion " + 
                                        (tmpCru.getEstacionB() > trayeCru.get(j).getEstacionB() ? 
                                                linTra.getFirst().getNombreEst() : linTra.getLast().getNombreEst()));
                            }
                            transbordos += 1;
                            tiempo += 3;
                        }
                        //Comprobacion linea C
                        else if(tmpCru.getLineaC() == trayeCru.get(j).getLineaA() || tmpCru.getLineaC() == trayeCru.get(j).getLineaC() || tmpCru.getLineaC() == trayeCru.get(j).getLineaC()){
                            lineaActual = tmpCru.getLineaC();
                            LinkedList<Estacion> linTra = TomarLinea(lineaActual);
                            System.out.println("+ Bajar de la estacion " + linTra.get(tmpCru.getEstacionC()).getNombreEst());
                            if(tmpCru.getLineaC() == trayeCru.get(j).getLineaA()){
                                System.out.println("\t- Transbordar a linea: " + lineaActual + " con direccion " + 
                                        (tmpCru.getEstacionC() > trayeCru.get(j).getEstacionA() ? 
                                                linTra.getFirst().getNombreEst() : linTra.getLast().getNombreEst()));
                            }
                            else{
                                System.out.println("\t- Transbordar a linea: " + lineaActual + " con direccion " + 
                                        (tmpCru.getEstacionC() > trayeCru.get(j).getEstacionC() ? 
                                                linTra.getFirst().getNombreEst() : linTra.getLast().getNombreEst()));
                            }
                            transbordos += 1;
                            tiempo += 3;
                        }
                    }
                }
                else{
                    if(lineaActual != lineaDes){
                        if(trayeDes.size() > 1){
                            LinkedList<Estacion> linTra = TomarLinea(trayeDes.getFirst().getNumLinea());
                            System.out.println("Bajar en la estacion: " + trayeDes.getLast().getNombreEst());
                            System.out.println("Transbordar a la linea " + trayeDes.getFirst().getNumLinea() + " con direccion " + 
                                    (trayeDes.getLast().getNumEstLin() > trayeDes.getFirst().getNumEstLin() ? 
                                        linTra.getFirst().getNombreEst() : linTra.getLast().getNombreEst()));
                        transbordos += 1;
                        tiempo += 3;
                        }
                    }
                }
            }
        }
    }
    
    /**
     * Esta función imprime la ruta que se debe tomar de la ultima estación de 
     * cruce al destino.
     * 
     */
    private void ImprimirTrayectoBA(){
        if(!trayeOri.getLast().getNombreEst().equals(trayeDes.getFirst().getNombreEst())){
            if(trayeOri.getLast().getNombreEst().equals(trayeDes.getLast().getNombreEst())){
                trayeDes.removeLast();
            }
            System.out.println("\nPasara por las estaciones: ");
            for(int x = (trayeDes.size() - 1); x >= 0; x--){
                System.out.println("- " + trayeDes.get(x).getNombreEst());
                if(!trayeDes.get(x).getPuntosInteres().equals("")){
                    String[] puntos;
                    puntos = (trayeDes.get(x).getPuntosInteres()).split(",");
                    System.out.println("\t Puntos de interes:");
                    for(int i = 0; i < puntos.length; i++){
                        System.out.println("\t\t = " + puntos[i]);
                    }
                }
            }
        }
        System.out.println("Bajar en la estación: " + trayeDes.getFirst().getNombreEst());
        System.out.println("Has llegado a tu destino.\n");
        System.out.println("Tiempo estimado: " + tiempo);
        System.out.println("Numero de Transbordos: " + transbordos);
        System.out.println("------------------------------------------------");
    }
    
    /**
     * Función que se encarga de mostrar las estación que contiene la lista
     * que se le especifico.
     * 
     * @param lista 
     * La lista de la cual se van a leer los datos.
     * 
     * @param lin 
     * La linea a la que pertenecen las estaciones.
     */
    private void MostrarEstaciones(LinkedList lista, int lin){
        System.out.println("\n-------------------------");
        System.out.println("Estaciones de la linea " + lin + "\n");
        for (Iterator<Estacion> it = lista.iterator(); it.hasNext();) {
            Estacion temp = it.next();
            System.out.println((temp.getNumEstLin() + 1) + " - " + temp.getNombreEst() + " " + temp.getStatus());
        }
        System.out.println("-------------------------");
    }
    
    /**
     * Función que se encarga de llamar a la linea que se le especifique para
     * posteriormente llamar al metodo que muestra el punto de interes o las
     * estaciones que contiene la linea.
     */
    public void MostrarLinea(){
        Scanner scan = new Scanner(System.in);
        try{
            System.out.println("¿Que linea quieres ver?");
            System.out.print("Linea: ");
            String entrada = scan.next();
            int lin = Integer.parseInt(entrada);
            switch(lin){
                case 1:
                    Estacion_O_PuntoInteres(lin);
                    break;
                case 2:
                    Estacion_O_PuntoInteres(lin);
                    break;
                case 3:
                    Estacion_O_PuntoInteres(lin);
                    break;
                case 4:
                    Estacion_O_PuntoInteres(lin);
                    break;
                case 5:
                    Estacion_O_PuntoInteres(lin);
                    break;
                case 6:
                    Estacion_O_PuntoInteres(lin);
                    break;
                case 7:
                    Estacion_O_PuntoInteres(lin);
                    break;
                case 8:
                    Estacion_O_PuntoInteres(lin);
                    break;
                default:
                    System.out.println("¡Opcion no valida!");
                    break;
            }
        }
        catch(NumberFormatException e){
            System.out.println("¡Debe de ser un valor numerico!");
        }
    }
    
    /**
     * Función que se encarga de mostrar los puntos de interes de las estaciones
     * que contengan puntos de interes.
     * 
     * @param lista
     * La lista de la cual se van a leer los datos.
     * 
     * @param lin 
     * La linea a la que pertenecen los puntos de interes
     */
    private void MostrarPuntoInt(LinkedList lista, int lin){
        System.out.println("\n-------------------------");
        System.out.println("Puntos de Interes de la linea " + lin + "\n");
        for (Iterator<Estacion> it = lista.iterator(); it.hasNext();) {
            Estacion temp = it.next();
            if(temp.getPuntosInteres().equals("")){

            }
            else{
                String[] puntos;
                System.out.println("Estacion: " + temp.getNombreEst());
                puntos = (temp.getPuntosInteres()).split(",");
                System.out.println(" Puntos de interes:");
                for(int i = 0; i < puntos.length; i++){
                    System.out.println("\t = " + puntos[i]);
                }
                System.out.println();
            }
        }
        System.out.println("-------------------------");
    }
    
    /**
     * Función que muestra el menu para ingresar los datos y planear un trayecto
     * a travez del SITEUR.
     */
    public void PlanearRuta(){
        Scanner scan = new Scanner(System.in);
        String destino, origen;
        int[] resultDes, resultOri;
        System.out.println("\n------------------------------------------------");
        System.out.println("Ingresar estacion de origen:");
        origen = scan.nextLine();
        System.out.println("Ingresar estacion de destino:");
        destino = scan.nextLine();
        resultOri = Busqueda(origen);
        resultDes = Busqueda(destino);
        if(resultDes[0] != 0 && resultOri[0] != 0){
            Ruta(resultDes, resultOri);
        }
        else{
            System.out.println("\nLa estacion " + origen + ((resultOri[0] == 0) ? 
                " no se encontro en ninguna linea" : " se encontro en la linea: " + 
                        resultOri[0] + " numero de estacion: " + resultOri[1]));
            System.out.println("\nLa estacion " + destino + ((resultDes[0] == 0) ? 
                " no se encontro en ninguna linea" : " se encontro en la linea: " + 
                        resultDes[0] + " numero de estacion: " + resultDes[1]));
        }
        System.out.println("------------------------------------------------");
    }
    
    /**
     * Esta función se encarga de mostrar los puntos de interes.
     * 
     * @param puntos
     * 
     * @param entrada
     * @return 
     */
    private boolean PuntoInteres(String puntos, String entrada){
        boolean resp = false;
        if(!puntos.equals("")){
            String[] punInt;
            punInt = puntos.split(",");
            for(int i = 0; i < punInt.length; i++){
                if(entrada.equals(punInt[i]))
                    resp = true;
            }
        }
        else{
            resp = false;
        }
        return resp;
    }
    
    /**
     * Función que se encarga de determinar cual es que caso que se va usar para
     * planear el trayecto actual y validar si las estaciones están en la misma
     * linea o en diferente linea.
     * 
     * @param destino
     * Recibe el arreglo que contiene el numero de linea y el numero de estación
     * destino.
     * 
     * @param origen 
     * Recibe el arreglo que contiene el numero de linea y el numero de estación
     * origen.
     */
    private void Ruta(int[]destino, int[]origen){
        int linEstDes = destino[0], numEstDes = destino[1];
        int linEstOri = origen[0], numEstOri = origen[1];
        if(linEstDes == linEstOri){
            int desCruce = BuscarNodoCruce(linEstDes, numEstDes);
            int oriCruce = BuscarNodoCruce(linEstOri, numEstOri);
            if(desCruce == 99 || oriCruce == 99){
                if(numEstDes > numEstOri){
                    Asciende(linEstDes, numEstDes, numEstOri);
                }
                else if(numEstDes < numEstOri){
                    Desciende(linEstDes, numEstDes, numEstOri);
                }
                else{
                    System.out.println("\n!!!Estas en la misma estación >:v¡¡¡");
                }
            }
            else{
                DiferenteLinea(linEstOri, numEstOri, linEstDes, numEstDes);
            }
        }
        else{
            DiferenteLinea(linEstOri, numEstOri, linEstDes, numEstDes);
        }
        if(!trayeOri.isEmpty()){
            if(trayeCru.isEmpty() || trayeDes.isEmpty()){
                ImprimirTrayectoSimple();
            }
            else{
                ImprimirTrayectoAB();
                ImprimirTrayectoCruce();
                ImprimirTrayectoBA();
            }
        }
        else{
            System.out.println("\n¡¡¡Destino Inaccesible!!!");
        }
       trayeOri.clear();
       trayeCru.clear();
       trayeDes.clear();
       transbordos = 0;
       tiempo = 0;
    }
    
    /**
     * Esta funcion sirve para tomar las estaciones por las que se pasa, tanto
     * del origen a la primera estacion de cruce, como del estino a la primera
     * estación de cruce.
     * 
     * @param linOri
     * Numero de linea de la estacion de origen.
     * 
     * @param estOri
     * Numero de la estacion de origen.
     * 
     * @param linDes
     * Numero de linea de la estación de destino.
     * 
     * @param estDes
     * Numero de la estación de destino.
     */
    private void DiferenteLinea(int linOri, int estOri, int linDes, int estDes){
        int tiempoRuta1 = 99, tiempoRuta2 = 99;
        LinkedList<Integer> listCruce = new LinkedList();
        LinkedList<Estacion> listOriAdelante = new LinkedList();
        LinkedList<Estacion> listOriAtras = new LinkedList();
        LinkedList<Estacion> listDesAdelante = new LinkedList();
        LinkedList<Estacion> listDesAtras = new LinkedList();
        listOriAdelante = Ascendente(linOri, estOri);
        listOriAtras = Descendente(linOri, estOri);
        listDesAdelante = Ascendente(linDes, estDes);
        listDesAtras = Descendente(linDes, estDes);
        int numCruA = 0, numCruB = 0, numCruX = 0,numCruY = 0;
        if(!listOriAdelante.isEmpty() && !listOriAtras.isEmpty() && !listDesAdelante.isEmpty() && !listDesAtras.isEmpty()){
            numCruA = BuscarNodoCruce(listOriAdelante.getLast().getNumLinea(), listOriAdelante.getLast().getNumEstLin());
            numCruB = BuscarNodoCruce(listOriAtras.getLast().getNumLinea(), listOriAtras.getLast().getNumEstLin());
            numCruX = BuscarNodoCruce(listDesAdelante.getLast().getNumLinea(), listDesAdelante.getLast().getNumEstLin());
            numCruY = BuscarNodoCruce(listDesAtras.getLast().getNumLinea(), listDesAtras.getLast().getNumEstLin());
            if(numCruA == numCruB && numCruX == numCruY){
                tiempoRuta1 = MatrizM[numCruA][numCruX];
                tiempoRuta1 += (listOriAdelante.size() - 1);
                tiempoRuta1 += (listDesAdelante.size() - 1);
                trayeOri = (LinkedList) listOriAdelante.clone();
                trayeDes = (LinkedList) listDesAdelante.clone();
                RutaCruce(numCruA, numCruX, listCruce);
                for(Iterator<Integer> it = listCruce.iterator(); it.hasNext();){
                    Integer temp = it.next();
                    trayeCru.add(nodosCruce.get(temp));
                }
                tiempo = tiempoRuta1;
            }
            else if(numCruA == numCruY && numCruB == numCruX){
                tiempoRuta1 = MatrizM[numCruA][numCruB];
                tiempoRuta1 += (listOriAdelante.size() - 1);
                tiempoRuta1 += (listDesAdelante.size() - 1);
                trayeOri = (LinkedList) listOriAdelante.clone();
                trayeDes = (LinkedList) listDesAdelante.clone();
                RutaCruce(numCruA, numCruB, listCruce);
                for(Iterator<Integer> it = listCruce.iterator(); it.hasNext();){
                    Integer temp = it.next();
                    trayeCru.add(nodosCruce.get(temp));
                }
                tiempo = tiempoRuta1;
            }
            else{
                tiempoRuta1 = MatrizM[numCruA][numCruX];
                tiempoRuta1 += (listOriAdelante.size() - 1);
                tiempoRuta1 += (listDesAdelante.size() - 1);
                
                tiempoRuta2 = MatrizM[numCruB][numCruY];
                tiempoRuta2 += (listOriAtras.size() - 1);
                tiempoRuta2 += (listDesAtras.size() - 1);
                if(tiempoRuta1 < tiempoRuta2){
                    trayeOri = (LinkedList) listOriAdelante.clone();
                    trayeDes = (LinkedList) listDesAdelante.clone();
                    RutaCruce(numCruA, numCruX, listCruce);
                    for(Iterator<Integer> it = listCruce.iterator(); it.hasNext();){
                        Integer temp = it.next();
                        trayeCru.add(nodosCruce.get(temp));
                    }
                    tiempo = tiempoRuta1;
                }
                else{
                    trayeOri = (LinkedList) listOriAtras.clone();
                    trayeDes = (LinkedList) listDesAtras.clone();
                    RutaCruce(numCruB, numCruY, listCruce);
                    for(Iterator<Integer> it = listCruce.iterator(); it.hasNext();){
                        Integer temp = it.next();
                        trayeCru.add(nodosCruce.get(temp));
                    }
                    tiempo = tiempoRuta2;
                }
            }
        }
        else if(!listOriAdelante.isEmpty() && (!listDesAdelante.isEmpty() || !listDesAtras.isEmpty())){
            numCruA = BuscarNodoCruce(listOriAdelante.getLast().getNumLinea(), 
                    listOriAdelante.getLast().getNumEstLin());
            if(!listDesAdelante.isEmpty()){
                numCruX = BuscarNodoCruce(listDesAdelante.getLast().getNumLinea(), 
                    listDesAdelante.getLast().getNumEstLin());
                tiempoRuta1 = MatrizM[numCruA][numCruX];
                tiempoRuta1 += (listOriAdelante.size() - 1);
                tiempoRuta1 += (listDesAdelante.size() - 1);
            }
            if(!listDesAtras.isEmpty()){
                numCruY = BuscarNodoCruce(listDesAtras.getLast().getNumLinea(), 
                    listDesAtras.getLast().getNumEstLin());
                tiempoRuta2 = MatrizM[numCruA][numCruY];
                tiempoRuta2 += (listOriAdelante.size() - 1);
                tiempoRuta2 += (listDesAtras.size() - 1);
            }
            if(tiempoRuta1 < tiempoRuta2){
                trayeOri = (LinkedList) listOriAdelante.clone();
                trayeDes = (LinkedList) listDesAdelante.clone();
                
                RutaCruce(numCruA, numCruX, listCruce);
                for(Iterator<Integer> it = listCruce.iterator(); it.hasNext();){
                    Integer temp = it.next();
                    trayeCru.add(nodosCruce.get(temp));
                }
                tiempo = tiempoRuta1;
            }
            else{
                trayeOri = (LinkedList) listOriAdelante.clone();
                trayeDes = (LinkedList) listDesAtras.clone();
                RutaCruce(numCruA, numCruY, listCruce);
                for(Iterator<Integer> it = listCruce.iterator(); it.hasNext();){
                    Integer temp = it.next();
                    trayeCru.add(nodosCruce.get(temp));
                }
                tiempo = tiempoRuta2;
            }
        }
        else if(!listOriAtras.isEmpty() && (!listDesAdelante.isEmpty() || !listDesAtras.isEmpty())){
            numCruA = BuscarNodoCruce(listOriAtras.getLast().getNumLinea(), 
                    listOriAtras.getLast().getNumEstLin());
            if(!listDesAdelante.isEmpty()){
                numCruX = BuscarNodoCruce(listDesAdelante.getLast().getNumLinea(), 
                    listDesAdelante.getLast().getNumEstLin());
                tiempoRuta1 = MatrizM[numCruA][numCruX];
                tiempoRuta1 += (listOriAtras.size() - 1);
                tiempoRuta1 += (listDesAdelante.size() - 1);
            }
            if(!listDesAtras.isEmpty()){
                numCruY = BuscarNodoCruce(listDesAtras.getLast().getNumLinea(), 
                    listDesAtras.getLast().getNumEstLin());
                tiempoRuta2 = MatrizM[numCruA][numCruY];
                tiempoRuta2 += (listOriAtras.size() - 1);
                tiempoRuta2 += (listDesAtras.size() - 1);
            }
            if(tiempoRuta1 < tiempoRuta2){
                trayeOri = (LinkedList) listOriAtras.clone();
                trayeDes = (LinkedList) listDesAdelante.clone();
                
                RutaCruce(numCruA, numCruX, listCruce);
                for(Iterator<Integer> it = listCruce.iterator(); it.hasNext();){
                    Integer temp = it.next();
                    trayeCru.add(nodosCruce.get(temp));
                }
                tiempo = tiempoRuta1;
            }
            else{
                trayeOri = (LinkedList) listOriAtras.clone();
                trayeDes = (LinkedList) listDesAtras.clone();
                RutaCruce(numCruA, numCruY, listCruce);
                for(Iterator<Integer> it = listCruce.iterator(); it.hasNext();){
                    Integer temp = it.next();
                    trayeCru.add(nodosCruce.get(temp));
                }
                tiempo = tiempoRuta2;
            }
        }
        else if(!listDesAdelante.isEmpty() && (!listOriAdelante.isEmpty() || !listOriAtras.isEmpty())){
            numCruA = BuscarNodoCruce(listDesAdelante.getLast().getNumLinea(), listDesAdelante.getLast().getNumEstLin());
            if(!listOriAdelante.isEmpty()){
                numCruX = BuscarNodoCruce(listOriAdelante.getLast().getNumLinea(), 
                    listOriAdelante.getLast().getNumEstLin());
                tiempoRuta1 = MatrizM[numCruA][numCruX];
                tiempoRuta1 += (listDesAdelante.size() - 1);
                tiempoRuta1 += (listOriAdelante.size() - 1);
            }
            if(!listOriAtras.isEmpty()){
                numCruY = BuscarNodoCruce(listOriAtras.getLast().getNumLinea(), 
                    listOriAtras.getLast().getNumEstLin());
                tiempoRuta2 = MatrizM[numCruA][numCruY];
                tiempoRuta2 += (listDesAdelante.size() - 1);
                tiempoRuta2 += (listOriAtras.size() - 1);
            }
            if(tiempoRuta1 < tiempoRuta2){
                trayeOri = (LinkedList) listDesAdelante.clone();
                trayeDes = (LinkedList) listOriAdelante.clone();
                RutaCruce(numCruA, numCruX, listCruce);
                for(Iterator<Integer> it = listCruce.iterator(); it.hasNext();){
                    Integer temp = it.next();
                    trayeCru.add(nodosCruce.get(temp));
                }
                tiempo = tiempoRuta1;
            }
            else{
                trayeOri = (LinkedList) listDesAdelante.clone();
                trayeDes = (LinkedList) listOriAtras.clone();
                RutaCruce(numCruA, numCruY, listCruce);
                for(Iterator<Integer> it = listCruce.iterator(); it.hasNext();){
                    Integer temp = it.next();
                    trayeCru.add(nodosCruce.get(temp));
                }
                tiempo = tiempoRuta2;
            }
        }
        else if(!listDesAtras.isEmpty() && (!listOriAdelante.isEmpty() || !listOriAtras.isEmpty())){
            numCruA = BuscarNodoCruce(listDesAtras.getLast().getNumLinea(), listDesAtras.getLast().getNumEstLin());
            if(!listOriAdelante.isEmpty()){
                numCruX = BuscarNodoCruce(listOriAdelante.getLast().getNumLinea(), 
                    listOriAdelante.getLast().getNumEstLin());
                tiempoRuta1 = MatrizM[numCruA][numCruX];
                tiempoRuta1 += (listDesAtras.size() - 1);
                tiempoRuta1 += (listOriAdelante.size() - 1);
            }
            if(!listOriAtras.isEmpty()){
                numCruY = BuscarNodoCruce(listOriAtras.getLast().getNumLinea(), 
                    listOriAtras.getLast().getNumEstLin());
                tiempoRuta2 = MatrizM[numCruA][numCruY];
                tiempoRuta2 += (listDesAtras.size() - 1);
                tiempoRuta2 += (listOriAtras.size() - 1);
            }
            if(tiempoRuta1 < tiempoRuta2){
                trayeOri = (LinkedList) listDesAtras.clone();
                trayeDes = (LinkedList) listOriAdelante.clone();
                RutaCruce(numCruA, numCruX, listCruce);
                for(Iterator<Integer> it = listCruce.iterator(); it.hasNext();){
                    Integer temp = it.next();
                    trayeCru.add(nodosCruce.get(temp));
                }
                tiempo = tiempoRuta1;
            }
            else{
                trayeOri = (LinkedList) listDesAtras.clone();
                trayeDes = (LinkedList) listOriAtras.clone();
                RutaCruce(numCruA, numCruY, listCruce);
                for(Iterator<Integer> it = listCruce.iterator(); it.hasNext();){
                    Integer temp = it.next();
                    trayeCru.add(nodosCruce.get(temp));
                }
                tiempo = tiempoRuta2;
            }
        }
    }
    
    /**
     * Esta es la función más importante del proyecto ya que se encarga de usar
     * el algoritmo de Floyd para poder sacar la ruta de cruce.
     * 
     * @param A
     * Es la estación donde se inicia el cruce.
     * 
     * @param B
     * Es la estación donde se termina el cruce.
     * 
     * @param lstCru
     * Toma como parametro la lista de cruce, a la cual se iran agregando las
     * estaciones de cruce por las que se pase.
     * 
     * @return
     * Regresa la lista de cruce con las estaciones por las que pasa.
     */
    private int RutaCruce(int A, int B, LinkedList lstCru){
        int pos, temp;
        temp = MatrizT[A][B];
        if(lstCru.isEmpty()){
           lstCru.add(A);
           lstCru.add(B);
           if (temp != 99){
               pos = lstCru.indexOf(A);
               lstCru.add(pos + 1,temp);
               RutaCruce(A, temp, lstCru);
               RutaCruce(temp, B, lstCru);
            }
        }
        if (temp != 99){       
            pos = lstCru.indexOf(A);
            if(!lstCru.contains(temp)){
                lstCru.add(pos + 1, temp);
                RutaCruce(A, temp, lstCru);
                RutaCruce(temp, B, lstCru);
            }
        }        
        return 0;
    }
    
    /**
     * Función que regresa la lista que se le especifica.
     * 
     * @param lin
     * Numero de la linea que debe de regresar.
     * 
     * @return 
     * La lista especificada.
     */
    private LinkedList<Estacion> TomarLinea(int lin){
        LinkedList<Estacion> lineaActual = new LinkedList();
        switch(lin){
            case 1:
                lineaActual = linea1;
                break;
            case 2:
                lineaActual = linea2;
                break;
            case 3:
                lineaActual = linea3;
                break;
            case 4:
                lineaActual = linea4;
                break;
            case 5:
                lineaActual = linea5;
                break;
            case 6:
                lineaActual = linea6;
                break;
            case 7:
                lineaActual = linea7;
                break;
            case 8:
                lineaActual = linea8;
                break;
        }
        return lineaActual;
    }
    
    /**
     * Esta función toma las estaciones de manera descendente por las que se paso
     * y las va a agregando a una lista.
     * 
     * @param lin
     * Linea que se va a recorrer.
     * 
     * @param estacion
     * Estacion de la que se empezo.
     * 
     * @param encuentro
     * Estacion hasta la cual se va a recorrer.
     * 
     * @return
     * Regresa la lista con las estacion por las que se paso.
     */
    private LinkedList<Estacion> TomarEstacionesPasoDes(int lin, int estacion, int encuentro){
        LinkedList<Estacion> trayectD = new LinkedList();
        LinkedList<Estacion> linea = TomarLinea(lin);
        int j = 0;
        //trayectD.addLast(linea.getFirst());
        for(int i = estacion; i >= encuentro; i--, j++){
            trayectD.add(j, linea.get(i));
        }
        return trayectD;
    }
    
    /**
     * Esta función toma las estaciones de manera ascendente por las que se paso
     * y las va a agregando a una lista.
     * 
     * @param lin
     * Linea que se va a recorrer.
     * 
     * @param estacion
     * Estacion de la que se empezo.
     * 
     * @param encuentro
     * Estacion hasta la cual se va a recorrer.
     * 
     * @return
     * Regresa la lista con las estacion por las que se paso.
     */
    private LinkedList<Estacion> TomarEstacionesPasoAum(int lin, int estacion, int encuentro){
        LinkedList<Estacion> trayectD = new LinkedList();
        LinkedList<Estacion> linea = TomarLinea(lin);
        int j = 0;
        //trayectD.addLast(linea.getLast());
        for(int i = estacion; i <= encuentro; i++, j++){
            trayectD.add(j, linea.get(i));
        }
        return trayectD;
    }
    
    /**
     * Esta función recorre la linea de manera ascendente hasta encontrar una 
     * estacion de cruce o que llegue al inicio o final de la linea.
     * 
     * @param lin
     * Numero de la linea que se va a recorrer.
     * 
     * @param est
     * Numero de la estación donde va a empezar a ascender.
     * 
     * @return 
     * En caso de que si haya encontrado una ruta, regresa una lista con las 
     * estaciones por las que paso.
     */
    private LinkedList<Estacion> Ascendente(int lin, int est){
        LinkedList<Estacion> trayectD = new LinkedList();
        LinkedList<Estacion> linea = TomarLinea(lin);
        for(int i = est; i < linea.getLast().getNumEstLin(); i++){
            if(i == linea.size()){
                //No Regresa nada si se acaba la linea y no encuentra una estacion
                //de cruce.
                break;
            }
            else{
                if(linea.get(i).getTipo() == 1){
                    if(linea.get(i).getStatus() == 1){
                        trayectD = TomarEstacionesPasoAum(lin, est, i);
                        break;
                    }
                    else{
                        //No regresa nada porque encontro un puto de cruce pero 
                        //este esta deshabilitado.
                        break;
                    }
                }
            }
        }    
        return trayectD;
    }
    
    /**
     * Esta función recorre la linea de manera descendente hasta encontrar una 
     * estacion de cruce o que llegue al inicio o final de la linea.
     * 
     * @param lin
     * Numero de la linea que se va a recorrer.
     * 
     * @param est
     * Numero de la estación donde va a empezar a descender.
     * 
     * @return 
     * En caso de que si haya encontrado una ruta, regresa una lista con las 
     * estaciones por las que paso.
     */
    private LinkedList<Estacion> Descendente(int lin, int est){
        LinkedList<Estacion> trayectD = new LinkedList();
        LinkedList<Estacion> linea = TomarLinea(lin);
        for(int i = est; i > linea.getFirst().getNumEstLin(); i--){
            if(i == 0){
                //No Regresa nada si se acaba la linea y no encuentra una estacion
                //de cruce.
                break;
            }
            else{
                if(linea.get(i).getTipo() == 1){
                    if(linea.get(i).getStatus() == 1){
                        trayectD = TomarEstacionesPasoDes(lin, est, i);
                        break;
                    }
                    else{
                        //No regresa nada porque encontro un puto de cruce pero 
                        //este esta deshabilitado.
                        break;
                    }
                }
            }
        }    
        return trayectD;
    }
    
    /**
     * Esta función muestra el menú del administrador. En este menú se pueden 
     * habilitar/deshabilitar estaciones o volver a los valores predeterminados.
     */
    public void Administrador(){
        Scanner scan = new Scanner(System.in);
        System.out.println("\n------------------------------------------------");
        System.out.println(" Modo Administrador");
        System.out.println("------------------------------------------------");
        int opcion = 0;
        while(opcion != 3){
            try{
                System.out.println("\n------------------------------------------------");
                System.out.println("¿Que desea hacer?");
                System.out.println("1.- Deshabilitar/Habilitar Estaciones");
                System.out.println("2.- Volver a valores Predetermiandos");
                System.out.println("3.- Salir");
                System.out.println("------------------------------------------------");
                System.out.print("Seleccion: ");
                String entrada = scan.next();
                opcion = Integer.parseInt(entrada);
                switch(opcion){
                case 1:
                    DeshabilitarEstaciones();
                    break;
                case 2:
                    Iniciar();
                    break;
                case 3:
                    System.out.println("Regresando a la pantalla principal...");
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
    
    /**
     * Esta función muestra el menú para poder deshabilitar una estación.
     */
    private void DeshabilitarEstaciones(){
        MatrizM = CopiarMatriz(MatrizMTemp);
        Scanner scan = new Scanner(System.in);
        System.out.println("\n------------------------------------------------");
        System.out.println("Deshabilitar/Habilitar");
        System.out.println("------------------------------------------------");
        int entrada = 0;
        while(entrada!= 99){
            try{
                for(Iterator<NodoCruce> it = nodosCruce.iterator(); it.hasNext();){
                    NodoCruce temp = it.next();
                    LinkedList<Estacion> linTemp = TomarLinea(temp.getLineaA());
                    System.out.println(temp.getPosFloyd() + " " + linTemp.get(temp.getEstacionA()).getNombreEst());
                }
                System.out.println("------------------------------------------------");
                System.out.println("99 - Salir");
                System.out.println();
                System.out.println("Dame el numero de estacion que quieres Deshabilitar/Habilitar");
                System.out.print("Seleccion: ");
                entrada = scan.nextInt();
                if(entrada != 99){
                    for(int col = 0; col < MatrizM.length; col++){
                        MatrizM[entrada][col] = 99;
                        for(int lin = 0; lin < MatrizM[0].length; lin++){
                            MatrizM[lin][entrada] = 99;
                        }
                    }
                    ModificarActivo(nodosCruce.get(entrada).getLineaA(), nodosCruce.get(entrada).getEstacionA());
                    ModificarActivo(nodosCruce.get(entrada).getLineaB(), nodosCruce.get(entrada).getEstacionB());
                }
            }
            catch(NumberFormatException e){
                System.out.println("¡Debe de ser un valor numerico!");
            }
        }
        MatrizMTemp = CopiarMatriz(MatrizM);
        Floyd(MatrizT, MatrizM);
    }
    
    /**
     * Esta función deshabilita una estación de cruce, cambiando su valor en las
     * listas por 0.
     * 
     * @param lin
     * El numero de la linea al que pertenece la estacion que se quiere modificar.
     * 
     * @param est
     * El numero de la estación que se quiere deshabilitar.
     */
    private void ModificarActivo(int lin, int est){
        LinkedList<Estacion> list = TomarLinea(lin);
        list.get(est).setStatus(0);
        switch(lin){
            case 1:
                linea1 = list;
                break;
            case 2:
                linea2 = list;
                break;
            case 3:
                linea3 = list;
                break;
            case 4:
                linea4 = list;
                break;
            case 5:
                linea5 = list;
                break;
            case 6:
                linea6 = list;
                break;
            case 7:
                linea6 = list;
                break;
            case 8:
                linea6 = list;
                break;
        }
    }
}