package webapp;

import webapp.Analyzer;
import webapp.AdafruitRequester;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
 
public class KasvikosteusServlet extends HttpServlet {
    
   private static final long serialVersionUID = 1L;
 
    
   public KasvikosteusServlet() {
   }
 
   @Override
   protected void doGet(HttpServletRequest req,
           HttpServletResponse resp) throws ServletException, IOException {
       
	   AdafruitRequester adafruitRequester = new AdafruitRequester();
	   ArrayList<String> data = adafruitRequester.getLastData();
       
	   String humidity = data.get(0);
	   String created_at = data.get(1);
	   
       Analyzer analyzer = new Analyzer();
       String analysis = analyzer.analyze(humidity);
       
       req.setAttribute("kosteus", humidity);
       req.setAttribute("analysis", analysis);
       req.setAttribute("created_at", created_at);
       
       RequestDispatcher view = req.getRequestDispatcher("result.jsp");
       view.forward(req, resp);
   }
   
   @Override
   protected void doPost(HttpServletRequest request,
           HttpServletResponse response) throws ServletException, IOException {
       this.doGet(request, response);
   }
}