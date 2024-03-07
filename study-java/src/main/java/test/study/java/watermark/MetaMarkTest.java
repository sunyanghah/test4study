package test.study.java.watermark;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static test.study.java.watermark.BusinessResponseEnum.UN_MARK_ERROR;

/**
 * @author sun yang
 * @date 2023/12/7
 */
@Slf4j
public class MetaMarkTest {

    public static void main(String[] args) throws Exception{

        FileTraceDto fileTraceDto = new FileTraceDto();
        fileTraceDto.setNickName("李四");
        fileTraceDto.setEmail("15012123336@163.com");
        fileTraceDto.setStatus("启用");
        fileTraceDto.setPhoneNumber("15012123336");
        fileTraceDto.setDeptName("亚信安全/业务与数据安全平台/C部门");
        fileTraceDto.setEmployeeNumber("110003");
        fileTraceDto.setDownloadTime("2023-11-23 05:11:00");
        fileTraceDto.setDeviceName("李四的dell");

//        fileAppendWatermark(wordFile,fileTraceDto);

//        OutFileTraceVo outFileTraceVo = fileTrace(wordFile);
//        System.out.println(JSON.toJSONString(outFileTraceVo));

        System.out.println(JSON.toJSONString(fileTraceDto));


        FileTraceDeviceDto fileTraceDeviceDto = new FileTraceDeviceDto();
        fileTraceDeviceDto.setDeviceId("123456789");
        fileTraceDeviceDto.setDeviceName("王五的dell");
        fileTraceDeviceDto.setStatus("启用");
        fileTraceDeviceDto.setIp("10.21.12.33");
        fileTraceDeviceDto.setMac("00-50-56-C0-00-01");
        fileTraceDeviceDto.setDeviceVersion("1.0.0");
        fileTraceDeviceDto.setOsVersion("Windows 10");
        fileTraceDeviceDto.setDownloadSource("报销系统");
        fileTraceDeviceDto.setDownloadTime("2023-11-22 05:11:00");

        System.out.println(JSON.toJSONString(fileTraceDeviceDto));

    }

    public static OutFileTraceVo fileTrace(File file) {

        String fileName = file.getName();
        OutFileTraceVo outFileTraceVo = new OutFileTraceVo();
        outFileTraceVo.setFileName(fileName);
        try {
            String traceStr = HiddenWaterMarkUtil.parseMarker(fileName, new FileInputStream(file));
            List<FileTraceDto> traceDtoList = JSON.parseArray(traceStr, FileTraceDto.class);
            outFileTraceVo.setTraceList(traceDtoList);
        } catch (Exception e) {
            log.warn("文件溯源失败: ", fileName);
        }
        return outFileTraceVo;

    }

    public static void fileAppendWatermark(File file, FileTraceDto markerDto){
        try {
            List<FileTraceDto> traceDtoList = new ArrayList<>();
            FileInputStream parseInputStream = new FileInputStream(file);
            String traceStr = HiddenWaterMarkUtil.parseMarker(file.getName(), parseInputStream);
            if (traceStr != null) {
                traceDtoList = JSON.parseArray(traceStr, FileTraceDto.class);
            }
            // 如果时间倒序，则插入到第一个。否则插入到最后一个
            traceDtoList.add(0, markerDto);

            ByteArrayOutputStream byteArrayOutputStream = HiddenWaterMarkUtil.marker(file.getName(), new FileInputStream(file), JSON.toJSONString(traceDtoList));
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(byteArrayOutputStream.toByteArray());
            fileOutputStream.flush();
            fileOutputStream.close();
        }catch (Exception e){
            e.printStackTrace();
            throw UN_MARK_ERROR.newException();
        }
    }

}
