package ejecuta;

import clases.Avion;
import clases.Pajaro;

public class Inicio {

	public static void main(String[] args) 
	{
		Pajaro pajaro = new Pajaro();
		Avion avion = new Avion();
		
		pajaro.despegar();
		pajaro.aterrizar();
		
		System.out.println();
		
		avion.despegar();
		avion.aterrizar();

	}

}
