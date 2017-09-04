package org.appollos.exposure

import org.appollos.core.Image

import scala.reflect.ClassTag


object Histogram {

  def apply[T: ClassTag](image: Image[T], bin: Int): Seq[T] = {
    val bins: Array[T] = new Array[T](bin);
    for (i <- 0 until image.height) {
      for (j <- 0 until image.width) {
        var ji = image(j, i);
      }
    }
    return bins;
  }
}
