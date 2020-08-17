package util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {
	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://127.0.0.1:3306/passenger_manager?useSSL=false&serverTimezone=UTC";
			String username = "root";
			String password = "lvyang80214685";
			connection = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}


	public static void closeAll(ResultSet resultSet, Statement statement, Connection connection) {
		if(resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
	}

	public static PreparedStatement getPreparedStatement(Connection connection, String sql) {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return preparedStatement;
	}
	

	public static Statement getStatement(Connection connection) {
		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return statement;
	}
	

	public static int excuteDML(String sql, Object...objs) {
		int n = 0;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = getConnection();
			preparedStatement = getPreparedStatement(connection, sql);
			for (int i = 0; i < objs.length; i++) {
				preparedStatement.setObject(i+1, objs[i]);
			}
			n = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll(null, preparedStatement, connection);
		}
		return n;
	}
	
	public static void backup() throws IOException {
        Runtime.getRuntime().exec("C:/Windows/System32/cmd.exe /c start D:\\java\\jee-2019-12\\workspace\\PassengerTransportSystem2\\src\\util\\dbbackup.bat");
    }

    public static void restore() throws IOException {
        Runtime.getRuntime().exec("C:/Windows/System32/cmd.exe /c start D:\\java\\jee-2019-12\\workspace\\PassengerTransportSystem2\\src\\util\\dbrestore.bat");
    }
    
   

  
	


}


