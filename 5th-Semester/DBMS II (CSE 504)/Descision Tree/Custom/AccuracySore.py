def accuracy_score(y_true, y_pred):
    """
    Compute the accuracy of a classification model on a test set.

    Parameters:
    y_true (array-like): The true labels for the test set.
    y_pred (array-like): The predicted labels for the test set.

    Returns:
    float: The accuracy score.
    """

    correct = 0
    total = len(y_true)

    for i in range(total):
        if y_true[i] == y_pred[i]:
            correct += 1

    accuracy = correct / total

    return accuracy
