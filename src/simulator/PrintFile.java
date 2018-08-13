package simulator;

import simulator.aircraft.Baloon;
import simulator.aircraft.Helicopter;
import simulator.aircraft.JetPlane;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class PrintFile {
    public static List<String> strings = new ArrayList<String>();

    public static String formatStringTowerBaloon(Baloon flyable, String message) {
        return ("Tower says: " + flyable.getClass().getTypeName() + "#" + flyable.getClass().getName() + "(" + "1" + ") " + message);
    }

    public static String formatStringTowerJetPlane(JetPlane flyable, String message) {
        return ("Tower says: " + flyable.getClass().getTypeName() + "#" + flyable.getClass().getName() + "(" + "1" + ") " + message);
    }

    public static String formatStringTowerHelicopter(Helicopter flyable, String message) {
        return ("Tower says: " + flyable.getClass().getTypeName() + "#" + flyable.getClass().getName() + "(" + "1" + ") " + message);
    }

    public static String formatStringBaloon(Baloon flyable, String message) {
        return (message);
    }

    public static String formatStringJetPlane(JetPlane flyable, String message) {
        return (message);
    }

    public static String formatStringHelicopter(Helicopter flyable, String message) {
        return (message);
    }

    public static void addString(String newString) {
        strings.add(newString);
    }

    public static void printInTxt() {
        try {
            PrintWriter writer = new PrintWriter("simulation.txt", "UTF-8");
            for (int i = 0; i < strings.size(); i++) {
                writer.println(strings.get(i));
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
