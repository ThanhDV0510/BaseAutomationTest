package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * ExcelFileController class used to manage actions with Excel file like open ,
 * close , write , read excel
 * 
 * @author lam vu duc
 * @date 023-Octorber-2014
 */
public class ExcelControllerXLSX  {

	public XSSFSheet ExcelWSheet;

	public XSSFWorkbook ExcelWBook;

	public XSSFCell Cell;

	public XSSFRow Row; 
	
	

	/**
	 * Get Excel File at known path
	 * 
	 * @author lam vu duc
	 * @date 17-July-2020
	 * @param excelFilePath
	 */
	public XSSFWorkbook getExcelFile(String excelFilePath)  {
		try {
			// Open excel file
			FileInputStream excelfile = new FileInputStream(new File(
					excelFilePath));

			// Access data required test
			try {
				ExcelWBook = new XSSFWorkbook(excelfile);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return ExcelWBook;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return ExcelWBook;
		}

	}

	/**
	 * Get A Sheet from Excel File , locating Sheet by Name
	 * 
	 * @author lam vu duc
	 * @date 023-Octorber-2014
	 * @param ExcelBook
	 *            , represent Excel file
	 * @param nameSheet
	 *            ,name of sheet in that excel file
	 * @return XSSFSheet, a sheet in that Excel file
	 */
	public XSSFSheet getSheetFromExcelFile(XSSFWorkbook ExcelBook,
			String nameSheet) {

		try {
			XSSFSheet sheet = ExcelBook.getSheet(nameSheet);
			return sheet;
		} catch (Exception ex) {
			System.out.print("Name of Sheet is not Correct,..Please input again !");
			return null;
		}

	}

	/**
	 * Get a Row from Sheet
	 * 
	 * @author lam vu duc
	 * @date 023-Octorber-2014
	 * @param sheet
	 *            in Excel file
	 * @param indexRow
	 *            ,index of Row in that sheet
	 * @return XSSFRow, a Row in that sheet
	 */
	public XSSFRow getRowFromSheet(XSSFSheet sheet, int indexRow) {
		int numberRows = sheet.getLastRowNum() - sheet.getFirstRowNum();
		XSSFRow Row = null;

		if (indexRow <= numberRows) {
			Row = sheet.getRow(indexRow);
			return Row;
		} else {

			try {
				throw (new Exception(
						" index of Row is not correct! Please input index of row is not bigger than "
								+ getNumberRowsFromSheet(sheet)));
			} catch (Exception e) {
				e.printStackTrace();
			}

			return Row;
		}
	}

	/**
	 * Get A Cell From Sheet , locating by index of Row
	 * 
	 * @author lam vu duc
	 * @date 023-Octorber-2014
	 * @param sheet
	 *            in Excel file
	 * @param indexRow
	 *            ,index of Row in that sheet
	 * @param indexColumn
	 *            , index of Column from that sheet
	 * @return XSSFCell, a Cell in that sheet
	 */
	public XSSFCell getCellFromSheet(XSSFSheet sheet, int indexRow,
			int indexColumn) {
		XSSFCell Cell = null;
		XSSFRow Row = getRowFromSheet(sheet, indexRow);
		Cell = Row.getCell(indexColumn);
		return Cell;

	}

	/**
	 * Get A Column , locating by index of Cell in a Row
	 * 
	 * @author lam vu duc
	 * @date 23-Octorber-2014
	 * @param sheet
	 *            in Excel file
	 * @param indexColumn
	 *            , index of Column from that sheet
	 * @return List<XSSFCell>, a total of Cells which have same index of column
	 *         in that sheet
	 */
	public List<XSSFCell> getColumnFromSheet(XSSFSheet sheet, int indexColumn) {
		int rows = getNumberRowsFromSheet(sheet);
		List<XSSFCell> list = new ArrayList<XSSFCell>();

		XSSFCell cell;

		for (int i = 0; i < rows; i++) {
			cell = getCellFromSheet(sheet, i, indexColumn);
			list.add(i, cell);
		}
		return list;
	}

	/**
	 * Get total of row in sheet
	 * 
	 * @author lam vu duc
	 * @date 23-Octorber-2014
	 * @param sheet
	 *            in Excel file
	 * @return int, total of rows in that sheet
	 */
	public int getNumberRowsFromSheet(XSSFSheet sheet) {
		int numberRows = sheet.getLastRowNum() - sheet.getFirstRowNum();
		return numberRows;
	}

	/**
	 * Get total of Cells in a Row
	 * 
	 * @author lam vu duc
	 * @date 23-Octorber-2014
	 * @param row
	 *            in Excel file
	 * @return int, total of cells in a row
	 */
	public int getNumberCellsFromARow(XSSFRow row) {
		int numberCells = row.getLastCellNum() - row.getFirstCellNum();
		return numberCells;
	}

	/**
	 * Write a value to a Cell in Sheet
	 * 
	 * @author lam vu duc
	 * @date 23-Octorber-2014
	 * @param excelFilepath
	 *            path of Excel file
	 * @param sheet
	 *            in Excel file
	 * @param row
	 *            in Excel file
	 * @param indexRow
	 *            index of row in Sheet
	 * @param indexColumn
	 *            index of column in sheet
	 * @param result
	 *            which need to insert into cell
	 * @param nameSheet
	 *            , name of sheet in Excel file
	 * @return void
	 */
	public void writeToCell(String excelFilepath, XSSFSheet sheet,
			String nameSheet, int indexRow, int indexColumn, String result) {
		@SuppressWarnings("unused")
		XSSFRow row = sheet.getRow(indexRow);

		XSSFCell cell = sheet.getRow(indexRow).createCell(indexColumn);
		convertCelltoString(cell);
		cell.setCellValue(result);
		FileOutputStream fs = null;
		try {
			fs = new FileOutputStream(excelFilepath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			sheet.getWorkbook().write(fs);
			fs.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Convert Cell to String format
	 * 
	 * @author lam vu duc
	 * @date 23-Octorber-2014
	 * @param cell
	 *            in Excel file
	 * @return void
	 */
	@SuppressWarnings({ "static-access", "deprecation" })
	public void convertCelltoString(XSSFCell cell) {
		cell.setCellType(Cell.CELL_TYPE_STRING);
	}

	/**
	 * Convert Cell to Numeric format
	 * 
	 * @author lam vu duc
	 * @date 23-Octorber-2014
	 * @param cell
	 *            in Excel file
	 * @return void
	 */
	@SuppressWarnings({ "static-access", "deprecation" })
	public void convertCelltoNumerric(XSSFCell cell) {
		cell.setCellType(Cell.CELL_TYPE_NUMERIC);
	}
	
	@SuppressWarnings({ "static-access", "deprecation" })
	public String checkCellType(XSSFCell cell){
		String return_cell_type = "";
		if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
			return_cell_type = new Integer((int) cell.getNumericCellValue()).toString();
		} else if (cell == null || cell.getCellType() == Cell.CELL_TYPE_BLANK) {
			return_cell_type = "";
		} else {
			return_cell_type = cell.getStringCellValue();
		}
		return return_cell_type;
	}
}
