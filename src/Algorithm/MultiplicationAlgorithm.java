package Algorithm;


/*
 * Please review Lecture 5 Algorithms Part I, slide 49 to complete this task.
 * */

public class MultiplicationAlgorithm {

    /**
     * Using divide-and-conquer to implement the Karatsuba multiplication to compute the product x times y. 
	 * x and y are two n-digit input numbers.
     *

     */
    public static long KMultiply(long x, long y){
        // TODO: Complete this method
//        tracker.calltracking(x,y); //Do not modify this method. Otherwise, you will be penalized for violation.
        // START YOUR CODE
        int n_of_x=MultiplicationAlgorithm.calculate_n_of_long(x);
        int n_of_y=MultiplicationAlgorithm.calculate_n_of_long(y);
        int n_of_x1=n_of_x;
        if (n_of_x1 %2!= 0)
            n_of_x1=n_of_x1-1;
        if (n_of_x==1)
            return x*y;
        if (n_of_x==2&&n_of_y==1)
            return x*y;
        long a=MultiplicationAlgorithm.find_a(x);
        long b=MultiplicationAlgorithm.find_b(x);
        long c=MultiplicationAlgorithm.find_a(y);
        long d=MultiplicationAlgorithm.find_b(y);
        return (long) (KMultiply(a,c)*Math.pow(10,n_of_x1)+(KMultiply(a,d)+KMultiply(c,b))*Math.pow(10,n_of_x1/2)+
                KMultiply(b,d));
        // END YOUR CODE
    }
    public static int calculate_n_of_long(long num){
        int count=1;
        while (num/10>=1){
            num=num/10;
            count=count+1;
        }
        return count;
    }
    public static long find_a(long num){
        String beforecut;
        String wholewithoudecimal=Long.toString(num);
        if (wholewithoudecimal.length()%2!=0)
            beforecut=wholewithoudecimal.substring(0,(wholewithoudecimal.length()/2)+1);
        else beforecut=wholewithoudecimal.substring(0,wholewithoudecimal.length()/2);
        return Integer.parseInt(beforecut);
    }
    public static long find_b(long num){
        String aftercut="";
        String wholewithoudecimal=Long.toString(num);
        if (wholewithoudecimal.length()%2!=0)
            aftercut=wholewithoudecimal.substring((wholewithoudecimal.length())/2+1);
        else aftercut=wholewithoudecimal.substring((wholewithoudecimal.length())/2);
        return Integer.parseInt(aftercut);

    }

}
