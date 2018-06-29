package simulator.tower;

import simulator.Flyable;
import java.util.Observer;

public class Tower implements Observer {

    public Tower(){
    }

    public void register(Flyable flyable){
        return;
    }

    public void unregister(Flyable flyable){
        return;
    }

    public void conditionsChanged(){
        return;
    }

    @Override
    public void update(java.util.Observable o, Object arg) {

    }
}