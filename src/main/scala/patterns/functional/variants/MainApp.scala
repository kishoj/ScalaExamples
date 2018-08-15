package patterns.functional.variants

class Director
class Manager extends Director
class Staff extends Manager

class ContainerStaff[+T]
class ContainerManager[T]
class ContainerDirector[+T]

object MainApp {
  def method1(box:ContainerStaff[Manager]){}
  def method2(box:ContainerDirector[Manager]){}
  def method3(box:ContainerManager[Manager]){}

  def main(args: Array[String]): Unit = {
    /*covariance*/
    //method1(new ContainerStaff[Director]) //compile fails
    method1(new ContainerStaff[Manager])
    method1(new ContainerStaff[Staff])

    /*contravariance*/
    //method2(new ContainerDirector[Director]) //compile fails
    method2(new ContainerDirector[Manager])
    method2(new ContainerDirector[Staff])

    /*invariance*/
    //method3(new ContainerManager[Director]) //compile fails
    method3(new ContainerManager[Manager])
    //method3(new ContainerManager[Staff]) //compile fails
  }
}
