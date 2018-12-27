package clock;

public class Clock {
	private display hour = new display(24);
	private display minute = new display(60);
	private display second = new display(60);
	
	public Clock(int hour, int minute, int second) {
		this.hour.setValue(hour);
		this.minute.setValue(minute);
		this.second.setValue(second);
	}
	
	public void tick() {
		this.second.increase();
		if (this.second.getValue() == 0 ) {
			this.minute.increase();
			if( this.minute.getValue() == 0 ) {
				this.hour.increase();
			}
		}
	}
	
	public String toString() {
		return String.format("%02d:%02d:%02d",this.hour.getValue(),this.minute.getValue(),this.second.getValue());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Clock a = new Clock(20,35,45);
		while(true) 
		{
			a.tick();
			System.out.println(a);
		}
	}

}

class display {
	private int value = 0;
	private int limit = 0;
	
	public display(int limit) {
		this.limit = limit;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public void increase() {
		value++;
		if( value == limit ) 
		{
			value = 0;
		}
	}
}
