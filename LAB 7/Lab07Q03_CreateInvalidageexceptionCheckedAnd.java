// Reference solution; understand and adapt it before using.
public class Lab07Q03_CreateInvalidageexceptionCheckedAnd {
    static class InvalidAgeException extends Exception { InvalidAgeException(String message){super(message);} }
    static void validateAge(int age) throws InvalidAgeException {if(age<0||age>120)throw new InvalidAgeException("Age must be between 0 and 120; received "+age);}
    public static void main(String[] args){for(int age:new int[]{20,145})try{validateAge(age);System.out.println(age+" accepted");}catch(InvalidAgeException e){System.out.println(e.getMessage());}}
}
