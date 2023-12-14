package com.examen.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import com.examen.dao.Vajilla;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceException;
import jakarta.transaction.Transactional;

/**
 * Clase que implementa los metodos para el CRUD de los elementos de la Vajilla
 */
@Service
public class VajillaServiceImpl implements VajillaService {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void save(Vajilla vajilla) {
		try {
			em.persist(vajilla);

		} catch (PersistenceException pe) {
			System.out.println("[Error]: No se ha podido registrar la vajilla" + pe.getMessage());
		}
	}

	@Override
	@Transactional
	public void delete(int id) {
		try {
			Vajilla vajilla = em.find(Vajilla.class, id);
			if (vajilla != null) {
				em.remove(vajilla);
			} else {
				System.out.println("[Error]: La vajilla no existe para ser eliminada");
			}
		} catch (PersistenceException pe) {
			System.out.println("[Error]: No se ha podido eliminar la vajilla" + pe.getMessage());
		}

	}

	@Override
	@Transactional
	public void update(Vajilla vajilla) {
		try {
			em.merge(vajilla);
		} catch (PersistenceException pe) {
			System.out.println("[Error]: No se ha podido modificar la vajilla" + pe.getMessage());
		}
	}

	@Override
	@Transactional
	public List<Vajilla> findAll() {
		try {

			List<Vajilla> vajillas = em.createQuery("select v from Vajilla v", Vajilla.class).getResultList();
			if (vajillas.isEmpty()) {
				System.out.println("No se encontraron vajillas registradas");
			} else {
				return vajillas;
			}
		} catch (PersistenceException pe) {
			System.out.println("[Error]: No se han podido recuperar las vajillas" + pe.getMessage());
		}
		return null;

	}

	@Override
	@Transactional
	public Vajilla findByCodigo(String codigo) {
		try {
			String query = "select v from Vajilla v where v.codigoElemento = :codigo";
			Vajilla vajilla = em.createQuery(query, Vajilla.class).setParameter("codigo", codigo).getSingleResult();
			if (vajilla == null) {
				System.out.println("No se encontraró vajilla registrada con codigo" + codigo);
			} else {
				return vajilla;
			}
		} catch (PersistenceException pe) {
			System.out
					.println("[Error]: No se han podido recuperar las vajilla con codigo " + codigo + pe.getMessage());
		}
		return null;

	}

}
