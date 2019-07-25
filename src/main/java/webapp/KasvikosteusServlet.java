package webapp;

import webapp.Analyzer;
import webapp.AdafruitRequester;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class KasvikosteusServlet extends HttpServlet {
    
   private static final long serialVersionUID = 1L;
 
    
   public KasvikosteusServlet() {
   }
 
   @Override
   protected void doGet(HttpServletRequest req,
           HttpServletResponse resp) throws ServletException, IOException {
       
	   AdafruitRequester adafruitRequester = new AdafruitRequester();
	   
       String humidity = adafruitRequester.getHumidity();
       Analyzer analyzer = new Analyzer();
       String analysis = analyzer.analyze(humidity);
       
       req.setAttribute("kosteus", humidity);
       req.setAttribute("analysis", analysis);
       
       RequestDispatcher view = req.getRequestDispatcher("result.jsp");
       view.forward(req, resp);
   }
   
   @Override
   protected void doPost(HttpServletRequest request,
           HttpServletResponse response) throws ServletException, IOException {
       this.doGet(request, response);
   }
}