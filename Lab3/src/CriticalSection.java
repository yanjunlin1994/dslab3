import java.util.*;
public class CriticalSection {
	private boolean Voted = false;
	private String currentProcess;
	private HashSet<String> receivedSet = new HashSet<String>();
	private Queue<String> requestQueue = new LinkedList<String>();
	
	public String getCurrentProcess(){
		return currentProcess;
	}
	
	public void setCurrentProces(String name){
		this.currentProcess = name;
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
				requestQueue.add(msg.get_source());
			}
			else {
				sendAck(msg);
				this.enterCS();
			}
		}
		else if (msg.get_kind().equals("release") && msg.groupMessageOrigin())
	}
	public void sendAck(TimeStampedMessage msg){
		
	}
}
