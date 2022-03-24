/*
1.) Char array/arrayList : 
char[] arr = {'a','b','c'};

2.) String class -> immutable -> thus automatically thread safe

String st = "geeks";
String st = new String("geeks");

3.) StringBuffer -> mutable ; thread safe/in multi threaded envir.
4.) StringBuilder -> mutable ; thread-safe   used within a single thread 
*/


/*
==              //compares refernce variable (i.e. address and data)  {ACCOR TO SIR: not data}
equals          //compares only data (but case sensitive)
equalsIgnoreTo  //compares only data (but NOT case sensitive)
compareTo       //similar to equals, but returns int { if 0 then Strings are equal}
compareIgnoreTo //similar to equals, but returns int(but NOT case sensitive) { if 0 then Strings are equal}
*/

/*
String s1 = "hey";
String s2 = "hey";
String s3 = new String("hey");
string s4 = new String("hey");
// == -> Compare references 
s1 == s2 -> true;
s1 == s3 -> false;
s3 == s4 -> false;

//equals ; compares data :
s1.equals(s2) - true , s1.equals(s3) - true ,  s3.equals(s4) - true   //@@@@@@CHECK

//compares lexo. order and data  : comapareTo -> extension of equals 
String s1 = "hey";
String s2 = "just kidding"
s1.compareTo(s2) -> -1 as s2> s1           [s1>s2 -> 1 , s1==s2 -> 0 , s1<s2 -> -1]

s1.contains(s2)   -> true or false 
s1.indexOf(s2)     -> if s1 contains s2 , returns the index of s1 containing s2 , if not present return -1


String a  = "hey"
String b = a;  //reference copy 
a==b ->true 
a = a + " there";
a==b -> false;      //as a now points to a new object "hey there" and b still points to older object "hey"

*/