package opis.bayes;

import java.util.ArrayList;
import opis.Iris;

public class StatCalculator {
    public static Iris mean(ArrayList<Iris> data){
        Iris miris=new Iris(0,0,0,0,"mean");
        for(Iris item:data){
            miris.petal_length=miris.petal_length+item.petal_length;
            miris.petal_width=miris.petal_length+item.petal_width;
            miris.sepal_length=miris.petal_length+item.sepal_length;
            miris.sepal_width=miris.petal_length+item.sepal_width;
        }
        miris.petal_length=miris.petal_length/data.size();
        miris.petal_width=miris.petal_width/data.size();
        miris.sepal_width=miris.sepal_width/data.size();
        miris.sepal_length=miris.sepal_length/data.size();
        return miris;
    }
    public static Iris standartDeviation(ArrayList<Iris> data) {
            Iris miris=mean(data);
            Iris sviris=new Iris(0,0,0,0,"sampleVariance");
            for(Iris item: data){
                sviris.petal_width+=Math.pow(item.petal_width-miris.petal_width,2);
                sviris.petal_length+=Math.pow(item.petal_length-miris.petal_length,2);
                sviris.sepal_width+=Math.pow(item.sepal_width-miris.sepal_width,2);
                sviris.sepal_length+=Math.pow(item.sepal_length-miris.sepal_length,2);
            }
                sviris.petal_length= Math.pow(sviris.petal_length/data.size(),0.5);
                sviris.petal_width= Math.pow(sviris.petal_width/data.size(),0.5);
                sviris.sepal_width= Math.pow(sviris.sepal_width/ data.size(),0.5);
                sviris.sepal_length= Math.pow(sviris.sepal_length/data.size(),0.5);

            return sviris;
        }
    }
