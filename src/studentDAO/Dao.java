package studentDAO;

import java.sql.SQLException;

public interface Dao<T, PK> {

    void InsertStudent() throws SQLException;
}