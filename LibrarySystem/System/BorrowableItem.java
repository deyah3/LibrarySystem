package AssignmentOne;

public abstract class BorrowableItem implements LibraryMaterials {
    private int libraryID;
    private String borrowerID;
    private double fee;

    public BorrowableItem(int libraryID) {
        this.libraryID = libraryID;
    }

    public void borrowItem(String borrowerID) {
        this.borrowerID = borrowerID;
    }

    public void returnItem() {
        this.borrowerID = null;
    }

    public int getLibraryID() {
        return libraryID;
    }

    public String getBorrowerID() {
        return borrowerID;
    }
    public double getFee(){
        return fee;}
        

}
