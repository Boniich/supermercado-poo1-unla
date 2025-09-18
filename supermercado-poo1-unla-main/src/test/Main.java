package test;

import java.time.LocalDate;
import java.time.LocalTime;

import modelo.Cliente;
import modelo.Supermercado;

public class Main {

	public static void main(String[] args) {
		
		Supermercado supermercado = new Supermercado();
		
		try {
			//Test 1 agregar los sig 3 prod
			System.out.println("test 1");
			supermercado.agregarProducto("Fideos most", 1000);
			supermercado.agregarProducto("Aceite", 1000);
			supermercado.agregarProducto("fideos tir", 5000);
			System.out.println(supermercado.getGondola());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		try {
			//intentar agregar Aceite nuevamente
			System.out.println("test 2");
			supermercado.agregarProducto("Aceite", 1000);
			System.out.println(supermercado.getGondola());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		try {
			boolean modificado = supermercado.modificarProducto(1, "Arroz", 5000);
			System.out.println("El producto fue modificado con exito? "+modificado);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		try {
			boolean modificado = supermercado.modificarProducto(10, "Arroz", 5000);
			System.out.println("El producto fue modificado con exito? "+modificado);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		try {
			boolean modificado = supermercado.modificarProducto(1, "", 5000);
			System.out.println("El producto fue modificado con exito? "+modificado);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		try {
			boolean modificado = supermercado.modificarProducto(1, "asas", -5);
			System.out.println("El producto fue modificado con exito? "+modificado);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		System.out.println("\n---- Caso de uso: Agregar Clientes ----\n");
		
		System.out.println("\n--- Agregamos clientes con exito ---\n");
		try {
			boolean agregado = supermercado.agregarCliente("Ezequiel", 36069300, "Calle falsa 123");
			if(agregado)
				System.out.println("El cliente agregado es: "+supermercado.traerCliente(36069300));
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		try {
			boolean agregado = supermercado.agregarCliente("Juan", 2500000, "Calle falsa 123");
			if(agregado)
				System.out.println("El cliente agregado es: "+supermercado.traerCliente(2500000));
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		System.out.println("\n--- Agregamos un cliente ya existente ---\n");
		
		try {
			boolean agregado = supermercado.agregarCliente("Ezequiel", 36069300, "Calle falsa 123");
			if(agregado)
				System.out.println("El cliente agregado es: "+supermercado.traerCliente(36069300));
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		System.out.println("\n---- Caso de uso: Eliminar Clientes ----\n");
		
		System.out.println("\n--- Eliminamos un cliente con exito ---\n");
		
		try {
			boolean eliminado = supermercado.eliminarCliente(36069300);
			if(eliminado) System.out.println("Cliente eliminado con exito!");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		System.out.println("\n--- Intentamos eliminar un cliente que no existe ---\n");
		
		try {
			boolean eliminado = supermercado.eliminarCliente(4556562);
			if(eliminado) System.out.println("Cliente eliminado con exito!");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		
		
		System.out.println("\n---- Caso de uso: Agregar carritos ----\n");
		
		System.out.println("\n--- Agregamos carritos con exito ---\n");
	
		try {
			LocalDate fecha = LocalDate.of(2025, 9, 17);
			LocalTime hora = LocalTime.of(18, 49);
			Cliente cliente = supermercado.traerCliente(2500000);
			boolean agregado = supermercado.agregarCarrito(fecha,hora,cliente);
			if(agregado) System.out.println(supermercado.traerCarrito(fecha, hora, cliente));
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		try {
			LocalDate fecha = LocalDate.of(2025, 9, 17);
			LocalTime hora = LocalTime.of(22, 10);
			Cliente cliente = supermercado.traerCliente(2500000);
			boolean agregado = supermercado.agregarCarrito(fecha,hora,cliente);
			if(agregado) System.out.println(supermercado.traerCarrito(fecha, hora, cliente));
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		try {
			LocalDate fecha = LocalDate.of(2025, 9, 18);
			LocalTime hora = LocalTime.of(22, 10);
			Cliente cliente = supermercado.traerCliente(2500000);
			boolean agregado = supermercado.agregarCarrito(fecha,hora,cliente);
			if(agregado) System.out.println(supermercado.traerCarrito(fecha, hora, cliente));
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		System.out.println("\n---- Caso de uso: Agregar items al carrito ----\n");
		
		System.out.println("\n--- Agregamos items con exito ---\n");
		
		
		try {
			supermercado.AgregarItemAlCarrito(1, supermercado.traerProducto(1), 2);
			supermercado.AgregarItemAlCarrito(1, supermercado.traerProducto(1), 2);
			supermercado.AgregarItemAlCarrito(1, supermercado.traerProducto(2), 2);
			
			 System.out.println(supermercado.traerCarrito(1));
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		try {
			supermercado.AgregarItemAlCarrito(2, supermercado.traerProducto(1), 5);
			supermercado.AgregarItemAlCarrito(2, supermercado.traerProducto(2), 3);
			
			 System.out.println(supermercado.traerCarrito(1));
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		try {
			supermercado.AgregarItemAlCarrito(3, supermercado.traerProducto(1), 1);
			
			 System.out.println(supermercado.traerCarrito(1));
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		System.out.println("El total del carrito con id 1 es: "+supermercado.traerCarrito(1).calcularTotal());
		System.out.println("El total del carrito con id 2 es: "+supermercado.traerCarrito(2).calcularTotal());
		System.out.println("El total del carrito con id 3 es: "+supermercado.traerCarrito(3).calcularTotal());

		try {
			System.out.println("El total del cliente 2500000 es: "+supermercado.calcularTotal(supermercado.traerCliente(2500000)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
		
		
		LocalDate fechaInicio = LocalDate.of(2025, 9, 17);
		LocalDate fechaFin = LocalDate.of(2025, 9, 18);
		System.out.println("El total entre la fecha 2025-9-17 y la fecha 2025-9-18 es: "
		+supermercado.calcularTotal(fechaInicio, fechaFin));
		
		System.out.println("El total de la fecha 2025 9 17 es: "+supermercado.calcularTotal(fechaInicio));
		
		try {
			System.out.println("El total del mes 9 del anio 2025 es: "+supermercado.calcularTotal(9, 2025));
		} catch (Exception e) {
			System.err.println(e.getMessage());

		}
		
		try {
			System.out.println("El total del mes 9 del anio 2025 es: "+supermercado.calcularTotal(1, 2025));
		} catch (Exception e) {
			System.err.println(e.getMessage());

		}


		


	}

}
