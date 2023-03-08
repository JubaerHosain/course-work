from sklearn.tree import DecisionTreeClassifier
from sklearn.datasets import load_iris
from sklearn.model_selection import train_test_split
import numpy as np

# Create a toy dataset with height, weight, and bmi as features
# and class as the target variable
dataset = {
    'height': [170, 160, 180, 175, 165, 172, 168, 182, 178, 171],
    'weight': [70, 65, 80, 72, 68, 75, 71, 85, 82, 73],
    'bmi': ['mid', 'low', 'high', 'mid', 'low', 'mid', 'mid', 'high', 'high', 'mid'],
    'class': ['A', 'B', 'B', 'A', 'B', 'A', 'A', 'B', 'B', 'A']
}

# Convert the dataset to a numpy array
X = np.array([dataset['height'], dataset['weight'], dataset['bmi']]).T
y = np.array(dataset['class'])

# Split the dataset into training and testing sets
X_train, X_test, y_train, y_test = train_test_split(X, y, random_state=0)

# Create the decision tree classifier
dtc = DecisionTreeClassifier()

# Fit the classifier to the training data
dtc.fit(X_train, y_train)

# Evaluate the classifier on the testing data
accuracy = dtc.score(X_test, y_test)

print("Accuracy:", accuracy)
# For continuous variables[weights, height, length, temperature...]