package simulator.aircraft;

interface IAircraft{
    public static final String Baloon = "Baloon";
    public static final String Helicopter = "Helicopter";
    public static final String JetPlane = "JetPlane";

    public long nextId();
}

public class Aircraft implements IAircraft{

    long        id;
    String      name;
    Coordinates coords;
    long        idCounter;

    public Aircraft(long _id, String _name, Coordinates _coords, long _idCounter){
        this.id         = _id;
        this.name       = _name;
        this.coords     = _coords;
        this.idCounter  = _idCounter;
    }

    public long nextId(){
        return 0;
    }

}
