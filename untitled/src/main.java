public class main {
    public static void main(String[] args) {


        // SIMULACION DE COMPRA CON CARGA DE EMPLEADO Y CAJA


        Empleado empleado1 = new Empleado("Facundo", 60000);


        Caja caja1 = new Caja(1, empleado1);


        Producto producto1 = new Producto("Yerba", 3000, 16);
        Producto producto2 = new Producto("Maple Huevo", 4500, 10);
        Producto producto3 = new Producto("Servilletas de papel", 1500, 10);

        Cliente cliente1 = new Cliente("Patricio", true);

        Transaccion transaccion1 = new Transaccion(cliente1, caja1);
        transaccion1.agregarProducto(producto1, 5);
        transaccion1.agregarProducto(producto2, 2);
        transaccion1.agregarProducto(producto3, 3);

        transaccion1.aplicarDescuentoMayorista();

        transaccion1.mostrarDetalles();
    }
}
