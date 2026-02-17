package ejecuta;

import java.util.Scanner;

import clases.Cafetera;
import clases.CafeteraException;

public class Inicio 
{
	public static void main(String[] args) 
	{
		
		//Declaramos las variables
		Cafetera miCafetera;
		String menu =   "MENU" + "\n"
						+ "1.Encender" + "\n"
						+ "2.Apagar" + "\n"
						+ "3.Servir Taza" + "\n"
						+ "4.Servir vaso" + "\n"
						+ "5.Rellenar" + "\n"
						+ "6.Mostrar agua restante" + "\n"
						+ "7.Salir" + "\n"
						+ "Introduce opcion:";
		
		int opcion = 0;
		Scanner sc = new Scanner(System.in);
		String mensaje;
				 
	
		try 
		{
			//1. -Puede fallar en el Constructor al Crear la Cafetera y arrojar una CafeteraException 
			miCafetera = new Cafetera(1000, 1000, 100, 250);
			
			do 
			{			
				//2.- Pueden fallar algunos metodos de Cafetera y arrojar una CafeteraException
				try 
				{
					System.out.println(menu);
					
					//Se va a pedir el valor en azul => [lo suyo seria hacerse una funcion, claro]
					System.out.print("\u001B[34m"); //Azul
					opcion = sc.nextInt();
					System.out.print("\u001B[0m"); //Reset
					
					
					switch (opcion) 
					{
						case 1: //encender
							mensaje = miCafetera.encender();
							System.out.println(mensaje);
							break;
							
						case 2: //apagar
							mensaje = miCafetera.apagar();
							System.out.println(mensaje);
							break;
							
						case 3: //Servir Taza (Puede fallar [esta en su codigo])
							mensaje = miCafetera.servirTaza();
							System.out.println(mensaje);
							break;
							
						case 4: //Servir Vaso (Puede fallar [esta en su codigo])
							mensaje = miCafetera.servirVaso();
							System.out.println(mensaje);
							break;
							
						case 5: //Rellenar
							mensaje = miCafetera.rellenar();
							System.out.println(mensaje);
							break;
							
						case 6: //Mostrar agua restante
							mensaje = miCafetera.mostrarCapacidad();
							System.out.println(mensaje);
							break;
							
						case 7: //Salir
							System.out.println("Hasta pronto!");
							break;
							
						default:
							System.out.println("Opcion incorrecta");
					}
				}
				catch (CafeteraException e) 
				{
					System.out.println(e.getMessage());
				}
				
				
				
			} while (opcion != 7);
		} 
		catch (CafeteraException e) 
		{
			System.out.println(e.getMessage());
		}
		
		sc.close(); //Habria que comprobar en los Errores porque aqui puede no llegar
	}
	
	

}
