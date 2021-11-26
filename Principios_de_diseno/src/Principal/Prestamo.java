package Principal;

import java.util.Scanner;
/** +---------------------------------!!!Prestamo------------------------------------------+
 * |Clase que se encarga de la gestion de los datos del prestamo que realiza el banco -----|
 * +------------------------------------------------------------------------------------+**/
public class Prestamo{

    private static int         n;//Número de cuotas para pago del prestamo
    private static int         Id_Prestamo;//Numero identificador del prestamo
    private static double      Valor;//Valor del prestamo
    private static String[]    Fechas_Pago = new String[n];//Fechas de cada cuota a pagar
    private static String      Fecha_Aut;//Fecha de autoricacion del prestamo
    private static String      Fecha_Entrega;//Fecha de desenbolso del prestamo
    private static int         defDinero;// Parametro para validar si se definieron los fondos del banco

    Scanner lec = new Scanner(System.in);

    public Prestamo() {}

    public Prestamo(int id_Prestamo, double valor, String[] fechas_Pago, String fecha_Aut, String fecha_Entrega) {
        Id_Prestamo = id_Prestamo;
        Valor = valor;
        Fechas_Pago = fechas_Pago;
        Fecha_Aut = fecha_Aut;
        Fecha_Entrega = fecha_Entrega;
    }

    /** +-------------registrarPrestamo----------------------+
     *  |Guarda los datos para registrar el prestamo---------|*
     * +----------------------------------------------------+*/
    public void registrarPrestamo(int id_Prestamo, double valor, String[] fechas_Pago, String fecha_Aut, String fecha_Entrega){
        setId_Prestamo(id_Prestamo);
        setValor(valor);
        setFechas_Pago(fechas_Pago);
        setFecha_Aut(fecha_Aut);
        setFecha_Entrega(fecha_Entrega);
    }

    public int getId_Prestamo() {
        System.out.println(Id_Prestamo);
        return Id_Prestamo;
    }

    public void setId_Prestamo(int id_Prestamo) {
        try{
            /** +------------------------------------!!!-----------------------------------------------------+
             *  |Verifica si el identificador del prestamo es negativo y si lo es pide su corrección---------|*
             * +--------------------------------------------------------------------------------------------+*/
            while(id_Prestamo <= 0){
                System.out.println("ID INCORRECTO: ");
                System.out.println("Debe ingresar un ID mayor a 0, intente nuevamente: ");
                id_Prestamo = lec.nextInt();
            }
            this.Id_Prestamo = id_Prestamo;
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public double getValor() {
        return Valor;
    }

    public void setValor(double valor) {
        try{
            double disponible;
            int op;
            /** +------------------------------------!!!---------------------------------------+
             *  |Verifica si el prestamo tiene un valor negativo o 0 y pide corrección---------|*
             * +------------------------------------------------------------------------------+*/
            while(valor<=0){
                System.out.println("VALOR DEL PRESTAMO INCORRECTO: ");
                System.out.println("Debe ingresar un valor mayor a 0, intente nuevamente: ");
                valor = lec.nextDouble();
            }
            Banco banco = new Banco();
            disponible = banco.getDinero_Banco() - valor;
            /** +------------------------------------!!!--------------------------------------------------------------------------------+
             *  |Calcula el dinero sobrante del banco despues del prestamo y posibilita al usuario tomar ese valor o rechazarlo--------|*
             * +-----------------------------------------------------------------------------------------------------------------------+*/
            //
            if(disponible < 0){
                System.out.println("El banco le puede prestar: " + banco.getDinero_Banco());
                System.out.println("Digite 1 si acepta ese valor, otro número si prefiere volver despues: ");
                op = lec.nextInt();
                if(op == 1){
                    this.Valor = banco.getDinero_Banco();
                    banco.setDinero_Banco(0);
                    setDefDinero(2);
                }
                else{
                    this.Valor = 0;
                }
            }
            /** +-----------------------------------------------!!!---------------------------------------------------------+
             *  |Realiza el prestamo original y verifica si el banco se queda sin dinero, notificando si sí es así---------|*
             * +-----------------------------------------------------------------------------------------------------------+*/
            else{
                this.Valor = valor;
                banco.setDinero_Banco(banco.getDinero_Banco() - valor);
                if(banco.getDinero_Banco() == 0){
                    System.out.println("El banco se quedo sin recursos");
                    setDefDinero(2);
                }
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public String[] getFechas_Pago() {
        return Fechas_Pago;
    }

    public void setFechas_Pago(String[] fechas_Pago) {
        Fechas_Pago = fechas_Pago;
    }

    public String getFecha_Aut() {
        return Fecha_Aut;
    }

    public void setFecha_Aut(String fecha_Aut) {
        Fecha_Aut = fecha_Aut;
    }

    public String getFecha_Entrega() {
        return Fecha_Entrega;
    }

    public void setFecha_Entrega(String fecha_Entrega) {
        Fecha_Entrega = fecha_Entrega;
    }

    public int getDefDinero() {
        return defDinero;
    }

    public void setDefDinero(int defDinero) {
        this.defDinero = defDinero;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
}
