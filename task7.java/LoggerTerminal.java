package task7.java;

public class LoggerTerminal implements LoggerAble {

    @Override
    public void logg(String msg) {
        System.out.println(LocalDateTime.now() + msg);
    }

}

