package com.sode.utils;

import java.io.InputStreamReader;
import java.util.List;

import org.springframework.core.io.ClassPathResource;

import com.opencsv.CSVReader;

public class Data {

	public static List<String[]> loadCSV(ClassPathResource file) {
		
		try(CSVReader fileReader = new CSVReader(new InputStreamReader(file.getInputStream()))) { 
			List<String[]> data = fileReader.readAll();
			
			fileReader.close();
			return data;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}