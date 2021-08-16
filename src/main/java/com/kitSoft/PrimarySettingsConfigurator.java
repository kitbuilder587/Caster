package com.kitSoft;

import java.io.File;
import java.net.URL;
import java.util.Scanner;

public class PrimarySettingsConfigurator {

    public static int editorTextSize = 12;

    public static void readConfigFile() throws Exception {
        URL properties = PrimarySettingsConfigurator.class.getClassLoader().getResource("config.prop");
        Scanner scanner = new Scanner(new File(properties.getPath()));
        while(scanner.hasNextLine()){
            String[] line = scanner.nextLine().split("=");
            if(line.length != 2) continue;
            if(line[0].equals("editorTextSize")){
                try{
                    editorTextSize = Integer.parseInt(line[1]);

                }catch (NumberFormatException exception){
                    throw new Exception("Wrong config");
                }
            }
        }
    }
}
