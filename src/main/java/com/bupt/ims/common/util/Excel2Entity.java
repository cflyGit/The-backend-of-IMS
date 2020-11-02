package com.bupt.ims.common.util;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;

public class Excel2Entity<T> {
    private ParseExcelFile pef;
    private Class<?> clazz;

    public Excel2Entity(String file, String entity) {
        this.pef = new ParseExcelFile(file);
        try {
            this.clazz  = Class.forName(entity);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<T> transfer() {
        ArrayList<T> list = new ArrayList<>();
        while (pef.hasNext()) {
            JSONObject json = pef.next();
            T t = (T)JSONObject.parseObject(String.valueOf(json), this.clazz);
            list.add(t);
        }
        return list;
    }
}
