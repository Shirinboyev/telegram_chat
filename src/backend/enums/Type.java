package backend.enums;
import static ui.utils.Utils.*;
public enum Type {
    PRIVATE, PUBLIC;
     public static Type choose(){
         for (int i = 0; i < values().length; i++)
             System.out.println((i + 1) + ": " + values()[i].name());

             Integer choose = enterInt("choose: ")-1;

             if(choose < 0 || choose>values().length){
                 System.out.println("Invalid choise");
                 return choose();
             }
         return values()[choose];
     }
    
    
}
