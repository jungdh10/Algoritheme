

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonMain {

	public static void main(String[] args) {
		SAXSample example = new SAXSample();
		try
		{
			example.parse();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}


	}
}
