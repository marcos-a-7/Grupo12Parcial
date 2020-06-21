package main;

import controlador.ControladorPrincipal;
import excepciones.NumeroInvalidoException;
import excepciones.TipoPersonaInvalidoException;
import modelo.Empresa;

public class Main {

	public static void main(String[] args) {
		
		Empresa empresa = new Empresa("MobiEstar");
		try {
			empresa.addPersona("Fisica", "Marcos", 456164);
			empresa.addPersona("Juridica", "que se yo", 7894843);
		} catch (NumeroInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TipoPersonaInvalidoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ControladorPrincipal controlador = new ControladorPrincipal(empresa);

	}

}
