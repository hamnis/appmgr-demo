organization := "net.hamnaberg.appmgr"

name := "appmgr-demo"

autoScalaLibrary := false

crossPaths := false

appmgrSettings

packageBin in Compile <<= appmgrBuild

appmgrLauncher in Appmgr := None

licenses += ("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0.html"))

bintrayPublishSettings

publishArtifact in Test := false

publishArtifact in (Compile, packageDoc) := false

publishArtifact in (Compile, packageSrc) := false

artifact in (Compile, packageBin) ~= { (art: Artifact) =>
  art.copy(`type` = "pom", extension = "zip")
}
