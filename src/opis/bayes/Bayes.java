package opis.bayes;

import opis.Iris;

import java.util.ArrayList;

public class Bayes {

    public static double probability(Iris x, ArrayList<Iris> data){
        Iris probs= StatCalculator.standartDeviation(data);
        Iris mprob= StatCalculator.mean(data);

        double[] prob=new double[5];
        prob[0]=(1/(Math.pow(2*Math.PI,0.5)*probs.petal_width))*
                Math.exp(-Math.pow(x.petal_width - mprob.petal_width,2)
                        /(2*Math.pow(probs.petal_width,2)));
        prob[1]=(1/(Math.pow(2*Math.PI,0.5)*probs.petal_length))*
                Math.exp(-Math.pow(x.petal_length - mprob.petal_length,2)
                        /(2*Math.pow(probs.petal_length,2)));
        prob[2]=(1/(Math.pow(2*Math.PI,0.5)*probs.sepal_width))*
                Math.exp(-Math.pow(x.sepal_width - mprob.sepal_width,2)
                        /(2*Math.pow(probs.sepal_width,2)));
        prob[3]=(1/(Math.pow(2*Math.PI,0.5)*probs.sepal_length))*
                Math.exp(-Math.pow(x.sepal_length - mprob.sepal_length,2)
                        /(2*Math.pow(probs.sepal_length,2)));

        prob[4]=prob[0]*prob[1]*prob[2]*prob[3];
        System.out.println("Probability("+x.name+"|"+data.get(0).name+")="+prob[4]);
        return prob[4];
    }
}
