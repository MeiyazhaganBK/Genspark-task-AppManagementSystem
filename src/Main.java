public class Main {
    public static void main(String[] args) {
        App[] apps = {
                new App("GamePro", "AliceDev", 450, "Games", 50),
                new App("SecureBank", "BadDev123", 300, "Finance", 10),
                new App("HeavyApp", "TrustedDev", 600, "Utility", 20),
                new App("FinanceBuddy", "JohnDev", 300, "Banking", 0),
                new App("EnterpriseSuite", "ProCorp", 400, "Enterprise", 150),
                new App("CheapTool", "ToolsInc", 120, "Utility", -5)
        };

        for (App app : apps) {
            try {
                AppValidator.validate(app);
                System.out.println("App " + app.appName + " by " + app.developerName + " is approved for publishing.");
            } catch (AppSizeTooLargeException | InvalidCategoryException |
                     PricingException | DeveloperBannedException e) {
                System.out.println("Validation failed for " + app.appName + ": " + e.getMessage());
            } finally {
                System.out.println("Validation completed for " + app.appName);
                System.out.println("-------------------------------------------------");
            }
        }
    }
}
