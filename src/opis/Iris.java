package opis;

import java.util.TreeMap;

public class Iris {
   public TreeMap<String,Double> params;
   public String name;
   public int target;//for svm

   public Iris(double sepal_length, double sepal_width, double petal_length, double petal_width, String name) {
      params = new TreeMap<>();
      params.put("Sepal Length",sepal_length);
      params.put("Sepal Width",sepal_width);
      params.put("Petal Length",petal_length);
      params.put("Petal Width",petal_width);
      this.name=name;
   }
   @Override
   public String toString(){
      return "Iris:"+name+"; sepal length="+params.get("Sepal Length")+
              "; sepal width="+params.get("Sepal Width")+"; petal length="+params.get("Petal Length")+
              "; petal width="+params.get("Petal Width");
   }
}
