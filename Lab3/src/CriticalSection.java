import java.util.*;
public class CriticalSection {
<<<<<<< HEAD
	private boolean Voted = false;
	private String currentProcess = null;
	private Queue<String> requestQueue = new LinkedList<String>();
	private HashSet<String> voteSet = new HashSet<String>();
	
	public void setVote(){
		this.Voted = true;
	}
	public void releaseVote(){
		this.Voted = false;
	}
	public boolean isLocked(){
		return this.Voted;
	}
	public void clearSet(){
		this.voteSet.clear();
	}
	public void handleMessage(TimeStampedMessage msg){
		if (msg.get_kind().equals( "request")){
			if (this.isLocked()){
				requestQueue.add(msg.getGroupMessageOrigin());
			}
			else {
				sendAck(msg.getGroupMessageOrigin());
				this.setVote();
			}
		}
		else if (msg.get_kind().equals("release") && msg.getGroupMessageOrigin().equals(currentProcess)){
			if (!requestQueue.isEmpty()){
				String dest = requestQueue.poll();
				sendAck(dest);
				this.setVote();
			}
			else{
				this.releaseVote();
				
			}
			
		}
	}
	
	public void sendAck(String dest){
		TimeStampedMessage msg = new TimeStampedMessage(this.myname, dest, "ack", " ", false,false);
		normal_send(msg);
	}
	public void sendRequest(TimeStampedMessage msg){
		this.clearSet();
	}
=======
    private boolean Voted = false;
    private String currentProcess = null;
    private Queue requestQueue = new LinkedList<String>();
    
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
>>>>>>> origin/master
}

