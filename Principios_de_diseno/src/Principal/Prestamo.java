package Principal;

public class Prestamo{
    private String Id_Prestamo;
    private double Valor;
    private String Fecha_Pago;
    private String Fecha_Aut;
    private String Fecha_Entrega;
    private double Dinero_Banco;

    public Prestamo() {
    }

    public Prestamo(String id_Prestamo, double valor, String fecha_Pago, String fecha_Aut, String fecha_Entrega, double dinero_Banco) {
        Id_Prestamo = id_Prestamo;
        Valor = valor;
        Fecha_Pago = fecha_Pago;
        Fecha_Aut = fecha_Aut;
        Fecha_Entrega = fecha_Entrega;
        Dinero_Banco = dinero_Banco;
    }

    public String getId_Prestamo() {
        return Id_Prestamo;
    }

    public void setId_Prestamo(String id_Prestamo) {
        Id_Prestamo = id_Prestamo;
    }

    public double getValor() {
        return Valor;
    }

    public void setValor(double valor) {
        Valor = valor;
    }

    public String getFecha_Pago() {
        return Fecha_Pago;
    }

    public void setFecha_Pago(String fecha_Pago) {
        Fecha_Pago = fecha_Pago;
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

    public double getDinero_Banco() {
        return Dinero_Banco;
    }

    public void setDinero_Banco(double dinero_Banco) {
        Dinero_Banco = dinero_Banco;
    }
}
