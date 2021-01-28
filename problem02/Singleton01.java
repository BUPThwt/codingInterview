package problem02;


// 双检锁
public class Singleton01 {

    private static volatile Singleton01 singleton01;
    private Singleton01(){
    }

    public static Singleton01 getInstance(){
        if(singleton01 == null){
            synchronized(Singleton01.class){
                if(singleton01 == null){
                    singleton01 = new Singleton01();
                }
            }
        }
        return singleton01;
    }
}
