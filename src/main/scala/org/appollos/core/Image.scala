package org.appollos.core

import breeze.linalg.DenseMatrix;


class Image(private val channels: Int, val width: Int, val height: Int) {
  private val data: Seq[DenseMatrix[Int]] = new Array[DenseMatrix[Int]](channels);

  private def putPixel(channel: Int, x: Int, y: Int, value: Int): Unit = {
    data(channel)(x, y) = value;
  }

  private def getPixel(channel: Int, x: Int, y: Int): Int = {
    data(channel)(x, y);
  }
}
