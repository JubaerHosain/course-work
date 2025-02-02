#include<bits/stdc++.h>
using namespace std;

struct Node {
    vector<int> point;
    Node *left, *right;
    Node(int k, vector<int> &array) {
        point.resize(k);
        left = right = NULL;
        for(int i = 0; i < k; i++)
            point[i] = array[i];
    }
};

// ================= Utilities ====================
void print(vector<int> &a, string sep = "\n") {
    int n = a.size();
    for (int i = 0; i < n; i++) {
        if(i == 0)
            cout << "{";

        cout << a[i];

        if(i < n-1)
            cout << ", ";
        if(i == n-1)
            cout << "}";
    }
    cout << sep;
}

bool is_equal(vector<int> &point1, vector<int> &point2) {
    for(int i = 0; i < point1.size(); i++) {
        if(point1[i] != point2[i])
            return false;
    }
    return true;
} 

// ================= Insert a Point ====================

Node* insert_node(Node *root, vector<int> &point, int k, int cd = 0) {
    if(root == NULL) {
        return new Node(k, point);
    }

    if(point[cd] < root->point[cd])
        root->left = insert_node(root->left, point, k, (cd+1)%k);
    else 
        root->right = insert_node(root->right, point, k, (cd+1)%k);

    return root;
}

// ================= Search a Point ====================

bool search(Node *root, vector<int> &point, int k, int cd) {
    if(root == NULL)
        return false;
    else if(is_equal(root->point, point)) 
        return true;

    if(point[cd] < root->point[cd])
        return search(root->left, point, k, (cd+1)%k);
    else 
        return search(root->right, point, k, (cd+1)%k);
}

// ================ Nearest Neighbour =================

//  This is distance squared - square root is NOT calculated
int dist_squared(vector<int> &a, vector<int> &b) {
    int dist = 0;
    for(int i = 0; i < a.size(); i++) {
        dist += pow(abs(a[i]-b[i]), 2);
    }
    return dist;
}

Node* find_closest(Node *a, Node *b, vector<int> &target) {
    if(a == NULL)
        return b;
    else if(b == NULL)
        return a;
    
    int d1 = dist_squared(a->point, target);
    int d2 = dist_squared(b->point, target);

    return d1 < d2 ? a : b;
}

Node* nearest_neighbour(Node *root, vector<int> target, int k, int cd = 0) {
    if(root == NULL)
        return NULL;

    Node *next, *other;
    if(target[cd] < root->point[cd]) {
        next = root->left;
        other = root->right;
    } else {
        next = root->right;
        other = root->left;
    }

    Node *temp = nearest_neighbour(next, target, k, (cd+1)%k);
    Node *best = find_closest(temp, root, target);

    int radius = dist_squared(best->point, target);

    /*
    We may need to check the other side of the tree. 
    If the other side is closer than the radius,
	then we must recurse to the other side as well.
    */
    int dist = pow(abs(root->point[cd]-target[cd]), 2);

    if(dist <= radius) {
        temp = nearest_neighbour(other, target, k, (cd+1)%k);
        best = find_closest(best, temp, target);
    }

    return best;
}

// ============ Find Minimum On Given Dimension ============

vector<int> min(vector<int> a, vector<int> b, int d) {
    return a[d] < b[d] ? a : b;
}

vector<int> find_min(Node *root, int k, int d, int cd = 0) {
    if(root == NULL) {
        vector<int> temp;
        for(int i = 0; i < k; i++)
            temp.push_back(INT_MAX);
        return temp;
    }

    if(cd == d) {
        if(root->left == NULL) 
            return root->point; 
        // min of root and left min
        return min(root->point, find_min(root->left, k, d, (cd+1)%k), d);
       
    }

    // min of root, left min, right min
    vector<int> temp1 = find_min(root->left, k, (cd+1)%k, d);
    vector<int> temp2 = find_min(root->right, k, (cd+1)%k, d);
    return min(root->point, min(temp1, temp2, d), d);
}

// ================= Delete a Point ====================

Node *delete_node(Node *root, vector<int> target, int k, int cd = 0) {
    if(root == NULL)
        return NULL;
    else if(is_equal(root->point, target)) {
        if(root->right != NULL) {
            // last parameter should 0 or cd ?? [0 in gfg]
            root->point = find_min(root->right, k, cd, 0);
            root->right = delete_node(root->right, root->point, k, (cd+1)%k);
        } else if(root->left != NULL) {
            root->point = find_min(root->left, k, cd, 0);
            root->right = delete_node(root->left, target, k, (cd+1)%k);
        } else {
            delete root;
            return NULL;
        }
        return root;
    }

    if(target[cd] < root->point[cd])
        root->left = delete_node(root->left, target, k, (cd+1)%k);
    else 
        root->right = delete_node(root->right, target, k, (cd+1)%k);

    return root;
}


int main(void) {
    int k = 2;
    Node *root = NULL;

    // vector<vector<int>> points = {{3, 6}, {17, 15}, {13, 15}, {6, 12},
    //                    {9, 1}, {2, 7}, {10, 19}};
     
    vector<vector<int>> points = { { 30, 40 }, { 5, 25 },
       { 70, 70 }, { 10, 12 }, { 50, 30 }, { 35, 45 } };
    
   
    for (int i = 0; i < points.size(); i++)
       root = insert_node(root, points[i], k);

    vector<int> a = find_min(root, k, 0);
    print(a);

    vector<int> b = find_min(root, k, 1);
    print(b);

    vector<int> c = nearest_neighbour(root, {4, 400}, k)->point;
    print(c);

    root = delete_node(root, {30, 40}, k);
    print(root->point);

    return 0;
}

