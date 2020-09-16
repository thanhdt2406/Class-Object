import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Create two book arrays
        ProgrammingBook[] programmingBooks = inputArrProgramming();
        FictionBook[] fictionBooks = inputArrFiction();

        //Merge two book arrays
        Book[] books = mergeTwoArr(programmingBooks, fictionBooks);

        do {
            mainMenu();
            int choice = inputInt("Enter your choice:");
            switch (choice) {
                case 0:
                    int displayChoice;
                    do {
                        displayMenu();
                        displayChoice = inputInt("Enter your choice:");
                        switch (displayChoice) {
                            case 1:
                                showProgrammingBook(programmingBooks);
                                inputStr("Press anything to continue...");
                                break;

                            case 2:
                                showFictionBook(fictionBooks);
                                inputStr("Press anything to continue...");
                                break;
                            case 3:
                                showAllBook(programmingBooks, fictionBooks);
                                inputStr("Press anything to continue...");
                                break;
                        }
                    } while (displayChoice != 4);
                    break;
                case 1:
                    //Sum all book's price
                    long totalMoney = sumPrice(programmingBooks) + sumPrice(fictionBooks);
                    System.out.println("Total money is " + totalMoney);
                    inputStr("Press anything to continue...");
                    break;
                case 2:
                    //Count book with 'Java' language
                    System.out.println("Number of programming book with 'Java' language: " + countWithLanguage(programmingBooks, "Java"));
                    inputStr("Press anything to continue...");
                    break;
                case 3:
                    int searchChoice;
                    do {
                        searchMenu();
                        searchChoice = inputInt("Enter your choice:");
                        switch (searchChoice) {
                            case 1:
                                //Sequential search
                                String nameOfBook = inputStr("Enter name of the book you want to search: ");
                                if (isExist(books, nameOfBook)) {
                                    System.out.println("The price of " + nameOfBook + " is: " + sequentialSearch(books, nameOfBook));
                                } else {
                                    System.out.println("Not found '" + nameOfBook + "'");
                                }
                                inputStr("Press anything to continue...");
                                break;
                            case 2:
                                //Binary search
                                long price = inputLong("Enter the price of book that you want to search: ");
                                String bookName = binarySearch(books, 0, books.length - 1, price);
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
                        sortMenu();
                        sortChoice = inputInt("Enter your choice:");
                        switch (sortChoice) {
                            case 1:
                                bubbleSort(books);
                                System.out.println("Done!");
                                inputStr("Press anything to continue...");
                                break;
                            case 2:
                                insertSort(books);
                                System.out.println("Done!");
                                inputStr("Press anything to continue...");
                                break;
                            case 3:
                                selectionSort(books);
                                System.out.println("Done!");
                                inputStr("Press anything to continue...");
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
        return scanner.nextInt();
    }

    public static long inputLong(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextLong();
    }

    public static ProgrammingBook inputProgrammingBook(String message) {
        System.out.println(message);
        String bookCode = inputStr("Enter the book code:");
        String name = inputStr("Enter the name:");
        long price = inputLong("Enter price of the book:");
        String author = inputStr("Enter the author name:");
        String language = inputStr("Enter the language: ");
        String framework = inputStr("Enter the framework: ");
        return new ProgrammingBook(bookCode, name, price, author, language, framework);
    }

    public static ProgrammingBook[] inputArrProgramming() {
        int amount = inputInt("Enter amount of programming book: ");
        ProgrammingBook[] programmingBooks = new ProgrammingBook[amount];
        for (int i = 0; i < programmingBooks.length; i++) {
            programmingBooks[i] = inputProgrammingBook("Enter book " + i + ":");
        }
        return programmingBooks;
    }

    public static FictionBook inputFictionBook(String message) {
        System.out.println(message);
        String bookCode = inputStr("Enter the book code:");
        String name = inputStr("Enter the name:");
        long price = inputLong("Enter price of the book:");
        String author = inputStr("Enter the author name:");
        String category = inputStr("Enter the category:");
        return new FictionBook(bookCode, name, price, author, category);
    }

    public static FictionBook[] inputArrFiction() {
        int amount = inputInt("Enter amount of fiction book: ");
        FictionBook[] fictionBooks = new FictionBook[amount];
        for (int i = 0; i < fictionBooks.length; i++) {
            fictionBooks[i] = inputFictionBook("Enter book " + i + ":");
        }
        return fictionBooks;
    }

    public static Book[] mergeTwoArr(ProgrammingBook[] arr1, FictionBook[] arr2) {
        int i = 0;
        Book[] books = new Book[arr1.length + arr2.length];
        for (int j = 0; j < arr1.length; j++, i++) {
            books[i] = arr1[j];
        }
        for (int j = 0; j < arr2.length; j++, i++) {
            books[i] = arr2[j];
        }
        return books;
    }

    public static long sumPrice(Book[] arr) {
        long sum = 0;
        for (Book i : arr) {
            sum += i.getPrice();
        }
        return sum;
    }

    public static boolean isExist(Book[] arr, String name) {
        for (Book book : arr) {
            if (book.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static int countWithLanguage(ProgrammingBook[] arr, String language) {
        int count = 0;
        for (ProgrammingBook i : arr) {
            if (i.getLanguage().equals(language)) {
                count++;
            }
        }
        return count;
    }

    public static void bubbleSort(Book[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i].getPrice() > arr[j].getPrice()) {
                    Book temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void insertSort(Book[] arr) {
        for (int i = 0; i < arr.length; i++) {
            Book key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].getPrice() > key.getPrice()) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void selectionSort(Book[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[index].getPrice() > arr[j].getPrice()) {
                    index = j;
                }
            }
            if (index != i) {
                Book temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
            }
        }
    }

    public static long sequentialSearch(Book[] arr, String name) {
        for (Book book : arr) {
            if (book.getName().equals(name)) {
                return book.getPrice();
            }
        }
        return -1;
    }

    public static String binarySearch(Book[] arr, int left, int right, long price) {
        selectionSort(arr);
        if (right >= left) {
            int mid = left + (right - left) / 2;

            if (arr[mid].getPrice() == price) {
                return arr[mid].getName();
            }

            if (arr[mid].getPrice() > price) {
                binarySearch(arr, left, mid - 1, price);
            }

            return binarySearch(arr, mid + 1, right, price);
        }

        return "";
    }

    public static void showProgrammingBook(ProgrammingBook[] arr) {
        System.out.printf("%15s %-20s %10s %-15s %-15s %-15s\n", "BookCode", "Name", "Price", "Author", "Language", "Framework");
        for (ProgrammingBook programmingBook : arr) {
            System.out.printf("%15s %-20s %10d %-15s %-15s %-15s\n", programmingBook.getBookCode(), programmingBook.getName(), programmingBook.getPrice(), programmingBook.getAuthor(), programmingBook.getLanguage(), programmingBook.getFramework());
        }
    }

    public static void showFictionBook(FictionBook[] arr) {
        System.out.printf("%15s %-20s %10s %-15s %-15s\n", "BookCode", "Name", "Price", "Author", "Category");
        for (FictionBook fictionBook : arr) {
            System.out.printf("%15s %-20s %10d %-15s %-15s\n", fictionBook.getBookCode(), fictionBook.getName(), fictionBook.getPrice(), fictionBook.getAuthor(), fictionBook.getCategory());
        }
    }

    public static void showAllBook(ProgrammingBook[] arr1, FictionBook[] arr2) {
        showProgrammingBook(arr1);
        System.out.println();
        showFictionBook(arr2);
    }

    public static void mainMenu() {
        System.out.println("Main Menu");
        System.out.println("0. Show Book");
        System.out.println("1. Total money of all books");
        System.out.println("2. Count the ProgrammingBook books with language as 'Java'");
        System.out.println("3. Search books");
        System.out.println("4. Sort books");
        System.out.println("5. Exit");
    }

    public static void searchMenu() {
        System.out.println("Search Menu");
        System.out.println("1. Sequential Search With Book's Name");
        System.out.println("2. Binary Search With Book's Price");
        System.out.println("3. Back");
    }

    public static void sortMenu() {
        System.out.println("Sort Menu");
        System.out.println("1. Bubble Sort");
        System.out.println("2. Insert Sort");
        System.out.println("3. Selection Sort");
        System.out.println("4. Back");
    }

    public static void displayMenu() {
        System.out.println("Display Menu");
        System.out.println("1. Display Programming Book");
        System.out.println("2. Display Fiction Book");
        System.out.println("3. Display All Book");
        System.out.println("4. Back");
    }
}
