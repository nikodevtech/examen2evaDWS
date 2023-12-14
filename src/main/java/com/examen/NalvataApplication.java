package com.examen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.examen.controladores.PrestamoController;
import com.examen.controladores.VajillaController;
import com.examen.servicios.MenuServiceImpl;

@SpringBootApplication
public class NalvataApplication {

	/**
	 * Clase principal de la capa de presentación por la que inicia el programa
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(NalvataApplication.class, args);

		MenuServiceImpl menuService = context.getBean(MenuServiceImpl.class);
		VajillaController vajillaController = context.getBean(VajillaController.class);
		PrestamoController prestamoController = context.getBean(PrestamoController.class);

		int opcion;
		boolean cerrarMenu = false;
		do {
			try {
				opcion = menuService.mostrarMenu();
				switch (opcion) {
				case 1:
					vajillaController.insertarVajilla();
					break;
				case 2:
					vajillaController.eliminarVajilla();
					break;
				case 3:
					vajillaController.actualizarVajilla();
					break;
				case 4:
					vajillaController.mostrarStock();
					break;
				case 0:
					cerrarMenu = true;
					break;
				default:
					System.out.println("Opcion no valida, pulse una tecla para continuar...");
					System.in.read();
					break;
				}
			} catch (Exception e) {
				System.out.println("[Error] Ocurrio un error no esperado " + e.getMessage());
			}

		} while (!cerrarMenu);

		System.out.println("Programa finalizado");
	}

}
