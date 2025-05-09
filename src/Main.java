import Exceptions.AppSizeTooLargeException;
import Exceptions.DeveloperBannedException;
import Exceptions.InvalidCategoryException;
import Exceptions.PricingException;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        List<App> apps = Arrays.asList(
                new App("SuperGame", "JohnDoe", 450, "Games", 20),
                new App("MegaTool", "JaneDoe", 550, "Utility", 10),
                new App("FinTrack", "BadDev", 400, "Finance", 5),
                new App("EnterpriseSuite", "CorpDev", 300, "Enterprise", 150)
        );

        for (App app : apps) {
            try {
                AppValidator.validate(app);
                System.out.println("App " + app.appName + " by " + app.developerName + " is approved for publishing.");
            } catch (AppSizeTooLargeException | InvalidCategoryException |
                     PricingException | DeveloperBannedException e) {
                System.out.println("Validation failed for " + app.appName + ": " + e.getMessage());
            } finally {
                System.out.println("Validation completed for " + app.appName);
                System.out.println();
            }
        }
    }
}
