package cn.zealon.notes.domain;

import lombok.Data;

/**
 * @author: tangyl
 * @since: 2020/11/17
 */
@Data
public class UserInfo {
    private String userId;
    private String userName;
    private String password;
    private Integer enable;
    private Integer pwdLock;
}
