package prueba;

import java.util.ArrayList;

import clientes.MedioPago;
import clientes.Persona;
import clientes.Tarjeta;
import modelo.Contrato;
import modelo.Empresa;

/**
 * @author Grupo12 Clase que implementa el metodo main para realizar una prueba
 *         del uso del programa<br>
 */
public class Prueba1 {

	public static void main(String[] args) {
		Empresa empresa = new Empresa("Telefonica");
		Contrato contrato;
		ArrayList<Contrato> contratos = new ArrayList<Contrato>();
		MedioPago medioPago;
		Persona persona;

		empresa.addContrato("Fisica", "Juan Prueba", 40500600, "Cheque", "Colon", 3000, "500", 3, 1, 0);
		empresa.addContrato("Fisica", "Juan Prueba", 40500600, "Cheque", "Colon", 3000, "100", 3, 1, 0); // caso de misma direccion, no lo crea
		empresa.addContrato("Fisica", "Juan Prueba", 40500600, "Tarjeta", "Colon", 3001, "100", 3, 1, 0); 
		empresa.addContrato("Juridica", "Juana Tester", 12345678, "Billete de Estanciero", "Formosa", 1, "500", 0, 0, 0); //Debe setear metodo de pago como efectivo solo
		empresa.addContrato("", "Empty", 123, "Cheque", "Chaco", -5, "100", 0, 0, 0);
		empresa.addContrato("Fisica", "Bruce wayne", -4050, "Cheque", "Colon", 3000, "100", 3, 1, 0); // caso de dni negativo
		empresa.addContrato("Fisica", "Bruce wayne", 40906, "Cheque", "Colon", 3000, "100", 3, 1, 0); //

		
		
		
		
		
		


	}

}
