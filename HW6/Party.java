public class Party {

	private int time;
	private int size;
	private int bribe;
	private String name;
	
	public Party(int t, int n, int b, String s) {
		time = t;
		size = n;
		bribe = b;
		name = s;
	}
	
	public int getTime() {
		return time;
	}
	
	public int getSize() {
		return size;
	}
	
	public int getBribe() {
		return bribe;
	}
	
	public String getName() {
		return name;
	}

}
