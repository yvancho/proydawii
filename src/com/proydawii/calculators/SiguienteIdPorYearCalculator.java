package com.proydawii.calculators;

import java.util.*;

import javax.persistence.*;

import org.openxava.calculators.*;
import org.openxava.jpa.*;

public class SiguienteIdPorYearCalculator implements ICalculator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int year;

	public Object calculate() throws Exception {
		Query query = XPersistence.getManager().createQuery(
				"select max(p.id) from Pedido "
						+ " p where year(p.fechahoraentrada) = :year");
		query.setParameter("year", getYear());
		Integer ultimoId = (Integer) query.getSingleResult();
		return ultimoId == null ? 1 : ultimoId + 1;
	}

	public int getYear() {
		year = Calendar.getInstance().get(Calendar.YEAR);
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

}
