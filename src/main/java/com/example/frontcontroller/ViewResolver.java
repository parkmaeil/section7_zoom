package com.example.frontcontroller;

public class ViewResolver {
     private static final String VIEWS_DIRECTORY="/WEB-INF/views/";
    private static final String VIEWS_EXTENSION=".jsp";

    public static String makeView(String viewName){
        if(viewName == null || viewName.trim().isEmpty()){
            throw new IllegalArgumentException("잘못된 뷰의 이름입니다.");
        }
        return VIEWS_DIRECTORY+viewName+VIEWS_EXTENSION;
    }
}
