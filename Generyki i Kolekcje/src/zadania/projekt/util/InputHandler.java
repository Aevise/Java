package zadania.projekt.util;

public class InputHandler {
    public String[] extractPersonalInformation(String info) throws RuntimeException {
        String[] rawData = info.split("_");
        String[] processedData = new String[3];
        if (rawData.length == 3) {
            for (int i = 0; i < 3; i++) {
                processedData[i] = processString(rawData[i]);
            }
            return processedData;
        }
        if (rawData.length == 2 && rawData[1].contains(",")) {
            processedData[0] = processString(rawData[0]);
            rawData = rawData[1].split(",");
            for (int i = 0; i < 2; i++) {
                if (rawData[i].toUpperCase().equals("VIP")) {
                    processedData[i + 1] = "VIP";
                } else {
                    processedData[i + 1] = processString(rawData[i]);
                }
            }
            return processedData;
        } else if (rawData.length == 2) {
            for (int i = 0; i < 2; i++) {
                processedData[i] = processString(rawData[i]);
            }
            return processedData;
        } else {
            throw new RuntimeException();
        }
    }

    private String processString(String data) {
        if (data.matches("[a-zA-Z]+")) {
            return data.substring(0, 1).toUpperCase() + data.substring(1).toLowerCase();
        } else if (data.matches("[0-9]+")) {
            return data;
        } else {
            return null;
        }
    }
}
