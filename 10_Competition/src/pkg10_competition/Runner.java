package pkg10_competition;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author David Šafařík
 */
public class Runner implements Comparable<Runner>{
    private String firstName;
    private String lastName;
    private int number;
    private LocalTime startTime;
    private LocalTime finishTime;
    public final static DateTimeFormatter DTF_START = DateTimeFormatter.ofPattern("HH:mm:ss");
    public final static DateTimeFormatter DTF_FINISH = DateTimeFormatter.ofPattern("HH:mm:ss:SSS");

    public Runner(String firstName, String lastName, int number) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getNumber() {
        return number;
    }

    public LocalTime getStartTime() {
        return startTime;
    }
    
    public String getStartTimeString(){
        return startTime.format(DTF_START);
    }
    
    public String getFinishTimeString(){
        return finishTime.format(DTF_FINISH);
    }

    public LocalTime getFinishTime() {
        return finishTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = LocalTime.parse(startTime,DTF_START);
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = LocalTime.parse(finishTime,DTF_FINISH);
    }
    
    public LocalTime runningTime(){
        return LocalTime.ofNanoOfDay(finishTime.toNanoOfDay() - startTime.toNanoOfDay());
    }
    
    @Override
    public String toString(){
        return String.format("%-4s%-10s%-10s%-15s%-15s%-15s", number ,firstName, lastName, getStartTimeString(), getFinishTimeString(), runningTime().format(DTF_FINISH));
    }
    
    public static void main(String[] args){
        Runner r = new Runner("Filip", "Kral", 25);
        r.setStartTime("09:00:00");
        r.setFinishTime("10:30:25:763");
        System.out.println(r);
    }

    @Override
    public int compareTo(Runner o) {
        return this.runningTime().compareTo(o.runningTime());
    }
    
}