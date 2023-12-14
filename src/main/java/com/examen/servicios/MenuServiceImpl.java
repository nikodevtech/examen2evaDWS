package com.examen.servicios;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.springframework.stereotype.Service;

/**
 * Clase que implementa la interfaz MenuService y define los metodos allí declarados
 */
@Service
public class MenuServiceImpl implements MenuService {

	@Override
	public int mostrarMenu() {
		
		int opcion = 0;
		try {
			Scanner sc = new Scanner(System.in);
			
			System.out.println("--- Menu ---");
			System.out.println("1. Registrar nueva vajilla");
			System.out.println("2. Eliminar vajilla");
			System.out.println("3. Modificar vajilla");	
			System.out.println("4. Mostrar Stock");
			System.out.println("5. Realizar reserva");
			System.out.println("0. Salir");
			
			System.out.print("Introduce una opcion: ");
			opcion = sc.nextInt();
		} catch(InputMismatchException e) {
			System.out.println("[Error] No ha introducido un valor numerico");
		}
		
		return opcion;
	}

}
