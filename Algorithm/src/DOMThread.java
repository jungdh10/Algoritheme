import java.io.*;
import java.net.*;
import java.util.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class DOMThread extends Thread {
	String xml;
	List<String> data = new ArrayList<String>();

	public void run() {
		StringBuilder sBuffer = new StringBuilder();
		try {
			
			String urlAddr = 
					"http://www.kma.go.kr/weather/forecast/mid-term-xml.jsp?stnId=109";
				URL url = new URL(urlAddr);
				HttpURLConnection conn = 
						(HttpURLConnection)url.openConnection();
				if (conn != null) {
					conn.setConnectTimeout(20000);
					conn.setUseCaches(false);
					if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
						InputStreamReader isr = new InputStreamReader(conn.getInputStream());
						BufferedReader br = new BufferedReader(isr);
						//줄 단위로 읽어서 sBuffer에 저장
						while(true) {
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
				//전부 읽었으면 String으로 변환
				xml = sBuffer.toString();
			} catch (Exception e) {
				System.out.println("다운로드 중 에러 발생");
			}
			if(xml != null){
				parsing(xml);
			}
			else{
				System.out.println("데이터가 없습니다.");
			}
		}
		
	private void parsing(String xml){
		try {
			if (xml != null) {
				//DOM - XML 파싱을 위한 객체를 생성
				DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				DocumentBuilder documentBuilder = factory.newDocumentBuilder();
				//문자열을 스트림으로 변환
				InputStream is = new ByteArrayInputStream(xml.getBytes());
				//파싱을 할 수 있도록 메모리에 모두 펼침
				Document doc = documentBuilder.parse(is);
				//루트를 찾아서 element에 저장
				Element element = doc.getDocumentElement();
				//tmx 태그를 전부 찾아서 items에 저장
				NodeList items = element.getElementsByTagName("tmx");
				int n = items.getLength();
				
				//items를 순회하면서 태그 안의 첫번째 값을 찾아서 data에 추가
				for (int i = 0; i < n; i++) {
					Node item = items.item(i);
					Node text = item.getFirstChild();
					String itemValue = text.getNodeValue();
					data.add(itemValue);
				}
			}
		} catch (Exception e) {
			System.out.println("파싱 중 에러 발생");
		}
		//리스트에 저장된 모든 문자열을 출력
		System.out.println(data);
	}
}
