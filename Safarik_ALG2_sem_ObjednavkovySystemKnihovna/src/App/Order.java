package App;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author David
 */
public class Order {
    //TODO ID, date of objednavka
    private Customer customer;
    private ArrayList<Book> books;

    public Order(Customer customer, ArrayList<Book> books) {
        this.customer = customer;
        this.books = books;
    }

    public Customer getCustomer() {
        return customer;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(customer.toString());
        for(Book b : books){
            sb.append("\n").append(b.toString());
        }
        return sb.toString();
    }
    
    public static void main(String[] args){
        Customer customer = new Customer("Petr", "Fila");
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Pavel", "Honza", "Nedved", 789456, new Date(1958, 5, 15)));
        Order order = new Order(customer, books);
        System.out.println(order.toString());
    }
    
}
