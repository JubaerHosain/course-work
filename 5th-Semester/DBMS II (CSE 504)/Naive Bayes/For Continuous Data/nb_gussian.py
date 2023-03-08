# For continuous datasets

import pandas as pd
import numpy as np
from sklearn.naive_bayes import GaussianNB
from sklearn.preprocessing import LabelEncoder
from sklearn.model_selection import train_test_split

# Load the data [this data is categorical]
data = pd.read_csv('play-tennis.data', sep=",")

# Convert categorical variables to numerical values
labelencoder = LabelEncoder()
data['Outlook'] = labelencoder.fit_transform(data['Outlook'])
data['Temperature'] = labelencoder.fit_transform(data['Temperature'])
data['Humidity'] = labelencoder.fit_transform(data['Humidity'])
data['Wind'] = labelencoder.fit_transform(data['Wind'])

# Split the data into features and target
X = data.iloc[:, 1:-1]
y = data.iloc[:, -1]

# Split the data into training and testing sets
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)

# Create a Gaussian Naive Bayes model
model = GaussianNB()

# Train the model using the training data
model.fit(X_train, y_train)

# Make predictions on the testing data
y_pred = model.predict(X_test)

print(y_pred)

# Calculate the test accuracy
accuracy = np.mean(y_pred == y_test)

print('Test Accuracy:', accuracy)
