package modelo;

public class ItemCarrito {

	private int idItem;
	private Producto producto;
	private int cantidad;
	
	
	public ItemCarrito(int idItem, Producto producto, int cantidad) throws Exception {
		super();
		this.idItem = idItem;
		this.setProducto(producto);
		this.setCantidad(cantidad);
	}
	
	public float calcularSubTotal() {
		return getProducto().getPrecio()*getCantidad();
	}
	
	
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) throws Exception {
		if(producto == null) throw new Exception("Error: El producto no puede ser null!");
		this.producto = producto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) throws Exception {
		if(cantidad < 1) throw new Exception("Error: La cantidad no puede ser menor a 1");
		this.cantidad = cantidad;
	}
	public int getIdItem() {
		return idItem;
	}


	@Override
	public String toString() {
		return "\n [idItem=" + idItem + ", producto=" + producto + ", cantidad=" + cantidad + "]\n";
	}
	
	
	
}
