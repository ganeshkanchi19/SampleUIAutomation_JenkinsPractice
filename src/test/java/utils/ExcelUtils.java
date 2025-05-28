package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	static String projPath;
	static XSSFWorkbook wb;
	static XSSFSheet sheet;

	public static void main(String[] args) throws IOException {
		getRowCount();
		getCellData_String();
		getCellData_Integers();

	}

	public static void getRowCount() throws IOException {
		try {
			projPath = System.getProperty("user.dir");
			wb = new XSSFWorkbook(projPath + "/excel/Login Data.xlsx");
			sheet = wb.getSheetAt(0);
			// sheet.getLastRowNum();
			int rowcount = sheet.getPhysicalNumberOfRows();
			System.out.println("Total numbet of rows : " + rowcount);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}

	}

	public static void getCellData_String() {
		try {
			projPath = System.getProperty("user.dir");
			wb = new XSSFWorkbook(projPath + "/excel/Login Data.xlsx");
			sheet = wb.getSheetAt(0);
			String cellData = sheet.getRow(0).getCell(0).getStringCellValue();
			System.out.println(cellData);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}

	}

	public static void getCellData_Integers() {
		try {
			projPath = System.getProperty("user.dir");
			wb = new XSSFWorkbook(projPath + "/excel/Login Data.xlsx");
			sheet = wb.getSheetAt(0);
			double Celldata = sheet.getRow(0).getCell(0).getNumericCellValue();
			System.out.println(Celldata);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}

	}

}
