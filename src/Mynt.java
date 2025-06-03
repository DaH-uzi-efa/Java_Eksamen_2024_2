import java.time.LocalDate;

public class Mynt extends Funn{
    private int diameter;
    private String metall;

    public Mynt(int id, String funnsted, int finner_id, LocalDate funntidspunkt, int antall_aarstall, int museum_id, int diameter, String metall) {
        super(id, funnsted, finner_id, funntidspunkt, antall_aarstall, museum_id);
        this.diameter = diameter;
        this.metall = metall;
    }

    public int getDiameter() {
        return diameter;
    }

    public String getMetall() {
        return metall;
    }

    @Override
    public String toString() {
        return super.toString()+ "Mynt{" +
                "diameter=" + diameter +
                ", metall='" + metall + '\'' +
                '}';
    }
}
