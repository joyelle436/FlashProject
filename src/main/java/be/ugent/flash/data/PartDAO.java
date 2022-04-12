package be.ugent.flash.data;

import java.sql.SQLException;
import java.util.List;
/**
 * Gebaseerd op code uit de cursus
 */
public interface PartDAO {
    List<Part> getParts() throws SQLException;
}
