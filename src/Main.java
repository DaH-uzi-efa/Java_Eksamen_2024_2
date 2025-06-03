import java.io.FileNotFoundException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Program p = new Program();
        try {
            p.readFile();
        } catch (SQLException | FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
