import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/result")
public class MarksServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String marksP = req.getParameter("marks");
        String result = "";

        try {
            int marks = Integer.parseInt(marksP);

            if (marks < 0 || marks > 100){
                result = "Invalid Marks";
            }else{
                if (marks >=75){
                    result= "Grade A";
                }else if (marks >= 65){
                    result = "Grade B";
                }else if (marks >= 55){
                    result = "Grade C";
                }else if (marks >=45){
                    result = "Grade S";
                }else{
                    result = "Weak";
                }
            }
        }catch (Exception e){
            result = "Invalid Marks";
        }finally{
            try(PrintWriter out = resp.getWriter()){
                out.println("<h1>" + result + "<h1>");
            }
        }
    }
}
