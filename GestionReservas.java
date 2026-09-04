import java.util.ArrayList;

public interface GestionReservas {

    void agregarReserva(Reserva reserva)throws ReservaException;

    Reserva buscarPorCodigo(String codigo);

    ArrayList<Reserva> obtenerReservas();
}
