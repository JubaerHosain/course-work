# For discrete datasets

import pandas as pd
from sklearn.preprocessing import LabelEncoder
from sklearn.model_selection import train_test_split
from sklearn.naive_bayes import MultinomialNB
from sklearn.metrics import accuracy_score, classification_report

# Load the data
data = pd.read_csv("play-tennis.data", sep=",")

# Convert categorical variables to numerical values
labelencoder = LabelEncoder()
data['Outlook'] = labelencoder.fit_transform(data['Outlook'])
data['Temperature'] = labelencoder.fit_transform(data['Temperature'])
data['Humidity'] = labelencoder.fit_transform(data['Humidity'])
data['Wind'] = labelencoder.fit_transform(data['Wind'])

# split the data into features (inputs) and target (output):
X = data.values[:, 1:-1]  # select all columns except the first (Day) and the last (PlayTennis)
y = data.values[:, -1]    # select only the last column (PlayTennis)

# Split the data into training and testing sets
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.3, random_state=42)

# Create a Multinomial Naive Bayes model
clf = MultinomialNB()

# Train the model using the training data
clf.fit(X_train, y_train)

# Make predictions on the testing data
y_pred = clf.predict(X_test)

print("Accuracy:", accuracy_score(y_test, y_pred))
# print(classification_report(y_test, y_pred))

