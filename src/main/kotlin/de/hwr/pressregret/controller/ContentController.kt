package de.hwr.pressregret.controller

import de.hwr.pressregret.api.response.contentResponse.AboutResponse
import de.hwr.pressregret.api.response.contentResponse.ContactResponse
import de.hwr.pressregret.api.response.contentResponse.HowToPlayResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/content")
class ContentController {

    @GetMapping("/how-to-play")
    fun howToPlay(): HowToPlayResponse {
         return HowToPlayResponse(
            title = "How to play",
            description = "The game isn't that complicated. The button that you will see on the screen gives you informations." +
                    "You have to follow the informations on it or you will loose the game." +
                    "With every level of the difficulties you pass the level gets harder each time." +
                    "The difficulty levels and their corresponding difficulty levels are interconnected. " +
                    "Information from the Easy or Medium difficulty levels may be useful for later levels. " +
                    "It is advisable to start with the Easy level.",
            instructions = listOf(
                "Press the button in the right moment!",
                "Do not get angry!",
                "read the description on the button!"
            )
        )
    }

    @GetMapping("/about")
    fun about(): AboutResponse {
        return AboutResponse(
            title = "About The Game and Inspiration!",
            description = "We are Sara and Emily! We are students at the HWR in Berlin in the 4th semester." +
                    "This is our game 'Press and Regret'. The game was a little inspiration of an other game." +
                    "'Press and Regret' will test your nerves and your reflexes." +
                    "Enjoy the game! If you have anything that we could do better, let us know in the contact section." +
                    "But now, have fun!",
        )
    }

    @GetMapping("/contact")
    fun contact(): ContactResponse {
        return ContactResponse(
            title = "Contact Us",
            description = "You can contact us via email!",
            email = "sara.emily.doof@mail.com"
        )
    }
}

