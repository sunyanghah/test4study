package study.ldap.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.*;
import java.lang.reflect.Field;
import java.security.Security;
import java.util.*;

/**
 * @author sun yang
 * @date 2024/1/15
 */
@Slf4j
public class Test {

    public static void main(String[] args) {
        ImcSyncConfigVo imcSyncConfigVo = new ImcSyncConfigVo();
//        imcSyncConfigVo.setAdminDn("CN=sic,OU=asiainfo-sec,OU=asiainfo-Users,DC=ais,DC=com");
        imcSyncConfigVo.setAdminDn("CN=sic,OU=special,OU=asiainfo-Users,DC=ais,DC=com");
        imcSyncConfigVo.setPort("389");
//        imcSyncConfigVo.setAdminPwd("Asiainfo@QWE$%^");
        imcSyncConfigVo.setAdminPwd("Asiainfo#!@#)(*");
        imcSyncConfigVo.setUrl("10.21.121.188");
        imcSyncConfigVo.setSourceType(ImcSyncEnum.SyncSourceType.LDAP);
        imcSyncConfigVo.setIsSslConnect(ImcSyncEnum.IsSslConnect.NO);
        InitialDirContext context = getConnection(imcSyncConfigVo);

        String baseDn = "OU=asiainfo-sec,OU=asiainfo-Users,DC=ais,DC=com";
//        testAuth();
//        queryOrgColumns(context,baseDn);
//        queryUserColumns(context,baseDn);

//        queryOrgDataSelf(context,baseDn);
        queryOrgDataByParent(context,baseDn,"asiainfo-sec");

//          queryUserSelf(context,baseDn,"hecj");
//        queryUserDataByOrg(context,baseDn);
//        queryUserDataByOrgOfPage(context,baseDn);
//        testSetData();
    }

    public static void testAuth(){
        ImcSyncConfigVo imcSyncConfigVo = new ImcSyncConfigVo();
        imcSyncConfigVo.setAdminDn("CN=Shaoqing WU,OU=DSG开发部,OU=数据安全开发部,OU=业务与数据安全平台,OU=亚信安全OA,OU=asiainfo-sec,OU=asiainfo-Users,DC=ais,DC=com");
        imcSyncConfigVo.setPort("389");
        imcSyncConfigVo.setAdminPwd("wsq5200$%^");
        imcSyncConfigVo.setUrl("10.21.121.188");
        imcSyncConfigVo.setSourceType(ImcSyncEnum.SyncSourceType.LDAP);
        imcSyncConfigVo.setIsSslConnect(ImcSyncEnum.IsSslConnect.NO);

        System.out.println(getConnection(imcSyncConfigVo));
    }


