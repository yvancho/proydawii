package com.proydawii.calculators;

import org.openxava.calculators.*;
import com.proydawii.model.*;

import org.openxava.jpa.*;

public class PrecioPorUnidad implements ICalculator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int productoId;

	public Object calculate() throws Exception {
		Productotienda producto = XPersistence.getManager().find(
				Productotienda.class, productoId);
		return producto.getPrecio();
	}

	public int getProductoId() {
		return productoId;
	}

	public void setProductoId(int productoId) {
		this.productoId = productoId;
	}

}
