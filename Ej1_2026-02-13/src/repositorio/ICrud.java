package repositorio;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ICrud<PK, MODELO>
{
	public abstract MODELO leer(PK id) throws Exception;
	public abstract ArrayList<MODELO> listar() throws Exception;
	public abstract boolean nuevo(MODELO modelo) throws SQLException;
	public abstract boolean editar(PK id, MODELO modelo) throws Exception;
	
	public abstract boolean eliminar(PK id) throws Exception;
	public abstract boolean eliminarModelo(MODELO modelo) throws Exception;

}
