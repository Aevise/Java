package zadania.projekt;

import java.util.*;

public class Shop {
    private PriorityQueue<Osoba> queue;
    public Shop(PriorityQueue<Osoba> queue) {
        this.queue = queue;
    }
    private Map<Osoba, Integer> clientRegister = new HashMap<>();
    public void addPerson(Osoba osoba){
        try {
            this.queue.add(osoba);
        }catch (NullPointerException | ClassCastException  e2){
            System.out.println("Please provide correct information");
        }
        processClientRegister(osoba);
        System.out.println(osoba + " came to the queue.");
    }
    private void processClientRegister(Osoba osoba){
        System.out.println(this.clientRegister.containsKey(osoba));
         if(this.clientRegister.containsKey(osoba)){
            Integer currentID = clientRegister.get(osoba);
            osoba.setID(currentID + 1);
            clientRegister.put(osoba, osoba.getID());
        }else {
            osoba.setID(1);
            clientRegister.put(osoba, osoba.getID());
        }
    }
    public void processQueue(){
        if(queue.poll() == null){
            System.out.println("Queue is empty");
        }
    }
    public void leaveQueue(String name, String surname, Integer ID){
        Osoba osobaToRemove = new Osoba(name, surname);
        osobaToRemove.setID(ID);
        for (Osoba osoba : queue) {
            System.out.println("Now processing: " + osoba);
            if(osoba.equals(osobaToRemove) && osoba.getID().equals(ID)){
                queue.remove(osoba);
                System.out.println(osoba + " has left the Queue!");
                return;
            }
        }
        System.out.println(osobaToRemove + " was not found in the Queue");

    }


    @Override
    public String toString() {
        return "Shop{" +
                "queue=" + queue +
                '}';
    }
}
