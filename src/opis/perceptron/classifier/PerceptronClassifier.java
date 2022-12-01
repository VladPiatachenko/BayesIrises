package opis.perceptron.classifier;

import opis.Iris;
import opis.Utils;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class PerceptronClassifier {
        static int MAX_ITER = 100;
        static double LEARNING_RATE = 0.1;
        static int NUM_INST = 100;
        static int theta = 0;

    public static void main(String[] args){
        double[] sep_l = new double [NUM_INST];
        double[] sep_w= new double [NUM_INST];
        double[] pet_l = new double [NUM_INST];
        double[] pet_w = new double [NUM_INST];
        int[] outputs = new int [NUM_INST];
        // fiftsep_w random points of class 1
        ArrayList<Iris> data= Utils.getDataset("E:\\erlkonig\\BayesIrises\\src\\iris.data");

        for (int i=0;i<50;i++){
                Iris ir=data.get(i);
                sep_l[i]=data.get(i).params.get("Sepal Length");
                sep_w[i]=data.get(i).params.get("Sepal Width");
                pet_l[i]=data.get(i).params.get("Petal Length");
                pet_w[i]=data.get(i).params.get("Petal Width");
                outputs[i]= 1;

            System.out.println(sep_l[i]+"\t"+sep_w[i]+"\t"+pet_l[i]+"\t"+outputs[i]);

        }
        for (int i=50;i<100;i++){
            Iris ir=data.get(i);
            sep_l[i]=data.get(i).params.get("Sepal Length");
            sep_w[i]=data.get(i).params.get("Sepal Width");
            pet_l[i]=data.get(i).params.get("Petal Length");
            pet_w[i]=data.get(i).params.get("Petal Width");
            outputs[i]= 0;
            System.out.println(sep_l[i]+"\t"+sep_w[i]+"\t"+pet_l[i]+"\t"+outputs[i]);
        }

        double[]weights = new double[5];// 4 for input
        double localError, globalError;
        int i, p, iteration, output;
        weights[0] = randomNumber(0,1);// w1
        weights[1] = randomNumber(0,1);// w2
        weights[2] = randomNumber(0,1);// W3
        weights[3] = randomNumber(0,1);// W4
        weights[4] = randomNumber(0,1);// this is the bias
        iteration = 0;
        do {
        iteration++;
        globalError=0;
    // loop through all instances (complete one epoch)
            for (p = 0; p < NUM_INST; p ++) {
    // calculate predicted class
                output = calculateOutput(theta,weights, sep_l[p], sep_w[p], pet_l[p],pet_w[p]);
    // difference between predicted and actual class values
                localError= outputs[p] -output;
    // update weights and bias
                weights[0] += LEARNING_RATE * localError * sep_l[p];
                weights[1] += LEARNING_RATE * localError * sep_w[p];
                weights[2] += LEARNING_RATE * localError * pet_l[p];
                weights[3] += LEARNING_RATE * localError * pet_w[p];
                weights[4] += LEARNING_RATE * localError;
    // summation of squared error (error value for all instances)
                globalError += (localError*localError);
            }
        /* Root Mean Squared Error */
        System.out.println("Iteration "+iteration+" : RMSE = "+Math.sqrt(globalError/ NUM_INST));
    } while (globalError != 0 && iteration<=MAX_ITER);

    System.out.println("\n =======\nDecision boundary equation:");
    System.out.println(weights[0] +"*sep_l + "+weights[1]+"*sep_w + "+weights[2]+"*pet_l + "+weights[3]+"*pet_w + "+weights[4]+" = 0");

        for(int j= 0; j < 10; j++){
            double sep_l1 = randomNumber(4, 7);
            double sep_w1 = randomNumber(2 , 5);
            double pet_l1 = randomNumber(1 , 5);
            double pet_w1 = randomNumber(0 , 2);
            output = calculateOutput(theta,weights, sep_l1, sep_w1, pet_l1,pet_w1);
            System.out.println("\n =======\nNew Random Iris:");
            System.out.println("sep_l = "+sep_l1+",sep_w = "+sep_w1+ ",pet_l = "+pet_l1+",pet_w = "+pet_w1);
            System.out.println("class = "+output);
        }
    }
    /** returns a random double value within a given range
* @param min the minimum value of the required range (int)
* @param masep_l the masep_limum value of the required range (int)
* @return a random double value between min and masep_l
* */
    public static double randomNumber(int min , int masep_l) {
        DecimalFormat df = new DecimalFormat("#,###");
        double d = min + Math.random() * (masep_l - min);
        String s = df.format(d);
        double sep_l = Double.parseDouble(s);
        return sep_l;
    }
/**
 * returns either 1 or 0 using a threshold function
 * theta is orange
 * @param theta an integer value for the threshold
 * @param weights [] the arrasep_w of weights
 * @param sep_l the sep_l input value
 * @param sep_w the sep_w input value
 * @param pet_l the pet_l input value
 * @return 1 or 0*
 * */
    static int calculateOutput(int theta, double weights[], double sep_l, double sep_w, double pet_l,double pet_w){
    double sum = sep_l * weights[0] + sep_w * weights[1] + pet_l * weights[2]+ pet_w * weights[3] + weights[4];
    return (sum >= theta) ? 1 : 0;
    }
}