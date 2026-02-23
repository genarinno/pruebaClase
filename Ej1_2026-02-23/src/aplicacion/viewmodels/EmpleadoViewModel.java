package aplicacion.viewmodels;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import hibernate.entidades.ThDepartamento;
import hibernate.entidades.ThEmpleado;

public class EmpleadoViewModel 
{
	// Campos
	// ------
	private Short empNo; // PK. Sustituimos por tipos envolventes, (no primitivos), short => Short. [Recordar qeu es mejor para acceder a objetos]
	private Byte deptNo; // FK. No queremos el departamento entero =>(private ThDepartamento thDepartamento;) solo la FK (clave foranea)
	private String apellido;
	private String oficio;
	private Short dir;
	private Date fechaAlt;
	private BigDecimal salario;
	private BigDecimal comision;
	
	//Campos de la tabla departamento
	private String dNombre;
	private String loc;
	
	
	//Otros campos (relacion de la tabla ThEmpleado con si misma)
	private String apellidoDirector;
	
	//Campos para el desplegable de la tabla departamento
	List<DepartamentosDesplegable> lsDepartamentos;

	
	// Metodos
	// -------
	
	// Metodo para pasar los datos del ViewModel a la Entidad
	public static ThEmpleado modeloToEntidad(EmpleadoViewModel vm) 
	{
		ThEmpleado entidad = new ThEmpleado();
		ThDepartamento entidadDepartamento;
		
		entidad.setEmpNo(vm.getEmpNo());
		entidad.setApellido(vm.getApellido());
		entidad.setOficio(vm.getOficio());
		entidad.setDir(vm.getDir());
		entidad.setFechaAlt(vm.getFechaAlt());
		
		entidad.setSalario(vm.getSalario());
		entidad.setComision(vm.getComision());
		
		//FK - Clave foranea
		//Traemos el departamento
		entidadDepartamento = new ThDepartamento();
		entidadDepartamento.setDeptNo(vm.getDeptNo());
		
		entidad.setThDepartamento(entidadDepartamento);
		
		
		
		return entidad;
	}
		
	// Metodo para pasar los datos de la Entidad al ViewModel
	//public static EmpleadoViewModel entidadToModelo(ThEmpleado entidad, List<ThDepartamento> lsEntidades) 
	public static EmpleadoViewModel entidadToModelo(ThEmpleado entidad, ThEmpleado entidadDirector, List<ThDepartamento> lsEntidades) //Queremos saber los datos del director del empleado [añadimos entidadDirector]
	{
		
		EmpleadoViewModel modelo = new EmpleadoViewModel();
		List<DepartamentosDesplegable> lsDepartamentos;
		DepartamentosDesplegable item;
		
		modelo.setEmpNo(entidad.getEmpNo());
		modelo.setDeptNo(entidad.getThDepartamento().getDeptNo());
		modelo.setApellido(entidad.getApellido());
		modelo.setOficio(entidad.getOficio());
		modelo.setDir(entidad.getDir());
		modelo.setFechaAlt(entidad.getFechaAlt());
		modelo.setSalario(entidad.getSalario());
		modelo.setComision(entidad.getComision());
		
		//Datos de su departamento
		modelo.setdNombre(entidad.getThDepartamento().getDnombre());
		modelo.setLoc(entidad.getThDepartamento().getLoc());
		
		//Desplegamos con los departamentos
		lsDepartamentos = new ArrayList<DepartamentosDesplegable>();
		
		// Otros campos. El apellido del director
		modelo.setApellidoDirector(entidadDirector.getApellido());
		
		
		for (ThDepartamento d : lsEntidades) 
		{
			item = new DepartamentosDesplegable(d.getDeptNo(), d.getDnombre());
			lsDepartamentos.add(item);
		}
		
		modelo.setLsDepartamentos(lsDepartamentos);
		
		//Set<ThEmpleado> empleados;
		/*EmpleadoViewModel vm = new EmpleadoViewModel();
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
		
		
		return vm;*/
		
		return modelo;
	}
	

	// Getters y Setters
	public Short getEmpNo() {
		return empNo;
	}


	public void setEmpNo(Short empNo) {
		this.empNo = empNo;
	}


	public Byte getDeptNo() {
		return deptNo;
	}


	public void setDeptNo(Byte deptNo) {
		this.deptNo = deptNo;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getOficio() {
		return oficio;
	}


	public void setOficio(String oficio) {
		this.oficio = oficio;
	}


	public Short getDir() {
		return dir;
	}


	public void setDir(Short dir) {
		this.dir = dir;
	}


	public Date getFechaAlt() {
		return fechaAlt;
	}


	public void setFechaAlt(Date fechaAlt) {
		this.fechaAlt = fechaAlt;
	}


	public BigDecimal getSalario() {
		return salario;
	}


	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}


	public BigDecimal getComision() {
		return comision;
	}


	public void setComision(BigDecimal comision) {
		this.comision = comision;
	}


	public String getdNombre() {
		return dNombre;
	}


	public void setdNombre(String dNombre) {
		this.dNombre = dNombre;
	}


	public String getLoc() {
		return loc;
	}


	public void setLoc(String loc) {
		this.loc = loc;
	}


	public List<DepartamentosDesplegable> getLsDepartamentos() {
		return lsDepartamentos;
	}


	public void setLsDepartamentos(List<DepartamentosDesplegable> lsDepartamentos) {
		this.lsDepartamentos = lsDepartamentos;
	}

	public String getApellidoDirector() {
		return apellidoDirector;
	}

	public void setApellidoDirector(String apellidoDirector) {
		this.apellidoDirector = apellidoDirector;
	}
	
	
	
	
}
