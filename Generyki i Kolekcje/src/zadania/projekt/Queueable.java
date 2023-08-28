package zadania.projekt;

public interface Queueable {
    void processQueue();
    void leaveQueue(String person);
    void addPersonToQueue(Osoba osoba);
    void resortQueue();
}
