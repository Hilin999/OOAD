package myservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import SQLconnection.DbUtil;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class searchGuitar
 */
@WebServlet("/searchGuitar")
public class searchGuitar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchGuitar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		System.out.println(request.getParameter("sendData"));
		String[] arg=request.getParameter("sendData").split(",");

		Map<String, String> select=new HashMap<String,String>();	
		StringBuffer sbsql=new StringBuffer("select * from guitars where 1=1");
		for (int i = 0; i < arg.length; i++) {
		String[] myarg=arg[i].substring(arg[i].indexOf("{\"")+2, arg[i].indexOf("\"}")+1).split("\":");
			select.put(myarg[0], myarg[1]);
			sbsql.append(" and ").append(myarg[0]).append(" like ").append(myarg[1]);
		}
		System.out.println(sbsql.toString());
		String j = "{\"rows\": [";
		Connection conn=DbUtil.getConnection();
		try {
		
		PreparedStatement stmt = conn.prepareStatement(sbsql.toString());
		ResultSet rs= stmt.executeQuery();
		while(rs.next()) {
				j += "{";				
				j += "\"serialNumber\": \"" + rs.getString("serialNumber") + "\", ";
				j += "\"price\": \"" + rs.getString("price") + "\", ";
				j += "\"builder\": \"" + rs.getString("builder") + "\", ";
				j += "\"model\": \"" + rs.getString("model") + "\", ";
				j += "\"type\": \"" + rs.getString("type") + "\", ";
				j += "\"backWood\": \"" + rs.getString("backWood") + "\", ";
				j += "\"topWood\": \"" + rs.getString("topWood") + "\"";
				j += "}";
				j += ", ";
			}		
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		if (j != "{\"rows\": [") {
			j = j.substring(0, j.length() - 2);
		}
		j += "]}";

		System.out.println(j);
		
		response.setContentType("text/x-json");
		
		PrintWriter printWriter=response.getWriter();
		printWriter.write(j);
		printWriter.close();
	
	}

}
