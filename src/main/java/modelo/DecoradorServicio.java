package modelo;

public abstract class DecoradorServicio implements IServicio {
	
	IServicio servicioEncapsulado;
	
	public String detalle() {
		return servicioEncapsulado.detalle(); 
	}
}
