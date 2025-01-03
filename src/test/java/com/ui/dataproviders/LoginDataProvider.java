package com.ui.dataproviders;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.testng.annotations.DataProvider;

import com.google.gson.Gson;
import com.ui.pojo.TestData;
import com.ui.pojo.User;
import com.utility.CSVReaderUtility;
import com.utility.ExcelReaderUtility;

public class LoginDataProvider {
	@DataProvider(name = "LoginTestDataProvider")
	public Iterator<Object[]> LoginDataProvider() throws FileNotFoundException {

		Gson gson = new Gson();
		File testDataFile = new File(System.getProperty("user.dir") + "\\TestData\\loginData.json");

		FileReader filereader = new FileReader(testDataFile);
		TestData data = gson.fromJson(filereader, TestData.class);
		List<Object[]> dataToReturn = new ArrayList<Object[]>();
		for (User user : data.getData()) {
			dataToReturn.add(new Object[] { user });
		}
		return dataToReturn.iterator();
	}
	
	@DataProvider(name="LoginTestCSVDataProvider")
public Iterator<User> logincsvdataprovider() {
	return CSVReaderUtility.readCsvFile("loginData.csv");
		
}
	@DataProvider(name="LoginTestExcelDataProvider")
public Iterator<User> loginexceldataprovider() {
	return ExcelReaderUtility.readExcelFile("LoginData.xlsx");
		
}
	
}