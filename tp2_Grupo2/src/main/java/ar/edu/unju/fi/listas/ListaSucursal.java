package ar.edu.unju.fi.listas;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.entity.Sucursal;

import java.time.LocalDate;
import java.util.ArrayList;

@Component
public class ListaSucursal {
	private List<Sucursal> sucursales;
	
	public ListaSucursal() {
		sucursales= new ArrayList<Sucursal>();
	/**	sucursales.add(new Sucursal("Patitas Felices en Buenos Aires", "Pedro de Mendoza N° 1835", "Buenos Aires", LocalDate.of(2023, 05, 12), "patitasfelicesbsas@gmail.com", "1139423453"));
		sucursales.add(new Sucursal("Patitas Felices en Córdoba", "Av. Colon N° 1775, Barrio Alberdi", "Buenos Aires", LocalDate.of(2022, 12, 18), "patitasfelicescordoba@gmail.com", "35139423453"));
		sucursales.add(new Sucursal("Patitas Felices en Salta", "Alvarado N° 697", "Salta", LocalDate.of(2022, 11, 20), "patitasfelicessalta@gmail.com", "38739423453"));
		sucursales.add(new Sucursal("Patitas Felices en Palermo", "Fitz Roy N° 2120, B° Palermo-Ciudad de Buenos Aires", "Buenos Aires", LocalDate.of(2022, 11, 26), "patitasfelicespalermo@gmail.com", "1165239909"));
		sucursales.add(new Sucursal("Patitas Felices en San Isidro", "Avenida Centenario N° 1302, San Isidro, Buenos Aires", "Buenos Aires", LocalDate.of(2022, 11, 30), "patitasfelicesisidro@gmail.com", "19878781122"));
		sucursales.add(new Sucursal("Patitas Felices en Misiones", "Calle Rondeau N° 880", "Misiones", LocalDate.of(2022, 12, 03), "patitasfelicesmisiones@gmail.com", "37698541212"));
	**/}
	public List<Sucursal> getSucursales() {
		return sucursales;
	}
	public void setSucursales(List<Sucursal> sucursales) {
		this.sucursales = sucursales;
	}
}

