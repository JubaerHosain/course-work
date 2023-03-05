# For categorical variables [color, gender, pet...]


# Import the necessary libraries
from sklearn.tree import DecisionTreeClassifier
from sklearn.preprocessing import LabelEncoder
import pandas as pd

# Create the dataset
data = {'Day': ['D1', 'D2', 'D3', 'D4', 'D5', 'D6', 'D7', 'D8', 'D9', 'D10', 'D11', 'D12', 'D13', 'D14'],
        'Outlook': ['Sunny', 'Sunny', 'Overcast', 'Rain', 'Rain', 'Rain', 'Overcast', 'Sunny', 'Sunny', 'Rain', 'Sunny', 'Overcast', 'Overcast', 'Rain'],
        'Temperature': ['Hot', 'Hot', 'Hot', 'Mild', 'Cool', 'Cool', 'Cool', 'Mild', 'Cool', 'Mild', 'Mild', 'Mild', 'Hot', 'Mild'],
        'Humidity': ['High', 'High', 'High', 'High', 'Normal', 'Normal', 'Normal', 'High', 'Normal', 'Normal', 'Normal', 'High', 'Normal', 'High'],
        'Wind': ['Weak', 'Strong', 'Weak', 'Weak', 'Weak', 'Strong', 'Strong', 'Weak', 'Weak', 'Weak', 'Strong', 'Strong', 'Weak', 'Strong'],
        'PlayTennis': ['No', 'No', 'Yes', 'Yes', 'Yes', 'No', 'Yes', 'No', 'Yes', 'Yes', 'Yes', 'Yes', 'Yes', 'No']}

df = pd.DataFrame(data)

# Convert categorical features to numeric labels
le = LabelEncoder()
df['Outlook'] = le.fit_transform(df['Outlook'])
df['Temperature'] = le.fit_transform(df['Temperature'])
df['Humidity'] = le.fit_transform(df['Humidity'])
df['Wind'] = le.fit_transform(df['Wind'])
df['PlayTennis'] = le.fit_transform(df['PlayTennis'])

# print(df)

#===========================

le.fit(data['Outlook'])
print(le.classes_, le.transform(le.classes_))
print(type(le.classes_), type(le.transform(le.classes_)))
le_name_mapping = dict(zip(le.classes_, le.transform(le.classes_)))
print(le_name_mapping)
{'Tom': 0, 'Nick': 1, 'Kate': 2}


#=============================

# Create the decision tree model
dtree = DecisionTreeClassifier()

# Define the features and target
X = df.iloc[:, 1:-1] # all columns except for Day and PlayTennis
y = df.iloc[:, -1] # PlayTennis column

# Fit the model to the data
dtree.fit(X, y)

# ==============Test - 0
"""
new_data = [[2, 1, 0, 1]] # ['Sunny', 'Hot', 'High', 'Weak']
test_df = pd.DataFrame(new_data, columns=X.columns)

# predict
prediction = dtree.predict(test_df)

print(test_df)
print(prediction) 
print(le.inverse_transform(prediction)) # Output: ['No']
"""

# ==============Test - 1
test_data = [['Sunny', 'Hot', 'High', 'Weak']]
test_df = pd.DataFrame(test_data, columns=X.columns)
print(test_df)


# test_df["Outlook"] = le.inverse_transform(test_df["Outlook"])


# Convert categorical features to numeric labels using LabelEncoder
# test_df = test_df.apply(lambda col: le.inverse_transform(col))


# predict
# prediction = dtree.predict(test_df)

print(test_df)
# print(prediction)
# print(le.inverse_transform(prediction))
