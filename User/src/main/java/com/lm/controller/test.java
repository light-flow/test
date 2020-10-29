package com.lm.controller;

/**
 * @author 流明
 */
public class test {
    public String decodeAtIndex(String S, int K) {
        long size =0;
        int n =S.length();
        for(char c: S.toCharArray()){
            if(!Character.isLetter(c)){
                size*=Integer.parseInt(Character.toString(c));
            }else{
                size++;
            }
        }
        for(int i = n-1;i>=0;i--){
            K = (int)(K%size);
            if(Character.isLetter(S.charAt(n)) && K==0){
                return Character.toString(S.charAt(n));
            }else if(Character.isDigit(S.charAt(n))){
                size = size/Integer.parseInt(Character.toString(S.charAt(n)));
            }else if(Character.isLetter(S.charAt(n)) && K!=0){
                size--;
            }
        }
        return "";
    }

    public static void main(String[] args) {
        test t = new test();
        System.out.println(t.decodeAtIndex("leet2code3",10));
    }
}
