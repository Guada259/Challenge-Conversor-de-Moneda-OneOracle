import java.util.Scanner;

public class Conversor {
    public static void conversor(String monedaOrigen, String monedaDeseada) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(("Ingrese el monto en " + monedaOrigen + " que desea convertir en " + monedaDeseada));
        double monto = scanner.nextDouble();
        double tasa;
        if (monedaOrigen.equals("USD")) {
            tasa = ExchangerateAPI.getRate(monedaDeseada);
        } else if (monedaDeseada.equals("USD")) {
            tasa = 1 / ExchangerateAPI.getRate(monedaOrigen);

        } else {
            double tasaIntermedia = ExchangerateAPI.getRate(monedaOrigen);
            double tasaFinal = ExchangerateAPI.getRate(monedaDeseada);
            tasa = tasaFinal / tasaIntermedia;

        }
        if (tasa != -1) {
            double resultado = monto * tasa;
            System.out.print("El valor " + monto + monedaOrigen + " corresponde al valor final==>" + resultado + monedaDeseada);
        } else {
            System.out.println("No se pudo obtener la tasa de cambio.");
        }
    }
}





