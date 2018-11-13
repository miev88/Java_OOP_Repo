// Methods declared inside interface are implicitly public.
// All variables declared in the interface are implicitly public static final (constants).


public interface SpaceShip {

    boolean launch(); /* was launch successful? */
    boolean land(); /* was landing successful? */
    boolean canCarry(Item item); /* can rocket carry such item */
    void carry(Item item); /* updates current weight of rocket */

}
