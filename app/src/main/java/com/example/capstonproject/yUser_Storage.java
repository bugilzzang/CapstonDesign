package com.example.capstonproject;

public class yUser_Storage {
    String id, pw, name, prefer_exercise;

    protected yUser_Storage(String id,String pw,String prefer_exercise, String name){
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.prefer_exercise = prefer_exercise;
    }

    protected String getId(){
        return id;
    }

    protected String getName(){
        return name;
    }

    protected String setPw(String pw, String pw_new){
        if(this.pw.equals(pw)){
            //서버 DB와 연결할 코드 자리
            this.pw = pw_new;
            return "비밀번호 변경 성공";
        }else{
            return "비밀번호 변경 실패";
        }
    }
    
    
}
