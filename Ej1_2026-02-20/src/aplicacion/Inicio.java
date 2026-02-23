package aplicacion;

import java.util.Iterator;

import aplicacion.viewmodels.DepartamentoVM;
import hibernate.entidades.ThDepartamento;
import hibernate.repositorios.ThDepartamentoRepositorio;

public class Inicio 
{

	public static void main(String[] args) 
	{
		DepartamentoVM vm = dameModeloVistaDepartamento((byte)20);
		String cadena;
		
		// Imprimimos...
		cadena = "DEPTNO: " + vm.deptNo + ", DNOMBRE: " + vm.dNombre + ", LOCALIDAD: "  + vm.loc + ":\n";
		cadena += "Empleado contratados: \n";
		
		for (DepartamentoVM.Empleado e : vm.lsEmpleados) 
		{
			cadena += "\tEMPNO: " + e.empNo + ", APELLIDO: " + e.apellido +  ", OFICIO: " + e.oficio
					+ ", SALARIO: " + e.salario + ", COMISION: " + e.comision + ", DIRECTOR: " + e.dir
					+ "FECHA ALTA: " + e.fechaAlt + "\n";
		} 
		
		System.out.println(cadena);
	}
	
	public static DepartamentoVM dameModeloVistaDepartamento(byte p_deptNo) 
	{
		DepartamentoVM vm;
		ThDepartamentoRepositorio repo = new ThDepartamentoRepositorio();
		ThDepartamento d;
		
		d = repo.leer(p_deptNo);
		vm = DepartamentoVM.entidadToModelo(d);
		
		repo.desconectar();
		
		return vm;
	}

}
