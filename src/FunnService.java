import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.*;

public class FunnService {
    private static final String ADD_PEOPLE_SQL = "INSERT INTO person VALUES (?, ?, ?, ?)";
    private static final String ADD_MUSEUM_SQL = "INSERT INTO museum VALUES (?, ?, ?)";
    private static final String ADD_MYNT_SQL = "INSERT INTO mynt VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String ADD_VAAPEN_SQL = "INSERT INTO vaapen VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String ADD_SMYKKE_SQL = "INSERT INTO smykke VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private final MysqlDataSource FunnDS;

    public FunnService() {
        FunnDS = new MysqlDataSource();
        FunnDS.setServerName(PropertiesProvider.PROPERTIES.getProperty("host"));
        FunnDS.setPortNumber(Integer.parseInt(PropertiesProvider.PROPERTIES.getProperty("port")));
        FunnDS.setDatabaseName(PropertiesProvider.PROPERTIES.getProperty("db_name"));
        FunnDS.setUser(PropertiesProvider.PROPERTIES.getProperty("uname"));
        FunnDS.setPassword(PropertiesProvider.PROPERTIES.getProperty("pwd"));
    }

    public MysqlDataSource getFunnDS() {
        return FunnDS;
    }

    public void addPerson(Person person, Connection connection) throws SQLException {
        try (PreparedStatement stmt = connection.prepareStatement(ADD_PEOPLE_SQL)){
            stmt.setInt(1, person.id());
            stmt.setString(2, person.navn());
            stmt.setString(3, person.tlf());
            stmt.setString(4, person.e_post());
            stmt.executeUpdate();
        }
    }

    public void addMuseum(Museum museum, Connection connection) throws SQLException {
        try (PreparedStatement stmt = connection.prepareStatement(ADD_MUSEUM_SQL)){
            stmt.setInt(1, museum.id());
            stmt.setString(2, museum.navn());
            stmt.setString(3, museum.sted());
            stmt.executeUpdate();
        }
    }

    public void addMynt(Mynt mynts, Connection connection) throws SQLException {
        try (PreparedStatement stmt = connection.prepareStatement(ADD_MYNT_SQL)){
            stmt.setInt(1, mynts.getId());
            stmt.setString(2, mynts.getFunnsted());
            stmt.setInt(3, mynts.getFinner_id());
            stmt.setDate(4, Date.valueOf(mynts.getFunntidspunkt()));
            stmt.setInt(5, mynts.getAntall_aarstall());
            if (mynts.getMuseum_id()== 0) {
                stmt.setNull(6, Types.INTEGER);
            } else {
                stmt.setInt(6, mynts.getMuseum_id());
            }
            stmt.setInt(7, mynts.getDiameter());
            stmt.setString(8, mynts.getMetall());
            stmt.executeUpdate();
        }
    }

    public void addVaapen(Vaapen vaapens, Connection connection) throws SQLException {
        try (PreparedStatement stmt = connection.prepareStatement(ADD_VAAPEN_SQL)){
            stmt.setInt(1, vaapens.getId());
            stmt.setString(2, vaapens.getFunnsted());
            stmt.setInt(3, vaapens.getFinner_id());
            stmt.setDate(4, Date.valueOf(vaapens.getFunntidspunkt()));
            stmt.setInt(5, vaapens.getAntall_aarstall());
            if (vaapens.getMuseum_id()== 0) {
                stmt.setNull(6, Types.INTEGER);
            } else {
                stmt.setInt(6, vaapens.getMuseum_id());
            }            stmt.setString(7, vaapens.getType());
            stmt.setString(8, vaapens.getMateriale());
            stmt.setInt(9, vaapens.getVekt());
            stmt.executeUpdate();
        }
    }

    public void addSmykke(Smykke smykkes, Connection connection) throws SQLException {
        try (PreparedStatement stmt = connection.prepareStatement(ADD_SMYKKE_SQL)){
            stmt.setInt(1, smykkes.getId());
            stmt.setString(2, smykkes.getFunnsted());
            stmt.setInt(3, smykkes.getFinner_id());
            stmt.setDate(4, Date.valueOf(smykkes.getFunntidspunkt()));
            stmt.setInt(5, smykkes.getAntall_aarstall());
            if (smykkes.getMuseum_id()== 0) {
                stmt.setNull(6, Types.INTEGER);
            } else {
                stmt.setInt(6, smykkes.getMuseum_id());
            }
            stmt.setString(7, smykkes.getType());
            stmt.setInt(8, smykkes.getVerdiestimat());
            stmt.setString(9, smykkes.getFilnavn());
            stmt.executeUpdate();
        }
    }
}
