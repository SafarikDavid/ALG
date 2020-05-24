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
    private String email;
    private ArrayList<Integer> rentedBooks;

    public Client(String firstName, String lastName, int ID, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        this.email = email;
        rentedBooks = new ArrayList<>();
    }

    public Client(String firstName, String lastName, int ID, String email, ArrayList<Integer> rentedBooks) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        this.email = email;
        this.rentedBooks = rentedBooks;
    }
    
    /**
     * Přidá ISBN vypůjčené knihy do seznamu vypůjčených knih klienta.
     * @param ISBN ISBN vypůjčené knihy
     */
    public void rentBook(int ISBN){
        rentedBooks.add(ISBN);
    }
    
    /**
     * Vrátí knihu podle zadaného ISBN. Smaže zadané ISBN ze seznamu vypůjčených knih klienta.
     * @param ISBN 
     */
    public void returnBook(int ISBN){
        for(Integer i : rentedBooks){
            if(i.equals(ISBN)){
                rentedBooks.remove(i);
                return;
            }
        }
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
    
    public ArrayList<Integer> getRentedBooks() {
        return rentedBooks;
    }
    
    public String getRentedBooksString(){
        StringBuilder sb = new StringBuilder();
        for(Integer i : rentedBooks){
            sb.append(i).append(" ");
        }
        return sb.toString();
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(firstName).append(" ").append(lastName).append(" ").append(ID).append(" ").append(email).append("\n");
        sb.append(this.getRentedBooksString());
        sb.append(";");
        return sb.toString();
    }
    
    public static void main(String[] args){
        Client cus = new Client("Petr", "Orisek", 1, "fds@fds.com");
//        cus.rentBook(new Book("Kaer","JDF",4897645, new Date(1958, 5, 15)));
        System.out.println(cus.getRentedBooks());
        System.out.println(cus.toString());
    }
    
}
