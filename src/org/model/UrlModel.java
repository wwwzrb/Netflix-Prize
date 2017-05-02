package org.model;

/**
 * Created by 王哲 on 2017/4/13.
 */
public class UrlModel {
    private static String url="http://www.omdbapi.com/?";
    private String t;
    private String y;
    private static String plot="full";

    public String getT() {
        return t;
    }

    public void setT(String t) {
        StringBuffer title=new StringBuffer();
        String[] str=null;
        String[] strArray=null;
        str=t.split(":");
        strArray=str[0].split(" ");
        for(int i=0;i<strArray.length;i++){
            if(i==0)
                title.append(strArray[i]);
            else{
                title.append("+");
                title.append(strArray[i]);
            }
        }
        this.t = title.toString();
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    @Override
    public String toString(){
        return url+"t="+t+"&y="+y+"&plot=full";
    }
}
