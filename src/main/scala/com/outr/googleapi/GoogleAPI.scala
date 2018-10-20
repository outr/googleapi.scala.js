package com.outr.googleapi

import scala.concurrent.{Future, Promise}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}

class GoogleAPI(clientId: String, load: List[String] = List("client", "auth2")) {
  lazy val init: Future[Unit] = {
    val promise = Promise[Unit]
    gapi.load(load.mkString(":"), () => {
      val options = new Auth2Options {}
      options.clientId = clientId
      val future = gapi.auth2.init(options).toFuture
      future.onComplete {
        case Success(_) => promise.success(())
        case Failure(exception) => promise.failure(exception)
      }
    })
    promise.future
  }

  def user(): Future[Option[GoogleUser]] = init.map { _ =>
    val auth = gapi.auth2.getAuthInstance()
    if (auth.isSignedIn.get()) {
      Some(auth.currentUser.get())
    } else {
      None
    }
  }

  def signIn(): Future[GoogleUser] = init.flatMap { _ =>
    gapi.auth2.getAuthInstance().signIn().toFuture
  }

  def signOut(): Future[Unit] = init.flatMap { _ =>
    gapi.auth2.getAuthInstance().signOut().toFuture
  }
}