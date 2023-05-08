package com.example.testgithublib;

import android.util.Log;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @ClassName javaBaseTest
 * @Description 这个是Java基础的练习以及复习
 * @Author YS
 * @Date 2023/4/23 7:39
 */
public class javaBaseTest {
    private static final String TAG = javaBaseTest.class.getSimpleName();

    //练习map相关操作
    public void testMap() {
        HashMap<String, String> map = new HashMap<>();
        map.put("1", "1value");
        map.put("2", "1value");
        map.put("3", "1value");
        map.put("4", "1value");
        //遍历
        for (String key :
                map.keySet()) {
            Log.e(TAG, "testMap:forEach遍历 key"+key+" value" + map.get(key));
        }
        //使用迭代器遍历
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> next = iterator.next();
            Log.e(TAG, "testMap:iterator key"+next.getKey()+" value" + next.getValue());
        }
        //map容量大的时候 推荐使用

    }
}
