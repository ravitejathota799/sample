package com.TripAdvisor.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.text.DateFormatter;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataReader {
	public static FileInputStream fi;	//declaring fileinput stream variable
	public static FileOutputStream fo;	//declaring fileoutput stream variable
	public static XSSFWorkbook wb;		//declaring workbook variable
	public static XSSFSheet ws;			//declaring sheet variable
	public static XSSFRow row;			//declaring row variable
	public static XSSFCell cell;		//declaring cell variable
	public static CellStyle style;
	
	//method for getting the row count using xlfile and xlsheet
	public static int getRowCount(String xlfile, String xlsheet) throws IOException {
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		int rowcount = ws.getLastRowNum();
		wb.close();
		fi.close();
		return rowcount;
	}

	//method for getting the cell count using xlfile and xlsheet
	public static int getCellCount(String xlfile, String xlsheet, int rownum) throws IOException {
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		int cellcount = row.getLastCellNum();
		wb.close();
		fi.close();
		return cellcount;
	}

	//method for getting the data  using xlfile, xlsheet,rownumber,column number
	public static String getCellData(String xlfile, String xlsheet, int rownum, int colnum) throws IOException {
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		cell = row.getCell(colnum);

		String data;
		try {
			// data=cell.toString();

			DataFormatter formatter = new DataFormatter();
			data = formatter.formatCellValue(cell);
			return data;
		} catch (Exception e) {
			data = "";
		}

		wb.close();
		fi.close();
		return data;
	}

	//method for setting the data  using xlfile, xlsheet,rownumber,column number
	public static void setCellData(String xlfile, String xlsheet, String rownum, int colnum, String data)
			throws IOException {
		try {
			fi = new FileInputStream(xlfile);
			wb = new XSSFWorkbook(fi);
			ws = wb.getSheet(xlsheet);
			row = ws.getRow(Integer.parseInt(rownum));
			if (row == null) {
				row = ws.createRow(Integer.parseInt(rownum));
				cell = row.createCell(colnum);
				cell.setCellValue(data);
				fo = new FileOutputStream(xlfile);
				wb.write(fo);

			} else {
				cell = row.createCell(colnum);
				cell.setCellValue(data);
				fo = new FileOutputStream(xlfile);
				wb.write(fo);
			}
			wb.close();
			fi.close();
			fo.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	//method for filling the cell with green color using xlfile, xlsheet,rownumber,column numbe
	public static void fillGreenColor(String xlfile, String xlsheet, int rownum, int colnum) throws IOException {
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		cell = row.getCell(colnum);

		style = wb.createCellStyle();

		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		cell.setCellStyle(style);
		fo = new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
	}

	//method for filling the cell with red color using xlfile, xlsheet,rownumber,column numbe
	public static void fillRedColor(String xlfile, String xlsheet, int rownum, int colnum) throws IOException {
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		cell = row.getCell(colnum);

		style = wb.createCellStyle();

		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

		cell.setCellStyle(style);
		fo = new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
	}

	//method for comparing the data using xlfile, xlsheet,rownumber,column numbe
	public static List CompareData(String xlfile, String xlsheet,String row, Double stockPrice) throws IOException {
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		List<String> dates = new ArrayList<String>();
		DataFormatter formatter = new DataFormatter();

		// Iterate through each row in the second column
		for (int i = Integer.parseInt(row); i < ws.getLastRowNum() + 1; i++) {
			Cell cell = ws.getRow(i).getCell(1);

			// Check if the cell is numeric and formatted as a number
			if (cell != null && cell.getCellType() == CellType.NUMERIC) {
				double cellValue = Double.parseDouble(formatter.formatCellValue(cell));

				// Compare the cell value with the stock price
				if (cellValue == stockPrice) {
					// Get the date from the first column
					Cell dateCell = ws.getRow(i).getCell(0);
					System.out.println(dateCell);
					dates.add(formatter.formatCellValue(dateCell));
					//fillGreenColor(xlfile,xlsheet,i,dateCell);
					
				}
			}
		}
		System.out.println("No matching stock price found.");
		return dates;
	}
}
