
package soccer.event;

/**
 *
 * @author RYZEN
 */
public class Dribble extends GameEvent{

    public Dribble(){
        super();
    }


    @Override
    public String toString(){
        return "Regate ";
    }


    @Override
    public GameEvent[] getNextEvents() {
        GameEvent theEvent[] = { new GainPossession(), new Shoot(), new Pass()};
        return theEvent;
    }

    //cambiar de jugador
    @Override
    public boolean changePlayer() {
       return false;
    }
    //cambiar o no de equipo
    @Override
    public boolean changeTeam() {
        return false;
    }

}
