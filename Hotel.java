import java.sql.SQLOutput;
import java.util.ArrayList;

public class Hotel implements GestionReservas{


    private String nombre;
    private String ciudad;
    private ArrayList<Reserva> reservas;

    public Hotel(String nombre, String ciudad) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.reservas = new ArrayList<>();
    }

    @Override
    public void agregarReserva(Reserva reserva)throws ReservaException {
        if(buscarPorCodigo(reserva.getCodigo())!=null){
            throw new  ReservaException ("Error ya existe una reserva");
        }
        reservas.add(reserva);
    }

    @Override
    public Reserva buscarPorCodigo(String codigo){
        for(Reserva reserva : reservas){
            if (reserva.getCodigo().equalsIgnoreCase(codigo)){
                return reserva;
            }
        }
        return null;
    }

    //Retorna la lista completa
    @Override
    public ArrayList<Reserva> obtenerReservas(){
        return reservas;
    }

    //
    public void listarReservas(){
        if (reservas.isEmpty()){
            System.out.println("No hay reservas registradas");
            return;
        }
        for(Reserva reserva : reservas){
            System.out.println(reserva.obtenerDetalle());
        }
    }

    //Calcular total de los ingresos de todas las reservas Polimorfismo
    public int calcularIngresos(){
        int total = 0;
        //Cada reserva calcula su total según su propia clase
        for(Reserva reserva : reservas){
            total += reserva.calcularTotal();
        }
        return total;
    }

    public void mostrarResumen(){
        System.out.println("Hotel: "+ nombre);
        System.out.println("Hotel: "+ ciudad);
        System.out.println("Reservas Registradas: " + reservas.size());
        System.out.println("Ingresos estimados: $ "+ calcularIngresos());

    }
}
