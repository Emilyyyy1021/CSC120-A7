/* the Library class */

import java.util.Hashtable;
import java.util.Map;

public class Library extends Building {

    private Hashtable<String, Boolean> collection;
    private boolean hasElevator;

    public Library(String name, String address, int nFloors, Boolean hasElevator, Hashtable<String, Boolean> collection) {
        super(name, address, nFloors);
        this.collection = collection;
        this.hasElevator = hasElevator;
    }

    /**
     * adding a book
     * @param title title of book 
     */
    public void addTitle(String title) {
    if (containsTitle(title) == false){
      this.collection.put(title, true);
    }
  }

  /** 
   * remove a book
   * @param title title of the book
   * @return the title of the book
   */
  public String removeTitle(String title) {
    if (containsTitle(title) == true) {
        this.collection.remove(title);
        return title;
      } else {
        return title + "not found";
      }
  }

  /**
   * checkout the book 
   * @param title title of book
   */
  public void checkOut(String title){
    if (isAvailable(title) == true) {
      this.collection.replace(title, false);
    }
  }

  /**
   * return the book
   * @param title title of book
   */
  public void returnBook(String title){
    if (isAvailable(title) == false) {
      this.collection.replace(title, true);
    } 
  }
  /**
   * the title appears as a key in the Libary's collection
   * @param title title of book
   * @return T/F the title appears as a key in the Libary's collection
   */
  public boolean containsTitle(String title){
    return this.collection.containsKey(title);
  }

  /**
   * the title is currently available
   * @param title title of book 
   * @return T/F the title is currently available
   */
  public boolean isAvailable(String title){
    return this.collection.containsValue(true);
  }

  /**
   * print the entire collection (including checkout status)
   */
  public void printCollection(){
    for (Map.Entry<String, Boolean> entry : this.collection.entrySet()) {
    String key = entry.getKey();
    Boolean value = entry.getValue();

    System.out.println ("Key: " + key + " Value: " + value);
    }
  }

  /* show the options */
  @Override
  public void showOptions() {
    System.out.println("Available options at " + this.name + ":\n + addTitle() \n + checkout() \n + returnBook() \n + printCollection()\n + goToFloor(n)");
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

  /**
     * Checkout the book with a specified user ID
     * @param title title of book
     * @param studentID ID of the student
     */
    public void checkOut(String title, String studentID){
      if (isAvailable(title) == true) {
          this.collection.replace(title, false);
          System.out.println("Book '" + title + "' checked out by user with ID: " + studentID);
      } else {
          System.out.println("Book '" + title + "' is not available for checkout.");
      }
  }

  /**
   * Return the book with a specified user ID
   * @param title title of book
   * @param studentID ID of the smith student 
   */
  public void returnBook(String title, String studentID){
      if (!isAvailable(title)) {
          this.collection.replace(title, true);
          System.out.println("Book '" + title + "' returned by user with ID: " + studentID);
      } else {
          System.out.println("Book '" + title + "' is already returned.");
      }
  }
}