package AssignmentOne;

public class Journal extends BorrowableItem {
    private final String title;
    private final String description;
    private final double fee=3.00;

    public Journal(int libraryID, String title, String description) {
        super(libraryID);
        this.title = title;
        this.description = description;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public Object getID() {
        return getLibraryID();
    }
    @Override
    public double getFee(){
        return fee;
    }

}
