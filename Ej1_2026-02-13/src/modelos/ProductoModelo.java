package modelos;

public class ProductoModelo{
	// Constructor
	// -----------
	public ProductoModelo()
	{
	}
	
	public ProductoModelo(int p_idProducto, String p_nombre, float p_precio, int p_stock)
	{
	setIdProducto(p_idProducto);
	setNombre(p_nombre);
	setPrecio(p_precio);
	setStock(p_stock);
	}
	
	// Campos
	// ------
	private int idProducto;
	private String nombre;
	private float precio;
	private int stock;
	
	// Métodos
	// -------
	// - Invalidados
	@Override
	public String toString() 
	{
		return "ID PRODUCTO: " + getIdProducto() + "\n"
				+ "NOMBRE: " + getNombre() + "\n"
				+ "PRECIO: " + getPrecio() + "\n"
				+ "STOCK: " + getStock() + "\n";
	}
	
	// - Getters y setters
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
}