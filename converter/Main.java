package converter;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String answer;
        do {
            System.out.println("Enter two numbers in format: {source base} {target base} (To quit type /exit)");
            answer = scanner.nextLine();
            if (answer.contains("/exit")) {
                return;
            }
            int sourceBase = Integer.parseInt(String.valueOf(answer.split(" ")[0]));
            int targetBase = Integer.parseInt(String.valueOf(answer.split(" ")[1]));
            do {
                System.out.printf("Enter number in base %d to convert to base %d (To go back type /back)", sourceBase, targetBase);
                answer = scanner.nextLine();
                if (!answer.equalsIgnoreCase("/back")) {
                    FullConverter result = new FullConverter(answer, targetBase, sourceBase);
                    if (answer.contains(".")) {
                        System.out.println("Conversion result: " + result.fractionalConverter());
                    } else {
                        System.out.println("Conversion result: " + result.convert());
                    }
                }
            } while (!answer.equalsIgnoreCase("/back"));
        } while (!answer.contains("/exit"));
    }

    private static void oldConversions(Scanner scanner) {
        String answer = "";
        String number;
        long target;
        do {
            System.out.println("Do you want to convert /from decimal or /to decimal? (To quit type /exit)");
            answer = scanner.nextLine();
            switch (answer) {
                case "/from" -> {
                    System.out.println("Enter number in decimal system");
                    number = scanner.nextLine();
                    System.out.println("Enter target base:");
                    target = scanner.nextInt();
                    Converter converterNumber = switch ((int) target) {
                        case 2 -> new BinaryConverter(number);
                        case 8 -> new OctalConverter(number);
                        case 16 -> new HexadecimalConverter(number);
                        default -> new BinaryConverter(number);
                    };
                    System.out.println("Conversion result: " + converterNumber.convert());
                }
                case "/to" -> {
                    System.out.println("Enter source number:");
                    number = scanner.nextLine();
                    System.out.println("Enter source base:");
                    target = scanner.nextInt();
                    Converter converterNumber = switch ((int) target) {
                        case 2 -> new BinaryConverter(number);
                        case 8 -> new OctalConverter(number);
                        case 16 -> new HexadecimalConverter(number);
                        default -> new BinaryConverter(number);
                    };
                    System.out.println("Conversion to decimal result: " + converterNumber.convertToDecimal());
                }
                case "/exit" -> {
                    return;
                }
            }
        } while (!answer.equals("exit"));
    }
}
