
package soccer.play;

import java.time.LocalDateTime;
import java.util.ArrayList;

import soccer.event.GameEvent;
import soccer.event.KickOff;

/**
 *
 * @author RYZEN
 */
public class Game implements IDisplayDataItem {

    private Team homeTeam;
    private Team awayTeam;
    private GameEvent[] events;
    private LocalDateTime theDataTime;

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
        currEvent.setTheTime(0);
        eventList.add(currEvent);
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
    
    
    
    @Override
    public boolean isDetailAvailable() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getDisplayDetail() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String getDetailType() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
