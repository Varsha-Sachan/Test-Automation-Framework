package com.utility;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.pojo.User;

public class CSVReaderUtility {
	public static Iterator<User> readCsvFile(String FileName) {
		File file = new File(System.getProperty("user.dir") + "\\testData\\" +FileName);
		FileReader filereader = null;
		CSVReader reader = null;
		String[] line;
		User userdata;
		List <User> userList=null;

		try {
			filereader = new FileReader(file);
			reader = new CSVReader(filereader);
			reader.readNext();// it will us row-1 coloumn information
//			reader.readNext();// it will give us row 2
//			reader.readNext(); //it will give row 3
//			data=reader.readNext();//Row 4 [if there is no row in CsV file and reached at the end of file then it will return Null
		
			userList = new ArrayList<User >();
			while((line= reader.readNext())!=null) {
			 userdata=new User(line[0],line[1]);
				userList.add(userdata);
			}
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (CsvValidationException | IOException e) {

			e.printStackTrace();
		}
return userList.iterator();
	}
}
