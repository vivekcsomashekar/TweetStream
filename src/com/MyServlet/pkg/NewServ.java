package com.MyServlet.pkg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.MyServlet.pkg.SubString;
import com.google.gson.Gson;

/**
 * Servlet implementation class NewServ
 */
@WebServlet("/NewServ")
public class NewServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		double latitude = 21.2222;
		double longitude = 32.3454;
		int i=0;
		SubString object = new SubString();
		ArrayList<Double> LatList = new ArrayList<Double>();
		ArrayList<Double> LongList = new ArrayList<Double>();
		String filter = request.getParameter("trends");
		LatList = object.Lat_list(filter);
		LongList = object.Long_List(filter);
		System.out.println("test");
	    
//		for( i=0;i<10;i++){
//			LatList.add(i, 10.00323+i);
//			LongList.add(i, 24.32443+i);
//		}
//		PrintWriter out=response.getWriter();
//	    response.setContentType("text/html");
//	    Connection conn = null;
//	    String url = "jdbc:mysql://localhost/TWEETMAP";
//	    String userName = "root";
//	    String passw = "ivek280991";
//	    PreparedStatement pst = null;
//	    ResultSet rs;
//	    try{    
//            
//    Class.forName("com.mysql.jdbc.Driver");
//        conn = DriverManager.getConnection(url, userName, passw);
//        pst = conn.prepareStatement("");
//    String sql ="select User_Name,Latitude, Longitude, Text_data from Tweet_Table";
//        pst.executeQuery(sql);
//        rs = pst.getResultSet();
//       outerloop:
//        while(rs.next()){
//        	
//        	LatList.add(i, rs.getDouble("Latitude"));
//        	
//			LongList.add(i, rs.getDouble("Longitude"));
//			i++;
//        	   while(i==1000){
//        		   break outerloop;
//        	   }   	
//        	}
//        //new google.maps.LatLng();
//        rs.close();pst.close(); 
//       
//        }
//    catch(Exception e){System.out.println("Exception is;"+e);}
		Map<String, ArrayList<Double>> map = new HashMap<String, ArrayList<Double>>();
		map.put("lat",LatList);  
		map.put("long",LongList);  

		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		response.getWriter().write(new Gson().toJson(map));
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
