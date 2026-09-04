public class ReservaFamiliar extends Reserva {

    //Atributos especificos

    private static final int PRECIO_NOCHE = 80000;
    private static final int EXTRA_PERSONA = 5000;

    //Constructor

    public ReservaFamiliar(String codigo, String nombreHuesped, String fechaIngreso, int noches, int cantidadPersonas) throws ReservaException {
        super(codigo, nombreHuesped, fechaIngreso, noches, cantidadPersonas);
    }

    //Implementar los metodos abstractos
    @Override
    public String obtenerTipo(){
        return "Reserva Familiar";
    }
    //Calcular el total de la estadia en el hotel
    @Override
    public int calcularTotal(){
        return (PRECIO_NOCHE * getNoches() + EXTRA_PERSONA * getCantidadPersonas());
    }
}
