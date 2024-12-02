package test.study.java.mianshiti2024;

import test.study.java.mianshiti2024.wework.WeWorkApi;
import test.study.java.mianshiti2024.wework.WeWorkDepartment;
import test.study.java.mianshiti2024.wework.WeWorkDepartmentSyncDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author sun yang
 * @date 2024/7/29
 */
public class Test0729 {

    public static void main(String[] args) {
        WeWorkApi weWorkApi = WeWorkApi.builder("wwb11de0978bf9c057", "2CwTe4pCXrcPCBod6nqfbscnaMiCutzfhimu8uhZX9I");
        List<WeWorkDepartment> weWorkDepartments = weWorkApi.queryDepartment(2709L);
        Map<Long,String> syncDtoList = handleFullPath(weWorkDepartments, 2709L, "产研啊啊");
        System.out.println(syncDtoList);

    }

    private static Map<Long,String> handleFullPath(List<WeWorkDepartment> weWorkDepartmentList,
                                                   long syncRootDepartmentId, String parentPath){

        Map<Long,String> fullPathMap = new HashMap();

        WeWorkDepartment rootDto = new WeWorkDepartment();
        rootDto.setId(syncRootDepartmentId);
        fullPathMap.put(syncRootDepartmentId,parentPath);

        processNodePath(weWorkDepartmentList,rootDto,fullPathMap);

        return null;
    }

    private static WeWorkDepartmentSyncDto toSyncDto(WeWorkDepartment item){
        WeWorkDepartmentSyncDto dto = new WeWorkDepartmentSyncDto();
        dto.setId(item.getId());
        dto.setParentid(item.getParentid());
        dto.setName(item.getName());
        dto.setFullPath(item.getName());
        return dto;
    }

    private static void processNodePath(List<WeWorkDepartment> listOrig, WeWorkDepartment node,Map<Long,String> fullPathMap){
        listOrig.stream().filter((no) -> no.getParentid().equals(node.getId())).peek((no) -> {
            fullPathMap.put(no.getId(),fullPathMap.get(node.getId())+"/"+no.getName());
            processNodePath(listOrig, no, fullPathMap);
        }).collect(Collectors.toList());
    }


}
