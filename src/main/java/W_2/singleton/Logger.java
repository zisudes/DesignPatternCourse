package W_2.singleton;

public class Logger {
    String fileName;
    String log;

    static Logger instance;

    private Logger(){
        this.fileName = "Logger.txt";
        this.log = "";
    }

    public static Logger getInstance(){
        if (instance == null){
            instance = new Logger();
        }
        return instance;
    }

    public void setFileName(String s){
        this.fileName = s;
    }

    public void write(String s){
        this.log += s + "\n";
    }

    public void close(){
        this.log = "";
    }

    public void show(){
        String spacer = "=".repeat(this.fileName.length());
        System.out.printf("%s\n%s\n%s\n%s\n", spacer, this.fileName, spacer, this.log);
    }
}