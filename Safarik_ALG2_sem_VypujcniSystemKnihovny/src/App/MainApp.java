package App;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;

/**
 *
 * @author David
 */
public class MainApp {
    private BookInventory booksInv = new BookInventory();
    private ClientsList clients = new ClientsList();
    
    public void loadAllData(String pathToBookInventory, String pathToClientsList) throws IOException{
        booksInv.loadData(pathToBookInventory);
        clients.loadData(pathToClientsList);
    }
    
    public void saveAllData(String pathToBookInventory, String pathToClientsList) throws IOException{
        booksInv.saveData(pathToBookInventory);
        clients.saveData(pathToClientsList);
    }
    
    /**
     * Vypůjčí klientovi se zadaným ID knihu podle zadaného ISBN.
     * @param clientID ID klienta
     * @param ISBN ISBN vypůjčované knihy
     * @return True, pokud se podařilo; False, pokud kniha nebo klient nejsou v seznamu
     * @throws ParseException 
     */
    public boolean rentBook(int clientID, int ISBN) throws ParseException{
        Book b;
        if((b = booksInv.getBookByISBN(ISBN)) != null && clients.){
            booksInv.rentOutBook(ISBN);
            LocalDate today = LocalDate.now();
            String todayString = String.format("%s/%s/%s", today.getYear(), today.getMonthValue(), today.getDayOfMonth());
            RentedBook rentedBook = new RentedBook(b.getName(), b.getAuthorName(), b.getISBN(), b.getPublishDateString(), todayString);
            clients.rentBook(clientID, rentedBook);
        }
        return false;
    }
    
    /**
     * Formátovaný výstup s informacemi o stavu knihovny.
     * @return String formatted
     */
    public String getBookInventoryInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("------------------------------------------------------------------------------------------------------\n");
        sb.append(String.format("| %-15s | %-25s | %-20s | %-14s | %-12s |\n", "K vypůjčení", "Název", "Jméno autora", "ISBN", "Datum vydáni"));
        sb.append("------------------------------------------------------------------------------------------------------\n");
        for(Book b : booksInv.getBooksList()){
            String s = String.format("| %-15s | %-25s | %-20s | %-14d | %-12s |", b.isIsRented()?"Ne":"Ano", b.getName(), b.getAuthorName(), b.getISBN(), b.getPublishDateString());
            sb.append(s);
            sb.append("\n");
        }
        sb.append("------------------------------------------------------------------------------------------------------\n");
        return sb.toString();
    }
    
    /**
     * Formátovaný výstup o registrovaných klientech.
     * @return String formatted
     */
    public String getClientsListInfo(){
        StringBuilder sb = new StringBuilder();
        for(Client c : clients.getClientList()){
            sb.append("------------------------------------------------------------------------------------------------\n");
            sb.append(String.format("| ID: %-4d | Jméno: %-10s | Příjmení: %-10s | E-mail: %-30s |\n", c.getID(), c.getLastName(), c.getFirstName(), c.getEmail()));
            sb.append("------------------------------------------------------------------------------------------------\n\n");
            if(c.getRentedBooks().size() > 0){
                sb.append("Vypůjčené knihy:\n");
                sb.append("---------------------------------------------------------------------------------------\n");
                sb.append(String.format("| %-25s | %-20s | %-14s | %-15s |\n", "Název", "Jméno autora", "ISBN", "Datum vypůjčení"));
                sb.append("---------------------------------------------------------------------------------------\n");
                for(RentedBook b : c.getRentedBooks()){
                    sb.append(String.format("| %-25s | %-20s | %-14d | %-15s |\n", b.getName(), b.getAuthorName(), b.getISBN(), b.getRentDateString()));
                }
                sb.append("---------------------------------------------------------------------------------------\n\n");
            }
        }
        return sb.toString();
    }
    
    public static void main(String[] args) throws IOException{
        MainApp mApp = new MainApp();
        mApp.loadAllData("data/BooksInventory.txt", "data/ClientsListCopy.txt");
        System.out.println(mApp.getBookInventoryInfo());
        System.out.println(mApp.getClientsListInfo());
    }
    
}
