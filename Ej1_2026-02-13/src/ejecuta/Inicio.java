package ejecuta;

import java.util.ArrayList;
import java.util.Scanner;

import modelos.ProductoModelo;
import repositorio.ProductoRepositorio;

public class Inicio {

	public static void main(String[] args) throws Exception 
	{
		String menu = """
					 GESTIÓN DE PRODUCTOS\n
					 --------------------
					 1. Nuevo
					 2. Buscar
					 3. Listar
					 4. Eliminar
					 5. Editar
					 6. Salir
					 Introduce opción:
					  """;
		int opcion;
		Scanner sc = new Scanner(System.in);
		ProductoModelo modelo;
		ArrayList<ProductoModelo> lsProductos;
		int idProducto;
		boolean ok;
		ProductoRepositorio repo = new ProductoRepositorio("localhost", 1521, "system", "admin" ,"free");
		
		do 
		{
			System.out.println(menu);
			opcion = Integer.valueOf(sc.nextLine());
			
			switch (opcion) {
				case 1:		
					try 
					{
						modelo = new ProductoModelo();
						
						System.out.println("Introduce ID PRODUCTO: ");
						modelo.setIdProducto(Integer.valueOf(sc.nextLine()));
						
						System.out.println("Introduce PRODUCTO: ");
						modelo.setNombre(sc.nextLine());
						
						System.out.println("Introduce PRECIO: ");
						modelo.setPrecio(Float.valueOf(sc.nextLine()));
						
						System.out.println("Introduce STOCK: ");
						modelo.setStock(Integer.valueOf(sc.nextLine()));
						
						ok = repo.nuevo(modelo);
						
						System.out.println(ok ? "INSERTADO!" : "NO SE HA GUARDADO");
					} 
					catch (Exception e) 
					{
						System.out.println(e.getMessage());
					}
					
					break;
				case 2:
					try 
					{
						System.out.println("Introduce ID PRODUCTO: ");
						idProducto = Integer.valueOf(sc.nextLine());
						
						modelo = repo.leer(idProducto);
						
						System.out.println((modelo!= null) ? "INSERTADO!" : "NO SE HA GUARDADO");
					}
					catch (Exception e) 
					{
						System.out.println(e.getMessage());
					}
					
					break;
				case 3:
					try 
					{
						lsProductos = repo.listar();
						
						for(ProductoModelo p: lsProductos) System.out.println(p);
					} 
					catch (Exception e) 
					{
						System.out.println(e.getMessage());
					}
					
					break;
				case 4:
					try 
					{
						System.out.println("Introduce ID PRODUCTO: ");
						idProducto = Integer.valueOf(sc.nextLine());
						
						ok = repo.eliminar(idProducto);
						System.out.println(ok ? "ELIMINADO!" : "NO SE HA ELIMINADO");
						
						
					} 
					catch (Exception e) 
					{
						System.out.println(e.getMessage());
					}
					
					break;
				case 5:
					try 
					{
						System.out.println("Introduce ID PRODUCTO: ");
						idProducto = Integer.valueOf(sc.nextLine());
						
						modelo = repo.leer(idProducto);
						
						ok = repo.editar(idProducto, modelo);
						
						System.out.println(ok ? "EDITADO!" : "NO SE HA EDITADO");
						
						
					} 
					catch (Exception e) 
					{
						System.out.println(e.getMessage());
					}
					break;
				case 6:
					break;
				default:
					break;
			}
			
		} while (opcion != 6);
		
	}

}
