public class U1 extends Rocket {

    U1() {
        super(1e8, 10000, 18000);
    }

    @Override
    public boolean launch() {
        double chanceLaunchExplosion = 0.05 * getCargoCarried() / getCargoLimit();
        return chanceLaunchExplosion < Math.random();
    }

    @Override
    public boolean land() {
        double chanceLandingCrash = 0.01 * getCargoCarried() / getCargoLimit();
        return chanceLandingCrash < Math.random();
    }
}
