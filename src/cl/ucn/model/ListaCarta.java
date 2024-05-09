package cl.ucn.model;

import java.util.ArrayList;

public class ListaCarta extends ArrayList<Carta> {

    public ListaCarta(){
        super();
    }

    /**
     * método que busca una carta por su nombre
     * @param nombre de la carta a buscar
     * @return true: encuentra la carta, false: no encuentra la carta
     */
    public boolean cartaExistePorNombre(String nombre){
        for (Carta carta : this){
            if (nombre.equals(carta.getNombre())){
                return true;
            }
        }
        return false;
    }

    /**
     * método que genera una cadena de texto a ser impreso por consola, que lista todas las cartas de la galería.
     * Muestra su nombre y descripción
     * @return la cadena de texto
     */
    public String aStringSimple(){
        String retorno = "";
        for (Carta carta : this){
            retorno+=carta.aStringSimple();
        }
        return retorno;
    }

    /**
     * método que genera una cadena de texto a ser almacenada en un archivo de salida, con toda la información de todas
     * las cartas de la galería
     * @return la cadena de texto
     */
    public String aStringArchivoSalida(){
        String retorno = "";
        for (Carta carta : this){
            retorno+=carta.aStringArchivoSalida();
        }
        return retorno;
    }

    /**
     * método que genera una cadena de texo a ser impreso por consola, que lista todas las cartas de la galería.
     * Muestra todos los atributos de las cartas, para un tipo de presencia determinada
     * @param presencia filtro aplicado a la galería
     * @return la cadena de texto
     */
    public String aStringDetallado(String presencia){
        String retorno = "";
        for (Carta carta : this){
            if (presencia.equals(carta.getPresencia())){
                retorno+=carta.aStringDetallado();
            }
        }
        return retorno;
    }

    /**
     * método que elimina una carta del sistema, dado su nombre
     * @param nombre de la carta a eliminar
     * @return true: se encontró y eliminó la carta, false: no se encontró la carta, por lo que no se eliminó
     */
    public boolean eliminarCartaPorNombre(String nombre){
        for (Carta carta : this){
            if (nombre.equals(carta.getNombre())){
                remove(carta);
                return true;
            }
        }
        return false;
    }

    /**
     * método que elimina una carta del sistema, dado su ID
     * @param id de la carta a eliminar
     * @return true: se encontró y eliminó la carta, false: no se encontró la carta, por lo que no se eliminó
     */
    public boolean eliminarCartaPorId(int id){
        for (Carta carta : this){
            if (id == carta.getId()){
                remove(carta);
                return true;
            }
        }
        return false;
    }
}
