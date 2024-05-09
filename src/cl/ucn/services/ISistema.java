package cl.ucn.services;

public interface ISistema {
    boolean agregarEntidad(String nombre, int nivel, String presencia, String descripcion,
                           int poderFisico, int poderMagico, int proteccionFisica, int proteccionMagica);
    boolean agregarDestreza(String nombre, int nivel, String presencia, String descripcion,
                            int potencia, String tipo);
    String verCartas();
    String verCartas(String presencia);
    boolean eliminarCarta(String nombre) throws Exception;
    boolean eliminarCarta(int id) throws Exception;
    String generarArchivoSalida();
}
