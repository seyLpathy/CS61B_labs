package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        // TODO: YOUR CODE HERE
        AList <Integer> column1 = new AList<>();
        AList<Double> column2 = new AList<>();
        AList<Integer> column3 = new AList<>();
        int [] numbers ={1000000,2000000,4000000,8000000,16000000,32000000,64000000,128000000};
        for(int i =0;i<numbers.length;i++){
            AList <Integer> test = new AList<>();
            column1.addLast(numbers[i]);
            column3.addLast(numbers[i]);
            Stopwatch s = new Stopwatch();
            while (test.size()<numbers[i]){
                test.addLast(8);
            }
            double timeInSeconds = s.elapsedTime();
            column2.addLast(timeInSeconds);
        }
        printTimingTable(column1,column2,column3);
    }

}
