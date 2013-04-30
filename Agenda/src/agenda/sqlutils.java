/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;
import java.sql.*;

/**
 *
 * @author SANTIAGO MARTINEZ MONAÑO
 */
public class sqlutils {
	Connection conexion;
    sqlutils(){
    	try{
    		Class.forName("com.mysql.jdbc.Driver");
    		this.conexion = DriverManager.getConnection ("jdbc:mysql://localhost/agendacomercial","root", "v21a2002");
    		//this.st = conexion.createStatement();
    	}
    	catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public ResultSet consulta(String query){
    		ResultSet resultado;
            try {
                Statement sentencia = this.conexion.createStatement();//ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY
                resultado = sentencia.executeQuery(query);
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }        return resultado;
    }
    
    void closebd(){
    	try{
    		//this.st.close();
    		this.conexion.close();
    	}
    	catch (Exception e){
    		e.printStackTrace();
    	}
    }
}
