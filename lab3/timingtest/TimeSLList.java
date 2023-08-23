package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
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
        timeGetLast();
    }

    public static void timeGetLast() {
        // TODO: YOUR CODE HERE
        AList <Integer> column1 = new AList<>();
        AList<Double> column2 = new AList<>();
        AList<Integer> column3 = new AList<>();
        int [] numbers ={1000,2000,4000,8000,16000,32000,64000,128000};
        for(int i =0;i<numbers.length;i++){
            int get_times =10000;
            SLList <Integer> test = new SLList<>();
            column1.addLast(numbers[i]);
            column3.addLast(get_times);
            while (test.size()<numbers[i]){
                test.addLast(8);
            }
            Stopwatch s = new Stopwatch();
            for (int j=0;j<get_times;j++){
                test.getLast();
            }
            double timeInSeconds = s.elapsedTime();
            column2.addLast(timeInSeconds);
        }
        printTimingTable(column1,column2,column3);
    }

}
