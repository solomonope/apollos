package org.appollos.exposure

import org.appollos.core.Image

object Histogram {

  def apply(image: Image, bin: Int = 256): Seq[Int] = {
    val bins: Array[Int] = new Array[Int](bin);
    for (i <- 0 until image.height) {
      for (j <- 0 until image.width) {
        var index = ((image(j, i) * bin) / 256.0).toInt;
        bins(index) += 1;
      }
    }
    return bins;
  }
}
