package hibernate.repositorios;

import java.util.List;

public interface ICrud<PK, ENTIDAD>
{
	ENTIDAD leer(PK id);
	List<ENTIDAD> listar();
	
	boolean nuevo(ENTIDAD entidad);
	boolean editar(PK id, ENTIDAD entidad);
	
	boolean eliminar(PK id);
	boolean eliminarEntidad(ENTIDAD entidad);
}
