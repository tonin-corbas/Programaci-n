
package Model;

/**
 * Clase Era para representar una época.
 */
public class Era {
    private int id;
    private String epoca;

    /**
     * Constructor de Era.
     *
     * @param id    ID de la época.
     * @param epoca Nombre de la época.
     */
    public Era(int id, String epoca) {
        this.id = id;
        this.epoca = epoca;
    }

    public int getId() {
        return id;
    }

    public String getEpoca() {
        return epoca;
    }
}
