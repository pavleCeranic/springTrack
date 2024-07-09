//package dev.pavleceranic.content_calendar.repository;
//
//import dev.pavleceranic.content_calendar.model.Content;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.List;
//
//@Repository
//public class ContentJdbcTemplateRepository {
//
//    private final JdbcTemplate jdbcTemplate;
//
//    public ContentJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    private static void mapRow(ResultSet rs, int rowNum) throws SQLException {
////        return new Content(rs.getInt( "id"),
////            rs.getString("title"),
////                rs.getString("desc"),
////                rs.getString("status"),
////                rs.getString("content_type"),
////                rs.getTimestamp("date_created"),
////                rs.getTimestamp("date_updated"),
////                rs.getString("url"));
//    }
//
//    public List<Content> getAllContent() {
//        String sql = "SELECT * FROM Content";
//        List<Content> contents = jdbcTemplate.query(sql, ContentJdbcTemplateRepository::mapRow);
//        return contents;
//    }
//
//    public void createContent(String title, String desc, String status, String contentType, String URL) {
//        String sql = "INSERT INTO Content (title, desc, status, content_type, date_created, URL) VALUES (?, ?, ?, ?, NOW(), ?)";
//        jdbcTemplate.update(sql, title, desc, status, contentType, URL);
//    }
//
//    public void updateContent(int id, String title, String desc, String status, String contentType, String URL) {
//        String sql = "INSERT INTO Content (title=?, desc=?, status=?, content_type=?, date_updated=NOW(), url=? WHERE id=?";
//        jdbcTemplate.update(sql, title, desc, status, contentType, URL, id);
//    }
//
//    public void deleteContent(int id) {
//        String sql = "DELETE FROM Content WHERE id=?";
//        jdbcTemplate.update(sql, id);
//    }
//
//    public Content getContent(int id) {
//        String sql = "SELECT * FROM Content WHERE id=?";
//        Content content = jdbcTemplate.queryForObject(sql, new Object[]{id}, ContentJdbcTemplateRepository::mapRow);
//        return content;
//    }
//}
