package cl.ucn.model;

import java.util.Arrays;
import java.util.List;

public class Destreza extends Carta{
    private int potencia;
    private String tipo;

    public Destreza(String nombre, int nivel, String presencia, String descripcion,
                    int potencia, String tipo) {
        super(nombre, nivel, presencia, descripcion);
        this.potencia = potencia;
        this.tipo = tipo;
    }

    @Override
    public String aStringDetallado() {
        String retorno = aStringSimple();
        retorno += "ID: "+getId()+"\n";
        retorno += "Nombre: "+getNombre()+"\n";
        retorno += "Nivel: "+getNivel()+"\n";
        retorno += "Presencia: "+getPresencia()+"\n";
        retorno += "Potencia: "+potencia+"\n";
        retorno += "Tipo: "+tipo+"\n";
        return retorno;
    }

    @Override
    public String aStringArchivoSalida() {
        String retorno = "Destreza;;;"+getNombre()+";;;"+getNivel()+";;;"+getPresencia()+";;;"+getDescripcion()+";;;";
        retorno += potencia+";;;"+tipo+"\n";
        return retorno;
    }
}
