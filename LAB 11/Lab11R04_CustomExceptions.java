// Reference solution; understand and adapt it before using.
public class Lab11R04_CustomExceptions {
    static class ItemNotAvailableException extends Exception { ItemNotAvailableException(String id){super("Item "+id+" is already on loan");} }
    static class MemberLimitExceededException extends Exception { MemberLimitExceededException(String member,int limit){super(member+" already has the maximum "+limit+" active loans");} }
    static void checkBorrow(String itemId,boolean available,String member,int activeLoans) throws ItemNotAvailableException,MemberLimitExceededException {if(!available)throw new ItemNotAvailableException(itemId);if(activeLoans>=3)throw new MemberLimitExceededException(member,3);}
    public static void main(String[] args){try{checkBorrow("B-3",true,"Kelvin",3);}catch(ItemNotAvailableException|MemberLimitExceededException e){System.out.println(e.getMessage());}}
}
