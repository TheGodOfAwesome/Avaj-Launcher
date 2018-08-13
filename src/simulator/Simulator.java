package simulator;

import simulator.aircraft.AircraftFactory;
import simulator.aircraft.IFlyable;
import simulator.tower.Tower;
import simulator.tower.WeatherTower;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Simulator {

    public static void main(String[] args) {
        int simCount = 0;
        int count = 0;
        ArrayList<String> fileContents = new ArrayList<String>();
        if (args.length == 1) {
            WeatherTower weatherTower = new WeatherTower();
            Tower tower = new Tower();
            IFlyable flyable;
            List<IFlyable> flyables = new ArrayList<IFlyable>();
            AircraftFactory factory = new AircraftFactory();

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
                for(String line : fileContents) {
                    System.out.println(line);
                    if (line != null) {
                        if (count == 0) {
                            simCount = Integer.parseInt(line.split(" ")[0]);
                            if (simCount < 0) {
                                System.out.println("Invalid Count: " + simCount);
                                System.exit(1);
                            }
                        }else{
                            System.out.println("SimCount: " + simCount);
                            flyable = factory.newAircraft(line.split(" ")[0], line.split(" ")[1],
                                    Integer.parseInt(line.split(" ")[2]), Integer.parseInt(line.split(" ")[3]),
                                    Integer.parseInt(line.split(" ")[4]));
                            flyable.registerTower(weatherTower);
                            tower.register(flyable);
                            if (flyable != null)
                                flyables.add(flyable);
                        }
                    }
                    count++;
                }
                for (int i = 0; i < simCount; i++) {
                    weatherTower.changeWeather();
                }
                PrintFile.printInTxt();
            } catch (IOException e) {
                System.out.println("IO Exception: " + e);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Specify simulation file");
            } catch (NullPointerException e) {
                System.out.println("value is null");
            } catch (NumberFormatException e) {
                System.out.println("not a valid number entered in file");
            } finally {
                System.out.println("\nSimulation Completed");
            }
        } else {
            System.out.println("Please add the scenario file as an argument when running the application!");
        }
        return;
    }

}
