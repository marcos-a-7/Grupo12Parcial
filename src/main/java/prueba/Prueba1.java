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
		empresa.addContrato("Juridica", "Juan Prueba", 40500600, "Efectivo", "Colon", 3000, "100", 3, 1, 0); // caso de misma direccion, no lo crea
		empresa.addContrato("Fisica", "Juan Prueba", 40500600, "Tarjeta", "San Juan", 2011, "100", 3, 1, 1); 
		
		empresa.addContrato("Fisica", "Bruce wayne", -4050, "Cheque", "Colon", 3000, "100", 3, 1, 0); // caso de dni negativo
		
		empresa.addContrato("Juridica", "Juana Tester", 12345678, "Billete de Estanciero", "Formosa", 1, "500", 0, 0, 0); //Debe setear metodo de pago como efectivo solo
		
		//excepciones por tipo persona 
		empresa.addContrato("Helicoptero", "Apache", 747, "Tarjeta", "Buenos Aires", 100, "500", 12, 0, 0); 
		
		//excepciones por tipo internet
		empresa.addContrato("Fisica", "Hola Mundo", 123, "Cheque", "Chaco", 203, "0", 0, 0, 0); 
		
		empresa.addContrato("Juridica", "Bruce wayne", 4050, "Cheque", "Gotica", 5100, "500", 2, -1, -1); //testeando que trata las cant negativas como 0
		empresa.addContrato("Juridica", "Bill Gates", 1000000, "Tarjeta", "EEUU", 200, "100", 5, 2, 2);
		empresa.addContrato("Fisica", "El Choquer", 777, "Efectivo", "Gotica", 205, "500", 5, 0, 1);
		
		
		System.out.println("\n"+empresa.reporte());//imprime la factura de cada contrato que se creo correctamente
		
		
		//cambiando tipo de internet
		empresa.buscaContrato("EEUU", 200).cambiaInternet("0");//no hace nada dado que no es valido
		System.out.println(empresa.buscaContrato("EEUU", 200).getFactura().imprimeFactura());
		empresa.buscaContrato("EEUU", 200).cambiaInternet("500");
		System.out.println(empresa.buscaContrato("EEUU", 200).getFactura().imprimeFactura());
		
		//agregando todo tipo de servicios a bruce wayne
		empresa.buscaContrato(4).addCelulares(1);
		empresa.buscaContrato(4).addCables(1);
		contratos = empresa.buscaContratosTitular(4050);
		contratos.get(0).addTelefonos(2);
		System.out.println(empresa.buscaContrato("Gotica",5100).getFactura().imprimeFactura());
		
		//eliminando servicios
		System.out.println(empresa.buscaContrato(2).getFactura().imprimeFactura());
		contratos = empresa.buscaContratosTitular(40500600);
		contratos.get(1).eliminaCables(1);
		contratos.get(1).eliminaCelular(5000007);
		empresa.buscaContrato(2).eliminaTelefono(4000002);
		System.out.println(empresa.buscaContrato(2).getFactura().imprimeFactura());
		
		//cambiando medio de pago, se vera reflejado en la tasa que se aplica a la factura
		System.out.println(empresa.buscaContrato("Formosa", 1).getFactura().imprimeFactura());
		empresa.buscaContrato("Formosa", 1).getTitular().cambiaMedioPago("Tarjeta");
		System.out.println(empresa.buscaContrato("Formosa", 1).getFactura().imprimeFactura());
		
		
		
		
		
		
		
		
		
		
		
		


	}

}
