package com.accenture.testBuyingProducts;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import cucumber.api.java.sl.Ce;

public class ReadWriteFile {

	private Iterator<Cell> celdas;
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private Iterator<Row> rows;
	private String FileName;

	public Map<Integer, List<String>> ReadFile() {
		System.out.println("Inicio lectura");
		this.FileName = "Products.xlsx";
		String ruta = System.getProperty("user.dir") + "/DataDrive/" + this.FileName;
		Map<Integer, List<String>> data = new HashMap();

		try {
			// Open Excel File
			FileInputStream file = new FileInputStream(new File(ruta));
			// Read the file
			workbook = new XSSFWorkbook(file);
			// Read sheet
			sheet = workbook.getSheetAt(0);

			int i = 0;
			for (Row row : sheet) {
				data.put(i, new ArrayList<String>());
				for (Cell cell : row) {
					switch (cell.getCellType()) {
					case 1: // String
						data.get(new Integer(i)).add(cell.getRichStringCellValue().getString());
						System.out.println(data.get(new Integer(i)).add(cell.getRichStringCellValue().getString()));
						break;
					case 2: // Empty cell
						data.get(i).add("NA");
						break;
					default: data.get(i).add("NA");
					}
				}
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Fin de lectura");
		return data;
	}

//	public Iterator<Cell> Read() {
//		// Reading
//		System.out.println("Inicio lectura");
//		String nombreArchivo = "Products.xlsx";
//		String ruta = System.getProperty("user.dir") + "/DataDrive/" + nombreArchivo;
//		Map<Integer, List<String>> data = new HashMap();
//		try {
//			// Open Excel File
//			FileInputStream file = new FileInputStream(new File(ruta));
//			// Read the file
//			XSSFWorkbook workbook = new XSSFWorkbook(file);
//			// Read sheet
//			XSSFSheet hoja = workbook.getSheetAt(0);
//			// Get rows from file
//			Iterator<Row> lineas = hoja.iterator();
//			Row row;
//			// Run each row from file
//			while (lineas.hasNext()) {
//				row = lineas.next();
//				// Get cells values
//				Iterator<Cell> celdas = row.cellIterator();
//				System.out.println(celdas);
//				System.out.println("Fin de lectura");
//				return celdas;
//			}
//		} catch (Exception e) {
//			System.err.println(e.getMessage());
//			return null;
//		}
//		return null;
//	}

}
