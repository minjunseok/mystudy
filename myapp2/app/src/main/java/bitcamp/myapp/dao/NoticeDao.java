package bitcamp.myapp.dao;

import bitcamp.myapp.vo.Notice;
import java.util.List;

public interface NoticeDao {

  void add(Notice notice);

  int delete(int no);

  List<Notice> findAll();

  Notice findBy(int no);

  int update(Notice notice);

}
