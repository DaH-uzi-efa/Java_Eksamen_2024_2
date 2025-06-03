import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class Program {
    private final FunnService funnService;

    public Program() {
        funnService = new FunnService();
    }

    public void readFile() throws SQLException, FileNotFoundException {
        File file = new File("funn.txt");
        try (Scanner fileReader = new Scanner(file);
             Connection connection = funnService.getFunnDS().getConnection()){
            while (fileReader.hasNextLine()) {
                String registrering = fileReader.nextLine();
                if (registrering.equals("Personer:")) {
                    int numberOfPeople = Integer.parseInt(fileReader.nextLine());
                    for (int i = 0; i < numberOfPeople; i++) {
                        Person person = readPerson(fileReader);
                        funnService.addPerson(person, connection);
                    }
                } else if (registrering.equals("Museer:")) {
                    int numberOfMuseum = Integer.parseInt(fileReader.nextLine());
                    for (int i = 0; i < numberOfMuseum; i++) {
                        Museum museum = readMuseum(fileReader);
                        funnService.addMuseum(museum, connection);

                    }
                } else if (registrering.equals("Funn:")) {
                    readFunn(fileReader, connection);
                }

            }
        }
    }

    private Funn readFunn(Scanner reader, Connection connection) throws SQLException {
        while (reader.hasNextLine()) {
            int id = Integer.parseInt(reader.nextLine());
            String funnsted = reader.nextLine();
            int finnerId = Integer.parseInt(reader.nextLine());
            LocalDate funntidspunkt = LocalDate.parse(reader.nextLine());
            int antallAarstall = Integer.parseInt(reader.nextLine());
            String museumIdLine = reader.nextLine();
            int museumId;
            if (museumIdLine.isEmpty()) {
                museumId = 0;
            } else {
                museumId = Integer.parseInt(museumIdLine);
            }
            String funngjenstand = reader.nextLine();
            if (funngjenstand.equals("Mynt")) {
                Mynt mynts = readMynt(id, funnsted, finnerId, funntidspunkt, antallAarstall, museumId, reader);
                funnService.addMynt(mynts, connection);
            } else if (funngjenstand.equals("Våpen")) {
                Vaapen vaapens = readVaapen(id, funnsted, finnerId, funntidspunkt, antallAarstall, museumId, reader);
                funnService.addVaapen(vaapens, connection);
            } else if (funngjenstand.equals("Smykke")) {
                Smykke smykkes = readSmykke(id, funnsted, finnerId, funntidspunkt, antallAarstall, museumId, reader);
                funnService.addSmykke(smykkes, connection);
            }
            reader.nextLine();
        }
        return null;
    }

    private Smykke readSmykke(int id, String funnsted, int finnerId, LocalDate funntidspunkt, int antallAarstall, int museumId, Scanner reader) {
        String type = reader.nextLine();
        int verdiestimat = Integer.parseInt(reader.nextLine());
        String filnavn = reader.nextLine();
        return new Smykke(id, funnsted, finnerId, funntidspunkt,antallAarstall, museumId, type, verdiestimat, filnavn);
    }

    private Vaapen readVaapen(int id, String funnsted, int finnerId, LocalDate funntidspunkt, int antallAarstall, int museumId, Scanner reader) {
        String type = reader.nextLine();
        String materiale = reader.nextLine();
        int vekt = Integer.parseInt(reader.nextLine());
        return new Vaapen(id, funnsted, finnerId, funntidspunkt,antallAarstall, museumId, type, materiale, vekt);
    }

    private Mynt readMynt(int id, String funnsted, int finnerId, LocalDate funntidspunkt, int antallAarstall, int museumId, Scanner reader) {
            int diameter = Integer.parseInt(reader.nextLine());
            String metall = reader.nextLine();
            return new Mynt(id, funnsted, finnerId, funntidspunkt, antallAarstall, museumId, diameter, metall);
    }

    private Museum readMuseum(Scanner reader) {
        int id = Integer.parseInt(reader.nextLine());
        String navn = reader.nextLine();
        String sted = reader.nextLine();
        return new Museum(id, navn, sted);
    }

    private Person readPerson(Scanner reader) {
        int id = Integer.parseInt(reader.nextLine());
        String name = reader.nextLine();
        String tlf = reader.nextLine();
        String ePost = reader.nextLine();
        return new Person(id, name, tlf, ePost);
    }

}

