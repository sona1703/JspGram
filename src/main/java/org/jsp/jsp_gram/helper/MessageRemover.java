package org.jsp.jsp_gram.helper;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import jakarta.servlet.http.HttpSession;
@Component
public class MessageRemover {
	public void remove() {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpSession session = attributes.getRequest().getSession();
		session.removeAttribute("pass");
		session.removeAttribute("fail");
	}
}
