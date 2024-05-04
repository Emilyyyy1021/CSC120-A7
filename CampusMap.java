import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Sage Hall", "144 Green St, Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Burton Hall", "46 College Ln, Northampton, MA 01063", 4));
        myMap.addBuilding(new Library("Neilson", "7 Neilson Drive, Northampton, MA 01063", 4, true, colletion));
        myMap.addBuilding(new Library("Josten Performing Arts Library", " Mendenhall Center, 122 Green St, Northampton, MA 01063", 1, false, collection));
        myMap.addBuilding(new Library("Hillyer Art Library","20 Elm St, Northampton, MA 01063", 2, false, collection));
        myMap.addBuilding(new House("Ziskind", "1 Henshaw Ave, Northampton, MA 010603", 4, true, true, residents));
        myMap.addBuilding(new House("Cutter", "10 Prospect St, Northampton, MA 010603", 4, true, true, residents));
        myMap.addBuilding(new House("King", "180 Elm St, Northampton, MA 01063", 3, true, false, residents));
        myMap.addBuilding(new Cafe("Campus Center Cafe", "100 Elm St, Northampton, MA 01063", 1, 20, 20, 20, 20));
        myMap.addBuilding(new Cafe("Compass Cafe", "7 Neilson Drive, Northampton, MA 01063", 1, 10, 10, 10, 10));
        System.out.println(myMap);
    }
    
}
