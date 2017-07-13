package listener;

import javax.servlet.http.HttpSessionEvent;  
import javax.servlet.http.HttpSessionListener;  
  
  
public class Listener1 implements HttpSessionListener {  
      
    private long onlineCount;  
  
    public void sessionCreated(HttpSessionEvent event) {  
        // TODO Auto-generated method stub  
         System.out.println("开始会话");
    	this.onlineCount=this.onlineCount+1;  
    	System.out.println(onlineCount+"aaaaaaaaaaaaaaaaaa");
    	
                                //保存在application作用域  
        event.getSession().getServletContext().setAttribute("onlineCount", onlineCount); 

    }  
  
    public void sessionDestroyed(HttpSessionEvent event) {  
        // TODO Auto-generated method stub  
        System.out.println("会话结束");
        this.onlineCount=this.onlineCount-1;  
        event.getSession().getServletContext().setAttribute("onlineCount", onlineCount);  
    }  
  
}  
