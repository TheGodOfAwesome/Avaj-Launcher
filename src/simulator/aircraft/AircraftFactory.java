package simulator.aircraft;

public class AircraftFactory {

    public static Aircraft newAircraft(String type, long _id, String _name, Coordinates _coords, long _idCounter){
        if (type.equals(Aircraft.Baloon))
            return new Baloon(_id, _name, _coords, _idCounter);
        else if (type.equals(Aircraft.Helicopter))
            return new Helicopter(_id, _name, _coords, _idCounter);
        else if (type.equals(Aircraft.JetPlane))
            return new JetPlane(_id, _name, _coords, _idCounter);
        else
            return null;
    }

}
