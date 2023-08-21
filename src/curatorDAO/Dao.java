package curatorDAO;

import java.sql.SQLException;

public interface Dao<T, PK> {

    void InsertCurator() throws SQLException;
}
