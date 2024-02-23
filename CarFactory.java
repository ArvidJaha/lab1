public class CarFactory {

    public static Car createScania(int x, int y){
        Scania car = new Scania();
        car.setxPos(x);
        car.setyPos(y);
        return car;
    }

    public static Volvo240 createVolvo(int x, int y){
        Volvo240 car = new Volvo240();
        car.setxPos(x);
        car.setyPos(y);
        return car;
    }
    public static Saab95 createSaab(int x, int y){
        Saab95 car = new Saab95();
        car.setxPos(x);
        car.setyPos(y);
        return car;
    }
    public static BilTransport createTransport(int x, int y){
        BilTransport car = new BilTransport();
        car.setxPos(x);
        car.setyPos(y);
        return car;
    }

}
