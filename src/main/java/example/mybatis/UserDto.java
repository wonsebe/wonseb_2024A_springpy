package example.mybatis;

import lombok.*;
import org.springframework.scheduling.support.SimpleTriggerContext;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter @ToString @Builder
public class UserDto {
    private int id;
    private String name;
    private  int age;
}
