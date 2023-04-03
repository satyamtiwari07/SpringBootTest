package com.example.Cucumber_Prime;

public class Driver {

    public String check(int num) {
        if(num < 2) return "Newbie";
        if(num < 6) return "Expert";
        return "Master";
    }

    public void checkNull(String name) throws Exception {

        if(name.length()==0)
            throw new Exception("Name is NULL");
    }

    public void checkDesc(String desc) throws Exception {
        if(desc.length()==0)
            throw new Exception("Desc is NULL");
    }
}
