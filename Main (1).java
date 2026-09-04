import java.util.Scanner;

public class Main {
    static Scanner entrada = new Scanner(System.in);
    public static void main (String[] args){

        Hotel hotel = new Hotel("Ibis", "Puerto Montt");

        //almacenar la opción que el usuario escribe
        int opcion = 0;

        //bucle para el menú While
        //usuario escoja 5 el bucle se detiene
        while (opcion != 5){

            mostrarMenu();

            try{
                opcion = leerEntero("Seleccione una opción");

                //swittch para validar la opciones del menú
                switch (opcion){
                    case 1:
                        registrarReserva(hotel);
                        break;
                    case 2:
                        hotel.listarReservas();
                        break;

                    case 3:
                        buscarReserva(hotel);

                    case 4:
                        hotel.mostrarResumen();
                        break;

                    case 5:
                        System.out.println("saliendo del sistema...");

                        //cuando el usuario escribe un número = 10
                    default:
                        System.out.println("opción no válida");
                }
            }catch (Exception error){
                System.out.println("error: "+ error.getMessage());
            }
        }
        entrada.close();//cerramos Scanner
    }
    //métod o para mostra el menú
    static void mostrarMenu(){
        System.out.println("\n HOTEL IBIS DE PUERTO MONTT");
        System.out.println("1. Registrar Reserva");
        System.out.println("2. Listar Reservas");
        System.out.println("3. Buscar Reserva");
        System.out.println("4. Ver resumen");
        System.out.println("5. Salir de Ibis");
    }

    static void registrarReserva(Hotel hotel) throws Exception{
        String codigo = leerTexto("Código de reserva: ");
        String huesped = leerTexto("Nombre del huesped: ");
        String fecha = leerTexto("Fecha de ingreso");
        int personas = leerEntero("Cantidad de personas");
        int noches = leerEntero("Cantidad de noches : ");



        //mmostramos las habitaciones posibles
        System.out.println("Tipo de habitación ");
        System.out.println("1. Simple ");
        System.out.println("2. Familiar ");

        //Guardamos la habitación seleccionada
        int tipo = leerEntero("Seleccione Tipo");

        Reserva reserva;

        if(tipo==1){
            reserva = new ReservaSimple(codigo, huesped, fecha, noches, personas);
        }else if (tipo==2){
            //agrego una reserva FAMILIAR
            reserva = new ReservaFamiliar(codigo, huesped, fecha, noches, personas);
        }else {
            throw new Exception("Tipo de reserva no válido");
        }
        hotel.agregarReserva(reserva);
        System.out.println("Reserva agregada correctamente");
    }

    //buscar una reserva
    static void buscarReserva(Hotel hotel){
        String codigo = leerTexto("Código a buscar");

        Reserva reserva = hotel.buscarPorCodigo(codigo);

        if (reserva==null){
            System.out.println("Reserva no encontreada");
        }else {
            System.out.println(reserva.obtenerDetalle());
        }
    }

    static String leerTexto(String mensaje){
        System.out.println(mensaje);
        return entrada.nextLine().trim();
    }
    static int leerEntero(String mensaje){
        System.out.println(mensaje);
        return Integer.parseInt(entrada.nextLine());
    }

}

