package study.ldap.util;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.*;
import java.util.Hashtable;

/**
 * @author sun yang
 * @date 2024/1/16
 */
public class LDAPQueryOrgExample {
    public static void main(String[] args) {
        String ldapUrl = "ldap://10.21.121.188:389"; // LDAP服务器的URL
        String bindDn = "CN=sic,OU=asiainfo-sec,OU=asiainfo-Users,DC=ais,DC=com"; // 管理员的DN
        String bindPassword = "Asiainfo@QWE$%^"; // 管理员的密码
        String baseDn = "OU=业务与数据安全平台,OU=亚信安全OA,OU=asiainfo-sec,OU=asiainfo-Users,DC=ais,DC=com"; // 搜索的基础DN
        String searchFilter = "(objectClass=organizationalUnit)"; // 过滤条件

        try {
            // 建立LDAP连接
            DirContext ctx = new InitialDirContext(createEnv(ldapUrl, bindDn, bindPassword));

            // 设置搜索控制项
            SearchControls controls = new SearchControls();
            controls.setSearchScope(SearchControls.SUBTREE_SCOPE);

            // 执行搜索
            NamingEnumeration<SearchResult> results = ctx.search(baseDn, searchFilter, controls);

            // 遍历搜索结果
            while (results.hasMore()) {
                SearchResult result = results.next();
                Attributes attrs = result.getAttributes();
                Attribute attr = attrs.get("ou");
                if (attr != null && attr.get() != null){
                    System.out.println("组织名: " + attr.get().toString());
                }
            }

            // 关闭LDAP连接
            ctx.close();
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    private static Hashtable<String, String> createEnv(String ldapUrl, String bindDn, String bindPassword) {
        Hashtable<String, String> env = new Hashtable<>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, ldapUrl);
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, bindDn);
        env.put(Context.SECURITY_CREDENTIALS, bindPassword);
        return env;
    }
}
