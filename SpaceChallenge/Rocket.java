/**
 * Rocket class implements the SpaceShip interface.
 * Classes U1 and U2 extend this class.
 */
public class Rocket implements SpaceShip {

    private double cost;
    private int cargoCarried;
    private int cargoLimit;

    Rocket(double cost, int weight, int maxWeight) {
        this.cost = cost;
        this.cargoCarried = 0;
        this.cargoLimit = maxWeight - weight;
    }

    double getCost() {
        return cost;
    }

    int getCargoCarried() {
        return cargoCarried;
    }

    int getCargoLimit() {
        return cargoLimit;
    }

    public boolean launch() {
        return true;
    }

    public boolean land() {
        return true;
    }

    /**
     * Check if the rocket can carry the weight of such item.
     *
     * @param item the item considered to be added to the rocket
     * @returntrue if the rocket can carry the item, false otherwise
     */
    public final boolean canCarry(Item item) {
        return (this.cargoCarried + item.weight) <= this.cargoLimit;
    }

    /**
     * Add item weight to the cargo weight.
     *
     * @param item the item to be added to the rocket
     */
    public final void carry(Item item) {
        this.cargoCarried += item.weight;
    }

}
