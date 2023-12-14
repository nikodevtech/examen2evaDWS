package com.examen.dao;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

/**
 * Clase DAO que representa la entidad Vajilla en el sistema.
 */
@Entity
@Table(name = "vajillas", schema = "esq_exa_dos")
public class Vajilla {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "codigo")
	private String codigoElemento = "aaaaa";
	@Column(name = "nombre")
	private String nombreElemento = "aaaaa";
	@Column(name = "descripcion")
	private String descripcionElemento = "aaaaa";
	@Column(name = "cantidad")
	private int cantidadElemento = 0;
	
	@ManyToMany(mappedBy = "listaVajilla")
	private List<Prestamo> listaPrestamos = new ArrayList<>();
	
	
	public Vajilla() {
		
	}
	

	public Vajilla(int id, String codigoElemento, String nombreElemento, String descripcionElemento, int cantidadElemento) {
		super();
		this.id = id;
		this.codigoElemento = codigoElemento;
		this.nombreElemento = nombreElemento;
		this.descripcionElemento = descripcionElemento;
		this.cantidadElemento = cantidadElemento;
	}


	public int getId() {
		return id;
	}


	public String getCodigoElemento() {
		return codigoElemento;
	}


	public void setCodigoElemento(String codigoElemento) {
		this.codigoElemento = codigoElemento;
	}


	public String getNombreElemento() {
		return nombreElemento;
	}


	public void setNombreElemento(String nombreElemento) {
		this.nombreElemento = nombreElemento;
	}


	public String getDescripcionElemento() {
		return descripcionElemento;
	}


	public void setDescripcionElemento(String descripcionElemento) {
		this.descripcionElemento = descripcionElemento;
	}


	public int getCantidadElemento() {
		return cantidadElemento;
	}


	public void setCantidadElemento(int cantidadElemento) {
		this.cantidadElemento = cantidadElemento;
	}


	public List<Prestamo> getListaPrestamos() {
		return listaPrestamos;
	}


	public void setListaPrestamos(List<Prestamo> listaPrestamos) {
		this.listaPrestamos = listaPrestamos;
	}


	@Override
	public String toString() {
		return "Vajilla [id=" + id + ", codigoElemento=" + codigoElemento + ", nombreElemento=" + nombreElemento
				+ ", descripcionElemento=" + descripcionElemento + ", cantidadElemento=" + cantidadElemento
				+ ", listaPrestamos=" + listaPrestamos.toString() + "]";
	}
	
	
	
	
	

}
