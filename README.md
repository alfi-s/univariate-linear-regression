# Gradient Descent for Univariate Linear Regression
Program in Java to demonstrate univariate linear regression with gradient descent.

## Usage
Compile the program through:
```bash
$ javac src/*.java
```
Run the program through:
```bash
$ java GradientDescent <fileName>
```

## Data
Data is stored as .csv files within the `/data` folder. 
The program works on numeric data, thus the data should be formatted as two-column numeric data delimited with commas.

Example data includes:
* `MacdonellDF.csv`
    * Macdonell's Data on Height and Finger Length of Criminals, used by Gosset (1908)
    * Format: height, finger_length