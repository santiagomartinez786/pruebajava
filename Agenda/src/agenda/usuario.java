package agenda;
import agenda.sqlutils;
import java.sql.*;
public class usuario extends sqlutils{
	private String usuario;
    private int modo;
    usuario(){
    	super();
    	this.usuario="";
    	this.modo=-1;
    }
    public String getUsuario(){
        return this.usuario;
    }
    
    public int getModo(){
        return this.modo;
    }
    
    public void setUsuario(String usuario){
        this.usuario=usuario;
    }
    
    public void setModo(int modo){
        this.modo=modo;
    }
    
    public boolean ulogin(int user,String pass) throws SQLException{
    	ResultSet resultquery= this.consulta("select * from usuario where dni='"+user+"' and pass='"+pass+"'");
    	int dni;
    	String passquery;
    	boolean res=false;
    	if (resultquery != null && resultquery.next()){
    		dni = resultquery.getInt("dni");
    		passquery=resultquery.getString("pass");
    		if((dni==user)&&(passquery.equals(pass))){
    			res=true;
    			this.setModo(resultquery.getInt("modo"));
    			String nombre=resultquery.getString("nombre");
    			String apellidos=resultquery.getString("apellidos");
    			this.setUsuario(nombre+" "+apellidos);
    		}
    	}
    	return res;
    }
    
}