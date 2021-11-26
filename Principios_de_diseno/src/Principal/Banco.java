package Principal;

/** +---------------------------------!!!Banco-------------------------------------+
 * |Clase que se encarga de la gestion del dinero del banco------------------------|
 * +-----------------------------------------------------------------------------+**/

public class Banco {

private static double Dinero_Banco;

    public Banco() {
    }

    public Banco(double dinero_Banco) {
        Dinero_Banco = dinero_Banco;
    }

    public double getDinero_Banco() {
        return Dinero_Banco;
    }

    public void setDinero_Banco(double dinero_Banco) {
        Dinero_Banco = dinero_Banco;
    }


}
