package com.javalaya.maven_pageobjectmodel_snapdeal.utility;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLearning {

	public static Sheet sheet;

	static {
		try (FileInputStream fis = new FileInputStream("snapdeal_testdata/snapdeal_td.xlsx")) {
			Workbook wb = WorkbookFactory.create(fis);
			sheet = wb.getSheetAt(0);
		} catch (Exception e) {

		}
	}

	public static void getSheetName() {
		System.out.println(sheet.getSheetName());
	}

	public static void readCellData() {
		int noOfRows = sheet.getPhysicalNumberOfRows();

		for (int rowIndex = 0; rowIndex < noOfRows; rowIndex++) {
			Row row = sheet.getRow(rowIndex);
			int cellCount = row.getPhysicalNumberOfCells();
			for (int cellIndex = 0; cellIndex < cellCount; cellIndex++) {
				Cell cell = row.getCell(cellIndex);
				System.out.print(cell.getStringCellValue() + "\t");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		getSheetName();
		readCellData();
	}
}

