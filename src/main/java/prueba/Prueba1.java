package prueba;

import java.util.ArrayList;

import clientes.MedioPago;
import clientes.Persona;
import clientes.Tarjeta;
import modelo.Contrato;
import modelo.Empresa;
import modelo.Factura;

/**
 * @author Grupo12 Clase que implementa el metodo main para realizar una prueba
 *         del uso del programa<br>
 */
public class Prueba1 {

	/*public static void main(String[] args) throws CloneNotSupportedException {
		Empresa empresa = new Empresa("Telefonica");
		Contrato contrato;
		ArrayList<Contrato> contratos = new ArrayList<Contrato>();
		MedioPago medioPago;

		empresa.addContrato("Fisica", "Juan Prueba", 40500600, "Cheque", "Colon", 3000, "500", 3, 1, 0);
		empresa.addContrato("Juridica", "Juan Prueba", 40500600, "Efectivo", "Colon", 3000, "100", 3, 1, 0); // caso de misma direccion, no lo crea
		empresa.addContrato("Fisica", "Juan Prueba", 40500600, "Tarjeta", "San Juan", 2011, "100", 3, 1, 1); 
		
		empresa.addContrato("Fisica", "Bruce wayne", -4050, "Cheque", "Colon", 3000, "100", 3, 1, 0); // caso de dni negativo
		
		empresa.addContrato("Juridica", "Juana Tester", 12345678, "Billete de Estanciero", "Formosa", 1, "500", 0, 0, 0); //Debe setear metodo de pago como efectivo solo

		empresa.addContrato("", "Empty", 123, "Cheque", "Chaco", -5, "100", 0, 0, 0);
		empresa.addContrato("Fisica", "Bruce wayne", -4050, "Cheque", "Colon", 3000, "100", 3, 1, 0); // caso de dni negativo
		empresa.addContrato("Fisica", "Bruce wayne", 40906, "Cheque", "Colon", 3000, "100", 3, 1, 0); //


		
		//excepciones por tipo persona 
		empresa.addContrato("Helicoptero", "Apache", 747, "Tarjeta", "Buenos Aires", 100, "500", 12, 0, 0); 
		
		//excepciones por tipo internet
		empresa.addContrato("Fisica", "Hola Mundo", 123, "Cheque", "Chaco", 203, "0", 0, 0, 0); 
		
		empresa.addContrato("Juridica", "Bruce wayne", 4050, "Cheque", "Gotica", 5100, "500", 2, -1, -1); //testeando que trata las cant negativas como 0
		empresa.addContrato("Juridica", "Bill Gates", 1000000, "Tarjeta", "EEUU", 200, "100", 5, 2, 2);
		empresa.addContrato("Fisica", "El Choquer", 777, "Efectivo", "Gotica", 205, "500", 5, 0, 1);
		
		
		System.out.println("\n"+empresa.enlistarFacturas());//imprime la factura de cada contrato que se creo correctamente
		System.out.println("-----------------------------------------------------------------------------------\n");

		//cambiando tipo de internet
		System.out.println("Cambiando tipo de internet\n");
		empresa.buscaContrato("EEUU", 200).cambiaInternet("0");//no hace nada dado que no es valido
		System.out.println(empresa.buscaContrato("EEUU", 200).getFactura().imprimeFactura());
		empresa.buscaContrato("EEUU", 200).cambiaInternet("500");
		System.out.println(empresa.buscaContrato("EEUU", 200).getFactura().imprimeFactura());
		System.out.println("-----------------------------------------------------------------------------------\n");
		
		//agregando todo tipo de servicios a bruce wayne
		System.out.println("Agregando servicios\n");
		System.out.println(empresa.buscaContrato("Gotica",5100).getFactura().imprimeFactura());
		empresa.buscaContrato(4).addCelulares(1);
		empresa.buscaContrato(4).addCables(1);
		contratos = empresa.buscaContratosTitular(4050);
		contratos.get(0).addTelefonos(2);
		System.out.println(empresa.buscaContrato("Gotica",5100).getFactura().imprimeFactura());
		System.out.println("-----------------------------------------------------------------------------------\n");
		
		//eliminando servicios de juan prueba en la direccion san juan 2011
		System.out.println("eliminando servicios\n");
		System.out.println(empresa.buscaContrato(2).getFactura().imprimeFactura());
		contratos = empresa.buscaContratosTitular(40500600);
		contratos.get(1).eliminaCables(1);
		contratos.get(1).eliminaCelular(5000007);
		empresa.buscaContrato(2).eliminaTelefono(4000002);
		System.out.println(empresa.buscaContrato(2).getFactura().imprimeFactura());
		System.out.println("-----------------------------------------------------------------------------------\n");
		
		//cambiando medio de pago, se vera reflejado en la tasa que se aplica a la factura
		System.out.println("cambiando medio de pago, se vera reflejando en un cambio en el Costo final\n");
		System.out.println(empresa.buscaContrato("Formosa", 1).getFactura().imprimeFactura());
		empresa.buscaContrato("Formosa", 1).getTitular().cambiaMedioPago("Tarjeta");
		System.out.println(empresa.buscaContrato("Formosa", 1).getFactura().imprimeFactura());
		System.out.println("-----------------------------------------------------------------------------------\n");
		
		//borrar todos los contratos de juan prueba
		System.out.println("borro todos los contratos de juan prueba");
		empresa.eliminaContratosTitular(40500600);
		System.out.println(empresa.buscaContratosTitular(40500600)==null);
		System.out.println("-----------------------------------------------------------------------------------\n");
		
		//borrar contrato por direccion
		System.out.println("borro contrato por direccion");
		empresa.eliminaContrato("EEUU", 200);
		System.out.println(empresa.buscaContrato("EEUU",200)==null);
		System.out.println("-----------------------------------------------------------------------------------\n");
		
		//borrar contrato por id
		System.out.println("borro contrato por id");
		empresa.eliminaContrato(3);
		System.out.println(empresa.buscaContrato(2)==null);
		System.out.println("-----------------------------------------------------------------------------------\n");

		//probando clone para un contrato de persona juridica(no es clonable)
		System.out.println("probando clone para un contrato de persona juridica(no es clonable)\n");
		Factura factura = null;
		factura = empresa.buscaContrato("Gotica", 5100).getFactura().clone();
		System.out.println(factura==null);
		System.out.println("-----------------------------------------------------------------------------------\n");
		
		//testeo el clone con una persona fisica, no puedo testear con factura porque no implementa seters
		System.out.println("Probando el clone en una persona fisica (siempre clonable)\n");
		Persona persona;
		persona = empresa.buscaContrato("Gotica", 205).getTitular();
		Persona personaClone = persona.clone();
		personaClone.setNombre("El Joker");
		System.out.println("\nPersona nombre: " + persona.getNombre());
		System.out.println("Persona clone nombre: " + personaClone.getNombre());
		System.out.println("-----------------------------------------------------------------------------------\n");

		//reporte y lista de facturas final
		System.out.println("reporte final\n");
		System.out.println("\n"+empresa.reporte());
		System.out.println("-----------------------------------------------------------------------------------\n");
		System.out.println("Enlista facturas\n");
		System.out.println("\n"+empresa.enlistarFacturas());

		
		
		


	}*/

}
