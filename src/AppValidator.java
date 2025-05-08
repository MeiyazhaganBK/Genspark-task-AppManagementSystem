import java.util.Arrays;
import java.util.List;

class AppValidator {
    static List<String> allowedCategories = Arrays.asList("Games", "Utility", "Finance", "Enterprise");
    static List<String> bannedDevelopers = Arrays.asList("BadDev123", "HackerCorp");

    public static void validate(App app) throws AppSizeTooLargeException,
            InvalidCategoryException, PricingException, DeveloperBannedException {

        if (app.appSizeInMB > 500) {
            throw new AppSizeTooLargeException("App size exceeds limit: " + app.appSizeInMB + "MB");
        }

        if (!allowedCategories.contains(app.category)) {
            throw new InvalidCategoryException("Invalid category: " + app.category);
        }

        if (app.price < 0) {
            throw new PricingException("Price cannot be negative.");
        }

        if (!app.category.equals("Enterprise") && app.price > 100) {
            throw new PricingException("Price exceeds limit for non-Enterprise apps: $" + app.price);
        }

        if (bannedDevelopers.contains(app.developerName)) {
            throw new DeveloperBannedException("Developer " + app.developerName + " is banned.");
        }
    }
}
