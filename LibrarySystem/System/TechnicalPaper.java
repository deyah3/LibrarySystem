package AssignmentOne;

public class TechnicalPaper extends BorrowableItem {
    private final String title;
    private final String description;
    private final double fee = 2.00;

    public TechnicalPaper(int libraryID, String title, String description) {
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
