package com.proydawii.actions;

import java.util.*;

import net.sf.jasperreports.engine.*;

import org.openxava.actions.*;

public class ReportePedidoPorTiendaAction extends JasperReportBaseAction {

	@Override
	protected Map<String, Object> getParameters() throws Exception {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("id", getView().getValue("tienda.id"));
		return parameters;
	}

	@Override
	protected JRDataSource getDataSource() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String getJRXML() throws Exception {
		// TODO Auto-generated method stub
		return "D:\\desarrollo\\reportes\\pedidosxTienda.jrxml";
	}

}
