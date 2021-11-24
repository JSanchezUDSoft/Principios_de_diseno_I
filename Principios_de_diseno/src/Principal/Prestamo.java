package Principal;

public class Prestamo{
    private String  Id_Prestamo;
    private double  Valor;
    private String  Fecha_Pago;
    private String  Fecha_Aut;
    private String  Fecha_Entrega;
    private double  Dinero_Banco;
    private int     defDinero = 0;

    Scanner lec = new Scanner(System.in);//Puede tener error :v

    public Prestamo() {}

    public Prestamo(String id_Prestamo, double valor, String fecha_Pago, String fecha_Aut, String fecha_Entrega, double dinero_Banco) {
        this.Id_Prestamo = id_Prestamo;
        this.Valor = valor;
        this.Fecha_Pago = fecha_Pago;
        this.Fecha_Aut = fecha_Aut;
        this.Fecha_Entrega = fecha_Entrega;
        this.Dinero_Banco = dinero_Banco;
    }

    public String getId_Prestamo() {
        return Id_Prestamo;
    }

    public void setId_Prestamo(String id_Prestamo) {
        try{
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
            while(valor<=0){
                System.out.println("VALOR DEL PRESTAMO INCORRECTO: ");
                System.out.println("Debe ingresar un valor mayor a 0, intente nuevamente: ");
                valor = lec.nextDouble();
            }
            disponible = getDinero_Banco() - valor;
            if(disponible < 0){
                System.out.println("El banco le puede prestar: " + getDineroBanco());
                System.out.println("Digite 1 si acepta ese valor, otro número si prefiere volver despues: ");
                op = lec.nextInt();
                if(op == 1){
                    this.Valor = getDinero_Banco();
                    setDinero_Banco(0);
                    setDefDinero(2);
                }
                else{
                    this.Valor = 0;
                }
            }
            else{
                this.Valor = valor;
                setDinero_Banco(getDinero_Banco() - valor);
                if(getDinero_Banco() == 0){
                    System.out.println("El banco se quedo sin recursos");
                    setDefDinero(2);
                }
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
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

    public int getDefDinero() {
        return defDinero;
    }

    public void setDefDinero(int defDinero) {
        this.defDinero = defDinero;
    }
}
