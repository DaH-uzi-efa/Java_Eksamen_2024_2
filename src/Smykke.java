import java.time.LocalDate;

public class Smykke extends Funn{
    private String type;
    private int verdiestimat;
    private String filnavn;

    public Smykke(int id, String funnsted, int finner_id, LocalDate funntidspunkt, int antall_aarstall, int museum_id, String type, int verdiestimat, String filnavn) {
        super(id, funnsted, finner_id, funntidspunkt, antall_aarstall, museum_id);
        this.type = type;
        this.verdiestimat = verdiestimat;
        this.filnavn = filnavn;
    }

    public String getType() {
        return type;
    }

    public int getVerdiestimat() {
        return verdiestimat;
    }

    public String getFilnavn() {
        return filnavn;
    }

    @Override
    public String toString() {
        return super.toString() + "Smykke{" +
                "type='" + type + '\'' +
                ", verdiestimat=" + verdiestimat +
                ", filnavn='" + filnavn + '\'' +
                '}';
    }
}

