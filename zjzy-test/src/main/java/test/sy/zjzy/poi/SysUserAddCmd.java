package test.sy.zjzy.poi;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

/**
 * @author sunYang
 * @Date 2020/8/8
 */
@Data
@JsonPropertyOrder({"name","gender","deptStr","credType","credNum","code","telephone","pinyin"})
public class SysUserAddCmd {

  private static final long serialVersionUID = -5853515615930063708L;

  private String name;

  private String gender;

  private String deptStr;

  private String credType;

  private String credNum;

  private String code;

  private String telephone;

  private String pinyin;

}
