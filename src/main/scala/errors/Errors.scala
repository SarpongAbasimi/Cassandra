package errors

sealed trait Errors extends Throwable with Product with Serializable
case class UserNotFoundError(message: String) extends  Errors
