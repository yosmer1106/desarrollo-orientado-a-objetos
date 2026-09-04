public class ReservaSimple extends Reserva{

    //Precio fijo de la habitacion por noche
    //Estático = no cambia = NO TOCAR

    private static final int PRECIO_NOCHE = 45000;

    //Constructor


    public ReservaSimple(String codigo, String nombreHuesped, String fechaIngreso, int noches, int cantidadPersonas) throws ReservaException {
        super(codigo, nombreHuesped, fechaIngreso, noches, cantidadPersonas);
    }

    //Implementamos los métodos obligatorios
    @Override
    public  String obtenerTipo(){
        return "Reserva simple";
    }

    //Calcular el total de la estadia en el hotel
    @Override
    public int calcularTotal(){
        return PRECIO_NOCHE * getNoches();
    }
}