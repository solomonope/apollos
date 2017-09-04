package org.appollos.filter.spatial

import breeze.linalg.DenseMatrix
import breeze.signal.convolve
import org.appollos.core.Image

import scala.reflect.ClassTag

object Canny {

  val cannKernel = new DenseMatrix[Double](3, 3);

  def apply[T: ClassTag](image: Image[T]): Image[T] = {

    return image;
  }
}
