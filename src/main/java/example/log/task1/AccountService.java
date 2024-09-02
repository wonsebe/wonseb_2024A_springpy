package example.log.task1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired private  AccountDao accountDao;

    //가계부 등록
    public int create(AccountDto accountDto){
        return accountDao.create(accountDto);
    }
    //전체출력
    public List<AccountDto>allPrint(){
        return accountDao.allPrint();
    }

    //수정
    public boolean  update(AccountDto accountDto){
        return accountDao.update(accountDto);
    }
    //삭제
    public int  delete(int hno){
        return accountDao.delete(hno);
    }
}
