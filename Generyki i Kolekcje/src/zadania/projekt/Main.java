package zadania.projekt;

import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop(new PriorityQueue<>());
        Scanner scanner = new Scanner(System.in);
        String command = "";

        Pattern pattern = Pattern.compile("\\((.*?)\\)"); // znajduje wszystko w środku
        while (!command.equals("end")){
            command = scanner.nextLine().trim().toUpperCase();
            Matcher matcher = pattern.matcher(command);

            if(command.startsWith("ADD") && command.endsWith(")")){
                if(command.contains("PERSON(") && matcher.find()){
                    String personalInformation = matcher.group(1);
                    try{
                        String[] extractedInfo = extractPersonalInformation(personalInformation);
                        boolean isVip = extractedInfo[2] == "VIP";
                        shop.addPersonToQueue(new Osoba(extractedInfo[0], extractedInfo[1], isVip));
                    }catch (RuntimeException e){
                        System.out.println("Wrong input!");
                    }
                }
            }else if(command.startsWith("LEAVE")){
                if(command.contains("PERSON(") && matcher.find()){
                    String personalInformation = matcher.group(1);
                    shop.leaveQueue(personalInformation);
                }
            } else if (command.equals("PROCESS")) {
                shop.processQueue();
            }
            else {
                System.out.println("Wrong command!");
            }
            System.out.println(shop);
        }
    }

    private static String[] extractPersonalInformation(String info) throws RuntimeException{
        String[] rawData = info.split("_");
        String[] processedData = new String[3];
        if(rawData.length == 3){
            for(int i = 0 ; i < 3; i++){
                processedData[i] = processString(rawData[i]);
            }
            return processedData;
        }
        if(rawData.length == 2 && rawData[1].contains(",")){
            processedData[0] = processString(rawData[0]);
            rawData = rawData[1].split(",");
            for(int i = 0 ; i < 2; i++){
                if(rawData[i].toUpperCase().equals("VIP")){
                    processedData[i+1] = "VIP";
                }else{
                    processedData[i + 1] = processString(rawData[i]);
                }
            }
            return processedData;
        }
        else if (rawData.length == 2){
            for(int i = 0 ; i < 2; i++){
                processedData[i] = processString(rawData[i]);
            }
            return processedData;
        }else {
            throw new RuntimeException();
        }
    }

    private static String processString(String data){
        if(data.matches("[a-zA-Z]+")){
            return data.substring(0,1).toUpperCase() + data.substring(1).toLowerCase();
        }
        else if (data.matches("[0-9]+")){
            return data;
        }
        else {
            return null;
        }
    }
}
