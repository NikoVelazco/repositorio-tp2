package ar.edu.unju.fi.listas;
import java.util.List;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import ar.edu.unju.fi.model.Paseo;
@Component
public class ListaPaseo {
	private List<Paseo> paseos;
	
	public ListaPaseo() {
		paseos = new ArrayList<Paseo>();
		paseos.add(new Paseo("Leg0001", "Noeli Mamaní", "6", "38872637672", "noeli@gmail.com", "Lunes y Vieners: 15 a 17", "Noeli es una paseadora de perros apasionada por los animales. Con una paciencia y calma excepcionales, se ha convertido en una experta en el manejo de perros ansiosos o temerosos. Su enfoque individualizado le permite adaptarse a las necesidades únicas de cada perro, proporcionando paseos relajantes y reconfortantes. Los dueños confían en ella por su habilidad para establecer vínculos sólidos con sus mascotas y garantizar su seguridad en cada salida."));
		paseos.add(new Paseo("Leg0002", "Sara Mercado", "3", "38872637672", "sara@gmail.com", "Lunes y Vieners: 10 a 12", "Sara es una paseadora de perros experimentada y cariñosa. Su principal enfoque es garantizar que los perros se sientan amados y seguros durante los paseos. Con su dulce y tranquilizadora presencia, crea un ambiente relajado para los perros más tímidos o nerviosos. Sara también tiene habilidades en adiestramiento básico y refuerza buenos comportamientos durante los paseos. Los dueños confían en ella para que sus perros reciban un trato afectuoso y una atención personalizada."));
		paseos.add(new Paseo("Leg0003", "Nicolás Velazco", "2", "38872637672", "nico@gmail.com", "Lunes y Vieners: 08 a 12", "Nico es un paseador de perros enérgico y activo. Amante del deporte al aire libre, aprovecha los paseos para mantener a los perros en forma y activos. Con él, los paseos se convierten en emocionantes aventuras donde los perros pueden disfrutar de largas caminatas, correr en parques o incluso nadar en lagos cercanos. Carlos es conocido por su habilidad para entretener y estimular a los perros, brindándoles un tiempo divertido y enérgico al aire libre."));
		paseos.add(new Paseo("Leg0004", "Alicia Roberts", "6", "38872637672", "alicia@gmail.com", "Lunes y Vieners: 18 a 20", "Alicia es una paseadora de perros amante de la naturaleza. Aprovecha los espacios verdes y los senderos para brindar a los perros una experiencia estimulante y enriquecedora. Ella cree en la importancia de conectar a los perros con su entorno natural, permitiéndoles explorar y descubrir nuevos olores y paisajes. María se esfuerza por crear un ambiente relajante y armonioso durante los paseos, fomentando un equilibrio entre la actividad física y la serenidad en la naturaleza."));
		paseos.add(new Paseo("Leg0005", "Cristian Ortega", "5", "38872637672", "cristian@gmail.com", "Lunes y Vieners: 15 a 17", "Cristian es un paseador de perros dedicado y comprometido. Su amor por los animales se refleja en cada aspecto de su trabajo. Es meticuloso en el seguimiento de las rutinas y preferencias de los perros, asegurándose de que se sientan cómodos y felices durante los paseos. Con una gran comprensión del comportamiento canino, Cristian es capaz de manejar cualquier situación de manera efectiva, brindando a los dueños tranquilidad y confianza en su capacidad para cuidar a sus perros."));
	}

	public List<Paseo> getPaseos() {
		return paseos;
	}

	public void setPaseos(List<Paseo> paseos) {
		this.paseos = paseos;
	}
	
	
}

/*package ar.edu.unju.fi.listas;
import java.util.List;
import java.util.ArrayList;
import ar.edu.unju.fi.model.Paseo;
public class ListaPaseo {
	private List<Paseo> paseos;
	
	public ListaPaseo() {
		paseos = new ArrayList<Paseo>();
		paseos.add(new Paseo("Leg0001", "Noeli Mamaní", "6", "38872637672", "noeli@gmail.com", "Lunes y Vieners: 15 a 17", "Noeli es una paseadora de perros apasionada por los animales. Con una paciencia y calma excepcionales, se ha convertido en una experta en el manejo de perros ansiosos o temerosos. Su enfoque individualizado le permite adaptarse a las necesidades únicas de cada perro, proporcionando paseos relajantes y reconfortantes. Los dueños confían en ella por su habilidad para establecer vínculos sólidos con sus mascotas y garantizar su seguridad en cada salida."));
		paseos.add(new Paseo("Leg0002", "Sara Mercado", "3", "38872637672", "sara@gmail.com", "Lunes y Vieners: 10 a 12", "Sara es una paseadora de perros experimentada y cariñosa. Su principal enfoque es garantizar que los perros se sientan amados y seguros durante los paseos. Con su dulce y tranquilizadora presencia, crea un ambiente relajado para los perros más tímidos o nerviosos. Sara también tiene habilidades en adiestramiento básico y refuerza buenos comportamientos durante los paseos. Los dueños confían en ella para que sus perros reciban un trato afectuoso y una atención personalizada."));
		paseos.add(new Paseo("Leg0003", "Nicolás Velazco", "2", "38872637672", "nico@gmail.com", "Lunes y Vieners: 08 a 12", "Nico es un paseador de perros enérgico y activo. Amante del deporte al aire libre, aprovecha los paseos para mantener a los perros en forma y activos. Con él, los paseos se convierten en emocionantes aventuras donde los perros pueden disfrutar de largas caminatas, correr en parques o incluso nadar en lagos cercanos. Carlos es conocido por su habilidad para entretener y estimular a los perros, brindándoles un tiempo divertido y enérgico al aire libre."));
		paseos.add(new Paseo("Leg0004", "Alicia Roberts", "6", "38872637672", "alicia@gmail.com", "Lunes y Vieners: 18 a 20", "Alicia es una paseadora de perros amante de la naturaleza. Aprovecha los espacios verdes y los senderos para brindar a los perros una experiencia estimulante y enriquecedora. Ella cree en la importancia de conectar a los perros con su entorno natural, permitiéndoles explorar y descubrir nuevos olores y paisajes. María se esfuerza por crear un ambiente relajante y armonioso durante los paseos, fomentando un equilibrio entre la actividad física y la serenidad en la naturaleza."));
		paseos.add(new Paseo("Leg0005", "Cristian Ortega", "5", "38872637672", "cristian@gmail.com", "Lunes y Vieners: 15 a 17", "Cristian es un paseador de perros dedicado y comprometido. Su amor por los animales se refleja en cada aspecto de su trabajo. Es meticuloso en el seguimiento de las rutinas y preferencias de los perros, asegurándose de que se sientan cómodos y felices durante los paseos. Con una gran comprensión del comportamiento canino, Cristian es capaz de manejar cualquier situación de manera efectiva, brindando a los dueños tranquilidad y confianza en su capacidad para cuidar a sus perros."));
	}

	public List<Paseo> getPaseos() {
		return paseos;
	}

	public void setPaseos(List<Paseo> paseos) {
		this.paseos = paseos;
	}
	
	
}*/