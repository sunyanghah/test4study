package test.study.java.mianshiti2024.wework;

import lombok.Data;

import java.util.List;

/**
 * @author sun yang
 * @date 2024/7/24
 */
@Data
public class WeWorkDepartmentListDto extends WeWorkResp {

    private List<WeWorkDepartment> department;

}
