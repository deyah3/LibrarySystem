package AssignmentOne;

public class FineCalculator {
    private BorrowRecord borrowed;
    private BorrowableItem item;
    private int daysOverdue;
    private double fee;;

    public FineCalculator(BorrowRecord borrowed) {
        this.borrowed = borrowed;
        this.item = borrowed.getItem();
        this.daysOverdue = calculateDaysOverdue();
        this.fee = getFeeItemType();
    }

    // private int getFeeItemType(BorrowableItem item) {
    // double fine = 0;
    // // Determine the fine based on the type of item
    // if (item instanceof Book) {
    // fine = daysOverdue * 3; // $3 per day for books
    // } else if (item instanceof Journal) {
    // fine = daysOverdue * 3; // $3 per day for journals
    // } else if (item instanceof Video) {
    // fine = daysOverdue * 1; // $1 per day for videos
    // } else if (item instanceof TechnicalPaper) {
    // fine = daysOverdue * 2; // $2 per day for technical papers
    // }
    // return 0;
    // }
    public double getFeeItemType() {
        fee = daysOverdue * item.getFee();
        return fee;

    }

    private int calculateDaysOverdue() {
        long lateness = borrowed.getDueDate().getTime() - System.currentTimeMillis();
        if (lateness <= 0) {
            return 0; // No overdue days if returned on or before due date
        }
        // Convert milliseconds to days
        return (int) (lateness / (1000 * 60 * 60 * 24));
    }

    public double getFee() {
        return fee;
    }

}
