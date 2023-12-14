package com.examen.controladores;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.examen.dao.Vajilla;
import com.examen.servicios.VajillaService;

/**
 * Controlador que gestiona las operaciones relacionadas con las vajillas en la
 * capa de presentación
 */
@Controller
public class VajillaController {

	@Autowired
	private VajillaService vajillaService;

	/**
	 * Pide al usuario los datos para insertar una nueva vajilla
	 * y por medio del servicio inserta la vajilla
	 */
	public void insertarVajilla() {
		try {
			Scanner sc = new Scanner(System.in);
			Vajilla v = new Vajilla();
			String descripcion;

			System.out.print("Inserte el nombre del elemento vajilla: ");
			String nombreElemento = sc.nextLine();
			v.setNombreElemento(nombreElemento);
			System.out.print("Inserte la descripción del elemento vajilla: ");
			descripcion = sc.nextLine();
			v.setDescripcionElemento(descripcion);
			System.out.print("Inserte la cantidad de stock del elemento: ");
			v.setCantidadElemento(sc.nextInt());
			v.setCodigoElemento(nombreElemento + descripcion);

			vajillaService.save(v);

			System.out.println("Vajilla insertada correctamente");
		} catch (Exception e) {
			System.out.println("[Error] Ocurrio un error no esperado " + e.getMessage());
		}
	}

	/**
	 * Muestra el stock actual de las vajillas registradas en el sistema
	 */
	public void mostrarStock() {
		
		try {
			List<Vajilla> listaVajillas = vajillaService.findAll();
			System.out.println("Mostrando Stock actual de las vajillas");

			for (Vajilla v : listaVajillas) {
				System.out.println("Codigo: " + v.getCodigoElemento() + " Nombre: " + v.getNombreElemento()
						+ "Cantidad: " + v.getCantidadElemento());
			}

		} catch (Exception e) {
			System.out.println("[Error] Ocurrio un error no esperado " + e.getMessage());
		}
	}

	public Vajilla buscarVajillaPorCodigo(String codigo) {
		try {
			return vajillaService.findByCodigo(codigo);
		} catch (Exception e) {
			System.out.println("[Error] Ocurrio un error no esperado " + e.getMessage());
			return null;
		}
	}

	/**
	 * Pide al usuario el codigo de la vajilla y la cantidad a disminuir 
	 * y actuliza la vajilla por medio del servicio
	 */
	public void actualizarVajilla() {
		try {
			Vajilla v = new Vajilla();
			Scanner sc = new Scanner(System.in);
			String codigoElementoAModificar;
			Vajilla vajilla = new Vajilla();

			System.out.print("Inserte el codigo del elemento a modificar: ");
			codigoElementoAModificar = sc.nextLine();
			vajilla = vajillaService.findByCodigo(codigoElementoAModificar);
			if (vajilla != null) {
				int cantidadDisminuir = 0;
				System.out.print("Inserte la cantidad de stock a disminuir: ");
				cantidadDisminuir = sc.nextInt();
				if (vajilla.getCantidadElemento() >= 0) {
					vajilla.setCantidadElemento(vajilla.getCantidadElemento() - cantidadDisminuir);
					vajillaService.update(vajilla);
					System.out.println("Stock de Vajilla actualizado correctamente");
				} else {
					vajilla.setCantidadElemento(0);
					System.out.println("Sin Stock de este elemento, se queda en cero");
				}

			} else {
				System.out.println("No se encontraron vajillas registradas con el codigo " + codigoElementoAModificar);
			}

		} catch (Exception e) {
			System.out.println("[Error] Ocurrio un error no esperado " + e.getMessage());
		}
	}

	/**
	 * Pide al usuario el codigo de la vajilla y la elimina por medio del servicio
	 */
	public void eliminarVajilla() {
		try {

			String codigoElementoAborrar;
			Scanner sc = new Scanner(System.in);
			System.out.print("Inserte el codigo del elemento a borrar: ");
			codigoElementoAborrar = sc.nextLine();

			Vajilla vajilla = new Vajilla();
			vajilla = vajillaService.findByCodigo(codigoElementoAborrar);
			if (vajilla != null) {
				vajillaService.delete(vajilla.getId());
				System.out.println("Vajilla eliminada correctamente");
			} else {
				System.out.println("No se encontraron vajillas registradas con el codigo " + codigoElementoAborrar);
			}

		} catch (Exception e) {
			System.out.println("[Error] Ocurrio un error no esperado " + e.getMessage());
		}
	}

}
