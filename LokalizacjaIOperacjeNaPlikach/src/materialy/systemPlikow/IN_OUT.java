package materialy.systemPlikow;

import java.io.File;

public class IN_OUT {
    public static void main(String[] args) {
        System.out.println(File.separator);
        System.out.println(System.getProperty("file.separator"));

        File file = new File("./src/pliki"); //klasa ta nie modyfikujemy plikow. Moze reprezentować pliki i katalogi
        System.out.println(file.exists());
        if (!file.exists()) {
            System.out.println("File: " + file + " not available");
        }

        System.out.println("file.getAbsolutePath(): " + file.getAbsolutePath());
        System.out.println("file.getAbsoluteFile(): " + file.getAbsoluteFile());
        System.out.println("file.getParent(): " + file.getParent());
        System.out.println("file.getParentFile(): " + file.getParentFile());

        if (file.isFile()) {
            System.out.println("File: " + file + " is File");
            System.out.println("File.length: " + file.length());
        }

        if (file.isDirectory()) {
            System.out.println("File: " + file + " is Directory");
            for (File listFile : file.listFiles()) {
                System.out.println("Subfile: " + listFile);
            }
        }


    }
}