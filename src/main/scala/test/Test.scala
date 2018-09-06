package test

import com.outr.googleapi.GoogleAPI

import scala.scalajs.js.annotation.JSExportTopLevel
import scala.concurrent.ExecutionContext.Implicits.global
import org.scalajs.dom._
import profig.Profig

object Test {
  @JSExportTopLevel("application")
  def main(): Unit = {
    Profig.loadDefaults()

    println("Hello, World!")
    val api = new GoogleAPI(Profig("clientId").as[String])

    def addSignOut(): Unit = {
      addButton("Sign Out") {
        api.signOut().foreach { _ =>
          println("Signed out successfully!")
        }
      }
    }

    api.user().foreach {
      case Some(user) => {
        println(s"Already Signed in: ${user.getBasicProfile().getName()} / ${user.getBasicProfile().getEmail()} / ${user.getBasicProfile().getImageUrl()}")
        addSignOut()
      }
      case None => addButton("Sign In") {
        api.signIn().foreach { user =>
          println(s"Signed in: ${user.getBasicProfile().getName()} / ${user.getBasicProfile().getEmail()} / ${user.getBasicProfile().getImageUrl()}")
          addSignOut()
        }
      }
    }
  }

  def addButton(label: String)(action: => Unit): Unit = {
    val button = document.createElement("button")
    button.innerHTML = label
    button.addEventListener("click", (event: Event) => {
      event.stopPropagation()
      event.preventDefault()

      action
    })
    document.body.appendChild(button)
  }
}