import java.util.Stack;
import javax.swing.JOptionPane;

public class Metodos {

    public void LlenarPila() {
        Stack<Repuestos> pila = new Stack<>();
        boolean continuar = true;
        String agregar = "";
        while (continuar) {

            Repuestos o = new Repuestos();

            o.setMarca(JOptionPane.showInputDialog("Ingrese la marca"));
            o.setReferencia(JOptionPane.showInputDialog("Ingrese la referencia"));
            o.setCantidad(Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad")));
            o.setPrecio(Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio")));
            pila.push(o);

            agregar = JOptionPane.showInputDialog("Desea agregar mas Registros S/N");

            if (agregar.equalsIgnoreCase("N")) {
                continuar = false;

            }

        }

        MostrarPila(pila);

        int opt = Integer.parseInt(JOptionPane.showInputDialog("ingrese 1: consultar, 2: eliminar ,3 modificar, 4 salir del programa "));
        
        if (opt != 5) {

            do {
            
                pila = AccionesRegistro(pila, opt);
                MostrarPila(pila);

                opt = Integer.parseInt(JOptionPane.showInputDialog("ingrese 1: consultar, 2: eliminar ,3 modificar, 4 vender repuesto, 5 salir del programa "));
    
            }
            while(opt != 5);
        }

        System.out.println("Programa finalizado");
        MostrarPila(pila);
        
    }

    public void MostrarPila(Stack<Repuestos> pila) {

        for (Repuestos o : pila) {

            System.out.println("Marca: " + o.getMarca());
            System.out.println("Color: " + o.getReferencia());
            System.out.println("Cantidad: " + o.getCantidad()); 
            System.out.println("Precio " + o.getPrecio());
            System.out.println();

        }

    }

    public Stack<Repuestos> AccionesRegistro(Stack<Repuestos> pila, int opt) {

        String dato = "";

        if (opt == 1) {

            dato = JOptionPane.showInputDialog("Ingrese el registro a consultar");

        }
        
        else if (opt == 2) {

            dato = JOptionPane.showInputDialog("Ingrese el registro al que desea eliminar");

        }
        
        else if (opt == 3) {

            dato = JOptionPane.showInputDialog("Ingrese el registro al que desea Modificar");

        }

        else {

            dato = JOptionPane.showInputDialog("Ingrese el repuesto que desea vender"); 

        }


        for (Repuestos Repuestos : pila) {

            if (Repuestos.getReferencia().equalsIgnoreCase(dato)) {

                if (opt == 1) {

                    System.out.println("El registro se encuentras y es: " + Repuestos.getMarca() + " " + Repuestos.getPrecio());

                }
                
                else if (opt == 2) {

                    pila.remove(Repuestos);

                }

                else if (opt == 3) {

                    Repuestos.setMarca(JOptionPane.showInputDialog("Ingrese la marca"));
                    Repuestos.setCantidad(Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad")));
                    Repuestos.setPrecio(Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio")));

                }

                else {

                    int cantidadV = 0, nuevaK = 0;
                    Double precioV = 0.0;
                    String respuesta = "";

                    do {

                        System.out.println("Referencia " + Repuestos.getReferencia() + "\nCantidad en almacén: " + Repuestos.getCantidad() + "\nPrecio por unidad: " + Repuestos.getPrecio());
                        cantidadV = Integer.parseInt(JOptionPane.showInputDialog("\nIngrese la cantidad a vender"));

                        precioV = cantidadV * Repuestos.getPrecio();

                        nuevaK = Repuestos.getCantidad() - cantidadV;

                        respuesta = JOptionPane.showInputDialog("Recibo de venta\nReferencia " + Repuestos.getReferencia() + "\nCantidad a vender: " + cantidadV + "\nPrecio total: " + precioV);

                        if (respuesta.equalsIgnoreCase("si")) {
                            
                            Repuestos.setCantidad(nuevaK);
                            System.out.println("Se ha vendido con exito " + cantidadV + " unidades");

                        }
                    
                    }

                    while (respuesta.equalsIgnoreCase("si"));
                        

                }

            }

        }

        return pila;

    }

}