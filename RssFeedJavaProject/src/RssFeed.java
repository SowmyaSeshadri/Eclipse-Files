
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.json.*;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class RssFeed {

	public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
	
		String stringParsed = "";

		URL url;
		InputStream is = null;
		String stringRetrieved;

		url = new URL("https://news.google.com/news/rss/?ned=in&gl=IN&hl=en-IN");

		is = url.openStream(); 
		 
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));

		while ((stringRetrieved = bufferedReader.readLine()) != null) {
			//System.out.println(stringRetrieved);
			stringParsed += stringRetrieved;
		}

		try {
			JSONObject xmlJSONObj = XML.toJSONObject(stringParsed);
			JSONObject object1 =(JSONObject)  xmlJSONObj.get("rss");
			JSONObject object2=(JSONObject) object1.get("channel");
			JSONArray array=(JSONArray) object2.get("item");
			for(int i=0;i<array.length();i++) {
			JSONObject object3=(JSONObject) array.get(i);
			System.out.println(object3.get("title"));
			System.out.println(object3.get("link"));
			}
			//String jsonString = xmlJSONObj.toString(4);
			//System.out.println(jsonString);
		} catch (JSONException je) {
			System.out.println(je.toString());
		}

	}

}
