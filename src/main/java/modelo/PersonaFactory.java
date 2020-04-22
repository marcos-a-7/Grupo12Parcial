package modelo;

public class PersonaFactory {

	public PersonaFactory() {
		// TODO Auto-generated constructor stub
	}

	public Persona getPersona(String tipo, String nombre, int dni, MedioPago medioPago) {
		if (tipo == null)
			return null;
		else if (tipo.equals("Fisica"))
			return new PersonaFisica(nombre, dni, medioPago);
		else if (tipo.equals("Juridica"))
			return new PersonaJuridica(nombre, dni, medioPago);
		return null;
	}



}
