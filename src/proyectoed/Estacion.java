/**
 *
 * @author Marlon Mejia
 * 
 * Esta clase crea la estructura de las estaciones. Esta estructura es la que 
 * tomaran las listas a la hora de que se carguen las estaciones de la base de 
 * datos.
 * 
 */

package proyectoed;

public class Estacion {
    private int idEstacion;
    private int numEstLin;
    private String nombreEst;
    private int numLinea;
    private String puntosInteres;
    private int tipo;
    private int status;

    public Estacion(int idEstacion, int numEstLin, String nombreEst, int numLinea, String puntosInteres, int tipo, int status) {
        this.idEstacion = idEstacion;
        this.numEstLin = numEstLin;
        this.nombreEst = nombreEst;
        this.numLinea = numLinea;
        this.puntosInteres = puntosInteres;
        this.tipo = tipo;
        this.status = status;
    }
    
    public Estacion() {
        idEstacion = 0;
        numEstLin = 0;
        nombreEst = " ";
        numLinea = 0;
        puntosInteres = " ";
        tipo = 0;
        status = 0;
    }

    public int getIdEstacion() { return idEstacion; }

    public void setIdEstacion(int idEstacion) { this.idEstacion = idEstacion; }
    
    public int getNumEstLin(){ return numEstLin; }
    
    public void setNumEstLin(int numEstLin){ this.numEstLin = numEstLin; }

    public String getNombreEst() { return nombreEst; }

    public void setNombreEst(String nombreEst) { this.nombreEst = nombreEst; }

    public int getNumLinea() { return numLinea; }

    public void setNumLinea(int numLinea) { this.numLinea = numLinea; }

    public String getPuntosInteres() { return puntosInteres; }

    public void setPuntosInteres(String puntosInteres) { this.puntosInteres = puntosInteres; }

    public int getTipo() { return tipo; }

    public void setTipo(int tipo) { this.tipo = tipo; }

    public int getStatus() { return status; }

    public void setStatus(int status) { this.status = status;}
}
