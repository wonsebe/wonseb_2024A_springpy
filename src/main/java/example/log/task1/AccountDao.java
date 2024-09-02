package example.log.task1;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AccountDao {

    //가계부 등록
    int create(AccountDto accountDto);
    //전체출력
    List<AccountDto>allPrint();

    //수정
    boolean update(AccountDto accountDto);

    //삭제
    int delete(int id);

}
