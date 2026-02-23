package hibernate.repositorios;

import java.util.List;

public interface ICrud<PK, ENTIDAD>
{
	//Create
	boolean nuevo(ENTIDAD entidad);
	
	//Read
	ENTIDAD leer(PK id);
	List<ENTIDAD> listar();
	
	//Update
	boolean editar(PK id, ENTIDAD entidad);
	
	//Delete
	boolean eliminar(PK id);
	boolean eliminarEntidad(ENTIDAD entidad);
}
