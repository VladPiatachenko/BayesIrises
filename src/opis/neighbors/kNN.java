package opis.neighbors;

import opis.Iris;

import java.util.List;

public class kNN {
    public static double calculateDistance(Iris a, Iris b){
     return Math.pow((Math.pow((a.petal_width-b.petal_width),2)
                      +Math.pow((a.petal_length-b.petal_length),2)
                        +Math.pow((a.sepal_width-b.sepal_width),2)
                            +Math.pow((a.sepal_length-b.sepal_width),2)),0.5);
    }
    public int calculateClosest(List<Iris> irises,Iris x,int k){
        int dist=0;

        for(Iris i:irises){
            if(k>calculateDistance(i,x)){
                dist++;
            }
        }
        return dist;
    }
}
