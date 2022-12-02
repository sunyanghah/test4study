package test.itext.web;

import org.commonmark.Extension;
import org.commonmark.ext.gfm.tables.TableBlock;
import org.commonmark.ext.gfm.tables.TableBody;
import org.commonmark.ext.gfm.tables.TableCell;
import org.commonmark.ext.gfm.tables.TablesExtension;
import org.commonmark.ext.heading.anchor.HeadingAnchorExtension;
import org.commonmark.node.Link;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.AttributeProvider;
import org.commonmark.renderer.html.AttributeProviderContext;
import org.commonmark.renderer.html.AttributeProviderFactory;
import org.commonmark.renderer.html.HtmlRenderer;

import java.util.*;

public class MarkdownUtils {

    /**
     * markdown格式转换成HTML格式
     * @param markdown
     * @return
     */
    public static String markdownToHtml(String markdown) {
        Parser parser = Parser.builder().build();
        Node document = parser.parse(markdown);
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        return renderer.render(document);
    }

    /**
     * 增加扩展[标题锚点，表格生成]
     * Markdown转换成HTML
     * @param markdown
     * @return
     */
    public static String markdownToHtmlExtensions(String markdown) {
        //h标题生成id
        Set<Extension> headingAnchorExtensions = Collections.singleton(HeadingAnchorExtension.create());
        //转换table的HTML
        List<Extension> tableExtension = Arrays.asList(TablesExtension.create());
        Parser parser = Parser.builder()
                .extensions(tableExtension)
                .build();
        Node document = parser.parse(markdown);
        HtmlRenderer renderer = HtmlRenderer.builder()
                .extensions(headingAnchorExtensions)
                .extensions(tableExtension)
                .attributeProviderFactory(new AttributeProviderFactory() {
                    public AttributeProvider create(AttributeProviderContext context) {
                        return new CustomAttributeProvider();
                    }
                })
                .build();
        return renderer.render(document);
    }

    /**
     * 处理标签的属性
     */
    static class CustomAttributeProvider implements AttributeProvider {
        @Override
        public void setAttributes(Node node, String tagName, Map<String, String> attributes) {
            //改变a标签的target属性为_blank
            if (node instanceof Link) {
                attributes.put("target", "_blank");
            }
            if (node instanceof TableBlock){
                attributes.put("style","border-collapse: collapse");
            }
            if (node instanceof TableCell) {
                attributes.put("style", "border: 1px solid;padding: 3px;");
            }
        }
    }


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
        System.out.println(markdownToHtmlExtensions(a));
    }
}

