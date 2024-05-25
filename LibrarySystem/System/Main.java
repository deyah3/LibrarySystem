package AssignmentOne;

public class Main {
    //Name: Diya Mustafa, d21015@auis.edu.krd
//Name: Aya Jamal, aa22017@auis.edu.krd 
    public static void main(String[] args) {
        
        Library library = new Library();

        library.addItem(new Book(1, "Introduction to Java", "A comprehensive guide to Java programming"));
        library.addItem(new Video(2, "Java Basics", "A video tutorial for beginners"));
        library.addItem(new Journal(3, "Java Trends", "Latest trends in Java development"));
        library.addItem(new TechnicalPaper(4, "Java Performance Optimization", "Tips for optimizing Java performance"));
        library.addItem(new TechnicalPaper(5, "Java Performance Optimization", "Tips for optimizing Java performance"));
        library.addItem(new TechnicalPaper(6, "Java Performance Optimization", "Tips for optimizing Java performance"));
                  
    
       // library.borrowItem(null, 2, null, null);
        library.printItem();

        library.borrowItem("3", 2 ,null, null);
        library.borrowItem("3", 3 ,null, null);
        library.borrowItem("3", 1 ,null, null);
        library.borrowItem("3", 5 ,null, null);
        library.borrowItem("3", 4 ,null, null);
        library.borrowItem("3", 6 ,null, null);

        library.printTable();

    }
}
