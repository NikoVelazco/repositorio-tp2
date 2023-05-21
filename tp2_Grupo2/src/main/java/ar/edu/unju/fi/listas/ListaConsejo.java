package ar.edu.unju.fi.listas;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.model.Consejo;

/**Se define una clase ListaConsejos
 * la clase tiene un atributo llamado consejos, tipo List 
 * consejos guarda una lista de objetos de la clase Consejo
 * **/
public class ListaConsejo {
	
private List<Consejo> consejos;
	
	/**
	 * Constructor por defecto para crear objetos clase lista Consejo
	 *   
	 */
	public ListaConsejo() {
		consejos = new ArrayList<Consejo>();
		consejos.add(new Consejo(1, "SALUD", "INDISTINTO", "INDISTINTO", "Mantén al día las vacunas de tu mascota. "
				+ "Es importante asegurarse de que tu perro esté al día en sus vacunas para prevenir enfermedades y mantener su salud en óptimas condiciones."));
		consejos.add(new Consejo(2, "ALIMENTACION", "INDISTINTO", "INDISTINTO", "Controla la alimentación de tu mascota. Proporciona a tu perro una dieta equilibrada y adecuada a sus necesidades nutricionales para mantener su peso ideal y prevenir enfermedades."));
		consejos.add(new Consejo(3, "CUIDADOS", "INDISTINTO", "INDISTINTO", "Mantén a tu mascota bien hidratado. Asegúrate de llevar agua y un tazón portátil para tu mascota durante los paseos. Si hace calor, es especialmente importante que tu mascota tenga acceso constante a agua fresca para evitar el riesgo de deshidratación."));
		consejos.add(new Consejo(4, "SALUD", "INDISTINTO", "INDISTINTO", "Realiza chequeos médicos regulares. Lleva a tu mascota al veterinario para chequeos médicos regulares, de esta manera podrás detectar problemas de salud temprano y tratarlos antes de que se conviertan en una situación más grave"));
		consejos.add(new Consejo(5, "CUIDADOS", "INDISTINTO", "INDISTINTO", "Ejercita a tu mascota. Los perros necesitan ejercicio regular para mantenerse saludables y felices. Caminar, correr o jugar con tu perro también puede fortalecer el vínculo entre ambos."));
		consejos.add(new Consejo(6, "CUIDADOS", "INDISTINTO", "INDISTINTO", "Es importante mantener a tu perro limpio y cuidado para prevenir problemas de salud. Cepilla regularmente su pelo para evitar enredos y para mantener su pelaje saludable.\r\n"
				+ "		    		 También es Importante bañarlo regularmente para evitar problemas de piel."));
		consejos.add(new Consejo(7, "CUIDADOS", "INDISTINTO", "INDISTINTO", "Proporciona un ambiente seguro. Mantén tu casa segura para tu perro, evita objetos peligrosos al alcance de su boca y asegúrate de que no tenga acceso a productos tóxicos."));
		
	}

	/**
	 * Metodo para obtener el array list consejos
	 * @return
	 */
	public List<Consejo> getConsejos() {
		return consejos;
	}

	/**
	 * Metodod para guardar el objeto consejos
	 * @param consejos objeto a ser guardado 
	 */
	public void setConsejos(List<Consejo> consejos) {
		this.consejos = consejos;
	}
	
	

}
