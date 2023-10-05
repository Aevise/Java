import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class NewsTopic implements Subject{

    private final List<Observer> observerList = new ArrayList<>();
    @Override
    public void register(Observer observer) {
        if(Objects.isNull(observer)){
            throw new NullPointerException("Observer is null");
        }
        if(!observerList.contains(observer)){
            observerList.add(observer);
        }
    }

    @Override
    public void unregister(Observer observer) {
        observerList.remove(observer);
    }

    public void setNews(String message){
        System.out.printf("message posted: %s%n", message);
        for (Observer observer : observerList) {
            observer.update(message);
        }
    }
}
