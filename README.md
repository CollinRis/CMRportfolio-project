# Allergen Detector

A modular Java component for detecting food allergens in ingredient lists. Built using the OSU CSE software component architecture with support for kernel and secondary methods, real-world use cases, and full test coverage — no JUnit required.

---

##  Project Overview

This project provides:

- A reusable `AllergenDetector` component
- A clean kernel/secondary/component-based implementation
- Console test runner (`AllergenDetectorTest1L.java`)
- Use case simulator for real-world allergen checks (`AllergenDetectorUseCases.java`)

---

##  Features

- Track custom allergens (e.g., "milk", "soy", "peanuts")
- Detect allergens in food ingredient lists
- Check if a product is safe to eat
- Alert users if a dangerous allergen is detected
- Warn if the food is made in a high-risk facility
- Transfer allergen tracking settings between instances
- Console-based testing and demonstrations (no JUnit)

---

##  File Descriptions

| File                            | Purpose                                                                 |
|---------------------------------|-------------------------------------------------------------------------|
| `AllergenDetectorKernel.java`  | Defines the kernel interface with core methods like `addAllergen`, `containsAllergen` |
| `AllergenDetector.java`        | Extends the kernel with higher-level methods like `alertUser`, `isSafeToEat` |
| `AllergenDetectorSecondary.java`| Implements secondary methods using only kernel methods (abstract class) |
| `AllergenDetector1L.java`      | Final concrete implementation using `Set1L` for internal data            |
| `AllergenDetectorTest1L.java`  | Full coverage console-based test file — no JUnit required                |
| `AllergenDetectorUseCases.java`| Simulates real-world usage (e.g., scanning meals, checking labels)       |
| `AllergenDetectorMain.java`| Original proof of concept showing that it will work       |


---

##  How to Run

### 1. Compile all files
### 2. Add allergens
### 3. Use other componets to parse the strings and give you the details that are necessary



### Example Usage

```java
AllergenDetector1L detector = new AllergenDetector1L();
detector.addAllergen("milk");

if (!detector.isSafeToEat("sugar, flour, milk")) {
    detector.alertUser("milk", "Chocolate Cake");
}
```


### Output:

```
ALERT: Chocolate Cake contains milk! Avoid consumption.
```

### What this project taught me
This project gave me the oppurtunity to implement a software component with a layerd architecture approach. We started out with brainstorming ideas where the allergen detector stuck out to me due to my severe food allergies and reading labels and "parsing them" is something that I do in my everyday life. After I came up with the idea I had to make a proof of concept `AllergenDetectorMain.java` to prove that I could make this component work by implementing bare bones methods into code. Next after that came designing the interfaces which I am going to give a breif breakdown of Each one

| File                            | Purpose                                                                 |
|---------------------------------|-------------------------------------------------------------------------|
| `AllergenDetectorKernel.java`  | Defines the kernel interface with core methods like `addAllergen`, `containsAllergen`, `removeAllergen`, and `getDetectedAllergens` |
| `AllergenDetector.java`        | Extends the kernel with higher-level methods like `alertUser`, `isSafeToEat`, `enterIngridentsString` |
| `AllergenDetectorSecondary.java`| Implements secondary methods using only kernel methods (abstract class) |
| `AllergenDetector1L.java`      | Final concrete implementation using `Set1L` for internal data            |

This is implemented to follow the OSU software sequence and more layers can be added on in the future. Next came testing and use cases which personally was my favorite part, while it did take a lot of debugging and rewriting code it was extremely rewarding seeing all of the code work. While I couldn't get junit tests to work I still implemented code to show what should be given for each step and what was given. For the use case I showed personal allergen tracking with my personal allergies and two commonly found snacks. A facility cross - contaminiation detection which will alert the user if there is a cross contamination risk. I also showed how it can be used to show diffrent menu items that are inputed. Lastly we can transfer allergens between users if we need to accomodate for more than one person so we could transfer it all to one person and then run the code to dispaly what allergens are in certain foods. This project is personally rewarding as I and my brother both have life threatining food allergies and projects like this can be used to easily parse and find allergens in food quickly and easily. My next steps for this project would be figuring out how to take an image of an ingrident list, convert it to a string and then throw it into the code to detect allergens. I addtionaly would need to implement synomys for common allergies(ex Milk = Dairy) so something wouldnt be skipped over on accident. I also feelit would be cool to implement a GUI to make this more user friendly.

## Author
# Collin Rismiller

![](osu-emailsig.png)

The Ohio state University College of Engineering

 Electrical and Computer Engineering
