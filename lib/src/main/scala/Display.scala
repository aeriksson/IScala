package org.refptr.iscala

import scala.annotation.implicitNotFound
import java.net.URL

trait Display[-T] {
    def mime: MIME
    def stringify(obj: T): String
}

@implicitNotFound(msg="Can't find Plain display type class for type ${T}.")
trait Plain[-T] extends Display[T] { val mime = MIME.`text/plain` }
@implicitNotFound(msg="Can't find HTML display type class for type ${T}.")
trait HTML[-T] extends Display[T] { val mime = MIME.`text/html` }
@implicitNotFound(msg="Can't find Markdown display type class for type ${T}.")
trait Markdown[-T] extends Display[T] { val mime = MIME.`text/markdown` }
@implicitNotFound(msg="Can't find Latex display type class for type ${T}.")
trait Latex[-T] extends Display[T] { val mime = MIME.`text/latex` }
@implicitNotFound(msg="Can't find JSON display type class for type ${T}.")
trait JSON[-T] extends Display[T] { val mime = MIME.`application/json` }
@implicitNotFound(msg="Can't find Javascript display type class for type ${T}.")
trait Javascript[-T] extends Display[T] { val mime = MIME.`application/javascript` }
@implicitNotFound(msg="Can't find SVG display type class for type ${T}.")
trait SVG[-T] extends Display[T] { val mime = MIME.`image/svg+xml` }
@implicitNotFound(msg="Can't find PNG display type class for type ${T}.")
trait PNG[-T] extends Display[T] { val mime = MIME.`image/png` }
@implicitNotFound(msg="Can't find JPEG display type class for type ${T}.")
trait JPEG[-T] extends Display[T] { val mime = MIME.`image/jpeg` }

object Plain {
    def apply[T](fn: T => String): Plain[T] = new Plain[T] {
        def stringify(obj: T) = fn(obj)
    }
}

object HTML {
    def apply[T](fn: T => String): HTML[T] = new HTML[T] {
        def stringify(obj: T) = fn(obj)
    }
}

object Markdown {
    def apply[T](fn: T => String): Markdown[T] = new Markdown[T] {
        def stringify(obj: T) = fn(obj)
    }
}

object Latex {
    def apply[T](fn: T => String): Latex[T] = new Latex[T] {
        def stringify(obj: T) = fn(obj)
    }
}

object JSON {
    def apply[T](fn: T => String): JSON[T] = new JSON[T] {
        def stringify(obj: T) = fn(obj)
    }
}

object Javascript {
    def apply[T](fn: T => String): Javascript[T] = new Javascript[T] {
        def stringify(obj: T) = fn(obj)
    }
}

object SVG {
    def apply[T](fn: T => String): SVG[T] = new SVG[T] {
        def stringify(obj: T) = fn(obj)
    }
}

object PNG {
    def apply[T](fn: T => String): PNG[T] = new PNG[T] {
        def stringify(obj: T) = fn(obj)
    }
}

object JPEG {
    def apply[T](fn: T => String): JPEG[T] = new JPEG[T] {
        def stringify(obj: T) = fn(obj)
    }
}

object Display {
    implicit val PlainAny    = Plain[Any](_.toString)
    implicit val HTMLNodeSeq = HTML[xml.NodeSeq](_.toString)
    implicit val LatexMath   = Latex[Math](_.toLatex)
    implicit val HTMLIFrame  = HTML[IFrame](_.toHTML)
}

trait DisplayObject {
    def toPlainOpt: Option[String] = None
    def toHTMLOpt: Option[String] = None
    def toMarkdownOpt: Option[String] = None
    def toLatexOpt: Option[String] = None
    def toJSONOpt: Option[String] = None
    def toJavascriptOpt: Option[String] = None
    def toSVGOpt: Option[String] = None
    def toPNGOpt: Option[String] = None
    def toJPEGOpt: Option[String] = None
}

trait HTMLDisplayObject extends DisplayObject {
    override def toHTMLOpt = Some(toHTML)
    def toHTML: String
}

trait LatexDisplayObject extends DisplayObject {
    override def toLatexOpt = Some(toLatex)
    def toLatex: String
}

case class Math(math: String) extends LatexDisplayObject {
    def toLatex = "$$" + math + "$$"
}

class IFrame(src: URL, width: Int, height: Int) extends HTMLDisplayObject {
    protected def iframe() =
        <iframe width={width.toString}
                height={height.toString}
                src={src.toString}
                frameborder="0"
                allowfullscreen="allowfullscreen"></iframe>

    def toHTML = iframe().toString
}

case class YouTubeVideo(id: String, width: Int=400, height: Int=300)
    extends IFrame(new URL("https", "www.youtube.com", s"/embed/$id"), width, height)

case class VimeoVideo(id: String, width: Int=400, height: Int=300)
    extends IFrame(new URL("https", "player.vimeo.com", s"/video/$id"), width, height)

case class ScribdDocument(id: String, width: Int=400, height: Int=300)
    extends IFrame(new URL("https", "www.scribd.com", s"/embeds/$id/content"), width, height)