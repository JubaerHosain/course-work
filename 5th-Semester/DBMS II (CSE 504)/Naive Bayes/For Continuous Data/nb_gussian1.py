# For continuous datasets

import pandas as pd
import numpy as np
from sklearn.naive_bayes import GaussianNB
from sklearn.model_selection import train_test_split

# Load the data [this data is continuous]
data = pd.read_csv('gender.data', sep=",")

# Split the data into features and target
X = data.iloc[:, 1:-1]
y = data.iloc[:, -1]

# Split the data into training and testing sets
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.3, random_state=42)

# Create a Gaussian Naive Bayes model
model = GaussianNB()

# Train the model using the training data
model.fit(X_train, y_train)

# Make predictions on the testing data
y_pred = model.predict(X_test)

# Calculate the test accuracy
accuracy = np.mean(y_pred == y_test)

print('Test Accuracy:', accuracy)
