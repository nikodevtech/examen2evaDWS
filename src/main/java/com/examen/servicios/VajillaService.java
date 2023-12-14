package com.examen.servicios;

import java.util.List;

import com.examen.dao.Vajilla;

/**
 * Interface que declara los metodos para el CRUD de los elementos de Vajilla
 */
public interface VajillaService {
	

	/**
	 * Guarda un elemento de Vajilla en la base de datos
	 * @param vajilla para ser guardada
	 */
	public void save(Vajilla vajilla);

	/**
	 * Elimina un elemento de Vajilla
	 * @param codigo del elemento a eliminar
	 */
	public void delete(int id);

	/**
	 * Modifica un elemento de Vajilla
	 * @param vajilla para ser modificada
	 */
	public void update(Vajilla vajilla);

	/**
	 * Busca todos los elementos de Vajilla
	 * @return una lista de todos los elementos
	 */
	public List<Vajilla> findAll();

	/**
	 * Busca un elemento de Vajilla por su codigo
	 * @param codigo del elemento a buscar
	 * @return el elemento vajilla
	 */
	public Vajilla findByCodigo(String codigo);
	

}
