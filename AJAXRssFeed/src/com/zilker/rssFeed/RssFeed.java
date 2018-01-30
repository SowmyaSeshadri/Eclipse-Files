package com.zilker.rssFeed;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.json.*;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import com.mysql.jdbc.Constants;

public class RssFeed {

	public static JSONObject getFeed(String domain) throws IOException, ParserConfigurationException, SAXException {
	
		System.out.println("HELLO");
		String stringParsed = "";
		JSONArray array=null;
		URL url;
		InputStream is = null;
		String stringRetrieved;

		String stringUrl = getDomain(domain);
		url = new URL(stringUrl);

		is = url.openStream(); 
		 
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
		JSONObject xmlJSONObj = null;
		while ((stringRetrieved = bufferedReader.readLine()) != null) {
			//System.out.println(stringRetrieved);
			stringParsed += stringRetrieved;
		}

		try {
			 xmlJSONObj = XML.toJSONObject(stringParsed);
			
		} catch (JSONException je) {
			System.out.println(je.toString());
		}
	
		return xmlJSONObj;

	}

	public static String getDomain(String domain) {
		if(domain.equals("technology")) {
			return com.zilker.rssFeed.constants.Constants.TECHURL;
		}
		if(domain.equals("india")) {
			 return com.zilker.rssFeed.constants.Constants.INDIAURL;
		}
		if(domain.equals("sports")) {
		  return com.zilker.rssFeed.constants.Constants.SPORTSURL;
		}
		if(domain.equals("world")) {
			return com.zilker.rssFeed.constants.Constants.WORLDURL;
		}
		if(domain.equals("entertainment")) {
			return com.zilker.rssFeed.constants.Constants.ENTURL;
		}
		return domain;
	}
	
	/*public static ArrayList<News> getNews(JSONArray jsonArray) throws JSONException{
		ArrayList<News> arrayList = new ArrayList<News>();
		for(int i=0;i< jsonArray.length();i++)
		{
		JSONObject jsonObj=(JSONObject) jsonArray.get(i);
		String title = jsonObj.get("title").toString();
		String link = jsonObj.get("link").toString();
		String pubDate = jsonObj.get("pubDate").toString();
		
		News news = new News(title,link,pubDate);
		arrayList.add(news);
		}
		
		return arrayList;
		
	}
	*/
	
}
