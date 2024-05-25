package AssignmentOne;

public class Video extends BorrowableItem {
    private final String title;
    private final String description;
    private final double fee = 1.00;

    public Video(int libraryID, String title, String description) {
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
