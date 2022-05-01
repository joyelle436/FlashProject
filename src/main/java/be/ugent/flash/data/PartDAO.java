package be.ugent.flash.data;

import java.sql.SQLException;
import java.util.List;
/**
 * Gebaseerd op code uit de cursus
 */
public interface PartDAO {
    List<Part> getAllParts() throws SQLException;
    List<Part> getParts(int question_id) throws SQLException;
    void updatePart(int part_id, byte[] part, String question_type) throws SQLException;
    void addPart(Part part) throws SQLException;
    void deleteParts(int question_id) throws SQLException;
}
