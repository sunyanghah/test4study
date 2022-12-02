//package test.itext2.web;
//
//
//import com.floppylab.markdown2document.domain.Document;
//import com.floppylab.markdown2document.domain.Link;
//import com.floppylab.markdown2document.domain.Output;
//import com.floppylab.markdown2document.generator.HtmlGenerator;
//import com.floppylab.markdown2document.generator.PdfGenerator;
//import com.floppylab.markdown2document.util.ContentFactory;
//
//import java.net.URL;
//import java.util.Arrays;
//
///**
// * @author sunYang
// * @date 2022/8/8 10:11
// */
//public class MdToolTest {
//
//    public static void main(String[] args) throws Exception{
//
//        String markdown_content = "### ■『 audio 』音频::配置说明\n" +
//                "\n" +
//                "#### 控件效果\n" +
//                "```\n" +
//                "TODO 效果图片\n" +
//                "```\n" +
//                "\n" +
//                "#### 属性描述\n" +
//                "|-字段名|含义|默认值|描述|是否必填|\n" +
//                "|-|-|-|-|-|-|\n" +
//                "|*|type|==音频==|==audio==| 控件类型 |是|\n" +
//                "|*|key|唯一标识|-| 取值控件唯一标识 |是|\n" +
//                "|*|label|显示名称| -| - |-|\n" +
//                "|*|value|值| - | 控件值/默认值 |-|\n" +
//                "|*|~~placeholder~~|~~引导文字~~|-| - |-|\n" +
//                "|*|description|描述|-| - |-|\n" +
//                "|*|hidden|隐藏|false| 控件隐藏 |-|\n" +
//                "|*|readonly|只读|false| 控件只读 |-|\n" +
//                "|*|required|必填|false| 控件必填 |-|\n" +
//                "|*|prefix|控件前缀|-| - |-|\n" +
//                "|*|suffix|控件后缀|-| - |-|\n" +
//                "|*|prefix_icon|控件前缀字体图标|-| - |-|\n" +
//                "|*|suffix_icon|控件后缀字体图标|-| - |-|\n" +
//                "\n" +
//                "- 默认支持音频资源类型\n" +
//                " \n" +
//                "  |类型|全称|分类|描述|\n" +
//                "  |-|-|-|-|\n" +
//                "  |MP3|MPEG Audio Layer3|音频|音频信息的压缩编码标准|\n" +
//                "  |~~WMA~~|~~Windows Media Audio~~|~~音频~~|~~微软开发的一种音频格式</br>压缩比和音质方面都超过了MP3|\n" +
//                "  |~~ACC~~|~~Advanced Audio Coding~~|~~音频~~|~~体积小音质高</br>体积太大~~|\n" +
//                "\n" +
//                "\n" +
//                "#### 代码结构\n" +
//                "```JSON\n" +
//                "{\n" +
//                "  \"type\": \"audio\",\n" +
//                "  \"key\": \"\",\n" +
//                "  \"label\": \"音频\",\n" +
//                "  //\"placeholder\": \"\", 不支持的属性\n" +
//                "  \"description\": \"\",\n" +
//                "  \"value\": \"\",\n" +
//                "  \"hidden\": false,\n" +
//                "  \"readonly\": false,\n" +
//                "  \"required\": false,\n" +
//                "  \"prefix\": \"\",\n" +
//                "  \"suffix\": \"\",\n" +
//                "  \"prefix_icon\": \"\",\n" +
//                "  \"suffix_icon\": \"\",\n" +
//                "}\n" +
//                "```\n";
//
//        ContentFactory contentFactory = ContentFactory.getInstance();
//
//        Document document = Document
//                .builder()
//                .markdownContents(Arrays.asList(
//                        contentFactory.create(markdown_content)
//                ))
//                .styles(Arrays.asList(
//                        new Link("https://raw.githubusercontent.com/yrgoldteeth/darkdowncss/master/darkdown.css")
//                )).build();
//
////        PdfGenerator pdfGenerator = new PdfGenerator();
////        Output output = pdfGenerator.generate(document);
////        output.toFile("sample.pdf");
//
//        HtmlGenerator htmlGenerator = new HtmlGenerator();
//        Output output = htmlGenerator.generate(document);
//        String html = new String(output.getContent());
////        output.toFile("sample.html");
//
//        System.out.println(html);
//
//    }
//
//
//}
