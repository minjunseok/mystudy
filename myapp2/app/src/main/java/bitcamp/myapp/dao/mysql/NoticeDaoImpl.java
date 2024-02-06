package bitcamp.myapp.dao.mysql;

import bitcamp.myapp.dao.DaoException;
import bitcamp.myapp.dao.NoticeDao;
import bitcamp.myapp.vo.Notice;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.checkerframework.checker.units.qual.N;

public class NoticeDaoImpl implements NoticeDao {

  Connection con;

  public NoticeDaoImpl(Connection con) {
    this.con = con;
  }

  @Override
  public void add(Notice notice) {
    try {
      Statement stmt = con.createStatement();
      stmt.executeUpdate(String.format(
          "insert into notices(title,content) values('%s','%s')",
          notice.getTitle(), notice.getContent()));

    } catch (Exception e) {
      throw new DaoException("데이터 입력 오류", e);
    }
  }

  @Override
  public int delete(int no) {
    try {
      Statement stmt = con.createStatement();
      return stmt.executeUpdate(
          String.format("delete from notices where notice_no=%d", no));

    } catch (Exception e) {
      throw new DaoException("데이터 삭제 오류", e);
    }
  }

  @Override
  public List<Notice> findAll() {
    try {
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("select * from notices");

      ArrayList<Notice> list = new ArrayList<>();

      while (rs.next()) {
        Notice notice = new Notice();
        notice.setNo(rs.getInt("notice_no"));
        notice.setTitle(rs.getString("title"));
        notice.setContent(rs.getString("content"));
        notice.setCreatedDate(rs.getDate("created_date"));

        list.add(notice);
      }
      return list;

    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public Notice findBy(int no) {
    try {
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery("select * from notices where notice_no=" + no);

      ArrayList<Notice> list = new ArrayList<>();

      if (rs.next()) {
        Notice notice = new Notice();
        notice.setNo(rs.getInt("notice_no"));
        notice.setTitle(rs.getString("title"));
        notice.setContent(rs.getString("content"));
        notice.setCreatedDate(rs.getDate("created_date"));

        return notice;
      }
      return null;

    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);

    }
  }

  @Override
  public int update(Notice notice) {
    try {
      Statement stmt = con.createStatement();
      return stmt.executeUpdate(String.format(
          "update notices set title='%s', content='%s'  where notice_no=%d",
          notice.getTitle(), notice.getContent(), notice.getNo()));

    } catch (Exception e) {
      throw new DaoException("데이터 변경 오류", e);
    }
  }
}
