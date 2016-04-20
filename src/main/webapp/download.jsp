<%@page language="java" contentType="application/x-msdownload" pageEncoding="gb2312"%> 

<%
 
 try { 
 			out.clear();//可以加也可以不加 
		  	out = pageContext.pushBody();
		  	response.setContentType("application/x-download"); 
		 	String down_url = request.getParameter("down_url"); 
		 	//System.out.println("down_url============="+down_url);
		 	
			//String id = request.getParameter("id"); 
			int t = down_url.indexOf("/");
			String filename = down_url.substring(t+1,down_url.length());
			//System.out.println("filename============="+filename);
			response.addHeader("Content-Disposition","attachment;filename=" + filename);   
            java.net.URL url = new java.net.URL(down_url);
            java.net.HttpURLConnection connection = (java.net.HttpURLConnection) url.openConnection();
            java.io.DataInputStream in = new java.io.DataInputStream(connection.getInputStream());
            
            java.io.OutputStream outs =null;// new java.io.DataOutputStream(new java.io.FileOutputStream("d:/zhs/my.doc"));
              
            byte[] buffer = new byte[4096];
            int count = 0;
            while ((count = in.read(buffer)) > 0) {
                outs=response.getOutputStream();   	
                outs.write(buffer, 0, count);
            }
            outs.close();
            in.close();
            

        } catch (Exception e) {
            System.out.println(e); 
        }
  
%> 
