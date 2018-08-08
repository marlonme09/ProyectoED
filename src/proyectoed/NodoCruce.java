/**
 *
 * @author Marlon Mejia
 * 
 * Esta clase crea la estructura de los nodos de cruce. Esta es la estructura 
 * que tomaran las listas cuando se carguen los datos de la base de datos.
 */

package proyectoed;

public class NodoCruce {
    private int posFloyd;
    private int lineaA;
    private int estacionA;
    private int lineaB;
    private int estacionB;
    private int lineaC;
    private int estacionC;
    private int activo;

    public NodoCruce(int posFloyd, int lineaA, int EstacionA, int lineaB, int EstacionB, int lineaC, int EstacionC, int activo) {
        this.posFloyd = posFloyd;
        this.lineaA = lineaA;
        this.estacionA = EstacionA;
        this.lineaB = lineaB;
        this.estacionB = EstacionB;
        this.lineaC = lineaC;
        this.estacionC = EstacionC;
        this.activo = activo;
    }
    
    public NodoCruce(){
        posFloyd = 99;
        lineaA = 0;
        estacionA = 99;
        lineaB = 0;
        estacionB = 99;
        lineaC = 0;
        estacionC = 99;
        activo = 0;
    }

    public int getPosFloyd() {
        return posFloyd;
    }

    public void setPosFloyd(int posFloyd) {
        this.posFloyd = posFloyd;
    }

    public int getLineaA() {
        return lineaA;
    }

    public void setLineaA(int lineaA) {
        this.lineaA = lineaA;
    }

    public int getEstacionA() {
        return estacionA;
    }

    public void setEstacionA(int EstacionA) {
        this.estacionA = EstacionA;
    }

    public int getLineaB() {
        return lineaB;
    }

    public void setLineaB(int lineaB) {
        this.lineaB = lineaB;
    }

    public int getEstacionB() {
        return estacionB;
    }

    public void setEstacionB(int EstacionB) {
        this.estacionB = EstacionB;
    }
    
    public int getLineaC() {
        return lineaC;
    }

    public void setLineaC(int lineaC) {
        this.lineaC = lineaC;
    }

    public int getEstacionC() {
        return estacionC;
    }

    public void setEstacionC(int EstacionC) {
        this.estacionC = EstacionC;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }
    
    
}
