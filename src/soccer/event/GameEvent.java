package soccer.event;
import soccer.play.Player;
import soccer.play.Team;
/**
 *
 * @author RYZEN
 */
public abstract class GameEvent {
    
    private Team theTeam;
    private Player thePlayer;
    private double theTime;
    int ballPos;


    public GameEvent(){
    }
    
   //get y set de theTeam
    public Team getTheTeam() {
        return theTeam;
    }

    public void setTheTeam(Team theTeam) {
        this.theTeam = theTeam;
    }
    //get y set de thePlayer
    public Player getThePlayer() {
        return thePlayer;
    }

    public void setThePlayer(Player thePlayer) {
        this.thePlayer = thePlayer;
    }
    //set y get de thetime
    public double getTheTime() {
        return theTime;
    }

    public void setTheTime(double theTime) {
        this.theTime = theTime;
    }
    //ESTE METODO DEVUELVE UN ARAY DE POSIBLES EVENTOS SIGUIENTES
    public abstract GameEvent[] getNextEvents();
//cambiar o no de jugador
    public abstract boolean changePlayer();
//cambiar o no de equipo
    public abstract boolean changeTeam();


    public int getBallPos() {
        return ballPos;
    }


    public void setBallPos(int ballPos) {
        this.ballPos = ballPos + (soccer.util.Settings.PITCH_LENGTH - ballPos)/8;
    }


    public void reverseBallPos(){
        this.ballPos = soccer.util.Settings.PITCH_LENGTH - this.ballPos;
    }
}

