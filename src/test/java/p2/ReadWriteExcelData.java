package p2;

import java.io.IOException;

import utils.ExcelUtils;

public class ReadWriteExcelData extends ExcelUtils {

	public static void main(String[] args) throws IOException {
		getRowCount();
		getCellData_String();
		getCellData_Integers();
		
	}

}
