import java.util.Stack;
import java.util.Scanner;

public class Hanoi {

    // Die drei Stäbe als Stacks
    private Stack<Integer> left;
    private Stack<Integer> middle;
    private Stack<Integer> right;

    // Initialisierung
    public Hanoi() {
        left = new Stack<>();
        middle = new Stack<>();
        right = new Stack<>();

        // Scheiben der Größen 9 bis 1 auf den linken Stab legen
        for (int i = 9; i >= 1; i--) {
            left.push(i);
        }
    }

    // Bewege eine Scheibe von einem Stab zu einem anderen
    private void moveDisk(Stack<Integer> from, Stack<Integer> to) {
        if (from.isEmpty()) {
            System.out.println("Ungültiger Zug: Der Quellstab ist leer.");
            return;
        }

        if (!to.isEmpty() && from.peek() > to.peek()) {
            System.out.println("Ungültiger Zug: Eine größere Scheibe kann nicht auf einer kleineren liegen.");
            return;
        }

        to.push(from.pop());
    }

    // Nimm Eingaben vom Benutzer und führe Züge aus
    public void play() {
        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            printTowers();

            System.out.print("Eingabe (z.B. lm für von links nach mitte, q für beenden): ");
            input = scanner.nextLine();

            if (input.equals("q")) {
                break;
            }

            if (input.length() != 2) {
                System.out.println("Ungültige Eingabe. Bitte zwei Buchstaben eingeben.");
                continue;
            }

            char from = input.charAt(0);
            char to = input.charAt(1);

            Stack<Integer> fromStack = getStack(from);
            Stack<Integer> toStack = getStack(to);

            if (fromStack == null || toStack == null) {
                System.out.println("Ungültige Eingabe. Erlaubte Stäbe sind l, m, r.");
                continue;
            }

            moveDisk(fromStack, toStack);
        }

        scanner.close();
    }

    // Hole den entsprechenden Stack für einen gegebenen Buchstaben
    private Stack<Integer> getStack(char c) {
        switch (c) {
            case 'l':
                return left;
            case 'm':
                return middle;
            case 'r':
                return right;
            default:
                return null;
        }
    }

    // Drucke den aktuellen Zustand der Türme
    private void printTowers() {
        System.out.println("  | ");
        System.out.println(" l|" + left);
        System.out.println("  | ");
        System.out.println(" m|" + middle);
        System.out.println("  | ");
        System.out.println(" r|" + right);
        System.out.println("  | ");
        System.out.println();
    }

    // Hauptmethode zum Starten des Spiels
    public static void main(String[] args) {
        Hanoi hanoi = new Hanoi();
        hanoi.play();
    }
}
