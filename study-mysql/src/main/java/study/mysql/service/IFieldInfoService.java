package study.mysql.service;

import study.mysql.entity.FieldInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author dell
 * @since 2020-12-18
 */
public interface IFieldInfoService extends IService<FieldInfo> {

    void init();

}
