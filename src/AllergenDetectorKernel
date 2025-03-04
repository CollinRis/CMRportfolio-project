import components.set.Set;
import components.standard.Standard;

/**
 * Kernel interface for the AllergenDetector component.
 * This interface defines the minimal set of operations required.
 * @author COllin Rismiller
 */
public interface AllergenDetectorKernel extends Standard<AllergenDetectorKernel> {

    /**
     * Adds an allergen to the tracked list.
     * @param allergen The allergen to track.
     * @requires allergen is not null and not empty.
     * @ensures this contains the added allergen.
     */
    void addAllergen(String allergen);

    /**
     * Removes an allergen from the tracked list.
     * @param allergen The allergen to remove.
     * @requires allergen exists in the tracked list.
     * @ensures this no longer contains the removed allergen.
     */
    void removeAllergen(String allergen);

    /**
     * Checks if a given ingredient list contains any tracked allergens.
     * @param ingredientList A comma-separated list of ingredients.
     * @return true if any tracked allergen is found, false otherwise.
     * @requires ingredientList is not null and properly formatted.
     * @ensures return value is true if and only if a tracked allergen is found.
     */
    boolean containsAllergen(String ingredientList);

    /**
     * Returns a set of detected allergens in the given ingredient list.
     * @param ingredientList A comma-separated list of ingredients.
     * @return A set of detected allergens.
     * @requires ingredientList is not null and properly formatted.
     * @ensures return value contains only the allergens found in the ingredient list.
     */
    Set<String> getDetectedAllergens(String ingredientList);
}
