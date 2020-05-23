package App;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author David Šafařík
 */
public class RentedBook extends Book{
    private Date rentDate;
    
    public RentedBook(String name, String authorName, int ISBN, String publishDate, String rentDate) throws ParseException {
        super(name, authorName, ISBN, publishDate, true);
        this.rentDate = SDF.parse(rentDate);
    }
    
    public RentedBook(String name, String authorName, int ISBN, Date publishDate, Date rentDate) {
        super(name, authorName, ISBN, publishDate, true);
        this.rentDate = rentDate;
    }

    @Override
    public String toString() {
        return super.toString() + " " + SDF.format(rentDate);
    }
    
    
    public static void main(String[] args){
        LocalDate today = LocalDate.now();
        Date dateNow = new Date(today.getYear(), today.getMonthValue()-1, today.getDayOfMonth());
        RentedBook rb;
        rb = new RentedBook("Pei","Karel",54325,new Date(1919,12,15), dateNow);
        System.out.println(rb.toString());
    }
    
}
