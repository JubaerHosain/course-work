import numpy
import cv2

import time
start_time = time.time()

# probability of P(C|S)
skin_color_ratio = numpy.full((256, 256, 256), 0.0, dtype=float)

# probability of P(C|NS)
non_skin_color_ratio = numpy.full((256, 256, 256), 0.0, dtype=float)

# Count of Skin Colors
skin_rgb_count = numpy.full((256, 256, 256), 0, dtype=int)

# Count of Non-Skin Colors
non_skin_rgb_count = numpy.full((256, 256, 256), 0, dtype=int)

# P(C|S) /  P(C|NS)
color_ratio = numpy.full((256, 256, 256), 0.0, dtype=float)

skin_cnt = 0
non_skin_cnt = 0
total_images = 555

for index in range(total_images):
    filename = "%04d" % index
    mask_image = cv2.imread("ibtd/mask/" + filename + ".bmp")
    actual_image = cv2.imread("ibtd/" + filename + ".jpg")

    height, width, channel = mask_image.shape

    for x in range(height):
        for y in range(width):
            # why this order ?
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

    print("Image ", index+1, "- DONE!")
    

fp = open('output.txt', 'w')
for r in range(256):
    for g in range(256):
        for b in range(256):
            skin_color_ratio[r, g, b] = skin_rgb_count[r, g, b] / skin_cnt
            non_skin_color_ratio[r, g, b] = non_skin_rgb_count[r, g, b] / non_skin_cnt

            if non_skin_rgb_count[r, g, b] == 0:
                color_ratio[r, g, b] = skin_color_ratio[r, g, b]
            else:
                color_ratio[r, g, b] = skin_color_ratio[r, g, b] / non_skin_color_ratio[r, g, b]

            tmp = color_ratio[r, g, b]
            fp.write(f"{tmp}\n")

fp.close()

print("--- %s seconds ---" % (time.time() - start_time))