import java.util.*;
class Book{
    private static int bookId;
    private String bookTitle;
    private String bookAuthor;
    Book(String bookTitle,String bookAuthor){
        bookId++;
        this.bookAuthor = bookAuthor;
        this.bookTitle = bookTitle;
    }
    public void setBookTitle(String bookTitle){
        this.bookTitle = bookTitle;
    }
    public void setBookAuthor(String bookAuthor){
        this.bookAuthor = bookAuthor;
    }
    public String getBookTitle(){
        return this.bookTitle;
    }
    public String getBookAuthor(){
        return this.bookAuthor;
    }
    public int getBookId(){
        return this.bookId;
    }
    @Override
    public String toString(){
        return " Book Title : "+ bookTitle
                + " ,Book Author : "+ bookAuthor;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return bookTitle.equals(book.bookTitle);
    }
    @Override
    public int hashCode() {
        return Objects.hash(bookTitle);
    }
}
class User{
    private static int userId;
    private String userName;
    private long mobileNo;
    User(String userName,long mobileNo){
        userId++;
        this.userName = userName;
        this.mobileNo = mobileNo;
    }
    public String getUserName(){
        return this.userName;
    }
    public long getMobileNo(){
        return this.mobileNo;
    }
    public int getUserId(){
        return this.userId;
    }
    @Override
    public String toString(){
        return "User Name : "+ userName
                + " ,Mobile Number : "+ mobileNo;
    }
}
class Library{
    private HashMap<Book,Integer> booksList;
    Library(){
        booksList = new HashMap<>();
    }
    public void addBooks(Book book){
        book.setBookTitle(book.getBookTitle().toLowerCase());
        booksList.put(book,booksList.getOrDefault(book,0)+1);
        System.out.println("Book Added to Library Successfully...");
    }
    public boolean borrowBook(String bookTitle){
        for(Book book : booksList.keySet()){
            if(book.getBookTitle().equalsIgnoreCase(bookTitle) && booksList.get(book)>0){
                booksList.put(book,booksList.get(book)-1);
                return true;
            }
        }
        return false;
    }
    public void updateBooks(String bookTitle){
        for(Book book : booksList.keySet()){
            if(book.getBookTitle().equalsIgnoreCase(bookTitle)){
                booksList.put(book,booksList.get(book)+1);
                System.out.println("Book returned Successfully..");
                return ;
            }
        }
        System.out.println("Book Not returned successfully");
    }
    public void displayBooks(){
        for(Book book : booksList.keySet()){
            System.out.println(book);
        }
    }
}
class LibraryManagement{
    //Users
    User user1;
    User user2;
    User user3;
    User user4;
    User user5;
    //Library
    Library library;
    ArrayList<User> borrowedList;
    Scanner sc;
    LibraryManagement(){
        sc = new Scanner(System.in);
        library = new Library();
        borrowedList = new ArrayList<>();
        user1 = new User("Manoj",8754253549L);
        user2 = new User("Kumar",1234567892L);
        user3 = new User("Vishaal",9876543211L);
        user4 = new User("Vijay",7871149050L);
        user5 = new User("GOogle",6549873218L);
        //Books
        // book1 = new Book("The alone","xyz");
        // book2 = new Book("Advanced Java","abc");
        // book3 = new Book("Advanced Java","cde");
        // book4 = new Book("Cloud infra","ght");
        // book5 = new Book("The None","zxc");
        // book6 = new Book("The Google","trz");
    }
    public void add(){
        System.out.println("Enter Book Title:");
        String bookTitle = sc.nextLine().toLowerCase();
        System.out.println("Enter Book Author:");
        String bookAuthor = sc.nextLine().toLowerCase();
        library.addBooks(new Book(bookTitle,bookAuthor));
    }
    public void borrow(){
        User borrowUser = null;
        while(true){
            System.out.println("Enter User to Borrow Book : (1-5)");
            int userNo = sc.nextInt();
            sc.nextLine();
            if(userNo==1){
                borrowUser = user1;
                break;
            }
            else if(userNo==2){
                borrowUser = user2;
                break;
            }
            else if(userNo==3){
                borrowUser = user3;
                break;
            }
            else if(userNo==4){
                borrowUser = user4;
                break;
            }
            else if(userNo==5){
                borrowUser = user5;
                break;
            }
        }
        System.out.println("Enter Book Title to Borrow:");
        // sc.nextLine();
        String bookTitle = sc.nextLine().toLowerCase();
        if(library.borrowBook(bookTitle)){
            borrowedList.add(borrowUser);
            System.out.println(borrowUser +" Borrowed the Book titled as "+ bookTitle);
        }
        else{
            System.out.println("Book is Unavailable");
        }
    }
    public void returnBook(){
        User returnUser = null;
        while(true){
            System.out.println("Enter User to Return Book : (1-5)");
            int userNo = sc.nextInt();
            sc.nextLine();
            if(userNo==1){
                returnUser = user1;
                break;
            }
            else if(userNo==2){
                returnUser = user2;
                break;
            }
            else if(userNo==3){
                returnUser = user3;
                break;
            }
            else if(userNo==4){
                returnUser = user4;
                break;
            }
            else if(userNo==5){
                returnUser = user5;
                break;
            }        
        }
            if(borrowedList.contains(returnUser)){
                System.out.println("Enter Book Title to return : ");
                String bookTitle = sc.nextLine();   
                library.updateBooks(bookTitle);
                borrowedList.remove(returnUser);
                System.out.println(returnUser.getUserName() + " Returned book Successfully..");
            }
            else{
                System.out.println(returnUser.getUserName() + " You didn't Buy Any books");
            }
    }
    public void display(){
        library.displayBooks();
    }
    public void displayBorrowedList(){
        for(User borrowedUser : borrowedList){
            System.out.println(borrowedUser);
        }
    }
}
public class Main
{
	public static void main(String[] args) {
		LibraryManagement libraryManagement = new LibraryManagement();
		Scanner sc = new Scanner(System.in);
		while(true){
		    System.out.println("--------------------------------------------------");
		    System.out.println("Enter 1 - Add Books\nEnter 2 - Borrow Books\nEnter 3 - Return Book\nEnter 4 - Display Books\nEnter 5 - Display Borrowed Users\nEnter Any keys(Numbers) - Exit");
		    int option = sc.nextInt();
		    if(option==1){
		        libraryManagement.add();
		    }
		    else if(option==2){
		        libraryManagement.borrow();
		    }
		    else if(option==3){
		        libraryManagement.returnBook();
		    }
		    else if(option==4){
		        libraryManagement.display();
		    }
		    else if(option==5){
		        libraryManagement.displayBorrowedList();
		    }
		    else    
		        break;
		}
	}
}