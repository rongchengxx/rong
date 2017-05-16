package com.rcb.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UploadServlet extends HttpServlet {

	

	public UploadServlet() {
	   super();
	}

	public void destroy() {
	   super.destroy(); // Just puts "destroy" string in log
	   // Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	   String contentType=request.getContentType();
	   String servername=request.getServerName();
	   String realpath=request.getRealPath(servername);
	   System.out.println(contentType);

	   InputStream in=null;
	   OutputStream out=null;
	   if(contentType.indexOf("multipart/form-data")>=0){
	    in=request.getInputStream();
	    int formlength=request.getContentLength();
	    byte[] formcontent=new byte[formlength];
	    int totalread=0;
	    int nowread=0;
	    while(totalread<formlength){
	     nowread=in.read(formcontent,totalread, formlength);
	     totalread+=nowread;
	    }
	    String strcontent=new String(formcontent);
	    System.out.println(strcontent);
	    int typestart=strcontent.indexOf("Content-Type:")+14;
	    int typeend=strcontent.indexOf("\n", typestart)-1;
	    String formType=strcontent.substring(typestart, typeend);
	   if(formType.equals("image/jpeg")||formType.equals("image/gif")||formType.equals("image/pjepg")){
	     int filenamestart=strcontent.indexOf("filename=\"")+10;
	     int filenameend=strcontent.indexOf("\n",filenamestart)-2;
	     String filename=strcontent.substring(filenamestart,filenameend);
	    filename=filename.substring(filename.lastIndexOf("."));
	    Calendar calendar = Calendar.getInstance();
	     String newfilename=""+(Calendar.getInstance().get(calendar.HOUR_OF_DAY)+
	    		 Calendar.getInstance().get(calendar.MINUTE)+
	    		 Calendar.getInstance().get(calendar.SECOND));
	     newfilename=newfilename+filename;
	     realpath=realpath+"";
	     newfilename=realpath+newfilename;
	     int filestart=strcontent.indexOf("\n",typestart)+1;
	    filestart=strcontent.indexOf("\n",filestart)+1;
	     int intboundary=contentType.indexOf("boundary=")+10;
	     String strboundary=contentType.substring(intboundary);
	     int fileend=strcontent.indexOf(strboundary,filestart)-4;
	     String saveFile=strcontent.substring(filestart,fileend);
	     int contentstart=strcontent.substring(0,filestart).getBytes().length;
	     int contentend=strcontent.substring(0,fileend).getBytes().length;
	     System.out.println(saveFile);
	     File myfile=new File(realpath);
	     if(!myfile.exists()){
	      myfile.mkdirs();
	     }
	     out=new FileOutputStream(newfilename);
	     out.write(formcontent, contentstart,contentend-contentstart);
	     response.sendRedirect("show.jsp");
	    }else{
	     response.sendRedirect("error.jsp");
	    }
	   }
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	   doGet(request,response);
	}

	public void init() throws ServletException {
	   // Put your code here
	}

	}

