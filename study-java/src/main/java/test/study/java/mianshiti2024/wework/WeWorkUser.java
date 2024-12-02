package test.study.java.mianshiti2024.wework;

import lombok.Data;

import java.util.List;

/**
 * @author sun yang
 * @date 2024/7/26
 */
@Data
public class WeWorkUser {
    /**
     * 企业微信用户唯一ID
     */
    private String open_userid;
    /**
     * 在企业微信里对应管理端账号
     */
    private String userid;
    /**
     * 用户姓名
     */
    private String name;
    /**
     * 部门id列表
     */
    private List<Long> department;
    private String mobile;
    /**
     * 性别。0表示未定义，1表示男性，2表示女性
     */
    private String gender;
    private String email;
    /**
     * 头像url。可直接访问的路径
     */
    private String avatar;
}
