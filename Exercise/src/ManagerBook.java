public class ManagerBook {

    public String binarySearch(Book[] arr, int left, int right, long price) {

        this.selectionSort(arr);
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

    public void bubbleSort(Book[] arr) {
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

    public int countWithLanguage(Book[] arr, String language) {
        int count = 0;
        for (Book i : arr) {
            if (i instanceof ProgrammingBook) {
                if (((ProgrammingBook) i).getLanguage().equals(language)) {
                    count++;
                }
            }
        }
        return count;
    }

    public void insertSort(Book[] arr) {
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

    public boolean isExist(Book[] arr, String name) {
        for (Book book : arr) {
            if (book.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void selectionSort(Book[] arr) {
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

    public long sequentialSearch(Book[] arr, String name) {
        for (Book book : arr) {
            if (book.getName().equals(name)) {
                return book.getPrice();
            }
        }
        return -1;
    }

    public void showBookArr(Book[] books) {
        for (Book i : books) {
            if (i instanceof ProgrammingBook) {
                showProgrammingBook((ProgrammingBook) i);
            } else {
                showFictionBook((FictionBook) i);
            }
        }
    }

    public void showFictionBook(FictionBook book) {
        System.out.printf("%15s   %-20s   %10s   %-15s   %-15s\n", "BookCode", "Name", "Price", "Author", "Category");
        System.out.printf("%15s   %-20s   %10d   %-15s   %-15s\n", book.getBookCode(), book.getName(), book.getPrice(), book.getAuthor(), book.getCategory());
    }

    public void showMainMenu() {
        System.out.println("Main Menu");
        System.out.println("0. Show Book");
        System.out.println("1. Total money of all books");
        System.out.println("2. Count the ProgrammingBook books with language as 'Java'");
        System.out.println("3. Search books");
        System.out.println("4. Sort books");
        System.out.println("5. Exit");
    }

    public void showSearchMenu() {
        System.out.println("Search Menu");
        System.out.println("1. Sequential Search With Book's Name");
        System.out.println("2. Binary Search With Book's Price");
        System.out.println("3. Back");
    }

    public void showSortMenu() {
        System.out.println("Sort Menu");
        System.out.println("1. Bubble Sort");
        System.out.println("2. Insert Sort");
        System.out.println("3. Selection Sort");
        System.out.println("4. Back");
    }

    public void showProgrammingBook(ProgrammingBook book) {
        System.out.printf("%15s   %-20s   %10s   %-15s   %-15s   %-15s\n", "BookCode", "Name", "Price", "Author", "Language", "Framework");
        System.out.printf("%15s   %-20s   %10d   %-15s   %-15s   %-15s\n", book.getBookCode(), book.getName(), book.getPrice(), book.getAuthor(), book.getLanguage(), book.getFramework());
    }

    public long sumPrice(Book[] arr) {
        long sum = 0;
        for (Book i : arr) {
            sum += i.getPrice();
        }
        return sum;
    }


}
