
package soccer.event;

/**
 *
 * @author RYZEN
 */
public class Shoot extends GameEvent {

    public Shoot() {
    }

    @Override
    public String toString() {
        return "Disparo a Porteria ";
    }

    
    
    
    @Override
    public GameEvent[] getNextEvents() {
        GameEvent theEvent[] = {new Goal(), new KickOut()};
        return theEvent;
    }

    @Override
    public boolean changePlayer() {
        return false;
    }

    @Override
    public boolean changeTeam() {
       return false;
    }
    
}
