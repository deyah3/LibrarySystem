package AssignmentOne;
public class Borrower {
    private String borrowerID;

    public Borrower(String borrowerID) {
        this.borrowerID = borrowerID;
    }

    public void borrowItem(BorrowableItem item) {
        item.borrowItem(borrowerID);
    }

    public void returnItem(BorrowableItem item) {
        item.returnItem();
    }
}
