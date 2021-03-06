package org.refptr.iscala
package widgets

sealed trait BorderStyle extends EnumType with SnakeCase
@enum object BorderStyle extends Enumerated[BorderStyle] {
    case object None extends BorderStyle
    case object Hidden extends BorderStyle
    case object Dotted extends BorderStyle
    case object Dashed extends BorderStyle
    case object Solid extends BorderStyle
    case object Double extends BorderStyle
    case object Groove extends BorderStyle
    case object Ridge extends BorderStyle
    case object Inset extends BorderStyle
    case object Outset extends BorderStyle
    case object Initial extends BorderStyle
    case object Inherit extends BorderStyle
}

sealed trait FontStyle extends EnumType with SnakeCase
@enum object FontStyle extends Enumerated[FontStyle] {
    case object Normal extends FontStyle
    case object Italic extends FontStyle
    case object Oblique extends FontStyle
    case object Initial extends FontStyle
    case object Inherit extends FontStyle
}

sealed trait FontWeight extends EnumType with SnakeCase
@enum object FontWeight extends Enumerated[FontWeight] {
    case object Normal extends FontWeight
    case object Bold extends FontWeight
    case object Bolder extends FontWeight
    case object Lighter extends FontWeight
    case object Initial extends FontWeight
    case object Inherit extends FontWeight
    case object `100` extends FontWeight
    case object `200` extends FontWeight
    case object `300` extends FontWeight
    case object `400` extends FontWeight
    case object `500` extends FontWeight
    case object `600` extends FontWeight
    case object `700` extends FontWeight
    case object `800` extends FontWeight
    case object `900` extends FontWeight
}

sealed trait ButtonStyle extends EnumType with SnakeCase
@enum object ButtonStyle extends Enumerated[ButtonStyle] {
    case object Primary extends ButtonStyle
    case object Success extends ButtonStyle
    case object Info extends ButtonStyle
    case object Warning extends ButtonStyle
    case object Danger extends ButtonStyle
}

sealed trait BoxStyle extends EnumType with SnakeCase
@enum object BoxStyle extends Enumerated[BoxStyle] {
    case object Success extends BoxStyle
    case object Info extends BoxStyle
    case object Warning extends BoxStyle
    case object Danger extends BoxStyle
}

sealed trait Orientation extends EnumType with SnakeCase
@enum object Orientation extends Enumerated[Orientation] {
    case object Horizontal extends Orientation
    case object Vertical extends Orientation
}

sealed trait Location extends EnumType with SnakeCase
@enum object Location extends Enumerated[Location] {
    case object Start extends Location
    case object Center extends Location
    case object End extends Location
    case object Baseline extends Location
    case object Stretch extends Location
}

sealed trait Overflow extends EnumType with SnakeCase
@enum object Overflow extends Enumerated[Overflow] {
    case object Visible extends Overflow
    case object Hidden extends Overflow
    case object Scroll extends Overflow
    case object Auto extends Overflow
    case object Initial extends Overflow
    case object Inherit extends Overflow
}
