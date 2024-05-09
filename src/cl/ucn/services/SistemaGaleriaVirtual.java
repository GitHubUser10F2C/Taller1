package cl.ucn.services;

import cl.ucn.model.Carta;
import cl.ucn.model.Destreza;
import cl.ucn.model.Entidad;
import cl.ucn.model.ListaCarta;

public class SistemaGaleriaVirtual implements ISistema{

    private ListaCarta listaCartas;

    public SistemaGaleriaVirtual() {
        this.listaCartas = new ListaCarta();
    }

    @Override
    public boolean agregarEntidad(String nombre, int nivel, String presencia, String descripcion,
                                  int poderFisico, int poderMagico, int proteccionFisica, int proteccionMagica) {
        if (listaCartas.cartaExistePorNombre(nombre)){
            return false;
        }
        Carta carta = new Entidad(nombre,nivel,presencia,descripcion,
                    poderFisico,poderMagico,proteccionFisica,proteccionMagica);
        listaCartas.add(carta);
        return true;
    }

    @Override
    public boolean agregarDestreza(String nombre, int nivel, String presencia, String descripcion,
                                   int potencia, String tipo) {
        if (listaCartas.cartaExistePorNombre(nombre)){
            return false;
        }
        Carta carta = new Destreza(nombre,nivel,presencia,descripcion,potencia,tipo);
        listaCartas.add(carta);
        return true;
    }

    @Override
    public String verCartas() {
        return listaCartas.aStringSimple();
    }

    @Override
    public String verCartas(String presencia) {
        return listaCartas.aStringDetallado(presencia);
    }

    @Override
    public boolean eliminarCarta(String nombre) throws Exception{
        if (listaCartas.isEmpty()){
            throw new Exception("Error: no hay cartas para eliminar");
        }
        return listaCartas.eliminarCartaPorNombre(nombre);
    }

    @Override
    public boolean eliminarCarta(int id) throws Exception{
        if (listaCartas.isEmpty()){
            throw new Exception("Error: no hay cartas para eliminar");
        }
        return listaCartas.eliminarCartaPorId(id);
    }

    @Override
    public String generarArchivoSalida() {
        return listaCartas.aStringArchivoSalida();
    }
}
