package com.examen.servicios;

import java.util.List;

import com.examen.dao.Prestamo;

/**
 * Interface que declara los metodos para el CRUD de los elementos de Prestamo
 */
public interface PrestamoService {
	
	/**
	 * Guarda un prestamo en la BBDD
	 * @param prestamo El prestamo a persistir
	 */
	public void save(Prestamo prestamo);

	/**
	 * Elimina un prestamo por su id previamente persistido
	 * @param id del prestamo a eliminar
	 */
	public void delete(long id);

	/**
	 * Modifica un prestamo previamente persistido
	 * @param prestamo el prestamo a modificar
	 */
	public void update(Prestamo prestamo);

	/**
	 * Busca todos los prestamos registrados
	 * @return Una lista de todos los prestamos
	 */
	public List<Prestamo> findAll();

	/**
	 * Busca un prestamo por su id previamente persistido 
	 * @param id del prestamo a buscar
	 * @return El prestamo encontrado
	 */
	public Prestamo findById(int id);
	

}
