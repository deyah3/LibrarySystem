package AssignmentOne;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Library {
    // i used this source to impement the hashmap:
    // https://www.w3schools.com/java/java_hashmap.asp
    private HashMap<Integer, BorrowableItem> items; // Map of borrowable items in the library
    private List<BorrowRecord> borrowRecords; // List of borrow records in the library

    public Library() {
        items = new HashMap<>();
        borrowRecords = new ArrayList<>();
    }

    // Method to add a borrowable item to the library
    public void addItem(BorrowableItem item) {
        items.put(item.getLibraryID(), item);
    }

    public void borrowItem(String borrowerID, int libraryID, Date loanDate, Date dueDate) {
        BorrowableItem item = searchById(libraryID);
        if (!checkIfAvailable(item)) {
            System.out.println("Material not available.");
            return;
        }
        if (checkBorrowAmount(borrowerID) >= 5) {
            System.out.println("Cannot borrow more than 5 items.");
            return;
        }
        item.borrowItem(borrowerID);
        BorrowRecord borrowRecord = new BorrowRecord(borrowerID, item, loanDate, dueDate);
        borrowRecords.add(borrowRecord);
        printItem();
    }

    public void returnItem(BorrowableItem item) {
        item.returnItem();
        BorrowRecord toRemove = null;
        for (BorrowRecord record : borrowRecords) {
            if (record.getItem() == item) {
                toRemove = record;
                break;
            }
        }
        if (toRemove != null) {
            borrowRecords.remove(toRemove);
        }
        printItem();
    }

    public double calculateFine(BorrowableItem item, int daysOverdue) {
        BorrowRecord borrowRecord = getBorrowRecord(item);
        if (borrowRecord == null) {
            System.out.println("Item not borrowed.");
            return 0;
        }

        FineCalculator fineCalculator = new FineCalculator(borrowRecord);
        return fineCalculator.getFeeItemType();
    }

    public BorrowableItem searchById(int libraryID) {
        return items.get(libraryID);
    }

    public void displayBorrowRecords() {
        for (BorrowRecord record : borrowRecords) {
            System.out.println(record);
        }
    }

    private boolean checkIfAvailable(BorrowableItem item) {
        return items.containsValue(item);
    }

    private int checkBorrowAmount(String borrowerID) {
        int count = 0;
        for (BorrowRecord record : borrowRecords) {
            if (record.getBorrowerID().equals(borrowerID)) {
                count++;
            }
        }
        return count;
    }

    private BorrowRecord getBorrowRecord(BorrowableItem item) {
        for (BorrowRecord record : borrowRecords) {
            if (record.getItem() == item) {
                return record;
            }
        }
        return null;
    }

    public void printItem() {
        System.out.println("All Items in Library:");

        for (BorrowableItem item : items.values()) {
            System.out.println(item.getID() + " " + item.getDescription());

        }
    }

    public void printTable() {
        System.out.println("Lent Item | Due Date | Fine");
        System.out.println();
//got this  from chat GPT for the bonus that require changing color of the fee.
        for (BorrowRecord record : borrowRecords) {
            System.out.print(record.getItem().getID() + " | " + record.getDueDate() + " | ");
            if (record.getFee() > 0) {
                System.out.print("\u001B[31m"); // ANSI escape code for red color
            }
            System.out.println(record.getFee());
            // Reset color to default
            System.out.print("\u001B[0m");
        }
    }

}

// public void printTable(){
// System.out.println("lended Item | due date | Fine");
// System.out.println();
// for(BorrowableItem item: items.values()){
// System.out.println(item.getFee() + " | " + item.getID());
// }

// }
