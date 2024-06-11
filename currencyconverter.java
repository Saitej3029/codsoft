import java.util.InputMismatchException;
import java.util.Scanner;

public class CurrencyConverter {
    private static final double USD_TO_EUR_RATE = 0.93;
    private static final double EUR_TO_USD_RATE = 1.08;
    private static final double USD_TO_JPY_RATE = 156.91;
    private static final double USD_TO_GBP_RATE = 0.79;
    private static final double USD_TO_AUD_RATE = 1.52;
    private static final double USD_TO_INR_RATE = 83.51; // Indian Rupee (INR)

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Currency Converter!");
        int baseCurrencyChoice;
        int targetCurrencyChoice;

        while (true) {
            System.out.println("\nBase Currency:");
            System.out.println("1. USD");
            System.out.println("2. EUR");
            System.out.println("3. JPY");
            System.out.println("4. GBP");
            System.out.println("5. AUD");
            System.out.println("6. INR");
            System.out.print("Choose the base currency: ");
            baseCurrencyChoice = getValidCurrencyChoice(scanner);

            System.out.println("\nTarget Currency:");
            System.out.println("1. EUR");
            System.out.println("2. USD");
            System.out.println("3. JPY");
            System.out.println("4. GBP");
            System.out.println("5. AUD");
            System.out.println("6. INR");
            System.out.print("Choose the target currency: ");
            targetCurrencyChoice = getValidCurrencyChoice(scanner);

            switch (baseCurrencyChoice) {
                case 1:
                    convertCurrency(scanner, "USD", targetCurrencyChoice);
                    break;
                case 2:
                    convertCurrency(scanner, "EUR", targetCurrencyChoice);
                    break;
                case 3:
                    convertCurrency(scanner, "JPY", targetCurrencyChoice);
                    break;
                case 4:
                    convertCurrency(scanner, "GBP", targetCurrencyChoice);
                    break;
                case 5:
                    convertCurrency(scanner, "AUD", targetCurrencyChoice);
                    break;
                case 6:
                    convertCurrency(scanner, "INR", targetCurrencyChoice);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void convertCurrency(Scanner scanner, String baseCurrency, int targetCurrencyChoice) {
        double baseAmount;
        double targetRate;
        double targetAmount;

        switch (targetCurrencyChoice) {
            case 1:
                targetRate = getTargetRate(baseCurrency, "EUR");
                break;
            case 2:
                targetRate = getTargetRate(baseCurrency, "USD");
                break;
            case 3:
                targetRate = getTargetRate(baseCurrency, "JPY");
                break;
            case 4:
                targetRate = getTargetRate(baseCurrency, "GBP");
                break;
            case 5:
                targetRate = getTargetRate(baseCurrency, "AUD");
                break;
            case 6:
                targetRate = getTargetRate(baseCurrency, "INR");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                return;
        }

        System.out.print("Enter the amount in " + baseCurrency + ": ");
        baseAmount = getValidAmount(scanner);

        targetAmount = baseAmount * targetRate;
        System.out.printf("%.2f %s is equivalent to %.2f %s%n", baseAmount, baseCurrency, targetAmount, getCurrencyName(targetCurrencyChoice));
    }

    private static double getTargetRate(String baseCurrency, String targetCurrency) {
        switch (baseCurrency) {
            case "USD":
                switch (targetCurrency) {
                    case "EUR":
                        return USD_TO_EUR_RATE;
                    case "JPY":
                        return USD_TO_JPY_RATE;
                    case "GBP":
                        return USD_TO_GBP_RATE;
                    case "AUD":
                        return USD_TO_AUD_RATE;
                    case "INR":
                        return USD_TO_INR_RATE;
                    default:
                        return 1.0;
                }
            case "EUR":
                return 1 / USD_TO_EUR_RATE;
            case "JPY":
                return 1 / USD_TO_JPY_RATE;
            case "GBP":
                return 1 / USD_TO_GBP_RATE;
            case "AUD":
                return 1 / USD_TO_AUD_RATE;
            case "INR":
                return 1 / USD_TO_INR_RATE;
            default:
                return 1.0;
        }
    }

    private static String getCurrencyName(int currencyChoice) {
        switch (currencyChoice) {
            case 1:
                return "EUR";
            case 2:
                return "USD";
            case 3:
                return "JPY";
            case 4:
                return "GBP";
            case 5:
                return "AUD";
            case 6:
                return "INR";
            default:
                return "Unknown Currency";
        }
    }

    private static int getValidCurrencyChoice(Scanner scanner) {
        int choice;
        while (true) {
            try {
                choice = scanner.nextInt();
                if (choice >= 1 && choice <= 6) {
                    break;
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // consume invalid input
            }
        }
        return choice;
    }

    private static double getValidAmount(Scanner scanner) {
        double amount;
        while (true) {
            try {
                amount = scanner.nextDouble();
                if (Double.isFinite(amount) && amount >= 0) {
                    break;
                } else {
                    System.out.println("Please enter a non-negative valid amount.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // consume invalid input
            }
        }
        return amount;
    }
}