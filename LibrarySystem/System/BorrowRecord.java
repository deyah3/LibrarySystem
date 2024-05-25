package AssignmentOne;

  //  import java.util.Calendar;
import java.util.Date;

public class BorrowRecord {
    private String borrowerID;
    private BorrowableItem item;
    private Date loanDate;
    private Date dueDate;
   // private Calendar calender;
    private double fee;

    public BorrowRecord(String borrowerID, BorrowableItem item, Date loanDate, Date dueDate) {
        this.borrowerID = borrowerID;
        this.item = item;
        this.loanDate = loanDate;
        this.dueDate = dueDate;
        //calender= Calendar.getInstance();
        

    }

    public String getBorrowerID() {
        return borrowerID;
    }

    public BorrowableItem getItem() {
        return item;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public Date getDueDate() {
        return dueDate;
    }
    public double getFee(){
        return fee;

    }

}


