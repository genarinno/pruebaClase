package hibernate.repositorios;

import java.util.List;

import hibernate.entidades.ThDepartamento;
import hibernate.entidades.ThEmpleado;

public class ThEmpleadoRepositorio  extends BaseDatos implements ICrud<Short, ThEmpleado>
{

	public ThEmpleadoRepositorio() {
		conectar();
	}

	@Override
	public boolean nuevo(ThEmpleado entidad) 
	{
		tx = session.beginTransaction();
		session.save(entidad);
		tx.commit();
		
		return true; //Habria que hacer un try-catch
	}

	@Override
	public ThEmpleado leer(Short id) 
	{
		ThEmpleado entidad;
		
		entidad = session.load(ThEmpleado.class, id); //Reflexividad
		
		return entidad;
	}

	@Override
	public List<ThEmpleado> listar() 
	{
		List<ThEmpleado> lsEmpleados;
		
		sql = "FROM ThEmpleado";
		q = session.createQuery(sql);
		
		lsEmpleados = q.list();
		
		return lsEmpleados;
	}

	@Override
	public boolean editar(Short id, ThEmpleado entidad) {
		ThEmpleado e;
		ThDepartamento d;
	
		tx = session.beginTransaction();
		e = session.load(ThEmpleado.class, id); //Cargo el modelo de Hibernate
		
		e.setApellido(entidad.getApellido());
		e.setOficio(entidad.getOficio());
		e.setDir(entidad.getDir());
		e.setFechaAlt(entidad.getFechaAlt());
		e.setSalario(entidad.getSalario());
		e.setComision(entidad.getComision());
		
		d = new ThDepartamento();
		d.setDeptNo(entidad.getThDepartamento().getDeptNo());
		
		e.setThDepartamento(d);
		
		session.save(e);
		tx.commit();
		
		
		return true; //Habria que hacer un try-catch
	}

	@Override
	public boolean eliminar(Short id) 
	{
		ThEmpleado e;
		
		tx = session.beginTransaction();
		
		e = session.load(ThEmpleado.class, id); //Cargo el modelo de Hibernate
		session.remove(e);
		
		tx.commit();
		
		return true;  //Habria que hacer un try-catch
	}

	@Override
	public boolean eliminarEntidad(ThEmpleado entidad) 
	{

		return eliminar(entidad.getEmpNo());
	}

}
