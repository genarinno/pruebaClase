package clases;

public class Pajaro implements IVolador
{

	@Override
	public void despegar() 
	{
		System.out.println("El pajaro esta echando a volar");
		
	}

	@Override
	public void aterrizar() {
		System.out.println("El pajaro se esta posando");
		
	}
	
}
