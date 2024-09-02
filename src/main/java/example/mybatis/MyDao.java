package example.mybatis;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MyDao {
    // [1] 추상메소드

    //[C] 1. 등록
    int save(UserDto userDto);
    //2.[R] 전체출력
    List<UserDto> findAll();
    //3.[U] 수정
    int update(UserDto userDto);
    //4.[D] 삭제
    int delete(int id);
    //2-2[R] 개별 조회
    UserDto findById(int id);

}
