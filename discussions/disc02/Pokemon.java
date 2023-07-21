public class Pokemon{
	public String name; 
	public int level;  
	public Pokemon(String name,int level){    // constructor for class pokemon
		this.name=name; 
		this.level=level;
	}
	public static void main(String[] args){
		Pokemon p = new Pokemon("Pikachu",17); 
		int level = 100; 
		change(p,level);
		System.out.println("Name:"+p.name+",Level:"+p.level);
	}
	public static void change(Pokemon poke,int level){
		poke.level=level;    // here we set p's level to 100 in this case 
		level=50;            // here level means the parameter of function "change"
		poke=new Pokemon("Gengar",1);
		System.out.println("Name:"+poke.name+",Level:"+poke.level);
	}
}