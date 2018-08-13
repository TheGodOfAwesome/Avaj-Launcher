package simulator.aircraft;

import simulator.tower.WeatherTower;

public interface IFlyable {
    //public Coordinates getCoordinates();
    public void updateConditions();
    public	void registerTower(WeatherTower weatherTower);
}
