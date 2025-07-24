package abbie.loops;

/**
 *
 * @author abiam
 */
public class BirthDate {
    private  int year;
    private final  int month;
    private final  int day;
    
    public BirthDate(int Year, int Month, int Day) {
    year = Year;
    month = Month;
    day = Day;
}
    public void setYear(int newYear) {
        year = newYear;
    }
}