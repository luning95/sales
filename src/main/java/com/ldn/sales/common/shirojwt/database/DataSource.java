package com.ldn.sales.common.shirojwt.database;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class DataSource {

    private static Map<String, Map<String, String>> data = new ConcurrentHashMap<String, Map<String, String>>();

    static {
        Map<String, String> data1 = new ConcurrentHashMap<String, String>();
        data1.put("password", "smith123");
        data1.put("role", "user");
        data1.put("permission", "view");
        data1.put("ban", "0");//--封号状态

        Map<String, String> data2 = new ConcurrentHashMap<String, String>();
        data2.put("password", "danny123");
        data2.put("role", "admin");
        data2.put("permission", "view,edit");
        data2.put("ban", "0");//--封号状态
        data.put("smith", data1);
        data.put("danny", data2);
    }

    public static Map<String, Map<String, String>> getData() {
        return data;
    }
}
