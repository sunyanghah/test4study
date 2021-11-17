package test.sy.zjzy.poi;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvFactory;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author sunYang
 * @Date 2020/8/13
 */
@RestController
@RequestMapping("/poi")
public class TestController {

    @PostMapping("/test")
    public void testPoi(MultipartFile file) throws Exception{

        jacksonCsv(file);

//        List<SysUserAddCmd> dataList = new ArrayList<>();
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(file.getInputStream(),"gb2312"));
//        String lineData = bufferedReader.readLine();
//        int lineNumber = 1;
//        while (lineData != null){
//            System.out.println(lineNumber+++"----------"+lineData);
//            if (lineNumber > 14){
//                dataList.add(handleLine(lineData));
//            }
//            lineData = bufferedReader.readLine();
//        }
//        System.out.println("=============================");
//        System.out.println("=============================");
//        System.out.println(JSON.toJSONString(dataList));
    }

//    private SysUserAddCmd handleLine(String lineData) throws Exception{
//        String[] dataArr = lineData.split(",");
//        SysUserAddCmd userAddCmd = new SysUserAddCmd();
//        int length = dataArr.length;
//        int dataNum = 0;
//        while(dataNum < length){
//            userAddCmd.setNextValue(dataArr[dataNum],dataNum);
//            dataNum++;
//        }
//        System.out.println("====="+ length);
//        return userAddCmd;
//    }


    @GetMapping("/test2")
    public void test() throws Exception{
        System.out.println("---------");
    }

    private void jacksonCsv(MultipartFile file) throws Exception{

        CsvMapper csvMapper = new CsvMapper();

        CsvFactory factory = csvMapper.getFactory();
        System.out.println("------");

//        CsvSchema csvSchema = CsvSchema.builder()
//                .addColumn("*姓名")
//                .addNumberColumn("*性别")
//                .addColumn("*组织路径")
//                .addColumn("*证件类型")
//                .addColumn("*证件号码")
//                .addColumn("工号")
//                .addColumn("手机号")
//                .addColumn("拼音").build();
//        CsvSchema csvSchema2 = CsvSchema.builder()
//                .addColumn("name")
//                .addNumberColumn("gender")
//                .addColumn("deptStr")
//                .addColumn("credType")
//                .addColumn("credNum")
//                .addColumn("code")
//                .addColumn("telephone")
//                .addColumn("pinyin").build();
//
//        MappingIterator<SysUserAddCmd> objectMappingIterator = csvMapper.readerFor(SysUserAddCmd.class)
//                .with(csvMapper.schemaFor(SysUserAddCmd.class)).readValues(file.getBytes());
//        List<SysUserAddCmd> sysUserAddCmds = objectMappingIterator.readAll();
//        System.out.println(sysUserAddCmds);
    }


}
