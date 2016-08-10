package com.MyServlet.pkg;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class SubString {
	
	ArrayList<Double> Lat_list(String filter){
	Connection conn = null;
	
    String url = "";
    String userName = "";
    String passw = "";
    PreparedStatement pst = null;
    ResultSet rs;
    int i = 0,j,k=0;
    String[] res;
    ArrayList<Double> LatList = new ArrayList<Double>();
    ArrayList<String> subString = new ArrayList<String>();
    
    try{    
        
Class.forName("com.mysql.jdbc.Driver");
    conn = DriverManager.getConnection(url, userName, passw);
    
    pst = conn.prepareStatement("");
String sql ="select User_Name,Latitude, Longitude, Text_data from TWEET_TABLE";
    pst.executeQuery(sql);
    rs = pst.getResultSet();
//    String filter = "today";
    while(rs.next()){
    	j=0;
    	
    	String str = rs.getString("Text_data");
//    	System.out.println(str);
    	
    	res = split_string(str);
    	while(j<res.length){
    	if(filter.equalsIgnoreCase(res[j])){
    		LatList.add(k,rs.getDouble("Latitude"));
    		k++;
    		break;
    	}
    	subString.add(i, res[j]);
    	j++;
    	i++;
    	}
    	
    	//String strAdd;
//    	if(str.substring(str.indexOf("#"), str.indexOf("\\s")).length() > 1){
//    		strAdd = str.substring(str.indexOf("#"), str.indexOf("\\s"));
//        	System.out.println("Test");
//        	subString.add(i,strAdd); 
//        	i++;
//    	}
    	
    	
    	
//    	System.out.println("Test");
    	}
    System.out.println("Number of latitudes: "+LatList.size());
    
    
    //new google.maps.LatLng();
    rs.close();pst.close(); 
//    System.out.println(subString.size());
    
//    Iterator iterator = wordCount.keySet().iterator();
//    
//    while (iterator.hasNext()) {
//       String key = iterator.next().toString();
//       String value = wordCount.get(key).toString();
//      
//       System.out.println(key + " " + value);
//    }
    }catch(Exception e)
    {
    	e.printStackTrace();
    }
	return LatList;
    }

	ArrayList<Double> Long_List(String filter){
		Connection conn = null;
	    String url = "";
	    String userName = "";
	    String passw = "";
	    PreparedStatement pst = null;
	    ResultSet rs;
	    int i = 0,j,k=0;
	    String[] res;
	    ArrayList<Double> LongList = new ArrayList<Double>();
	    ArrayList<String> subString = new ArrayList<String>();
	    
	    try{    
	        
	    	Class.forName("com.mysql.jdbc.Driver");
	    	    conn = DriverManager.getConnection(url, userName, passw);
	    	    pst = conn.prepareStatement("");
	    	String sql ="select User_Name,Latitude, Longitude, Text_data from TWEET_TABLE";
	    	    pst.executeQuery(sql);
	    	    rs = pst.getResultSet();
//	    	    String filter = "today";
	    	    while(rs.next()){
	    	    	j=0;
	    	    	
	    	    	String str = rs.getString("Text_data");
//	    	    	System.out.println(str);
	    	    	
	    	    	res = split_string(str);
	    	    	while(j<res.length){
	    	    	if(filter.equalsIgnoreCase(res[j])){
	    	    		
	    	    		LongList.add(k,rs.getDouble("Longitude"));
	    	    		k++;
	    	    		break;
	    	    	}
	    	    	subString.add(i, res[j]);
	    	    	j++;
	    	    	i++;
	    	    	}
	    	    	
	    	    	//String strAdd;
//	    	    	if(str.substring(str.indexOf("#"), str.indexOf("\\s")).length() > 1){
//	    	    		strAdd = str.substring(str.indexOf("#"), str.indexOf("\\s"));
//	    	        	System.out.println("Test");
//	    	        	subString.add(i,strAdd); 
//	    	        	i++;
//	    	    	}
	    	    	
	    	    	
	    	    	
//	    	    	System.out.println("Test");
	    	    	}
	    	    System.out.println("Number of Longitude: "+LongList.size());
	    	    
	    	    
	    	    //new google.maps.LatLng();
	    	    rs.close();pst.close(); 
//	    	    System.out.println(subString.size());
	    	    Map<String, Integer> wordCount = count(subString);
//	    	    Iterator iterator = wordCount.keySet().iterator();
	    	//    
//	    	    while (iterator.hasNext()) {
//	    	       String key = iterator.next().toString();
//	    	       String value = wordCount.get(key).toString();
//	    	      
//	    	       System.out.println(key + " " + value);
//	    	    }
	    	    }catch(Exception e)
	    	    {
	    	    	e.printStackTrace();
	    	    }
		return LongList;
		
	}

	
	static String[] split_string(String str){
		String[] res = str.split("\\s");
//		for(int i=0; i< res.length; i++)
//		System.out.println(res[i]);
		
	return res;
		
		
	}
	static Map<String, Integer> count(ArrayList<String> wordList) throws IOException{
		Map<String, Integer> wordCount = new HashMap<String, Integer>();

		for(String word: wordList) {
		  if(word.length()>=5){
			  Integer count = wordCount.get(word);          
			  wordCount.put(word, (count==null) ? 1 : count+1);
		  }
		  
		}
		
			
			
//		PrintWriter writer = new PrintWriter(new FileWriter("Count.csv", true));
//		Iterator iterator = wordCount.keySet().iterator();
//	    
//	    while (iterator.hasNext()) {
//	       String key = iterator.next().toString();
//	       Integer value = wordCount.get(key);
//	       writer.println(key+","+value);
//	       //System.out.println(key + " " + value);
//	    }
//		
//	    writer.close();
		
		
		return wordCount;
	}
}
