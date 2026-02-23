import java.util.Scanner;

public class CTFDetector{

static void caesarBruteForce(String input){
System.out.println("all possible ceasershifts:");
for(int i=0;i<=25;i++){
StringBuilder decoded = new StringBuilder();
for(char c:input.toCharArray()){
if(Character.isLetter(c)){
char base = Character.isUpperCase(c) ? 'A' : 'a';
decoded.append((char)((c-base+i)%26+base));
}
else{
decoded.append(c);
}}
System.out.println("shift " + i + ": " + decoded);
}}

public static void main(String[] args){
Scanner sc = new Scanner(System.in);
System.out.println("write your CTF string:");
String input = sc.nextLine();

if(input.matches("^[0-9a-fA-F]+$") && input.length() % 2==0){
System.out.println("hex detected");
System.out.println("prerequisites:");
System.out.println("ASCII - every character has a number");
System.out.println("binary - computers store evrything as 0s and 1s");
System.out.println("hexaddecimal notation - uses 0-9 and A-F");
System.out.println("want to decode it?");
String choice = sc.nextLine();
if(choice.equals("y")){
StringBuilder decoded = new StringBuilder();
for(int i = 0; i<input.length();i+=2){
String byteStr = input.substring(i,i+2);
int value = Integer.parseInt(byteStr,16);
decoded.append((char)value);
}System.out.println("decoded: " + decoded);
}
}
else if(input.matches("^[a-zA-Z]+$") && input.length()>3){
System.out.println("possibly ROT13 or ceaser chipher");
System.out.println("prerequisites");
System.out.println("alphabet indexing");
System.out.println("caeser cipher - letters shifted by a fixed number");
System.out.println("ROT13 - caesar shifted by exactly 13");
System.out.println("what do u want to try");
System.out.println("1. decode as ROT13");
System.out.println("2. brute force ceaser");
System.out.println("3. both");
String choice = sc.nextLine();

if(choice.equals("1") || choice.equals("3")){
StringBuilder decoded = new StringBuilder();
for(char c : input.toCharArray()){
if(Character.isLetter(c)){
char base = Character.isUpperCase(c) ? 'A' : 'a';
decoded.append((char)((c-base+13)%26+base));
}
else{
decoded.append(c);
}}
System.out.println("ROT13 decoded: " + decoded);
}
if(choice.equals("2") || choice.equals("3")){
caesarBruteForce(input);
}

}else if(input.matches("^[a-zA-Z0-9+/]+=+4")){
System.out.println("base64 detected");
System.out.println("prerequisites");
System.out.println("ASCII");
System.out.println("binary - bits and bytes");
System.out.println("encoding vs encryption");
System.out.println("base64 characted list - A-Z,a-z,0-9,+,/");
System.out.println("want to decode it?(y/n)");
String choice = sc.nextLine();
if(choice.equals("y")){
byte[] decoded = java.util.Base64.getDecoder().decode(input);
System.out.println("decoded: " + new String(decoded));
}
}
else{
System.out.println("couldnt identify encoding type");
}}}
