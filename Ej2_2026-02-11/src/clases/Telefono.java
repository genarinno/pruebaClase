package clases;

public class Telefono 
{
	// Constructores
	// -------------
	public Telefono() 
	{
		//Telefono.id++;
		this("", "", 0, 0F);//El constructor sin parametros llama al constructor con parametros pasandole los campos standard
	
	}
	
	public Telefono(String pFabricante, String pModelo, int pMemoria, float pPrecio) 
	{
		Telefono.id++;
		this.idTelefono = Telefono.id;
		
		setFabricante(pFabricante);
		setModelo(pModelo);
		setMemoria(pMemoria);
		setPrecio(pPrecio);
	}
	
	
	// Campos
	// ------
	private static int id = 0;
	
	private int idTelefono;
	private String fabricante;
	private String modelo;
	private int memoria;
	private float precio;
	
	
	
	// Metodos
	// -------
	// - De las instancias de la Clas
	// 
	// - Getters y Setters
	
	public int getIdTelefono() {
		return idTelefono;
	}
	public void setIdTelefono(int idTelefono) {
		this.idTelefono = idTelefono;
	}
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getMemoria() {
		return memoria;
	}
	public void setMemoria(int memoria) {
		this.memoria = memoria;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	// - Invalidados
	
	@Override
	public String toString() 
	{
		return String.format("ID TELEFONO: %d\nFABRICANTE: %s\nMODELO: %s\nMEMORIA: %d\nPRECIO: %.2f\n", 
							  getIdTelefono(), getFabricante(), getModelo(), getMemoria(), getPrecio());
	}

	@Override
	public boolean equals(Object pOtroTelefono) 
	{
		boolean sonIguales;
		
		sonIguales = this.idTelefono == ((Telefono) pOtroTelefono).idTelefono;
		
		return sonIguales;
	}
	
	
	
	
}
