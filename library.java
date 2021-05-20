import java.util.Scanner;

class book {

public int sNo;
public String bookName;
public String authorName;
public int bookQty;
public int bookQtyCopy;

Scanner input = new Scanner(System.in);

book(){
	boolean loop1 = true, loop2 = true, loop3 = true,loop4 = true;
	do
    {
		System.out.println("Enter Serial No of Book:");
		
		if(input.hasNextInt())
		{	
			this.sNo = input.nextInt();
			loop1 = false;
			break;
		}
		
		else
		{
			System.out.println("Enter digits as input");
		}
		input.nextLine();
    }while(loop1);
	
	input.nextLine();
	do
	{
		System.out.println("Enter Book Name:");
		if(input.hasNextInt())
		{	
			loop2= true;
			System.out.println("Enter a valid name");
		}
		else
		{
			this.bookName = input.nextLine();
			loop2= false;
			break;
		}
		input.nextLine();
	}while(loop2);

	do
	{
		System.out.println("Enter Author Name:");
		if(input.hasNextInt())
		{	
			loop3= true;
			System.out.println("Enter a valid name");
		}
		else
		{
			this.authorName = input.nextLine();
			loop3= false;
			break;
		}
		input.nextLine();
	}while(loop3);

	do
    {
		System.out.println("Enter Quantity of Books:");
		
		if(input.hasNextInt())
		{	
			this.bookQty = input.nextInt();
			loop4 = false;
			break;
		}
		
		else
		{
			System.out.println("Enter digits as input");
		}
		input.nextLine();
    }while(loop4);
	
    bookQtyCopy = this.bookQty;

}

}

