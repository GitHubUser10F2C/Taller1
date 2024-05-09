package cl.ucn.services;

public interface ISistema {
    /**
     * funcionalidad del sistema que permite agregar una entidad a la galería, dados los datos pedidos.
     * @param nombre de la carta
     * @param nivel de la carta
     * @param presencia de la carta
     * @param descripcion de la carta
     * @param poderFisico de la carta
     * @param poderMagico de la carta
     * @param proteccionFisica de la carta
     * @param proteccionMagica de la carta
     * @return true: si el nombre es único y se agregó la carta al sistema, false: si el nombre estaba repetido y no se
     * agregó la carta al sistema
     */
    boolean agregarEntidad(String nombre, int nivel, String presencia, String descripcion,
                           int poderFisico, int poderMagico, int proteccionFisica, int proteccionMagica);

    /**
     * funcionalidad del sistema que permite agregar una destreza a la galeria, dados los datos pedidos
     * @param nombre de la carta
     * @param nivel de la carta
     * @param presencia de la carta
     * @param descripcion de la carta
     * @param potencia de la carta
     * @param tipo de la carta
     * @return true: si el nombre es único y se agregó la carta al sistema, false: si el nombre estaba repetido y no se
     * agregó la carta al sistema
     */
    boolean agregarDestreza(String nombre, int nivel, String presencia, String descripcion,
                            int potencia, String tipo);

    /**
     * funcionalidad del sistema que permite visualizar de manera simple las cartas de la galeria
     * @return String con formato particular que permite ver información no detallada de las cartas de la galería
     */
    String verCartas();

    /**
     * funcionalidad del sistema que permite visualisar de manera detallada las cartas de la galeria con una
     * presencia determinada.
     * @param presencia filtro aplicado a la galería.
     * @return String con formato particular que permite ver información detallada de las cartas de la galería que
     * poseen la presencia ingresada por parámetro.
     */
    String verCartas(String presencia);

    /**
     * funcionalidad del sistema que permite eliminar una carta del sistema, dado su nombre
     * @param nombre de la carta a eliminar
     * @return true si existia una carta con ese nombre y fue eliminada, false si no existía una carta con ese nombre
     * y por tanto no se eliminó.
     * @throws Exception cuando no hay cartas en el sistema
     */
    boolean eliminarCarta(String nombre) throws Exception;

    /**
     * funcionalidad del sistema que permite eliminar una carta del sistema, dado su ID
     * @param id de la carta a eliminar
     * @return true: si existia una carta con ese ID y fue eliminada, false: si no existía una carta con ese ID
     * y por tanto no se eliminó.
     * @throws Exception cuando no hay cartas en el sistema
     */
    boolean eliminarCarta(int id) throws Exception;

    /**
     * funcionalidad del sistema que genera una cadena de texto a ser almacenada en un archivo de salida
     * @return la cadena de texto
     */
    String generarArchivoSalida();
}
