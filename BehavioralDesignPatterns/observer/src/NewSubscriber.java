import java.util.Objects;

public class NewSubscriber implements Observer {
    private final String username;

    @Override
    public void update(String message) {
        if(Objects.isNull(message)){
            System.out.printf("%s message null%n", username);
        }else {
            System.out.printf("%s message: %s%n", username, message);
        }
    }

    public NewSubscriber(String username) {
        this.username = username;
    }
}
