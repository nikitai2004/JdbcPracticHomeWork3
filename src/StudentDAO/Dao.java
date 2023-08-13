package StudentDAO;

import java.sql.SQLException;

public interface Dao<T, PK> {

    void InsertStudent() throws SQLException;
}