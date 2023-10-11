package singleton_design_pattern;

class SingletonEagar {
    //create new instance of SingletonEager
    private static SingletonEagar instance = new SingletonEagar();

    //empty constructor
    private SingletonEagar() {

    }

    //getter method
    public static SingletonEagar getInstance() {
        return instance;
    }
}

class Singleton {
    private static Singleton instance;

    //empty constructor
    private Singleton() {

    }

    //getter with if case
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

class SingletonSynchronizedMethod {
    private static SingletonSynchronizedMethod instance;

    //private constructor
    private SingletonSynchronizedMethod() {

    }

    //getter method
    public static synchronized SingletonSynchronizedMethod getInstance() {
        if (instance == null) {
            instance = new SingletonSynchronizedMethod();
        }
        return instance;
    }
}

class SingletonSynchronized {
    private static SingletonSynchronized instance;

    //empty constructor
    private SingletonSynchronized() {

    }

    //getter with if case
    public static SingletonSynchronized getInstance() {
        if (instance == null) {
            synchronized (SingletonSynchronized.class) {
                if (instance == null) {
                    instance = new SingletonSynchronized();
                }
            }
        }
        return instance;
    }
}

public class SingletonPattern {
    public static void main(String[] args) {
        //printout instances
        SingletonSynchronized instance = SingletonSynchronized.getInstance();
        System.out.println(instance);
        SingletonSynchronized instance1 = SingletonSynchronized.getInstance();
        System.out.println(instance1);
    }
}