package modelo;

public abstract class DecoradorServicio implements IServicio {

	IServicio servicioEncapsulado;
	
	

	public DecoradorServicio(IServicio servicioEncapsulado) {
		this.servicioEncapsulado = servicioEncapsulado;
	}

	public String detalle() {
		return servicioEncapsulado.detalle();
	}

	public double getCostoTotal() {
		return servicioEncapsulado.getCostoTotal() + this.getCosto();
	}
}
