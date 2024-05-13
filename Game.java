import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Game {
    private static Scanner scanner;

    public Game() {
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Bem-vindo ao Mortal Kombat !");

        Character subZero = new Character("Sub-Zero", 100, "Congelamento");
        Character scorpion = new Character("Scorpion", 200, "Teleportação");
        Character raiden = new Character("Raiden", 300, "Choque Elétrico");

        System.out.println("Iniciando a batalha:");
        while (subZero.isAlive() && scorpion.isAlive() && raiden.isAlive()) {
            subZero.attack(scorpion);
            if (scorpion.isAlive()) {
                scorpion.attack(subZero);
            }
            if (subZero.isAlive() && scorpion.isAlive()) {
                raiden.attack(scorpion);
            }
        }

        List<String> winners = getWinners(subZero, scorpion, raiden);
        if (winners.isEmpty()) {
            System.out.println("Não houve vencedor.");
        } else {
            System.out.println(String.join(", ", winners) + " venceram!");
        }
    }

    private List<String> getWinners(Character... characters) {
        List<String> winners = new ArrayList<>();
        for (Character character : characters) {
            if (character.isAlive()) {
                winners.add(character.getName());
            }
        }
        return winners;
    }
}
