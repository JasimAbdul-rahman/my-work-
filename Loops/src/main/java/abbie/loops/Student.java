
package abbie.loops;

/**
 *
 * @author abiam
 */
public class Student {
    private final int id;  private BirthDate birthDate;
    
    
    public Student(int ssn,   int year, int month, int day) {
       id = ssn; 
    }
    
    public int getId() { 
        return id; 
    }
    
    public BirthDate getBirthDate() {
    return birthDate;
    }
    
}
