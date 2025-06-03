import java.time.LocalDate;

public class Vaapen extends Funn{
    private String type;
    private String materiale;
    private int vekt;

    public Vaapen(int id, String funnsted, int finner_id, LocalDate funntidspunkt, int antall_aarstall, int museum_id, String type, String materiale, int vekt) {
        super(id, funnsted, finner_id, funntidspunkt, antall_aarstall, museum_id);
        this.type = type;
        this.materiale = materiale;
        this.vekt = vekt;
    }

    public String getType() {
        return type;
    }

    public String getMateriale() {
        return materiale;
    }

    public int getVekt() {
        return vekt;
    }

    @Override
    public String toString() {
        return super.toString() + "Vaapen{" +
                "type='" + type + '\'' +
                ", materiale='" + materiale + '\'' +
                ", vekt=" + vekt +
                '}';
    }
}
