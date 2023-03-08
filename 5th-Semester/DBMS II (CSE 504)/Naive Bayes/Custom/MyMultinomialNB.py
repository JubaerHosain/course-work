import numpy as np

class MultinomialNB:
    def __init__(self, alpha=1.0):
        self.alpha = alpha

    def fit(self, X, y):
        self.classes = np.unique(y)
        self.class_prob = np.zeros(len(self.classes))
        self.word_prob = []

        # Compute class probabilities
        for i, c in enumerate(self.classes):
            X_c = X[y == c]
            self.class_prob[i] = X_c.shape[0] / X.shape[0]

            # Compute word probabilities for class c
            count = X_c.sum(axis=0)
            total_count = count.sum()
            prob = (count + self.alpha) / (total_count + self.alpha * X.shape[1])
            self.word_prob.append(prob)

        self.word_prob = np.array(self.word_prob)

    def predict(self, X):
        y_pred = []
        for x in X:
            # Compute log-likelihood for each class
            log_likelihood = np.log(self.word_prob + 1e-8).dot(x) + np.log(self.class_prob + 1e-8)

            # Choose the class with the highest log-likelihood
            y_pred.append(self.classes[np.argmax(log_likelihood)])

        return y_pred
