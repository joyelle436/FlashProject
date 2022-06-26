package be.ugent.flash.db;

import java.sql.SQLException;
import java.util.List;
/**
 * Gebaseerd op code uit de cursus
 */
public interface PartDAO {
    List<Part> getAllParts() throws SQLException;
    List<Part> getParts(int question_id) throws SQLException;
    void updatePart(int question_id, int part_id, byte[] part) throws SQLException;
    void addPart(int question_id, byte[] part) throws SQLException;
    void deletePart(int part_id) throws SQLException;
    void deleteParts(int question_id) throws SQLException;
}
