import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        ArrayList<Iris> data;
        data=Utils.getDataset("E:\\erlkonig\\BayesDemo\\src\\iris.data");
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

        System.out.println(temp0.get(0).name);
        System.out.println(StatCalculator.mean(temp0).toString());
        //System.out.println(StatCalculator.standartDeviation(temp0).toString());

        System.out.println(temp1.get(0).name);
        System.out.println(StatCalculator.mean(temp1).toString());
        //System.out.println(StatCalculator.standartDeviation(temp1).toString());

        System.out.println(temp2.get(0).name);
        System.out.println(StatCalculator.mean(temp2).toString());
        //System.out.println(StatCalculator.standartDeviation(temp2).toString());

        Iris interest=new Iris(5.9,3.0,5.1,1.8,"unknown");//Iris-virginica

        double[] tempres=new double[3];
        tempres[0]=Bayes.probability(interest,temp0);
        tempres[1]=Bayes.probability(interest,temp1);
        tempres[2]=Bayes.probability(interest,temp2);

        double max=-1;
        for(int i=0;i<3;i++){
            if (max<=tempres[i]){
                max=tempres[i];
                interest.name=data.get(i*50).name;
            }
        }
        System.out.println("Suppose type is "+interest.name);
    }
}
