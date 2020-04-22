package modelo;

import Excepciones.ImposibleCrearPaqueteException;
import Excepciones.TipoNoEncontradoException;

public class PaqueteServiciosFactory {

	protected static PaqueteServicios getPaqueteServicios(String tipoInternet, int cantCelu, int cantTel, int cantCable)
			throws ImposibleCrearPaqueteException {
		PaqueteServicios paquete = null;
		int i;
		if (tipoInternet != null) {
			if (tipoInternet.equals("100")) {
				paquete = new PaqueteServicios(new Internet100());
			} else if (tipoInternet.equals("500")) {
				paquete = new PaqueteServicios(new Internet500());
			} else {
				throw new TipoNoEncontradoException("No se pudo crear el paquete con el internet ", tipoInternet);
			}
			if (paquete != null) {
				for (i = 0; i < cantCelu; i++)
					paquete.addCelular(new Celular());
				for (i = 0; i < cantTel; i++)
					paquete.addTelefono(new Telefono());
				for (i = 0; i < cantCable; i++)
					paquete.addCable(new Cable());
			}
		}
		return paquete;
	}

}
