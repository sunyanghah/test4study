package test.retrofit.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author suny
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CurrentUser {

    private String id;
    private String username;
    private String realname;
    private String nickname;
    private String phone;
    private String email;
    private String avatar;
    private boolean internalFlag;
    private boolean enableFlag;

}
