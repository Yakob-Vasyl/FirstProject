package audioshop.tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

/**
 * Created by vasya on 006 06 03 2017.
 */
public class AllParams extends SimpleTagSupport {
    private final StringWriter sw = new StringWriter();
    private final static String AMPER = "&";
    private final static String QUEST = "?";
    private final static String EQUAL = "=";

    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        PageContext pageContext = (PageContext) getJspContext();
        HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
        Map<String, String[]> map = request.getParameterMap();
        boolean isFirst = true;
        for(Map.Entry<String, String[]> entry : map.entrySet()){
            for(String value : entry.getValue()){
                if(isFirst){
                    sw.append(QUEST);
                    isFirst = false;
                }else{
                    sw.append(AMPER);
                }
                sw.append(entry.getKey());
                sw.append(EQUAL);
                sw.append(value);
            }
        }
        out.println(sw.toString());
    }
}
