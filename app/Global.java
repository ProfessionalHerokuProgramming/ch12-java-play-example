import play.*;
import play.libs.*;

import java.util.*;

import play.db.ebean.*;
import com.avaje.ebean.*;

import models.Employee;

public class Global extends GlobalSettings {

    @Override
    public void onStart(Application app) {
        InitialData.insert(app);
    }

   static class InitialData {
        
        public static void insert(Application app) {

            if (Ebean.find(Employee.class).findRowCount() == 0) {
                    
                Map<String,List<Object>> all = 
                    (Map<String,List<Object>>)Yaml.load("initial-data.yml");
        
                // Insert employees
                Ebean.save(all.get("employees"));
            }
        }
    }
}