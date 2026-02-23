package aplicacion;

import java.util.List;

import aplicacion.viewmodels.DepartamentosDesplegable;
import aplicacion.viewmodels.EmpleadoViewModel;
import hibernate.entidades.ThDepartamento;
import hibernate.entidades.ThEmpleado;
import hibernate.repositorios.ThEmpleadoRepositorio;
import hibernate.repositorios.ThDepartamentoRepositorio;

public class Inicio 
{

	public static void main(String[] args) 
	{
		// Repositorios
		ThEmpleadoRepositorio repoEmple;
		ThDepartamentoRepositorio repoDepart;
		
		// Entidades
		ThEmpleado entidadEmpleado; // Contiene un registro de la tabla ThEmpleado
		ThEmpleado entidadDirector; // Contiene un registro de la tabla ThEmpleado (en este caso el director del empleado, [queremos saber sus datos para este caso])
		List<ThDepartamento> lsEntidadesDepartamento; // Contiene todos los resgistros de la tabla ThDepartamento
		
		// Modelo
		EmpleadoViewModel modelo;
		
		// Campos PK
		short empNo = 7521;
		
		// Poblamos las entidades con la informacion de la BBDD
		repoEmple = new ThEmpleadoRepositorio();
		entidadEmpleado = repoEmple.leer(empNo);
		entidadDirector = repoEmple.leer(entidadEmpleado.getDir());
		
		repoDepart= new ThDepartamentoRepositorio();
		lsEntidadesDepartamento = repoDepart.listar();
		
		
		// ¡Comenzamos!!
		// ------------
		// - Poblamos el modelo desde las entidades
		modelo = EmpleadoViewModel.entidadToModelo(entidadEmpleado, entidadDirector, lsEntidadesDepartamento);
		
		// - Imprimimos
		String cadena = "DATOS DEL EMPLEADO: \n" +
				 "EMPNO: " + modelo.getEmpNo() + ", DEPTNO: " + modelo.getDeptNo() +
				 ", APELLIDO: " + modelo.getApellido() + ", OFICIO: " + modelo.getOficio() +
				 ", DIRECTOR: " + modelo.getDir() + ", APLLDO (DIRECTOR):" + modelo.getApellidoDirector() + ", F. ALTA: " + modelo.getFechaAlt() +
				 ", SALARIO: " + modelo.getSalario() + ", COMISION: " + modelo.getComision() + "\n";
		
		cadena += "DATOS DE SU DEPARTAMENTO: \n" +
		          "DNOMBRE: " + modelo.getdNombre() + ", LOCALIDAD: " + modelo.getLoc() + "\n";
		
		cadena += "DEPARTAMENTOS PARA EL DESPLEGABLE: \n";
		
		for (DepartamentosDesplegable item : modelo.getLsDepartamentos()) 
		{
			cadena += "\tDEPTNO: " + item.getDeptNo() + ", DNOMBRE: " + item.getdNombre() + "\n";
		}
		
		System.out.println(cadena);
 	}

}
