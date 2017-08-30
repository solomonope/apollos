name := "apollos"

version := "1.0"

scalaVersion := "2.12.1"

libraryDependencies ++= Seq(
  "org.scalanlp" %% "breeze" % "0.13.2",

  "org.scalanlp" %% "breeze-natives" % "0.13.2",

  "org.scalanlp" %% "breeze-viz" % "0.13.2"

)

resolvers += "Typesafe" at "https://repo.typesafe.com/typesafe/releases/"
