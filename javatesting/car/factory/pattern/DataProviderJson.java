package car.factory.pattern;

import java.io.File;
import java.io.FileReader;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class DataProviderJson {
	@DataProvider(name = "JsonParser")

	public static Object[] credentials() {

		Object[] data = null;
		// I saved the Json in a file.
		String filename = ".\\testdata\\com\\data\\json\\NewCustomer.json";
		try {
			JsonObject jObject = new JsonParser().parse(new FileReader(new File(filename))).getAsJsonObject();
			JsonArray jArray = jObject.getAsJsonArray("NewCustomer Data");
			data = new Object[jArray.size()];
			for (int i = 0; i < jArray.size(); i++) {
				System.out.println(jArray.get(i));
				data[i] = jArray.get(i);
			}

		} catch (Exception e) {

		}
		return data;

	}

	// Here we are calling the Data Provider object with its Name

	@Test(dataProvider = "JsonParser")

	public void test(Object arrays) {

		System.out.println("From test class" + arrays);

	}

}
