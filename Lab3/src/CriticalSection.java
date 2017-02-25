import java.util.*;
public class CriticalSection {
	private boolean Voted = false;
	
	public void enterCS(){
		this.Voted = true;
	}
	public void releaseCS(){
		this.Voted = false;
	}
	public boolean isLocked(){
		return this.Voted;
	}
<<<<<<< HEAD
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
=======
>>>>>>> parent of 4b5e617... template
}
