package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.constants.Env;
import com.google.gson.Gson;
import com.ui.pojo.Config;
import com.ui.pojo.Environments;

public class JSONUtility {
// practice 2 to 3 times this code
	public static Environments readJson(Env env) {
			Gson gson = new Gson();
		File jsonfile = new File(System.getProperty("user.dir") + "\\config\\config.json");
		System.out.println(jsonfile);
		FileReader filereader = null;
		try {
			filereader = new FileReader(jsonfile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Config config = gson.fromJson(filereader, Config.class);
		Environments environment = config.getEnvironments().get("QA");
		return environment;

	}

}
