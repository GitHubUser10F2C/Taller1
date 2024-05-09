package cl.ucn.model;

public class Entidad extends Carta{
    private int poderFisico;
    private int poderMagico;
    private int proteccionFisica;
    private int proteccionMagica;

    public Entidad(String nombre, int nivel, String presencia, String descripcion,
                   int poderFisico, int poderMagico, int proteccionFisica, int proteccionMagica) {
        super(nombre, nivel, presencia, descripcion);
        this.poderFisico = poderFisico;
        this.poderMagico = poderMagico;
        this.proteccionFisica = proteccionFisica;
        this.proteccionMagica = proteccionMagica;
    }

    @Override
    public String aStringDetallado() {
        String retorno = aStringSimple();
        retorno += "ID: "+getId()+"\n";
        retorno += "Nombre: "+getNombre()+"\n";
        retorno += "Nivel: "+getNivel()+"\n";
        retorno += "Presencia: "+getPresencia()+"\n";
        retorno += "Poder Físico: "+poderFisico+"\n";
        retorno += "Poder Mágico: "+poderMagico+"\n";
        retorno += "Protección Física: "+proteccionFisica+"\n";
        retorno += "Protección Mágica: "+proteccionMagica+"\n";
        return retorno;
    }

    @Override
    public String aStringArchivoSalida() {
        String retorno = "Entidad;;;"+getNombre()+";;;"+getNivel()+";;;"+getPresencia()+";;;"+getDescripcion()+";;;";
        retorno += poderFisico+";;;"+poderMagico+";;;"+proteccionFisica+";;;"+proteccionMagica+"\n";
        return retorno;
    }
}
