//package test.study.news.web;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import test.study.common.platform.RP;
//import test.study.news.dto.InAddKindDto;
//import test.study.news.dto.InKindListDto;
//import test.study.news.dto.InUpdateKindDto;
//import test.study.news.dto.OutKindInfoDto;
//import test.study.news.service.NewsKindService;
//
//import javax.validation.Valid;
//import java.util.List;
//
///**
// * Created by dell on 2019/3/11.
// * @author dell
// *
// * 新闻分类
// *
// */
//@RestController
//@RequestMapping("/kind")
//public class NewsKindController {
//
//    @Autowired
//    private NewsKindService newsKindService;
//
//    /**
//     * 分页查询
//     * @param inKindListDto
//     * @return
//     * @throws Exception
//     */
//    @PostMapping("/listPage")
//    public RP getKindList(@Valid @RequestBody InKindListDto inKindListDto) throws Exception {
//        List<OutKindInfoDto> kindListDtoList = newsKindService.getKindList(inKindListDto);
//        return RP.buildSuccess(kindListDtoList);
//    }
//
//    /**
//     * 新增
//     * @param inAddKindDto
//     * @return
//     * @throws Exception
//     */
//    @PostMapping()
//    public RP addKind(@RequestBody @Valid InAddKindDto inAddKindDto) throws Exception{
//        newsKindService.addKind(inAddKindDto);
//        return RP.buildSuccess("新增成功");
//    }
//
//    /**
//     * 获取一条数据详细信息
//     * @param id
//     * @return
//     * @throws Exception
//     */
//    @GetMapping("/{id}")
//    public RP getKindInfo(@PathVariable("id")Long id) throws Exception {
//        OutKindInfoDto outKindInfoDto = newsKindService.getKindInfo(id);
//        return RP.buildSuccess(outKindInfoDto);
//    }
//
//    /**
//     * 修改
//     * @param inUpdateKindDto
//     * @return
//     * @throws Exception
//     */
//    @PutMapping()
//    public RP updateKind(@Valid @RequestBody InUpdateKindDto inUpdateKindDto) throws Exception{
//        newsKindService.updateKind(inUpdateKindDto);
//        return RP.buildSuccess("修改成功");
//    }
//
//    /**
//     * 单条删除
//     * @param id
//     * @return
//     * @throws Exception
//     */
//    @DeleteMapping("/{id}")
//    public RP deleteKind(@PathVariable("id")Long id) throws Exception{
//        newsKindService.deleteKind(id);
//        return RP.buildSuccess("删除成功");
//    }
//}
