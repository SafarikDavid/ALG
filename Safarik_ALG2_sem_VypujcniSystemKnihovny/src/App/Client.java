package App;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author David Šafařík
 */
public class Client {
    private String firstName;
    private String lastName;
    private int ID;
    private ArrayList<RentedBook> rentedBooks;

    public Client(String firstName, String lastName, int ID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        rentedBooks = new ArrayList<>();
    }

    public Client(String firstName, String lastName, int ID, ArrayList<RentedBook> rentedBooks) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        this.rentedBooks = rentedBooks;
    }
    
    public void rentBook(RentedBook book){
        rentedBooks.add(book);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getID() {
        return ID;
    }

    public ArrayList<RentedBook> getRentedBooks() {
        return rentedBooks;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(firstName).append(" ").append(lastName).append(" ").append(ID).append("\n");
        for(RentedBook b : rentedBooks){
            sb.append(b.toString()).append("\n");
        }
        return firstName + " " + lastName + " " + ID;
    }
    
    public static void main(String[] args){
        Client cus = new Client("Petr", "Orisek", 1);
//        cus.rentBook(new Book("Kaer","JDF",4897645, new Date(1958, 5, 15)));
        System.out.println(cus.getRentedBooks());
        System.out.println(cus.toString());
    }
    
}
