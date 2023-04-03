package com.example.Cucumber;

public class Evenoddgame {
    public String play(int number) throws IllegalAccessException {
        if(number<0) throw new IllegalAccessException("it cannot be less than zero");
        if(number%2==1) return "odd number";
        if(number%2==0) return "even number";

        return String.valueOf(number);

    }
}
