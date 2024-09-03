package example.log.task1;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Log4j2
@Service
public class AccountService {

    @Autowired private  AccountDao accountDao;


    //가계부 등록
    public int create(AccountDto accountDto){
        int num =  accountDao.create( accountDto );
        if(num==1){ log.info("Account create"); }
        return 1;
    }
    //전체출력
    public List<AccountDto>allPrint(){
        return accountDao.allPrint();
    }

    //수정
    public boolean  update(AccountDto accountDto){
        System.out.println("accountDto = " + accountDto);
        boolean result = accountDao.update( accountDto );
        if( result ){ log.info("Account updated"); }
        return result;
    }
    //삭제
    public int  delete(int hno){
        int num =  accountDao.delete( hno );
        if(num==1){ log.info("Account deleted"); }
        return 1;
    }
    }


