package clases;

public class Cafetera 
{
	
	// Constructores
	// -------------
	public Cafetera(int capacidadTotal, int capacidadRestante, int volumenTaza, int volumenVaso) throws CafeteraException
	{
		setCapacidadTotal(capacidadTotal);
		setCapacidadRestante(capacidadRestante);
		setVolumenTaza(volumenTaza);
		setVolumenVaso(volumenVaso);
		
		// La cafetera se encuentra apagada
		setEstado(false);
	}
	
	
	// Campos
	// ------
	private int capacidadTotal; //Cantidad maxima de agua que se puede alamacenar en la cafetera
	private int capacidadRestante; // Cantidad de agua que queda en la cafetera
	private int volumenTaza; //Cantidad de agua que cabe en la taza
	private int volumenVaso;  //Cantidad de agua que cabe en el vaso
	private boolean estado; //Indica si la cafetera esta apagado o encendida
	
	// Declaramos (por ahora en main y solo las variables), los colores para printar los distintos mensajes
	// [Lo suyo es crearse un metodo o sobrecargar println con otro paramtero que indique con un codigo el color]
	public static final String RESET = "\u001B[0m";
    public static final String ROJO  = "\u001B[31m";
    public static final String VERDE = "\u001B[32m";
    public static final String GRIS  = "\u001B[90m";

	// Metodos
	// -------
	
	public /*void*/ String servirTaza() throws CafeteraException 
	{
		// Validamos
		// ---------
		// - La cafetera esta apagada => Exception
		// - No queda agua => Exception
		// - Servimos taza => OK
		
		if (getEstado() == false) 
		{
			throw new CafeteraException(GRIS + "La cafetera esta apagada. No se ha servido la taza" + RESET);
		} 
		else if (getCapacidadRestante() <  getVolumenTaza()) // No queda suficiente agua
		{
			throw new CafeteraException(ROJO +"No se ha servido la taza. No queda agua."+ RESET);
		}
		else 
		{
			setCapacidadRestante(getCapacidadRestante() -  getVolumenTaza());
		}	
		
		return VERDE + "Taza servida" + RESET;
		
	}
	
	public /*void*/ String servirVaso() throws CafeteraException 
	{
		// Validamos
		// ---------
		// - La cafetera esta apagada => Exception
		// - No queda agua => Exception
		// - Servimos vaso => OK
		
		if (getEstado() == false) 
		{
			throw new CafeteraException(GRIS + "La cafetera esta apagada. No se ha servido el vaso" + RESET);
		} 
		else if (getCapacidadRestante() <  getVolumenVaso()) // No queda suficiente agua
		{ 
			throw new CafeteraException(ROJO + "No se ha servido la vaso. No queda agua." + RESET);
		}
		else // OK. Servimos vaso
		{
			setCapacidadRestante(getCapacidadRestante() -  getVolumenVaso());
		}	
		
		return VERDE + "Vaso servido" + RESET;
	}
	
	
	public String encender() 
	{
		
		setEstado(true);
		return VERDE + "Cafetera encendida." + RESET;
	}
	
	public String apagar() 
	{
		setEstado(false);
		return ROJO + "Cafetera apagada." + RESET;
	}
	
	public String rellenar() throws CafeteraException //Se rellena entera la cafetera
	{
		if( getCapacidadRestante() == getCapacidadTotal()) 
		{
			return GRIS + "La capacidad ya se encuentra rellena totalmente: " + getCapacidadTotal() + " ml de agua." + RESET;
		}
		
		setCapacidadRestante(getCapacidadTotal());
		return VERDE + "Cafetera Rellena Queda(n): " + getCapacidadRestante() + " ml de agua." + RESET;
	}
	
	public String mostrarCapacidad() 
	{
		return GRIS + "Queda(n): " + getCapacidadRestante() + " ml de agua." + RESET;
	}
	
	
	// - Getters y setters
	public int getCapacidadTotal() 
	{
		return capacidadTotal;
	}
	
	public void setCapacidadTotal(int capacidadTotal) 
	{
		this.capacidadTotal = capacidadTotal;
	}
	
	public int getCapacidadRestante() {
		return capacidadRestante;
	}
	
	public void setCapacidadRestante(int capacidadRestante) throws CafeteraException 
	{
		if (capacidadRestante > getCapacidadTotal()) 
		{
			throw new CafeteraException(ROJO + "Campo CAPACIDAD RESTANTE incorrecto. No puede superar la capacidad de la cafetera." + RESET);
		} 
		else 
		{
			this.capacidadRestante = capacidadRestante;
		}
	}
	
	public int getVolumenTaza() 
	{
		return volumenTaza;
	}
	
	public void setVolumenTaza(int volumenTaza) 
	{
		this.volumenTaza = volumenTaza;
	}
	
	public int getVolumenVaso() 
	{
		return volumenVaso;
	}
	
	public void setVolumenVaso(int volumenVaso) 
	{
		this.volumenVaso = volumenVaso;
	}

	public boolean getEstado() 
	{
		return estado;
	}

	public void setEstado(boolean estado) 
	{
		this.estado = estado;
	}
	
	
	
	
}
