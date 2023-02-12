package kz.beigam.data

import org.litote.kmongo.coroutine.CoroutineDatabase

interface CountriesDataSource {

}

class MongoCountriesDataSource(
    db: CoroutineDatabase
):CountriesDataSource {
}