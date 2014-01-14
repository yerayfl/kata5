package kata5;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DatabasePersonLoader implements PersonLoader {

    private Connection connection;

    public DatabasePersonLoader(Connection connection) throws SQLException {
        this.connection = connection;
    }

    @Override
    public Person[] load() {
        try {
            return loadPeople();
        } catch (SQLException ex) {
            return new Person[0];
        }
    }

    private ResultSet createResultSet(String select) throws SQLException {
        return connection.createStatement().executeQuery(select);
    }

    private Person[] loadPeople() throws SQLException {
        ResultSet set = createResultSet("SELECT * FROM people");
        return getPeople(set);
    }

    private Person[] getPeople(ResultSet set) throws SQLException {
        ArrayList<Person> list = new ArrayList<>();
        while (set.next()) {
            list.add(createPerson(set));
        }
        return list.toArray(new Person[0]);
    }

    private Person createPerson(ResultSet set) throws SQLException {
        return new Person(
                set.getString("first_name"),
                set.getString("last_name"),
                set.getString("company_name"),
                set.getString("address"),
                set.getString("city"),
                set.getString("state"),
                new Mail(set.getString("email")),
                set.getString("web"));
    }
}
