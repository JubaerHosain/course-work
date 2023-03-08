# one-hot encoding

# Import necessary libraries
from sklearn.tree import DecisionTreeClassifier
import pandas as pd

# Load the data into a pandas dataframe
data = pd.read_csv('play-tennis.data', sep=",")

# Separate the features (X) and target variable (y)
X = data.drop(['Day', 'PlayTennis'], axis=1)
y = data['PlayTennis']

# one-hot encoding
# Convert categorical variables into numerical variables
X = pd.get_dummies(X)

# Create the decision tree model
model = DecisionTreeClassifier()

# Train the model
model.fit(X, y)

# Predict the target variable for a new instance
new_data = pd.DataFrame({
    'Outlook_Sunny': [1],
    'Outlook_Overcast': [0],
    'Outlook_Rain': [0],
    'Temperature_Hot': [1],
    'Temperature_Mild': [0],
    'Temperature_Cool': [0],
    'Humidity_High': [1],
    'Humidity_Normal': [0],
    'Wind_Strong': [0],
    'Wind_Weak': [1]
})

# Reorder the columns in the prediction data to match the order used during training
new_data = new_data[X.columns]

prediction = model.predict(new_data)

# Print the predicted output
print(prediction)
