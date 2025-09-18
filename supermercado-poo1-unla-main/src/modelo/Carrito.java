package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Carrito {
	private int idCarrito;
	private LocalDate fecha;
	private LocalTime hora;
	private List<ItemCarrito> listaItems;
	private Cliente cliente;
	
	
	public Carrito(int idCarrito, LocalDate fecha, LocalTime hora, Cliente cliente) throws Exception {
		super();
		this.idCarrito = idCarrito;
		this.fecha = fecha;
		this.hora = hora;
		this.listaItems = new ArrayList<ItemCarrito>();
		this.setCliente(cliente);
	}
	
	
	public boolean agregarItem(Producto producto, int cantidad) throws Exception {
		
		boolean agregado = false;
		ItemCarrito itemCarrito = traerItemCarrito(producto);
		if(itemCarrito != null) {
			itemCarrito.setCantidad(itemCarrito.getCantidad()+cantidad);
			//lo cambiamos a true?
		} else {
			int ultimoId = 1;
			if(listaItems.size() > 0) ultimoId = listaItems.get(listaItems.size()-1).getIdItem()+1;
			agregado = listaItems.add(new ItemCarrito(ultimoId,producto,cantidad));
		}
		
	
		return agregado;
	}
	
	public boolean eliminarItem(Producto producto, int cantidad) throws Exception {
		boolean eliminado = false;
		ItemCarrito itemCarritoBuscado = traerItemCarrito(producto);
		
		if(itemCarritoBuscado == null) throw new Exception("Error: El producto no existe en el carrito");
		
		
		//no es mejor devolver true literal?
		if(itemCarritoBuscado.getCantidad() == cantidad) {
			eliminado = listaItems.remove(itemCarritoBuscado);
		}else {
			itemCarritoBuscado.setCantidad(itemCarritoBuscado.getCantidad()-cantidad);
			eliminado = true;
		}
		
		return eliminado;
		
		
	}
	
	public ItemCarrito traerItemCarrito(Producto producto) {
		ItemCarrito itemBuscado = null;
		int index = 0;
		boolean encontrado = false;
		if(listaItems.size() > 0 && producto != null) {
			while(index < listaItems.size() && !encontrado) {
				
				if(listaItems.get(index).getProducto().getProducto().equalsIgnoreCase(producto.getProducto())){
					encontrado = true;
					itemBuscado = listaItems.get(index);
				}
					
				index++;
			}
		}
		return itemBuscado;
		
	}
	
	
	public float calcularTotal() {
		float total = 0;
		for(ItemCarrito i : listaItems) {
			total = total + i.calcularSubTotal();
		}
		return total;
	}
	
	
	
	public int getIdCarrito() {
		return idCarrito;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) throws Exception {
		if(fecha != null) throw new Exception("Error: La fecha no puede ser nula!");
		this.fecha = fecha;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) throws Exception {
		if(hora != null) throw new Exception("Error: La hora no puede ser nula!");
		this.hora = hora;
	}

	public List<ItemCarrito> getListaItems() {
		return listaItems;
	}

	public void setListaItems(List<ItemCarrito> listaItems) {
		this.listaItems = listaItems;
	}


	
	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) throws Exception {
		if(cliente == null) throw new Exception("Error: El cliente no puede ser nulo!");
		this.cliente = cliente;
	}


	@Override
	public String toString() {
		return "Carrito [idCarrito=" + idCarrito + ", fecha=" + fecha + ", hora=" + hora + ", listaItems= \n" + listaItems
				+ "\n, cliente=" + cliente + "]";
	}
	





	
}
