public class sum{
	/*** sum all the arguments in command line */
	public static void main(String[] args){
		int sums = 0;
		for (int i = 0;i< args.length;i++){
			sums += Integer.parseInt(args[i]);   //integer.parseint can change string to int 
		}
		System.out.println("the sums of  arguments: "+sums);

	}
}