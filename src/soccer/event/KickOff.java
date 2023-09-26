
package soccer.event;

/**
 *
 * @author RYZEN
 */
public class KickOff extends GameEvent{

    public KickOff() {
    }

    @Override
    public String toString() {
        return "Inicia el juego ";
    }

    
    @Override
     public void setBallPos (int ballpos){
         super.ballPos = 50;
     }
    
    @Override
    public GameEvent[] getNextEvents() {
        GameEvent theEvent[] = {new ReceivePass(), new GainPossession()};
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
