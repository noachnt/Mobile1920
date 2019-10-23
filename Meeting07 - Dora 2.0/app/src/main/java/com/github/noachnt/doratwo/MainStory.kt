package com.github.noachnt.doratwo

import android.app.Application

class MainStory: Application() {

    data class Scene(
        val title: String,
        val body: String,
        val actions: List<String>
    )

    companion object {
        // Constants
        val MAIN_MENU = "Main Menu"
        val TRY_AGAIN = "Try Again"
        val CONTINUE = "Continue"

        // Scenes
        val scenes: List<Scene> = listOf (
            // 0 (INTRO)
            Scene (
                "Intro",
                "In this game you became Dora!",
                actions = listOf (
                    "Proceed",
                    "Proceed",
                    "Proceed",
                    "Proceed"
                )
            ),

            // 1 (BOOTS CRAVINGS)
            Scene (
                "BOOTS CRAVINGS",
                "Boots wants a banana",
                actions = listOf (
                    "Give boots a banana",
                    "Hit Boots",
                    "Ignore Boots",
                    "Leave.."
                )
            ),

            // 2 (BOOTS LIKES YOU)
            Scene (
                "BOOTS LIKES YOU",
                "Boots now follow you wherever you go! What you want to do with Boots today?",
                actions = listOf (
                    "Adventure",
                    "Leave",
                    "",
                    ""
                )
            ),

            // 3 (HIT BOOTS)
            Scene (
                "WHY YOU HIT BOOTS?",
                "YOU MEAN HUMAN BEING!",
                actions = listOf (
                    "Im sorry!",
                    "LEFT",
                    "",
                    ""
                )
            ),

            // 4 (BOOTS IGNORED)
            Scene (
                "Boots gets ignored",
                "Boots decide to leave..",
                actions = listOf (
                    "Chase boots!",
                    "WHO CARES!",
                    "",
                    ""
                )
            ),

            // 5
            Scene (
                "BOOTS FORGIVE YOU",
                "You say sorry to Boots and he forgive you :D",
                actions = listOf (
                    "Give Boots the banana",
                    "Hit Boots again!",
                    "",
                    ""
                )
            ),

            // 6 (DORA ENTER AMAZON)
            Scene (
                "Dora and boots enter the Amazon",
                "Dora and Boots hear something rattling in the trees. It was SWIPER! He was in the three listening. He had an evil smile on his face."+
                        "Swiper is about to steal Dora's MAP",
                actions = listOf (
                    "Says: SWIPER NO SWIPING",
                    "SMACK SWIPER REAL HARD!",
                    "RUN",
                    ""
                )
            ),

            // 7 (BAD ENDING 1)
            Scene (
                "Bad Ending: You left",
                "You left boots alone",
                actions = listOf (
                    MAIN_MENU,
                    TRY_AGAIN,
                    "",
                    ""
                )
            ),
            // 8 (SWIPER LEFT)

            Scene (
                "AWWW MANNN",
                "SWIPER LEFT",
                actions = listOf(
                    "Continue the Adventure",
                    "Im tired",
                    "",
                    ""
                )
            ),
            // 9 (NORMAL ENDING)
            Scene (
                "YAY WE DID IT",
                "DORA FINISH THE ADVENTURE WITH BOOTS",
                actions = listOf(
                    CONTINUE,
                    "",
                    "",
                    ""
                )
            ),
            // 10 (BAD ENDING 2)
            Scene (
                "WHAT!?",
                "YOU DONT DESERVE TO PLAY THIS GAME!",
                actions = listOf(
                    MAIN_MENU,
                    TRY_AGAIN,
                    "",
                    ""
                )
            ),

            // 11 (BEST ENDING)
            Scene (
                "BEST ENDING",
                "DORA AND BOOTS SMACK SWIPER REAL HARD! (SWIPER DIED)"+"\n" +
                        "NO ONE HAS EVER BOTHERED DORA AND BOOTS SINCE THEN :D THE END",
                actions = listOf(
                    CONTINUE,
                    "",
                    "",
                    ""
                )
            )



        )

        // ending flags
        var badEnding1 = false
        var badEnding2 = false
        var normalEnding1 = false
        var bestEnding = false

        // utility
        lateinit var currentDisplayedEnding: Scene
    }


}