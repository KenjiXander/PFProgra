public class Artista {
    private int idArtista;
    private String nombre;
    private String generoMusical;

    public Artista(int idArtista, String nombre, String generoMusical) {
        this.idArtista = idArtista;
        this.nombre = nombre;
        this.generoMusical = generoMusical;
    }

    public int getIdArtista() {
        return idArtista;
    }

    public String getNombre() {
        return nombre;
    }

    public String getGeneroMusical() {
        return generoMusical;
    }
}
