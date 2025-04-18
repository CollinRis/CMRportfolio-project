import components.set.Set;

public class AllergenDetectorUseCases {

    public static void main(String[] args) {
        System.out.println("=== USE CASE 1: Personal Allergen Tracking ===");

        // Set up the allergen detector with My allergens
        AllergenDetector1L personalDetector = new AllergenDetector1L();
        personalDetector.addAllergen("milk");
        personalDetector.addAllergen("eggs");

        // Simulated ingredients from a food label
        String product1 = "SUGAR, INVERT SUGAR, CORN SYRUP, MODIFIED CORN STARCH, CONTAINS LESS THAN 2% OF CITRIC ACID, WHITE MINERAL OIL, NATURAL AND ARTIFICIAL FLAVOR, RED 40, CARNAUBA WAX"; //Swedish Fish
        String product2 = "Sugar, Chocolate, Milk, Cocoa Butter, Skim Milk, Milk Fat, Lecithin (Soy), PGPR, Natural Flavor"; //Hersheys Bar

        // Check if the product contains any tracked allergens
        if (!personalDetector.isSafeToEat(product1)) {
            Set<String> found = personalDetector.getDetectedAllergens(product1);
            // Show a warning message to the user
            personalDetector.alertUser(found.toString(), "Swedish Fish");
        } else {
            System.out.println("Product is safe to eat!");
        }

        // Check the second product
        if (!personalDetector.isSafeToEat(product2)) {
            Set<String> found = personalDetector.getDetectedAllergens(product2);
            // Show a warning message to the user
            personalDetector.alertUser(found.toString(), "Hersheys Bar");
        } else {
            System.out.println("Product is safe to eat!");
        }


        System.out.println("\n=== USE CASE 2: Facility Cross-Contamination Check ===");

        // Info string from a food label about the facility
        AllergenDetector1L facilityDetector = new AllergenDetector1L();
        String facilityInfo = "This product is processed in facility with allergens";

        // Check if there's cross-contamination risk
        if (facilityDetector.isCrossContaminationRisk(facilityInfo)) {
            System.out.println("WARNING: Cross-contamination possible. Add allergen warning to label.");
        } else {
            System.out.println("No cross-contamination risk.");
        }

        System.out.println("\n=== USE CASE 3: Batch Meal Check ===");

        // Set up meal detector with allergens to watch for
        AllergenDetector1L mealDetector = new AllergenDetector1L();
        mealDetector.addAllergen("eggs");
        mealDetector.addAllergen("milk");

        // A list of dishes in a meal
        String[] mealDishes = {
            "bread, water, salt",          // Safe
            "chocolate, milk, sugar",      // Contains milk
            "flour, eggs, butter"          // Contains eggs
        };

        // Check each dish for allergens
        for (int i = 0; i < mealDishes.length; i++) {
            System.out.println("Dish " + (i + 1) + ":");
            mealDetector.enterIngredientString(mealDishes[i]);  // Prints whether safe or not
            System.out.println();
        }

        System.out.println("\n=== USE CASE 4: Transfer Allergen Settings ===");

        // Create a detector for a parent with existing allergens
        AllergenDetector1L parent = new AllergenDetector1L();
        parent.addAllergen("gluten");
        parent.addAllergen("tree nuts");

        // Create a child detector and transfer the parent's settings
        AllergenDetector1L child = new AllergenDetector1L();
        child.transferFrom(parent);  // Now child has the allergens, parent is cleared

        // Check the child detector against ingredients
        System.out.println("Child allergen detection:");
        child.enterIngredientString("gluten, sugar, tree nuts"); // should detect both

        // Check that parent is cleared after transfer
        System.out.println("Parent allergen detection after transfer:");
        parent.enterIngredientString("gluten, tree nuts"); // should say safe

        System.out.println("\n=== END OF USE CASE DEMOS ===");
    }
}
