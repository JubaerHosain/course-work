import numpy
import imageio.v2 as imageio
import matplotlib.pyplot as plt


# skin = positive
# non skin = negative
T = 0.4
predictions = []
TP, TN, FP, FN = 0, 0, 0, 0



def equal(l1, l2):
    return list(l1) == l2



def test(test_image_names, trained_data):
    global predictions
    TP, TN, FP, FN = 0, 0, 0, 0
    for name in test_image_names:
        new_mask = imageio.imread(f"ibtd/{name}.jpg")
        height, width, channel = new_mask.shape
        for x in range(height):
            for y in range(width):
                red = new_mask[x, y, 0]
                green = new_mask[x, y, 1]
                blue = new_mask[x, y, 2]
                if trained_data[red, green, blue] <= T:
                    # image without skin is covered with WHITE
                    new_mask[x, y, 0] = 255
                    new_mask[x, y, 1] = 255
                    new_mask[x, y, 2] = 255
        plt.imsave(f"output/mask/{name}.jpg", new_mask)
        
        #calculate predictions
        original_mask = imageio.imread(f"ibtd/mask/{name}.bmp")
        for x in range(height):
            for y in range(width):
                if equal(original_mask[x, y], [255, 255, 255]):
                    if equal(new_mask[x, y], [255, 255, 255]):
                        TP += 1
                    else:
                        FN += 1
                else:
                    if equal(new_mask[x, y], [255, 255, 255]):
                        FP += 1
                    else:
                        TN += 1
    predictions.append((TN + TP) / (TN + TP + FP + FN))

    

def read_image_names(test_no):
    fp = open("output/images%04d.txt" % test_no, "r")
    test_image_names = fp.readlines()
    fp.close()
    return test_image_names



def read_trained_data(test_no):
    trained_data = numpy.zeros(shape=(256, 256, 256), dtype=float)
    fp = open("output/trained_data%04d.txt" % test_no, "r")
    for r in range(256):
        for g in range(256):
            for b in range(256):
                val = fp.readline()
                try:
                    trained_data[r, g, b] = float(val)
                except:
                    print(f"error - {val}")
    fp.close()
    return trained_data



if __name__ == '__main__':
    total_test = 1
    for i in range(total_test):
        print(f"Test - {i+1} is running")
        test_image_names = read_image_names(i)
        test_image_names = map(lambda x: x[0:-1], test_image_names)
        trained_data = read_trained_data(i)
        test(test_image_names, trained_data)
        print(f"Test - {i+1} is completed!")
    print(predictions)