    public static InitialDirContext getConnection(ImcSyncConfigVo syncConfigVo){
        log.info("LDAP/AD连接信息入参============>{}", JSONObject.toJSONString(syncConfigVo));
        Hashtable<Object, Object> env = new Hashtable<Object, Object>();
        InitialDirContext ctx = null;
        ImcSyncConfigVo imcSyncConfigVo = new ImcSyncConfigVo();
        BeanUtils.copyProperties(syncConfigVo, imcSyncConfigVo);
        if (ImcSyncEnum.SyncSourceType.LDAP.equals(imcSyncConfigVo.getSourceType()) && ImcSyncEnum.IsSslConnect.YES.equals(imcSyncConfigVo.getIsSslConnect())) {
            imcSyncConfigVo.setIsSslConnect(ImcSyncEnum.IsSslConnect.NO);
            if ("636".equals(imcSyncConfigVo.getPort())) {
                imcSyncConfigVo.setPort("389");
            }else if ("389".equals(imcSyncConfigVo.getPort())) {
                imcSyncConfigVo.setPort("636");
            }
        }

        // 设置连接超时时间为5秒
        if (ImcSyncEnum.SyncSourceType.LDAP.equals(imcSyncConfigVo.getSourceType())) {
            env.put("com.sun.jndi.ldap.connect.timeout", "5000");
        }

        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        //验证类型
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        //用户名称，cn,ou,dc 分别：用户，组，域
        env.put(Context.SECURITY_PRINCIPAL, imcSyncConfigVo.getAdminDn());
        //用户密码 cn 的密码
        env.put(Context.SECURITY_CREDENTIALS, imcSyncConfigVo.getAdminPwd());

        //objectGUID 转换，很关键
        env.put("java.naming.ldap.attributes.binary","objectGUID");
        if (imcSyncConfigVo.getSourceType().equals(ImcSyncEnum.SyncSourceType.AD)&& ImcSyncEnum.IsSslConnect.YES.equals(imcSyncConfigVo.getIsSslConnect())) {
            //解决No subject alternative DNS name xxxxx的错误
            Security.setProperty("jdk.tls.disabledAlgorithms", "");
            System.setProperty("com.sun.jndi.ldap.object.disableEndpointIdentification", "true");
            env.put(Context.SECURITY_PROTOCOL, "ssl");
            env.put(Context.PROVIDER_URL, "ldaps://" + imcSyncConfigVo.getUrl() + ":"+imcSyncConfigVo.getPort());
            //绕过证书认证，别忘记输入正确的类路径
            env.put("java.naming.ldap.factory.socket", "study.ldap.util.DummySSLSocketFactory");
        }else  {
            env.put(Context.PROVIDER_URL, "ldap://" + imcSyncConfigVo.getUrl() + ":" + imcSyncConfigVo.getPort());
        }
        try {
            log.info("LDAP/AD连接信息连接中============>{}",JSONObject.toJSONString(env));
            ctx = new InitialDirContext(env);
            System.out.println("认证成功");
        } catch (NamingException e) {
            System.out.println("认证失败");
            e.printStackTrace();
        }
        return ctx;
    }


    public static void queryOrgColumns(InitialDirContext context,String baseDn){
        try {

            String searchFilter = "(objectClass=organizationalUnit)"; // 过滤条件

            // 设置搜索控制项
            SearchControls controls = new SearchControls();
            controls.setSearchScope(SearchControls.SUBTREE_SCOPE);

            // 执行搜索
            NamingEnumeration<SearchResult> results = context.search(baseDn, searchFilter, controls);

            SearchResult result = results.next();
            Attributes attributes = result.getAttributes();
            NamingEnumeration<? extends Attribute> allAttr = attributes.getAll();
            List<String> attrList = new ArrayList<>();
            while(allAttr.hasMore()){
                Attribute attribute = allAttr.next();
                attrList.add(attribute.getID());

//                if ("objectGUID".equals(attribute.getID())) {
//                    String guid = getObjectGUID((byte[]) attribute.getAll().next());
//                    System.out.println(guid);
//                }

//                System.out.println(attribute.getID()+"----"+attribute.get());
            }
            System.out.println(JSON.toJSONString(attrList));
        }catch (NamingException e){
            e.printStackTrace();
        }
    }

    public static void queryUserColumns(InitialDirContext context,String baseDn){
        try {

            String searchFilter = "(objectClass=person)"; // 过滤条件

            // 设置搜索控制项
            SearchControls controls = new SearchControls();
            controls.setSearchScope(SearchControls.SUBTREE_SCOPE);

            // 执行搜索
            NamingEnumeration<SearchResult> results = context.search(baseDn, searchFilter, controls);

            SearchResult result = results.next();
            Attributes attributes = result.getAttributes();
            NamingEnumeration<? extends Attribute> allAttr = attributes.getAll();
            List<String> attrList = new ArrayList<>();
            while(allAttr.hasMore()){
                Attribute attribute = allAttr.next();
                attrList.add(attribute.getID());
//                System.out.println(attribute.getID()+"----"+attribute.get());
            }
            System.out.println(JSON.toJSONString(attrList));
        }catch (NamingException e){
            e.printStackTrace();
        }
    }

