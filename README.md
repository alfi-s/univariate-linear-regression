# Gradient Descent for Univariate Linear Regression
Program in Java to demonstrate univariate linear regression with gradient descent.

## Usage
On Linux or MacOS:
```sh
$ chmod +x gradient-descent.sh
$ ./gradient-descent.sh
```

On Windows:
```bat
C:\DIRECTORY> gradient-descent.bat
```
These will automatically compile and run the program.
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

## Plotting Functions
On line 58 of the `GradientDescent` class, there is a HypothesisFunction functional interface that is used 
in plotting the graph for said function. For example, if you want to plot the function:
```
h(x) = x + 2
```
you'd change that line to be:
```java
HypothesisFunction h_x = (x) -> x + 2;
```
This is called a *lambda expression*, and it's useful because it resembles how you'd write
the function mathematically. Lambda expressions are of the form:
```
(parameter1, parameter2,...parameterN) -> { function body }
```
Think of it as just a more compact way of writing methods.

If you want to add external variables in the lambda expression you have to
create a temporary variable that is `final` because of how it is implemented
in Java. So if you have variables `w1` and `w2` and want to express the function
`h(x) = (w1 * x) + w0`, you'd have to create temporary variables to store the current value. That is:
```java
double w1 = 0;
double w2 = 0;
////////////////////
// some code here //
////////////////////
final double w_1 = w1;
final double w_0 = w0;
HypothesisFunction h_x = (x) -> (w1 * x) + w0;
```
As of right now, the HypothesisFunction interface can only handle one parameter `x`.
If you want to pass in more parameters you'd have to go to `HypothesisFunction.java` 
and change the method signature.

For example, you want to write the function `(x1, x2) -> x1 + x2`.

In `HypothesisFunction.java`, change the `evaluate` method to:
```java
double evaluate(double x1, double x2);
```

As it is, the program is only capable of plotting graphs for univariate regression because it only plots
in two dimensions.