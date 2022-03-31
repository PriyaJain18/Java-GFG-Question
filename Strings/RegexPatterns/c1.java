// package RegexPatterns;

import java.util.Scanner;
import java.util.regex.*;
/*
MatchResult INTERFACE AND 3 CLASSES -> Matcher ,Pattern, PatternSyntaxException 
COMMON METHODS: 
//MATCHER CLASS :
1   boolean matches()	test whether the regular expression matches the pattern.
2	boolean find()	finds the next expression that matches the pattern.
3	boolean find(int start)	finds the next expression that matches the pattern from the given start number.
4	String group()	returns the matched subsequence.
5	int start()	returns the starting index of the matched subsequence.
6	int end()	returns the ending index of the matched subsequence.
7	int groupCount()	returns the total number of the matched subseque
8.  split()
9.  pattern()

[abc] = can be either a, b, or c (simple class)
[^abc] = Any character except a, b, or c (negation)
[a-zA-Z] = a through z or A through Z, inclusive (range)
[a-d[m-p]] = a through d, or m through p: [a-dm-p] (union)
[a-z&&[def]] = d, e, or f (intersection)
[a-z&&[^bc]] = a through z, except for b and c: [ad-z] (subtraction)
[a-z&&[^m-p]] = a through z, and not m through p: [a-lq-z](subtraction)

Regex	Description
X? = X occurs once or not at all
X+  = 1/1+
X*  = 0/0+
X{n} = n times only
X{n,} = X occurs n/n+
X{y,z}	= X occurs y to z(excluded) times

.	Any character (may or may not match terminator)
\d	Any digits, short of [0-9]
\D	Any non-digit, short for [^0-9]
\s	Any whitespace character, short for [\t\n\x0B\f\r]
\S	Any non-whitespace character, short for [^\s]
\w	Any word character, short for [a-zA-Z_0-9]
\W	Any non-word character, short for [^\w]
\b	A word boundary
\B	A non word boundary
*/

public class c1 {
    public static boolean MatchFinder(){ //returns first match from text entered,regardless if the remaining text has non-pattern criteria
        Scanner sc = new Scanner(System.in);
        Pattern p = Pattern.compile(sc.nextLine());  //enter pattern
        Matcher m = p.matcher(sc.nextLine());    //enter text in which we need to find/match pattern 
        if(m.find()){  //finds  and returns first match , if we need to find all matches -> use while instead of if
            System.out.println("match found ,returns : "+ m.group()+" from index "+ m.start()+ " to "+m.end());
            return true;
        }else{
            return false;
        }
    }  
    public static void main(String[] args) {
        boolean found = MatchFinder();  // pattern -> \d , text->53js , OUTPUT -> match found ,returns : 5 from index 0 to 1
        System.out.println("match found: "+found);
        //IF ABOVE DONE USING Pattern.matches(regex,input) -> return false;
        System.out.println(Pattern.matches("\\d", "53js"));// false (has more than 2 char)

        //OTHER REGEX EXAMPLES : 
        System.out.println(Pattern.matches(".s", "amms"));// false (has more than 2 char)
        System.out.println(Pattern.matches("..s", "mas"));// true (3rd char is s)
        System.out.println(Pattern.matches("[amn]", "abcd"));// false (not a or m or n)
        System.out.println(Pattern.matches("[amn]", "a"));// true (among a or m or n)
        System.out.println(Pattern.matches("[amn]", "ammmna"));// false (m and a comes more than once)
        System.out.println(Pattern.matches("[amn]?", "aaa"));// false (a comes more than one time)
        System.out.println(Pattern.matches("[amn]?", "aammmnn"));// false (a m and n comes more than one time)
        System.out.println(Pattern.matches("[amn]?", "am"));// false (a or m or n must come one time)
        System.out.println(Pattern.matches("[a-d]", "b"));// true
        System.out.println(Pattern.matches("[a-d]", "abc"));// false (more than one letter)
        System.out.println(Pattern.matches("\\d", "1"));// true (digit and comes once)
        System.out.println(Pattern.matches("\\d", "4443"));// false (digit but comes more than once)
        System.out.println(Pattern.matches("\\D", "m"));// true (non-digit and comes once)
        System.out.println(Pattern.matches("\\D", "abc"));// false (non-digit but comes more than once)
        System.out.println(Pattern.matches("\\D*", "mak"));// true (non-digit and may come 0 or more times)
        System.out.println(Pattern.matches("[a-zA-Z0-9]{6}", "JA2Uk2"));// true
        System.out.println(Pattern.matches("[a-zA-Z0-9]{6}", "arun$2lr"));// false ($ is not matched and also more than 6 characters)
        /*EXAMPLE : Create a regular expression that accepts 10 digit numeric characters starting with 7, 8 or 9 only.  
 [789]{1}[0-9]{9}
 [789][0-9]{9}
 [789]{1}\\d{9}
 */
    }

}