    public static void queryOrgDataSelf(InitialDirContext context,String baseDn){
        try {

            String searchFilter = "(objectClass=organizationalUnit)"; // 过滤条件

            // 设置搜索控制项
            SearchControls controls = new SearchControls();
            controls.setSearchScope(SearchControls.OBJECT_SCOPE);

            // 执行搜索
            NamingEnumeration<SearchResult> results = context.search(baseDn, searchFilter, controls);

            // 遍历搜索结果
            while (results.hasMore()) {
                SearchResult result = results.next();
                Attributes attributes = result.getAttributes();
                Attribute attr = attributes.get("ou");
                String thisName = "null";
                if (attr != null && attr.get() != null){
                    thisName = attr.get().toString();
                }
                System.out.println("组织名: "+thisName);
            }

        }catch (NamingException e){
            e.printStackTrace();
        }
    }

    public static void queryOrgDataByParent(InitialDirContext context,String baseDn,String allParent){
        try {

            String searchFilter = "(objectClass=organizationalUnit)"; // 过滤条件

            // 设置搜索控制项
            SearchControls controls = new SearchControls();
            controls.setSearchScope(SearchControls.ONELEVEL_SCOPE);

            // 执行搜索
            NamingEnumeration<SearchResult> results = context.search(baseDn, searchFilter, controls);

            // 遍历搜索结果
            while (results.hasMore()) {
                SearchResult result = results.next();
                Attributes attributes = result.getAttributes();
                Attribute attr = attributes.get("ou");
                String thisName = "null";
                if (attr != null && attr.get() != null){
                    thisName = attr.get().toString();
                }

                Attribute objectGUID = attributes.get("objectGUID");
                String guid = getObjectGUID((byte[]) objectGUID.get());

                System.out.println("组织名: "+ allParent+"---"+thisName+"--"+guid);
//                queryOrgDataByParent(context,result.getNameInNamespace(),allParent+"---"+thisName);
            }

        }catch (NamingException e){
            e.printStackTrace();
        }
    }

    public static void queryUserSelf(InitialDirContext context,String baseDn,String userName){
        try {

            String searchFilter = "(samaccountname="+userName+")"; // 过滤条件

            // 设置搜索控制项
            SearchControls controls = new SearchControls();
            controls.setSearchScope(SearchControls.SUBTREE_SCOPE);

            // 执行搜索
            NamingEnumeration<SearchResult> results = context.search(baseDn, searchFilter, controls);

            SearchResult result = results.next();
            Attributes attributes = result.getAttributes();
            Attribute attr = attributes.get("distinguishedname");
            System.out.println("这个人的DN: "+attr.get());

        }catch (NamingException e){
            e.printStackTrace();
        }
    }

