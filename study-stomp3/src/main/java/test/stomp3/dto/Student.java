package test.stomp3.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import test.stomp3.config.Check;

/**
 * @author sunYang
 * @date 2022/6/16 15:11
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {

    private String name;

    @Check
    private String id;

    @Check
    private Integer age;

}
