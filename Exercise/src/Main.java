import java.awt.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ManagerBook mb = new ManagerBook();
        Book[] books = inputBookArr();

        do {
            mb.showMainMenu();
            int choice = inputInt("Enter your choice:");
            switch (choice) {
                case 0:
                    mb.showBookArr(books);
                    inputStr("Press enter to continue...");
                    break;
                case 1:
                    //Sum all book's price
                    long totalMoney = mb.sumPrice(books);
                    System.out.println("Total money is " + totalMoney);
                    inputStr("Press enter to continue...");
                    break;
                case 2:
                    //Count book with 'Java' language
                    System.out.println("Number of programming book with 'Java' language: " + mb.countWithLanguage(books, "Java"));
                    inputStr("Press enter to continue...");
                    break;
                case 3:
                    int searchChoice;
                    do {
                        mb.showSearchMenu();
                        searchChoice = inputInt("Enter your choice:");
                        switch (searchChoice) {
                            case 1:
                                //Sequential search
                                String nameOfBook = inputStr("Enter name of the book you want to search: ");
                                if (mb.isExist(books, nameOfBook)) {
                                    System.out.println("The price of " + nameOfBook + " is: " + mb.sequentialSearch(books, nameOfBook));
                                } else {
                                    System.out.println("Not found '" + nameOfBook + "'");
                                }
                                inputStr("Press anything to continue...");
                                break;
                            case 2:
                                //Binary search
                                long price = inputLong("Enter the price of book that you want to search: ");
                                String bookName = mb.binarySearch(books, 0, books.length - 1, price);
                                if (bookName.equals("")) {
                                    System.out.println("No book has price " + price);
                                } else {
                                    System.out.println("Book has price " + price + " is: " + bookName);
                                }
                                inputStr("Press anything to continue...");
                                break;
                        }
                    } while (searchChoice != 3);
                    break;
                case 4:
                    int sortChoice;
                    do {
                        mb.showSortMenu();
                        sortChoice = inputInt("Enter your choice:");
                        switch (sortChoice) {
                            case 1:
                                mb.bubbleSort(books);
                                System.out.println("Done!");
                                inputStr("Press enter to continue...");
                                break;
                            case 2:
                                mb.insertSort(books);
                                System.out.println("Done!");
                                inputStr("Press enter to continue...");
                                break;
                            case 3:
                                mb.selectionSort(books);
                                System.out.println("Done!");
                                inputStr("Press enter to continue...");
                                break;
                        }
                    } while (sortChoice != 4);
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("No choice!");
            }
        } while (true);
    }

    public static String inputStr(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextLine();
    }

    public static int inputInt(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        boolean flag = true;
        int num=0;
        while(flag){
            try {
                num = Integer.parseInt(scanner.nextLine());
                if (num < 0) {
                    System.out.println("Error! Please try again!!!");
                } else {
                    flag=false;
                }
            } catch(NumberFormatException e) {
                System.out.println("Error! Please try again!!!");
            }
        }
        return num;
    }

    public static long inputLong(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        boolean flag = true;
        long num=0;
        while(flag){
            try {
                num = Long.parseLong(scanner.nextLine());
                if (num < 0) {
                    System.out.println("Error! Please try again!!!");
                } else {
                    flag=false;
                }
            } catch(NumberFormatException e) {
                System.out.println("Error! Please try again!!!");
            }
        }
        return num;
    }

    public static ProgrammingBook inputProgrammingBook(String message) {
        System.out.println(message);
        String bookCode = inputStr("Enter the book code:");
        String name = inputStr("Enter the name:");
        long price = inputLong("Enter the price:");
        String author = inputStr("Enter the author name:");
        String language = inputStr("Enter the language: ");
        String framework = inputStr("Enter the framework: ");
        return new ProgrammingBook(bookCode, name, price, author, language, framework);
    }

    public static FictionBook inputFictionBook(String message) {
        System.out.println(message);
        String bookCode = inputStr("Enter the book code:");
        String name = inputStr("Enter the name:");
        long price = inputLong("Enter the price:");
        String author = inputStr("Enter the author name:");
        String category = inputStr("Enter the category:");
        return new FictionBook(bookCode, name, price, author, category);
    }

    public static Book[] inputBookArr() {
        int amountProgram = inputInt("Enter amount of Programming Book");
        int amountFiction = inputInt("Enter amount of Fiction Book");
        int i = 0;
        Book[] books = new Book[amountFiction + amountProgram];
        for (int j = 0; j < amountProgram; j++, i++) {
            books[i] = inputProgrammingBook("Enter Programming Book");
        }
        for (int j = 0; j < amountFiction; j++, i++) {
            books[i] = inputFictionBook("Enter Fiction Book");
        }
        return books;
    }
}
