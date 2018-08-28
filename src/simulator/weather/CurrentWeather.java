package simulator.weather;

public class CurrentWeather {

    String currentWeather;

    public CurrentWeather(String currentWeather){
        setCurrentWeather(currentWeather);
    }

    public String getCurrentWeather(){ return currentWeather; }

    public String setCurrentWeather(String newCurrentWeather){
        currentWeather = newCurrentWeather;
        return currentWeather;
    }

}
