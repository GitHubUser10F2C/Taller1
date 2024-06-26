package cl.ucn.model;

import java.util.Arrays;
import java.util.List;

public abstract class Carta {
    private int id;
    private String nombre;
    private String presencia;
    private int nivel;
    private String descripcion;

    private static int contadorId = 0;

    private static final List<String> presencias =
            Arrays.asList("fuego", "tierra", "aire", "agua", "éter", "santo", "destrucción");

    private static final List<String> presenciasCodigo =
            Arrays.asList("\033[31m", "\033[32m", "\033[36m", "\033[34m", "\033[33m", "\033[37m", "\033[30m");

    public Carta(String nombre, int nivel, String presencia, String descripcion) {
        this.id = ++contadorId;
        this.nombre = nombre;
        this.nivel = nivel;
        this.presencia = presencia;
        this.descripcion = descripcion;
    }

    /**
     * método que genera una cadena de texo a ser impreso por consola, que muestra todos los atributos de la carta
     * @return la cadena de texto
     */
    public abstract String aStringDetallado();

    /**
     * método que genera una cadena de texto a ser impreso por consola, que representa a la carta, muestra su nombre y
     * descripción
     * @return la cadena de texto
     */
    public String aStringSimple(){
        int largoNombre = nombre.length();
        int largoDescripcion = descripcion.length();
        String trozoDescripcion = "";
        String retorno = "";
        retorno+= getCodigo();

        retorno+="---------------------\n";

        retorno+="| ";
        retorno+=nombre;
        retorno+= " ".repeat(15-largoNombre);
        retorno += "   |\n";

        retorno += "|-------------------|\n";
        retorno+= "|                   |\n".repeat(2);
        retorno += "|-------------------|\n";

        int lineasDescripcion = (largoDescripcion/19)+1;
        for (int i=0; i < lineasDescripcion; i++){
            retorno+="|";
            trozoDescripcion = descripcion.substring(i*19,Math.min(i*19 + 19, descripcion.length()));
            retorno+=trozoDescripcion;
            retorno+= " ".repeat(19-trozoDescripcion.length());
            retorno += "|\n";
            if (i>4){
                break;
            }
        }
        retorno+= "|                   |\n".repeat(Math.max(0,4-lineasDescripcion));
        retorno+="|||||||||||||||||||||"+"\u001B[0m"+"\n";
        return retorno;
    }

    /**
     * método que genera una cadena de texto a ser almacenada en un archivo de salida, con toda la información de
     * la carta
     * @return la cadena de texto
     */
    public abstract String aStringArchivoSalida();

    /**
     * obtiene el código de color correspondiente a la presencia de la carta
     * @return el código de color de la carta, que permite imprimir dicha carta a color desde consola
     */
    private String getCodigo(){
        return presenciasCodigo.get(presencias.indexOf(presencia));
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPresencia() {
        return presencia;
    }

    public int getNivel() {
        return nivel;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
