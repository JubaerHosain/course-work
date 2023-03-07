# Custom decision tree based on Entropy for [Continuous data]
import numpy as np

class DecisionTreeClassifier:
    def __init__(self, criterion='entropy', random_state=100, max_depth=3, min_samples_leaf=5):
        self.criterion = criterion
        self.random_state = random_state
        self.max_depth = max_depth
        self.min_samples_leaf = min_samples_leaf
        self.tree_ = None
        
    def fit(self, X, y):
        self.classes_ = np.unique(y)
        self.n_classes_ = len(self.classes_)
        self.n_features_ = X.shape[1]
        rng = np.random.RandomState(self.random_state)
        self.tree_ = self._build_tree(X, y, depth=0, rng=rng)
        
    def predict(self, X):
        return np.array([self._predict_tree(x, self.tree_) for x in X])
        
    def _build_tree(self, X, y, depth, rng):
        n_samples, n_features = X.shape
        
        # stopping criteria
        if depth >= self.max_depth or n_samples < 2*self.min_samples_leaf:
            return self._make_leaf_node(y)
        
        # select random subset of features
        feature_indices = rng.choice(range(n_features), size=int(np.sqrt(n_features)), replace=False)
        # find best feature to split on
        best_feature, best_threshold = self._find_best_split(X, y, feature_indices)
        
        # stopping criteria
        if best_feature is None:
            return self._make_leaf_node(y)
        
        # split data
        left_indices = X[:,best_feature] < best_threshold
        right_indices = ~left_indices
        
        # build child nodes
        left_tree = self._build_tree(X[left_indices,:], y[left_indices], depth+1, rng)
        right_tree = self._build_tree(X[right_indices,:], y[right_indices], depth+1, rng)
        
        # create internal node
        node = {'feature': best_feature, 'threshold': best_threshold,
                'left': left_tree, 'right': right_tree, 'leaf': False}
        
        return node
        
    def _find_best_split(self, X, y, feature_indices):
        best_feature, best_threshold, best_score = None, None, -np.inf
        for feature in feature_indices:
            feature_values = X[:,feature]
            thresholds = np.unique(feature_values)
            for threshold in thresholds:
                score = self._evaluate_split(X, y, feature, threshold)
                if score > best_score:
                    best_feature, best_threshold, best_score = feature, threshold, score
        return best_feature, best_threshold
        
    def _evaluate_split(self, X, y, feature, threshold):
        left_indices = X[:,feature] < threshold
        right_indices = ~left_indices
        n_left, n_right = left_indices.sum(), right_indices.sum()
        if n_left == 0 or n_right == 0:
            return -np.inf
        score_left = self._score_subset(y[left_indices])
        score_right = self._score_subset(y[right_indices])
        score = (n_left*score_left + n_right*score_right) / (n_left + n_right)
        return score
            
    def _score_subset(self, y):
        if self.criterion == 'entropy':
            p = np.array([(y == c).mean() for c in self.classes_])
            score = -np.sum(p*np.log2(p + 1e-10))
        elif self.criterion == 'gini':
            p = np.array([(y == c).mean() for c in self.classes_])
            score = 1 - np.sum(p**2)
        elif self.criterion == 'misclassification':
            p = np.array([(y == c).mean() for c in self.classes_])
            score = 1 - np.max(p)
        else:
            raise ValueError("Invalid criterion '%s'. Must be one of 'entropy', 'gini', or 'misclassification'." % self.criterion)
        return score

    def _make_leaf_node(self, y):
        class_counts = np.array([(y == c).sum() for c in self.classes_])
        class_probabilities = class_counts / class_counts.sum()
        return {'leaf': True, 'probs': class_probabilities}

    def _predict_tree(self, x, tree):
        if tree['leaf']:
            return self.classes_[np.argmax(tree['probs'])]
        else:
            if x[tree['feature']] < tree['threshold']:
                return self._predict_tree(x, tree['left'])
            else:
                return self._predict_tree(x, tree['right'])


