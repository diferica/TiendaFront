package com.mintic.tiendafront.dto;

import com.opencsv.bean.CsvBindByName;

public class Producto {

	@CsvBindByName(column = "idProveedor")
	private int idProveedor;

	@CsvBindByName(column = "ivaCompra")
	private double ivaCompra;

	@CsvBindByName(column = "nombre")
	private String nombre;

	@CsvBindByName(column = "precioCompra")
	private double precioCompra;

	@CsvBindByName(column = "precioVenta")
	private double precioVenta;
	
	

	public Producto() {
	}

	public Producto(int idProveedor, double ivaCompra, String nombre, double precioCompra, double precioVenta) {
		this.idProveedor = idProveedor;
		this.ivaCompra = ivaCompra;
		this.nombre = nombre;
		this.precioCompra = precioCompra;
		this.precioVenta = precioVenta;
	}

	public int getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}

	public double getIvaCompra() {
		return ivaCompra;
	}

	public void setIvaCompra(double ivaCompra) {
		this.ivaCompra = ivaCompra;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecioCompra() {
		return precioCompra;
	}

	public void setPrecioCompra(double precioCompra) {
		this.precioCompra = precioCompra;
	}

	public double getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}

}
