//package test.itext2.web;
//
//import com.itextpdf.html2pdf.ConverterProperties;
//import com.itextpdf.html2pdf.HtmlConverter;
//import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider;
//import com.itextpdf.layout.font.FontProvider;
//import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
//import org.springframework.util.ResourceUtils;
//
//import java.io.*;
//
///**
// * @author sunYang
// * @date 2022/8/2 16:58
// */
//public class TestController {
//
//    public static void htmlToPdf() throws Exception {
//        String a = "### ■『 text 』文本::配置说明\n" +
//                "\n" +
//                "#### 效果\n" +
//                "\n" +
//                "![企业微信截图_20220722151043.png](http://10.100.32.63:8888/group1/M00/00/01/CmQgP2LaTvGEJ2uhAAAAAIInu_g692.png)\n" +
//                "\n" +
//                "\n" +
//                "####  属性描述\n" +
//                "|-|字段名|含义|默认值|描述|是否必填|\n" +
//                "|-|-|-|-|-|-|\n" +
//                "|*|type|==文本==|==text==| 控件类型 |是|\n" +
//                "|*|key|唯一标识|-| 取值控件唯一标识 |是|\n" +
//                "|*|label|显示名称| -| - |-|\n" +
//                "|*|value|值|-| 控件值/默认值 |-|\n" +
//                "|*|placeholder|占位符|-| - |-|\n" +
//                "|*|description|描述|-| - |-|\n" +
//                "|*|hidden|隐藏|false| 控件隐藏 |-|\n" +
//                "|*|readonly|只读|false| 控件只读 |-|\n" +
//                "|*|required|必填|false| 控件必填 |-|\n" +
//                "|*|prefix|控件前缀|-| - |-|\n" +
//                "|*|suffix|控件后缀|-| - |-|\n" +
//                "|*|prefix_icon|控件前缀字体图标|-| - |-|\n" +
//                "|*|suffix_icon|控件后缀字体图标|-| - |-|\n" +
//                "#### 代码结构\n" +
//                "```JSON\n" +
//                "{\n" +
//                "  \"type\": \"text\", \n" +
//                "  \"key\": \"\",\n" +
//                "  \"label\": \"文本\",\n" +
//                "  \"placeholder\": \"\",\n" +
//                "  \"description\": \"\",\n" +
//                "  \"value\": \"\",\n" +
//                "  \"hidden\": false,\n" +
//                "  \"readonly\": false,\n" +
//                "  \"required\": false,\n" +
//                "  \"prefix\": \"\",\n" +
//                "  \"suffix\": \"\",\n" +
//                "  \"prefix_icon\": \"\",// icon-model\n" +
//                "  \"suffix_icon\": \"\" // icon-attachment\n" +
//                "}\n" +
//                "```\n" +
//                "#### 示例\n" +
//                "\n";
//
//        String destPath =  "H:/template.pdf";
//        ConverterProperties converterProperties = new ConverterProperties();
//        FontProvider dfp = new DefaultFontProvider();
//        // 添加字体库
//        dfp.addDirectory(ResourceUtils.getURL("Fonts").getPath());
//        converterProperties.setFontProvider(dfp);
//        try (OutputStream out = new FileOutputStream(new File(destPath))) {
//            HtmlConverter.convertToPdf("<!DOCTYPE html>\n" +
//                    "<html>\n" +
//                    "<head>\n" +
//                    "<title>TEST.MD</title>\n" +
//                    "<meta http-equiv=\"Content-type\" content=\"text/html;charset=UTF-8\">\n" +
//                    "\n" +
//                    "<style>\n" +
//                    "/* https://github.com/microsoft/vscode/blob/master/extensions/markdown-language-features/media/markdown.css */\n" +
//                    "/*---------------------------------------------------------------------------------------------\n" +
//                    " *  Copyright (c) Microsoft Corporation. All rights reserved.\n" +
//                    " *  Licensed under the MIT License. See License.txt in the project root for license information.\n" +
//                    " *--------------------------------------------------------------------------------------------*/\n" +
//                    "\n" +
//                    "body {\n" +
//                    "\tfont-family: var(--vscode-markdown-font-family, -apple-system, BlinkMacSystemFont, \"Segoe WPC\", \"Segoe UI\", \"Ubuntu\", \"Droid Sans\", sans-serif);\n" +
//                    "\tfont-size: var(--vscode-markdown-font-size, 14px);\n" +
//                    "\tpadding: 0 26px;\n" +
//                    "\tline-height: var(--vscode-markdown-line-height, 22px);\n" +
//                    "\tword-wrap: break-word;\n" +
//                    "}\n" +
//                    "\n" +
//                    "#code-csp-warning {\n" +
//                    "\tposition: fixed;\n" +
//                    "\ttop: 0;\n" +
//                    "\tright: 0;\n" +
//                    "\tcolor: white;\n" +
//                    "\tmargin: 16px;\n" +
//                    "\ttext-align: center;\n" +
//                    "\tfont-size: 12px;\n" +
//                    "\tfont-family: sans-serif;\n" +
//                    "\tbackground-color:#444444;\n" +
//                    "\tcursor: pointer;\n" +
//                    "\tpadding: 6px;\n" +
//                    "\tbox-shadow: 1px 1px 1px rgba(0,0,0,.25);\n" +
//                    "}\n" +
//                    "\n" +
//                    "#code-csp-warning:hover {\n" +
//                    "\ttext-decoration: none;\n" +
//                    "\tbackground-color:#007acc;\n" +
//                    "\tbox-shadow: 2px 2px 2px rgba(0,0,0,.25);\n" +
//                    "}\n" +
//                    "\n" +
//                    "body.scrollBeyondLastLine {\n" +
//                    "\tmargin-bottom: calc(100vh - 22px);\n" +
//                    "}\n" +
//                    "\n" +
//                    "body.showEditorSelection .code-line {\n" +
//                    "\tposition: relative;\n" +
//                    "}\n" +
//                    "\n" +
//                    "body.showEditorSelection .code-active-line:before,\n" +
//                    "body.showEditorSelection .code-line:hover:before {\n" +
//                    "\tcontent: \"\";\n" +
//                    "\tdisplay: block;\n" +
//                    "\tposition: absolute;\n" +
//                    "\ttop: 0;\n" +
//                    "\tleft: -12px;\n" +
//                    "\theight: 100%;\n" +
//                    "}\n" +
//                    "\n" +
//                    "body.showEditorSelection li.code-active-line:before,\n" +
//                    "body.showEditorSelection li.code-line:hover:before {\n" +
//                    "\tleft: -30px;\n" +
//                    "}\n" +
//                    "\n" +
//                    ".vscode-light.showEditorSelection .code-active-line:before {\n" +
//                    "\tborder-left: 3px solid rgba(0, 0, 0, 0.15);\n" +
//                    "}\n" +
//                    "\n" +
//                    ".vscode-light.showEditorSelection .code-line:hover:before {\n" +
//                    "\tborder-left: 3px solid rgba(0, 0, 0, 0.40);\n" +
//                    "}\n" +
//                    "\n" +
//                    ".vscode-light.showEditorSelection .code-line .code-line:hover:before {\n" +
//                    "\tborder-left: none;\n" +
//                    "}\n" +
//                    "\n" +
//                    ".vscode-dark.showEditorSelection .code-active-line:before {\n" +
//                    "\tborder-left: 3px solid rgba(255, 255, 255, 0.4);\n" +
//                    "}\n" +
//                    "\n" +
//                    ".vscode-dark.showEditorSelection .code-line:hover:before {\n" +
//                    "\tborder-left: 3px solid rgba(255, 255, 255, 0.60);\n" +
//                    "}\n" +
//                    "\n" +
//                    ".vscode-dark.showEditorSelection .code-line .code-line:hover:before {\n" +
//                    "\tborder-left: none;\n" +
//                    "}\n" +
//                    "\n" +
//                    ".vscode-high-contrast.showEditorSelection .code-active-line:before {\n" +
//                    "\tborder-left: 3px solid rgba(255, 160, 0, 0.7);\n" +
//                    "}\n" +
//                    "\n" +
//                    ".vscode-high-contrast.showEditorSelection .code-line:hover:before {\n" +
//                    "\tborder-left: 3px solid rgba(255, 160, 0, 1);\n" +
//                    "}\n" +
//                    "\n" +
//                    ".vscode-high-contrast.showEditorSelection .code-line .code-line:hover:before {\n" +
//                    "\tborder-left: none;\n" +
//                    "}\n" +
//                    "\n" +
//                    "img {\n" +
//                    "\tmax-width: 100%;\n" +
//                    "\tmax-height: 100%;\n" +
//                    "}\n" +
//                    "\n" +
//                    "a {\n" +
//                    "\ttext-decoration: none;\n" +
//                    "}\n" +
//                    "\n" +
//                    "a:hover {\n" +
//                    "\ttext-decoration: underline;\n" +
//                    "}\n" +
//                    "\n" +
//                    "a:focus,\n" +
//                    "input:focus,\n" +
//                    "select:focus,\n" +
//                    "textarea:focus {\n" +
//                    "\toutline: 1px solid -webkit-focus-ring-color;\n" +
//                    "\toutline-offset: -1px;\n" +
//                    "}\n" +
//                    "\n" +
//                    "hr {\n" +
//                    "\tborder: 0;\n" +
//                    "\theight: 2px;\n" +
//                    "\tborder-bottom: 2px solid;\n" +
//                    "}\n" +
//                    "\n" +
//                    "h1 {\n" +
//                    "\tpadding-bottom: 0.3em;\n" +
//                    "\tline-height: 1.2;\n" +
//                    "\tborder-bottom-width: 1px;\n" +
//                    "\tborder-bottom-style: solid;\n" +
//                    "}\n" +
//                    "\n" +
//                    "h1, h2, h3 {\n" +
//                    "\tfont-weight: normal;\n" +
//                    "}\n" +
//                    "\n" +
//                    "table {\n" +
//                    "\tborder-collapse: collapse;\n" +
//                    "}\n" +
//                    "\n" +
//                    "table > thead > tr > th {\n" +
//                    "\ttext-align: left;\n" +
//                    "\tborder-bottom: 1px solid;\n" +
//                    "}\n" +
//                    "\n" +
//                    "table > thead > tr > th,\n" +
//                    "table > thead > tr > td,\n" +
//                    "table > tbody > tr > th,\n" +
//                    "table > tbody > tr > td {\n" +
//                    "\tpadding: 5px 10px;\n" +
//                    "}\n" +
//                    "\n" +
//                    "table > tbody > tr + tr > td {\n" +
//                    "\tborder-top: 1px solid;\n" +
//                    "}\n" +
//                    "\n" +
//                    "blockquote {\n" +
//                    "\tmargin: 0 7px 0 5px;\n" +
//                    "\tpadding: 0 16px 0 10px;\n" +
//                    "\tborder-left-width: 5px;\n" +
//                    "\tborder-left-style: solid;\n" +
//                    "}\n" +
//                    "\n" +
//                    "code {\n" +
//                    "\tfont-family: Menlo, Monaco, Consolas, \"Droid Sans Mono\", \"Courier New\", monospace, \"Droid Sans Fallback\";\n" +
//                    "\tfont-size: 1em;\n" +
//                    "\tline-height: 1.357em;\n" +
//                    "}\n" +
//                    "\n" +
//                    "body.wordWrap pre {\n" +
//                    "\twhite-space: pre-wrap;\n" +
//                    "}\n" +
//                    "\n" +
//                    "pre:not(.hljs),\n" +
//                    "pre.hljs code > div {\n" +
//                    "\tpadding: 16px;\n" +
//                    "\tborder-radius: 3px;\n" +
//                    "\toverflow: auto;\n" +
//                    "}\n" +
//                    "\n" +
//                    "pre code {\n" +
//                    "\tcolor: var(--vscode-editor-foreground);\n" +
//                    "\ttab-size: 4;\n" +
//                    "}\n" +
//                    "\n" +
//                    "/** Theming */\n" +
//                    "\n" +
//                    ".vscode-light pre {\n" +
//                    "\tbackground-color: rgba(220, 220, 220, 0.4);\n" +
//                    "}\n" +
//                    "\n" +
//                    ".vscode-dark pre {\n" +
//                    "\tbackground-color: rgba(10, 10, 10, 0.4);\n" +
//                    "}\n" +
//                    "\n" +
//                    ".vscode-high-contrast pre {\n" +
//                    "\tbackground-color: rgb(0, 0, 0);\n" +
//                    "}\n" +
//                    "\n" +
//                    ".vscode-high-contrast h1 {\n" +
//                    "\tborder-color: rgb(0, 0, 0);\n" +
//                    "}\n" +
//                    "\n" +
//                    ".vscode-light table > thead > tr > th {\n" +
//                    "\tborder-color: rgba(0, 0, 0, 0.69);\n" +
//                    "}\n" +
//                    "\n" +
//                    ".vscode-dark table > thead > tr > th {\n" +
//                    "\tborder-color: rgba(255, 255, 255, 0.69);\n" +
//                    "}\n" +
//                    "\n" +
//                    ".vscode-light h1,\n" +
//                    ".vscode-light hr,\n" +
//                    ".vscode-light table > tbody > tr + tr > td {\n" +
//                    "\tborder-color: rgba(0, 0, 0, 0.18);\n" +
//                    "}\n" +
//                    "\n" +
//                    ".vscode-dark h1,\n" +
//                    ".vscode-dark hr,\n" +
//                    ".vscode-dark table > tbody > tr + tr > td {\n" +
//                    "\tborder-color: rgba(255, 255, 255, 0.18);\n" +
//                    "}\n" +
//                    "\n" +
//                    "</style>\n" +
//                    "\n" +
//                    "<style>\n" +
//                    "/* Tomorrow Theme */\n" +
//                    "/* http://jmblog.github.com/color-themes-for-google-code-highlightjs */\n" +
//                    "/* Original theme - https://github.com/chriskempson/tomorrow-theme */\n" +
//                    "\n" +
//                    "/* Tomorrow Comment */\n" +
//                    ".hljs-comment,\n" +
//                    ".hljs-quote {\n" +
//                    "\tcolor: #8e908c;\n" +
//                    "}\n" +
//                    "\n" +
//                    "/* Tomorrow Red */\n" +
//                    ".hljs-variable,\n" +
//                    ".hljs-template-variable,\n" +
//                    ".hljs-tag,\n" +
//                    ".hljs-name,\n" +
//                    ".hljs-selector-id,\n" +
//                    ".hljs-selector-class,\n" +
//                    ".hljs-regexp,\n" +
//                    ".hljs-deletion {\n" +
//                    "\tcolor: #c82829;\n" +
//                    "}\n" +
//                    "\n" +
//                    "/* Tomorrow Orange */\n" +
//                    ".hljs-number,\n" +
//                    ".hljs-built_in,\n" +
//                    ".hljs-builtin-name,\n" +
//                    ".hljs-literal,\n" +
//                    ".hljs-type,\n" +
//                    ".hljs-params,\n" +
//                    ".hljs-meta,\n" +
//                    ".hljs-link {\n" +
//                    "\tcolor: #f5871f;\n" +
//                    "}\n" +
//                    "\n" +
//                    "/* Tomorrow Yellow */\n" +
//                    ".hljs-attribute {\n" +
//                    "\tcolor: #eab700;\n" +
//                    "}\n" +
//                    "\n" +
//                    "/* Tomorrow Green */\n" +
//                    ".hljs-string,\n" +
//                    ".hljs-symbol,\n" +
//                    ".hljs-bullet,\n" +
//                    ".hljs-addition {\n" +
//                    "\tcolor: #718c00;\n" +
//                    "}\n" +
//                    "\n" +
//                    "/* Tomorrow Blue */\n" +
//                    ".hljs-title,\n" +
//                    ".hljs-section {\n" +
//                    "\tcolor: #4271ae;\n" +
//                    "}\n" +
//                    "\n" +
//                    "/* Tomorrow Purple */\n" +
//                    ".hljs-keyword,\n" +
//                    ".hljs-selector-tag {\n" +
//                    "\tcolor: #8959a8;\n" +
//                    "}\n" +
//                    "\n" +
//                    ".hljs {\n" +
//                    "\tdisplay: block;\n" +
//                    "\toverflow-x: auto;\n" +
//                    "\tcolor: #4d4d4c;\n" +
//                    "\tpadding: 0.5em;\n" +
//                    "}\n" +
//                    "\n" +
//                    ".hljs-emphasis {\n" +
//                    "\tfont-style: italic;\n" +
//                    "}\n" +
//                    "\n" +
//                    ".hljs-strong {\n" +
//                    "\tfont-weight: bold;\n" +
//                    "}\n" +
//                    "</style>\n" +
//                    "\n" +
//                    "<style>\n" +
//                    "/*\n" +
//                    " * Markdown PDF CSS\n" +
//                    " */\n" +
//                    "\n" +
//                    " body {\n" +
//                    "\tfont-family: -apple-system, BlinkMacSystemFont, \"Segoe WPC\", \"Segoe UI\", \"Ubuntu\", \"Droid Sans\", sans-serif, \"Meiryo\";\n" +
//                    "\tpadding: 0 12px;\n" +
//                    "}\n" +
//                    "\n" +
//                    "pre {\n" +
//                    "\tbackground-color: #f8f8f8;\n" +
//                    "\tborder: 1px solid #cccccc;\n" +
//                    "\tborder-radius: 3px;\n" +
//                    "\toverflow-x: auto;\n" +
//                    "\twhite-space: pre-wrap;\n" +
//                    "\toverflow-wrap: break-word;\n" +
//                    "}\n" +
//                    "\n" +
//                    "pre:not(.hljs) {\n" +
//                    "\tpadding: 23px;\n" +
//                    "\tline-height: 19px;\n" +
//                    "}\n" +
//                    "\n" +
//                    "blockquote {\n" +
//                    "\tbackground: rgba(127, 127, 127, 0.1);\n" +
//                    "\tborder-color: rgba(0, 122, 204, 0.5);\n" +
//                    "}\n" +
//                    "\n" +
//                    ".emoji {\n" +
//                    "\theight: 1.4em;\n" +
//                    "}\n" +
//                    "\n" +
//                    "code {\n" +
//                    "\tfont-size: 14px;\n" +
//                    "\tline-height: 19px;\n" +
//                    "}\n" +
//                    "\n" +
//                    "/* for inline code */\n" +
//                    ":not(pre):not(.hljs) > code {\n" +
//                    "\tcolor: #C9AE75; /* Change the old color so it seems less like an error */\n" +
//                    "\tfont-size: inherit;\n" +
//                    "}\n" +
//                    "\n" +
//                    "/* Page Break : use <div class=\"page\"/> to insert page break\n" +
//                    "-------------------------------------------------------- */\n" +
//                    ".page {\n" +
//                    "\tpage-break-after: always;\n" +
//                    "}\n" +
//                    "\n" +
//                    "</style>\n" +
//                    "\n" +
//                    "<script src=\"https://unpkg.com/mermaid/dist/mermaid.min.js\"></script>\n" +
//                    "</head>\n" +
//                    "<body>\n" +
//                    "  <script>\n" +
//                    "    mermaid.initialize({\n" +
//                    "      startOnLoad: true,\n" +
//                    "      theme: document.body.classList.contains('vscode-dark') || document.body.classList.contains('vscode-high-contrast')\n" +
//                    "          ? 'dark'\n" +
//                    "          : 'default'\n" +
//                    "    });\n" +
//                    "  </script>\n" +
//                    "<h3 id=\"%E2%96%A0-radio-%E5%8D%95%E9%80%89%E9%85%8D%E7%BD%AE%E8%AF%B4%E6%98%8E\">■『 radio 』单选::配置说明</h3>\n" +
//                    "<h4 id=\"%E6%8E%A7%E4%BB%B6%E6%95%88%E6%9E%9C\">控件效果</h4>\n" +
//                    "<pre class=\"hljs\"><code><div>TODO 效果图片\n" +
//                    "</div></code></pre>\n" +
//                    "<h4 id=\"%E5%B1%9E%E6%80%A7%E6%8F%8F%E8%BF%B0\">属性描述</h4>\n" +
//                    "<table>\n" +
//                    "<thead>\n" +
//                    "<tr>\n" +
//                    "<th>-</th>\n" +
//                    "<th>字段名</th>\n" +
//                    "<th>含义</th>\n" +
//                    "<th>默认值</th>\n" +
//                    "<th>描述</th>\n" +
//                    "<th>是否必填</th>\n" +
//                    "</tr>\n" +
//                    "</thead>\n" +
//                    "<tbody>\n" +
//                    "<tr>\n" +
//                    "<td>*</td>\n" +
//                    "<td>type</td>\n" +
//                    "<td>==单选==</td>\n" +
//                    "<td>==radio==</td>\n" +
//                    "<td>控件类型</td>\n" +
//                    "<td>是</td>\n" +
//                    "</tr>\n" +
//                    "<tr>\n" +
//                    "<td>*</td>\n" +
//                    "<td>key</td>\n" +
//                    "<td>唯一标识</td>\n" +
//                    "<td>-</td>\n" +
//                    "<td>取值控件唯一标识</td>\n" +
//                    "<td>是</td>\n" +
//                    "</tr>\n" +
//                    "<tr>\n" +
//                    "<td>*</td>\n" +
//                    "<td>label</td>\n" +
//                    "<td>显示名称</td>\n" +
//                    "<td>-</td>\n" +
//                    "<td>-</td>\n" +
//                    "<td>-</td>\n" +
//                    "</tr>\n" +
//                    "<tr>\n" +
//                    "<td>*</td>\n" +
//                    "<td>value</td>\n" +
//                    "<td>值</td>\n" +
//                    "<td>-</td>\n" +
//                    "<td>控件值/默认值</td>\n" +
//                    "<td>-</td>\n" +
//                    "</tr>\n" +
//                    "<tr>\n" +
//                    "<td>*</td>\n" +
//                    "<td><s>placeholder</s></td>\n" +
//                    "<td><s>引导文字</s></td>\n" +
//                    "<td>-</td>\n" +
//                    "<td>-</td>\n" +
//                    "<td>-</td>\n" +
//                    "</tr>\n" +
//                    "<tr>\n" +
//                    "<td>*</td>\n" +
//                    "<td>description</td>\n" +
//                    "<td>描述</td>\n" +
//                    "<td>-</td>\n" +
//                    "<td>-</td>\n" +
//                    "<td>-</td>\n" +
//                    "</tr>\n" +
//                    "<tr>\n" +
//                    "<td>*</td>\n" +
//                    "<td>hidden</td>\n" +
//                    "<td>隐藏</td>\n" +
//                    "<td>false</td>\n" +
//                    "<td>控件隐藏</td>\n" +
//                    "<td>是</td>\n" +
//                    "</tr>\n" +
//                    "<tr>\n" +
//                    "<td>*</td>\n" +
//                    "<td>readonly</td>\n" +
//                    "<td>只读</td>\n" +
//                    "<td>false</td>\n" +
//                    "<td>控件只读</td>\n" +
//                    "<td>是</td>\n" +
//                    "</tr>\n" +
//                    "<tr>\n" +
//                    "<td>*</td>\n" +
//                    "<td>required</td>\n" +
//                    "<td>必填</td>\n" +
//                    "<td>false</td>\n" +
//                    "<td>控件必填</td>\n" +
//                    "<td>是</td>\n" +
//                    "</tr>\n" +
//                    "<tr>\n" +
//                    "<td>*</td>\n" +
//                    "<td>prefix</td>\n" +
//                    "<td>控件前缀</td>\n" +
//                    "<td>-</td>\n" +
//                    "<td>-</td>\n" +
//                    "<td>-</td>\n" +
//                    "</tr>\n" +
//                    "<tr>\n" +
//                    "<td>*</td>\n" +
//                    "<td>suffix</td>\n" +
//                    "<td>控件后缀</td>\n" +
//                    "<td>-</td>\n" +
//                    "<td>-</td>\n" +
//                    "<td>-</td>\n" +
//                    "</tr>\n" +
//                    "<tr>\n" +
//                    "<td>*</td>\n" +
//                    "<td>prefix_icon</td>\n" +
//                    "<td>控件前缀字体图标</td>\n" +
//                    "<td>-</td>\n" +
//                    "<td>-</td>\n" +
//                    "<td>-</td>\n" +
//                    "</tr>\n" +
//                    "<tr>\n" +
//                    "<td>*</td>\n" +
//                    "<td>suffix_icon</td>\n" +
//                    "<td>控件后缀字体图标</td>\n" +
//                    "<td>-</td>\n" +
//                    "<td>-</td>\n" +
//                    "<td>-</td>\n" +
//                    "</tr>\n" +
//                    "<tr>\n" +
//                    "<td>*</td>\n" +
//                    "<td>dataset</td>\n" +
//                    "<td>数据集合</td>\n" +
//                    "<td>Array<ValueLabelObject></td>\n" +
//                    "<td>-</td>\n" +
//                    "<td>是</td>\n" +
//                    "</tr>\n" +
//                    "</tbody>\n" +
//                    "</table>\n" +
//                    "<ul>\n" +
//                    "<li>\n" +
//                    "<p>数据集 ValueLabelObject</p>\n" +
//                    "<table>\n" +
//                    "<thead>\n" +
//                    "<tr>\n" +
//                    "<th>字段名</th>\n" +
//                    "<th>含义</th>\n" +
//                    "<th>默认值</th>\n" +
//                    "<th>描述</th>\n" +
//                    "<th>是否必填</th>\n" +
//                    "</tr>\n" +
//                    "</thead>\n" +
//                    "<tbody>\n" +
//                    "<tr>\n" +
//                    "<td>value</td>\n" +
//                    "<td>值</td>\n" +
//                    "<td>-</td>\n" +
//                    "<td>-</td>\n" +
//                    "<td>是</td>\n" +
//                    "</tr>\n" +
//                    "<tr>\n" +
//                    "<td>label</td>\n" +
//                    "<td>显示名称</td>\n" +
//                    "<td>-</td>\n" +
//                    "<td>-</td>\n" +
//                    "<td>是</td>\n" +
//                    "</tr>\n" +
//                    "</tbody>\n" +
//                    "</table>\n" +
//                    "</li>\n" +
//                    "</ul>\n" +
//                    "<h4 id=\"%E4%BB%A3%E7%A0%81%E7%BB%93%E6%9E%84\">代码结构</h4>\n" +
//                    "<pre class=\"hljs\"><code><div>{\n" +
//                    "  <span class=\"hljs-attr\">\"type\"</span>: <span class=\"hljs-string\">\"radio\"</span>,\n" +
//                    "  <span class=\"hljs-attr\">\"key\"</span>: <span class=\"hljs-string\">\"\"</span>,\n" +
//                    "  <span class=\"hljs-attr\">\"label\"</span>: <span class=\"hljs-string\">\"单选\"</span>,\n" +
//                    "  <span class=\"hljs-attr\">\"value\"</span>: <span class=\"hljs-string\">\"\"</span>,\n" +
//                    "  <span class=\"hljs-comment\">//\"placeholder\": \"\", 不支持的属性</span>\n" +
//                    "  <span class=\"hljs-attr\">\"description\"</span>: <span class=\"hljs-string\">\"\"</span>,\n" +
//                    "  <span class=\"hljs-attr\">\"hidden\"</span>: <span class=\"hljs-literal\">false</span>,\n" +
//                    "  <span class=\"hljs-attr\">\"readonly\"</span>: <span class=\"hljs-literal\">false</span>,\n" +
//                    "  <span class=\"hljs-attr\">\"required\"</span>: <span class=\"hljs-literal\">false</span>,\n" +
//                    "  <span class=\"hljs-attr\">\"prefix\"</span>: <span class=\"hljs-string\">\"\"</span>,\n" +
//                    "  <span class=\"hljs-attr\">\"suffix\"</span>: <span class=\"hljs-string\">\"\"</span>,\n" +
//                    "  <span class=\"hljs-attr\">\"prefix_icon\"</span>: <span class=\"hljs-string\">\"\"</span>,\n" +
//                    "  <span class=\"hljs-attr\">\"suffix_icon\"</span>: <span class=\"hljs-string\">\"\"</span>,\n" +
//                    "  <span class=\"hljs-attr\">\"dataset\"</span>: [ <span class=\"hljs-comment\">//dataset 数据集 </span>\n" +
//                    "    <span class=\"hljs-comment\">//value 选中值  label 显示名称</span>\n" +
//                    "    {<span class=\"hljs-attr\">\"value\"</span>: <span class=\"hljs-string\">\"api\"</span>,<span class=\"hljs-attr\">\"label\"</span>: <span class=\"hljs-string\">\"接口数据\"</span>},\n" +
//                    "    {<span class=\"hljs-attr\">\"value\"</span>: <span class=\"hljs-string\">\"static\"</span>,<span class=\"hljs-attr\">\"label\"</span>: <span class=\"hljs-string\">\"静态数据\"</span>},\n" +
//                    "    {<span class=\"hljs-attr\">\"value\"</span>: <span class=\"hljs-string\">\"digitaltwin\"</span>,<span class=\"hljs-attr\">\"label\"</span>: <span class=\"hljs-string\">\"孪生体属性\"</span>},\n" +
//                    "  ],\n" +
//                    "\n" +
//                    "}\n" +
//                    "</div></code></pre>\n" +
//                    "\n" +
//                    "</body>\n" +
//                    "</html>\n", out, converterProperties);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void main(String[] args) throws Exception{
//        htmlToPdf();
//    }
//
//    public static byte[] file2byte(File file) {
//        if (file == null) {
//            return null;
//        }
//        FileInputStream fileInputStream = null;
//        ByteArrayOutputStream byteArrayOutputStream = null;
//        try {
//            fileInputStream = new FileInputStream(file);
//            byteArrayOutputStream = new ByteArrayOutputStream();
//            byte[] b = new byte[1024];
//            int n;
//            while ((n = fileInputStream.read(b)) != -1) {
//                byteArrayOutputStream.write(b, 0 , n);
//            }
//            return byteArrayOutputStream.toByteArray();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (fileInputStream != null) {
//                    fileInputStream.close();
//                }
//                if (byteArrayOutputStream != null) {
//                    byteArrayOutputStream.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return null;
//    }
//
//}
