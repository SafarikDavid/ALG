package UI;

import App.MainApp;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

/**
 *
 * @author David Šafařík
 */
public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static String pathToBookInventory = "data/BooksInventory.txt";
    private static String pathToClientsList = "data/ClientsList.txt";
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //načti data ze souborů
        MainApp app = new MainApp();
        boolean areFilesLoaded = false;
        try {
            app.loadAllData(pathToBookInventory, pathToClientsList);
            System.out.println("Data úspěšně načtena.");
            areFilesLoaded = true;
        } catch (IOException ex) {
            System.out.println("Neexistujici vstupni soubory.\n" + pathToBookInventory + "\n" + pathToClientsList);
        }
        if(areFilesLoaded){
            //cyklus programu
            int choice, choiceInner, clientID, returnCode;
            long ISBN;
            boolean isChoiceLoaded;
            do{
                //vypiš menu
                System.out.println(getMainMenu());
                
                //načti volbu
                choice = checkInteger();
                
                //switch statement
                switch(choice){
                    
                    //BookInventory práce
                    case 1:
                        do{
                            System.out.println(getBookInventoryMenu());
                            //načti volbu
                            choiceInner = checkInteger();
                            
                            switch(choiceInner){
                                //vypiš všechny knihy
                                case 1:
                                    System.out.println(app.getBookInventoryInfo());
                                    break;
                                //serad knihy abecedne a vypiš
                                case 2:
                                    app.sortInventoryByNameOfBook();
                                    System.out.println(app.getBookInventoryInfo());
                                    break;
                                //serad knihy abecedne podle autora a vypis
                                case 3:
                                    app.sortInventoryByNameOfAuthor();
                                    System.out.println(app.getBookInventoryInfo());
                                    break;
                                //serad knihy podle data vydani a vypis
                                case 4:
                                    app.sortInventoryByPublishDate();
                                    System.out.println(app.getBookInventoryInfo());
                                    break;
                                //pridej knihu do inventare
                                case 5:
                                    System.out.println("Zadejte nazev knihy:");
                                    String name = sc.nextLine();
                                    System.out.println("Zadejte jméno autora:");
                                    String authorName = sc.nextLine();
                                    System.out.println("Zadejte ISBN:");
                                    long ISBNadd = checkISBN();
                                    System.out.println("Zadejte datum vydání knihy:");
                                    String publishDate = checkDate();
                                    try {
                                        app.addNewBookToInventory(name, authorName, ISBNadd, publishDate);
                                        System.out.println("Kniha úspěšně přidána.");
                                    } catch (ParseException ex) {
                                        System.out.println("Špatně zadané datum. Knihu se nepodařilo přidat.");
                                    }
                                    break;
                                //návrat
                                case 0:
                                    System.out.println("Vracím se do hlavního menu.");
                                    break;
                                default:
                                    break;
                            }
                        }while(choiceInner != 0);
                        break;
                        
                    //client práce
                    case 2:
                        do{
                            System.out.println(getClientMenu());
                            choiceInner = checkInteger();
                            switch(choiceInner){
                                //registruj klienta 
                                case 4:
                                    System.out.println("Zadejte křestní jméno klienta:");
                                    String firstName = checkIfStringWithoutWhiteSpace();
                                    System.out.println("Zadejte příjmení klienta:");
                                    String lastName = checkIfStringWithoutWhiteSpace();
                                    System.out.println("Zadejte email:");
                                    String email = checkIfStringWithoutWhiteSpace();
                                    int ID = app.getNewClientID();
                                    app.addNewClientToList(firstName, lastName, ID, email);
                                    break;
                                //vypiš registrované klienty
                                case 1:
                                    System.out.println(app.getClientsListInfo());
                                    break;
                                //posli email o nevrácených knihách
                                case 5:
                                    ID = checkInteger();
                                    String recipient = app.getClientsMail(ID);
                                    if(recipient != null){
                                        System.out.println("Zadejte heslo:");
                                        String pass = sc.nextLine();
                                        {
                                            try {
                                                app.sendMail("programmailtesterknihovna@gmail.com", "programmailtesterknihovna@gmail.com", pass, "Knihovna", "Vrat knihy.");
                                                System.out.println("Povedlo se.");
                                            } catch (Exception ex) {
                                                System.out.println("Nastala chyba.");
                                            }
                                        }
                                    }else{
                                        System.out.println("Klient s daným ID neexistuje.");
                                    }
                                    break;
                                //setrid podle prijmeni
                                case 2:
                                    app.sortClientsListByLastName();
                                    System.out.println(app.getClientsListInfo());
                                    break;
                                //setrid podle id
                                case 3:
                                    app.sortClientsListByID();
                                    System.out.println(app.getClientsListInfo());
                                    break;
                                //návrat
                                case 0:
                                    System.out.println("Vracím se do hlavní nabídky.");
                                    break;
                                default:
                                    break;
                            }
                        }while(choiceInner != 0);
                        break;
                        
                    //výpůjčky
                    case 3:
                        do{
                            System.out.println(getRentMenu());
                            choiceInner = checkInteger();
                            switch(choiceInner){
                                //vypůjčit knihu
                                case 1:
                                    System.out.println("Zadejte ID klienta:  ");
                                    clientID = checkInteger();
                                    System.out.println("Zadejte ISBN kniihy: ");
                                    ISBN = checkISBN();
                                    returnCode = 2;
                                    try {
                                        returnCode = app.rentBook(clientID, ISBN);
                                    } catch (ParseException ex) {
                                        System.out.println("Kniha v seznamu je špatně naformátována.");
                                    }
                                    switch(returnCode){
                                        case 0:
                                            System.out.println("Kniha úspěšně vypůjčena.");
                                            break;
                                        case 1:
                                            System.out.println("Klient nebo kniha nejsou v seznamu, nebo je kniha již vypůjčena.");
                                            break;
                                        case 2:
                                            System.out.println("Klient není v seznamu.");
                                            break;
                                        default:
                                            System.out.println("Neočekávaná chyba.");
                                            break;
                                    }
                                    break;
                                //vrátit knihu
                                case 2:
                                    System.out.println("Zadej ID klienta: ");
                                    clientID = checkInteger();
                                    System.out.println("Zadej ISBN knihy: ");
                                    ISBN = checkISBN();
                                    returnCode = app.returnBook(clientID, ISBN);
                                    switch(returnCode){
                                        case 0:
                                            System.out.println("Kniha úspěšně vrácena.");
                                            break;
                                        case 1:
                                            System.out.println("Klient není v seznamu nebo kniha není vypůjčena.");
                                            break;
                                        case 2:
                                            System.out.println("Kniha není v invetáři zaznamenána.");
                                            break;
                                        default:
                                            System.out.println("Neočekávaná chyba.");
                                            break;
                                    }
                                    break;
                                //návrat
                                case 0:
                                    System.out.println("Vracím se do hlavní nabídky.");
                                    break;
                                default:
                                    break;
                            }
                        }while(choiceInner != 0);
                        break;
                        
                    //ukoncit
                    case 0:
                        System.out.println("Konec programu.");
                        String toSave;
                        do{
                            System.out.println("Přejete si uložit změny v knihovních souborech? y/n");
                            toSave = sc.nextLine();
                            if(toSave.matches("[yY]")){
                                try {
                                    app.saveAllData(pathToBookInventory, pathToClientsList);
                                    System.out.println("V pořádku uloženo.");
                                } catch (IOException ex) {
                                    System.out.println("Nepodařilo se uložit.");
                                }
                            }else if(toSave.matches("[nN]")){
                                System.out.println("Neukládám a končím.");
                            }else{
                                System.out.println("y/n");
                            }
                        }while(!toSave.matches("[yY]|[nN]")); //[yY](?![nN])|[nN](?![yY])
                        break;
                    default:
                        System.out.println("Neznámá volba.");
                        break;
                }
            }while(choice != 0);
        }
    }
    
    /**
     * Vrátí string s výpisem volby pro hlavní menu.
     * @return 
     */
    private static String getMainMenu() {
        return "-----------------------\n"
                + "1: Knihovní inventář\n"
                + "2: Klienti\n"
                + "3: Výpůjčky\n"
                + "0: Ukončit program\n"
                + "-----------------------";
    }
    
    /**
     * Menu pro volby výpůjček.
     * @return 
     */
    private static String getRentMenu() {
        return "---------------------------\n"
                + "1: Vypůjčit knihu\n"
                + "2: Vrátit knihu\n"
                + "0: Návrat do hlavního menu\n"
                + "---------------------------";
    }

    /**
     * Menu pro volby práce se seznamem klientů.
     * @return 
     */
    private static String getClientMenu() {
        return "-----------------------------------------\n"
                + "1: Vypiš registrované klienty\n"
                + "2: Setříď seznam podle příjmení a vypiš\n"
                + "3: Setříď seznam podle ID a vypiš\n"
                + "4: Registruj klienta\n"
                + "5: Email\n"
                + "0: Návrat do hlavního menu\n"
                + "-----------------------------------------";
        
    }

    /**
     * Menu pro práci s inventářem.
     * @return 
     */
    private static String getBookInventoryMenu() {
        return "-------------------------------------------\n"
                + "1: Vypiš všechny knihy\n"
                + "2: Seřaď knihy podle názvu a vypiš\n"
                + "3: Seřaď knihy podle jména autora a vypiš\n"
                + "4: Seřaď knihy podle data vydání a vypiš\n"
                + "5: Přidej knihu do inventáře\n"
                + "0: Návrat do hlavního menu\n"
                + "-------------------------------------------";
    }
    
    /**
     * Kontroluje, zda je zadaný string bez mezer.
     * @return zadaný string
     */
    private static String checkIfStringWithoutWhiteSpace(){
        do{
            String string = sc.nextLine();
            if(string.contains(" ")){
                System.out.println("Nepovolená mezera.");
            }else{
                return string;
            }
        }while(true);
    }
    
    /**
     * Cyklus pro načtení integer. Až po úspěšném načtení integer vrací načtenou hodnotu.
     * @return načtenou hodnotu integer
     */
    private static int checkInteger(){
        do{
            String integer = sc.nextLine();
            try{
                return Integer.parseInt(integer);
            }catch(NumberFormatException n){
                System.out.println("Zadávejte pouze celá čísla.");
            }
        }while(true);
    }
    
    /**
     * Zkontroluje formát zadaného data. V cyklu, dokud uživatel nezadá správný formát.
     * @return String s datem
     */
    private static String checkDate(){
        System.out.println("Formát: dd/mm/rr");
        String date;
        while(true){
            if((date = sc.nextLine()).matches("^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$")){
                return date;
            }
            System.out.println("Špatný formát.");
        }
    }
    
    /**
     * Zkontroluje jestli uživatel zadal long.
     * @return 
     * @see checkInteger()
     */
    private static long checkLong(){
        do{
            String longInteger = sc.nextLine();
            try{
                return Long.parseLong(longInteger);
            }catch(NumberFormatException n){
                System.out.println("Zadávejte pouze celá čísla.");
            }
        }while(true);
    }
    
    /**
     * Pro testování bude pro ověření ISBN použita tato metoda. Pouze kontroluje, zda je vstup typu long.
     * @return long number
     */
    private static long checkISBN(){
        return checkLong();
    }
    
    /**
     * Zkontroluje správnost zadaného ISBN.
     * @return ISBN, pokud je správné, jinak 0
     */
    private static long checkISBNreal(){
        long ISBN = checkLong();
        if(countdigits(ISBN) != 13){
            long ISBNcopy = ISBN;
            long[] ISBNparts = new long[13];
            for(int i = 12; i >= 0; i--){
                ISBNparts[i] = ISBNcopy%10;
                ISBNcopy /= 10;
            }
            int sum = 0;
            for(int i = 0; i < ISBNparts.length - 1; i++){
                sum += ISBNparts[i]*((i%2==0)?1:3);
            }
            sum %= 10;
            if(sum != 0){
                if(10 - sum == ISBNparts[12]){
                    return ISBN;
                }
            }else{
                return ISBN;
            }
        }
        return 0;
    }
    
    /**
     * Zjisti pocet cislic long cisla.
     * @param n Zadané číslo k testování
     * @return počet číslic
     */
    private static int countdigits(long n){
        int count = 0;
        long copy = n;
        while(copy != 0){
            copy /= 10;
            count++;
        }
        return count;
    }
}