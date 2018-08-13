package simulator.tower;

import simulator.PrintFile;
import simulator.aircraft.Baloon;
import simulator.aircraft.IFlyable;
import simulator.aircraft.Helicopter;
import simulator.aircraft.JetPlane;

import java.util.ArrayList;
import java.util.List;

public class Tower {
    private static List<IFlyable> observers = new ArrayList<IFlyable>();

    public void register(IFlyable flyable) {
        observers.add(flyable);
        switch (flyable.getClass().getName()) {
            case "Baloon": {
                Baloon baloon = Baloon.class.cast(flyable);
                PrintFile.addString(PrintFile.formatStringTowerBaloon(baloon, "registered to weather tower."));
                System.out.println(flyable.getClass().getName() + " registered to weather tower.");
                break;
            }
            case "JetPlane": {
                JetPlane jetPlane = JetPlane.class.cast(flyable);
                PrintFile.addString(PrintFile.formatStringTowerJetPlane(jetPlane, "registered to weather tower."));
                System.out.println(flyable.getClass().getName() + " registered to weather tower.");
                break;
            }
            case "Helicopter": {
                Helicopter helicopter = Helicopter.class.cast(flyable);
                PrintFile.addString(PrintFile.formatStringTowerHelicopter(helicopter, "registered to weather tower."));
                System.out.println(flyable.getClass().getName() + " registered to weather tower.");
                break;
            }
        }
    }

    public void unregister(IFlyable flyable) {
        observers.remove(flyable);
        switch (flyable.getClass().getName()) {
            case "Baloon": {
                Baloon baloon = Baloon.class.cast(flyable);
                PrintFile.addString(PrintFile.formatStringTowerBaloon(baloon, "Tower says: Baloon#" + flyable.getClass().getName() + "(" + "id" + ")" + " unregistered to weather tower."));
                System.out.println(flyable.getClass().getName() + " unregistered to weather tower.");
                break;
            }
            case "JetPlane": {
                JetPlane jetPlane = JetPlane.class.cast(flyable);
                PrintFile.addString(PrintFile.formatStringTowerJetPlane(jetPlane, "unregistered to weather tower."));
                System.out.println(flyable.getClass().getName() + " unregistered to weather tower.");
                break;
            }
            case "Helicopter": {
                Helicopter helicopter = Helicopter.class.cast(flyable);
                PrintFile.addString(PrintFile.formatStringTowerHelicopter(helicopter, "unregistered to weather tower."));
                System.out.println(flyable.getClass().getName() + " unregistered to weather tower.");
                break;
            }
        }
    }

    protected void conditionsChanged() {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).updateConditions();
        }
    }
}