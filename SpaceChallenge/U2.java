public class U2 extends Rocket {

    U2() {
        super(1.2e8, 18000, 29000);
    }

    @Override
    public boolean launch() {
        double chanceLaunchExplosion = 0.04 * getCargoCarried() / getCargoLimit();
        return chanceLaunchExplosion < Math.random();
    }

    @Override
    public boolean land() {
        double chanceLandingCrash = 0.08 * getCargoCarried() / getCargoLimit();
        return chanceLandingCrash < Math.random();
    }
}
