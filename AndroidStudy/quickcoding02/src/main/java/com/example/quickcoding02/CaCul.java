package com.example.quickcoding02;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iny00 on 2016-09-30.
 */
public class CaCul implements GetResult{

    public List<Integer> getArr(String numbers){
        String []arr = numbers.split(", ");
        List<Integer> ar = new ArrayList<Integer>();
        for(int i=0;i<arr.length;i++){
            try{
                ar.add( Integer.parseInt(arr[i]));
            }catch (NumberFormatException e){
                System.out.println("not number");
                continue;
            }
        }
        return ar;
    }
    public String minimum(String numbers){
        List<Integer> arr=getArr(numbers);
        int min=arr.get(0);
        for(int i=1;i<arr.size();i++) {
            if(arr.get(i)<min){
                min=arr.get(i);
            }
        }
        return String.valueOf(min);
    }
    public String average(String numbers){
        int sum=0;
        int aver;
        List<Integer> arr=getArr(numbers);
        for(int i=0;i<arr.size();i++){
            sum+=arr.get(i);
        }
        aver=sum/(arr.size());
        return String.valueOf(aver);
    }
    public String maximum(String numbers){
        List<Integer> arr=getArr(numbers);
        int max=arr.get(0);
        for(int i=1;i<arr.size();i++) {
            if(arr.get(i)>max){
                max=arr.get(i);
            }
        }
        return String.valueOf(max);
    }

}
