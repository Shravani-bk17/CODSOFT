import java.util.Scanner;

public class task4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=========================================");
        System.out.println("          TASK 4: CURRENCY CONVERTER     ");
        System.out.println("=========================================");

        // 1. Currency Selection
        System.out.print("Enter the base currency (USD, EUR, GBP, INR): ");
        String baseCurrency = scanner.next().toUpperCase();

        System.out.print("Enter the target currency (USD, EUR, GBP, INR): ");
        String targetCurrency = scanner.next().toUpperCase();

        // 2. Amount Input
        System.out.print("Enter the amount you want to convert: ");
        double amount = scanner.nextDouble();

        double exchangeRate = 0.0;
        boolean validConversion = true;

        // 3 & 4. Currency Conversion using nested switch-case blocks
        switch (baseCurrency) {
            case "USD":
                switch (targetCurrency) {
                    case "USD": exchangeRate = 1.0; break;
                    case "EUR": exchangeRate = 0.87; break;
                    case "GBP": exchangeRate = 0.74; break;
                    case "INR": exchangeRate = 96.31; break;
                    default: validConversion = false; break;
                }
                break;

            case "EUR":
                switch (targetCurrency) {
                    case "USD": exchangeRate = 1.15; break;
                    case "EUR": exchangeRate = 1.0; break;
                    case "GBP": exchangeRate = 0.85; break;
                    case "INR": exchangeRate = 110.38; break;
                    default: validConversion = false; break;
                }
                break;

            case "GBP":
                switch (targetCurrency) {
                    case "USD": exchangeRate = 1.35; break;
                    case "EUR": exchangeRate = 1.18; break;
                    case "GBP": exchangeRate = 1.0; break;
                    case "INR": exchangeRate = 130.29; break;
                    default: validConversion = false; break;
                }
                break;

            case "INR":
                switch (targetCurrency) {
                    case "USD": exchangeRate = 0.0104; break;
                    case "GBP": exchangeRate = 0.0077; break;
                    case "EUR": exchangeRate = 0.0091; break;
                    case "INR": exchangeRate = 1.0; break;
                    default: validConversion = false; break;
                }
                break;

            default:
                validConversion = false;
                break;
        }

        // 5. Display Result
        System.out.println("-----------------------------------------");
        if (validConversion) {
            double convertedAmount = amount * exchangeRate;
            System.out.println("Converted Amount: " + convertedAmount + " " + targetCurrency);
        } else {
            System.out.println("Error: Invalid currency pair entered.");
        }
        System.out.println("-----------------------------------------");

        scanner.close();
    }
}