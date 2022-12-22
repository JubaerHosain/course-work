import numpy
import cv2
import random
import time



# train a model
def train(filenames):
    # Count of Skin Colors
    skin_rgb_count = numpy.full((256, 256, 256), 0, dtype=int)
    # Count of Non-Skin Colors
    non_skin_rgb_count = numpy.full((256, 256, 256), 0, dtype=int)
    skin_cnt = 0
    non_skin_cnt = 0
    
    for filename in filenames:
        mask_image = cv2.imread("ibtd/mask/" + filename + ".bmp")
        actual_image = cv2.imread("ibtd/" + filename + ".jpg")
        height, width, channel = mask_image.shape
        for x in range(height):
            for y in range(width):
                # why this order? bcz open-cv mode is BGR 
                blue = mask_image[x, y, 0]
                green = mask_image[x, y, 1]
                red = mask_image[x, y, 2]
                # means it's NON-SKIN
                if blue > 250 and green > 250 and red > 250:  
                    blue = actual_image[x, y, 0]
                    green = actual_image[x, y, 1]
                    red = actual_image[x, y, 2]
                    non_skin_rgb_count[red, green, blue] += 1
                    non_skin_cnt += 1
                else:
                    skin_rgb_count[red, green, blue] += 1
                    skin_cnt += 1
    
    # P(C|S) /  P(C|NS)
    color_ratio = numpy.full((256, 256, 256), 0.0, dtype=float)
    
    for r in range(256):
        for g in range(256):
            for b in range(256):
                # probability of P(C|S)
                skin_ratio = skin_rgb_count[r, g, b] / skin_cnt
                # probability of P(C|NS)
                non_skin_ratio = non_skin_rgb_count[r, g, b] / non_skin_cnt
                if non_skin_ratio == 0:
                    color_ratio[r, g, b] = skin_ratio
                else:
                    color_ratio[r, g, b] = skin_ratio / non_skin_ratio
                    
    return color_ratio

         
                
# store trained data 
def write_trained_data(filename, content):
    fp = open(filename, 'w')
    for r in range(256):    
        for g in range(256):    
            for b in range(256):    
                fp.write(f"{content[r, g, b]}\n")
    fp.close()
    
    
  
# store test image names for corresponding train
def write_image_names(filename, content):
    fp = open(filename, 'w')
    for c in content:
        fp.write(f"{c}\n")
    fp.close()
    
    

if __name__ == '__main__':
    total_image = 555
    filenames = ["%04d"%i for i in range(total_image)]
    
    # 90% for training and 10% for testing
    total_training = 1
    no_of_image_to_train = 500
    
    start = time.time()
    for i in range(total_training):
        random.shuffle(filenames)
        print(f"Training - {i+1} is running...")
        trained_data = train(filenames[:no_of_image_to_train])
        write_trained_data("output/trained_data%04d.txt"%i, trained_data)
        write_image_names("output/images%04d.txt"%i, filenames[no_of_image_to_train:])
        print(f"Training - {i+1} is completed!")
    
    end = time.time()
    print("Done!")
    print(f"Total time needed: {end-start}s")