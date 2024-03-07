package study.mysql.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.mysql.config.IdGenerator;
import study.mysql.entity.FieldInfo;
import study.mysql.mapper.FieldInfoMapper;
import study.mysql.service.IFieldInfoService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author dell
 * @since 2020-12-18
 */
@Service
public class FieldInfoServiceImpl extends ServiceImpl<FieldInfoMapper, FieldInfo> implements IFieldInfoService {

    @Resource
    private IdGenerator idGenerator;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void init() {

        List<FieldInfo> fieldInfoList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            FieldInfo fieldInfo = new FieldInfo();
            fieldInfo.setId(idGenerator.next());
            fieldInfo.setCategoryId(idGenerator.next());
            fieldInfo.setCode("thisIsCode"+i);
            fieldInfo.setName("thisIsName"+i);
            fieldInfo.setDescription("thisIsDescription"+i);
            fieldInfoList.add(fieldInfo);
            if (fieldInfoList.size() == 3){
                this.saveBatch(fieldInfoList);
                fieldInfoList.clear();
            }
        }
    }

}
