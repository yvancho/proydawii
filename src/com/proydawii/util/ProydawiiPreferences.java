package com.proydawii.util;

import java.io.*;
import java.math.*;
import java.util.*;

import org.apache.commons.logging.*;
import org.openxava.util.*;

public class ProydawiiPreferences {

	private final static String FILE_PROPERTIES = "proydawii.properties";
	private static Log log = LogFactory.getLog(ProydawiiPreferences.class);
	private static Properties properties;

	private static Properties getProperties() {
		if (properties == null) {
			PropertiesReader pr = new PropertiesReader(
					ProydawiiPreferences.class, FILE_PROPERTIES);
			try {
				properties = pr.get();
			} catch (IOException e) {
				log.error(XavaResources.getString("properties_file_error",
						FILE_PROPERTIES), e);
				properties = new Properties();
				e.printStackTrace();
			}
		}
		return properties;
	}

	public static BigDecimal getDefaultPorcentajeIgv() {
		return new BigDecimal(getProperties().getProperty(
				"defaultPorcentajeIgv"));
	}

}
