package example.log.task1;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/houseaccountbook")
public class AccountController {
    @Autowired private AccountService accountService;

    @PostMapping("/hcreate")
    public int create(AccountDto accountDto){
        return accountService.create(accountDto);
    }

    @GetMapping("/hprint")
    public List<AccountDto> allPrint(){
        return accountService.allPrint();
    }

    @PutMapping("/hupdate")
    public boolean  update(AccountDto accountDto){
        return accountService.update(accountDto);
    }

    @DeleteMapping("/hdelete")
    public int  delete(int hno){
        return accountService.delete(hno);
    }







}
