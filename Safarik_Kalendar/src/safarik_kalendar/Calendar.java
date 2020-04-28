package safarik_kalendar;

/**
 *
 * @author David Šafařík
 */
public class Calendar {
    private int day;
    private int month;
    private int year;
    private static int[] daysInMonths = {31,28,31,30,31,30,31,31,30,31,30,31};

    public Calendar(int day, int month, int year) {
        this.year = year;
        checkLeapYear(year);
        this.month = (checkMonthLimit(month))?month:daysInMonths.length;
        this.day = (checkDayLimit(day, this.month))?day:daysInMonths[this.month-1];
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }
    
    /**
     * checks whether the input day exceeds the number of days in a given month
     * @param d day number
     * @param m month number
     * @return true if in limits
     */
    private static boolean checkDayLimit(int d, int m){
        return d <= daysInMonths[m-1];
    }
    
    /**
     * Checks whether the input month exceeds the maximum of 12 months in a year
     * @param m month number
     * @return true if in limits
     */
    private static boolean checkMonthLimit(int m){
        return m <= daysInMonths.length;
    }
    
    /**
     * Builds a Windows like calendar
     * @return String with formated calendar
     */
    public String displayCalendar(){
        StringBuilder sb = new StringBuilder();
        sb.append(getDayNameString(dayOfWeek())).append(" ").append(day).append(" ").append(getMonthNameString(this.month)).append(" ").append(this.getYear());
        sb.append("\nSun Mon Tue Wed Thu Fri Sat\n");
        for(int i = 1; i < dayOfWeek(1); i++){
            sb.append("    ");
        }
        for(int i = 1; i <= daysInMonths[this.month-1]; i++){
            if(dayOfWeek(i)%7==1 && i != 1){
                sb.append("\n");
            }
            if(i/10==0){
                sb.append(" ").append(i);
            }else{
                sb.append(i);
            }
            sb.append("  ");
        }
        return sb.toString();
    }
    
    /**
     * Gives an English name of a day according to the input number
     * @param day number from 1 to 7
     * @return English names of days with Sunday = 1,... , Saturday = 7 
     */
    private static String getDayNameString(int day){
        final String[] DAYS_STRINGS = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
        return DAYS_STRINGS[day-1];
    }
    
    /**
     * Gives an English name if a month according to the input number
     * @param month number form 1 to 12
     * @return English names of months with January being 1
     */
    private static String getMonthNameString(int month){
        final String[] MONTHS_STRINGS = {"January","February","March","April","May","June","July","August","September","October","November","December"};
        return MONTHS_STRINGS[month-1];
    }
    /**
     * Calculates the day of week (Monday, Tuesday, ...)
     * @return int between 1 and 7, seven = Saturday, one = Sunday,...
     */
    public int dayOfWeek(){
        int d = this.day;
        int m = this.month;
        int y = this.year;
        if (m == 1 || m == 2) m+=12;
        int K = y%100;
        if (m == 13 || m == 14)K--;y--; 
        int J = y /100;
        int h = d + ((13*(m+1))/5) + K + (K/4) + (J/4) +(5*J);
        h %= 7;
        if(h == 0) {
            h = 7;
        }
        return h;
    }
    
    /**
     * Calculates the day of week (Monday, Tuesday, ...)
     * @param d day
     * @return int between 0 and 6, zero = Saturday, one = Sunday,...
     */
    public int dayOfWeek(int d){
        int m = this.month;
        int y = this.year;
        if (m == 1 || m == 2) m+=12;
        int K = y%100;
        if (m == 13 || m == 14)K--;y--; 
        int J = y /100;
        int h = d + ((13*(m+1))/5) + K + (K/4) + (J/4) +(5*J);
        h %= 7;
        if(h == 0) {
            h = 7;
        }
        return h;
    }
    
    /**
     * Static method, which decides whether the input year is bissextile
     * @param year input year upon which the method decides decide
     * @return true if year is bissextile, else false
     */
    public static boolean isLeapYear(int year){
        return year % 4 == 0 && (year % 100 != 0) || (year % 400 == 0);
    }
    
    /**
     * Return the number of days in the input year
     * @param year input year upon which the method calculates the number of days
     * @return 366 if is leap year, else 365
     */
    public static int daysInYear(int year){
        int days = 365;
        return (isLeapYear(year))?days+1:days;
    }
    
    /**
     * Checks whether the current year in bissextile and changes variable daysInMonths accordingly
     * @param year year upon which to check
     */
    public static void checkLeapYear(int year){
        daysInMonths[1] = (isLeapYear(year))?29:28;
    }
    
    /**
     * changes the current month to the next
     */
    public void nextMonth(){
        this.day = 1;
        if(month == 12){
            this.month = 1;
            this.year += 1;
        }else{
            this.month += 1;
        }
        checkLeapYear(this.year);
    }

    /**
     * changes the current month to the previous
     */
    public void previousMonth(){
        this.day = 1;
        if(month == 1){
            this.month = 12;
            this.year -= 1;
        }else{
            this.month -= 1;
        }
        checkLeapYear(this.year);
    }
    
    /**
     * changes the current month to the previous, but changes days to the last day of the new month
     */
    public void previousMonthLastDay(){
        if(month == 1){
            this.month = daysInMonths.length;
            this.year -= 1;
        }else{
            this.month -= 1;
        }
        this.day = daysInMonths[month-1];
        checkLeapYear(this.year);
    }
    
    /**
     * changes the current day to the next
     */
    public void nextDay(){
        if(checkDayLimit(day + 1, month)){
            day += 1;
        }else{
            nextMonth();
        }
    }
    
    /**
     * changes the current day to the previous
     */
    public void previousDay(){
        if(day - 1 < 1){
            previousMonthLastDay();
        }else{
            day -= 1;
        }
    }
    
    /**
     * Changes the current to year to the next. Changes day and month to 1.
     */
    public void nextYear(){
        year += 1;
        day = 1;
        month = 1;
    }
    
    /**
     * Changes the current to year to the previous. Changes day and month to 1.
     */
    public void previousYear(){
        year -= 1;
        day = 1;
        month = 1;
    }
    
    public static void main(String[] args){
        Calendar cal = new Calendar(16,15,2020);
        cal.nextYear();
        System.out.println(cal.displayCalendar());
//        System.out.println(cal.displayCalendar());
//        cal.previousDay();
//        System.out.println(cal.displayCalendar());
//        cal.nextDay();
//        System.out.println(cal.displayCalendar());
//        
//        System.out.println(cal.dayOfWeek());
//        System.out.println(isLeapYear(2020));
//        System.out.println(cal.displayCalendar());
//        cal.nextMonth();
//        System.out.println(cal.displayCalendar());
//        cal.nextMonth();
//        System.out.println(cal.displayCalendar());
//        cal.nextMonth();
//        System.out.println(cal.displayCalendar());
//        cal.nextMonth();
//        System.out.println(cal.displayCalendar());
//        cal.nextMonth();
//        System.out.println(cal.displayCalendar());
//        cal.nextMonth();
//        System.out.println(cal.displayCalendar());
//        cal.nextMonth();
//        System.out.println(cal.displayCalendar());
//        cal.nextMonth();
//        System.out.println(cal.displayCalendar());
//        cal.nextMonth();
//        System.out.println(cal.displayCalendar());
//        cal.nextMonth();
//        System.out.println(cal.displayCalendar());
//        cal.nextMonth();
//        System.out.println(cal.displayCalendar());
//        Calendar cal2 = new Calendar(1,2,2020);
//        System.out.println(cal2.dayOfWeek());
    }
}
