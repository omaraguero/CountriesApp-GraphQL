package com.roa.countryapp.domain

import com.apollographql.apollo3.ApolloClient
import com.roa.CountriesQuery
import com.roa.CountryQuery
import com.roa.countryapp.data.toDetailedCountry
import com.roa.countryapp.data.toSimpleCountry

class ApolloCountryClient(
    private val apolloClient: ApolloClient
) : CountryClient {

    override suspend fun getCountries(): List<SimpleCountry> {
        return apolloClient.query(CountriesQuery())
            .execute().data?.countries?.map { it.toSimpleCountry() } ?: emptyList()
    }

    override suspend fun getCountry(code: String): DetailedCountry? {
        return apolloClient.query(CountryQuery(code)).execute().data?.country?.toDetailedCountry()
    }

}