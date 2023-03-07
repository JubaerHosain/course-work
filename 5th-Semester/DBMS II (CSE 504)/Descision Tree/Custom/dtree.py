# dataset url: 'https://archive.ics.uci.edu/ml/machine-learning-databases/balance-scale/balance-scale.data'

# For categorical variables [color, gender, pet...]

# Importing the required packages
import pandas as pd
from sklearn.metrics import confusion_matrix
from sklearn.model_selection import train_test_split
from MyDecisionTree import DecisionTreeClassifier
from AccuracySore import accuracy_score
from sklearn.metrics import classification_report


# Function importing dataset
def import_data():
    data_url = 'balance-scale.data'
    balance_data = pd.read_csv(data_url, sep=',', header=None)

    # Printing the dataset shape
    print("Dataset Shape: ", balance_data.shape)

    # Printing the dataset observations
    print("Top five rows from the Dataset:")
    print(balance_data.head())
    print()
    return balance_data


# Function to split the dataset
def split_dataset(balance_data):
    # Separating the target variable/attribute
    X = balance_data.values[:, 1:5]
    Y = balance_data.values[:, 0]

    # Splitting the dataset into train and test
    X_train, X_test, y_train, y_test = train_test_split(X, Y, test_size=0.3, random_state=100)

    return X, Y, X_train, X_test, y_train, y_test


# Function to perform training with giniIndex.
def train_using_gini(X_train, y_train):
    # Creating the classifier object
    gini_classifier = DecisionTreeClassifier(
        criterion="gini", random_state=100, max_depth=3, min_samples_leaf=5)

    # Performing training
    gini_classifier.fit(X_train, y_train)

    return gini_classifier


# Function to perform training with entropy.
def train_using_entropy(X_train, y_train):
    # Decision tree with entropy
    entropy_classifier = DecisionTreeClassifier(
        criterion="entropy", random_state=100, max_depth=3, min_samples_leaf=5)

    # Performing training
    entropy_classifier.fit(X_train, y_train)

    return entropy_classifier


# Function to make predictions
def prediction(X_test, classifier_object):
    # Prediction on test with classifier
    y_prediction = classifier_object.predict(X_test)

    # print("Predicted values:")
    # print(y_prediction)

    return y_prediction


# Function to calculate accuracy
def calculate_accuracy(y_test, y_prediction):
    print("Confusion Matrix: ")
    print(confusion_matrix(y_test, y_prediction))

    print("Accuracy: ", accuracy_score(y_test, y_prediction) * 100)

    # print("Report: ")
    # print(classification_report(y_test, y_prediction))


# Driver function
def decision_tree():
    # =================Building phase=================

    # Importing dataset
    balance_data = import_data()

    # Split dataset
    X, Y, X_train, X_test, y_train, y_test = split_dataset(balance_data)

    # Train Using Gini classifier
    gini_classifier = train_using_gini(X_train, y_train)

    # Train Using Entropy classifier
    entropy_classifier = train_using_entropy(X_train, y_train)

    # =================Operational Phase=================

    print("=================Results Using Gini Index=================")
    # Prediction using gini
    gini_y_prediction = prediction(X_test, gini_classifier)
    calculate_accuracy(y_test, gini_y_prediction)

    print("=================Results Using Entropy=================")
    # Prediction using entropy
    entropy_y_prediction = prediction(X_test, entropy_classifier)
    calculate_accuracy(y_test, entropy_y_prediction)


# Calling driver function
if __name__ == "__main__":
    decision_tree()
