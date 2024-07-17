package com.roa.countryapp.domain

import com.roa.CountryQuery

interface CountryClient {
    suspend fun getCountries(): List<SimpleCountry>
    suspend fun getCountry(code: String): DetailedCountry?
}