public class Iris {
   double sepal_length;//cm
   double sepal_width;// cm
   double petal_length;// cm
   double petal_width;// cm
   String name;

   public Iris(double sepal_length, double sepal_width, double petal_length, double petal_width, String name) {
      this.sepal_length = sepal_length;
      this.sepal_width = sepal_width;
      this.petal_length = petal_length;
      this.petal_width = petal_width;
      this.name=name;
   }
   @Override
   public String toString(){
      return "Iris:"+name+"; sepal length="+sepal_length+
              "; sepal width="+sepal_width+"; petal length="+petal_length+
              "; petal width="+petal_width;
   }
}
