package example.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyService {
    @Autowired private  MyDao myDao;

    //[1]. 등록
    public int save(UserDto userDto){
        return  myDao.save(userDto);
    }
    //[2] 전체 출력
    public List<UserDto> findAll(){
        return myDao.findAll();
    }
    //2-2 개별 출력
    public UserDto findById(int id){
        return myDao.findById(id);
    }
    //[3] 수정
    public int update(UserDto userDto){
        return myDao.update(userDto);
    }
    //[4] 삭제
    public int delete(int id){
        return myDao.delete(id);
    }
}
