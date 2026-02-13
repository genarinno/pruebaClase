package repositorio;

import java.sql.SQLException;
import java.util.ArrayList;

import modelos.ProductoModelo;

public class ProductoRepositorio extends BaseDatos implements ICrud<Integer, ProductoModelo>//El envolvente no admite primitivos int => Integer
{

	
	// Constructores
	// -------------
	public ProductoRepositorio(String pURL) 
	{
		super(pURL);
	}

	public ProductoRepositorio(String pHost, int pPuerto, String pUsuario, String pPassword, String pCatalogo) 
	{
		super(pHost, pPuerto, pUsuario, pPassword, pCatalogo);
	}

	@Override
	public ProductoModelo leer(Integer id) throws Exception 
	{
		ProductoModelo productoModelo;
		
		sql = """
				SELECT IDPRODUCTO, NOMBRE, PRECIO, STOCK 
				FROM PRODUCTO
				WHERE IDPRODUCTO = ?;		
			  """;
		ps = conexion.prepareStatement(sql);
		ps.setInt(1, id);
		
		rs = ps.executeQuery();
		
		//Nos situamos en la primera dila de datos
		if(rs.next() == true)
		{
			productoModelo = new ProductoModelo();
			
			productoModelo.setIdProducto(rs.getInt("IDPRODUCTO"));
			productoModelo.setNombre(rs.getString("NOMBRE"));
			productoModelo.setPrecio(rs.getFloat("PRECIO"));
			productoModelo.setStock(rs.getInt("STOCK"));
		}
		else 
		{
			productoModelo = null;
		}
		
		return productoModelo;
	}

	@Override
	public ArrayList<ProductoModelo> listar() throws Exception 
	{
		ArrayList<ProductoModelo> productos = new ArrayList<ProductoModelo>();
		ProductoModelo modelo;
		
		sql = """
				SELECT IDPRODUCTO, NOMBRE, PRECIO, STOCK 
				FROM PRODUCTO
			  """;
		
		st = conexion.createStatement();
		rs = st.executeQuery(sql);
		
		while(rs.next() == true)
		{
			modelo = new ProductoModelo();
			
			modelo.setIdProducto(rs.getInt("IDPRODUCTO"));
			modelo.setNombre(rs.getString("NOMBRE"));
			modelo.setPrecio(rs.getFloat("PRECIO"));
			modelo.setStock(rs.getInt("STOCK"));
			
			productos.add(modelo);
		}
		
		return productos;
	}

	@Override
	public boolean nuevo(ProductoModelo modelo) throws SQLException 
	{
		
		boolean ok;
		sql = "INSERT INTO PRODUCTO(IDPRODUCTO, NOMBRE, PRECIO, STOCK) " + //Si IDPRODUCTO es autoincremental no haria falta el 1er campo
			  "VALUES(?, ?, ?, ?)";
		//            1  2  3  4
		
		
		ps = conexion.prepareStatement(sql);
		
		ps.setInt(1, modelo.getIdProducto());
		ps.setString(2, modelo.getNombre());
		ps.setFloat(3, modelo.getPrecio());
		ps.setInt(4, modelo.getStock());
		
		cantidad = ps.executeUpdate();
		
		if (cantidad == 1) 
		{
			ok = true;
		} 
		else 
		{
			ok = false;
		}
		
		return ok;
	}

	@Override
	public boolean editar(Integer id, ProductoModelo modelo) throws Exception 
	{
		
		boolean ok;
		
		sql = """
		        UPDATE PRODUCTO
		        SET IDPRODUCTO = ?, NOMBRE = ?, PRECIO = ?, STOCK = ?
		        WHERE IDPRODUCTO = ?;
		        """;
		ps = conexion.prepareStatement(sql);
		
		//Datos a insertar
		ps.setInt(1, modelo.getIdProducto());
		ps.setString(2, modelo.getNombre());
		ps.setFloat(3, modelo.getPrecio());
		ps.setInt(4, modelo.getStock());
		
		//Identificador para identificador registro
		ps.setInt(5, modelo.getStock());
		
		cantidad = ps.executeUpdate();
		
		if (cantidad == 1) 
		{
			ok = true;
		} 
		else 
		{
			ok = false;
		}
		
		return ok;
	}

	@Override
	public boolean eliminar(Integer id) throws Exception 
	{
		
		sql = """
			     DELETE FROM PRODUCTO
				 WHERE IDPRODUCTO = ?
			  """;
		ps= conexion.prepareStatement(sql);
		ps.setInt(1, id);
		
		return ps.executeUpdate() == 1; //Hemos simplificado el codigo de "editar()" [Nos quitamos ok]
	}

	@Override
	public boolean eliminarModelo(ProductoModelo modelo) throws Exception 
	{
		return eliminar(modelo.getIdProducto());
	}

	/*
	@Override
	public ProductoModelo leer(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ProductoModelo> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean nuevo(ProductoModelo modelo) throws SQLException {
		st = conexion.createStatement();
		return false;
	}

	@Override
	public boolean editar(Integer id, ProductoModelo modelo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminarModelo(ProductoModelo modelo) {
		// TODO Auto-generated method stub
		return false;
	}
	
	*/
	
	// Campos
	// ------
	
		
	// Metodos
	// -------
	/*@Override
	public Object leer(Object id) 
	{
		return null;
	}

	@Override
	public ArrayList listar() 
	{
		return null;
	}

	@Override
	public boolean nuevo(Object modelo) 
	{
		return false;
	}

	@Override
	public boolean editar(Object id, Object modelo) 
	{
		return false;
	}

	@Override
	public boolean eliminar(Object id) 
	{
		return false;
	}

	@Override
	public boolean eliminarModelo(Object modelo) 
	{
		return false;
	}*/
	
}
