package com.javalaya.maven_pageobjectmodel_snapdeal.utility;

import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.github.dockerjava.transport.DockerHttpClient.Request.Method;

public class ExcelUtility {

	public static Sheet sheet;
	
	static {
		try(FileInputStream fis = new FileInputStream("snapdeal_testdata/snapdeal_td.xlsx");
				Workbook wb = WorkbookFactory.create(fis)){
			sheet = wb.getSheetAt(0);
		}catch (Exception e) {
		}
	}
	
	public static String[][] getDataToTests(Method m){
		
		int numofRows = sheet.getPhysicalNumberOfRows();
		ArrayList<String[]> allData = new ArrayList<>();
		for(int rowIndex =0;rowIndex <numofRows;rowIndex++) {
			Row row = sheet.getRow(rowIndex);
			int cellCount = row.getPhysicalNumberOfCells();
			String runStatus = row.getCell(2).getStringCellValue();
			String testName = row.getCell(1).getStringCellValue();
			if (runStatus.equalsIgnoreCase("Y") && testName.equalsIgnoreCase(m.name())) {
				ArrayList<String> eachData = new ArrayList<>();
				for(int cellIndex=3;cellIndex<cellCount;cellIndex++) {
					Cell cell = row.getCell(cellIndex);
					eachData.add(cell.getStringCellValue());
				}
				eachData.add(rowIndex + "");
				allData.add(eachData.toArray(new String[0]));
			}
		}
		return allData.toArray(new String[][] {});
	}
}
