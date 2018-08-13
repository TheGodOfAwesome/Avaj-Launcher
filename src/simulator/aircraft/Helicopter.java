package simulator.aircraft;

import simulator.PrintFile;
import simulator.tower.WeatherTower;

public class Helicopter extends Aircraft implements IFlyable {
    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public	void updateConditions() {
        String weather = weatherTower.getWeather(this.coords);
        switch (weather) {
            case "SUN":
                this.coords.setLongitude(this.coords.getLongitude() + 10);
                this.coords.setHeight(this.coords.getHeight() + 2);
                if (this.coords.getHeight() > 100)
                    this.coords.setHeight(100);
                PrintFile.addString(PrintFile.formatStringHelicopter(this, "Helicopter#" + this.name + "(" + this.id + "): AHH ITS A BEAUTIFUL DAY!"));
                System.out.println("Helicopter#" + this.name + "(" + this.id + "): AHH ITS A BEAUTIFUL DAY!");
                break;
            case "RAIN":
                this.coords.setLongitude(this.coords.getLongitude() + 5);
                PrintFile.addString(PrintFile.formatStringHelicopter(this, "Helicopter#" + this.name + "(" + this.id + "): ITS POURING! TURN ON THE WINDSHIELD WIPERS"));
                System.out.println("Helicopter#" + this.name + "(" + this.id + "): ITS POURING! TURN ON THE WINDSHIELD WIPERS");
                break;
            case "FOG":
                this.coords.setLongitude(this.coords.getLongitude() + 1);
                PrintFile.addString(PrintFile.formatStringHelicopter(this, "Helicopter#" + this.name + "(" + this.id + "): ITS FOGGING UP!"));
                System.out.println("Helicopter#" + this.name + "(" + this.id + "): ITS FOGGING UP!");
                break;
            case "SNOW":
                this.coords.setHeight(this.coords.getHeight() - 12);
                PrintFile.addString(PrintFile.formatStringHelicopter(this, "Helicopter#" + this.name + "(" + this.id + "): WE ARE GOING TO HAVE A WHITE CHRISTMAS!"));
                System.out.println("Helicopter#" + this.name + "(" + this.id + "): WE ARE GOING TO HAVE A WHITE CHRISTMAS!");
                break;
            default:
                PrintFile.addString(PrintFile.formatStringHelicopter(this, "Helicopter#" + this.name + "(" + this.id + "): I CANT REACH THE WEATHER TOWER!"));
                System.out.println("Helicopter#" + this.name + "(" + this.id + "): I CANT REACH THE WEATHER TOWER!");
                break;
        }
        if (this.coords.getHeight() <= 0) {
            PrintFile.addString(PrintFile.formatStringHelicopter(this, "Helicopter#" + this.name + "(" + this.id + ") LANDED."));
            PrintFile.addString(PrintFile.formatStringHelicopter(this, "Helicopter#" + this.name + "(" + this.id + ") UNREGISTERED FROM WEATHER TOWER."));
            System.out.println("Helicopter#" + this.name + "(" + this.id + ") LANDED.");
            System.out.println("Helicopter#" + this.name + "(" + this.id + ") UNREGISTERED FROM WEATHER TOWER.");
            weatherTower.unregister(this);
        }
    }

    public	void	registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        PrintFile.addString(PrintFile.formatStringHelicopter( this, "Tower says: Helicopter#" + this.name + "(" + this.id + ")" + " registered to weather tower."));
        System.out.println("Tower says: Helicopter#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
        weatherTower.register(this);
    }

}