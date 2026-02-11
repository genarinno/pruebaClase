package clases;

import java.util.ArrayList;

public class TelefonoRepositorio implements ICrud
{
	// Constructor
	// -----------
	
	// Campos
	// ------
	private ArrayList<Telefono> lsTelefonos = new ArrayList<Telefono>();
	
	
	// Metodos
	// -------
	
	@Override
	public Telefono leer(Telefono busqueda) 
	{
		int posicion;
		Telefono t;
		
		posicion = this.lsTelefonos.indexOf(busqueda);
		
		if (posicion == -1) 
		{
			t = null;
		} 
		else 
		{
			t = this.lsTelefonos.get(posicion);
		}
		
		return t;
	}
	
	@Override
	public Telefono leer(int idTelefono) 
	{
		//a) Hacemos una busqueda secuencial
		boolean encontrado;
		Telefono telefono = null;
		
		
		encontrado = false;
		for (int i = 0; !encontrado && i < this.lsTelefonos.size(); i++) 
		{			
			telefono = lsTelefonos.get(i);
			
			if (idTelefono == telefono.getIdTelefono()) 
			{
				encontrado = true;
			}
		}
		
		if (encontrado == false) 
		{
			telefono = null;
		}
		
		return telefono;
		
		//b) Con indexOf() (redefiniendo el 'equals()' de telefono)
		/*
		Telefono telefono;
		Telefono busqueda;
		int posicion;
		
		busqueda = new Telefono();
		busqueda.setIdTelefono(idTelefono);
				
		posicion = lsTelefonos.indexOf(busqueda); //Aqui entra en accion el metodo 'equals' de Telefono.
		telefono = lsTelefonos.get(posicion);	
		
		return telefono;
		*/
	}

	@Override
	public ArrayList<Telefono> listar() 
	{
		return this.lsTelefonos;
	}

	@Override
	public boolean nuevo(Telefono telefono) 
	{
		Telefono t;
		boolean ok = false;
		
		t = leer(telefono);
		
		if (t == null) 
		{
			this.lsTelefonos.add(telefono);
			ok = true;
		}
		
		return ok;
	}

	@Override
	public boolean eliminar(int idTelefono) 
	{
		
		Telefono telefono = new Telefono();
		telefono.setIdTelefono(idTelefono);
		boolean eliminado;
		
		eliminado = this.lsTelefonos.remove(telefono); //Aqui entra en accion el metodo 'equals' de Telefono.
		return eliminado;
	}

	@Override
	public boolean eliminar(Telefono telefono) 
	{
		return this.lsTelefonos.remove(telefono); //Aqui entra en accion el metodo 'equals' de Telefono.
	}

	@Override
	public boolean editar(int idTelefono, Telefono telefono) 
	{
		boolean ok;
		int posicion; // posicion donde encuentra el registro
		Telefono busqueda = new Telefono();
		busqueda.setIdTelefono(idTelefono);
		
		posicion = this.lsTelefonos.indexOf(busqueda);
		
		if (posicion == -1) 
		{
			ok = false;
		}
		else 
		{
			ok = true;
			this.lsTelefonos.set(posicion, telefono);
		}
		
		return ok;
	}
	
}
