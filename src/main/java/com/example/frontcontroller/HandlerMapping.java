package com.example.frontcontroller;

import com.example.controller.Controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

public class HandlerMapping {
    // Key-Value
    private HashMap<String, Controller> mappings;

    public HandlerMapping(){
         mappings=new HashMap<>();
         try{
             loadMappingFromExternalSource();
         }catch (Exception e){
             e.printStackTrace();
         }
    }
    private void loadMappingFromExternalSource() throws Exception{
        InputStream inputStream=getClass().getClassLoader().getResourceAsStream("mappingConfig.properties");
        if(inputStream==null){
             throw new IOException("mappingConfig.properties 파일이 없습니다.");
        }
        Properties properties=new Properties();
        properties.load(inputStream);

        for(String key : properties.stringPropertyNames()){
              String className=properties.getProperty(key);
              Class<?> clazz=Class.forName(className);
              Controller controller= (Controller) clazz.getDeclaredConstructor().newInstance();  // new com.example.controller.BookListController()
              mappings.put(key, controller);
        }
        inputStream.close();
    }

    public Controller getController(String key){ // /list.do
        return mappings.get(key);  // new com.example.controller.BookListController()
    }
}
