import java.time.LocalDate;

public abstract class Funn {
    private final int id;
    private final String funnsted;
    private final int finner_id;
    private final LocalDate funntidspunkt;
    private final int antall_aarstall;
    private final int museum_id;

    public Funn(int id, String funnsted, int finner_id, LocalDate funntidspunkt, int antall_aarstall, int museum_id) {
        this.id = id;
        this.funnsted = funnsted;
        this.finner_id = finner_id;
        this.funntidspunkt = funntidspunkt;
        this.antall_aarstall = antall_aarstall;
        this.museum_id = museum_id;
    }

    public int getId() {
        return id;
    }

    public String getFunnsted() {
        return funnsted;
    }

    public int getFinner_id() {
        return finner_id;
    }

    public LocalDate getFunntidspunkt() {
        return funntidspunkt;
    }

    public int getAntall_aarstall() {
        return antall_aarstall;
    }

    public int getMuseum_id() {
        return museum_id;
    }

    @Override
    public String toString() {
        return "Funn{" +
                "id=" + id +
                ", funnsted='" + funnsted + '\'' +
                ", finner_id=" + finner_id +
                ", funntidspunkt=" + funntidspunkt +
                ", antall_aarstall=" + antall_aarstall +
                ", museum_id=" + museum_id +
                '}';
    }
}

