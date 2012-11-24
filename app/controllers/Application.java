package controllers;

import play.*;
import play.mvc.*;

import models.Employee;

import views.html.*;

public class Application extends Controller {
  
    public static Result index() {
        return ok(
            views.html.index.render(Employee.all())
        );
    }    
}