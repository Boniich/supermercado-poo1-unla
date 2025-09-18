package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Supermercado {

	private List<Producto> gondola;
	private List<Carrito> carritos;
	private List<Cliente> clientes;
	
	


	public Supermercado() {
		this.gondola = new ArrayList<Producto>();
		this.carritos = new ArrayList<Carrito>();
		this.clientes = new ArrayList<Cliente>();
		
	}

	public boolean agregarProducto(String producto, float precio) throws Exception {
		
		if(traerProducto(producto) != null) throw new Exception("Error: El producto ya existe!");
		
		int ultimoId = 1; 
		if(gondola.size() > 0) ultimoId = gondola.get(gondola.size()-1).getIdProducto()+1; 
		return gondola.add(new Producto(ultimoId,producto,precio));
		
	}
	
	public Producto traerProducto(String nombre) {
		Producto producto = null;
		int index = 0;
		boolean encontrado = false;
		if(!gondola.isEmpty()) {
			while(index < gondola.size() && !encontrado) {
				if(gondola.get(index).getProducto().equalsIgnoreCase(nombre)) {
					encontrado = true;
					producto = gondola.get(index);
				}
				index++;
			}
			
		}
		
		
		return producto;
		
	}
	
	public Producto traerProducto(int idProducto) {
		Producto producto = null;
		int index = 0;
		boolean encontrado = false;
		if(!gondola.isEmpty()) {
			while(index < gondola.size() && !encontrado) {
				if(gondola.get(index).getIdProducto() == idProducto) {
					encontrado = true;
					producto = gondola.get(index);
				}
				index++;
			}
			
		}
		
		
		return producto;
		
	}
	
	public boolean modificarProducto(int idProducto, String producto, float precio) throws Exception {
		
		Producto productoBuscado = traerProducto(idProducto);
		if(productoBuscado == null) throw new Exception("Error: El producto buscado no existe!");
		
		productoBuscado.setProducto(producto);
		productoBuscado.setPrecio(precio);
		
		return true;
	}
	
	public boolean eliminarProducto(int idProducto) throws Exception {
		
		Producto productoEncontrado = traerProducto(idProducto);
		if(productoEncontrado == null) throw new Exception("Error: Producto buscado no existe!");
		
		return gondola.remove(productoEncontrado);
	}
	
	//Clientes
	
	public boolean agregarCliente(String cliente, long dni, String direccion) throws Exception {
		if(traerCliente(dni) != null) throw new Exception("Error: El cliente ya existe!");
		
		int ultimoId = 1;
		if(!clientes.isEmpty()) ultimoId = clientes.get(clientes.size()-1).getIdCliente()+1;
		return clientes.add(new Cliente(ultimoId, cliente, dni, direccion));
	}
	
	public boolean eliminarCliente(long dni) throws Exception {
		Cliente clienteBuscado = traerCliente(dni);
		if(clienteBuscado == null) throw new Exception("Error: El cliente no existe!");
		if(existeCarritoDeCliente(clienteBuscado)) 
			throw new Exception("Error: El cliente no puede ser eliminado porque tiene uno o mas carritos de compra");
		return clientes.remove(clienteBuscado);
		
	}
	
	
	
	public Cliente traerCliente(long dni) {
		Cliente clienteBuscado = null;
		int index = 0;
		boolean encontrado = false;
		
		if(!clientes.isEmpty())
			while(index < clientes.size() && !encontrado) {
				
				if(clientes.get(index).getDni() == dni) {
					clienteBuscado = clientes.get(index);
					encontrado = true;
				}
				
				index++;
			}
		
		return clienteBuscado;
	}
	
	
	//Carritos
	
	public boolean agregarCarrito(LocalDate fecha, LocalTime hora, Cliente cliente) throws Exception {
		
		if(traerCarrito(fecha, hora, cliente) != null) throw new Exception("Error: El carrito ya existe!");
		
		int ultimoId = 1;
		if(!carritos.isEmpty()) ultimoId = carritos.get(carritos.size()-1).getIdCarrito()+1;
		return carritos.add(new Carrito(ultimoId,fecha,hora,cliente));
	}
	
	
	public boolean AgregarItemAlCarrito(int idCarrito, Producto producto, int cantidad) throws Exception {
		Carrito carritoBuscado = traerCarrito(idCarrito);
		if(carritoBuscado == null) throw new Exception("Error: El carrito buscado no existe!");
		return carritoBuscado.agregarItem(producto, cantidad);
	}
	
	public boolean eliminarItemDelCarrito(int idCarrito, Producto producto, int cantidad) throws Exception {
		Carrito carritoBuscado = traerCarrito(idCarrito);
		if(carritoBuscado == null) throw new Exception("Error: El carrito buscado no existe!");
		return carritoBuscado.eliminarItem(producto, cantidad);
	}
	
	public Carrito traerCarrito(int idCarrito) {
		Carrito carritoBuscado = null;
		int index = 0;
		boolean encontrado = false;
		
		if(!carritos.isEmpty())
			while(index < carritos.size() && !encontrado) {
				if(carritos.get(index).getIdCarrito() == idCarrito) {
					carritoBuscado = carritos.get(index);
					encontrado = true;
				}
				index++;
			}
				
		return carritoBuscado;
	}
	

	public Carrito traerCarrito(LocalDate fecha, LocalTime hora, Cliente cliente) {
		Carrito carritoBuscado = null;
		int index = 0;
		boolean encontrado = false;
		
		if(!carritos.isEmpty())
			while(index < carritos.size() && !encontrado) {
				if(carritos.get(index).getCliente().equals(cliente) && 
						carritos.get(index).getFecha().equals(fecha) && 
						carritos.get(index).getHora().equals(hora)) {
					carritoBuscado = carritos.get(index);
					encontrado = true;
				}
				index++;
			}
				
		return carritoBuscado;
	}
	
	public boolean existeCarritoDeCliente(Cliente cliente) {
		int index = 0;
		boolean encontrado = false;
		if(!carritos.isEmpty())
			while(index < carritos.size() && !encontrado) {
				if(carritos.get(index).getCliente().equals(cliente)) encontrado = true;
				index++;
			}
		
		return encontrado;
	}
	
	public List<Carrito> traerCarritosPorCliente(Cliente cliente) {
		List<Carrito> carritosCliente = new ArrayList<Carrito>();
		int index = 0;
		
		if(!carritos.isEmpty())
			while(index < carritos.size()) {
				if(carritos.get(index).getCliente().equals(cliente)) {
					carritosCliente.add(carritos.get(index));
				}
				index++;
			}
				
		return carritosCliente;
	}
	
	public float calcularTotal(Cliente cliente) throws Exception {
		//Es necesario un traerCliente que reciba un cliente?
		//Seria correcto utilizar calcularTotal que recibe dni:
		
		return calcularTotal(cliente.getDni());
		/*
		if(traerCliente(cliente.getDni()) == null) throw new Exception("Error: El cliente no existe!");
		float total = 0;
		for(Carrito c : traerCarritosPorCliente(cliente)) {
			total += c.calcularTotal();
		}
		return total;*/
	}
	
	public float calcularTotal(long dni) throws Exception {
		Cliente clienteBuscado = traerCliente(dni);
		if(clienteBuscado == null) throw new Exception("Error: El cliente no existe!");
		float total = 0;
		for(Carrito c : traerCarritosPorCliente(clienteBuscado)) {
			total += c.calcularTotal();
		}
		return total;
		
		
	}
	
	public float calcularTotal(LocalDate fechaInicio, LocalDate fechaFin) {
		float total = 0;
		for(Carrito c: carritos) {
			if((c.getFecha().isEqual(fechaInicio) 
					||c.getFecha().isAfter(fechaInicio) && c.getFecha().isBefore(fechaFin)) 
					|| c.getFecha().isEqual(fechaFin)) {
				total += c.calcularTotal();
			}
		}
		return total;
	}
	
	public float calcularTotal(LocalDate fecha) {
		float total = 0;
		for(Carrito c: carritos) {
			if(c.getFecha().isEqual(fecha)) {
				total += c.calcularTotal();
			}
		}
		return total;
	}
	
	public float calcularTotal(int mes, int anio) throws Exception {
		if(mes < 1 || mes > 12) throw new Exception("Error: El mes es incorrecto!");
		if(anio < 0 || anio > LocalDate.now().getYear()) throw new Exception("Error: El anio es incorrecto");
		
		float total = 0;
		for(Carrito c: carritos) {
			if(c.getFecha().getMonthValue() == mes && c.getFecha().getYear() == anio) {
				total += c.calcularTotal();
			}
		}
		return total;
	}
	
	public float calcularTotal(LocalDate fechaInicio, LocalDate fechaFin, Cliente cliente) throws Exception {
		Cliente clienteBuscado = traerCliente(cliente.getDni());
		if(clienteBuscado == null) throw new Exception("Error: El cliente no existe!");
		
		float total = 0;
		if(!carritos.isEmpty() && existeCarritoDeCliente(clienteBuscado)) {
			for(Carrito c : carritos) {
				if((c.getFecha().isAfter(fechaInicio) && c.getFecha().isBefore(fechaFin))
						&& c.getCliente().equals(clienteBuscado)) {
					total += c.calcularTotal();
				}
			}
		}

		return total;
		
	}
	
	public float calcularTotal(LocalDate fecha, Cliente cliente) throws Exception {
		Cliente clienteBuscado = traerCliente(cliente.getDni());
		if(clienteBuscado == null) throw new Exception("Error: El cliente no existe!");
		
		float total = 0;
		for(Carrito c: carritos) {
			if(c.getFecha().isEqual(fecha) && c.getCliente().equals(clienteBuscado)) {
				total += c.calcularTotal();
			}
		}
		return total;
	}
	
	public float calcularTotal(int mes, int anio, Cliente cliente) throws Exception {
		Cliente clienteBuscado = traerCliente(cliente.getDni());
		if(clienteBuscado == null) throw new Exception("Error: El cliente no existe!");
		if(mes < 1 || mes > 12) throw new Exception("Error: El mes es incorrecto!");
		if(anio < 0 || anio > LocalDate.now().getYear()) throw new Exception("Error: El anio es incorrecto");
		
		float total = 0;
		for(Carrito c: carritos) {
			if(c.getFecha().getMonthValue() == mes && c.getFecha().getYear() == anio 
					&& c.getCliente().equals(clienteBuscado)) {
				total += c.calcularTotal();
			}
		}
		return total;
	}


	public List<Producto> getGondola() {
		return gondola;
	}

	public void setGondola(List<Producto> gondola) {
		this.gondola = gondola;
	}

	public List<Carrito> getCarritos() {
		return carritos;
	}

	public void setCarritos(List<Carrito> carritos) {
		this.carritos = carritos;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
}
