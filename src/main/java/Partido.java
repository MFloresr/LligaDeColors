public class Partido {

    private String nombre;
    private int gols;

    public Partido() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getGols() {
        return gols;
    }

    public void setGols(int gols) {
        this.gols = gols;
    }

    @Override
    public String toString() {
        return "partido{" +
                "nombre='" + nombre + '\'' +
                ", gols=" + gols +
                '}';
    }
}