    public static void queryUserDataByOrg(InitialDirContext context,String baseDn){
        try {
            String searchFilter = "(objectClass=person)"; // 过滤条件

            // 设置搜索控制项
            SearchControls controls = new SearchControls();
            controls.setSearchScope(SearchControls.ONELEVEL_SCOPE);

            // 执行搜索
            NamingEnumeration<SearchResult> results = context.search(baseDn, searchFilter, controls);

            // 遍历搜索结果
            while (results.hasMore()) {
                SearchResult result = results.next();
                Attributes attrs = result.getAttributes();
                Attribute givenname = attrs.get("givenname");

                Attribute objectGUID = attrs.get("objectGUID");
                String guid = getObjectGUID((byte[]) objectGUID.get());

                if (givenname != null) {
                    String username = givenname.get() == null ? "" : givenname.get().toString();
                    System.out.println("用户名: " + username +"--"+guid);
                }
            }

        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public static void queryUserDataByOrgOfPage(InitialDirContext context,String baseDn){
        try {
            String searchFilter = "(objectClass=person)"; // 过滤条件

            // 设置搜索控制项
            SearchControls controls = new SearchControls();
            controls.setSearchScope(SearchControls.ONELEVEL_SCOPE);
            // 分页的两个参数
            controls.setCountLimit(3);

            // 执行搜索
            NamingEnumeration<SearchResult> results = context.search(baseDn, searchFilter, controls);

            // 遍历搜索结果
            while (results.hasMore()) {
                SearchResult result = results.next();
                Attributes attrs = result.getAttributes();
                Attribute givenname = attrs.get("givenname");

                Attribute objectGUID = attrs.get("objectGUID");
                String guid = getObjectGUID((byte[]) objectGUID.get());

                if (givenname != null) {
                    String username = givenname.get() == null ? "" : givenname.get().toString();
                    System.out.println("用户名: " + username +"--"+guid);
                }
            }

        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public static Map<String,String> querySysColumn(Class<?> clazz){
        Map<String,String> columnFieldMap = new HashMap<>();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(SysColumn.class)) {
                SysColumn annotation = field.getAnnotation(SysColumn.class);
                String columnName = annotation.columnName();
                columnFieldMap.put(columnName,field.getName());
            }
        }
        System.out.println(JSON.toJSONString(columnFieldMap));
        return columnFieldMap;
    }

    public static void testSetData(){

        Map<String,String> data = new HashMap<>();
        data.put("user_name","zhangsan");
        data.put("mobile","13022221111");

        Map<String, String> columnFieldMap = querySysColumn(TestUser.class);
        TestUser testUser = new TestUser();

        for (Map.Entry<String, String> entry : data.entrySet()) {
            setValue(testUser,columnFieldMap.get(entry.getKey()),entry.getValue());
        }

        System.out.println(JSON.toJSONString(testUser));
    }

    public static void setValue(Object obj, String fieldName, Object value) {
        try {
            Class<?> clazz = obj.getClass();
            Field field = clazz.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(obj, value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * guid转换
     *
     * @return
     * @paramD
     */
    public static String getObjectGUID(byte[] GUID) {
        String strGUID = "";
        String byteGUID = "";
        for (int c = 0; c < GUID.length; c++) {
            byteGUID = byteGUID + "\\" + AddLeadingZero((int) GUID[c] & 0xFF);
        }
        strGUID = strGUID + AddLeadingZero((int) GUID[3] & 0xFF);
        strGUID = strGUID + AddLeadingZero((int) GUID[2] & 0xFF);
        strGUID = strGUID + AddLeadingZero((int) GUID[1] & 0xFF);
        strGUID = strGUID + AddLeadingZero((int) GUID[0] & 0xFF);
        strGUID = strGUID + "-";
        strGUID = strGUID + AddLeadingZero((int) GUID[5] & 0xFF);
        strGUID = strGUID + AddLeadingZero((int) GUID[4] & 0xFF);
        strGUID = strGUID + "-";
        strGUID = strGUID + AddLeadingZero((int) GUID[7] & 0xFF);
        strGUID = strGUID + AddLeadingZero((int) GUID[6] & 0xFF);
        strGUID = strGUID + "-";
        strGUID = strGUID + AddLeadingZero((int) GUID[8] & 0xFF);
        strGUID = strGUID + AddLeadingZero((int) GUID[9] & 0xFF);
        strGUID = strGUID + "-";
        strGUID = strGUID + AddLeadingZero((int) GUID[10] & 0xFF);
        strGUID = strGUID + AddLeadingZero((int) GUID[11] & 0xFF);
        strGUID = strGUID + AddLeadingZero((int) GUID[12] & 0xFF);
        strGUID = strGUID + AddLeadingZero((int) GUID[13] & 0xFF);
        strGUID = strGUID + AddLeadingZero((int) GUID[14] & 0xFF);
        strGUID = strGUID + AddLeadingZero((int) GUID[15] & 0xFF);
        return strGUID;
    }

    private static String AddLeadingZero(int k) {
        return (k <= 0xF) ? "0" + Integer.toHexString(k) : Integer
                .toHexString(k);
    }

}
