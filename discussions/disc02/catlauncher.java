public class catlauncher{

//java allows you do access to static variables through a instance name,which is highly unrecommended
	public static void main(String[] args){
		Cat a = new Cat("Cream","Meow!");
		Cat b = new Cat("Tubbs","Nyan!");   // here class Cat.noise becomes Nyan
		a.play();      
		b.play();    // so both cat a/b both noise set as Nyan 
		Cat.anger(); // access to static method correctly
		a.calm();    // access static variable through a instance name
		a.play(); 
		b.play();
}
}