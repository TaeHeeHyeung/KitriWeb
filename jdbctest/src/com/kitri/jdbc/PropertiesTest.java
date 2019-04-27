package com.kitri.jdbc;

import java.io.*;
import java.util.Properties;

public class PropertiesTest {

	public static void main(String[] args) {
		Properties prop = new Properties();
		try {
			prop.load(new FileReader(new File("src\\com\\kitri\\jdbc\\test.properties")));
			System.out.println(prop.getProperty("name_kor"));
			System.out.println(prop.getProperty("name_cn"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
