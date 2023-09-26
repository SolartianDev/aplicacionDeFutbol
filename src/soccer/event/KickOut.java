
package soccer.event;

/**
 *
 * @author RYZEN
 */
public class KickOut extends GameEvent {

    public KickOut() {
    }

    @Override
    public String toString() {
        return "Salvados, Saque de puerta ";
    }

    @Override
    public void setBallPos (int ballpos){
        super.ballPos= 95;
    }
    
    @Override
    public GameEvent[] getNextEvents() {
        GameEvent theEvent[]={ new GainPossession(), new ReceivePass()};
        return theEvent;
    }

    @Override
    public boolean changePlayer() {
        return true;
    }

    @Override
    public boolean changeTeam() {
        return true;
    }
    
}
