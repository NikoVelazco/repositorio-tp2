package ar.edu.unju.fi.listas;
import java.util.List;
import java.util.ArrayList;
import ar.edu.unju.fi.model.Paseo;
public class ListaPaseo {
	private List<Paseo> paseos;
	
	public ListaPaseo() {
		paseos = new ArrayList<Paseo>();
		paseos.add(new Paseo("Leg0001", "Noeli Mamaní", "6", "38872637672", "noeli@gmail.com", "Lunes y Vieners: 15 a 17"));
		paseos.add(new Paseo("Leg0002", "Sara Mercado", "3", "38872637672", "sara@gmail.com", "Lunes y Vieners: 10 a 12"));
		paseos.add(new Paseo("Leg0003", "Nicolás Velazco", "2", "38872637672", "nico@gmail.com", "Lunes y Vieners: 08 a 12"));
		paseos.add(new Paseo("Leg0004", "Alicia Roberts", "6", "38872637672", "alicia@gmail.com", "Lunes y Vieners: 18 a 20"));
		paseos.add(new Paseo("Leg0005", "Cristian Ortega", "5", "38872637672", "cristian@gmail.com", "Lunes y Vieners: 15 a 17"));
	}

	public List<Paseo> getPaseos() {
		return paseos;
	}

	public void setPaseos(List<Paseo> paseos) {
		this.paseos = paseos;
	}
	
	
}