
package soccer.play;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

import soccer.event.GameEvent;
import soccer.event.KickOff;
import soccer.util.Settings;

/**
 *
 * @author RYZEN
 */
public class Game implements IDisplayDataItem {

    private Team homeTeam;
    private Team awayTeam;
    private GameEvent[] events;
    private LocalDateTime theDataTime;
    
    private boolean detailAvailable = false;
    private int id = 0;
    private String detailType = "Game";

    public Game(Team homeTeam, Team awayTeam, LocalDateTime theDataTime) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.theDataTime = theDataTime;
    }
    
    public void playGame(){
        ArrayList <GameEvent> eventList = new ArrayList();
        Team currTeam;
        Player currPlayer;
        GameEvent currEvent = new KickOff();
        currEvent.setBallPos(50);
        
        currEvent.setTheTeam(Math.random()> 0.5? homeTeam : awayTeam);
        
        currEvent.setThePlayer(currEvent.getTheTeam().getPlayerArray()[(int)Math.random()*this.homeTeam.getPlayerArray().length]);
        currEvent.setTheTime(0); //inicio de partido
        eventList.add(currEvent); 
        
        for (int i = 1; i <= Settings.GAME_LENGTH; i++) {
            
            if(Math.random()> Settings.GAME_EVENT_FREQUENCY){
                currTeam = currEvent.getTheTeam();
                currPlayer = currEvent.getThePlayer();
                
                int currBallPos = currEvent.getBallPos();
                
                currEvent = currTeam.getNextPlayAttempt(currEvent);
                
                currEvent.setBallPos(currBallPos);
                
                if(currEvent.changeTeam()){
                    currTeam = getOtherTeam(currTeam);
                    currEvent.reverseBallPos();
                }
                currEvent.setTheTeam(currTeam);
                
                ArrayList <Player> currPlayerList = new ArrayList (Arrays.asList(currEvent.getTheTeam().getPlayerArray()));
                currPlayerList.remove(currPlayer);
                currEvent.setThePlayer(
                    currEvent.changePlayer()?
                    currPlayerList.get((int) (Math.random()* currPlayerList.size())):
                    currPlayer
                );
                    currEvent.setTheTime(i);
                    eventList.add(currEvent);
            }
            this.events = new GameEvent[eventList.size()];
            eventList.toArray(events);
        } 
    }
    
    public String getDescription(boolean showEvents){
        //equipo 1 vs equipo 2 (27/09/2023) (2-1)
       StringBuilder returnString = new StringBuilder();
       returnString.append(this.getHomeTeam().getTeamName() + " vs " +
               this.getAwayTeam().getTeamName() + " (" +
               this.getTheDataTime().format(DateTimeFormatter.ISO_LOCAL_DATE) + ")");
       returnString.append("\n");
       GameResult theResult = getGameResult();
       if(theResult.isIsDrawn()){
           returnString.append(" Empate");
       }else{
           returnString.append((theResult.getWinner().getTeamName()));
           returnString.append("Gana!");
       }
       returnString.append("(" + theResult.getHomeTeamGoals()+"-"+
               theResult.getAwayTeamGoals()+") \n");
       
       if(showEvents){
           for(GameEvent currEvent : this.getEvents()){
               returnString.append(currEvent.getBallPos() + " : " + currEvent+ "en los"+
               currEvent.getTheTime() + "mins por "+
               currEvent.getThePlayer().getPlayerName()+
                   "\n");
           }
       }
       return returnString.toString();
    }
    
    public String getDescription(){
        return getDescription(false);// cuando no haya evento que mostrar
    }
    
    public String getScore(){
        String theScore;
        GameResult theResult = getGameResult();
        theScore = theResult.getHomeTeamGoals() + " - "+ theResult.getAwayTeamGoals();
        return theScore;
    }
    
    public GameResult getGameResult(){
        return new GameResult(this);
    }
    
    public Team getOtherTeam(Team currTeam){
         if(currTeam == homeTeam){
             currTeam = awayTeam;
         }else currTeam = homeTeam;
         return currTeam;
            }
    
    

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    public GameEvent[] getEvents() {
        return events;
    }

    public void setEvents(GameEvent[] events) {
        this.events = events;
    }

    public LocalDateTime getTheDataTime() {
        return theDataTime;
    }

    public void setTheDataTime(LocalDateTime theDataTime) {
        this.theDataTime = theDataTime;
    }
    
    public void setLocalDataTime (LocalDateTime theDataTime){
        this.setTheDataTime(theDataTime);
    }
    
    
    
    
    @Override
    public boolean isDetailAvailable() {
        return detailAvailable;
    }

    public void setDetailAvailable(boolean detailAvailable) {
        this.detailAvailable = detailAvailable;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDetailType(String detailType) {
        this.detailType = detailType;
    }

    @Override
    public String getDisplayDetail() {
        return getScore();
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getDetailType() {
        return detailType;
    }
    
}
