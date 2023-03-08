# for mixed values [Categorical and Continuous attributes]

import pandas as pd
from sklearn.tree import DecisionTreeClassifier
from sklearn.preprocessing import LabelEncoder
from sklearn.model_selection import train_test_split

data = tennis_data = pd.read_csv('tax-evasion.data', sep=',')

df = pd.DataFrame(data)

# encode categorical variables
# there is no need to encode target variable
le = LabelEncoder()
df['Refund'] = le.fit_transform(df['Refund'])
df['Marital Status'] = le.fit_transform(df['Marital Status'])

# split the data into training and testing sets
X_train, X_test, y_train, y_test = train_test_split(df.drop(['Tid', 'Cheat'], axis=1), df['Cheat'], test_size=0.3, random_state=42)

# train the decision tree classifier
dtc = DecisionTreeClassifier()
dtc.fit(X_train, y_train)

prediction = dtc.predict(X_test)
print(prediction)

# evaluate the decision tree classifier
score = dtc.score(X_test, y_test)
print('Accuracy:', score*100)
