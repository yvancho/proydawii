package com.proydawii.calculators;

import org.openxava.calculators.*;

import com.proydawii.util.*;

public class PorcentajeIgvCalculator implements ICalculator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Object calculate() throws Exception {
		
		return ProydawiiPreferences.getDefaultPorcentajeIgv();
	}

}
