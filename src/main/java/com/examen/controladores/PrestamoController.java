package com.examen.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.examen.dao.Prestamo;
import com.examen.servicios.PrestamoService;

/**
 * Controlador que gestiona las operaciones relacionadas con los prestamos en la
 * capa de presentación
 */
@Controller
public class PrestamoController {

	@Autowired
	private PrestamoService prestamoService;

	public void insertarPrestamo(Prestamo p) {
		try {
			prestamoService.save(p);
		} catch (Exception e) {
			System.out.println("[Error] Ocurrio un error no esperado " + e.getMessage());
		}
	}

	public List<Prestamo> buscarTodosLosPrestamos() {
		try {
			return prestamoService.findAll();
		} catch (Exception e) {
			System.out.println("[Error] Ocurrio un error no esperado " + e.getMessage());
			return null;
		}
	}

	public Prestamo buscarPrestamoPorId(int id) {
		try {
			return prestamoService.findById(id);
		} catch (Exception e) {
			System.out.println("[Error] Ocurrio un error no esperado " + e.getMessage());
			return null;
		}
	}

	public void actualizarPrestamo(Prestamo p) {
		try {
			prestamoService.update(p);
		} catch (Exception e) {
			System.out.println("[Error] Ocurrio un error no esperado " + e.getMessage());
		}
	}

	public void eliminarPrestamo(int id) {
		try {
			prestamoService.delete(id);
		} catch (Exception e) {
			System.out.println("[Error] Ocurrio un error no esperado " + e.getMessage());
		}
	}

}
