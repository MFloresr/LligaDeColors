
public class Equipo implements Comparable<Equipo> {

    private String nombre;
    private int victoria;
    private int empate;
    private int derrota;
    private int puntuacion;



    public Equipo() {
    }

    public Equipo(String nombre) {
        this.nombre = nombre;
    }

    public Equipo(String nombre, int victoria, int empate, int derrota, int puntuacion) {
        this.nombre = nombre;
        this.victoria = victoria;
        this.empate = empate;
        this.derrota = derrota;
        this.puntuacion = puntuacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVictoria() {
        return victoria;
    }

    public void setVictoria(int victoria) {
        this.victoria = victoria;
    }

    public int getEmpate() {
        return empate;
    }

    public void setEmpate(int empate) {
        this.empate = empate;
    }

    public int getDerrota() {
        return derrota;
    }

    public void setDerrota(int derrota) {
        this.derrota = derrota;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    @Override
    public String toString() {
        return "equipo{" +
                "nombre='" + nombre + '\'' +
                ", victoria=" + victoria +
                ", empate=" + empate +
                ", derrota=" + derrota +
                ", puntuacion=" + puntuacion +
                '}';
    }

    @Override
    public int compareTo(Equipo o) {
        if (puntuacion < o.puntuacion) {
            return 1;
        }
        if (puntuacion > o.puntuacion) {
            return -1;
        }
        return 0;
    }
}
