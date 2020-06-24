package main;

import java.io.IOException;

import controlador.ControladorPrincipal;
import excepciones.NumeroInvalidoException;
import excepciones.PersonaRepetidaException;
import excepciones.TipoPersonaInvalidoException;
import modelo.Empresa;
import pasoDelTiempo.EmuladorPasoTiempo;
import pasoDelTiempo.Observador;
import persistencia.IPersistencia;
import persistencia.PersistenciaBIN;

public class Main {

	public static void main(String[] args) {

		IPersistencia persistencia = new PersistenciaBIN();
		Empresa empresa;
		EmuladorPasoTiempo ept;
		try {
			persistencia.abrirInput("Empresa.bin");
			empresa = (Empresa) persistencia.leer();
			persistencia.cerrarInput();
			persistencia.abrirInput("Mes.bin");
			ept = (EmuladorPasoTiempo)persistencia.leer();
			persistencia.cerrarInput();

		} catch (IOException e) {
			empresa = new Empresa("SpaceX");
			ept = new EmuladorPasoTiempo();
		} catch (ClassNotFoundException e) {
			empresa = new Empresa("SpaceX");
			ept = new EmuladorPasoTiempo();
		}

		Observador obs = new Observador(empresa,ept);
		ControladorPrincipal controlador = new ControladorPrincipal(empresa,ept);

	}

}
