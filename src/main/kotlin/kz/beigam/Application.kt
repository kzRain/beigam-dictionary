package kz.beigam

import io.ktor.server.application.*
import kz.beigam.plugins.*
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {
    val mongoUser = environment.config.property("mongo.username").getString()//System.getenv("MONGO_PASSWORD")
    val mongoPassword = environment.config.property("mongo.password").getString()//System.getenv("MONGO_PASSWORD")
    val dbName = environment.config.property("mongo.database").getString()
    val host = environment.config.property("mongo.host").getString()

    val db = KMongo.createClient(
        connectionString = "mongodb://$mongoUser:$mongoPassword@$host/$dbName?retryWrites=true&w=majority"
    )
        .coroutine
        .getDatabase(dbName)

    configureHTTP()
    configureSerialization()
    configureRouting()
}
