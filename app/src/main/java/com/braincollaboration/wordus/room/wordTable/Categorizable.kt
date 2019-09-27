package com.braincollaboration.wordus.room.wordTable

/**
 * An interface for objects that belong to a named category.
 */
interface Categorizable {

    /**
     * Gets the name of the category that this item belongs to.
     *
     * @return the name `String`
     */
    val category: String

    /**
     * Gets the name of the word that this item belongs to.
     * Need to sort words in alphabetic at recyclerView
     * @return the name `String`
     */
    val name: String

}
