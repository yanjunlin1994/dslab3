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
}
