import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double width = inputDouble("Enter the width:");
        double height = inputDouble("Enter the height:");
        Rectangle rectangle = new Rectangle(width, height);
        rectangle.display();
    }

    public static double inputDouble(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextDouble();
    }
}
