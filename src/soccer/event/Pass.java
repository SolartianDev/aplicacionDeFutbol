/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package soccer.event;

/**
 *
 * @author RYZEN
 */
public class Pass extends GameEvent {

    public Pass() {
        super();
    }

    @Override
    public String toString() {
        return "Pase Ejecutado ";
    }

    
    
    
    @Override
    public GameEvent[] getNextEvents() {
        GameEvent theEvent[] = {new ReceivePass(), new GainPossession()};
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
