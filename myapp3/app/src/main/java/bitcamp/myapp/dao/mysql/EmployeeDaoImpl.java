package bitcamp.myapp.dao.mysql;

import bitcamp.myapp.dao.DaoException;
import bitcamp.myapp.dao.EmployeeDao;
import bitcamp.myapp.vo.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

  Connection con;

  public EmployeeDaoImpl(Connection con) {
    this.con = con;
  }


//  private int no;
//  private String name;
//  private String email;
//  private String phoneno;
//  private String faxno;
//  private String rank;
//  private String position;
//  private String password;
//  private Date createdDate;
//  private boolean currentlyemployed;
//  private String birthday;
//  private String postalcode;
//  private String addressline1;
//  private String addressline2;
//  private String job;
//  private String startdate;
//  private String resignationday;



  @Override
  public void add(Employee employee) {
    try (PreparedStatement pstmt = con.prepareStatement(
        "insert into members("
            + "name,"
            + "password,"
            + "email,"
            + "phoneno,"
            + "faxno,"
            + "rank,"
            + "position,"
            + "birthday,"
            + "postalcode,"
            + "addressline1,"
            + "addressline2,"
            + "job,"
            + "startdate,"
            + "resignationday) values(?,sha2(?,256),?,?,?,?,?,?,?,?,?,?,?,?)")) {
      pstmt.setString(1, employee.getName());
      pstmt.setString(2, employee.getPassword());
      pstmt.setString(3, employee.getEmail());
      pstmt.setString(4,employee.getPhoneno());
      pstmt.setString(5,employee.getFaxno());
      pstmt.setString(6,employee.getRank());
      pstmt.setString(7,employee.getPosition());
      pstmt.setString(8,employee.getBirthday());
      pstmt.setString(9,employee.getPostalcode());
      pstmt.setString(10,employee.getAddressline1());
      pstmt.setString(11,employee.getAddressline2());
      pstmt.setString(12,employee.getJob());
      pstmt.setString(13,employee.getStartdate());
      pstmt.setString(14,employee.getResignationday());




      pstmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException("데이터 입력 오류", e);
    }
  }

  @Override
  public int delete(int no) {
    try (PreparedStatement pstmt = con.prepareStatement(
        "delete from employees where employee_no=?")) {
      pstmt.setInt(1, no);
      return pstmt.executeUpdate();

    } catch (Exception e) {
      throw new DaoException("데이터 삭제 오류", e);
    }
  }


//     pstmt.setString(1, employee.getName());
//      pstmt.setString(2, employee.getPassword());
//      pstmt.setString(3, employee.getEmail());
//      pstmt.setString(4,employee.getPhoneno());
//      pstmt.setString(5,employee.getFaxno());
//      pstmt.setString(6,employee.getRank());
//      pstmt.setString(7,employee.getPosition());
//      pstmt.setString(8,employee.getBirthday());
//      pstmt.setString(9,employee.getPostalcode());
//      pstmt.setString(10,employee.getAddressline1());
//      pstmt.setString(11,employee.getAddressline2());
//      pstmt.setString(12,employee.getJob());
//      pstmt.setString(13,employee.getStartdate());
//      pstmt.setString(14,employee.getResignationday());
//

  @Override
  public List<Employee> findAll() {
    try (PreparedStatement pstmt = con.prepareStatement(
        "select employee_no,"
            + "name,"
            + "email,"
            + "created_date,"
            + "phoneno,"
            + "faxno,"
            + "rank,"
            + "position,"
            + "birthday,"
            + "postalcode,"
            + "addressline1,"
            + "addressline2,"
            + "job,"
            + "startdate,"
            + "resignationday from employees");
        ResultSet rs = pstmt.executeQuery();) {

      ArrayList<Employee> list = new ArrayList<>();

      while (rs.next()) {
        Employee employee = new Employee();
        employee.setNo(rs.getInt("employee_no"));
        employee.setName(rs.getString("name"));
        employee.setEmail(rs.getString("email"));
        employee.setCreatedDate(rs.getDate("created_date"));
        employee.setPhoneno(rs.getString("phoneno"));
        employee.setFaxno(rs.getString("faxno"));
        employee.setRank(rs.getString("rank"));
        employee.setPosition(rs.getString("position"));
        employee.setBirthday(rs.getString("birthday"));
        employee.setPostalcode(rs.getString("Postalcode"));
        employee.setAddressline1(rs.getString("addressline1"));
        employee.setAddressline2(rs.getString("addressline2"));
        employee.setJob(rs.getString("job"));
        employee.setStartdate(rs.getString("startdate"));
        employee.setResignationday(rs.getString("resignationday"));

        list.add(employee);
      }
      return list;

    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public Employee findBy(int no) {
    try (PreparedStatement pstmt = con.prepareStatement(
        "select employee, name, email, created_date from employees where employee_no=?")) {
      pstmt.setInt(1, no);

      try (ResultSet rs = pstmt.executeQuery()) {
        if (rs.next()) {
          Employee employee = new Employee();
          employee.setNo(rs.getInt("employee_no"));
          employee.setName(rs.getString("name"));
          employee.setEmail(rs.getString("email"));
          employee.setCreatedDate(rs.getDate("created_date"));
          employee.setPhoneno(rs.getString("phoneno"));
          employee.setFaxno(rs.getString("faxno"));
          employee.setRank(rs.getString("rank"));
          employee.setPosition(rs.getString("position"));
          employee.setBirthday(rs.getString("birthday"));
          employee.setPostalcode(rs.getString("Postalcode"));
          employee.setAddressline1(rs.getString("addressline1"));
          employee.setAddressline2(rs.getString("addressline2"));
          employee.setJob(rs.getString("job"));
          employee.setStartdate(rs.getString("startdate"));
          employee.setResignationday(rs.getString("resignationday"));
          return employee;
        }
        return null;
      }
    } catch (Exception e) {
      throw new DaoException("데이터 가져오기 오류", e);
    }
  }

  @Override
  public int update(Employee employee) {
    String sql = null;
    if (employee.getPassword().length() == 0) {
      sql = "update employees set name=?, email=?"
    try (PreparedStatement pstmt = con.prepareStatement(
        "update members set email=?, name=?, password=sha2(?,256) where member_no=?")) {
      pstmt.setString(1, employee.getEmail());
      pstmt.setString(2, employee.getName());
      pstmt.setString(3, employee.getPassword());
      pstmt.setInt(4, employee.getNo());
      return pstmt.executeUpdate();
    } catch (Exception e) {
      throw new DaoException("데이터 변경 오류", e);
    }
  }
}