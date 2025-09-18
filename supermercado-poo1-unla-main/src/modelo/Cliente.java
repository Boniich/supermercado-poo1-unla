package modelo;

public class Cliente {
	
	private int idCliente;
	private String nombre;
	private long dni;
	private String direccion;
	
	public Cliente(int idCliente, String nombre, long dni, String direccion) throws Exception {
		super();
		this.idCliente = idCliente;
		this.setNombre(nombre);
		this.setDni(dni);
		this.setDireccion(direccion);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) throws Exception {
		if(nombre.isEmpty()) throw new Exception("Error: El nombre del cliente no puede estar vacio!");
		this.nombre = nombre;
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) throws Exception {
		if(direccion.isEmpty()) throw new Exception("Error: La direccion del cliente no puede estar vacia!");
		this.direccion = direccion;
	}

	public int getIdCliente() {
		return idCliente;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nombre=" + nombre + ", dni=" + dni + ", direccion=" + direccion
				+ "]";
	}
	

	
}
