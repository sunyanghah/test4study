package test.itext.web;


import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerFontProvider;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import com.itextpdf.tool.xml.pipeline.end.PdfWriterPipeline;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.nio.charset.Charset;

/**
 * @author sunYang
 * @date 2022/8/1 18:10
 */
public class TestController {

    public static void main(String[] args) {

        String a = "### ■『 text 』文本::配置说明\n" +
                "\n" +
                "#### 效果\n" +
                "\n" +
                "![企业微信截图_20220722151043.png](http://10.100.32.63:8888/group1/M00/00/01/CmQgP2LaTvGEJ2uhAAAAAIInu_g692.png)\n" +
                "\n" +
                "\n" +
                "####  属性描述\n" +
                "|-|字段名|含义|默认值|描述|是否必填|\n" +
                "|-|-|-|-|-|-|\n" +
                "|*|type|==文本==|==text==| 控件类型 |是|\n" +
                "|*|key|唯一标识|-| 取值控件唯一标识 |是|\n" +
                "|*|label|显示名称| -| - |-|\n" +
                "|*|value|值|-| 控件值/默认值 |-|\n" +
                "|*|placeholder|占位符|-| - |-|\n" +
                "|*|description|描述|-| - |-|\n" +
                "|*|hidden|隐藏|false| 控件隐藏 |-|\n" +
                "|*|readonly|只读|false| 控件只读 |-|\n" +
                "|*|required|必填|false| 控件必填 |-|\n" +
                "|*|prefix|控件前缀|-| - |-|\n" +
                "|*|suffix|控件后缀|-| - |-|\n" +
                "|*|prefix_icon|控件前缀字体图标|-| - |-|\n" +
                "|*|suffix_icon|控件后缀字体图标|-| - |-|\n" +
                "#### 代码结构\n" +
                "```JSON\n" +
                "{\n" +
                "  \"type\": \"text\", \n" +
                "  \"key\": \"\",\n" +
                "  \"label\": \"文本\",\n" +
                "  \"placeholder\": \"\",\n" +
                "  \"description\": \"\",\n" +
                "  \"value\": \"\",\n" +
                "  \"hidden\": false,\n" +
                "  \"readonly\": false,\n" +
                "  \"required\": false,\n" +
                "  \"prefix\": \"\",\n" +
                "  \"suffix\": \"\",\n" +
                "  \"prefix_icon\": \"\",// icon-model\n" +
                "  \"suffix_icon\": \"\" // icon-attachment\n" +
                "}\n" +
                "```\n" +
                "#### 示例\n" +
                "\n";

//        String b = "<html><body>" + MarkdownUtils.markdownToHtmlExtensions(a) + "</body></html>";

        String b = "<html><body>" + "<div data-v-7a63e4b3=\"\" class=\"v-show-content scroll-style scroll-style-border-radius\" style=\"background-color: rgb(251, 251, 251);\"><h3><a id=\"_text__0\"></a>■『 text 』文本::配置说明</h3>\n" +
                "<h4><a id=\"_2\"></a>效果</h4>\n" +
                "<p><img src=\"http://10.100.32.63:8888/group1/M00/00/01/CmQgP2LaTvGEJ2uhAAAAAIInu_g692.png\" alt=\"企业微信截图_20220722151043.png\" /></p>\n" +
                "<h4><a id=\"_7\"></a>属性描述</h4>\n" +
                "<table>\n" +
                "<thead>\n" +
                "<tr>\n" +
                "<th>-</th>\n" +
                "<th>字段名</th>\n" +
                "<th>含义</th>\n" +
                "<th>默认值</th>\n" +
                "<th>描述</th>\n" +
                "<th>是否必填</th>\n" +
                "</tr>\n" +
                "</thead>\n" +
                "<tbody>\n" +
                "<tr>\n" +
                "<td>*</td>\n" +
                "<td>type</td>\n" +
                "<td><mark>文本</mark></td>\n" +
                "<td><mark>text</mark></td>\n" +
                "<td>控件类型</td>\n" +
                "<td>是</td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td>*</td>\n" +
                "<td>key</td>\n" +
                "<td>唯一标识</td>\n" +
                "<td>-</td>\n" +
                "<td>取值控件唯一标识</td>\n" +
                "<td>是</td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td>*</td>\n" +
                "<td>label</td>\n" +
                "<td>显示名称</td>\n" +
                "<td>-</td>\n" +
                "<td>-</td>\n" +
                "<td>-</td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td>*</td>\n" +
                "<td>value</td>\n" +
                "<td>值</td>\n" +
                "<td>-</td>\n" +
                "<td>控件值/默认值</td>\n" +
                "<td>-</td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td>*</td>\n" +
                "<td>placeholder</td>\n" +
                "<td>占位符</td>\n" +
                "<td>-</td>\n" +
                "<td>-</td>\n" +
                "<td>-</td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td>*</td>\n" +
                "<td>description</td>\n" +
                "<td>描述</td>\n" +
                "<td>-</td>\n" +
                "<td>-</td>\n" +
                "<td>-</td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td>*</td>\n" +
                "<td>hidden</td>\n" +
                "<td>隐藏</td>\n" +
                "<td>false</td>\n" +
                "<td>控件隐藏</td>\n" +
                "<td>-</td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td>*</td>\n" +
                "<td>readonly</td>\n" +
                "<td>只读</td>\n" +
                "<td>false</td>\n" +
                "<td>控件只读</td>\n" +
                "<td>-</td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td>*</td>\n" +
                "<td>required</td>\n" +
                "<td>必填</td>\n" +
                "<td>false</td>\n" +
                "<td>控件必填</td>\n" +
                "<td>-</td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td>*</td>\n" +
                "<td>prefix</td>\n" +
                "<td>控件前缀</td>\n" +
                "<td>-</td>\n" +
                "<td>-</td>\n" +
                "<td>-</td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td>*</td>\n" +
                "<td>suffix</td>\n" +
                "<td>控件后缀</td>\n" +
                "<td>-</td>\n" +
                "<td>-</td>\n" +
                "<td>-</td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td>*</td>\n" +
                "<td>prefix_icon</td>\n" +
                "<td>控件前缀字体图标</td>\n" +
                "<td>-</td>\n" +
                "<td>-</td>\n" +
                "<td>-</td>\n" +
                "</tr>\n" +
                "<tr>\n" +
                "<td>*</td>\n" +
                "<td>suffix_icon</td>\n" +
                "<td>控件后缀字体图标</td>\n" +
                "<td>-</td>\n" +
                "<td>-</td>\n" +
                "<td>-</td>\n" +
                "</tr>\n" +
                "</tbody>\n" +
                "</table>\n" +
                "<h4><a id=\"_23\"></a>代码结构</h4>\n" +
                "<pre><div class=\"hljs\"><code class=\"lang-JSON\"><span class=\"hljs-punctuation\">{</span>\n" +
                "  <span class=\"hljs-attr\">\"type\"</span><span class=\"hljs-punctuation\">:</span> <span class=\"hljs-string\">\"text\"</span><span class=\"hljs-punctuation\">,</span> \n" +
                "  <span class=\"hljs-attr\">\"key\"</span><span class=\"hljs-punctuation\">:</span> <span class=\"hljs-string\">\"\"</span><span class=\"hljs-punctuation\">,</span>\n" +
                "  <span class=\"hljs-attr\">\"label\"</span><span class=\"hljs-punctuation\">:</span> <span class=\"hljs-string\">\"文本\"</span><span class=\"hljs-punctuation\">,</span>\n" +
                "  <span class=\"hljs-attr\">\"placeholder\"</span><span class=\"hljs-punctuation\">:</span> <span class=\"hljs-string\">\"\"</span><span class=\"hljs-punctuation\">,</span>\n" +
                "  <span class=\"hljs-attr\">\"description\"</span><span class=\"hljs-punctuation\">:</span> <span class=\"hljs-string\">\"\"</span><span class=\"hljs-punctuation\">,</span>\n" +
                "  <span class=\"hljs-attr\">\"value\"</span><span class=\"hljs-punctuation\">:</span> <span class=\"hljs-string\">\"\"</span><span class=\"hljs-punctuation\">,</span>\n" +
                "  <span class=\"hljs-attr\">\"hidden\"</span><span class=\"hljs-punctuation\">:</span> <span class=\"hljs-keyword\">false</span><span class=\"hljs-punctuation\">,</span>\n" +
                "  <span class=\"hljs-attr\">\"readonly\"</span><span class=\"hljs-punctuation\">:</span> <span class=\"hljs-keyword\">false</span><span class=\"hljs-punctuation\">,</span>\n" +
                "  <span class=\"hljs-attr\">\"required\"</span><span class=\"hljs-punctuation\">:</span> <span class=\"hljs-keyword\">false</span><span class=\"hljs-punctuation\">,</span>\n" +
                "  <span class=\"hljs-attr\">\"prefix\"</span><span class=\"hljs-punctuation\">:</span> <span class=\"hljs-string\">\"\"</span><span class=\"hljs-punctuation\">,</span>\n" +
                "  <span class=\"hljs-attr\">\"suffix\"</span><span class=\"hljs-punctuation\">:</span> <span class=\"hljs-string\">\"\"</span><span class=\"hljs-punctuation\">,</span>\n" +
                "  <span class=\"hljs-attr\">\"prefix_icon\"</span><span class=\"hljs-punctuation\">:</span> <span class=\"hljs-string\">\"\"</span><span class=\"hljs-punctuation\">,</span><span class=\"hljs-comment\">// icon-model</span>\n" +
                "  <span class=\"hljs-attr\">\"suffix_icon\"</span><span class=\"hljs-punctuation\">:</span> <span class=\"hljs-string\">\"\"</span> <span class=\"hljs-comment\">// icon-attachment</span>\n" +
                "<span class=\"hljs-punctuation\">}</span>\n" +
                "</code></div></pre>\n" +
                "<h4><a id=\"_41\"></a>示例</h4>\n" +
                "</div>" + "</body></html>";

        System.out.println("--------------");
        System.out.println(b);
        System.out.println("--------------");

        createdPdfByItextHtml(b,new File("H:/test.pdf"));
    }


