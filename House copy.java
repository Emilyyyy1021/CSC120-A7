/* the House Class */
import java.util.ArrayList;

public class House extends Building{

  private ArrayList<String> residents; // The <String> tells Java what kind of data we plan to store IN the ArrayList
  private boolean hasDiningRoom;
  private boolean hasElevator;


  public House(String name, String address, int nFloors, boolean hasDiningRoom, boolean hasElavator, ArrayList<String> residents) {
    super(name, address, nFloors);
    this.hasDiningRoom = hasDiningRoom;
    this.hasElevator = hasElevator;
    this.residents = residents;
  }

  /**
   * Getter for whether has a dinning room 
   * @return T/F has a dinning room
   */
  public boolean hasDiningRoom() {
    return this.hasDiningRoom;
  }

  /**
   * Getter for number of residents 
   * @return number of residents 
   */
  public int nResidents() {
    try{
      return this.residents.size();
  }catch (Exception e){
    System.out.println(e);
    return 0;
  }
  }

  /**
   * resident movein
   * @param name name of resident
   */
  public void moveIn(String name){
    if (isResident(name) == false){
      this.residents.add(name);
    }
  }

   /**
     * Resident move-in with specified age and occupation
     * @param name Name of resident
     * @param year which year the student is
     */
    public void moveIn(String name, String year){
      String residentInfo = name + " (Age: " + age")";
      if (!isResident(name)){
          this.residents.add(residentInfo);
          System.out.println(residentInfo + " moved into " + this.name);
      }
  }

  /**
   * resident moveout
   * @param name the name of resident
   * @return name the name of resident who moved out
   */
  // return the name of the person who moved out
  public String moveOut(String name){
    if (isResident(name) == true){
      this.residents.remove(name);
      return name;
    }else {
      return name + "Not found";
    }
  }

  /**
     * Resident move-out with specified departure reason
     * @param name Name of resident
     * @param reason Reason for departure
     * @return Name of resident who moved out
     */
    public String moveOut(String name, String reason){
      if (isResident(name)){
          this.residents.remove(name);
          return name + " moved out of " + this.name + " due to " + reason;
      } else {
          return name + " not found in " + this.name;
      }
  }


  /**
   * the resident is in the house
   * @param person the resident 
   * @return T/F if the resident is the list
   */
  public boolean isResident(String person){
    if (this.residents.contains(person)){
      System.out.println(person + " is in " + name);
      return true;
    }else{
      return false;
    }
  }

  /* show the options */
  @Override
  public void showOptions() {
    System.out.println("Available options at " + this.name + ":\n + moveIn() \n + moveOut() \n + goToFloor(n)");
  }

  /**
   * go to different floor
   * @param floorNum
   */
  public void goToFloor(int floorNum) {
    try {
        if (this.hasElevator) {
            super.goToFloor(floorNum);
        } else {
            if (floorNum > activeFloor) {
                super.goUp();
                System.out.println("current floor: " + activeFloor);
            } else if (floorNum < activeFloor) {
                super.goDown();
                System.out.println("current floor: " + activeFloor);
            }
        }
    } catch (Exception e) {
        System.out.println("Unavailable to move");
    }
}

  }

  // public static void main(String[] args) {
  //   House Ziskind = new House("Ziskind", "1 Henshaw Ave", 3, true, true, new ArrayList<residents>());
  // }
}
