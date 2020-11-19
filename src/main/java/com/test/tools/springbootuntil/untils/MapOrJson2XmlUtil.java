package com.test.tools.springbootuntil.untils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import sun.applet.Main;

import java.util.*;


/**
 * @Description: 将map转化为json
 * * @Author: gwj
 * @CreateDate: 2020/11/5 9:51
 * @UpdateUser: gwj
 * @UpdateDate: 2020/11/5 9:51
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
@Component
public class MapOrJson2XmlUtil {
    /**
     * 方法描述
     *
     * @return
     * @author gwj
     * @date 2020/11/5
     */
    public static String Map2Xml(Object get, StringBuffer str) {
        //定义公共变量
        JSONObject item = null;
        //判断是map还是JSONObject是JSONObject就直接传递到下边参数，如果是map就进行转化
        if (get instanceof JSONObject) {
            item = (JSONObject) get;
        } else if (get instanceof HashMap) {
            String json = JSON.toJSONString(get, SerializerFeature.WriteMapNullValue);
            item = JSON.parseObject(json);
        }
        //map迭代
        //两种方法：entryset/keyset
        Set set = item.keySet();
        for (Iterator iterator = set.iterator(); iterator.hasNext(); ) {
            //获取key
            String key = (String) iterator.next();
            //获取key对应的value值
            Object value = item.get(key);
            //判断value
            if (null == value) {
                //如果为空设置默认值为空
                value = "";
            }
            //判断是都为JSONObject
            if (value.getClass().getName().equals("com.alibaba.fastjson.JSONObject")) {
                str.append('<' + key + '>');
                Map2Xml(value, str);
                str.append("</" + key + ">");
            }//判断value值的类型:1.列表(jsonArray ArrayList)，2.map
            else if (value.getClass().getName().equals("com.alibaba.fastjson.JSONArray")) {
                //如果是列表类型（list<map>），则需要对value遍历
                List<Map> list = JSON.parseArray(JSONObject.toJSONString(value), Map.class);
                //拼接
                str.append('<' + key + '>');
                //对list进行遍历
                for (int i = 0; i < list.size(); i++) {
                    //获取
                    JSONObject ChilMap = (JSONObject) list.get(i);
                    //递归调用
                    Map2Xml(ChilMap, str);
                }
                str.append("</" + key + ">");
            } else {
                //判断是否为map
                if (value instanceof HashMap) {
                    str.append("<" + key + ">");
                    Map2Xml(value, str);
                    str.append("</" + key + ">");
                } else if (value.getClass().getName().equals("java.lang.String")) {
                    str.append("<" + key + ">" + value + "</" + key + ">");
                }
            }

        }
        return str.toString();

    }

    //@Bean
    public static void testmap2xml() {
//        String str = "{\"InstrRen\":{\"OperationType\":\"36\",\"RenContent\":{\"StatusDec\":\"账户编号不能为空\",\"StatusNo\":\"02\"}}}";
////JSON.parse(str)
//        JSONObject parse = JSON.parseObject(str);
        StringBuffer s = new StringBuffer();
//
//        //测试json类型
//        String s1 = Map2Xml(parse, s);
//        System.out.println(s1);
//        //
//
//        //测试map类型
//        //最内层
//        HashMap<Object, Object> inner2 = new HashMap<>();
//        inner2.put("a2", "11");
//        inner2.put("b2", "22");
//        inner2.put("c2", "33");
//        inner2.put("d2", "44");
//        //内层
//        HashMap<Object, Object> inner = new HashMap<>();
//        inner.put("a", "1");
//        inner.put("b", "2");
//        inner.put("c", "3");
//        inner.put("d", "4");
//        inner.put("e", inner2);
//        //--外层
//        HashMap<String, Object> outer = new HashMap<>();
//        outer.put("outer", inner);
        //String s2 = Map2Xml(outer, s);
        //System.out.println(s2);
        HashMap<String,Object> map1=new HashMap<>();
        HashMap<String,Object> map2=new HashMap<>();
        HashMap<String,Object> map3=new HashMap<>();
        HashMap<String,Object> map4=new HashMap<>();
        HashMap<String,Object> map5=new HashMap<>();
        HashMap<String,Object> map6=new HashMap<>();
        HashMap<String,Object> map7=new HashMap<>();
        HashMap<String,Object> map8=new HashMap<>();
        //最外层
        map1.put("datatonc",map2);
        //内1
        map2.put("nccontext", map3);
//			map3存放nccontext中的内容
        //内2
        map2.put("billinfos", map4);//map2可能是个列表
        map4.put("billinfo", map5);
        map4.put("billinfo", map5);
        map5.put("head", map7);
        //map7存放head中的内容
        map5.put("items", map6);//items可能是个列表
        map6.put("item", map8);
        map6.put("item", map8);

        //map8存放item中的内容
        String s1 = Map2Xml(map1, s);
        System.out.println(s1);


    }

    public static void main(String[] args) {
        testmap2xml();
    }
}

