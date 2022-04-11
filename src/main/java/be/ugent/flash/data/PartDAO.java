package be.ugent.flash.data;

import java.sql.SQLException;
import java.util.List;

public interface PartDAO {
    List<Part> getParts() throws SQLException;
}
