import java.util.ArrayList;
import java.util.List;

public class Humano {

        String nombre;

    public Humano(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

}

class Empleado extends Humano {
    double sueldo;

    public Empleado(String nombre, double sueldo) {
        super(nombre);
        this.sueldo = sueldo;
    }

}

class Cliente extends Humano {
    boolean esMayorista;

    public Cliente(String nombre, boolean esMayorista) {
        super(nombre);
        this.esMayorista = esMayorista;
    }

    public boolean esMayorista() {
        return esMayorista;
    }



}

class Producto {
    String nombre;
    double precio;
    int cantidad;

    public Producto(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void reducirCantidad(int cantidadComprada) {
        if (cantidad >= cantidadComprada) {
            cantidad -= cantidadComprada;
        } else {
            System.out.println();
        }
    }
}

class Caja {
    int numero;
    Empleado empleado;

    public Caja(int numero, Empleado empleado) {
        this.numero = numero;
        this.empleado = empleado;
    }

    public int getNumero() {
        return numero;
    }

    public Empleado getEmpleado() {
        return empleado;
    }
}



class Transaccion {
    Cliente cliente;
    Caja caja;
    List<Producto> productosComprados;
    double totalPagado;

    public Transaccion(Cliente cliente, Caja caja) {
        this.cliente = cliente;
        this.caja = caja;
        this.productosComprados = new ArrayList<>();
        this.totalPagado = 0.0;
    }

    public void agregarProducto(Producto producto, int cantidad) {
        if (producto.getCantidad() >= cantidad) {
            producto.reducirCantidad(cantidad);
            productosComprados.add(producto);
            totalPagado += producto.getPrecio() * cantidad;
        } else {
            System.out.println("No se pudo agregar " + producto.getNombre() + " por falta de stock.");
        }
    }

    public void aplicarDescuentoMayorista() {
        if (cliente.esMayorista()) {
            totalPagado *= 0.7;
        }
    }

    public void mostrarDetalles() {
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("Atendido por: " + caja.getEmpleado().getNombre() + " en la caja " + caja.getNumero());
        System.out.println("Productos comprados:");
        for (Producto producto : productosComprados) {
            System.out.println("- " + producto.getNombre() + " (Precio: " + producto.getPrecio() + ")");
        }
        System.out.println("Total pagado: " + totalPagado);
    }
}





