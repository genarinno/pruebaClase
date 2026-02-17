package repositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BaseDatos 
{
	// Constructores
	// -------------
	
	public BaseDatos(String pURL)
	{
		this.url = pURL;
	}
	public BaseDatos(String pHost, int pPuerto, String pUsuario, String pPassword, String pCatalogo)
	{
		this.url = "jdbc:oracle:thin:" + pUsuario + "/" +pPassword + "@" + pHost + ":" + pPuerto + "/" +pCatalogo;
	}
	
	// Campos
	// ------
	
	private String url;
	public Connection conexion;
	public PreparedStatement ps;
	public Statement st;
	public String sql;
	public int cantidad;
	public ResultSet rs;
	
	// Metodos
	// -------
	public void conectar() throws ClassNotFoundException, SQLException
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		this.conexion = DriverManager.getConnection(this.url);
	}
	
	public void desconectar() throws SQLException
	{
		this.conexion.close();
	}
	
}
