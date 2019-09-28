package com.braincollaboration.wordus.feature.home.view

data class WordPresentation (val wordName : String = "", val wordMeaning : String = "")

fun String.toWordPresentation () = WordPresentation("", "") /*TODO convert from server entity to app entity*/