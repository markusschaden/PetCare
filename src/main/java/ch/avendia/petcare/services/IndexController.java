package ch.avendia.petcare.services;

import ch.avendia.petcare.framework.security.session.SessionService;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Markus on 20.04.2015.
 */
@Singleton
public class IndexController extends HttpServlet {

    @Inject
    SessionService listService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //req.setAttribute("names", listService.names());
        req.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(req, resp);
    }

}
