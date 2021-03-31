package test.study.java.mianshi2020;


import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 项目环节枚举
 *
 * @author dell
 * @date 2020-12-22
 */
public enum CuxHrTasProjectStepE {

  S00_00_PUBLISH("S00_00_PUBLISH","立项",false),
  S01_00_APPLY("S01_00_APPLY","申报",true),
  S02_00_OPINION("S02_00_OPINION","单位意见",false),
  S02_01_YEAR("S02_01_YEAR","年度考核及任职期满",true),
  S02_02_BASE("S02_02_BASE","基层单位意见",true),
  S02_03_REPORT("S02_03_REPORT","呈报单位意见",true),
  S03_00_TRIAL("S03_00_TRIAL","申报表初审",true),
  S03_01_TRIAL_ADDED("S03_01_TRIAL_ADDED","材料补充",false),
  S04_00_REVIEW("S04_00_REVIEW","复审",true),
  S04_01_ARRANGE_REVIEW("S04_01_ARRANGE_REVIEW","指派复审人员",true),
  S04_02_REVIEW("S04_02_REVIEW","复审(被指定)",false),
  S05_00_EXAM("S05_00_EXAM","考试",false),
  S05_01_OFFLINE("S05_01_OFFLINE","线下考试",false),
  S05_02_RESULT("S05_02_RESULT","考试结果登记",true),
  S06_00_DEBATE("S06_00_DEBATE","答辩",false),
  S06_01_AREA("S06_01_AREA","答辩区域管理",true),
  S06_02_GROUP("S06_02_GROUP","答辩组专家管理",true),
  S06_03_ARRANGE_DEBATE("S06_03_ARRANGE_DEBATE","分配答辩专家",true),
  S06_04_ARRANGE_PAPER_QUESTION("S06_04_ARRANGE_PAPER_QUESTION","指定论文评分和出题专家",false),
  S06_05_PAPER_GUADE_QUESTION("S06_05_PAPER_GUADE_QUESTION","论文评分，答辩出题",true),
  S06_06_QUESTION_TABLE("S06_06_QUESTION_TABLE","导出出题表和签到表",false),
  S06_07_OFFLINE_DEBATE("S06_07_OFFLINE_DEBATE","线下答辩",false),
  S06_08_GUADE("S06_08_GUADE","答辩评分",true),
  S06_09_CALC("S06_09_CALC","计算得分",false),
  S06_10_ADJUST("S06_10_ADJUST","调整分数",true),
  S06_11_FINAL("S06_11_FINAL","最终得分(论文，答辩)",false),
  S06_12_COMMENT("S06_12_COMMENT","答辩评语",false),
  S07_00_ANON_EXPERT_OPINION("S07_00_ANON_EXPERT_OPINION","评审组织意见",true),
  S07_01_COMMENT("S07_01_COMMENT","评审组织评语",false),
  S08_00_GEN_CERT_NO("S08_00_GEN_CERT_NO","生成证书编号",true),
  S09_00_HR_OPINION("S09_00_HR_OPINION","人事或职改部门意见",true);

  @lombok.Getter
  private final String value;
  @lombok.Getter
  private final String name;
  @lombok.Getter
  private final Boolean execStepFlag;

  CuxHrTasProjectStepE(String value, String name, Boolean execStepFlag) {
    this.value = value;
    this.name = name;
    this.execStepFlag = execStepFlag;
  }

  public boolean eq(String value) {
    return this.equals(of(value));
  }

  public static CuxHrTasProjectStepE nextStep(CuxHrTasProjectStepE cuxHrTasProjectStepE){

    List<CuxHrTasProjectStepE> stepList = Arrays.stream(values()).filter(values -> values.execStepFlag).collect(Collectors.toList());

    stepList.sort(Comparator.comparing(e -> e.value));

    int index = stepList.indexOf(cuxHrTasProjectStepE);

    if (index == stepList.size()-1){
      return null;
    }

    return stepList.get(index+1);
  }

  /**
   * 得到枚举值，默认 YEAR。
   *
   * @param value value
   * @return enum
   */
  public static CuxHrTasProjectStepE of(String value) {
    return of(value, S02_01_YEAR);
  }

  public static CuxHrTasProjectStepE of(String value, CuxHrTasProjectStepE defaultValue) {
    return Stream.of(CuxHrTasProjectStepE.values())
      .filter(e -> e.getValue().equals(value))
      .findFirst()
      .orElse(defaultValue);
  }

  public static boolean eq(String value, CuxHrTasProjectStepE cuxHrTasProjectStatusE) {
    if ((value == null)
      || (cuxHrTasProjectStatusE == null)) {
      return false;
    }
    return cuxHrTasProjectStatusE.eq(value);
  }

  public static boolean eq(CuxHrTasProjectStepE cuxHrTasProjectStatusE, String value) {
    return eq(value, cuxHrTasProjectStatusE);
  }
}
