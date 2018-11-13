import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;


public class Main {

    public static void main(String [] args) {

        try {
            //Create simulation
            Simulation simulation = new Simulation();

            //Load items for phase-1 and phase-2
            ArrayList<Item> listOne = simulation.loadItems(new File("src/phase-1.txt"));
            ArrayList<Item> listTwo = simulation.loadItems(new File("src/phase-2.txt"));

            //Load a fleet of U1 rockets for phase-1 and then for phase-2
            ArrayList<Rocket> fleetU1PhaseOne = simulation.loadU1(listOne);
            ArrayList<Rocket> fleetU1PhaseTwo = simulation.loadU1(listTwo);

            //Run simulation for U1 fleet
            ArrayList<Rocket> fleetU1 = new ArrayList<>();
            fleetU1.addAll(fleetU1PhaseOne);
            fleetU1.addAll(fleetU1PhaseTwo);
            System.out.println("Rockets in U1 fleet: " + fleetU1.size());
            double totalCostU1 = simulation.runSimulation(fleetU1);
            System.out.println("Total budget required for U1 fleet: " + totalCostU1);

            //Load a fleet of U2 rockets for phase-1 and then for phase-2
            ArrayList<Rocket> fleetU2PhaseOne = simulation.loadU2(listOne);
            ArrayList<Rocket> fleetU2PhaseTwo = simulation.loadU2(listTwo);

            //Run simulation for U2 fleet
            ArrayList<Rocket> fleetU2 = new ArrayList<>();
            fleetU2.addAll(fleetU2PhaseOne);
            fleetU2.addAll(fleetU2PhaseTwo);
            System.out.println("Rockets in U2 fleet: " + fleetU2.size());
            double totalCostU2 = simulation.runSimulation(fleetU2);
            System.out.println("Total budget required for U2 fleet: " + totalCostU2);

        } catch (FileNotFoundException e) {
            System.out.println("Files could not be found!");
        }
    }
}
