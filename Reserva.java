public abstract class Reserva {

    private String codigo;
    private String nombreHuesped;
    private String fechaIngreso;
    private int noches;
    private int cantidadPersonas;

    public Reserva(String codigo, String nombreHuesped, String fechaIngreso, int noches, int cantidadPersonas)
            throws ReservaException{

        //validamos algunos datos erroneos
        if(codigo==null || codigo.trim().isEmpty() || nombreHuesped==null || nombreHuesped
                .trim().isEmpty() || fechaIngreso ==null || fechaIngreso.trim().isEmpty()){
            throw new ReservaException("Código, Nombre del huesped y la fecha son campos obligatorios");
        }

        //validamos los datos enteros erroneos
        if(noches <=0 || cantidadPersonas <= 0){
            throw new ReservaException("La cantidad de noches y la cantidad de personas debe ser mayor a 0");
        }

        //crear un nuevo objeto -> reserva
        this.codigo = codigo;
        this.nombreHuesped = nombreHuesped;
        this.fechaIngreso = fechaIngreso;
        this.noches = noches;
        this.cantidadPersonas = cantidadPersonas;
    }

    //getters

    public String getCodigo() {
        return codigo;
    }

    public int getNoches() {
        return noches;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    //Al declarar una clase abstracta, obligo a los herederos a implementar dichos métodos
    //Métodos abstractos
    public abstract String obtenerTipo();

    //Calcular el total de la reserva
    public abstract int calcularTotal();

    //método normal
    public String obtenerDetalle(){
        return "Código : " + codigo
                + "| Huesped : " +nombreHuesped
                + "| Fecha : " +fechaIngreso
                + "| Tipo : " +obtenerTipo()
                + "| Noches : " +noches
                + "| Personas : " +cantidadPersonas
                + "| Total : " +calcularTotal();
    }

}

