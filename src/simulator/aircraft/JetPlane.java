package simulator.aircraft;

import simulator.PrintFile;
import simulator.Simulator;
import simulator.tower.WeatherTower;
import simulator.weather.CurrentWeather;

import java.util.Random;

public class JetPlane extends Aircraft implements IFlyable {
    private WeatherTower weatherTower;
    private CurrentWeather currentWeather;

    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void	updateConditions() {
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
                this.coords.setLatitude(this.coords.getLatitude() + 10);
                this.coords.setHeight(this.coords.getHeight() + 2);
                if (this.coords.getHeight() > 100)
                    this.coords.setHeight(100);
                PrintFile.addString(PrintFile.formatStringJetPlane(this, "JetPlane#" + this.name + "(" + this.id + "): SUN IS SHINING!"));
                System.out.println("JetPlane#" + this.name + "(" + this.id + "): SUN IS SHINING!");
                currentWeather = new CurrentWeather("SUN");
                break;
            case "RAIN":
                this.coords.setLatitude(this.coords.getLatitude() + 5);
                PrintFile.addString(PrintFile.formatStringJetPlane(this, "JetPlane#" + this.name + "(" + this.id + "): SINGING IN THE RAIN!"));
                System.out.println("JetPlane#" + this.name + "(" + this.id + "): SINGING IN THE RAIN!");
                currentWeather = new CurrentWeather("RAIN");
                break;
            case "FOG":
                this.coords.setLatitude(this.coords.getLatitude() + 1);
                PrintFile.addString(PrintFile.formatStringJetPlane(this, "JetPlane#" + this.name + "(" + this.id + "): WE SHOULD GET A FOG HORN!"));
                System.out.println("JetPlane#" + this.name + "(" + this.id + "): WE SHOULD GET A FOG HORN!");
                currentWeather = new CurrentWeather("FOG");
                break;
            case "SNOW":
                this.coords.setHeight(this.coords.getHeight() - 12);
                PrintFile.addString(PrintFile.formatStringJetPlane(this, "JetPlane#" + this.name + "(" + this.id + "): SNOW FALL!"));
                System.out.println("JetPlane#" + this.name + "(" + this.id + "): SNOW FALL!");
                currentWeather = new CurrentWeather("SNOW");
                break;
            default:
                PrintFile.addString(PrintFile.formatStringJetPlane(this, "JetPlane#" + this.name + "(" + this.id + "): I CANT REACH THE WEATHER TOWER!"));
                System.out.println("JetPlane#" + this.name + "(" + this.id + "): I CANT REACH THE WEATHER TOWER!");
                break;
        }
        if (this.coords.getHeight() <= 0) {
            PrintFile.addString(PrintFile.formatStringJetPlane(this, "Helicopter#" + this.name + "(" + this.id + ") LANDED."));
            PrintFile.addString(PrintFile.formatStringJetPlane(this, "Helicopter#" + this.name + "(" + this.id + ") UNREGISTERED FROM WEATHER TOWER."));
            System.out.println("Helicopter#" + this.name + "(" + this.id + ") LANDED.");
            System.out.println("Helicopter#" + this.name + "(" + this.id + ") UNREGISTERED FROM WEATHER TOWER.");
            weatherTower.unregister(this);
        }
    }

    public	void	registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        PrintFile.addString(PrintFile.formatStringJetPlane(this, "Tower says: JetPlane#" + this.name + "(" + this.id + ")" + " registered to weather tower."));
        System.out.println("Tower says: JetPlane#" + this.name + "(" + this.id + ")" + " registered to weather tower.");
        this.weatherTower.register(this);
    }

}
