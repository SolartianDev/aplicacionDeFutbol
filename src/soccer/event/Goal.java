
package soccer.event;

/**
 *
 * @author RYZEN
 */
public class Goal extends GameEvent {

    public Goal() {
    }

    @Override
    public String toString() {
        return "Gooooooool! ";
    }

    
    public void setBallpos (int ballpos){
        super.ballPos = 100; 
    }
    
    @Override
    public GameEvent[] getNextEvents() {
        GameEvent theEvent[] = {new KickOff()};
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
