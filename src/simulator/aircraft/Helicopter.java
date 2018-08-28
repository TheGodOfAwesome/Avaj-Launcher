package simulator.aircraft;

import simulator.PrintFile;
import simulator.tower.WeatherTower;
import simulator.weather.CurrentWeather;

import java.util.Random;

public class Helicopter extends Aircraft implements IFlyable {
    private WeatherTower weatherTower;
    private CurrentWeather currentWeather;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public	void updateConditions() {
        String weather = weatherTower.getWeather(this.coords);

        if (currentWeather != null && weather == currentWeather.getCurrentWeather()) {
            String[] weatherOptions = {"SUN", "RAIN", "FOG", "SNOW"};
            Random rand = new Random();
            while (weather == currentWeather.getCurrentWeather()) {
                int randomNum = rand.nextInt(3);
                weather = weatherOptions[randomNum];
            }
        }
        switch (weather) {
            case "SUN":
                this.coords.setLongitude(this.coords.getLongitude() + 10);
                this.coords.setHeight(this.coords.getHeight() + 2);
                if (this.coords.getHeight() > 100)
                    this.coords.setHeight(100);
                PrintFile.addString(PrintFile.formatStringHelicopter(this, "Helicopter#" + this.name + "(" + this.id + "): AHH ITS A BEAUTIFUL DAY!"));
                System.out.println("Helicopter#" + this.name + "(" + this.id + "): AHH ITS A BEAUTIFUL DAY!");
                currentWeather = new CurrentWeather("SUN");
                break;
            case "RAIN":
                this.coords.setLongitude(this.coords.getLongitude() + 5);
                PrintFile.addString(PrintFile.formatStringHelicopter(this, "Helicopter#" + this.name + "(" + this.id + "): ITS POURING! TURN ON THE WINDSHIELD WIPERS"));
                System.out.println("Helicopter#" + this.name + "(" + this.id + "): ITS POURING! TURN ON THE WINDSHIELD WIPERS");
                currentWeather = new CurrentWeather("RAIN");
                break;
            case "FOG":
                this.coords.setLongitude(this.coords.getLongitude() + 1);
                PrintFile.addString(PrintFile.formatStringHelicopter(this, "Helicopter#" + this.name + "(" + this.id + "): ITS FOGGING UP!"));
                System.out.println("Helicopter#" + this.name + "(" + this.id + "): ITS FOGGING UP!");
                currentWeather = new CurrentWeather("FOG");
                break;
            case "SNOW":
                this.coords.setHeight(this.coords.getHeight() - 12);
                PrintFile.addString(PrintFile.formatStringHelicopter(this, "Helicopter#" + this.name + "(" + this.id + "): WE ARE GOING TO HAVE A WHITE CHRISTMAS!"));
                System.out.println("Helicopter#" + this.name + "(" + this.id + "): WE ARE GOING TO HAVE A WHITE CHRISTMAS!");
                currentWeather = new CurrentWeather("SNOW");
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