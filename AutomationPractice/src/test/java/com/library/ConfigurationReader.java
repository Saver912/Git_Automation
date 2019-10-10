package com.library;

import java.io.FileInputStream;
import java.util.Properties;

import net.bytebuddy.jar.asm.commons.TryCatchBlockSorter;

public class ConfigurationReader {
	private static Properties configFileReader;
	static {
		try {
			String path = "config.properties";
			FileInputStream input = new FileInputStream(path);

			configFileReader = new Properties();
			configFileReader.load(input);
			input.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public static String getProperty(String getProperty) {
	
	return configFileReader.getProperty(getProperty);
	}
}
