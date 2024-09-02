package example.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mybatis")
public class MyController {

    @Autowired
    private MyService myService;
    //1. 등록
    @PostMapping("/save")
    public int save(UserDto userDto){
        return myService.save(userDto);
    }
    //[2]전체 출력
    @GetMapping("/findall")
    public List<UserDto> findAll(){
        return myService.findAll();
    }
    //[3] 수정
    @PutMapping("/update")
    public int update(UserDto userDto){
        return myService.update(userDto);
    }

    //2-2 개별 조회
    @GetMapping("/findById")
    public UserDto findById(int id){
        return myService.findById(id);
    }

    //[4] 삭제
    @DeleteMapping("/delete")
    public int delete(int id){
        return myService.delete(id);
    }
}