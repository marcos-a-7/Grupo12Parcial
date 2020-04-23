package servicios;

/**
 * @author Grupo12
 *La clase internet500 implementa el patron singleton y devuelve el costo de dicho internet<br>
 */
public class Internet500 extends Internet {
	private static Internet500 internet500; 
	
	private Internet500() {
		
	}
	
	public static Internet500 getInstance() {
		if(internet500==null)
			internet500 = new Internet500();
		return internet500;
	}
	
	public double getCosto() {
		return 1000;
	}
	@Override
	public String toString() {
		return "Internet100: " + this.getCosto();
	}
	public String detalle() {
		return super.detalle() + " 500: $" + this.getCosto() + "\n" ;
	}
}
