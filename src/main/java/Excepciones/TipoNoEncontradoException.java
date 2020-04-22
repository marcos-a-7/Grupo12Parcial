package Excepciones;

public class TipoNoEncontradoException extends ImposibleCrearPaqueteException {
	String tipo;

	public TipoNoEncontradoException(String arg0, String tipo) {
		super(arg0);
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

}
