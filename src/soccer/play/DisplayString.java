
package soccer.play;

/**
 *
 * @author RYZEN
 */
public class DisplayString implements IDisplayDataItem {
    
    String displayDetail;
    int id = 0;

    public DisplayString(String displayDetail) {
        this.displayDetail = displayDetail;
    }

    public void setDisplayDetail(String displayDetail) {
        this.displayDetail = displayDetail;
    }
    
    
    

    @Override
    public boolean isDetailAvailable() {
        return false;
    }

    @Override
    public String getDisplayDetail() {
        return this.displayDetail;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getDetailType() {
       return "String"; 
    }
    
}
