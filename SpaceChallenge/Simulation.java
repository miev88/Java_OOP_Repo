import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Simulation {

    /**
     * Read a text file containing items where each line has form "item name = item weight".
     * This method saves the name and weight of each line in an Item object which is then added to an ArrayList.
     *
     * @param file A text file
     * @return An ArrayList with Items as elements
     * @throws FileNotFoundException Exception is caught in main()
     */
    public ArrayList<Item> loadItems(File file) throws FileNotFoundException {
        ArrayList<Item> itemsList = new ArrayList<>();
        Scanner fileScanner = new Scanner(file);
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            String[] parts = line.split("=");
            Item item = new Item();
            item.name = parts[0];
            item.weight = Integer.parseInt(parts[1]);
            itemsList.add(item);
        }
        return itemsList;
    }

    /**
     * Load each rocket with items from the input list until the rocket cannot carry the next item.
     * Create a new rocket. Repeat from the beginning until all the items from the input list have been loaded.
     *
     * @param itemsList An ArrayList with Items as elements
     * @return An ArrayList with Rockets as elements
     */
    public ArrayList<Rocket> loadU1(ArrayList<Item> itemsList) {
        ArrayList<Rocket> rocketsList = new ArrayList<>();
        U1 tempRocket = new U1();
        for(Item item : itemsList) {
            if(tempRocket.canCarry(item)) {
                tempRocket.carry(item);
            } else {
                rocketsList.add(tempRocket);
                tempRocket = new U1();
                tempRocket.carry(item); // add item that didn't fit in previous rocket
            }
        }
        rocketsList.add(tempRocket); // add last rocket to list of rockets
        //for(int i=0; i<rocketsList.size(); i++) {
        //   System.out.println("final index " + i +": " + rocketsList.get(i).getCargoCarried());
        //}
        return rocketsList;
    }

    /**
     * See loadU1.
     *
     * @param itemsList An ArrayList with Items as elements
     * @return An ArrayList with Rockets as elements
     */
    public ArrayList<Rocket> loadU2(ArrayList<Item> itemsList) {
        ArrayList<Rocket> rocketsList = new ArrayList<>();
        U2 tempRocket = new U2();
        for(Item item : itemsList) {
            if(tempRocket.canCarry(item)) {
                tempRocket.carry(item);
            } else {
                rocketsList.add(tempRocket);
                tempRocket = new U2();
                tempRocket.carry(item); // add item that didn't fit in previous rocket
            }
        }
        rocketsList.add(tempRocket); // add last rocket to list of rockets
        //for(int i=0; i<rocketsList.size(); i++) {
        //    System.out.println("final index " + i +": " + rocketsList.get(i).getCargoCarried());
        //}
        return rocketsList;
    }

    /**
     * For each rocket from the input array, it simulates launching and landing.
     * Anytime a rocket explodes or crashes, the rocket is launched again.
     * Moreover, it keeps track of the total costs of the simulation (exploded/crashed rockets included).
     *
     * @param rocketsList An ArrayList with Rockets as elements
     * @return A double that represents the total cost of the simulation
     */
    public double runSimulation(ArrayList<Rocket> rocketsList) {
        double totalCost = 0.0;
        for(Rocket rocket : rocketsList) {
            totalCost += rocket.getCost();
            boolean failure = !( rocket.launch() && rocket.land() );
            //Every time a rocket explodes or crashes, send it again
            while(failure) {
                totalCost += rocket.getCost();
                failure = !( rocket.launch() && rocket.land() );
            }
        }
        return totalCost;
    }
}
