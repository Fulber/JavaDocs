package ro.teamnet.zth;

import ro.teamnet.zth.api.annotations.MyController;
import ro.teamnet.zth.api.annotations.MyRequestMethod;
import ro.teamnet.zth.appl.controller.DepartmentController;
import ro.teamnet.zth.appl.controller.EmployeeController;
import ro.teamnet.zth.fmk.AnnotationScanUtils;
import ro.teamnet.zth.fmk.MethodAttributes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * Created by user on 14.07.2016.
 */
public class DispatcherServlet extends HttpServlet {

    /*
     * key: urlPath
     * val: method info
     */
    HashMap<String, MethodAttributes> allowedMethods = new HashMap<>();

    @Override
    public void init() throws ServletException {

        try {
            Iterable<Class> classes = AnnotationScanUtils.getClasses("ro.teamnet.zth.appl.controller");
            for (Class controller : classes) {
                if (controller.isAnnotationPresent(MyController.class)) {
                    MyController myController = (MyController) controller.getAnnotation(MyController.class);
                    String urlPath = myController.urlPath();

                    Method[] methods = controller.getMethods();
                    for (Method method : methods) {
                        if (method.isAnnotationPresent(MyRequestMethod.class)){
                            MyRequestMethod myRequestMethod = method.getAnnotation(MyRequestMethod.class);
                            String finalUrlPath = urlPath + myRequestMethod.urlPath();

                            MethodAttributes methodAttributes = new MethodAttributes();
                            methodAttributes.setControllerClass(controller.getName());
                            methodAttributes.setMethodType(myRequestMethod.methodType());
                            methodAttributes.setMethodName(method.getName());

                            allowedMethods.put(finalUrlPath, methodAttributes);
                        }
                    }
                }
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        dispatchReply("GET", req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        dispatchReply("POST", req, resp);
    }

    protected void dispatchReply(String type, HttpServletRequest req, HttpServletResponse resp) {

        try {
            Object r = dispatch(req, resp);
            reply(r, req, resp);

        } catch (Exception ex) {
            sendExceptionError(ex, req, resp);
        }
    }

    protected Object dispatch(HttpServletRequest req, HttpServletResponse resp) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        String pathInfo = req.getPathInfo();

        MethodAttributes methodAttributes = allowedMethods.get(pathInfo);
        Object controller = Class.forName(methodAttributes.getControllerClass()).newInstance();
        Method requestedMethod = controller.getClass().getMethod(methodAttributes.getMethodName());

        return requestedMethod.invoke(controller);
    }

    protected void reply(Object r, HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.getWriter().write((String) r);
    }

    protected void sendExceptionError(Exception ex, HttpServletRequest req, HttpServletResponse resp) {

    }
}
