/** need further extension 
String List L=new String List("eat",null);
L = new String List("shouldn't",L); 
L = new String List("you",L); 
L = new String List("sometimes",L); 
String List M = L.rest; 
String List R = new String List("many",null); 
R = newStringList("potatoes",R); 
R.rest.rest=R; 
M.rest.rest.rest=R.rest; 
L.rest.rest=L.rest.rest.rest;
L=M.rest;                                                   
*/