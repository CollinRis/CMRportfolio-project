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

### Author
Collin Rismiller

![](osu-emailsig.png)

College of Engineering

Electrical and Computer Engineering
