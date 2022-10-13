package opis;

import opis.bayes.Bayes;
import opis.neighbors.kNN;

import java.util.*;

public class Main {
    public static void main(String[] args){
        ArrayList<Iris> data;
        data= Utils.getDataset("E:\\erlkonig\\BayesIrises\\src\\iris.data");
        ArrayList<Iris> temp0=new ArrayList<Iris>();
        ArrayList<Iris> temp1=new ArrayList<Iris>();
        ArrayList<Iris> temp2=new ArrayList<Iris>();

        for (int i=0;i<150;i++){
            if(i<50){
                temp0.add(data.get(i));
            } else if (i<100) {
                temp1.add(data.get(i));
            } else {
                temp2.add(data.get(i));
            }
        }
//        4.4,2.9,1.4,0.2,Iris-setosa
        //6.2,2.8,4.8,1.8,Iris-virginica - negative
//        7.7,3.0,6.1,2.3,Iris-virginica -positive
        Iris interest=new Iris(7.7,3.0,6.1,2.3,"unknown");

        System.out.println(kNN.calculateDistance(temp0.get(0),interest));

        System.out.println(temp0.get(0).name);
        Map<Double,String> dataset=new TreeMap<>();
        for(Iris t:temp0){
            dataset.put(kNN.calculateDistance(t,interest),t.name);
        }
        System.out.println(temp1.get(0).name);
        for(Iris t:temp1){
            dataset.put(kNN.calculateDistance(t,interest),t.name);
        }
        System.out.println(temp2.get(0).name);
        for(Iris t:temp2){
            dataset.put(kNN.calculateDistance(t,interest),t.name);
        }
        Set<Double> keys=dataset.keySet();
        int it1=0,it2=0,it3=0,kNN=0;
        for(double k:keys){
            if(kNN<3){
                if (dataset.get(k).equals(temp0.get(0).name)) {
                    it1++;
                }
                if (dataset.get(k).equals(temp1.get(0).name)) {
                    it2++;
                }
                if (dataset.get(k).equals(temp2.get(0).name)) {
                    it3++;
                }
                kNN++;
            }
            System.out.println(k+"  " +dataset.get(k));
        }
        System.out.println("------result------");
        if(it1>it2&&it1>it3){System.out.println("It's "+temp0.get(0).name);}
        else if(it2>it1&&it2>it3){System.out.println("It's "+temp1.get(0).name);}
        else {System.out.println("It's "+temp2.get(0).name);}

    }
}
