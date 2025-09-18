package modelo;

public class Producto {

	private int idProducto;
	private String producto;
	private float precio;
	
	public Producto(int idProducto, String producto, float precio) throws Exception {
		this.idProducto = idProducto;
		this.setProducto(producto);
		this.setPrecio(precio);
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) throws Exception {
		if(producto.isEmpty()) throw new Exception("Error: no se puede dejar vacio el nombre del producto");
		this.producto = producto;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) throws Exception {
		if(precio < 0) throw new Exception("Error: El precio no debe ser negativo");
		this.precio = precio;
	}

	public int getIdProducto() {
		return idProducto;
	}

	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", producto=" + producto + ", precio=" + precio + "]";
	}
	

	
}
