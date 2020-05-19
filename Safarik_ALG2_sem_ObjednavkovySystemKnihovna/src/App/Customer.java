package App;

/**
 *
 * @author David
 */
public class Customer {
    private String firstName;
    private String lastName;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
    
    public static void main(String[] args){
        Customer cus = new Customer("Petr", "Orisek");
        System.out.println(cus.toString());
    }
    
}
