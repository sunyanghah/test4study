package test.study.spring1.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.study.spring1.dto.TestExtendDto;
import test.study.spring1.service.TestServiceExtendService;

import javax.annotation.Resource;

/**
 * @author sunYang
 * @Date 2021-03-26
 */
@RestController
@RequestMapping("/test/extend")
public class TestServiceExtendController {

    @Resource
    private TestServiceExtendService testServiceExtendService;

    @PostMapping("/test1")
    public String test1(@RequestBody TestExtendDto testExtendDto){
//        TestServiceExtendService realService = ApplicationBeanContext.getBean(checkProject(testExtendDto.getProjectId()), TestServiceExtendService.class);
        return testServiceExtendService.getInfo();
//        return realService.getInfo();
    }

    private String checkProject(String projectId){
        if ("1".equals(projectId)){
            return "cat";
        }else if ("2".equals(projectId)){
            return "dog";
        }else{
            return "dog";
        }
    }

//    enum AlarmHandlerTypeE{
//
//        /**
//         * 进入
//         */
//        AIN(1, (TestAbstractService) () -> {
//            System.out.println("");
//            return null;
//        }),
//        /**
//         * 离开
//         */
//        AOUT(2,(fenceId, tagNumber,ignoreTimeMillis,timeout, stringRedisTemplate) -> {
//            stringRedisTemplate.opsForValue().set(RedisKeyE.REDIS_KEY_D_FNC.getValue()+fenceId
//                    +RedisKeyE.REDIS_KEY_SUFFIX_AOUT_IGNORE.getValue()+ tagNumber,String.valueOf(ignoreTimeMillis),timeout, TimeUnit.MILLISECONDS);
//        });
//
//        @Getter
//        private Integer type;
//        @Getter
//        private TestServiceExtendService service;
//
//        AlarmHandlerTypeE(Integer type, TestServiceExtendService service){
//            this.type = type;
//            this.service = service;
//        }
//
//        public static AlarmHandlerTypeE of(Integer type) {
//            return Stream.of(AlarmHandlerTypeE.values())
//                    .filter(e -> e.getType().equals(type))
//                    .findFirst()
//                    .orElse(null);
//        }
//
//    }

}
