package zadania.projekt;

import java.util.PriorityQueue;

public class QueueToShop implements Queueable {
    private PriorityQueue<Osoba> queue = new PriorityQueue<>();

    @Override
    public void addPersonToQueue(Osoba osoba) {
        boolean checkName = osoba.getName() == null || osoba.getName().equals("null");
        boolean checkSurname = osoba.getSurname() == null || osoba.getSurname().equals("null");
        try {
            if (checkName || checkSurname) {
                throw new NullPointerException();
            }
            this.queue.add(osoba);
        } catch (NullPointerException | ClassCastException e2) {
            System.out.println("Please provide correct information.");
            return;
        }
        System.out.println(osoba + " arrived at the queue.");
        resortQueue();
    }

    @Override
    public void processQueue() {
        Osoba personLeaving = queue.poll();
        if (personLeaving == null) {
            System.out.println("Queue is empty. Take some rest!");
            return;
        }
        System.out.println(personLeaving + " please come to the store!");
    }

    @Override
    public void leaveQueue(String person) {
        String[] parts = person.split("_");
        if (parts.length < 3) {
            System.out.println("Incorrect input.");
            return;
        }
        String name = parts[0].substring(0, 1).toUpperCase() + parts[0].substring(1).toLowerCase();
        String surname = parts[1].substring(0, 1).toUpperCase() + parts[1].substring(1).toLowerCase();
        Osoba osobaToRemove = new Osoba(name, surname);
        try {
            int ID = Integer.parseInt(parts[2]);
            osobaToRemove.setID(ID);
        } catch (NumberFormatException ignored) {
        }
        for (Osoba osoba : queue) {
            if (osoba.equals(osobaToRemove)) {
                queue.remove(osoba);
                System.out.println(osoba + " has left the Queue!");
                resortQueue();
                return;
            }
        }
        System.out.println(osobaToRemove + " was not found in the Queue");
    }

    public void addExistingQueue(PriorityQueue<Osoba> queue) {
        if (this.queue.isEmpty()) {
            this.queue = new PriorityQueue<>(queue);
        } else {
            this.queue.addAll(queue);
        }
        resortQueue();
    }

    @Override
    public void resortQueue() {
        this.queue = new PriorityQueue<>(this.queue);
    }

    @Override
    public String toString() {
        PriorityQueue<Osoba> resortQueue = new PriorityQueue<>(this.queue);
        return "Queue: " + resortQueue;
    }
}
