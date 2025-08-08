import java.util.Scanner;
public class Menu {
    public static void inicio(){
        while(true){
        Scanner scanner= new Scanner(System.in);
        System.out.println("Menu");
        System.out.println("1) Dolar ==> Peso Argentino ");
        System.out.println("2) Peso Argentino ==> Dolar ");
        System.out.println("3) Dolar ==> Real Brasileño ");
        System.out.println("4) Real Brasileño ==> Dolar ");
        System.out.println("5) Dolar ==> Peso colombiano ");
        System.out.println("6) peso Colombiano ==> Dolar ");
        System.out.println("7) Salir");
        System.out.println("Seleccione una opcion");

        int opcion = scanner.nextInt();


            switch (opcion) {
            case 1 -> Conversor.conversor("USD", "ARS");
            case 2 -> Conversor.conversor("ARS", "USD");
            case 3 -> Conversor.conversor("USD", "BRL");
            case 4 -> Conversor.conversor("BRL", "USD");
            case 5 -> Conversor.conversor("USD", "COP");
            case 6 -> Conversor.conversor("COP", "USD");
            case 7 -> {
                System.out.println("Gracias por usar esta app");
                return;
            }
            default -> throw new IllegalStateException("Unexpected value: " + opcion);
        }
            System.out.println();
        }


    }




}
