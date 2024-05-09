package cl.ucn.model;

import java.util.ArrayList;

public class ListaCarta extends ArrayList<Carta> {

    public ListaCarta(){
        super();
    }
    public boolean cartaExistePorNombre(String nombre){
        for (Carta carta : this){
            if (nombre.equals(carta.getNombre())){
                return true;
            }
        }
        return false;
    }

    public boolean cartaExistePorId(int id){
        for (Carta carta : this){
            if (id == carta.getId()){
                return true;
            }
        }
        return false;
    }

    public Carta getCartaPorNombre(String nombre){
        for (Carta carta : this){
            if (nombre.equals(carta.getNombre())){
                return carta;
            }
        }
        return null;
    }

    public Carta getCartaPorId(int id){
        for (Carta carta : this){
            if (id == carta.getId()){
                return carta;
            }
        }
        return null;
    }

    public String aStringSimple(){
        String retorno = "";
        for (Carta carta : this){
            retorno+=carta.aStringSimple();
        }
        return retorno;
    }

    public String aStringArchivoSalida(){
        String retorno = "";
        for (Carta carta : this){
            retorno+=carta.aStringArchivoSalida();
        }
        return retorno;
    }

    public String aStringDetallado(String presencia){
        String retorno = "";
        for (Carta carta : this){
            if (presencia.equals(carta.getPresencia())){
                retorno+=carta.aStringDetallado();
            }
        }
        return retorno;
    }

    public boolean eliminarCartaPorNombre(String nombre){
        for (Carta carta : this){
            if (nombre.equals(carta.getNombre())){
                remove(carta);
                return true;
            }
        }
        return false;
    }

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
