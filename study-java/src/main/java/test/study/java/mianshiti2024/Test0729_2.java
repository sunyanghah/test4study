package test.study.java.mianshiti2024;

import test.study.java.mianshiti2024.wework.WeWorkDepartmentSyncDto;

import java.lang.reflect.Field;

/**
 * @author sun yang
 * @date 2024/7/29
 */
public class Test0729_2 {

    public static void main(String[] args) throws NoSuchFieldException {
        WeWorkDepartmentSyncDto syncDto = new WeWorkDepartmentSyncDto();
        syncDto.setId(1L);
        syncDto.setFullPath("fullPath");
        syncDto.setName("333");

        Class clazz = syncDto.getClass();
        Field ids = clazz.getDeclaredField("name");

        System.out.println(ids.getName());

    }

}
