package com.example.utils;

import com.example.base.BaseConfig;
import com.example.base.BaseModel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by admin on 2015/6/21.
 */
public class JsonUtils {
    public static String getModelName(String str) {
        String[] strArr = str.split("\\W");
        if (strArr.length > 0) {
            str = strArr[0];
        }
        return ucfirst(str);
    }
     public static String ucfirst (String str) {
        if (str != null && str != "") {
            str  = str.substring(0,1).toUpperCase()+str.substring(1);
        }
        return str;
    }
    @SuppressWarnings("unchecked")
    private static  BaseModel json2model (String modelClassName, JSONObject modelJsonObject) throws Exception  {
        // auto-load model class
        BaseModel modelObj = (BaseModel) Class.forName(modelClassName).newInstance();
        Class<? extends BaseModel> modelClass = modelObj.getClass();
        // auto-setting model fields
        Iterator<String> it = modelJsonObject.keys();
        while (it.hasNext()) {
            String varField = it.next();
         if("latitude".equals(varField)){
                double varValue =  modelJsonObject.getDouble(varField);
                Field field = modelClass.getDeclaredField(varField);
                field.setAccessible(true); // have private to be accessable
                field.set(modelObj, varValue);
            }
            else if("lngtitude".equals(varField)){
                double varValue =  modelJsonObject.getDouble(varField);
                Field field = modelClass.getDeclaredField(varField);
                field.setAccessible(true); // have private to be accessable
                field.set(modelObj, varValue);
            }
            else if("time".equals(varField)){
                double varValue =  modelJsonObject.getDouble(varField);
                Field field = modelClass.getDeclaredField(varField);
                field.setAccessible(true); // have private to be accessable
                field.set(modelObj, varValue);
            }
            else{
                String varValue = modelJsonObject.getString(varField);
                Field field = modelClass.getDeclaredField(varField);
                field.setAccessible(true); // have private to be accessable
                field.set(modelObj, varValue);
            }

        }
        return modelObj;
    }
    public static  List<BaseModel> parseResult (String result) throws Exception {

        if (result.length() > 0) {
            JSONObject jsonObject = null;
            jsonObject = new JSONObject(result);
            Iterator<String> it = jsonObject.keys();
            ArrayList<BaseModel> modelList = new ArrayList<BaseModel>();
            while (it.hasNext()) {
                // initialize
                String jsonKey = it.next();
                String modelName = getModelName(jsonKey);
                String modelClassName = BaseConfig.MODEL_PARKET_NAME + modelName;
                JSONArray modelJsonArray = jsonObject.optJSONArray(jsonKey);
                // JSONObject
                if (modelJsonArray == null) {
                    JSONObject modelJsonObject = jsonObject.optJSONObject(jsonKey);
                    if (modelJsonObject == null) {
                        throw new Exception("Message result is invalid");
                    }
                    modelList.add(json2model(modelClassName, modelJsonObject));


                } else {
                    for (int i = 0; i < modelJsonArray.length(); i++) {
                        JSONObject modelJsonObject = modelJsonArray.optJSONObject(i);
                        modelList.add(json2model(modelClassName, modelJsonObject));
                    }

                }
                return modelList;
            }
        }
            return null;
    }
    public static List<String> getResult(JSONObject response) {
        List<String> list = new ArrayList<>();
        try {
            JSONObject firstEvent = new JSONObject(response.getString("result"));
            Iterator<String> it = firstEvent.keys();
            while (it.hasNext()) {
                // initialize
                String jsonKey = it.next();
                JSONArray modelJsonArray = firstEvent.optJSONArray(jsonKey);
                String modelName = JsonUtils.getModelName(jsonKey);
                // JSONObject
                if (modelJsonArray == null) {
                    JSONObject modelJsonObject = firstEvent.optJSONObject(jsonKey);
                    list.add(modelJsonObject.toString());
                    if (modelJsonObject == null) {
                        throw new Exception("Message result is invalid");
                    }
                    // JSONArray
                } else {
                    for (int i = 0; i < modelJsonArray.length(); i++) {
                        JSONObject modelJsonObject = modelJsonArray.optJSONObject(i);
                        list.add(modelJsonObject.toString());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if(list.isEmpty()){
                return null;
            }else{
                return  list;
            }
        }
    }


}
