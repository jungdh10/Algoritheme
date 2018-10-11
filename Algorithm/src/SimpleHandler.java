import java.util.*;

import org.xml.sax.*;
import org.xml.sax.helpers.*;

class SimpleHandler extends DefaultHandler {
	private List<Blog> list;
	private Blog aBlog;
	private StringBuilder sb;

	public SimpleHandler(List<Blog> list) {
		super();
		this.list = list;
	}

	
	public void startElement(String uri, String localName, String qName, Attributes atts) {
		if (qName.equals("item")) {
			aBlog = new Blog();
		}
	}

	public void endElement(String uri, String localName, String qName) {
		if (qName.equals("item")) {
			list.add(aBlog);
			aBlog = null;
		} else if (aBlog != null && qName.equals("title") && sb!=null) {
			aBlog.setTitle(sb.toString());
		} else if (aBlog != null && qName.equals("description")) {
			aBlog.setDescription(sb.toString());
		} else if (aBlog != null && qName.equals("link")) {
			aBlog.setLink(sb.toString());
		} 
		if (qName.equals("channel"))
			return;
		sb = null;
	}

	
	public void characters(char[] chars, int start, int length) {
		if (aBlog != null && sb == null)
			sb = new StringBuilder(new String(chars, start, length));
		else if (aBlog != null && sb != null)
			sb.append(new String(chars, start, length));
	}
}
