package aplicacion.viewmodels;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import hibernate.entidades.ThDepartamento;
import hibernate.entidades.ThEmpleado;

public class DepartamentoVM 
{
	
	
	
	// Campos
	// ------
	public Byte deptNo;    //
	public String dNombre; // Me interesa que no haya tipos primitivos dentro del ViewModel
	public String loc;     //
	
	public List<Empleado> lsEmpleados; //Clase Interna (Empleados del departamento)
	
	
	// Metodos
	// -------
	
	// Metodo para pasar los datos del ViewModel a la Entidad
	public static ThDepartamento modeloToEntidad(DepartamentoVM vm) 
	{
		ThDepartamento entidad = new ThDepartamento();
		
		entidad.setDeptNo(vm.deptNo);
		entidad.setDnombre(vm.dNombre);
		entidad.setLoc(vm.loc);
		
		return entidad;
	}
	
	// Metodo para pasar los datos de la Entidad al ViewModel
	public static DepartamentoVM entidadToModelo(ThDepartamento entidad) 
	{
		DepartamentoVM vm = new DepartamentoVM();
		Set<ThEmpleado> empleados;
		
		vm.deptNo = entidad.getDeptNo();
		vm.dNombre = entidad.getDnombre();
		vm.loc = entidad.getLoc();
		
		vm.lsEmpleados = new ArrayList<DepartamentoVM.Empleado>(); //Polimorfismo
		
		empleados = entidad.getThEmpleados();
		
		empleados.forEach((item)->{
			Empleado e = vm.new Empleado(item.getEmpNo(), item.getApellido(), item.getOficio(),
										 item.getDir(), item.getFechaAlt(), item.getSalario(),
										 item.getComision()
										); //Instanciamos un objeto dentra de la clase interna (si la hubiesemos sacado fuera lo hariamos fuera del scope)
			vm.lsEmpleados.add(e);
		});
		
		
		return vm;
	}
	
	
	// Clases internas.- (Solo utilizadas dentro del ViewModel)
	// ---------------
	public class Empleado
	{
		// Constructores
		public Empleado() {
			
		}
		
		public Empleado(Short empNo, String apellido, String oficio, 
						Short dir, Date fechaAlt, Long salario,
						Long comision)
		{
			
			this.empNo = empNo;
			this.apellido = apellido;
			this.oficio = oficio;
			this.dir = dir;
			this.fechaAlt = fechaAlt;
			this.salario = salario;
			this.comision = comision;	
		}
		
		// Campos
		public Short empNo;     //
		public String dNombre;  // 
		public String loc;      //
		public String apellido; // Me interesa que no haya tipos primitivos dentro del ViewModel
		public String oficio;   //
 		public Short dir;       //
		public Date fechaAlt;   //
		
		public Long salario;
		public Long comision;
	}
}
