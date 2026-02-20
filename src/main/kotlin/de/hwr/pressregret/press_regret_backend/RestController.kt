/*package de.hwr.pressregret.press_regret_backend

import de.hwr.pressregret.press_regret_backend.content.ContentDto
import de.hwr.pressregret.press_regret_backend.content.SectionDto
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/content")
class ContentController {

    @GetMapping("/how-to-play")
    fun howToPlay(): ContentDto =
        ContentDto(
            slug = "how-to-play",
            title = "How to play",
            sections = listOf(
                SectionDto("Ziel", "Drücke den Button nur, wenn es der Befehl verlangt."),
                SectionDto("Regeln", "Falsches Drücken = Punkteverlust. Richtiges Timing = Punkte.")
            )
        )

    @GetMapping("/about")
    fun about(): ContentDto =
        ContentDto(
            slug = "about",
            title = "About / Inspo",
            sections = listOf(
                SectionDto("Inspiration", "Inspiriert von Press-under-Pressure-Mechaniken."),
                SectionDto("Projekt", "Webprogrammierung (SPA) mit React + Spring Boot.")
            )
        )
}*/