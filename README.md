# Gradient Descent for Univariate Linear Regression
Program in Java to demonstrate univariate linear regression with gradient descent.

## Usage
Compile the program through:
```bash
$ javac src/*.java
```
Run the program through:
```bash
$ java -cp src GradientDescent
```

## Data
Data is stored as .csv files within the `/data` folder. 
The program works on numeric data, thus the data should be formatted as two-column numeric data delimited with commas.

You can specify the your own file by changing line 3 of `GradientDescent.java`:
```java
    static final String DATA_FILE = /* your_file.csv */;
```

Example data included:
* `MacdonellDF.csv`
    * Macdonell's Data on Height and Finger Length of Criminals, used by Gosset (1908)
    * Format: height, finger_length