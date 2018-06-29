package simulator.aircraft;

import simulator.tower.WeatherTower;

public class JetPlane extends Aircraft {

    public JetPlane(long _id, String _name, Coordinates _coords, long _idCounter){
        super(_id, _name, _coords, _idCounter);
    }

    public void updateConditions(){
        return;
    }

    public void registerTower(WeatherTower weatherTower){
        return;
    }
}
