package scala.meta.contrib.prettyprinters

sealed abstract class ScalacCompilerPhase(val name: String)

case object Parser extends ScalacCompilerPhase("parser")
case object Namer extends ScalacCompilerPhase("namer")
case object PackageObjects extends ScalacCompilerPhase("packageobjects")
case object Typer extends ScalacCompilerPhase("typer")
case object PatMat extends ScalacCompilerPhase("patmat")
case object SuperAccessor extends ScalacCompilerPhase("superaccessors")
case object ExtMethods extends ScalacCompilerPhase("extmethods")
case object Pickler extends ScalacCompilerPhase("pickler")
case object RefChecks extends ScalacCompilerPhase("refchecks")
case object SelectiveANF extends ScalacCompilerPhase("selectiveanf")
case object SelectiveCPS extends ScalacCompilerPhase("selectivecps")
case object Uncurry extends ScalacCompilerPhase("uncurry")
case object TailCalls extends ScalacCompilerPhase("tailcalls")
case object Specialize extends ScalacCompilerPhase("specialize")
case object ExplicitOuter extends ScalacCompilerPhase("explicitouter")
case object Erasure extends ScalacCompilerPhase("erasure")
case object PostErasure extends ScalacCompilerPhase("posterasure")
case object LazyVals extends ScalacCompilerPhase("lazyvals")
case object LambdaLift extends ScalacCompilerPhase("lambdalift")
case object Constructors extends ScalacCompilerPhase("contructors")
case object Flatten extends ScalacCompilerPhase("flatten")
case object Mixin extends ScalacCompilerPhase("mixin")
case object Cleanup extends ScalacCompilerPhase("cleanup")
case object Icode extends ScalacCompilerPhase("icode")
case object Inliner extends ScalacCompilerPhase("inliner")
case object InlineExceptionHandlers extends ScalacCompilerPhase("inlineExceptionHandlers")
case object CloseLim extends ScalacCompilerPhase("closelim")
case object Dce extends ScalacCompilerPhase("dce")
case object Jvm extends ScalacCompilerPhase("jvm")
case object Terminal extends ScalacCompilerPhase("terminal")




