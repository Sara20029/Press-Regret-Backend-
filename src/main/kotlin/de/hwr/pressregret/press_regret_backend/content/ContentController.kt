package de.hwr.pressregret.press_regret_backend.content


import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/content")
class ContentController {

    @GetMapping("/how-to-play")
    fun howToPlay(): ContentResponse =
        ContentResponse(
            slug = "how-to-play",
            title = "How to play",
            sections = listOf(
                SectionDto(
                    heading = "Ziel",
                    body = "Erfülle die Befehle, indem du den Button im richtigen Moment drückst."
                ),
                SectionDto(
                    heading = "Regeln",
                    body = "Falsches Drücken verursacht Regret (Punkteverlust). Richtiges Timing bringt Punkte."
                )
            )
        )

    @GetMapping("/about")
    fun about(): ContentResponse =
        ContentResponse(
            slug = "about",
            title = "About / Inspo",
            sections = listOf(
                SectionDto(
                    heading = "Inspiration",
                    body = "Die Idee ist von Button-Reaction-Games wie Press-under-Pressure inspiriert."
                ),
                SectionDto(
                    heading = "Projekt",
                    body = "SPA mit React (Frontend) und Spring Boot (REST Backend)."
                )
            )
        )
}