public class Logger {
    private static Logger instance;

    private Logger() {

    }

    // It is basic But not Thread Safe

    // public static Logger getInstance(){
    // if(instance==null)
    // instance = new Logger();
    // return instance;
    // }

    // It is Thread safe But not optimized because if 100 threads accessing this
    // then every thread need to be get the lock and check condition execute it

    // public static Logger getInstance() {

    // synchronized (Logger.class) {
    // if (instance == null)
    // instance = new Logger();
    // return instance;
    // }
    // }


    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null)
                    instance = new Logger();
            }
        }
        return instance;
    }

    public void log(String msg) {
        System.out.println(msg+".");
    }
}
