package ejecuta;

import java.util.ArrayList;
import java.util.Scanner;

import clases.Telefono;
import clases.TelefonoRepositorio;

public class Inicio 
{
	public static void main(String[] args) 
	{
		 String menu = "MENU TELEFONOS\n" + 
				 	   "--------------\n" +
				 	   "1. Buscar\n" +
				 	   "2. Listar\n" +
				 	   "3. Nuevo\n" +
				 	   "4. Editar\n" +
				 	   "5. ELiminar\n" +
				 	   "6. Salir\n" +
				 	   "Introduce opción: ";
		 int opcion;
		 Scanner sc = new Scanner(System.in);
		 Telefono telefono;
		 int idTelefono;
		 TelefonoRepositorio repo = new TelefonoRepositorio();
		 boolean ok;
		 
		 
		 
		 do
		 {	
			System.out.println(menu);
			opcion = Integer.valueOf(sc.nextLine());
			
			switch(opcion)
			{
				case 1:
					System.out.println("Introduce el ID del telefono");
					idTelefono = Integer.valueOf(sc.nextLine());
					
					telefono = repo.leer(idTelefono);
					
					if(telefono == null) 
					{
						System.out.println("No se ha encontrado.");
					}
					else 
					{
						System.out.println(telefono);
					}
					
					break;
					
				case 2:
					if(repo.listar().size() == 0) {
						System.out.println("No se han encontrado telefonos");
						break;
					}
					
					System.out.println("Listado de telefono: ");
					for(Telefono t: repo.listar()) System.out.println(t);
					
					break;
				
				case 3:
					telefono = new Telefono();
					System.out.println("A continuacion, se le pediran los datos del telefono");
					
					System.out.println("Introduce FABRICANTE:");
					telefono.setFabricante(sc.nextLine());
					
					System.out.println("Introduce MODELO:");
					telefono.setModelo(sc.nextLine());
					
					System.out.println("Introduce MEMORIA:");
					telefono.setMemoria(Integer.valueOf(sc.nextLine()));
					
					System.out.println("Introduce PRECIO:");
					telefono.setPrecio(Float.valueOf(sc.nextLine()));
					
					ok = repo.nuevo(telefono);
					
					if(ok) 
					{
						System.out.println("¡Guardado!!");
					}
					else {
						System.out.println("No se ha guardado.");
					}
					
					break;
				
				case 4:
					System.out.println("Introduce el ID del telefono que deseads modificar: ");
					idTelefono = Integer.valueOf(sc.nextLine());
					
					if(repo.leer(idTelefono) == null) //No se encuentra porque el regisro no existe 
					{
						System.out.println("No se ha editado, porque el registro no existe.");
					}
					else 
					{
						telefono = new Telefono();
						
						System.out.println("A continuacion, se le pedira que introduzca los datos modificados");
						
						System.out.println("Introduce ID TELEFONO: ");
						telefono.setIdTelefono(Integer.valueOf(sc.nextLine()));
						
						System.out.println("Introduce FABRICANTE:");
						telefono.setFabricante(sc.nextLine());
						
						System.out.println("Introduce MODELO:");
						telefono.setModelo(sc.nextLine());
						
						System.out.println("Introduce MEMORIA:");
						telefono.setMemoria(Integer.valueOf(sc.nextLine()));
						
						System.out.println("Introduce PRECIO:");
						telefono.setPrecio(Float.valueOf(sc.nextLine()));
						
						ok = repo.editar(idTelefono, telefono);
						
						if(ok)
						{
							System.out.println("¡Editado!!");
						}
						else 
						{
							System.out.println("No se ha editado");
						}
					}
					
					break;
				
				case 5:
					
					System.out.println("Introduce el ID del telefono que deseads modificar: ");
					idTelefono = Integer.valueOf(sc.nextLine());
					Telefono telefonoBorrar  = repo.leer(idTelefono);
					
					
					if(telefonoBorrar == null) //No se encuentra porque el regisro no existe 
					{
						System.out.println("No se ha borrado, porque el registro no existe.");
						break;
					}
					
					repo.eliminar(telefonoBorrar.getIdTelefono());
					
					break;
				
				case 6:
					System.out.println("¡Hasta pronto!");
					break;
				
				default:
					System.out.println("Opcion incorrecta");
			}		
		 }while(opcion != 6);
	}
}
