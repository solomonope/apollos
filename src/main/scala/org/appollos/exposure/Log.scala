package org.appollos.exposure

import breeze.linalg.{max}
import org.appollos.core.Image

object Log {
  def apply(image: Image): Image = {
    val lImage: Image = Image(image.width, image.height);
    val k = {
      val L = 255;
      val data = image(0);
      val maxIntensity = max(data);
      (L - 1) / Math.log(1 + maxIntensity)
    }
    for (i <- 0 until image.height) {
      for (j <- 0 until image.width) {
        var t = k * Math.log(1 + image(j, i));
        lImage(j, i, t);
      }
    }
    return lImage;
  }

  def main(args: Array[String]): Unit = {
    print("Hello world");
  }
}
