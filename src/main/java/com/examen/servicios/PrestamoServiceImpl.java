package com.examen.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import com.examen.dao.Prestamo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceException;
import jakarta.transaction.Transactional;

/**
 * Clase serivicio que implementa los metodos para el CRUD de los elementos del Prestamo
 */
@Service
public class PrestamoServiceImpl implements PrestamoService {
	
	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	@Transactional
	public void save(Prestamo prestamo) {
		try {
			em.persist(prestamo);		
		} catch (PersistenceException pe ) {
			System.out.println("[Error]: De persistencia, no se ha podido registrar el prestamo" + pe.getMessage());
		}
	}

	@Override
	@Transactional
	public void delete(long id) {
		try {
			Prestamo prestamo = em.find(Prestamo.class, id);
			if(prestamo != null) {
				em.remove(prestamo);
			} else {
				System.out.println("No se encontraron prestamos registrados con id "+id);
			}
		} catch (PersistenceException pe ) {
			System.out.println("[Error]: De persistencia, no se ha podido eliminar el prestamo" + pe.getMessage());
		}
		

	}

	@Override
	@Transactional
	public void update(Prestamo prestamo) {
		try {
			em.merge(prestamo);
		} catch (PersistenceException pe ) {
			System.out.println("[Error]: No se ha podido modificar el prestamo" + pe.getMessage());
		}
	}

	@Override
	@Transactional
	public List<Prestamo> findAll() {
		try {
			List<Prestamo> prestamos = em.createQuery("select p from Prestamo p", Prestamo.class).getResultList();
			return prestamos;
		} catch (PersistenceException e) {
			System.out.println("[Error] De persistencia, no se encontraron prestamos" + e.getMessage());
		}
		return null;
		
	}

	@Override
	@Transactional
	public Prestamo findById(int id) {
		try {
			String query = "select v from Vajilla v where v.id = :id";
			Prestamo prestamo = em.createQuery(query, Prestamo.class).setParameter("id", id).getSingleResult();
			if(prestamo == null) {
				System.out.println("No se encontró prestamo registrado con el id: " + id);
			} else {
				return prestamo;
			}
		} catch (PersistenceException e) {
			System.out.println("[Error] De persistencia, no se encontraró prestamo" + e.getMessage());
		}
		return null;
		
	}

}
