package genericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * this class has method to  fetch data from excel sheet 
 * @author DELL
 *
 */
public class ExcelUtility 
{
	/**
	 * this method will fetch string data from excel sheet
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public String fetchStringDataFromExcelSheet(String sheetName, int rowNo, int cellNo) throws EncryptedDocumentException, FileNotFoundException, IOException
	{
		
		return WorkbookFactory.create(new FileInputStream(IPathConstant.EXCEL_FILE_PATH)).getSheet(sheetName).getRow(rowNo).getCell(cellNo).getStringCellValue();
	}
	/**
	 * this method will fetch numeric data from excel sheet
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public double fetchNumericDataFromExcelSheet(String sheetName, int rowNo, int cellNo) throws EncryptedDocumentException, FileNotFoundException, IOException
	{
		
		return WorkbookFactory.create(new FileInputStream(IPathConstant.EXCEL_FILE_PATH)).getSheet(sheetName).getRow(rowNo).getCell(cellNo).getNumericCellValue();
	}
	/**
	 * this method will fetch boolean data from excel sheet
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public boolean fetchBooleanDataFromExcelSheet(String sheetName, int rowNo, int cellNo) throws EncryptedDocumentException, FileNotFoundException, IOException
	{
		
		return WorkbookFactory.create(new FileInputStream(IPathConstant.EXCEL_FILE_PATH)).getSheet(sheetName).getRow(rowNo).getCell(cellNo).getBooleanCellValue();
	}
	/**
	 * this method will fetch date data from excel sheet
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public String fetchDateDataFromExcelSheet(String sheetName, int rowNo, int cellNo) throws EncryptedDocumentException, FileNotFoundException, IOException
	{
		
		return WorkbookFactory.create(new FileInputStream(IPathConstant.EXCEL_FILE_PATH)).getSheet(sheetName).getRow(rowNo).getCell(cellNo).getLocalDateTimeCellValue().toString().substring(0,10);
	}

}