class books {

book theBooks[] = new book[50];     // Array that stores 'book' Objects.
public static int count;    // Counter for No of book objects Added in Array.

Scanner input = new Scanner(System.in);




int compareBookObjects(book b1, book b2){

    if (b1.bookName.equalsIgnoreCase(b2.bookName)){

        System.out.println("Book of this Name Already Exists.");
        return 0;

    }
    if (b1.sNo==b2.sNo){

        System.out.println("Book of this Serial No Already Exists.");
        return 0;
    }
    return 1;
}

void addBook(book b){

    for (int i=0; i<count; i++){

        if (this.compareBookObjects(b, this.theBooks[i]) == 0)
            return;

    }

    if (count<50){

        theBooks[count] = b;
        count++;

    }
    else{

        System.out.println("No Space to Add More Books.");

    }

}

void searchBySno(){

    System.out.println("\t\t\t\tSEARCH BY SERIAL NUMBER\n");

    int sNo = 0;
    boolean loop1 = true;
    do
    {
		System.out.println("Enter Serial No of Book:");
		
		if(input.hasNextInt())
		{	
			sNo = input.nextInt();
			loop1 = false;
			break;
		}
		
		else
		{
			System.out.println("Enter digits as input");
		}
		input.nextLine();
    }while(loop1);
	
	input.nextLine();
    

    int flag = 0;
    System.out.println("S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");
    for (int i=0; i<count; i++){

        if (sNo == theBooks[i].sNo){

            System.out.println(theBooks[i].sNo + "\t\t" + theBooks[i].bookName + "\t\t" + theBooks[i].authorName + "\t\t" + 
                theBooks[i].bookQtyCopy + "\t\t" + theBooks[i].bookQty);
            flag++;
            return;

        }

    }
    if (flag == 0)
        System.out.println("No Book for Serial No " + sNo + " Found.");

}

void searchByAuthorName(){

    System.out.println("\t\t\t\tSEARCH BY AUTHOR'S NAME");
    
    String authorName = "";
    
    boolean loop2 = true;
    do
	{
    	System.out.println("Enter Author Name:");
		if(input.hasNextInt())
		{	
			loop2= true;
			System.out.println("Enter a valid name");
		}
		else
		{
			authorName = input.nextLine();
			loop2= false;
			break;
		}
		input.nextLine();
	}while(loop2);

    int flag = 0;
    System.out.println("S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");
    for (int i=0; i<count; i++){

        if (authorName.equalsIgnoreCase(theBooks[i].authorName)){

            System.out.println(theBooks[i].sNo + "\t\t" + theBooks[i].bookName + "\t\t" + theBooks[i].authorName + "\t\t" + 
                theBooks[i].bookQtyCopy + "\t\t" + theBooks[i].bookQty);
            flag++;
        }

    }
    if (flag == 0)
        System.out.println("No Books of " + authorName + " Found.");

}


void showAllBooks(){

    System.out.println("\t\t\t\tSHOWING ALL BOOKS\n");
    System.out.println("S.No\t\tName\t\tAuthor\t\tAvailable Qty\t\tTotal Qty");
    for (int i=0; i<count; i++){

        System.out.println(theBooks[i].sNo + "\t\t" + theBooks[i].bookName + "\t\t" + theBooks[i].authorName + "\t\t" + 
                theBooks[i].bookQtyCopy + "\t\t" + theBooks[i].bookQty);


    }

}

void upgradeBookQty(){

    System.out.println("\t\t\t\tUPGRADE QUANTITY OF A BOOK\n");

    int sNo = 0;
    
    boolean loop1 = true;
    do
    {
		System.out.println("Enter Serial No of Book:");
		
		if(input.hasNextInt())
		{	
			sNo = input.nextInt();
			loop1 = false;
			break;
		}
		
		else
		{
			System.out.println("Enter digits as input");
		}
		input.nextLine();
    }while(loop1);
	
    int flag1 = 0;
    
    for (int i=0; i<count; i++){
    	
    	int addingQty = 0;
    	
        if (sNo == theBooks[i].sNo){

        	boolean loop2 = true;
            do
            {
        		System.out.println("Enter No of Books to be added:");
        		
        		if(input.hasNextInt())
        		{	
        			addingQty = input.nextInt();
        			loop2 = false;
        			flag1++;
        			//break;
        		}
        		
        		else
        		{
        			System.out.println("Enter digits as input");
        		}
        		input.nextLine();
            }while(loop2);
            
            theBooks[i].bookQty += addingQty;
            theBooks[i].bookQtyCopy += addingQty;
            return;

        }
        
    }
    if(flag1 == 0)
    	System.out.println("Enter a valid Serial number");
    return;
}


void dispMenu(){

    System.out.println("----------------------------------------------------------------------------------------------------------");
    System.out.println("Enter 0 to Exit Application.");
    System.out.println("Enter 1 to Add new Book.");
    System.out.println("Enter 2 to Upgrade Quantity of a Book.");
    System.out.println("Enter 3 to Search a Book.");
    System.out.println("Enter 4 to Show All Books.");
    System.out.println("Enter 5 to Register Student.");
    System.out.println("Enter 6 to Show All Registered Students.");
    System.out.println("Enter 7 to Check Out Book. ");
    System.out.println("Enter 8 to Check In Book");
    System.out.println("----------------------------------------------------------------------------------------------------------");

}
int isAvailable(int sNo){

    //returns the index number if available



    for (int i=0; i<count; i++){

        if (sNo == theBooks[i].sNo){
            if(theBooks[i].bookQtyCopy > 0){

                System.out.println("Book is Available.");
                return i;

            }
            System.out.println("Book is Unavailable");
            return -1;

        }

    }

    System.out.println("No Book of Serial Number " + " Available in Library.");
    return -1;


}
book checkOutBook(){

    int sNo = 0;
    boolean loop1 = true;
    do
    {
		System.out.println("Enter Serial No of Book:");
		
		if(input.hasNextInt())
		{	
			sNo = input.nextInt();
			loop1 = false;
			break;
		}
		
		else
		{
			System.out.println("Enter digits as input");
		}
		input.nextLine();
    }while(loop1);
    
    int bookIndex =isAvailable(sNo);

    if (bookIndex!=-1){

        //int bookIndex = isAvailable(sNo);
        theBooks[bookIndex].bookQtyCopy--;

        return theBooks[bookIndex];
    }

    return null;

}

void checkInBook(book b){

    for (int i=0; i<count; i++){

        if (b.equals(theBooks[i]) ){

            theBooks[i].bookQtyCopy++;
            return;

        }

    }

}
}

class student {

String studentName;
String regNum;

book borrowedBooks[] = new book[3];
public int booksCount = 0;

Scanner input = new Scanner(System.in);

student(){

    System.out.println("Enter Student Name:");
    this.studentName = input.nextLine();

    boolean loop1 = true;
    do
    {
    	System.out.println("Enter Reg Number:");
		
		if(input.hasNextInt())
		{	
			this.regNum = input.nextLine();
			loop1 = false;
			break;
		}
		
		else
		{
			System.out.println("Enter digits as input");
		}
		input.nextLine();
    }while(loop1);
    
}
}


