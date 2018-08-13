package simulator.aircraft;

public class Coordinates {

    private int longitude;
    private int latitude;
    private int height;

    Coordinates(int lon, int lat, int height){
        this.longitude  = lon;
        this.latitude   = lat;
        this.height     = height;
    }

    public int getLongitude() {
        return this.longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public int getLatitude() {
        return this.latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

}
