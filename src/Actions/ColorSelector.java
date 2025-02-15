package Actions;

import Cards.enums.CardColor;
import java.util.Scanner;

public class ColorSelector {
    private final Scanner scanner;

    public ColorSelector(Scanner scanner) {
        this.scanner = scanner;
    }

    public CardColor promptForColor() {
        System.out.println("Choose a new color:");
        int index = 1;
        for (CardColor color : CardColor.values()) {
            if (!color.equals(CardColor.WILD)) { // Exclude WILD from the options
                System.out.println(index + ". " + color);
                index++;
            }
        }
        while (true) {
            System.out.print("Enter the number corresponding to your choice: ");
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                if (choice >= 1 && choice < index) {
                    return CardColor.values()[choice - 1];
                } else {
                    System.out.println("Invalid choice. Please select a valid color.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        }
    }
}
