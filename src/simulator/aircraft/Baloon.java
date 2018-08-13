package simulator.aircraft;

import simulator.PrintFile;
import simulator.tower.WeatherTower;

public class Baloon extends Aircraft implements IFlyable {
    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public	void updateConditions() {
        switch (weatherTower.getWeather(this.coords)) {
            case "SUN":
                coords.setLongitude(coords.getLongitude() + 2);
                coords.setHeight(coords.getHeight() + 4);
                if (coords.getHeight() > 100)
                    coords.setLongitude(100);
                PrintFile.addString(PrintFile.formatStringBaloon(this, "Baloon#" + this.name + "(" + this.id + "): ITS SO BRIGHT OUT!"));
                System.out.println("Baloon#" + this.name + "(" + this.id + "): ITS SO BRIGHT OUT");
                break;
            case "RAIN":
                coords.setHeight(coords.getHeight() - 5);
                PrintFile.addString(PrintFile.formatStringBaloon(this, "Baloon#" + this.name + "(" + id + "): THE RAINS ARE UPON US!!!"));
                System.out.println("Baloon#" + this.name + "(" + id + "): THE RAINS ARE UPON US!!!");
                break;
            case "FOG":
                coords.setHeight(coords.getHeight() - 2);
                PrintFile.addString(PrintFile.formatStringBaloon(this, "Baloon#" + this.name + "(" + this.id + "): THE FOG OF WAR IS UPON US!!!"));
                System.out.println("Baloon#" + this.name + "(" + this.id + "): THE FOG OF WAR IS UPON US!!!");
                break;
            case "SNOW":
                coords.setHeight(coords.getHeight() - 15);
                PrintFile.addString(PrintFile.formatStringBaloon(this, "Baloon#" + this.name + "(" + this.id + "): CAN YOU FEEL THE WINDS OF WINTER?!"));
                System.out.println("Baloon#" + this.name + "(" + this.id + "): CAN YOU FEEL THE WINDS OF WINTER?!");
                break;
            default:
                PrintFile.addString(PrintFile.formatStringBaloon(this, "Baloon#" + this.name + "(" + this.id + "): I CANT REACH THE WEATHER TOWER!"));
                System.out.println("Baloon#" + this.name + "(" + this.id + "): I CANT REACH THE WEATHER TOWER!");
                break;
        }
        if (this.coords.getHeight() <= 0){
            PrintFile.addString(PrintFile.formatStringBaloon(this, "Baloon#" + this.name + "(" + this.id + ") landed."));
            PrintFile.addString(PrintFile.formatStringBaloon(this, "Baloon#" + this.name + "(" + this.id + ") unregistered from weather tower."));
            System.out.println("Baloon#" + this.name + "(" + this.id + ") landed.");
            System.out.println("Baloon#" + this.name + "(" + this.id + ") unregistered from weather tower.");
            weatherTower.unregister(this);
        }
    }

    public	void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        PrintFile.addString(PrintFile.formatStringBaloon(this, "Tower says: Baloon#" + this.name + "(" + this.id + ")" + " registered to weather tower."));
        System.out.println("Tower says: Baloon#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
        weatherTower.register(this);
    }
}
