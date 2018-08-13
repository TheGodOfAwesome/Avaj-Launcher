package simulator.aircraft;

public class AircraftFactory {

    public IFlyable newAircraft(String type, String _name, int _longitude, int _latitude, int _height){
        Coordinates _coords = new Coordinates(_longitude, _latitude, _height);
        _coords.setLongitude(_longitude);
        _coords.setLatitude(_latitude);
        _coords.setHeight(_height);
        if (type.equals("Baloon")) {
            System.out.println("Baloon Column\nChose " + type + "\nName: "+ _name + "\nCoordinates:\n" + _coords.getLatitude() + "\n" + _coords.getLongitude() + "\nHeight:\n" + _coords.getHeight());
            return new Baloon(_name, _coords);
        }
        else if (type.equals("Helicopter"))
        {
            System.out.println("Helicopter Column\nChose " + type + "\nName: "+ _name + "\nCoordinates:\n" + _coords.getLatitude() + "\n" + _coords.getLongitude() + "\nHeight:\n" + _coords.getHeight());
            return new Helicopter(_name, _coords);
        }
        else if (type.equals("JetPlane")) {
            System.out.println("JetPlane Column\nChose " + type + "\nName: "+ _name + "\nCoordinates:\n" + _coords.getLatitude() + "\n" + _coords.getLongitude() + "\nHeight:\n" + _coords.getHeight());
            return new JetPlane(_name, _coords);
        }
        else {
            System.out.println("No Choice\n");
            return null;
        }
    }

}
