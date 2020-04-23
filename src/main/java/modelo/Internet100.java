package modelo;

public class Internet100 extends Internet {
	private static Internet100 internet100; 
	
	private Internet100() {
		
	}
	
	public static Internet100 getInstance() {
		if(internet100==null)
			internet100 = new Internet100();
		return internet100;
	}
	
	public double getCosto() {
		return 850;
	}
	public String detalle() {
		return super.detalle() + " 100: $" + this.getCosto() + "\n" ;
	}
}
