package study.ldap.util;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.*;
import java.io.IOException;
import java.util.Hashtable;

/**
 * @author sun yang
 * @date 2024/3/29
 */
public class Test0329 {

    public static void main(String[] args) throws IOException {

        queryPagedResults();
    }

    public static void queryPagedResults() throws IOException {
        String ldapUrl = "ldap://10.21.121.188:389";
        String username = "CN=sic,OU=asiainfo-sec,OU=asiainfo-Users,DC=ais,DC=com";
        String password = "Asiainfo@QWE$%^";
        String baseDn = "OU=disable,OU=asiainfo-sec,OU=asiainfo-Users,DC=ais,DC=com";
        String searchFilter = "(objectClass=person)";
        // 设置每页返回的最大条目数
        int pageSize = 2000;
        byte[] cookie = null;
        for (int i = 0; true; i++) {
            try {
                int realDataNum = 0;
                // 创建环境属性
                Hashtable<String, String> env = new Hashtable<>();
                env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
                env.put(Context.PROVIDER_URL, ldapUrl);
                env.put(Context.SECURITY_AUTHENTICATION, "simple");
                env.put(Context.SECURITY_PRINCIPAL, username); // 管理员账户
                env.put(Context.SECURITY_CREDENTIALS, password); // 管理员密码
                env.put("java.naming.ldap.attributes.binary", "objectGUID");

                // 创建LdapContext实例
                InitialLdapContext ctx = new InitialLdapContext(env, null);

                SearchControls controls2 = new SearchControls();
                controls2.setSearchScope(SearchControls.ONELEVEL_SCOPE);

                // 设置分页控制
                Control[] controls;

                if (i == 0) {
                    // 第一次查询，不需要cookie
                    controls = new Control[]{new PagedResultsControl(pageSize, Control.NONCRITICAL)};
                } else if (cookie == null){
                   break;
                } else{
                    // 后续查询，需要使用上一次查询的cookie
                    controls = new Control[]{new PagedResultsControl(pageSize, cookie,Control.NONCRITICAL)};
                }
                ctx.setRequestControls(controls);

                // 执行查询
                NamingEnumeration<SearchResult> results = ctx.search(baseDn, searchFilter, controls2);
                // 遍历结果集
                while (results.hasMoreElements()) {
                    realDataNum++;
                    SearchResult result = results.next();
                    Attributes attrs = result.getAttributes();
                    // 处理每个SearchResult的Attributes
                    // ... (这里可以添加处理逻辑，例如打印或存储属性)
                    System.out.println("Result: " + attrs.get("sAMAccountName").get());
                }

                // 获取分页控制的响应“cookie”
                Control[] responseControls = ctx.getResponseControls();
                if (responseControls != null) {
                    for (Control control : responseControls) {
                        if (control instanceof PagedResultsResponseControl) {
                            // 更新cookie
                            cookie = ((PagedResultsResponseControl) control).getCookie();
                        }
                    }
                }

                // 关闭上下文
                ctx.close();
            } catch (NamingException e) {
                e.printStackTrace();
            }
        }
    }

}
