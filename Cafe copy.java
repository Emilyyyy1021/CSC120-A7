/* the Cafe class */
public class Cafe extends Building{

    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory

    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
    }
    
    /**
     * selling coffee
     * @param size size of coffee/ number of coffee in ouces
     * @param nSugarPackets number of sugar packets
     * @param nCreams number of creams
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        this.nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        System.out.println("Coffee: " + nCoffeeOunces + "\nSugar: " + nSugarPackets + "\nCream: " + nCreams);
    }

    /**
     * restocking
     * @param nCoffeeOunces number of Coffee in ounces
     * @param nSugarPackets number of Sugar Packets
     * @param nCreams number of creams
     * @param nCups number of cups
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += nCups;
        System.out.println("Coffee: " + nCoffeeOunces + "\nSugar: " + nSugarPackets + "\nCreams: " + nCreams + "\nCups: " + nCups);
    }

    public void showOptions() {
        super.showOptions();
    }

    public static void main(String[] args) {
        Cafe CC = new Cafe("CC", "100 Elm St", 3, 100, 50, 20, 30);
        CC.sellCoffee(5, 2, 1);
        CC.restock(100, 100, 100, 100);
    }
    
}
