package GroupDAO;

import java.sql.SQLException;

public interface Dao<T, PK> {

    void InsertGroup() throws SQLException;
}