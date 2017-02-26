import java.util.*;
public class CriticalSection {
    private boolean Voted;
    private String currentProcess;
    private Queue requestQueue;
    public CriticalSection() {
        this.Voted = false;
        this.currentProcess = null;
        this.requestQueue = new LinkedList<String>();
    }
    
    public void enterCS(){
        this.Voted = true;
    }
    public void releaseCS(){
        this.Voted = false;
    }
    public boolean isLocked(){
        return this.Voted;
    }
    public void handleRequest(TimeStampedMessage msg){
        if (msg.get_kind().equals( "request")){
            if (this.isLocked()){
                requestQueue.add(msg.getGroupMessageOrigin());
            }
            else {
                sendAck(msg);
                this.enterCS();
            }
        }
        else if (msg.get_kind().equals("release") && msg.getGroupMessageOrigin().equals(currentProcess)){
            
        }
    }
    public void sendAck(TimeStampedMessage msg){
        
    }
}

