package com.roa.countryapp.data

import com.roa.CountriesQuery
import com.roa.CountryQuery
import com.roa.countryapp.domain.DetailedCountry
import com.roa.countryapp.domain.SimpleCountry

fun CountryQuery.Country.toDetailedCountry():DetailedCountry {
    return DetailedCountry(
        code = code,
        name = name,
        emoji = emoji,
        capital = capital ?: "No capital",
        currency = currency ?: "No currency",
        languages = languages.mapNotNull { it.name },
        continent = continent.name
    )
}

fun CountriesQuery.Country.toSimpleCountry():SimpleCountry {
    return SimpleCountry(
        code = code,
        name = name,
        emoji = emoji,
        capital = capital ?: "No capital",
    )
}