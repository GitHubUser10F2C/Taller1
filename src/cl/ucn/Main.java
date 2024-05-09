package cl.ucn;

import cl.ucn.services.ISistema;
import cl.ucn.utils.Instalador;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        ISistema sistema = instalarSistema();
        LeerArchivoEntrada(sistema);
        menuPrincipal(sistema);
    }

    /**
     * lee el archivo de texto 'galería.txt', para agregar al sistema la información almacenada ahí
     * @param sistema
     */
    private static void LeerArchivoEntrada(ISistema sistema) {
        try {
            File archivoEntrada = new File("galeria.txt");
            Scanner myReader = new Scanner(archivoEntrada);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                try{
                    agregarCartaDesdeArchivo(sistema,data);
                }
                catch (Exception e){
                    System.out.println("Error al leer una de las cartas de 'galeria.txt'");
                }
            }
            myReader.close();
        } catch (Exception e) {
            System.out.println("Ocurrio un error al intentar leer las cartas desde 'galeria.txt");
            e.printStackTrace();
        }
    }

    /**
     * lee un string para agregar al sistema la información de cartas almacenadas ahí.
     * la información del string se lee con el siguiente formato para cada linea:
     * [Destreza/Entidad];;;[DatosDestreza/DatosEntidad]
     * si el primer campo es 'Destreza', el formato para esa línea de texto es:
     * Destreza;;;[nombre];;;[nivel];;;[presencia];;;[descripcion];;;[potencia];;;[tipo]
     * si el primer campo es 'Entidad', el formato para esa linea de texto es:
     * Entidad;;[nombre];;;[nivel];;;[presencia];;;[descripcion];;;[poder fisico];;;[poder magico];;;
     * [proteccion fisica];;;[proteccion magica]
     * @param sistema
     * @param data string a leer
     * @throws Exception si ocurre un error durante la lectura del archivo
     */
    private static void agregarCartaDesdeArchivo(ISistema sistema, String data) throws Exception {
        String[] partes = data.split(";;;");
        if (partes[0].equals("Destreza")){
            String nombre = partes[1];
            int nivel = Integer.parseInt(partes[2]);
            String presencia = partes[3];
            String descripcion = partes[4];
            int potencia = Integer.parseInt(partes[5]);
            String tipo = partes[6];
            sistema.agregarDestreza(nombre,nivel,presencia,descripcion,potencia,tipo);
        }
        else if (partes[0].equals("Entidad")){
            String nombre = partes[1];
            int nivel = Integer.parseInt(partes[2]);
            String presencia = partes[3];
            String descripcion = partes[4];
            int poderFisico = Integer.parseInt(partes[5]);
            int poderMagico = Integer.parseInt(partes[6]);
            int proteccionFisica = Integer.parseInt(partes[7]);
            int proteccionMagica = Integer.parseInt(partes[8]);
            sistema.agregarEntidad(nombre,nivel,presencia,descripcion,
                    poderFisico,poderMagico,proteccionFisica,proteccionMagica);
        }
        else{
            throw new Exception("Error al leer una de las cartas de 'galeria.txt'");
        }
    }

    public static ISistema instalarSistema(){
        return new Instalador().instalarSistema();
    }

    /**
     * menu principal de la aplicación desde el cual se puede acceder a todas las funcionalidad del sistema
     * @param sistema
     */
    public static void menuPrincipal(ISistema sistema){
        System.out.println("\nBienvenido a la galería de cartas");
        while (true) {
            System.out.println("Elija una opción:");
            System.out.println("1. Agregar carta");
            System.out.println("2. Ver cartas");
            System.out.println("3. Eliminar carta");
            System.out.println("4. Guardar y salir");
            String input = in.nextLine();
            switch(input) {
                case "1":
                    agregarCarta(sistema);
                    break;
                case "2":
                    verCartas(sistema);
                    break;
                case "3":
                    eliminarCarta(sistema);
                    break;
                case "4":
                    guardarSalir(sistema);
                    return;
                default:
                    System.out.println("Debe elegir una opción del 1 al 4");
            }
        }
    }

    /**
     * pregunta al usuario si quiere agregar una destreza o una entidad al sistema, para despues solicitarle
     * los datos necesarios y agregar dicha destreza o entidad
     * @param sistema
     */
    private static void agregarCarta(ISistema sistema){
        while (true) {
            System.out.println("Elija una opción:");
            System.out.println("1. Agregar destreza");
            System.out.println("2. Agregar entidad");
            System.out.println("3. Regresar");
            String input = in.nextLine();
            switch(input) {
                case "1":
                    agregarDestreza(sistema);
                    break;
                case "2":
                    agregarEntidad(sistema);
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Debe elegir una opción del 1 al 3");
            }
        }
    }

    /**
     * solicita los datos necesarios al usuario para agregar una carta de entidad al sistema
     * @param sistema
     */
    private static void agregarEntidad(ISistema sistema) {
        String nombre = solicitarNombre();
        int nivel = solicitarNivel();
        String presencia = solicitarPresencia();
        String descripcion = solicitarDescripcion();
        int poderFisico = solicitarInt("poder físico");
        int poderMagico = solicitarInt("poder mágico");
        int proteccionFisica = solicitarInt("protección física");
        int proteccionMagica = solicitarInt("protección mágica");

        if (sistema.agregarEntidad(nombre,nivel,presencia,descripcion,
                poderFisico,poderMagico,proteccionFisica,proteccionMagica)){
            System.out.println("La carta se ha agregado correctamente");
        }
        else{
            System.out.println("Error: el nombre ingresado ya existe en el sistema");
        }
    }

    /**
     * solicita los datos necesarios al usuario para agregar una carta de destreza al sistema
     * @param sistema
     */
    private static void agregarDestreza(ISistema sistema) {
        String nombre = solicitarNombre();
        int nivel = solicitarNivel();
        String presencia = solicitarPresencia();
        String descripcion = solicitarDescripcion();
        int potencia = solicitarInt("potencia");
        String tipo = solicitarTipo();

        if (sistema.agregarDestreza(nombre,nivel,presencia,descripcion,potencia,tipo)){
            System.out.println("La carta se ha agregado correctamente");
        }
        else{
            System.out.println("Error: el nombre ingresado ya existe en el sistema");
        }
    }

    /**
     * Imprime por consola todas las cartas del sistema, para posteriormente consultar si desea filtrar los resultados
     * según la presencia de las cartas.
     * @param sistema
     */
    private static void verCartas(ISistema sistema){
        String cartas = sistema.verCartas();
        if (cartas.equals("")){
            System.out.println("No hay cartas en el sistema");
            return;
        }
        System.out.println(cartas);
        while (true) {
            System.out.println("Elija una opción:");
            System.out.println("1. Filtrar");
            System.out.println("2. Regresar");
            String input = in.nextLine();
            switch(input) {
                case "1":
                    verCartasConFiltro(sistema);
                    break;
                case "2":
                    return;
                default:
                    System.out.println("Debe elegir una opción del 1 al 2");
            }
        }
    }

    /**
     * Solicita al usuario una presencia de carta, para posteriormente imprimir a detalle por consola todas las
     * cartas con esa presencia
     * @param sistema
     */
    private static void verCartasConFiltro(ISistema sistema) {
        String presencia = solicitarPresencia();
        String cartas = sistema.verCartas(presencia);
        if (cartas.equals("")){
            System.out.println("No hay cartas de "+presencia+" registradas en el sistema");
        }
        System.out.println(cartas);
    }

    /**
     * Solicita al usuario su preferencia entre eliminar una carta según su nombre o según su ID, para posteriormente
     * solicitar dicho dato e inentar eliminar la carta.
     * @param sistema
     */
    private static void eliminarCarta(ISistema sistema){
        String cartas = sistema.verCartas();
        if (cartas.equals("")){
            System.out.println("No hay cartas en el sistema");
            return;
        }
        while (true) {
            System.out.println("Elija una opción:");
            System.out.println("1. Eliminar por nombre");
            System.out.println("2. Eliminar por ID");
            System.out.println("3. Regresar");

            String input = in.nextLine();
            switch(input) {
                case "1":
                    eliminarCartaPorNombre(sistema);
                    break;
                case "2":
                    eliminarCartaPorId(sistema);
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Debe elegir una opción del 1 al 3");
            }
        }
    }

    /**
     * elimina una carta del sistema, dado su ID
     * @param sistema
     */
    private static void eliminarCartaPorId(ISistema sistema) {
        int id = solicitarInt("ID");
        try{
            boolean eliminado = sistema.eliminarCarta(id);
            if (eliminado){
                System.out.println("Carta eliminada correctamente");
            }
            else{
                System.out.println("Error: No existe carta ingresada en el sistema con esa ID");
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * elimina una carta del sistema, dado su nombre
     * @param sistema
     */
    private static void eliminarCartaPorNombre(ISistema sistema) {
        String nombre = solicitarNombre();
        try{
            boolean eliminado = sistema.eliminarCarta(nombre);
            if (eliminado){
                System.out.println("Carta eliminada correctamente");
            }
            else{
                System.out.println("Error: No existe carta ingresada en el sistema con ese nombre");
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * guarda los cambios realizados a la galería en el archivo de salida 'galeria.txt
     * @param sistema
     */
    private static void guardarSalir(ISistema sistema) {
        try {
            FileWriter myWriter = new FileWriter("galeria.txt");

            myWriter.write(sistema.generarArchivoSalida());

            myWriter.close();
            System.out.println("Cartas actualizadas correctamente en 'galeria.txt'");
            System.out.println("Nos vemos!");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al intentar guardar las cartas en 'galeria.txt'");
            e.printStackTrace();
        }
    }

    /**
     * solicita un tipo de carta al usuario. Valida que esté entre los dos valores posibles para el tipo
     * @return el tipo validado
     */
    private static String solicitarTipo() {
        List<String> tipos = Arrays.asList("F", "M");
        while (true) {
            System.out.print("Ingrese tipo (Físico = F, Mágico = M):");
            String tipo = in.nextLine();
            if (!tipos.contains(tipo)){
                System.out.println("El tipo debe ser F o M");
            }
            else{
                if (tipo.equals("F")){
                    return "físico";
                }
                return "mágico";
            }
        }
    }

    /**
     * solicita una presencia de carta al usuario. Valida que esté entre los siete valores posibles para la presencia
     * @return la presencia validada
     */
    private static String solicitarPresencia() {
        List<String> presencias =
                Arrays.asList("fuego", "tierra", "aire", "agua", "éter", "santo", "destrucción");
        while (true) {
            System.out.print("Ingrese presencia:");
            String presencia = in.nextLine();
            if (!presencias.contains(presencia)){
                System.out.println("La presencia debe ser fuego, tierra, aire, agua, éter, santo o destrucción");
            }
            else{
                return presencia;
            }
        }
    }

    /**
     * solicita una descrpción de carta al usuario. Valida que tenga entre 1 y 255 caracteres.
     * @return la descripción validada
     */
    private static String solicitarDescripcion() {
        while (true) {
            System.out.print("Ingrese descripción:");
            String descripcion = in.nextLine();
            if (descripcion.equals("") || descripcion.length()>255){
                System.out.println("La descrpición debe ser una cadena de entre 1 y 255 caracteres");
            }
            else{
                return descripcion;
            }
        }
    }

    /**
     * solicita un entero al usuario. Valida que sea un entero
     * @param datoPedido nombre del dato que se pedirá al usuario
     * @return el entero validado
     */
    private static int solicitarInt(String datoPedido) {
        int datoInt;
        while (true) {
            System.out.print("Ingrese "+datoPedido+": ");
            String dato = in.nextLine();
            try{
                datoInt = Integer.parseInt(dato);
                return datoInt;
            }
            catch (Exception e){
                System.out.println(datoPedido + " debe ser un entero");
            }
        }
    }

    /**
     * solicita un nivel de carta al usuario. Valida que sea un entero y esté entre 1 y 5
     * @return el nivel validado
     */
    private static int solicitarNivel() {
        int datoInt;
        while (true) {
            System.out.print("Ingrese nivel: ");
            String dato = in.nextLine();
            try{
                datoInt = Integer.parseInt(dato);
                if (datoInt>5 || datoInt<1){
                    System.out.println("nivel debe ser un entero entre 1 y 5");
                }
                else{
                    return datoInt;
                }
            }
            catch (Exception e){
                System.out.println("nivel debe ser un entero");
            }
        }
    }

    /**
     * solicita un nombre de carta al usuario. Valida que tenga de 1 a 15 caracteres
     * @return el nombre validado
     */
    private static String solicitarNombre(){
        while (true) {
            System.out.print("Ingrese nombre:");
            String nombre = in.nextLine();
            if (nombre.equals("") || nombre.length()>15){
                System.out.println("El nombre debe ser una cadena de entre 1 y 15 caracteres");
            }
            else{
                return nombre;
            }
        }
    }
}