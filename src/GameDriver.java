import Setup.GameManager;
import Setup.GameSetupFactory;
import java.util.Scanner;

public class GameDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameManager gameManager = GameSetupFactory.createGameManager(scanner);
        gameManager.startGame();
        scanner.close();
    }
}

