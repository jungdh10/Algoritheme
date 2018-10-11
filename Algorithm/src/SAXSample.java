
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
public class SAXSample
{
	List<Blog> list = new ArrayList<Blog>();
	public void parse() throws Exception
	{
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		SimpleHandler handler = new SimpleHandler(list);
		parser.parse("https://apis.daum.net/search/blog?apikey=465b06fae32febacbc59502598dd7685&q=%EC%82%BC%EA%B5%AD%EC%A7%80&output=xml", handler);
		for(Blog blog : list){
			System.out.println(blog);
		}
	}
}
