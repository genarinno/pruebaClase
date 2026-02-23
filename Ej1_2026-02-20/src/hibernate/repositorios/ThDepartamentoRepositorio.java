package hibernate.repositorios;

import java.util.List;

import hibernate.entidades.ThDepartamento;

public class ThDepartamentoRepositorio extends BaseDatos implements ICrud<Byte, ThDepartamento>
{

	public ThDepartamentoRepositorio() 
	{
		conectar();
	}
	
	@Override
	public ThDepartamento leer(Byte id) 
	{
		ThDepartamento entidad;
		
		entidad = session.load(ThDepartamento.class, id);
		
		return entidad;
	}

	@Override
	public List<ThDepartamento> listar() 
	{
		List<ThDepartamento> datos;
		
		datos = session.createQuery("FROM ThDepartamento").list();
		
		return datos;
	}

	@Override
	public boolean nuevo(ThDepartamento entidad) 
	{
		
		return false;
	}

	@Override
	public boolean editar(Byte id, ThDepartamento entidad) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminar(Byte id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminarEntidad(ThDepartamento entidad) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
