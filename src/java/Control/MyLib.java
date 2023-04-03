package Control;
import jakarta.servlet.http.*;

public class MyLib {
   public static String searchCookie(Cookie [] a, String xName) {
      String u = null; 
      if(a==null) return(null);
      for(Cookie x : a) {
          if(x.getName().equals(xName)) return(x.getValue());
      }
      return(u);
   }    
}
