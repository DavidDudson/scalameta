package scala.meta.contrib.prettyprinters

import java.io.{ByteArrayOutputStream, PrintStream}

import scala.annotation.implicitNotFound
import scala.meta.prettyprinters.Show
import scala.reflect.internal.util.BatchSourceFile
import scala.tools.nsc._
import scala.meta._
import scala.meta.prettyprinters.Show.Str

@implicitNotFound(msg = "You should only use subtypes of compiler stage for implicit resolution")
sealed trait CompilerStage[A] extends Show[A]
object CompilerStage {
  def apply[T](f: T => Show.Result): CompilerStage[T] = new CompilerStage[T] {
    def apply(input: T): Show.Result = f(input)
  }

  implicit def compilerStage[T: Syntax]: CompilerStage[T] = CompilerStage { x =>
    Str(compileString(x.show[Syntax]))
  }

  val settings = new Settings(null)
  val classpath = sys.props("java.class.path").split(java.io.File.pathSeparatorChar).toList
  val plugins = classpath.map(jar => s"-Xplugin:$jar")
  settings.processArguments(plugins, processAll = true)
  settings.processArgumentString("-Xprint:jvm")
  settings.print.value = true
  classpath.foreach(settings.classpath.append)
  settings.Yreploutdir.value = ""

  val compiler = new Global(settings)
  val run = new compiler.Run()

  def compileString(code: String): String = {
    val byteArrayStream = new ByteArrayOutputStream()
    val stream = new PrintStream(byteArrayStream)
    Console.withOut(stream) {
      run.compileSources(new BatchSourceFile("<script>", code) :: Nil)
      if (compiler.reporter.hasErrors) {
        println("Errors: ")
        println(compiler.reporter.errorCount)
      }
    }

    byteArrayStream.toString.split("\n").tail.mkString("\n")
  }
}

object Main {
  def main(args: Array[String]): Unit = {
    println(CompilerStage.compileString("trait Foo"))
  }
}


