import com.google.gson.Gson;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String url = "https://v6.exchangerate-api.com/v6/161a9e11bd2a7823c5a0b80b/latest/USD";
        String json = HttpClient.get(url);

        Gson gson = new Gson();
        ExchangeRate data = gson.fromJson(json, ExchangeRate.class);

        Map<String, Double> tasas = data.getConversionRates();
        Scanner sc = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("\n1) Dólar =>> Peso argentino");
            System.out.println("2) Peso argentino =>> Dólar");
            System.out.println("3) Dólar =>> Real brasileño");
            System.out.println("4) Real brasileño =>> Dólar");
            System.out.println("5) Dólar =>> Peso colombiano");
            System.out.println("6) Peso colombiano =>> Dólar");
            System.out.println("7) Salir");
            System.out.println("*******************************************");
            System.out.print("Elija una opción válida: ");
            opcion = sc.nextInt();

            if (opcion >= 1 && opcion <= 6) {
                System.out.print("\nIngrese el valor que deseas convertir: ");
                double valor = sc.nextDouble();

                switch (opcion) {
                    case 1: // USD -> ARS
                        double resultado1 = valor * tasas.get("ARS");
                        System.out.printf("El valor %.2f [USD] corresponde al valor final de >>>> %.2f [ARS]%n", valor, resultado1);
                        break;
                    case 2: // ARS -> USD
                        double resultado2 = valor / tasas.get("ARS");
                        System.out.printf("El valor %.2f [ARS] corresponde al valor final de >>>> %.2f [USD]%n", valor, resultado2);
                        break;
                    case 3: // USD -> BRL
                        double resultado3 = valor * tasas.get("BRL");
                        System.out.printf("El valor %.2f [USD] corresponde al valor final de >>>> %.2f [BRL]%n", valor, resultado3);
                        break;
                    case 4: // BRL -> USD
                        double resultado4 = valor / tasas.get("BRL");
                        System.out.printf("El valor %.2f [BRL] corresponde al valor final de >>>> %.2f [USD]%n", valor, resultado4);
                        break;
                    case 5: // USD -> COP
                        double resultado5 = valor * tasas.get("COP");
                        System.out.printf("El valor %.2f [USD] corresponde al valor final de >>>> %.2f [COP]%n", valor, resultado5);
                        break;
                    case 6: // COP -> USD
                        double resultado6 = valor / tasas.get("COP");
                        System.out.printf("El valor %.2f [COP] corresponde al valor final de >>>> %.2f [USD]%n", valor, resultado6);
                        break;
                }
            } else if (opcion != 7) {
                System.out.println("Opción inválida.");
            }

        } while (opcion != 7);

        System.out.println("Gracias por usar el Conversor de Monedas 💸");
    }
}


