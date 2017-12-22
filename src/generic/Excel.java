package generic;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {
	public static String getCellValue(String path,String sheet,int r,int c) {
		String cv="";
		try {
			Workbook wb=WorkbookFactory.create(new FileInputStream(path));
			cv=wb.getSheet(sheet).getRow(r).getCell(c).toString();
		}
		catch(Exception e) {
			
		}
		return cv;
	}
	public static int getRowCount(String path,String sheet) {
		int rc=0;
		try {
			//Row values starts from 0 
			Workbook wb=WorkbookFactory.create(new FileInputStream(path));
			rc=wb.getSheet(sheet).getLastRowNum();
		}catch(Exception e) {
			
		}
		return rc;
	}
}
