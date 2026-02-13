package ejecuta;

import java.util.Scanner;

import modelos.ProductoModelo;
import repositorio.ProductoRepositorio;

public class Inicio {

	public static void main(String[] args) 
	{
		String menu = """
					 GESTIÓN DE PRODUCTOS\n
					 --------------------
					 1. Nuevo
					 2. Buscar
					 3. Listar
					 4. Eliminar
					 5. Editar
					 Introduce opción:
					  """;
		int opcion;
		Scanner sc = new Scanner(System.in);
		ProductoModelo modelo;
		int idProducto;
		boolean ok;
		ProductoRepositorio repo = new ProductoRepositorio("localhost", 1521, "system", "admin" ,"free");
		
	}

}
