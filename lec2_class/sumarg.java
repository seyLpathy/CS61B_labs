public class sumarg{
	public static void main(String[] args){
		int answer = 0;
		for (int i = 0; i<args.length;i++){
			answer += toint(args[i]);
		}
		System.out.println("the sum of the args above is "+ answer);
	}
}