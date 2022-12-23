
def apriori(data, min_support):
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

    # Remove item sets with support less than the minimum support threshold
    frequent_item_sets = set()
    for item_set, count in support_counts.items():
        if count >= min_support:
            frequent_item_sets.add(item_set)

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
        temp_frequent_item_sets = set()
        for item_set, count in support_counts.items():
            if count >= min_support:
                temp_frequent_item_sets.add(item_set)

        # break if there are no item sets left
        if len(temp_frequent_item_sets) == 0:
            break

        k += 1
        # Otherwise, add the temp_frequent_item_sets to the frequent_item_sets list
        frequent_item_sets = temp_frequent_item_sets

    return frequent_item_sets


if __name__ == "__main__":
    # data = [
    #     ['bread', 'milk'],
    #     ['bread', 'diaper', 'beer', 'eggs'],
    #     ['milk', 'diaper', 'beer', 'cola'],
    #     ['bread', 'milk', 'diaper', 'beer'],
    #     ['bread', 'milk', 'diaper', 'cola']
    # ]

    transactions = [
        ["i1", "i2", "i5"],
        ["i2", "i4"],
        ["i2", "i3"],
        ["i1", "i2", "i4"],
        ["i1", "i3"],
        ["i2", "i3"],
        ["i1", "i3"],
        ["i1", "i2", "i3", "i5"],
        ["i1", "i2", "i3"]
    ]

    frequent_item_sets = apriori(transactions, min_support=2)
    print(frequent_item_sets)
