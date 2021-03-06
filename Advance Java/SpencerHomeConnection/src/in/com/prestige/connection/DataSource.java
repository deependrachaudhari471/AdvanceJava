package in.com.prestige.connection;

import java.sql.Connection;
import java.util.ResourceBundle;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DataSource {
    private static DataSource datasource;
    //jdbc connection pool
    private DataSource(){
    	
    }
    
    private ComboPooledDataSource cpds = null;
    
    public static DataSource getInstance(){
    	if(datasource == null){
    		ResourceBundle rb = ResourceBundle.getBundle("in.com.prestige.bundle.system");
    		datasource = new DataSource();
    		datasource.cpds = new ComboPooledDataSource();
    		try{
    			datasource.cpds.setDriverClass(rb.getString("driver"));
    		}catch(Exception e){
    			e.printStackTrace();
    		}
    		datasource.cpds.setJdbcUrl(rb.getString("url"));
    		datasource.cpds.setUser(rb.getString("username"));
    		datasource.cpds.setPassword(rb.getString("password"));
    	}
    	return datasource;
    }
    
    //get the connecton form combopoolDataSource
    
    public static Connection getConnection() throws Exception {
    	 return getInstance().cpds.getConnection();
    }
    
    public static void closeConnection(Connection conn){
    	if(conn != null){
    		try{
    			conn.close();
    		}catch(Exception e){
    			e.printStackTrace();
    		}
    	}
    }
    
    //RollBack
    public static void txnRollBack(Connection conn) throws Exception{
    	if(conn != null){
    		try{
    		conn.rollback();
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	}
    }
}

