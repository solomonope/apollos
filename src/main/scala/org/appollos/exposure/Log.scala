package org.appollos.exposure

import breeze.linalg.{DenseMatrix, max}
import org.appollos.core.Image
import spire.ClassTag


object Log {
  def apply[T: ClassTag](image: Image[T]): Image[T] = {
    val lImage: Image[T] = Image(image.width, image.height);
    val k = {
      var L = 255;
      val data = image(0).asInstanceOf[DenseMatrix[Double]]
      var maxIntensity = max(data);
      (L - 1) / Math.log(1 + maxIntensity)
    }
    for (i <- 0 until image.height) {
      for (j <- 0 until image.width) {
        var t = k * Math.log(1 + image(j, i).asInstanceOf[Double]);
        lImage(j, i, t.asInstanceOf[T]);
      }
    }
    return lImage;
  }

  def main(args: Array[String]): Unit = {
    print("Hello world");
  }
}
