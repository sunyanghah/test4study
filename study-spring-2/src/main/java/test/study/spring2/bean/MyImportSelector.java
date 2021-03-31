package test.study.spring2.bean;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * Created by dell on 2020/5/19.
 */
public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"test.study.spring2.bean.MyTestBean2","test.study.spring2.bean.MyTestBean3"};
    }
}
