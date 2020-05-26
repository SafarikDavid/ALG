package App;

import java.text.ParseException;
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
    private String email;
    private ArrayList<RentedBook> rentedBooks;

    public Client(String firstName, String lastName, int ID, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        this.email = email;
        rentedBooks = new ArrayList<>();
    }

    public Client(String firstName, String lastName, int ID, String email, ArrayList<RentedBook> rentedBooks) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        this.email = email;
        this.rentedBooks = rentedBooks;
    }
    
    /**
     * Přidá knihu do seznamu vypůjčených knih klienta.
     * @param book
     */
    public void rentBook(RentedBook book){
        rentedBooks.add(book);
    }
    
    /**
     * Vrátí knihu se zadaným ISBN. Smaže ze seznamu půjčených knih.
     * @param ISBN ISBN hledane knihy
     * @return True, pokud byla kniha úspěšně nalezena a smazána; pokud neni kniha se zadaným ISBN v seznamu, tak False
     */
    public boolean returnBook(long ISBN){
        int i = findRentedBookByISBN(ISBN);
        if(i >= 0){
            rentedBooks.remove(i);
            return true;
        }
        return false;
    }
    
    /**
     * Najde index knihy podle ISBN.
     * @param ISBN ISBN knihy
     * @return -1 pokud kniha nenalezena, jinak index v seznamu
     */
    private int findRentedBookByISBN(long ISBN){
        int i = 0;
        for(RentedBook b : rentedBooks){
            if(b.getISBN() == ISBN){
                return i;
            }
            i++;
        }
        return -1;
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

    public String getEmail() {
        return email;
    }
    
    public ArrayList<RentedBook> getRentedBooks() {
        return rentedBooks;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(firstName).append(" ").append(lastName).append(" ").append(ID).append(" ").append(email).append("\n");
        for (RentedBook rentedBook : rentedBooks) {
            sb.append(rentedBook).append("\n");
        }
        return sb.toString();
    }
    
    public static void main(String[] args) throws ParseException{
        Client cus = new Client("Petr", "Orisek", 1, "fds@fds.com");
        cus.rentBook(new RentedBook("Kaer","JDF",4897645, "12/5/1999", "20/4/2020"));
        System.out.println(cus.toString());
        cus.returnBook(4897645);
        System.out.println(cus.toString());
    }
    
}
