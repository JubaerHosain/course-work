from collections import Counter


def apriori(data, min_support):
    """
        Args:
            data (list of list): all transactions
            min_support (int): 

        Returns:
            result, frequency: list[set(frozenset)], dict(frozenset)
    """

    # First, generate a list of all unique items in the data
    items = set()
    for transaction in data:
        for item in transaction:
            items.add(item)

    # Next, generate a list of all item sets of length 1
    item_sets = set()
    for item in items:
        item_sets.add(frozenset([item]))

    # Initialize a dictionary to store the support counts for each item set
    support_counts = {}

    # Iterate through each item set and count the support for each one
    for item_set in item_sets:
        support_counts[item_set] = 0
        for transaction in data:
            if item_set.issubset(transaction):
                support_counts[item_set] += 1

    # supports_count of all item sets of all length which fulfills min_support_count
    final_support_count = {}

    # Remove item sets with support less than the minimum support threshold
    frequent_item_sets = set()
    for item_set, count in support_counts.items():
        if count >= min_support:
            frequent_item_sets.add(item_set)
            final_support_count[item_set] = count

    # frequent item sets of all possible length (1 to ..possible)
    result = []
    result.append(frequent_item_sets)

    # Continue the process for item sets of length 2 and up
    k = 2
    while len(frequent_item_sets) > 0:
        # Generate a list of all item sets of length k
        item_sets = set()
        for item_set_1 in frequent_item_sets:
            for item_set_2 in frequent_item_sets:
                if item_set_1 != item_set_2:
                    item_set = item_set_1.union(item_set_2)
                    if len(item_set) == k:
                        item_sets.add(item_set)

        # Initialize a dictionary to store the support counts for each item set
        support_counts = {}

        # Iterate through each item set and count the support for each one
        for item_set in item_sets:
            support_counts[item_set] = 0
            for transaction in data:
                if item_set.issubset(transaction):
                    support_counts[item_set] += 1

        # Remove item sets with support less than the minimum support threshold
        frequent_item_sets = set()
        for item_set, count in support_counts.items():
            if count >= min_support:
                frequent_item_sets.add(item_set)
                final_support_count[item_set] = count

        # break if there are no item sets left fulfilling minimum support
        if len(frequent_item_sets) == 0:
            break

        k += 1
        # Otherwise, add the frequent_item_sets to the result
        result.append(frequent_item_sets)

    return result, final_support_count



def get_confidence(l1, l2, frequency):
    a = frozenset(l1)
    b = frozenset(l2)

    if(a not in frequency) or (b not in frequency):
        return 0

    return (frequency[a]/frequency[b])*100


if __name__ == "__main__":
    # read transsactions from input.txt
    transactions = list()
    with open("input.txt") as file:
        transactions = [line.rstrip().split() for line in file]

    # frequent item set of all possible length (1 to ..possible)
    result, final_support_count = apriori(transactions, min_support=2)

    for i in range(len(result)):
        print(f"Frequent item sets of length - {i+1}:")
        for item in result[i]:
            print(item)
        print()

    print("Support counts of all set which fulfills min_support condition: ")
    for item, count in final_support_count.items():
        print(item, ": ", count)
    print()

    # upore sobgula, niche lefter gula

    print("Confidence calculation: ") 
    print("Confidence of i1^i2 => i5:", round(get_confidence(["i1", "i2", "i5"], ["i1", "i2"], final_support_count), 2))
    print("Confidence of i1^i5 => i2:", round(get_confidence(["i1", "i2", "i5"], ["i1", "i5"], final_support_count), 2))
    print("Confidence of i2^i5 => i1:", round(get_confidence(["i1", "i2", "i5"], ["i2", "i5"], final_support_count), 2))
    print("Confidence of i1 => i2^i5:", round(get_confidence(["i1", "i2", "i5"], ["i1"], final_support_count), 2))
    print("Confidence of i2 => i1^i5:", round(get_confidence(["i1", "i2", "i5"], ["i2"], final_support_count), 2))
    print("Confidence of i5 => i1^i2:", round(get_confidence(["i1", "i2", "i5"], ["i5"], final_support_count), 2))
    


