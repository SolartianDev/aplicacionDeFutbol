
package soccer.play;
/**
 *
 * @author RYZEN
 */
public class Player implements Comparable {
    
    private String playerName;

    private int goalsScored;

    public Player(String playerName) {
        this.playerName = playerName; // para que no me genere advertencia con el que sigue
        //setPlayerName(PlayerName);
    }
    
    //metodo asignar goles
    public void incGoalsScored(){
        this.goalsScored++;
    }
//get y set de player name
    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String PlayerName) {
        this.playerName = PlayerName;
    }
//get y set de goalsscored
    public int getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    /**
     *
     * @param thePlayer
     * @return
     */
    @Override
    public int compareTo(Object thePlayer) {
     if(this.getGoalsScored() < ((Player)thePlayer).getGoalsScored()){
     return 1;
    }else return -1;
}
   
      
}