    public static void createdPdfByItextHtml(String htmlContent, File file){
        InputStream inputStream = null;
        FileOutputStream outputStream = null;
        PdfWriter writer = null;
        try {
            // 1. 获取生成pdf的html内容
            inputStream= new ByteArrayInputStream(htmlContent.getBytes("utf-8"));
            outputStream = new FileOutputStream(file);
            Document document = new Document();
            writer = PdfWriter.getInstance(document, outputStream);
            document.open();
            // 2. 添加字体
//            XMLWorkerFontProvider fontImp = new XMLWorkerFontProvider(XMLWorkerFontProvider.DONTLOOKFORFONTS);
//            fontImp.register(getFontPath());
            // 3. 设置编码
            XMLWorkerHelper.getInstance().parseXHtml(writer, document, inputStream, Charset.forName("UTF-8"),new CustomXMLWorkerFontProvider());
            // 4. 关闭,(不关闭则会生成无效pdf)
            document.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }finally {
            try {
                if(writer!=null){
                    writer.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            }catch(IOException ex){
                ex.printStackTrace();
            }
        }
    }


    @Slf4j
    public static class CustomXMLWorkerFontProvider extends XMLWorkerFontProvider {

        @Override
        public Font getFont(final String fontName, final String encoding, final boolean embedded, final float size, final int style,
                            final BaseColor color) {
            BaseFont bf = null;
            try {
                bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.EMBEDDED);
                Font font = new Font(bf, size, style, color);
                font.setColor(color);
                // log.info("PDF文档字体初始化完成!");
                return font;
            } catch (Exception e) {
                log.error("exception:", e);
            }
            return null;
        }
    }

}
