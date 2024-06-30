public class Publicidad {
    private int idPublicidad;
    private String medio;
    private int presupuesto;
    private String descripcion;

    public Publicidad(int idPublicidad, String medio, int presupuesto, String descripcion) {
        this.idPublicidad = idPublicidad;
        this.medio = medio;
        this.presupuesto = presupuesto;
        this.descripcion = descripcion;
    }

    public int getIdPublicidad() {
        return idPublicidad;
    }

    public String getMedio() {
        return medio;
    }

    public int getPresupuesto() {
        return presupuesto;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
