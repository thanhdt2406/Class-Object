import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Solve quadratic equation a * x^2 + b * x + c = 0");
        double a = inputDouble("Enter a:");
        double b = inputDouble("Enter b:");
        double c = inputDouble("Enter c:");
        QuadraticEquation quadraticEquation = new QuadraticEquation(a, b, c);
        if (quadraticEquation.getDiscriminant() < 0) {
            System.out.println("No root!");
        } else if (quadraticEquation.getDiscriminant() == 0) {
            System.out.println("One root:");
            System.out.println(quadraticEquation.getRoot1());
        } else {
            System.out.println("Two roots: ");
            System.out.println("x1: " + quadraticEquation.getRoot1());
            System.out.println("x2: " + quadraticEquation.getRoot2());
        }
    }

    public static double inputDouble(String message) {
        System.out.println(message);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }
}
