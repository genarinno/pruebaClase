package aplicacion.viewmodels;

public class DepartamentosDesplegable 
{
	public DepartamentosDesplegable() 
	{
	}

	// Aqui no utilizamos tipos envolventes, utilizamos primitivos ya que es una clase y metodo propio para trabajar por
	// nuestra cuenta y no depende ni de los datos cliente ni de los datos de la BBDD 
	public DepartamentosDesplegable(byte deptNo, String dNombre) 
	{
		this.deptNo = deptNo;
		this.dNombre = dNombre;
	}

	private byte deptNo;
	private String dNombre;
	
	
	public byte getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(byte deptNo) {
		this.deptNo = deptNo;
	}

	public String getdNombre() {
		return dNombre;
	}

	public void setdNombre(String dNombre) {
		this.dNombre = dNombre;
	}
	
	
}
