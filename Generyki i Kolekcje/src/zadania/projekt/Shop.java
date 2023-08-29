package zadania.projekt;

import zadania.projekt.util.InputHandler;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Shop {
    private QueueToShop queue;
    private final InputHandler inputHandler = new InputHandler();

    public Shop() {
        this.queue = new QueueToShop();
    }

    public void openShop() {
        Scanner scanner = new Scanner(System.in);
        String command = "";

        Pattern pattern = Pattern.compile("\\((.*?)\\)"); // znajduje wszystko w środku
        while (!command.equals("end")) {
            command = scanner.nextLine().trim().toUpperCase();
            Matcher matcher = pattern.matcher(command);

            if (command.startsWith("ADD") && command.endsWith(")")) {
                if (command.contains("PERSON(") && matcher.find()) {
                    String personalInformation = matcher.group(1);
                    try {
                        String[] extractedInfo = inputHandler.extractPersonalInformation(personalInformation);
                        boolean isVip = extractedInfo[2] == "VIP";
                        queue.addPersonToQueue(new Osoba(extractedInfo[0], extractedInfo[1], isVip));
                    } catch (RuntimeException e) {
                        System.out.println("Wrong input!");
                    }
                }
            } else if (command.startsWith("LEAVE")) {
                if (command.contains("PERSON(") && matcher.find()) {
                    String personalInformation = matcher.group(1);
                    queue.leaveQueue(personalInformation);
                }
            } else if (command.equals("PROCESS")) {
                queue.processQueue();
            } else {
                System.out.println("Wrong command!");
            }
            System.out.println(queue);
        }
    }
}
