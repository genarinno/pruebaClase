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
	public boolean nuevo(ThDepartamento entidad) 
	{
		
		tx = session.beginTransaction();
		session.save(entidad);
		tx.commit();
		
		return true; //Habria que hacer un try-catch
	}
	
	@Override
	public ThDepartamento leer(Byte id) 
	{
		ThDepartamento entidad;
		
		entidad = session.load(ThDepartamento.class, id); //Reflexion
		
		return entidad;
	}

	@Override
	public List<ThDepartamento> listar() 
	{
		List<ThDepartamento> lsDepartamentos;
		
		sql = "FROM ThDepartamento";
		q = session.createQuery(sql);
		
		lsDepartamentos = q.list();
		
		return lsDepartamentos;
	}

	@Override
	public boolean editar(Byte id, ThDepartamento entidad) 
	{
		ThDepartamento d;
		
		tx = session.beginTransaction();
		d = session.load(ThDepartamento.class, id);
		
		d.setDnombre(entidad.getDnombre());
		d.setLoc(entidad.getLoc());
		
		session.save(d);
		tx.commit();
		
		return true;  //Habria que hacer un try-catch
		
	}

	@Override
	public boolean eliminar(Byte id) 
	{
		ThDepartamento d;
		
		tx = session.beginTransaction();
		d = session.load(ThDepartamento.class, id);
		
		
		session.remove(d);
		tx.commit();
		
		return true;   //Habria que hacer un try-catch
	}

	@Override
	public boolean eliminarEntidad(ThDepartamento entidad) 
	{
		return eliminar(entidad.getDeptNo());
	}
	
}
