package org.appollos.exposure

import breeze.linalg.{DenseMatrix, DenseVector, argmax, max}
import org.appollos.core.Image

import scala.reflect.ClassTag

object Gamma {


  def apply(img: Image, gamma: Double, k: Int = 1): Image = {
    val image = Image(img.width, img.height);
    val data = img(0);
    val maxIntensity = max(data)
    val L = math.pow(2, img.imageType.id) - 1;
    for (i <- 0 until img.height) {
      for (j <- 0 until img.width) {
        val norm = img(j, i) / maxIntensity;
        val t = Math.pow(k * norm, gamma) * L;
        image(j, i, t);
      }
    }
    return image;
  }

  def main(arg: Array[String]) = {
    println("Hello world")
  }

}
