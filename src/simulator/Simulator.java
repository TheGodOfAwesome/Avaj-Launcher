package simulator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Simulator {

    public static void main(String[] args) {
        ArrayList<String> fileContents = new ArrayList<String>();
        if (args.length > 0) {
            System.out.println("Simulation Started");
            System.out.println(args[0] + "\n");
            try {
                BufferedReader in = new BufferedReader(new FileReader(new File(args[0])));
                String fileLineBuffer = "";
                int fileSize = 0;
                while((fileLineBuffer = in.readLine()) != null) {
                    fileContents.add(fileLineBuffer);
                    fileSize++;
                }
                int count = 0;
                for(String line : fileContents)
                    System.out.println(count++ + ". " + line);
            } catch (IOException e) {
                System.out.println("IO Exception: " + e);
            } finally {
                System.out.println("\nSimulation Completed");
            }
        } else {
            System.out.println("Please add the scenario file as an argument when running the application!");
        }
        return;
    }

}
