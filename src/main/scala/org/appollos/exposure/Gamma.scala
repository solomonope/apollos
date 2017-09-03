package org.appollos.exposure

import breeze.linalg.{DenseMatrix, DenseVector, argmax, max}
import org.appollos.core.Image

import scala.reflect.ClassTag

object Gamma {


  def apply[T: ClassTag](img: Image[T], gamma: Double, k: Int = 1): Image[T] = {
    val image = Image[T](img.width, img.height);
    val data = img(0).asInstanceOf[DenseMatrix[Double]]
    var maxIntensity = max(data)
    for (i <- 0 until img.height) {
      for (j <- 0 until img.width) {
        var norm = img(j, i).asInstanceOf[Double] / maxIntensity;
        var t = k * Math.pow(norm, gamma);
        image(j, i, t.asInstanceOf[T]);

      }
    }
    return image;
  }

  def main(arg: Array[String]) = {
    println("Hello world")
  }

}
