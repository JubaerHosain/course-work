import numpy as np

class GaussianNB:
    def __init__(self):
        self.classes = None
        self.class_prob = None
        self.mean = None
        self.var = None

    def fit(self, X, y):
        self.classes = np.unique(y)
        n_classes = len(self.classes)
        n_features = X.shape[1]
        
        # Initialize parameters
        self.class_prob = np.zeros(n_classes)
        self.mean = np.zeros((n_classes, n_features))
        self.var = np.zeros((n_classes, n_features))

        # Compute mean, variance, and class probabilities for each class
        for i, c in enumerate(self.classes):
            X_c = X[y == c]
            self.class_prob[i] = X_c.shape[0] / X.shape[0]
            self.mean[i, :] = X_c.mean(axis=0)
            self.var[i, :] = X_c.var(axis=0)

    def predict(self, X):
        # Calculate log-likelihood for each class
        log_likelihood = np.zeros((X.shape[0], len(self.classes)))
        for i, c in enumerate(self.classes):
            mean = self.mean[i, :]
            var = self.var[i, :]
            log_likelihood[:, i] = self._logpdf(X, mean, var) + np.log(self.class_prob[i])

        # Predict class with highest log-likelihood
        y_pred = self.classes[np.argmax(log_likelihood, axis=1)]
        return y_pred

    def _logpdf(self, X, mean, var):
        # Compute log-pdf of Gaussian distribution
        exponent = -0.5 * ((X - mean) ** 2 / (var + 1e-9))
        logpdf = np.sum(np.log(1 / np.sqrt(2 * np.pi * var + 1e-9)) + exponent, axis=1)
        return logpdf
