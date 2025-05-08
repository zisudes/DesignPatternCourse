package W_3.template_method;

import java.util.Scanner;

public class ScannerReader {
    public static int promptChoice(String prompt, String[] options){
        Scanner scanner = new Scanner(System.in);

        System.out.println(prompt);
        for (int i = 0; i < options.length; i++) {
            System.out.printf("[%s] %s\n", i + 1, options[i]);
        }
        return scanner.nextInt();
    }

    public static int promptInt(String prompt){
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        } else {
            System.out.println("Invalid input. Please provide a number.");
            return promptInt(prompt);
        }
    }
}