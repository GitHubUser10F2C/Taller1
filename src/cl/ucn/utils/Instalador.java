package cl.ucn.utils;

import cl.ucn.services.ISistema;
import cl.ucn.services.SistemaGaleriaVirtual;

public class Instalador {
    private ISistema sistemaInstalar;

    public Instalador(){
        this.sistemaInstalar = new SistemaGaleriaVirtual();
    }

    public ISistema instalarSistema(){
        return this.sistemaInstalar;
    }
}
