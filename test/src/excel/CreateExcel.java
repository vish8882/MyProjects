package excel;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFPrintSetup;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

//import com.highmark.ebt.util.HMUtilFonts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
public class CreateExcel {

	public static void main(String[] args) {
		
		
		HSSFWorkbook workbook= new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("Test");
		HSSFRow row=null;
		HSSFCell cell = null;
		
		row=sheet.createRow(0);
		cell =row.createCell((short)0);
		cell.setCellValue("CC Payments");
		
		row=sheet.createRow(1);
		cell =row.createCell((short)2);
		cell.setCellValue("CC Payments EBOTPT");
		
		cell =row.createCell((short)3);
		cell.setCellValue("CC Payments in BCPMT");
		
		cell =row.createCell((short)4);
		cell.setCellValue("TOTAL");
		String cards[] = {"American Express","Discover Card","Master Card", "Visa", "NP","PP","SP"};
		for (int i =0; i<=6;i++)
		{
		row=sheet.createRow(i+2);
		cell =row.createCell((short)0);
		
		cell.setCellValue(cards[i]);
		}
		
	
		
		
		String reportPath= "D:/Users/lidnl0t/Downloads/Test/Test.xls";
		FileOutputStream out;
		try {
			out = new FileOutputStream("D:/Users/lidnl0t/Downloads/Test/Test.xls");
			workbook.write(out);   
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  catch (IOException i)
		{
			System.out.println(i);
		}
		
		
	
	}
}
