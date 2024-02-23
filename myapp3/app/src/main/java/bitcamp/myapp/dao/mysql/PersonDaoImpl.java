package bitcamp.myapp.dao.mysql;

import bitcamp.myapp.dao.DaoException;
import bitcamp.myapp.dao.PersonDao;
import bitcamp.myapp.vo.Person;
import bitcamp.util.DBConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PersonDaoImpl implements PersonDao {

  DBConnectionPool connectionPool;

  public PersonDaoImpl(DBConnectionPool connectionPool) {
    this.connectionPool = connectionPool;
  }

  @Override
  public void add(Person person) {
    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement(
            "insert into members(email,name,password) values(?,?,sha2(?,256))")) {
      pstmt.setString(1, person.getEmail());
      pstmt.setString(2, person.getName());
      pstmt.setString(3, person.getPassword());
      pstmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException("데이터 입력 오류", e);
    }
  }

  @Override
  public int delete(int no) {
    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement(
            "delete from members where member_no=?")) {
      pstmt.setInt(1, no);
      return pstmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException("데이터 삭제 오류", e);
    }
  }

  @Override
  public List<Person> findAll() {
    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement(
            "select member_no, email, name, created_date from members");
        ResultSet rs = pstmt.executeQuery();) {

      ArrayList<Person> list = new ArrayList<>();

      while (rs.next()) {
        Person person = new Person();
        person.setNo(rs.getInt("member_no"));
        person.setEmail(rs.getString("email"));
        person.setName(rs.getString("name"));
        person.setCreatedDate(rs.getDate("created_date"));

        list.add(person);
      }
      return list;

    } catch (Exception e) {
      throw new DaoException("데이터 불러오기 에러", e);
    }
  }

  @Override
  public Person findBy(int no) {
    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement(
            "select member_no, email, name, created_date from members where member_no=?")) {
      pstmt.setInt(1, no);

      try (ResultSet rs = pstmt.executeQuery()) {
        if (rs.next()) {
          Person person = new Person();
          person.setNo(rs.getInt("member_no"));
          person.setEmail(rs.getString("email"));
          person.setName(rs.getString("name"));
          person.setCreatedDate(rs.getDate("created_date"));
          return person;
        }
        return null;
      }

    } catch (Exception e) {
      throw new DaoException("데이터 불러오기 에러", e);
    }
  }

  @Override
  public int update(Person person) {
    String sql = null;
    if (person.getPassword().length() == 0) {
      sql = "update members set email=?, name=? where member_no=?";
    } else {
      sql = "update members set email=?, name=?, password=sha2(?,256) where member_no=?";
    }

    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql)) {
      pstmt.setString(1, person.getEmail());
      pstmt.setString(2, person.getName());
      pstmt.setString(3, person.getPassword());
      pstmt.setInt(4, person.getNo());
      return pstmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException("데이터 변경 에러", e);
    }
  }

  @Override
  public Person findByEmailAndPassword(String email, String password) {
    try (Connection con = connectionPool.getConnection();
        PreparedStatement pstmt = con.prepareStatement(
            "select member_no, email, name, created_date from members where email=? and password=sha2(?,256)")) {
      pstmt.setString(1, email);
      pstmt.setString(2, password);

      try (ResultSet rs = pstmt.executeQuery()) {
        if (rs.next()) {
          Person person = new Person();
          person.setNo(rs.getInt("member_no"));
          person.setEmail(rs.getString("email"));
          person.setName(rs.getString("name"));
          person.setCreatedDate(rs.getDate("created_date"));
          return person;
        }
        return null;
      }

    } catch (Exception e) {
      throw new DaoException("데이터 불러오기 에러", e);
    }
  }

}
