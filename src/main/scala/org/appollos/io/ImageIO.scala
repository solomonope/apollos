package org.appollos.io

import java.awt.image.{BufferedImage, Raster}
import java.io.File

import breeze.plot._
import org.appollos.core.Image
import org.appollos.exposure.{Gamma, Inverse, Log}


object ImageIO {

  def read(filePath: String): Image[_] = {
    val bufferedImage: BufferedImage = javax.imageio.ImageIO.read(new File(filePath));


    val image = Image[Double](bufferedImage.getWidth, bufferedImage.getHeight());
    val raster: Raster = bufferedImage.getData();
    for (i <- 0 until bufferedImage.getHeight()) {
      for (j <- 0 until bufferedImage.getWidth) {
        val v: Array[Int] = raster.getPixel(j, i, null);
        image(j, i, v(0).toDouble);
      }
    }
    return image;
  }

  def write(filePath: String, image: Image[_]): Unit = {


  }

  def main(args: Array[String]): Unit = {
    val img: Image[Double] = ImageIO.read("/Users/s.folorunsho/lab/101_ObjectCategories/nautilus/image_0001.jpg").asInstanceOf[Image[Double]]

    var imx = Inverse[Double](img);
    var gamma = Gamma[Double](img, 0.75);
    var log = Log[Double](img);
    var t: Thread = new Thread(() => {
      val f2 = Figure("MM")
      f2.subplot(0) += breeze.plot.image(gamma(0));
      //f2.subplot(0) += breeze.plot.image(img(0));
    })
    var t2: Thread = new Thread(() => {
      val f2 = Figure("Original")
      f2.subplot(0) += breeze.plot.image(img(0));
      //f2.subplot(0) += breeze.plot.image(img(0));
    })
    t2.start();
    t.start();

  }
}
