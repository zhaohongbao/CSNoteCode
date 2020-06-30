package mycode.javaguide.part1;

//出处：v3.0-JavaGuide面试突击版
public class Singleton {
    private volatile static Singleton uniqueInstance;

    private Singleton(){
    }

    public synchronized static Singleton getUniqueInstance(){
        //先判断对象是否已经实例过，没有实例化过才进入加锁代码
        if(uniqueInstance == null){
            //类对象加锁
            synchronized (Singleton.class){
                if(uniqueInstance == null){
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }

}
