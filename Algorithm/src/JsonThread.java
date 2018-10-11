import java.io.*;
import java.net.*;
import java.util.*;

import org.json.*;

public class JsonThread extends Thread{
	public void run() {
		StringBuilder sBuffer = new StringBuilder();
		String json="";
		ArrayList<String> data = new ArrayList<String>();
		try {
			String urlAddr =
"http://apis.daum.net/search/book?apikey=465b06fae32febacbc59502598dd7685&output=json&q=java";
			URL url = new URL(urlAddr);
			
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			if (conn != null) {
				conn.setConnectTimeout(20000);
				conn.setUseCaches(false);
				if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
					InputStreamReader isr = new InputStreamReader(
							conn.getInputStream());
					BufferedReader br = new BufferedReader(isr);

					while (true) {
						String line = br.readLine();
						if (line == null) {
							break;
						}
						sBuffer.append(line);
					}
					br.close();
					conn.disconnect();
				}
			}
			json = sBuffer.toString();
		} catch (Exception e) {
			System.out.println("가져오기 실패:" + e.getMessage());
		}
		try {
			System.out.println(json);
			JSONObject obj = new JSONObject(json);
			JSONObject channel = obj.getJSONObject("channel");
			JSONArray items = channel.getJSONArray("item");
			for (int i = 0; i < items.length(); i++) {
				JSONObject book = items.getJSONObject(i);
				data.add("저자:" + book.getString("author") + ",제목:"
						+ book.getString("title"));
			}
			
		}
		catch (Exception e) {
			System.out.println("파싱 실패:" + e.getMessage());
		}
		System.out.println(data);
	}
}
