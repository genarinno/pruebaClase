package clases;

import java.util.ArrayList;

public interface ICrud 
{
	public abstract Telefono leer(int idTelefono);
	public abstract Telefono leer(Telefono busqueda);
	
	public abstract ArrayList<Telefono> listar();
	public abstract boolean nuevo(Telefono telefono);
	
	public abstract boolean eliminar(int idTelefono);
	public abstract boolean eliminar(Telefono telefono);
	
	public abstract boolean editar(int idTelefono, Telefono telefono);
	
	

}
