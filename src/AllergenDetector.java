import components.set.Set;
import components.set.Set1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * The {@code AllergenDetector} component for tracking allergens in food. 
 */
public class AllergenDetector {

    private Set<String> trackedAllergens;

    /**
     * Constructor: Initializes an empty set of allergens.
     */
    public AllergenDetector() {
        this.trackedAllergens = new Set1L<>();
    }

    /**
     * Adds an allergen to the user's tracked list.
     * @param allergenName The allergen to track.
     */
    public void addAllergen(String allergenName) {
        this.trackedAllergens.add(allergenName.toLowerCase());
    }

    /**
     * Removes an allergen from the user's tracked list.
     * @param allergenName The allergen to remove.
     */
    public void removeAllergen(String allergenName) {
        this.trackedAllergens.remove(allergenName.toLowerCase());
    }

    /**
     * Checks if the given ingredient list contains any allergens.
     * @param ingredientList A comma-separated list of ingredients.
     * @return True if any tracked allergen is found.
     */
    public boolean containsAllergen(String ingredientList) {
        for (String ingredient : ingredientList.toLowerCase().split(", ")) {
            if (this.trackedAllergens.contains(ingredient)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns a set of allergens found in the given ingredient list.
     * @param ingredientList A comma-separated list of ingredients.
     * @return Set of detected allergens.
     */
    public Set<String> getDetectedAllergens(String ingredientList) {
        Set<String> detected = new Set1L<>();
        for (String ingredient : ingredientList.toLowerCase().split(", ")) {
            if (this.trackedAllergens.contains(ingredient)) {
                detected.add(ingredient);
            }
        }
        return detected;
    }

    /**
     * Determines if the given food is safe to eat.
     * @param ingredientList A comma-separated list of ingredients.
     * @return True if no allergens are found.
     */
    public boolean isSafeToEat(String ingredientList) {
        return !this.containsAllergen(ingredientList);
    }

    /**
     * Checks if the facility has a risk of cross-contamination.
     * @param facilityInfo Information about the manufacturing facility.
     * @return True if cross-contamination risk is high.
     */
    public boolean isCrossContaminationRisk(String facilityInfo) {
        return facilityInfo.toLowerCase().contains("processed in facility with allergens");
    }

    /**
     * Alerts the user if a dangerous allergen is detected.
     * @param allergenName The detected allergen.
     * @param productName The food product containing the allergen.
     */
    public void alertUser(String allergenName, String productName) {
        System.out.println("ALERT: " + productName + " contains " + allergenName + "! Avoid consumption.");
    }

    /**
     * Looks up a food product and checks for allergens in its ingredient list.
     * @param ingredientList A comma-separated list of ingredients.
     */
    public void enterIngredientString(String ingredientList) {
        Set<String> detectedAllergens = this.getDetectedAllergens(ingredientList);

        if (detectedAllergens.size() > 0) {
            System.out.println("WARNING: Allergens detected in food product!");
            System.out.println("Detected allergens: " + detectedAllergens);
        } else {
            System.out.println("Safe to eat! No allergens detected.");
        }
    }

    /**
     * Main method for demonstration.
     */
    public static void main(String[] args) {
        SimpleWriter out = new SimpleWriter1L();
        AllergenDetector detector = new AllergenDetector();

        // Predefined test inputs
        detector.addAllergen("peanuts");
        detector.addAllergen("milk");
        detector.addAllergen("soy");

        String testIngredients1 = "sugar, flour, milk, eggs";
        String testIngredients2 = "sugar, flour, cocoa, vanilla";

        out.println("Testing ingredient list: " + testIngredients1);
        detector.enterIngredientString(testIngredients1);

        out.println("Testing ingredient list: " + testIngredients2);
        detector.enterIngredientString(testIngredients2);

        out.close();
    }
}
