import numpy as np

class RandomForestClassifierScratch:
    def __init__(self, n_estimators=100, max_features=None, max_depth=None, random_state=None):
        self.n_estimators = n_estimators
        self.max_features = max_features
        self.max_depth = max_depth
        self.random_state = random_state
        self.estimators = []
        
    def fit(self, X, y):
        np.random.seed(self.random_state)
        n_samples, n_features = X.shape
        
        # Determine the number of features to use for each tree
        if self.max_features is None:
            self.max_features = int(np.sqrt(n_features))
            
        for i in range(self.n_estimators):
            # Randomly select the features to use for this tree
            feature_indices = np.random.choice(n_features, self.max_features, replace=False)
            X_subset = X[:, feature_indices]
            
            # Randomly select the samples to use for this tree
            sample_indices = np.random.choice(n_samples, n_samples, replace=True)
            X_subset = X_subset[sample_indices, :]
            y_subset = y[sample_indices]
            
            # Train a decision tree on the selected features and samples
            tree = self.build_tree(X_subset, y_subset, max_depth=self.max_depth)
            
            # Add the trained tree to the list of estimators
            self.estimators.append((feature_indices, sample_indices, tree))
            
    def build_tree(self, X, y, max_depth=None):
        n_samples, n_features = X.shape
        
        if max_depth is None:
            max_depth = float("inf")
        
        if n_samples == 0 or max_depth == 0:
            return self.Leaf(y)
        
        if self.is_pure(y):
            return self.Leaf(y)
        
        feature_indices = np.random.choice(n_features, self.max_features, replace=False)
        best_feature, best_threshold = self.get_best_split(X, y, feature_indices)
        
        if best_feature is None:
            return self.Leaf(y)
        
        left_indices = X[:, best_feature] < best_threshold
        right_indices = X[:, best_feature] >= best_threshold
        
        left_subtree = self.build_tree(X[left_indices, :], y[left_indices], max_depth=max_depth-1)
        right_subtree = self.build_tree(X[right_indices, :], y[right_indices], max_depth=max_depth-1)
        
        return self.DecisionNode(best_feature, best_threshold, left_subtree, right_subtree)
    
    def get_best_split(self, X, y, feature_indices):
        best_gain = -float("inf")
        split_index, split_threshold = None, None
        
        for feature_index in feature_indices:
            feature_values = X[:, feature_index]
            thresholds = np.unique(feature_values)
            
            for threshold in thresholds:
                gain = self.get_information_gain(X, y, feature_index, threshold)
                
                if gain > best_gain:
                    best_gain = gain
                    split_index = feature_index
                    split_threshold = threshold
        
        return split_index, split_threshold
    
    def get_information_gain(self, X, y, feature_index, threshold):
        parent_entropy = self.calculate_entropy(y)
        
        left_indices = X[:, feature_index] < threshold
        left_entropy = self.calculate_entropy(y[left_indices])
        left_weight = np.sum(left_indices) / len(y)
        
        right_indices = X[:, feature_index] >= threshold
        right_entropy = self.calculate_entropy(y[right_indices])
        right_weight = np
