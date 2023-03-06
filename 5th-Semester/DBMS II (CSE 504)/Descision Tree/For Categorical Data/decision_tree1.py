# For categorical variables [color, gender, pet...]

# Import the necessary libraries
import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.tree import DecisionTreeClassifier
from sklearn.metrics import accuracy_score
from sklearn.metrics import confusion_matrix
from sklearn.preprocessing import LabelEncoder


# Function importing dataset
def import_data():
    data_url = 'play-tennis.data'
    tennis_data = pd.read_csv(data_url, sep=',')
    
    # Printing the dataset shape
    print("Dataset Shape: ", tennis_data.shape)

    # Printing the dataset observations
    print("Top five rows from the Dataset:")
    print(tennis_data.head())
    print()
    return tennis_data


# Convert categorical features to numeric labels
def encode_labels(data):
    label_dict = {}
    le = LabelEncoder()
    for column in data.columns:
        data[column] = le.fit_transform(data[column])
        label_dict[column] = dict(zip(le.classes_, le.transform(le.classes_)))
        
    return label_dict


# Function to split the dataset
def split_dataset(data):
    # Separating the target variable/attribute
    X = data.values[:, 1:5]
    Y = data.values[:, -1]
    
    # Splitting the dataset into train and test
    X_train, X_test, Y_train, Y_test = train_test_split(X, Y, test_size=0.3, random_state=100)

    return X, Y, X_train, X_test, Y_train, Y_test

# Function to perform training with entropy.
def train_using_entropy(X_train, Y_train):
    # Decision tree with entropy
    entropy_classifier = DecisionTreeClassifier(criterion="entropy", random_state=100)

    # Performing training
    entropy_classifier.fit(X_train, Y_train)

    return entropy_classifier


# Function to make predictions
def prediction(X_test, classifier_object):
    # Prediction on test with classifier
    Y_predictions = classifier_object.predict(X_test)

    return Y_predictions

# Function to calculate accuracy
def calculate_accuracy(T_test, Y_predictions):
    print("Confusion Matrix: ")
    print(confusion_matrix(T_test,Y_predictions))

    print("Accuracy: ", accuracy_score(Y_test, Y_predictions) * 100)

    # print("Report: ")
    # print(classification_report(y_test, y_prediction))



def decode(label_dict, custom_prediction):
    # search for the key
    for key, value in label_dict["PlayTennis"].items():
        if value == custom_prediction[0]:
            return key



if __name__ == "__main__":
    # import data
    tennis_data = import_data() 
    
    # encode labels
    label_dict = encode_labels(tennis_data)
    
    # split data
    X, Y, X_train, X_test, Y_train, Y_test = split_dataset(tennis_data)
    
    # train
    dtree = train_using_entropy(X_train, Y_train)
    
    # predict
    Y_predictions = prediction(X_test, dtree)
    
    # accuracy
    calculate_accuracy(Y_test, Y_predictions)
    
    # ===================custom test===================
    test_data = [
        [
            label_dict["Outlook"]['Sunny'], 
            label_dict["Temperature"]['Hot'], 
            label_dict["Humidity"]['High'], 
            label_dict["Wind"]['Weak']
        ]
    ]
    
    print("Custom input:", ['Sunny', 'Hot', 'High', 'Weak'], sep=" ")
    
    # predict
    custom_prediction = prediction(test_data, dtree)
    
    print("Custom prediction:", decode(label_dict, custom_prediction),  sep=" ")