package com.tracker.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class psedoCode {
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,343,3354,343452,5345363,45435435));
        int maxNumber = 0;
        for(int i=0; i<a.size(); i++){
            if(a.get(i)>maxNumber){
                maxNumber=a.get(i);
            }

        }
        System.out.println(maxNumber);
    }
}
