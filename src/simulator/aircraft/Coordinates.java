package simulator.aircraft;

public class Coordinates {

    int longitude;
    int latitude;
    int height;

    public Coordinates(int lon, int lat, int height){
        this.longitude  = lon;
        this.latitude   = lat;
        this.height     = height;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
