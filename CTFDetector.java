import java.util.Scanner;

public class CTFDetector {
public static void main(String[] args){
 Scanner sc = new Scanner(System.in);
System.out.println("write the ctf string: ");
String input = sc.nextLine();
System.out.println("you entered " + input);

if (input.matches("^[0-9a-fA-F]+$") && input.length() % 2 == 0) {
System.out.println("Detected: Hex");
System.out.println("prerequisites: ");
System.out.println("ASCII - every character has a number");
System.out.println("Binary - computers store evrything as 0s and 1s");
System.out.println("Hexadecimal notation - uses 0-9 & A-F");

System.out.println("do you want to decode it?(y/n)");
String choice = sc.nextLine();
if(choice.equals("y")){
StringBuilder decoded = new StringBuilder();
for(int i=0;i<input.length();i+=2){
String byteStr = input.substring(i,i+2);
int value = Integer.parseInt(byteStr,16);
decoded.append((char)value);
}
System.out.println("decoded: " + decoded);
}

}else if (input.matches("^[a-zA-Z]+$") && input.length() > 3) {
System.out.println("Detected: Possibly ROT13 or Caesar cipher");
System.out.println("Prerequisites: ");
System.out.println("Alphabet indexing - every letter has a position");
System.out.println("Caesar cipher - letters shifted by a fixed number");
System.out.println("ceaser shifted by 13");

System.out.println("do you want to decode as ROT13? (y/n)");
String choice = sc.nextLine();
if(choice.equals("y")){
StringBuilder decoded = new StringBuilder();
for(char c : input.toCharArray()){
if(Character.isLetter(c)){
char base = Character.isUpperCase(c) ? 'A' : 'a';
decoded.append((char)((c - base + 13) % 26 + base));
}
else{
decoded.append(c);
}}
System.out.println("decoded: " + decoded);
}


}else if (input.matches("^[a-zA-Z0-9+/]+=+$")) {
System.out.println("Detected: Base64");
System.out.println("ASCII");
System.out.println("binary");
System.out.println("encoding vs encryption");
System.out.println("base64 character list");

System.out.println("want to decode it?(y/n)");
String choice = sc.nextLine();
if(choice.equals("y")){
byte[] decoded = java.util.Base64.getDecoder().decode(input);
System.out.println("decode: " + new String(decoded));
}
}else {
System.out.println("Could not identify encoding");
}}}