class students {

Scanner input = new Scanner(System.in);

student theStudents[] = new student[50];

//books book;

public static int count = 0;

void addStudent(student s){

    for (int i=0; i<count; i++){

        if(s.regNum.equalsIgnoreCase(theStudents[i].regNum)){

            System.out.println("Student of Reg Num " + s.regNum + " is Already Registered.");
            return;
        }

    }

    if (count<=50){

        theStudents[count] = s;
        count++;

    }

}
void showAllStudents(){

    System.out.println("Student Name\t\tReg Number");
    for (int i=0; i<count; i++){

        System.out.println(theStudents[i].studentName + "\t\t" + theStudents[i].regNum);

    }


}

int isStudent(){
    //return index number of student if available

     //System.out.println("Enter Student Name:");
    //String studentName = input.nextLine();

		String regNum = "";
	
    	boolean loop1 = true;
    	do
        {
    		System.out.println("Enter Reg Number:");
    		
    		if(input.hasNextInt())
    		{	
    			regNum = input.nextLine();
    			loop1 = false;
    			break;
    		}
    		
    		else
    		{
    			System.out.println("Enter digits as input");
    		}
    		input.nextLine();
        }while(loop1);
    
    for (int i=0; i<count; i++){

        if (theStudents[i].regNum.equalsIgnoreCase(regNum)){

            return i;

        }

    }
    System.out.println("Student is not Registered.");
    System.out.println("Get Registered First.");


    return -1;

}
void checkOutBook(books book){
    int studentIndex =this.isStudent();

    if (studentIndex!=-1){
        System.out.println("checking out");

        book.showAllBooks();
        book b = book.checkOutBook();
        System.out.println("checking out");
        if (b!= null){

            if (theStudents[studentIndex].booksCount<=3){
                System.out.println("adding book");
                theStudents[studentIndex].borrowedBooks[theStudents[studentIndex].booksCount] = b;
                theStudents[studentIndex].booksCount++;
                return;

            }
            else {

                System.out.println("Student Can not Borrow more than 3 Books.");
                return;

            }
        }
        System.out.println("Book is not Available.");

    }

}

void checkInBook(books book){

    int studentIndex = this.isStudent();
    if (studentIndex != -1){
        
    	System.out.println("S.No\t\t\tBook Name\t\t\tAuthor Name");
        student s = theStudents[studentIndex];
        
        for (int i=0; i<s.booksCount; i++){

            System.out.println(s.borrowedBooks[i].sNo+ "\t\t\t" + s.borrowedBooks[i].bookName + "\t\t\t"+
                    s.borrowedBooks[i].authorName);

        }
        
        int sNo = 0;
        boolean loop1 = true;
    	do
        {
    		System.out.println("Enter Serial Number of Book to be Checked In:");
    		
    		if(input.hasNextInt())
    		{	
    			sNo = input.nextInt();
    			loop1 = false;
    			break;
    		}
    		
    		else
    		{
    			System.out.println("Enter digits as input");
    		}
    		input.nextLine();
        }while(loop1);
      
        for (int i=0; i<s.booksCount; i++){

            if (sNo == s.borrowedBooks[i].sNo){

                book.checkInBook(s.borrowedBooks[i]);
                s.borrowedBooks[i]=null;
                return;

            }

        }
        System.out.println("Book of Serial No "+sNo+"not Found");

    }
}
}

class Library {


public static void main(String[] args) {

    Scanner input = new Scanner(System.in);

    System.out.println("********************Welcome to the Student Library!********************");
    System.out.println("              Please Select From The Following Options:               ");
System.out.println("**********************************************************************");
    books ob = new books();
    students obStudent = new students();
    int choice = 0;
    int searchChoice = 0;

    do{
    	boolean loop1 = true;
    	do
        {
    		ob.dispMenu();
    		
    		if(input.hasNextInt())
    		{	
    			choice = input.nextInt();
    			loop1 = false;
    			break;
    		}
    		
    		else
    		{
    			System.out.println("CHOICE SHOULD BE BETWEEN 0 TO 8.");
    		}
    		input.nextLine();
        }while(loop1);

        switch(choice){

            case 1:
                book b = new book();
                ob.addBook(b);
                break;

            case 2:
                ob.upgradeBookQty();
                break;

            case 3:
            	boolean loop2 = true;
            	do
                {
            		System.out.println("Enter 1 to Search with Serial No.");
                    System.out.println("Enter 2 to Search with Author Name(Full Name).");
                    searchChoice = input.nextInt();
            		
					if(searchChoice == 1 || searchChoice == 2)
            		{	
            		
            			loop2 = false;
            			break;
            		}
            		
            		else
            		{
            			System.out.println("Enter a valid choice");
            		}
            		input.nextLine();
                }while(loop2);
     
                switch(searchChoice){

                    case 1:
                        ob.searchBySno();
                        break;
                    case 2:
                        ob.searchByAuthorName();

                }
                break;

            case 4:
                ob.showAllBooks();
                break;
            case 5:
                student s = new student();
                obStudent.addStudent(s);
                break;
            case 6:
                obStudent.showAllStudents();
                break;
            case 7:
                obStudent.checkOutBook(ob);
                break;
            case 8:
                obStudent.checkInBook(ob);
                break;
            default:
                System.out.println("CHOICE SHOULD BE BETWEEN 0 TO 8.");

        }

    }
    while (choice!=0);
}
}
