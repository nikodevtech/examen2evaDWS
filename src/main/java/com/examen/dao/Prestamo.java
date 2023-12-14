package com.examen.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

/**
 * Clase DAO que representa la entidad Prestamo en el sistema.
 */
@Entity
@Table(name = "prestamos", schema = "esq_exa_dos")
public class Prestamo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPrestamo;
	@Column(name = "fecha_prestamo")
	private LocalDate fechaPrestamo = LocalDate.of(9999, 12, 31);
	
	@JoinTable(name = "rel_prestamo_vajilla",
				joinColumns = @JoinColumn(name = "prestamo_id_fk"),
				inverseJoinColumns = @JoinColumn(name = "vajilla_id_fk"),
				schema = "esq_exa_dos"
				)
	@ManyToMany
	private List<Vajilla>listaVajilla = new ArrayList<>();
	
	public Prestamo() {
		
	}
	
	public Prestamo(LocalDate fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}

	public int getIdPrestamo() {
		return idPrestamo;
	}


	public LocalDate getFechaPrestamo() {
		return fechaPrestamo;
	}

	public void setFechaPrestamo(LocalDate fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}

	public List<Vajilla> getListaVajilla() {
		return listaVajilla;
	}

	public void setListaVajilla(List<Vajilla> listaVajilla) {
		this.listaVajilla = listaVajilla;
	}

	@Override
	public String toString() {
		return "Prestamo [idPrestamo=" + idPrestamo + ", fechaPrestamo=" + fechaPrestamo + ", listaVajilla="
				+ listaVajilla.toString() + "]";
	}
	
	
	

}
