package problem02;

public class Singleton04 {
    private static Singleton04 singleton04 = new Singleton04();
    private Singleton04(){

    }

    public static Singleton04 getInstance(){
        return singleton04;
    }
}
