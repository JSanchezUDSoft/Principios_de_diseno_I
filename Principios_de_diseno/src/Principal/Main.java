package Principal;

public class Main {

    public static void main(String[] args) {
        try{
            G_Banco g_banco = new G_Banco();
            Prestamo prestamo = new Prestamo();
            boolean menu = true;

            while(menu == true){
                if(prestamo.getDefDinero() == 0 || prestamo.getDefDinero() == 1){
                    g_banco.capturar();
                    g_banco.imprimir();
                }
                else if(prestamo.getDefDinero() == 2){
                    System.out.println("\nSe agotaron los recursos del banco, intente mañana");
                    menu = false;
                }
                else{
                    System.out.println("\nEjecucion finalizada correctamente");
                    menu = false;
                }
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
