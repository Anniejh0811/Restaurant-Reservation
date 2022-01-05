/**
 * This class implements Person and store the information about the person .
 * 
 */
public class Person {
    private String name;
    private boolean chairNeeded;
    private int peopleNumber;
    private String time;
    
    /**
     * Constructor of the person
     * 
     * @param name the name of the person
     * @param chairNeeded check if the person needs chair
     * @param peopleNumber the number of people attending
     * @param time the time a person will arrive
     */
    public Person(String name, boolean chairNeeded, int peopleNumber, String time) {
       this.name = name;
       this.chairNeeded = chairNeeded;
       this.peopleNumber = peopleNumber;
       this.time = time;
    }
    
    /**
     * Get the name of the person
     * 
     * @param get the name of the person
     */
    public String getName() {
      return name;
    }
    
    /**
     * Check if person needs chair
     * 
     * @param true if the person need chair, otherwise false
     */
    public Boolean getChairNeeded() {
      return chairNeeded;
    }
    
    /**
     * Get the number of guests attending
     * 
     * @param Get the number of guests attending
     */
    public int getPeopleNumber() {
      return peopleNumber;
    }
    
    /**
     * Get the time
     * 
     * @param Get the time
     */
    public String getTime() {
      return time;
    }
    
    /**
     * Get the string representation of information about the person
     * 
     * @param Get the string representation of information about the person
     */
    public String toString() {
      String str = "";
      str += getName()+" ";
      if(chairNeeded) {
        str += "yes ";
      }else {
        str += "no ";
      }
      str+=getPeopleNumber()+" " + getTime();
      return str;
    }
}
