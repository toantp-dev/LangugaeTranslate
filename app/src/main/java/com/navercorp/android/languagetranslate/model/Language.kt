package com.navercorp.android.languagetranslate.model

import java.util.Locale

/**
 * Holds the language code (i.e. "en") and the corresponding localized full language name (i.e.
 * "English")
 */
data class Language(val code: String) : Comparable<Language> {

    val displayName: String
        get() = Locale(code).displayName

    override fun equals(other: Any?): Boolean {
        if (other === this) {
            return true
        }

        if (other !is Language) {
            return false
        }

        val otherLang = other as Language?
        return otherLang!!.code == code
    }

    override fun toString(): String {
        return "$code - $displayName"
    }

    override fun compareTo(other: Language): Int {
        return this.displayName.compareTo(other.displayName)
    }

    override fun hashCode(): Int {
        return code.hashCode()
    }
}