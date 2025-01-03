package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.ui.pojo.User;

public class ExcelReaderUtility {

	public static Iterator<User> readExcelFile(String FileName){

		Row row;
		Cell emailAddressCell;
		Cell passwordCell;
		User user;
		List<User> userList = null;
		XSSFSheet xssfsheet = null;
		Iterator<Row> rowIterator;
		File excelFile = new File(System.getProperty("user.dir") + "//testData//" + FileName);
		XSSFWorkbook xssfworkbook = null;
		try {
			xssfworkbook = new XSSFWorkbook(excelFile);
			userList = new ArrayList<User>();
			xssfsheet=xssfworkbook.getSheet("LoginTestData");
		    rowIterator = xssfsheet.iterator();
			rowIterator.next();// Skipping the column
			while (rowIterator.hasNext()) {
				row = rowIterator.next();
				emailAddressCell = row.getCell(0);
				passwordCell = row.getCell(1);
				user = new User(emailAddressCell.toString(), passwordCell.toString());
				userList.add(user);
				//System.out.println(userList.add(user));
				xssfworkbook.close();
			}
		} catch (InvalidFormatException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		return userList.iterator();

	}
}
